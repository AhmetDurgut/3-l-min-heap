package uclu_min_heap;

import java.util.Scanner;
import uclu_min_heap.Uclu_min_heap.BinarySearchTree.Node;

public class Uclu_min_heap {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sayıları virgül ile giriniz: ");

        String nums = input.nextLine();
        String[] virgul = nums.split(",");
        int[] dizi = new int[virgul.length];

        for (int i = 0; i < virgul.length; i++) {
            dizi[i] = Integer.parseInt(virgul[i]);
        }

        System.out.println("Girilen sayıların dizisi: ");

        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
     /*   
            Heap heap=new Heap();
        for(int i=0;i<dizi.length;i++) {
        	heap.insert(dizi[i]);     // hocam bu kısımda heap.insert hata veriyor vermemesi lazım ama veriyor    
        }                                       bu yüzden bu kısmı yorum satırı olarak aldım 
       
       */ 
        
    }
   
    
    public static void isMinHeap(int[] dizi) {
        

        boolean isminheap = true;
        boolean ucludurumlari;

        if (dizi.length != 0) {
            for (int i = 0; i < (dizi.length - 3) / 3; i++) {
                //sol çocuk
                if (dizi[3 * i + 1] < dizi[i]) {
                    //Orta Çocuk 
                    if (3 * i + 2 < dizi.length && dizi[3 * i + 2] < dizi[i]) {
                        //Sağ Çocuk
                        if (3 * i + 3 < dizi.length && dizi[3 * i + 3] < dizi[i]) {
                            ucludurumlari = true;
                        } else {
                            ucludurumlari = false;
                            isminheap = false;
                        }
                    } else {
                        ucludurumlari = false;
                        isminheap = false;
                    }
                } else {
                    ucludurumlari = false;
                    isminheap = false;
                }
            }
        } else {
            ucludurumlari = false;
            isminheap = false;
        }

        if (isminheap) {
            System.out.println("Dizi uclu min heaptir");
        } else {
            System.out.println("Dizi uclu min heap degildir");
        }

    }
    
    class BinarySearchTree {

        class Node {

            int key;
            Node left, right, mid;

            public Node(int item) {
                key = item;
                left = right = mid = null;
            }
        }

        Node root;

        BinarySearchTree() {
            root = null;
        }

        void insert(int key) {
            root = insertKey(root, key);
        }

        Node insertKey(Node root, int key) {
            if(root==null) {
			root=new Node(key);
		}
		else if(root.left==null) {
			root.left=insertKey(root.left,key);
		}
		else if(root.mid==null) {
			root.mid=insertKey(root.mid,key);
		}
		else if(root.right==null) {
			root.right=insertKey(root.right,key);
		}
		else {
			if(root.left!= null) {
				if(root.left.left==null) {
					root.left.left=insertKey(root.left.left,key);
				}
				else if(root.left.mid==null) {
					root.left.mid=insertKey(root.left.mid,key);
				}
				else if(root.left.right==null) {
					root.left.right=insertKey(root.left.right,key);
				}
			}
			else if(root.mid!=null) {
				if(root.mid.left==null) {
					root.mid.left=insertKey(root.mid.left,key);
				}
				else if(root.mid.mid==null) {
					root.mid.mid=insertKey(root.mid.mid,key);
				}
				else if(root.mid.right==null) {
					root.mid.right = insertKey(root.mid.right,key);
				}
			}
			else if(root.right!=null) {
				if(root.right.left==null) {
					root.right.left = insertKey(root.right.left,key);
				}
				else if(root.right.mid==null) {
					root.right.mid=insertKey(root.right.mid,key);
				}
				else if(root.right.right==null) {
					root.right.right=insertKey(root.right.right,key);
				}
			}
		}
		return root;
	}

    }
  
    void gezinti(){
        Node root = null;
        gezintiRec(root);
    }
    
    void gezintiRec(Node root){
        if(root != null){
            gezintiRec(root.left);
            System.out.print(root.key + " ");
            gezintiRec(root.mid);
            System.out.print(root.key + " ");
            gezintiRec(root.right);
        }
    } 
    
    
}


