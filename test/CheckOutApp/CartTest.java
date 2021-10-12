package CheckOutApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void testThatProductsExist(){
        Product items = new Product();
        assertNotNull(items);
    }

    @Test
    void testThatACartExist(){
        Cart shoppingCart = new Cart();
        assertNotNull(shoppingCart);
    }

    @Test
    void testThatProductHasAName(){
        Product items = new Product();
        items.setNameOfItem("MANGO");
        assertEquals("MANGO", items.getNameOfItem());
    }

    @Test
    void testThatProductHasQuantityAndAmount(){

        Product items = new Product();
        Product items1 = new Product();
        items.setAmountOfItem(BigDecimal.valueOf( 200));
        items.setNumberOfItems(2);
        assertEquals(BigDecimal.valueOf(400), items.getAmountOfOneOrMoreItems());
    }
    @Test
    void testThatItemCanBeAddedToAShoppingCart(){
        Product items = new Product();
        Cart shoppingCart = new Cart();
        shoppingCart.addItems("Mango", BigDecimal.valueOf(1000), 2);
        shoppingCart.addItems("orange", BigDecimal.valueOf(2000), 3);

        assertEquals(2, shoppingCart.getTotalProducts());

    }
    @Test
    void testThatItemsCanBeChanged(){
        Cart shoppingCart = new Cart();
        Product mango = new Product("Mango",3,  BigDecimal.valueOf(50));
        Product orange = new Product("orange", 2, BigDecimal.valueOf(100));
        Product pampers = new Product("pampers", 2, BigDecimal.valueOf(2000));
        shoppingCart.getItems().add(mango);
        shoppingCart.getItems().add(orange);
        shoppingCart.changeItem(orange, pampers);
        for (Product i : shoppingCart.getItems()) {
            System.out.println(i);
        }
assertEquals(2, shoppingCart.getTotalProducts() );

    }
    @Test
    void testThatItemsCanBeRemovedFromCart(){

        Cart shoppingCart = new Cart();
        Product mango = new Product("Mango",3,  BigDecimal.valueOf(50));
        Product orange = new Product("orange", 2, BigDecimal.valueOf(100));
        Product pampers = new Product("pampers", 2, BigDecimal.valueOf(2000));
        shoppingCart.getItems().add(mango);
        shoppingCart.getItems().add(orange);
        shoppingCart.getItems().add(pampers);

        shoppingCart.removeItems(pampers);
        for(Product i : shoppingCart.getItems() ){
            System.out.println(i);
        }
        assertEquals(2, shoppingCart.getTotalProducts());

    }

}