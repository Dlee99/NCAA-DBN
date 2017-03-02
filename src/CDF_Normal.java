/**
 * Created by dl447 on 3/2/17.
 */
public class CDF_Normal {
    /*

Here is a copy of the documentation in the FORTRAN code:

	SUBROUTINE NORMP(Z, P, Q, PDF)
C
C	Normal distribution probabilities accurate to 1.e-15.
C	Z = no. of standard deviations from the mean.
C	P, Q = probabilities to the left & right of Z.   P + Q = 1.
C       PDF = the probability density.
C
C       Based upon algorithm 5666 for the error function, from:
C       Hart, J.F. et al, 'Computer Approximations', Wiley 1968
C
C       Programmer: Alan Miller
C
C	Latest revision - 30 March 1986
C

*/

    public static double normp(double z) {
	    //returns the probability of a z to the right of what is inputted
        double zabs; //Absolute value of Z.  
        double p; //Probability that gets returned
        double expntl,pdf; // -.25 * (Z)^4, density function for getting the area under the curve
        final double p0 = 220.2068679123761;
        final double p1 = 221.2135961699311;
        final double p2 = 112.0792914978709;
        final double p3 = 33.91286607838300;
        final double p4 = 6.373962203531650;
        final double p5 = .7003830644436881;
        final double p6 = .3526249659989109E-01;
	    //probability coefficients, for the right
        final double q0 = 440.4137358247522;
        final double q1 = 793.8265125199484;
        final double q2 = 637.3336333788311;
        final double q3 = 296.5642487796737;
        final double q4 = 86.78073220294608;
        final double q5 = 16.06417757920695;
        final double q6 = 1.755667163182642;
        final double q7 = .8838834764831844E-1;
	    //more probability coefficients, for the left
        final double cutoff = 7.071;
	    //z score at which a different function must be used
        final double root2pi = 2.506628274631001;
	    //the square root of pi, duh
        zabs = Math.abs(z);

//  |z| > 37
	    //Z scores too big or small just round
        if (z > 37.0) {

            p = 1.0;

            return p;

        }

        if (z < -37.0) {

            p = 0.0;

            return p;

        }

//  |z| <= 37.

        expntl = Math.exp(-.5*zabs*zabs);

        pdf = expntl/root2pi;
	    //density function, used for finding the area under the curve
	    
//  |z| < cutoff = 10/sqrt(2).

        if (zabs < cutoff) {

            p = expntl*((((((p6*zabs + p5)*zabs + p4)*zabs + p3)*zabs +
                    p2)*zabs + p1)*zabs + p0)/(((((((q7*zabs + q6)*zabs +
                    q5)*zabs + q4)*zabs + q3)*zabs + q2)*zabs + q1)*zabs +
                    q0);

        } else {

            p = pdf/(zabs + 1.0/(zabs + 2.0/(zabs + 3.0/(zabs + 4.0/
                    (zabs + 0.65)))));

        }

        if (z < 0.0) {

            return p;

        } else {

            p = 1.0 - p;

            return p;

        }

    }

}

