/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.ragga.sofinal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author ragga
 */
public class MyBlockingQueue<E> {
    private Queue<E> queue;
    private int max = 10;
    private ReentrantLock lock = new ReentrantLock(true); 
    
    public MyBlockingQueue(int size){
        queue = new LinkedList<>();
        this.max = size;
    }
    
    public void put(E e){
        lock.lock();
        try{
            while(queue.size() == max){
                //Se bloquea cuando este lleno
            }
            queue.add(e);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            lock.unlock();
        }
    }
    
    public E take(){
        lock.lock();
        try{
            while(queue.size() == 0){
                //Se bloquea cuando este lleno
            }
            E item = queue.remove();
            return item;
        }catch(Exception e){
        }finally{
            lock.unlock();
        }
        return take();
    }
}
