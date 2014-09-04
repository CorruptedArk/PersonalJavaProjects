/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectilesolver;


/**
 *
 * @author Noah
 */
public class ConstantAcceleration {
    public double vi;
    public double vf;
    public double Δx;
    public double a;
    public double t;
    
    public void noVfNoΔx(double vi, double a, double t){
        this.vi = vi;
        this.a = a;
        this.t = t;
        this.vf = vi + (a * t);
        this.Δx = (vi*t) + (.5*a*Math.pow(t, 2));
    }
    
    public void noViNoΔx(double vf, double a, double t){
        this.vf = vf;
        this.a = a;
        this.t = t;
        this.vi = vf - (a*t);
        this.Δx = (vf*t) - (.5*a*Math.pow(t, 2));
    }
    
    public void noANoΔx(double vi, double vf, double t){
        this.vi = vi;
        this.vf = vf;
        this.t = t;
        this.Δx = .5 * (vf + vi) * t;
        this.a = (vf - vi) / t;
    }
    
    public void noTNoΔx(double vi, double vf, double a){
        this.vi = vi;
        this.vf = vf;
        this.a = a;
        this.t = (vf - vi) / a;
        this.Δx = (Math.pow(vf, 2) - Math.pow(vi, 2)) / (2*a);
    }
    
    public void noViNoA(double vf, double Δx, double t){
        this.vf = vf;
        this.Δx = Δx;
        this.t = t;
        this.vi = ((2*Δx)/t) - vf;
        this.a = (2*((vf*t) - Δx)) / Math.pow(t, 2);
    }
    
    public void noVfNoA(double vi, double Δx, double t) {
        this.vi = vi;
        this.Δx = Δx;
        this.t = t;
        this.vf = ((2*Δx)/t) - vi;
        this.a = (2*(Δx - (vi*t))) / Math.pow(t, 2);
    }
    
    public void noTNoA(double vi, double vf, double Δx){
        this.vi = vi;
        this.vf = vf;
        this.Δx = Δx;
        this.a = (Math.pow(vf,2) - Math.pow(vi,2)) / (2*Δx);
        this.t = (2*Δx) / (vf + vi);
    }
    
    public void noViNoT(double vf, double Δx, double a){
        this.vf = vf;
        this.Δx = Δx;
        this.a = a;
        this.vi = Math.sqrt(Math.pow(vf,2) - (2*a*Δx));
        this.t = (2*Δx) / (vf + vi); 
    }
    
    public void noVfNoT(double vi, double Δx, double a){ 
        this.vi = vi;
        this.Δx = Δx;
        this.a = a;
        this.vf = Math.sqrt(Math.pow(vi, 2) + (2*a*Δx));
        this.t = (2*Δx) / (vf + vi);
    }
    
    public void noViNoVf(double Δx, double a, double t){
        this.Δx = Δx;
        this.a = a;
        this.t = t;
        this.vi = (Δx - (.5 * a * Math.pow(t,2))) / t;
        this.vf = (Δx + (.5 * a * Math.pow(t,2))) / t;
    }
    
}
