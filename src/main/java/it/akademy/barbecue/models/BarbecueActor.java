package it.akademy.barbecue.models;

public class BarbecueActor extends Person implements Games, MealOrganization {

    boolean goodMood;

    public BarbecueActor(String firstName, String lastName, int age, Role role, boolean goodMood) {
        super(firstName, lastName, age, role);
        this.goodMood = goodMood;
    }

    @Override
    public void playSoccer(Person person) {
        if (person.getAge() <= 18) {
            System.out.println(person.getFirstName() + " joue au foot. ");
        } else {
            System.out.println("T'es trop vieux pour ça ..., va t'occuper du repas !");
        }
    }

    @Override
    public void playPingPong(Person person) {
        if (person.getAge() <= 18) {
            System.out.println(person.getFirstName() + " joue au ping pong. ");
        } else {
            System.out.println("T'es trop vieux pour ça ..., va t'occuper du repas !");
        }
    }

    @Override
    public void cook(Person person) {
        if (person.getAge() > 18) {
            System.out.println(person.getFirstName() + " prépare le repas. ");
        } else {
            System.out.println("T'es trop jeune, va t'amuser !");
        }
    }

    @Override
    public void washDish(Person person) {
        if (person.getAge() > 18) {
            System.out.println(person.getFirstName() + " lave la vaisselle. ");
        } else {
            System.out.println("T'es trop jeune, va t'amuser !");
        }
    }

    public boolean isGoodMood() {
        return goodMood;
    }

    public void setGoodMood(boolean goodMood) {
        this.goodMood = goodMood;
    }
}
