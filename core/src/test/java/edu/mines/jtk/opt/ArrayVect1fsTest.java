/****************************************************************************
Copyright 2003, Landmark Graphics and others.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
****************************************************************************/
package edu.mines.jtk.opt;

import java.util.Random;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import edu.mines.jtk.util.Almost;

/** Unit tests for edu.mines.jtk.opt.ArrayVect1fs. */
public class ArrayVect1fsTest extends TestCase {

  /** Run test code. */
  public void testAll () {
    Random random = new Random(32525);
    {
      ArrayVect1f[] data = new ArrayVect1f[5];
      for (int j=0; j<data.length; ++j) {
        float[] a = new float[31];
        for (int i=0; i<a.length; ++i) {a[i] = random.nextFloat();}
        data[j] = new ArrayVect1f(a, j+3, ((j+4.)/3.));
      }
      ArrayVect1fs v = new ArrayVect1fs(data);
      VectUtil.test(v);
      v.dispose();
    }

    {
      ArrayVect1f[] data = new ArrayVect1f[5];
      for (int j=0; j<data.length; ++j) {
        float[] a = new float[31];
        for (int i=0; i<a.length; ++i) {a[i] = 1.f;}
        data[j] = new ArrayVect1f(a, 0, 3.);
      }
      ArrayVect1fs v = new ArrayVect1fs(data);
      VectUtil.test(v);
      Vect w = v.clone();
      w.multiplyInverseCovariance();
      assert Almost.FLOAT.equal(1./3., v.dot(w));
      assert Almost.FLOAT.equal(1./3., v.magnitude());
    }
  }

  // OPTIONAL OPTIONAL OPTIONAL OPTIONAL OPTIONAL OPTIONAL OPTIONAL

  /* Initialize objects used by all test methods */
  @Override protected void setUp() throws Exception { super.setUp();}

  /* Destruction of stuff used by all tests: rarely necessary */
  @Override protected void tearDown() throws Exception { super.tearDown();}

  // NO NEED TO CHANGE THE FOLLOWING

  /** Standard constructor calls TestCase(name) constructor 
      @param name Name of junit Test.
   */
  public ArrayVect1fsTest(String name) {super (name);}

  /** This automatically generates a suite of all "test" methods.
      @return A suite of all junit tests as a Test.
   */
  public static junit.framework.Test suite() {
    try {assert false; throw new IllegalStateException("need -ea");}
    catch (AssertionError e) {}
    return new TestSuite(ArrayVect1fsTest.class);
  }

  /** Run all tests with text gui if this class main is invoked 
      @param args Command-line arguments.
   */
  public static void main (String[] args) {
    junit.textui.TestRunner.run (suite());
  }
}
