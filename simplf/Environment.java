package simplf; 

class Environment {
    public AssocList assocList;
    public final Environment enclosing;
    Environment() {
        this.assocList = null;
        this.enclosing = null;
    }

    Environment(Environment enclosing) {
        this.assocList = null;
        this.enclosing = enclosing;
    }


    Environment(AssocList assocList, Environment enclosing) {
        this.assocList = assocList;
        this.enclosing = enclosing;
    }

    // Return a new version of the environment that defines the variable "name"
    // and sets its initial value to "value". Take care to ensure the proper aliasing
    // relationship. There is an association list implementation in Assoclist.java.
    // If your "define" function adds a new entry to the association list without
    // modifying the previous list, this should yield the correct aliasing
    // relationsip.
    //
    // For example, if the original environment has the association list
    // [{name: "x", value: 1}, {name: "y", value: 2}]
    // the new environment after calling define(..., "z", 3) should have the following
    //  association list:
    // [{name: "z", value: 3}, {name: "x", value: 1}, {name: "y", value: 2}]
    // This should be constructed by building a new class of type AssocList whose "next"
    // reference is the previous AssocList.
    Environment define(Token varToken, String name, Object value) {
        AssocList newList = new AssocList(name, value, assocList);
        return new Environment(newList, enclosing);
    }

    void assign(Token name, Object value) {
        for (AssocList node = assocList; node != null; node = node.next) {
            if (node.name.equals(name.lexeme)) {
                node.value = value;
                return;
            }
        }
        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'");
    }

    void define(String name, Object value) {
        assocList = new AssocList(name, value, assocList);
    }  

    Object get(Token name) {
        for (AssocList node = assocList; node != null; node = node.next) {
            if (node.name.equals(name.lexeme)) {
                return node.value;
            }
        }
        if (enclosing != null) {
            return enclosing.get(name);
        }
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'");
    }
    }

