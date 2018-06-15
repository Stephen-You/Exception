package cn.exception180610.construction;

public class CleanupIdiom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NeedsCleanup nc1 = new NeedsCleanup();
		try {
			System.out.println("nc1 try!");
		} finally {
			nc1.dispose();
		}
		
		NeedsCleanup nc2 = new NeedsCleanup();
		NeedsCleanup nc3 = new NeedsCleanup();
		try {
			System.out.println("nc2 nc3 try!");
		} finally {
			nc3.dispose();
			nc2.dispose();
		}
		
		try {
			NeedsCleanup2 nc4 = new NeedsCleanup2();
			try {
				System.out.println("nc4 try!");
				NeedsCleanup2 nc5 = new NeedsCleanup2();
				try {
					System.out.println("nc5 try!");
				} finally {
					// TODO: handle finally clause
					nc5.dispose();
				}
			}catch (Exception e) {
				System.out.println(e);
			} finally {
				nc4.dispose();
			}
		}catch (ConstructionException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
