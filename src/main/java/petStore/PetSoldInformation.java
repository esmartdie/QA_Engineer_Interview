package petStore;

import java.util.Map;

public class PetSoldInformation {

    public static void main(String[] args) {
        System.out.println("-----Consulta de mascotas vendidas--------");
        Map<Integer, String> soldPetsMap = new PetStatus().soldPets();
        System.out.println("-----Consulta de mascotas vendidas agrupadas por nombre--------");
        PetMapProcessor petCount = new PetMapProcessor(soldPetsMap);
        petCount.countPetsByName();
    }
}
