package com.company;

/**
 * Created by ashu on 15/01/18.
 */
public class LinkList {

    private Node head , tail;



   void append(int data){

       Node newNode = new Node();

       newNode.data = data;


       if(head == null){
           head = newNode;
           tail = newNode;
       }else {


           tail.next = newNode;
           tail = newNode;
       }
   }

   void removeTail(){

       if (tail == null)

           return;

       else {

           if (head == tail) {

               head = null;

               tail = null;

           } else {

               Node previousToTail = head;

               while (previousToTail.next != tail) {
                   previousToTail = previousToTail.next;
               }

               tail = previousToTail;

               tail.next = null;

           }

       }


   }


   void removeHead (){
       if(head.next != null){

           Node temp = head.next;
           head.next = null;
           head = temp;

       }else {
           head = null;
           tail = null;
       }



   }





    void removeGreaterThen(int min){



       if(head == null){
           return;
       }

        Node temp = head;


        while (temp != null ){




            if(temp.data > min)
            {
                if(temp == head){

                    temp = temp.next;

                    removeHead();


                } else

                if(temp == tail){




                    removeTail();



                    temp = null;


                }
                else {

                    System.out.println(temp.data);

                    Node nextTemp = temp.next;

                        temp.data = nextTemp.data;
                        temp.next = nextTemp.next;
                        // clearing next reference so it will not cause memory leak
                        nextTemp.next = null;

                        if(temp.next == null){
                            tail = temp;
                        }


                }

            } else {
                temp = temp.next;
            }



       }



    }

    void print(){

        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data);

            if(temp.next != null)
            {
                System.out.print(" ->  ");
            }
            temp = temp.next;


        }

    }




    private class Node {
       private Node next = null;
       private int  data;


    }

}
