package datastruct;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.IndexOutOfBoundsException;

class MyUnsortedListTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*@Test
	void testOfEArray() {
		fail("Not yet implemented");
	}

	@Test
	void testOfIterableOfE() {
		fail("Not yet implemented");
	}*/

	@Test
	void testIsEmpty() {
		MyUnsortedList list = MyUnsortedList.of();
		assertTrue(list.isEmpty(), "liste est vide");
	}

	@Test
	void testSizePlein() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		assertEquals(3, list.size(), "taille liste avec des élément");
	}
	
	@Test
	void testSizeVide() {
		MyUnsortedList list = MyUnsortedList.of();
		assertEquals(0, list.size(), "taille liste vide");
	}

	@Test
	void testPrependSize() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.prepend(0);
		assertEquals(4, list.size(), "test taille liste parès prepend");
	}
	
	@Test
	void testPrependElementDebut() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.prepend(0);
		assertEquals(0, list.pop(), "test ajout premier élément list prepend");
	}
	
	@Test
	void testPrependVide() {
		MyUnsortedList list = MyUnsortedList.of();
		list.prepend(0);
		assertEquals(1, list.size(), "test taille preprend list vide");
	}

	@Test
	void testAppendSize() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.append(0);
		assertEquals(4, list.size(), "test taille append");
	}
	
	@Test
	void testAppendElementFin() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.append(0);
		assertEquals(0, list.popLast(), "test append");
	}
	
	@Test
	void testAppendVide() {
		MyUnsortedList list = MyUnsortedList.of();
		list.append(0);
		assertEquals(1, list.size(), "test append liste vide");
	}

	@Test
	void testInsertDebutSize() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.insert(0, 0);
		assertEquals(4, list.size(), "test sur la size insert au début");
	}
	
	@Test
	void testInsertDebut() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.insert(0, 0);
		assertEquals(0, list.pop(), "test insert debut");
	}
	
	@Test
	void testInsertFinSize() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.insert(0, 3);
		assertEquals(4, list.size(), "test sur la size insert à la fin");
	}
	
	@Test
	void testInsertFin() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.insert(0, 3);
		assertEquals(0, list.popLast(), "test insert fin");
	}
	
	@Test
	void testInsertSize() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.insert(0, 2);
		assertEquals(4, list.size(), "test taille insert");
	}
	
	@Test
	void testInsert() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.insert(0, 1);
		assertEquals(0, list.remove(1), "test insert");
	}
	
	@Test
	void testInsertNegatif(){
		java.lang.IndexOutOfBoundsException thrown = assertThrows(java.lang.IndexOutOfBoundsException.class, () -> {
			MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
			list.insert(3, -1);
		});
		assertNotNull(thrown, "test insert négatif");
	}
	
	@Test
	void testInsertTropGrand(){
		java.lang.IndexOutOfBoundsException thrown = assertThrows(java.lang.IndexOutOfBoundsException.class, () -> {
			MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
			list.insert(3, 250);
		});
		assertNotNull(thrown, "test insert trop grand");
	}

	@Test
	void testPop() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		assertEquals(1, list.pop(), "test pop");
	}
	
	@Test
	void testPopVide() {
		EmptyListException thrown = assertThrows(EmptyListException.class, () -> {
			MyUnsortedList list = MyUnsortedList.of();
			list.pop();
		});
		assertNotNull(thrown, "test pop liste vide");
	}

	@Test
	void testPopLast() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		assertEquals(3, list.popLast(), "test popLast");
	}
	
	@Test
	void testPopLastVide() {
		EmptyListException thrown = assertThrows(EmptyListException.class, () -> {
			MyUnsortedList list = MyUnsortedList.of();
			list.popLast();
		});
		assertNotNull(thrown, "test popLast liste vide");
	}

	@Test
	void testRemove() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		assertEquals(2, list.remove(1), "test remove");
	}
	
	@Test
	void testRemoveComparaison() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.remove(1);
		assertEquals(list, MyUnsortedList.of(1,3), "test remove avec comparaison des listes");
	}
	
	@Test
	void testRemoveComparaisonDebut() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.remove(0);
		assertEquals(list, MyUnsortedList.of(2,3), "test remove au début avec comparaison des listes");
	}
	
	@Test
	void testRemoveDebut() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		assertEquals(1, list.remove(0), "test remove au début");
	}
	
	@Test
	void testRemoveFin() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		assertEquals(3, list.remove(2), "test remove à la fin");
	}
	
	@Test
	void testRemoveSize() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		list.remove(0);
		assertEquals(2, list.size(), "test remove sur la taille");
	}
	
	@Test
	void testRemoveVide() {
		java.lang.IndexOutOfBoundsException thrown = assertThrows(java.lang.IndexOutOfBoundsException.class, () -> {
			MyUnsortedList list = MyUnsortedList.of();
			list.remove(0);
		});
		assertNotNull(thrown, "test remove sur une liste vide");
	}
	
	@Test
	void testRemoveNegatif() {
		java.lang.IndexOutOfBoundsException thrown = assertThrows(java.lang.IndexOutOfBoundsException.class, () -> {
			MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
			list.remove(-1);
		});
		assertNotNull(thrown, "test remove d'index négatif");
	}
	
	@Test
	void testRemoveTropGrand() {
		java.lang.IndexOutOfBoundsException thrown = assertThrows(java.lang.IndexOutOfBoundsException.class, () -> {
			MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
			list.remove(250);
		});
		assertNotNull(thrown, "test remove d'index trop grand");
	}

	@Test
	void testEqualsObjectEgal() {
		MyUnsortedList list1 = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList list2 = MyUnsortedList.of(1, 2, 3);
		assertTrue(list1.equals(list2), "test égale entre deux listes");
	}
	
	@Test
	void testEqualsObjectNotEgal1PlusGrand() {
		MyUnsortedList list1 = MyUnsortedList.of(1, 2, 3, 4);
		MyUnsortedList list2 = MyUnsortedList.of(1, 2, 3);
		assertFalse(list1.equals(list2), "test égale avec liste1 plus grande");
	}
	
	@Test
	void testEqualsObjectNotEgalMemeTaille() {
		MyUnsortedList list1 = MyUnsortedList.of(4, 8, 6);
		MyUnsortedList list2 = MyUnsortedList.of(1, 2, 3);
		assertFalse(list1.equals(list2), "test égale avec des listes de même taille mais différente");
	}
	
	@Test
	void testEqualsObjectNotEgal2PlusGrand() {
		MyUnsortedList list1 = MyUnsortedList.of(1, 2, 3);
		MyUnsortedList list2 = MyUnsortedList.of(1, 2, 3, 4);
		assertFalse(list1.equals(list2), "test égale avec liste2 plus grande");
	}
	
	@Test
	void testEqualsObjectEgalPasMemeObject() {
		MyUnsortedList list1 = MyUnsortedList.of(1, 2, 3);
		assertFalse(list1.equals("a"), "test égale avec un object qui n'est pas un MyUnsortedList");
	}

	@Test
	void testToString() {
		MyUnsortedList list = MyUnsortedList.of(1, 2, 3);
		assertEquals("MyUnsortedList { size = 3, [1, 2, 3] }", list.toString(), "test toString");
	}

}
