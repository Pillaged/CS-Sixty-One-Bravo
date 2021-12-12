public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double Grav = 6.67e-11;
    public double ForceExerted;
    public double r;
    public double direction = 0;
    public double forceBooster;

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName, direction);
    }
    public Body(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }
    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public Body(double xP, double yP, double xV, double yV, double m, String img, double direction, double forceBooster){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
        this.direction = direction;
        this.forceBooster = forceBooster;
    }

    public double mousePosToAngle(double scale){
        double mouseX = StdDraw.mouseX();
        double mouseY = StdDraw.mouseY();
        double xDiff = mouseX - this.xxPos;
        double yDiff = mouseY - this.yyPos;
        
        double angle = 0;
        if (xDiff > 0 & yDiff > 0) {
            angle = Math.toDegrees(Math.atan(yDiff/xDiff)) + 270;
        }
        else if (xDiff < 0 & yDiff < 0){
            angle = Math.toDegrees(Math.atan(yDiff/xDiff)) + 90;
        }
        else if (xDiff > 0 & yDiff < 0){
            angle = Math.toDegrees(Math.atan(yDiff/xDiff)) + 270;
        }
        else if (xDiff < 0 & yDiff > 0){
            angle = Math.toDegrees(Math.atan(yDiff/xDiff)) + 90;
        }
        direction = angle;
        return angle;
    }

    public double[] propulsionForce(){
        double boostX = forceBooster * Math.pow(Math.cos(direction), 2);
        double boostY = forceBooster * Math.pow(Math.sin(direction), 2);
        double[] netBoost = new double[2];
        
        if (this.direction >= 0 & this.direction < 90){
            netBoost[0] = -boostX;
            netBoost[1] = boostY;
        }
 
        else if (this.direction < 270 & this.direction >=180){
            netBoost[0] = boostX;
            netBoost[1] = -boostY;
        }

        else if (this.direction < 180 & this.direction >=90){
            netBoost[0] = -boostX;
            netBoost[1] = -boostY;
        }

           else if (this.direction >= 270 & this.direction < 360) {
        netBoost[0] =  boostX;
        netBoost[1] =  boostY;
           }

        return netBoost;
    }

    public double calcDistance(Body b){
        double rsquared =  Math.pow((this.xxPos - b.xxPos), 2) + Math.pow((this.yyPos - b.yyPos), 2);
        double r2 = Math.sqrt(rsquared);
        this.r = r2;
        return r2;
    }
    public double calcForceExertedBy(Body b){
        double Fuerza = Body.Grav*(this.mass * b.mass)/(Math.pow(calcDistance(b), 2));
        this.ForceExerted = Fuerza;
        return Fuerza;
    }
    public double calcForceExertedByX(Body b){
        double ForzaX = (this.calcForceExertedBy(b) * (b.xxPos - this.xxPos))/this.calcDistance(b);
        return ForzaX;
    }
    public double calcForceExertedByY(Body b){
        double ForzaY = (this.calcForceExertedBy(b) * (b.yyPos - this.yyPos))/this.calcDistance(b);
        return ForzaY;
    }
    public double calcNetForceExertedByX(Body[] planets){
        double sum = 0;
        for (Body planet:planets){
            if (!this.equals(planet)){
                sum += this.calcForceExertedByX(planet);
            }
        }
        return sum;
    }
    public double calcNetForceExertedByY(Body[] planets){
        double sum = 0.0;
        for (int i = 0; i < planets.length; i++){
            Body planet = planets[i];
            if  (!this.equals(planet)){
                sum += this.calcForceExertedByY(planet);
            }
        }
        return sum;
    }
    public void update(double dt, double fx, double fy){
        double accelxx = fx/this.mass;
        double accelyy = fy/this.mass;
        this.xxVel += accelxx*dt;
        this.yyVel += accelyy*dt;
        this.xxPos += this.xxVel*dt;
        this.yyPos += this.yyVel*dt;
    }
} 