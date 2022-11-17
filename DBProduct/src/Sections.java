import java.util.ArrayList;

public class Sections {
    private ArrayList<Section> sections = new ArrayList<>();

    public void addSection(String name, String workTime) {
        Section newSection = new Section(name, workTime);
        if (sections.isEmpty()) {
            newSection.setId(1);
        } else {
            newSection.setId(sections.get(sections.size() - 1).getId() + 1);
        }
        sections.add(newSection);
    }

    public void removeSection(Section section) {
        sections.remove(section);
    }

    public void updateSection(Section updatedSection, String updatedName, String updatedWorkTime) {
        if (!updatedName.equals("")) {
            updatedSection.setName(updatedName);
        }
        if (!updatedWorkTime.equals("")) {
            updatedSection.setWorkTime(updatedWorkTime);
        }
    }

    public void showSections() {

        for (Section section : sections) {
            if (!section.getProducts().isEmpty()) {
                System.out.println(section.getId() + "\t" + section.getName() + "\t" + section.getWorkTime());
                for (Product product : section.getProducts()) {
                    System.out.println("\t" + product.getId() + "\t" + product.getNameProduct());
                }
            }
            if (!section.getProducts().isEmpty()) {
                System.out.println("Товаров в отделе нет..");
            }
        }
    }

    public void showSectionsWithoutProducts() {
        for (Section section : sections) {
            if (section.getProducts().isEmpty()) {
                System.out.println(section.getId() + "\t" + section.getName() + section.getWorkTime());
                for (Product product : section.getProducts()) {
                    System.out.println("\t" + product.getId() + "\t" + product.getNameProduct());
                }
            }
        }
    }

    public Section findSectionById(int id) {
        for (Section section : sections) {
            if (section.getId() == id) {
                return section;
            }
        }
        return null;
    }

    public void setSections(ArrayList<Section> sections) {this.sections = sections;}

    public ArrayList<Section> getSections() {return this.sections;}
}
