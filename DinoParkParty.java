import java.util.Scanner;

public class DinoParkParty
{

   public static void main(String[] args)
   {
   
      Scanner in = new Scanner (System.in);
      
      int entry = 0;
      int adult = 0;
      int kid = 0;
      double adultPrice = 15;
      double kidPrice = 8;
      String member = "x";
      String cont = "y";
      
      do
      {
      
         System.out.println("Welcome to the Dinosaur Park Party Planner");
         System.out.println("1. Group Rate Admission Party");
         System.out.println("2. Bare Bones Package");
         System.out.println("3. Deluxe Party Package");
         System.out.println("4. Quit");
         System.out.println("Enter your choice: ");
         
         //Get the user input to move to the next menu screen
         entry = in.nextInt();
         //buffer flush
         in.nextLine();
            
         //Option 1 brings the user to a discount screen, where they may qualify for 10% off admission if the reservation is placed by a member with a large enough party
         if(entry == 1)
         {    
            //First thing's first, we check if the reservation is being placed by a member. If not, the else statement down at the bottom of this block spits the user to the main menu option          
            System.out.println("Park Members get group admission price. That means 10% off with a party of 10+");
            System.out.println("Are you a member? (y/n)");
            member = in.nextLine();
            
            //This while loop will prevent any surprises and make sure the user answers yes or no
            while(!member.equalsIgnoreCase("y") && !member.equalsIgnoreCase("n"))
            {
               System.out.println("Sorry, that is not a valid entry. Please try again.");
               System.out.println("Are you a member? (y/n)");
               member = in.nextLine();
            }
         
            if(member.equalsIgnoreCase("y"))
            {
               
               System.out.println("Enter how many people are in your party and see if you qualify!");
               System.out.println("How many adults in your party?");
               adult = in.nextInt();
               System.out.println("How many kids in your party?");
               kid = in.nextInt();
               //buffer flush
               in.nextLine();
               
               //Then we use an if statement to determine if the party is, in fact, large enough by adding the inputs. If it is, then the calculation begins               
               if(adult + kid >= 10)
               {
                  System.out.println("You qualify for 10% off!");
                  //It then takes the sum total and multiplies it by .9 for an output reflecting the total price with the discount applied
                  System.out.println("The total cost for your party will be $" + (((adult * adultPrice) + (kid * kidPrice)) * .9));
                  
                  //The last line shows how much money was saved by arriving at the above total, multiplied by .1 to show what was subtracted by the discount
                  System.out.println("With this offer, you have saved $" + (((adult * adultPrice) + (kid * kidPrice)) * .1) + "!");
               }
               
               else
               {
                  System.out.println("Sorry, your party is not large enough to qualify for the group discount.");
               }
            }
            //This is where a non-member ends up, with an apology and a kick down to the main menu/quit option
            else if (member.equalsIgnoreCase("n"))
            {
               System.out.println("Sorry, the Group Rate Admission Party offer is only available to Park Members");
            }
         }
         
         //Option 2 is a much simpler menu. No need to check for membership, and only working with base prices.
         else if(entry == 2)
         {
            System.out.println("This option is best for a single family looking for a day with the Dinosaurs! Standard admission rates apply");
            System.out.println("How many adults in your party?");
            adult = in.nextInt();
            System.out.println("How many kids in your party?");
            kid = in.nextInt();
            
            //buffer flush
            in.nextLine();
            
            System.out.println("The total cost for your party will be $" + ((adult * adultPrice) + (kid * kidPrice)));
            if(adult + kid >= 10)
            {
               System.out.println("That's a big group! Park Members should check out the Group Rate Admission page to see how much you could save with our discounted pricing.");
            }
         }
         //Option 3 takes the user to the deluxe option, which is a better experience for a flat-rate addition to the party admission
         //Members pay $50 on top of base price, and non-members pay $100 on top of base price
         else if(entry == 3)
         {
            System.out.println("Want to take your birthday to a new extreme? Amp up your party with the Dino Deluxe Package for $100 dollars plus the price of your party's admission");
            System.out.println("Park Members receive a $50 discount for the Deluxe Package!");
            System.out.println("Enter your party's information below for pricing");
            
            {
               //First we get user input on membership, which is used later. It's quartered off up here so the while statement can catch any invalid inputs.
               System.out.println("Are you a member? (y/n)");
               member = in.nextLine();
               while(!member.equalsIgnoreCase("y") && !member.equalsIgnoreCase("n"))
               {
                  System.out.println("Sorry, that's an invalid entry. Please try again.");
                  System.out.println("Are you a member? (y/n)");
                  member = in.nextLine();
               }
            
               System.out.println("How many adults in your party?");
               adult = in.nextInt();
               System.out.println("How many kids in your party?");
               kid = in.nextInt();
               
               //flush bufffer
               in.nextLine();
               
               //The equation in the if statement adds 50 to the base price for members, and the else if after that adds 100 for the non-members
               if(member.equalsIgnoreCase("y"))
               {
                  System.out.println("The total cost for your Deluxe Package will be $" + (((adult * adultPrice) + (kid * kidPrice)) + 50.));
               }
               else if(member.equalsIgnoreCase("n"))
               {
                  System.out.println("The total cost for your Deluxe Package will be $" + (((adult * adultPrice) + (kid * kidPrice)) + 100.));
               }
            }
         }
         else if (entry == 4)
         {
            //Intentionally left blank in order to get the user to the confirm quit prompt without further delay
         }
         else
         {
            System.out.println("That is not one of our options.");
         }
         
         //Give user the option to begin again or leave the program. Every menu option will ultimately end up here.
         System.out.println("You may now press \"Q\" to exit");
         System.out.println("Still have questions? Press any other key to return to the main menu");
         cont = in.nextLine();
      }while(!cont.equalsIgnoreCase("q"));
      
      //I had a lot of fun with this! Sorry there weren't any dinosaur puns.......
      System.out.println("Thanks, we hope to see you soon!");
   }

}