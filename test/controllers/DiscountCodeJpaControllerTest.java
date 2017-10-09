/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entita.Customer;
import entita.DiscountCode;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mauro
 */
public class DiscountCodeJpaControllerTest {

    private static String NAME_PU = "JPA-hibernatePU";
    private static EntityManagerFactory EMF = null;
    private DiscountCodeJpaController instance = null;

    public DiscountCodeJpaControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        EMF = Persistence.createEntityManagerFactory(NAME_PU);
        System.out.println("instanziato EMF= " + EMF);
    }

    @AfterClass
    public static void tearDownClass() {
        EMF.close();
    }

    @Before
    public void setUp() {
        instance = new DiscountCodeJpaController(EMF);
        System.out.println("instanziato DiscountCodeJpaController= " + instance);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEntityManager method, of class DiscountCodeJpaController.
     */
    @Test
    public void testGetEntityManager() {
        System.out.println("getEntityManager");

        EntityManager result = instance.getEntityManager();
        System.out.println("em= " + result);
        assertNotNull(result);
        if (result.isOpen()) {
            System.out.println("*****Il em è ancora aperto****");
            result.close();
            System.out.println("*****ora il em è chiuso*****");
            assertTrue(!result.isOpen());

            result = null;
        }

    }

    /**
     * Test of create method, of class DiscountCodeJpaController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");

        // instance.create(discountCode);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of edit method, of class DiscountCodeJpaController.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");

        //   instance.edit(discountCode);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of destroy method, of class DiscountCodeJpaController.
     */
    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        String id = "";

        // instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findDiscountCodeEntities method, of class
     * DiscountCodeJpaController.
     */
    @Test
    public void testFindDiscountCodeEntities_0args() {
        System.out.println("findDiscountCodeEntities");

        int expResult = 4;
        List<DiscountCode> result = instance.findDiscountCodeEntities();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of findDiscountCodeEntities method, of class
     * DiscountCodeJpaController.
     */
    @Test
    public void testFindDiscountCodeEntities_int_int() {
        System.out.println("findDiscountCodeEntities");
        int maxResults = 100;
        int firstResult = 0;
        int expResult = 4;
        List<DiscountCode> result = instance.findDiscountCodeEntities(maxResults, firstResult);
        assertEquals(expResult, result.size());
    }

    /**
     * Test of findDiscountCode method, of class DiscountCodeJpaController.
     */
    @Test
    public void testFindDiscountCode() {
        System.out.println("findDiscountCode");
        String id = "L";

        String expResult = id;

        DiscountCode result = instance.findDiscountCode(id);
        assertEquals(expResult, result.getDiscountCode());
        double sconto = result.getRate().doubleValue();
        assertTrue(7.00 == sconto);

        System.out.println("\n\n-------------Prova partendo da discontcode detached:----------");

        List<Customer> customerListfromdatached = result.getCustomerList();
        String nameclass = customerListfromdatached.getClass().getCanonicalName();

        System.out.println("\n------la lista è di classe: " + nameclass);

        System.out.println("\n---customerlist= " + customerListfromdatached.size() + " elementi");
        assertNotNull("la lista di customer è nulla : probabile erore di LazyException", customerListfromdatached);

    }

    /**
     * Test of getDiscountCodeCount method, of class DiscountCodeJpaController.
     */
    @Test
    public void testGetDiscountCodeCount() {
        System.out.println("getDiscountCodeCount");

        int expResult = 4;
        int result = instance.getDiscountCodeCount();
        assertTrue(expResult == result);

    }
}
