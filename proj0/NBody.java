import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class NBody {

    public double T;
    public double dt;
    public String filename;
    public double radius;
    public Body[] universe;
    public static Body Spaceship = new Body(1.4960e+6,5.7900e+10,0,0,500,"Rocket.png", 0, 100);

    public static void main(String[] args) {


        double T = Double.parseDouble((args[0]));
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(args[2]);
        Body[] universe = readBodies(args[2]);
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg", 2*radius, 2*radius);
        for (Body b : universe) {
            b.draw();
        }
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while (time<T){
            double ShipX = Spaceship.calcNetForceExertedByX(universe);
            double ShipY = Spaceship.calcNetForceExertedByY(universe);
            double[] xForces = new double[universe.length];
            double[] yForces = new double[universe.length];
            for (int i = 0; i < universe.length; i++){
                xForces[i] = universe[i].calcNetForceExertedByX(universe);
                yForces[i] = universe[i].calcNetForceExertedByY(universe);
            }
            for (int i = 0; i < universe.length; i++){
                universe[i].update(dt, xForces[i], yForces[i]);
            }


            Spaceship.mousePosToAngle(radius);
            if (StdDraw.isMousePressed()){
                ShipX = Spaceship.propulsionForce()[0];
                ShipY = Spaceship.propulsionForce()[1];
                System.out.println("Num: " + (StdDraw.mouseX()) + " " + (StdDraw.mouseY()) + " "
                 + (Spaceship.xxPos) + " " + (Spaceship.yyPos) + " " + Spaceship.direction
                 + " " + Spaceship.forceBooster + " Shipx: " + ShipX + " ShipY: " + ShipY);
            }
            Spaceship.update(dt, ShipX, ShipY);


            StdDraw.picture(0, 0, "images/starfield.jpg", 2*radius, 2*radius);
            for (Body b : universe) {
                b.draw();
            }
            Spaceship.draw();
            StdDraw.show();
            StdDraw.pause(10);
            time += 10;
        }
    }

    public static double readRadius(String filename) {
        In in = new In(filename);
        int numbor = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String filename){
        In in = new In(filename);
        int firstnum = in.readInt();
        double radius = in.readDouble();
        Body[] listplanets = new Body[firstnum];
        for (int i = 0; i<firstnum; i++){
            listplanets[i] = new Body(in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readDouble(), in.readString());

        }
        return listplanets;
    }
}
