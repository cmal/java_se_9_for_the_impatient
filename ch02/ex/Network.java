package ch02.ex;

import java.util.ArrayList;

public class Network {

    // use javap -private ch02/ex/Network\$Member
    // to see the private class
    public class Member { // Member is an inner class of Network
        private String name;
        private ArrayList<Member> friends;

        public Member(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }
        public void deactivate() {
            // members.remove(this);
            Network.this.members.remove(this);
        }

        public boolean belongsTo(Network n) {
            return Network.this == n;
        }
    
    }

    private ArrayList<Member> members = new ArrayList<>();
    
    public Member enroll(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public void unenroll(Member m) {
        // members.remove(m);
        m.deactivate();
    }

    public int size() {
        return members.size();
    }

    public static void main(String[] args) {
        Network myFace = new Network();
        System.out.println(myFace.size());
        Network.Member fred = myFace.enroll("Fred");
        System.out.println(myFace.size());
        System.out.println(fred.belongsTo(myFace));

        Network.Member wilma = myFace.new Member("Wilma");
        fred.deactivate();
        System.out.println(myFace.size());
        System.out.println(fred.belongsTo(myFace));
        System.out.println(wilma.belongsTo(myFace));
    }
}
