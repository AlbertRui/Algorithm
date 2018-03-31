package algs.hash;

/**
 * 基于线性探测的符号表
 *
 * @author AlbertRui
 * @date 2018-03-31 21:41
 */
public class LinearProbingHashST<Key, Value> {

    private static final int INIT_CAPACITY = 4;

    private int n;//符号表中键值对的总数
    private int m = 16;//线性探测表的大小
    private Key[] keys;//键
    private Value[] values;//值

    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public LinearProbingHashST(int m) {
        this.m = m;
        this.n = 0;
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        return getValue(key) != null;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(cap);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        m = temp.m;
    }

    public void put(Key key, Value value) {
        if (n >= m / 2) resize(2 * m);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    public Value getValue(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueTORedo = values[i];
            keys[i] = null;
            values[i] = null;
            n--;
            put(keyToRedo, valueTORedo);
            i = (i + 1) % m;
        }
        n--;
        if (n > 0 && n == m / 8) {
            resize(m / 2);
        }
    }

}
