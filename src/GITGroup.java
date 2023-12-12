import java.util.Scanner;

public class GITGroup {

    public static void main(String[] args)
    {
        // Kysytään pelaajan nimi
        Scanner scanner = new Scanner(System.in);
        String playerName = "";

        // Tarkastetaan onko pelaajan nimi tyhja
        while (playerName.isEmpty()) 
        {
            System.out.print("Anna pelaajan nimi: ");
            playerName = scanner.nextLine().trim();

            // Tarkistetaan, ettei nimi ole tyhjä
            if (playerName.isEmpty()) 
            	{
                System.out.println("Nimi ei voi olla tyhjä. Anna nimi uudelleen.");
            	}
        }
        
        //testi
        
        // Luodaan pelaajan hahmo aloitusenergialla 100
        HumanCharacter character = new HumanCharacter(playerName, 100);
        character.characterInfo();

        // Pelaajan toimintojen valinta
        while (character.getEnergy() > 0) 
        {
            System.out.println("\nValitse toiminto:");
            System.out.println("1. Nuku");
            System.out.println("2. Syö");
            System.out.println("3. Juokse");
            System.out.println("4. Hyppää");
            System.out.println("5. Tanssi");
            System.out.println("6. Lopeta peli");

            //Try/catch, jos käyttäjä valitsee esim.kirjaimen tai floatin annettujen numeroiden sijaan
            int choice=-1;
            try {
            	System.out.println("Valitse toiminto: ");
            	choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
            	System.out.println("Valitse toiminto annetuista numeroista");
            	scanner.nextLine();
            	continue;
            }

            switch (choice) 
            {
                case 1:
                    character.sleep();
                    break;
                case 2:
                    character.eat();
                    break;
                case 3:
                    character.run();
                    break;
                case 4:
                    character.jump();
                    break;
                case 5:
                    character.dance();
                    break;    
                case 6:
                    System.out.println("Peli päättyi!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Virheellinen valinta. Yritä uudelleen.");
            }

            character.characterInfo();

            // Tarkistetaan ja päivitetään energiataso
            if (character.getEnergy() > 100) 
            	{
                character.setEnergy(100);
                System.out.println("Energiasi on täynnä.");
            	}

            // Peli loppuu kun energia on 0, tarkistetaan se tässä
            if (character.getEnergy() <= 0) 
            	{
                System.out.println("Peli päättyi. Energiasi loppui.");
                scanner.close();
                System.exit(0);
            	}
        }
    } // Main loppuu
} //Luokka GITGroup päättyy tähän

// Yläluokka Character alkaa tästä
class Character 
{

    protected String name;
    protected int energy;

    public Character(String name, int energy) 
    	{
        this.name = name;
        this.energy = energy;
    	}

    // Metodi näyttää tiedot hahmosta
    public void characterInfo() 
    	{
        System.out.println("***Character***");
        System.out.println("Name: " + name);
        System.out.println("Energy level: " + energy);
    	}

    // Metodi palauttaa energiatason
    public int getEnergy() 
    	{
        return energy;
    	}

    // Metodi asettaa energiatason
    public void setEnergy(int newEnergy) 
    	{
        energy = newEnergy;
    	}
} // Yläluokka Character päättyy tähän

// Alaluokka HumanCharacter alkaa tästä
class HumanCharacter extends Character 
{

    public HumanCharacter(String name, int startingEnergy) {
        super(name, startingEnergy);
    }

    // Metodi nukkumiseen, uni tuo energiaa 20
    public void sleep() 
    	{
        energy += 20;
        System.out.println(name + " sleeps");
    	}

    // Metodi syömiseen, syöminen tuo energiaa 5
    public void eat() 
    	{
        energy += 5;
        System.out.println(name + " eats");
    	}

    // Metodi juoksemiseen, juokseminen vie energiaa 10
    public void run() 
    	{
        energy -= 10;
        System.out.println(name + " runs");
    	}

    // Metodi hyppäämiseen, hyppääminen vie energiaa 8
    public void jump() 
    	{
        energy -= 8;
        System.out.println(name + " jumps");
    	}
    
    // Metodi tanssimiseen, tanssiminen vie energiaa 10
    public void dance()
    {
    	energy -= 10;
    	System.out.println(name + " dances");		
    }
    
} // Alaluokka HumanCharacter päättyy tähän