package simplf; 

class Environment {
    Environment() {
        //throw new UnsupportedOperationException("TODO: implement environments.");
    }

    Environment(Environment enclosing) {
        throw new UnsupportedOperationException("TODO: implement environments.");
    }

    Environment(AssocList assocList, Environment enclosing) {
        throw new UnsupportedOperationException("TODO: implement environments.");
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
        throw new UnsupportedOperationException("TODO: implement environments.");
    }

    void assign(Token name, Object value) {
        throw new UnsupportedOperationException("TODO: implement environments.");
    }

    Object get(Token name) {
        throw new UnsupportedOperationException("TODO: implement environments.");
    }
}

