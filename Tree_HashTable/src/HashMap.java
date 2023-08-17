import java.util.Iterator;

public class HashMap<K, V> implements Iterable<HashMap.Entity>{

    private static final int INIT_BUCKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.5;
    private int size;

    // Массив бакетов (связных списков)
    private Bucket[] buckets;

    @Override
    public Iterator<HashMap.Entity> iterator() {
        return null;
    }

    class HashMapIterator implements Iterator<HashMap.Entity>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Entity next() {
            return null;
        }
    }


    /**
     * Элемент хэш Таблицы
     */
    class Entity{
        K key;
        V value;

        @Override
        public String toString() {
            return String.format("%s - %s", key, value);
        }
    }

    /**
     * Связный список
     * @param <K> Ключ элемента хэш-Таблицы
     * @param <V> Значение элемента хэш-Таблицы
     */
    class Bucket<K, V>{

        // Указатель на первый элемент связного списка
        Node head;

        /**
         * Узел бакета (связного списка)
         */
        class Node{

            // Указатель на следующий элемент связного списка
            Node next;

            // Значение узла указывающее на элемент
            Entity value;
        }


        /**
         * Добавление нового элемента хеш таблицы
         * @param entity
         * @return
         */
        public V add(Entity entity){

            Node node = new Node();
            node.value = entity;

            if (head == null){
                head = node;
                return null;
            }

            Node currentNOde = head;
            while (true){
                if(currentNOde.value.key.equals(entity.key)){
                    V buf = (V)currentNOde.value.value;
                    currentNOde.value.value = entity.value;
                    return buf;
                }
                if (currentNOde.next != null){
                    currentNOde = currentNOde.next;
                } else {
                    currentNOde.next = node;
                    return null;
                }
            }
        }

        public V get(K key){
            Node node = head;
            while (node != null){
                if (node.value.key.equals(key))
                    return (V)node.value.value;
                node = node.next;
            }
            return null;
        }

        public V remove(K key){
            if (head == null)
                return null;
            if (head.value.key.equals(key)){
                V buf = (V)head.value.value;
                head = head.next;
                return buf;

            } else {
                Node node = head;
                while (node.next != null){
                    if (node.next.value.key.equals(key)){
                        V buf = (V)node.next.value.value;
                        node.next = node.next.next;
                        return buf;
                    }
                    node = node.next;
                }
                return null;
            }
        }
    }

    private int calculateBucketIndex(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private void recalculate(){
        size = 0;
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++){
            Bucket<K, V> bucket = old[i];
            if (bucket != null){
                Bucket.Node node = bucket.head;
                while (node != null){
                    put((K)node.value.key, (V)node.value.value);
                    node = node.next;
                }
            }
        }
    }

    public V put(K key, V value){

        if (buckets.length * LOAD_FACTOR <= size){
            recalculate();
        }
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null){
            bucket = new Bucket();
            buckets[index] = bucket;
        }

        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;

        V buf = (V)bucket.add(entity);
        if (buf == null){
            size++;
        }
        return buf;

    }

    public V get(K key){
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        return (V) bucket.get(key);
    }

    public V remove(K key){
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null)
            return null;
        V buf = (V)bucket.remove(key);
        if (buf != null){
            size--;
        }
        return buf;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < buckets.length; i++){
            Bucket<K, V> bucket = buckets[i];
            if (bucket != null){
                Bucket.Node node = bucket.head;
                while (node != null){
                    stringBuilder.append(node.value);
                    stringBuilder.append('\n');
                    node = node.next;
                }
            }
        }
        return stringBuilder.toString();
    }

    public  HashMap(){
        buckets = new Bucket[INIT_BUCKET_COUNT];
    }



    public HashMap(int initCount){
        buckets = new Bucket[initCount];
    }

}
