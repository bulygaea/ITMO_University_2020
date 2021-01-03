package com.company;

import ru.ifmo.se.pokemon.*;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon a1 = new Kartana("Kartana1", 1);
        Pokemon b1 = new Feebas("Feebas1", 1);
        Pokemon a2 = new Milotic("Milotic1", 1);
        Pokemon b2 = new Litwick("Litwick1", 1);
        Pokemon a3 = new Lampent("Lampent1", 1);
        Pokemon b3 = new Chandelure("Chandelure1", 1);
        b.addAlly(a1);
        b.addAlly(a2);
        b.addAlly(a3);
        b.addFoe(b1);
        b.addFoe(b2);
        b.addFoe(b3);
        b.go();
    }
}

class Kartana extends Pokemon {
    public Kartana(String s, int i) {
        super(s, i);
        setStats(59, 181, 131, 59, 31, 109);
        setType(Type.STEEL, Type.GRASS);
        setMove(new FlashCannon(), new Tackle(), new Swagger(), new DoubleEdge());
    }
}

class Feebas extends Pokemon {
    public Feebas(String s, int i) {
        super(s, i);
        setStats(20, 15, 20, 10, 55, 80);
        setType(Type.WATER);
        setMove(new Waterfall(), new Facade(), new IceBeam());
    }
}

class Milotic extends Feebas {
    public Milotic(String s, int i) {
        super(s, i);
        setStats(95, 60, 79, 100, 125, 81);
        setType(Type.WATER);
        addMove(new Coil());
    }
}

class Litwick extends Pokemon {
    public Litwick(String s, int i) {
        super(s, i);
        setStats(50, 30, 55, 65, 55, 20);
        setType(Type.GHOST, Type.FIRE);
        setMove(new CalmMind(), new WillOWisp());
    }
}

class Lampent extends Litwick {
    public Lampent(String s, int i) {
        super(s, i);
        setStats(60, 40, 60, 95, 60, 55);
        setType(Type.GHOST, Type.FIRE);
        addMove(new NightShade());
    }
}

class Chandelure extends Lampent {
    public Chandelure(String s, int i) {
        super(s, i);
        setStats(60, 55, 90, 145, 90, 80);
        setType(Type.GHOST, Type.FIRE);
        addMove(new EnergyBall());
    }
}

class FlashCannon extends SpecialMove {
    public FlashCannon() {
        super(Type.STEEL, 80, 100);
    }

    @Override
    protected String describe() {
        return "использует Flash Cannon";
    }
}

class Tackle extends PhysicalMove {
    public Tackle() {
        super(Type.NORMAL, 40, 100);
    }

    @Override
    protected String describe() {
        return "использует Tackle";
    }
}

class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected String describe() {
        return "использует Swagger";
    }
}

class DoubleEdge extends PhysicalMove {
    public DoubleEdge() {
        super(Type.NORMAL, 120, 100);
    }

    @Override
    protected String describe() {
        return "использует Double-Edge";
    }
}

class Waterfall extends PhysicalMove {
    public Waterfall() {
        super(Type.WATER, 80, 100);
    }

    @Override
    protected String describe() {
        return "использует Waterfall";
    }
}

class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected String describe() {
        return "использует Facade";
    }
}

class IceBeam extends SpecialMove {
    public IceBeam() {
        super(Type.ICE, 90, 100);
    }

    @Override
    protected String describe() {
        return "использует Ice Beam";
    }
}

class Coil extends StatusMove {
    public Coil() {
        super(Type.POISON, 0, 0);
    }

    @Override
    protected String describe() {
        return "использует Coil";
    }
}

class CalmMind extends StatusMove {
    public CalmMind() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected String describe() {
        return "использует Calm Mind";
    }
}

class WillOWisp extends StatusMove {
    public WillOWisp() {
        super(Type.FIRE, 0, 85);
    }

    @Override
    protected String describe() {
        return "использует Will-O-Wisp";
    }
}

class NightShade extends SpecialMove {
    public NightShade() {
        super(Type.GHOST, 0, 100);
    }

    @Override
    protected String describe() {
        return "использует Night Shade";
    }
}

class EnergyBall extends SpecialMove {
    public EnergyBall() {
        super(Type.GRASS, 90, 100);
    }

    @Override
    protected String describe() {
        return "использует Energy Ball";
    }
}
