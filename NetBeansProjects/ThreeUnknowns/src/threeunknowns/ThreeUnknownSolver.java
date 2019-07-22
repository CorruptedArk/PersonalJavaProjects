/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threeunknowns;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Noah
 */


public class ThreeUnknownSolver {
    
    double[][] arrayA;
    double[][] arrayB;
    double x;
    double y;
    double z;
    
    
    public ThreeUnknownSolver(double a1, double b1, double c1, double d1,
                              double a2, double b2, double c2, double d2,
                              double a3, double b3, double c3, double d3){
        
        this.arrayA = new double[][]{{a1,b1,c1},{a2,b2,c2},{a3,b3,c3}};
        this.arrayB = new double[][]{{d1},{d2},{d3}};
    }
    
    public void solve() throws RuntimeException{
        
        Matrix matrixA = new Matrix(arrayA);
        Matrix matrixB = new Matrix(arrayB);
        
         Matrix solvedMatrix = matrixA.solve(matrixB);
        
        double[][] solutions = solvedMatrix.returnArray();
        
        
        
        x = new BigDecimal(solutions[0][0]).setScale(6, RoundingMode.HALF_DOWN).doubleValue();
        y = new BigDecimal(solutions[1][0]).setScale(6, RoundingMode.HALF_DOWN).doubleValue();
        z = new BigDecimal(solutions[2][0]).setScale(6, RoundingMode.HALF_DOWN).doubleValue();
    }
    
    
    
}
