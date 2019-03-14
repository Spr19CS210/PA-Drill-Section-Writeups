package edu.spr19cs210.section07;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class Section07TestClass {
	
	@Test
	public void TestPersonEquals() {
		
		Person one = new Person(1, "Tyler", "Conklin");
		Person two = new Person(2, "Clark", "Penado");
		Person three = new Person(2, "Pete", "Mahon");
		Person four = new Person(1, "Tyler", "Conklin");
		MyGeneric<Person> outlier = new MyGeneric<>(new Person(1, "Tyler", "Conklin"));
		
		assertFalse(one.equals(two));
		assertFalse(one.equals(three));
		assertFalse(two.equals(three));
		assertTrue(one.equals(four));
		assertFalse(one.equals(outlier));
		
	}
	
	@Test
	public void TestPersonHashCode() {
		
		Person one = new Person(1, "Tyler", "Conklin");
		Person two = new Person(2, "Clark", "Penado");
		Person three = new Person(2, "Pete", "Mahon");
		
		assertFalse(one.hashCode() == two.hashCode());
		assertTrue(two.hashCode() == three.hashCode());
		
	}
	
	@Test
	public void TestPersonToString() {
		
		Person one = new Person(1, "Tyler", "Conklin");
		
		assertTrue(one.toString().equals("Tyler Conklin (id=1)"));
		
	}
	
	@Test
	public void TestPersonHashSet() {
		
		HashSet<Person> tester = new HashSet<>();
		
		Person one = new Person(1, "Tyler", "Conklin");
		Person two = new Person(2, "Clark", "Penado");
		Person three = new Person(2, "Pete", "Mahon");
		Person four = new Person(1, "Tyler", "Conklin");
		
		tester.add(one);
		tester.add(two);
		
		assertTrue(tester.size() == 2);
		
		tester.add(three);
		tester.add(four);
		
		assertTrue(tester.size() == 3);
		
	}
	
	@Test
	public void TestMyGenericIntEquals() {
		
		MyGeneric<Integer> one = new MyGeneric<>(1);
		MyGeneric<Integer> two = new MyGeneric<>(2);
		
		assertFalse(one.equals(two));
		
	}
	
	@Test
	public void TestMyGenericIntHash() {
		
		MyGeneric<Integer> one = new MyGeneric<>(1);
		MyGeneric<Integer> two = new MyGeneric<>(2);
		
		assertFalse(one.hashCode() == two.hashCode());
		
	}
	
	@Test
	public void TestMyGenericStringEquals() {
		
		MyGeneric<String> one = new MyGeneric<>("String");
		MyGeneric<String> two = new MyGeneric<>("Integer");
		MyGeneric<String> three = new MyGeneric<>("Boolean");
			
		assertFalse(one.equals(two)); 
		assertFalse(one.equals(three));
		assertFalse(two.equals(three));
		
	}
	
	@Test
	public void TestMyGenericStringHash() {
		
		MyGeneric<String> one = new MyGeneric<>("String");
		MyGeneric<String> two = new MyGeneric<>("Integer");
		MyGeneric<String> three = new MyGeneric<>("Boolean");
		
		assertFalse(one.hashCode() == two.hashCode());
		assertFalse(one.hashCode() == three.hashCode());
		assertFalse(two.hashCode() == three.hashCode());
		
	}
	
	@Test
	public void TestMyGenericMultipleEquals() {
		
		MyGeneric<Integer> one = new MyGeneric<>(1);
		MyGeneric<String> str = new MyGeneric<>("String");
		
		assertFalse(one.equals(str));
		
	}
	
	@Test
	public void TestMyGenericMultipleHash() {
		
		MyGeneric<Integer> one = new MyGeneric<>(1);
		MyGeneric<String> str = new MyGeneric<>("String");
		
		assertFalse(one.hashCode() == str.hashCode());
		
	}
	
}
