package edu.odu.cs.cs330.items;

import java.util.Scanner;

/**
 * This class represents one piece of armour--as found in most video games.
 * This includes boots and helmets.
 *
 * Armour may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
public class Armour extends Item {
    /**
     * Durability decreases each time armour is used.
     */
    protected int durability;

    /**
     * The amount of damage that can be negated.
     */
    protected int  defense;

    /**
     * Base material out of which the armour is constructed.
     */
    protected String material;

    /**
     * Type of enchantment afforded (e.g. protection, feather_falling, or
     * unbreaking)
     */
    protected String modifier;

    /**
     * Enchantment level applied.
     */
    protected int modifierLevel;

    /**
     * Associated element--e.g., ice, fire, and lightning.
     */
    protected String element;

    /**
     * Default to a armour with an empty name, zero durability, zero defense,
     * blank material, no modifier a zero modifier level, and a blank element.
     */
    public Armour()
    {
        super("Armour");

        this.durability = 0;
        this.defense = 0;
        this.material = "";
        this.modifier = "";
        this.modifierLevel = 1;
        this.element = "";
    }

    /**
     * Duplicate a piece of armour.
     *
     * @param src armour to duplicate
     */
    public Armour(Armour src)
    {
        super(src.name);

        this.durability = src.durability;
        this.defense = src.defense;
        this.material = src.material;
        this.modifier = src.modifier;
        this.modifierLevel = src.modifierLevel;
        this.element = src.element;
    }

    /**
     * Retrieve armour durability.
     *
     * @return remaining durability
     */
    public int getDurability()
    {
        return this.durability;
    }

    /**
     * Set armour durability.
     *
     * @param dur new durability value
     */
    public void setDurability(int dur)
    {
        this.durability = dur;
    }

    /**
     * Retrieve armour defense.
     *
     * @return total defense provided
     */
    public int getDefense()
    {
        return this.defense;
    }

    /**
     * Set armour defense.
     *
     * @param def replacement defense
     */
    public void setDefense(int def)
    {
        this.defense = def;
    }

    /**
     * Retrieve armour material.
     *
     * @return base material
     */
    public String getMaterial()
    {
        return this.material;
    }

    /**
     * Set armour Material.
     *
     * @param mat replacement material type
     */
    public void setMaterial(String mat)
    {
        this.material = mat;
    }

    /**
     * Retrieve armour modifier.
     *
     * @return buff/debuff provided
     */
    public String getModifier()
    {
        return this.modifier;
    }

    /**
     * Set armour modifier.
     *
     * @param mod updated modifier
     */
    public void setModifier(String mod)
    {
        this.modifier = mod;
    }

    /**
     * Retrieve armour modifier level.
     *
     * @return buff/debuff level
     */
    public int getModifierLevel()
    {
        return this.modifierLevel;
    }

    /**
     * Set armour modifier level.
     *
     * @param level replacement modifier level
     */
    public void setModifierLevel(int level)
    {
        this.modifierLevel = level;
    }

    /**
     * Retrieve armour element.
     *
     * @return element
     */
    public String getElement()
    {
        return this.element;
    }

    /**
     * Set armour element.
     *
     * @param ele new element
     */
    public void setElement(String ele)
    {
        this.element = ele;
    }

    @Override
    public boolean isStackable()
    {
        return false;
    }

    /**
     * Read Armour attributes.
     */
    @Override
    public void read(Scanner snr)
    {
        super.name = snr.next();
        this.material = snr.next(); 
        this.durability = snr.nextInt(); 
        this.defense = snr.nextInt();    
        this.modifier = snr.next(); 
        this.modifierLevel = snr.nextInt();
        this.element = snr.next(); 
    }

    /**
     * Clone--i.e., copy--this Armour.
     */
    @Override
    public Item clone()
    {
        return new Armour(this);
    }

    /**
     * Check for logical equivalence--based on name, material, modifier, and
     * element.
     *
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs)
    {
        if (!(rhs instanceof Armour)) {
            return false;
        }

        Armour rhsArmour = (Armour) rhs;

        if (!this.name.equals(rhsArmour.name)){
            return false;
        }

        if (!this.material.equals(rhsArmour.material)){
            return false;
        }

        if (!this.modifier.equals(rhsArmour.modifier)){
            return false;
        }
        
        if(!this.element.equals(rhsArmour.element)){
            return false;
        }

        return true;

    }

    /**
     * Generate a hash code by adding the name, material, modifier, and element
     * hash codes.
     */
    @Override
    public int hashCode() {
        
        int hc = name.hashCode();

        hc += material.hashCode();
        hc += modifier.hashCode();
        hc += element.hashCode(); 

        return hc;
    }

    /**
     * *Print* one Armour.
     */
    @Override
    public String toString() {

        String armourStr = "  Nme: " + this.name + "\n"
                         + "  Dur: " + this.durability + "\n"
                         + "  Def: " + this.defense + "\n"
                         + "  Mtl: " + this.material + "\n"
                         + "  Mdr: " + this.modifier + " (Lvl " + this.modifierLevel + ")\n"
                         + "  Emt: " + this.element + "\n";
        return armourStr;
    }
}




