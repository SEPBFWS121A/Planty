import './smoke.cy';

const name = 'Sunflower';
const description = 'A beautiful yellow flower';
const category = 'Sunflower';
const sensor = 'Epic Sensor';

describe('UI Tests', () => {
  beforeEach(() => {
    // Öffne die Webseite, die du testen möchtest
    cy.visit('http://localhost:4200/');
  });


  describe('Check UI-Elements', () => {
    it('Check Submit Button', () => {
      //Visit Plant site
      cy.visit('http://localhost:4200/plant');

      //Check if buttons exist
      cy.contains('button', 'Add Plant').should('exist');
    });

    it('Check name field', () => {
      //Visit Plant site
      cy.visit('http://localhost:4200/plant');

      //Check if field exist
      cy.get('input[placeholder="Name"]').should('exist');
    });


    it('Check category dropdown', () => {
      //Visit Plant site
      cy.visit('http://localhost:4200/plant');

      //Check if field exist
      cy.contains('mat-label.ng-star-inserted', 'Selected Category').should('exist');
    });

    it('Check sensor dropdown', () => {
      //Visit Plant site
      cy.visit('http://localhost:4200/plant');

      //Check if field exist
      cy.contains('mat-label.ng-star-inserted', 'Selected Sensor').should('exist');
    });
  });

  describe('Check UI-Elements functionality', () => {
    it('Check maxlength = 40 on Name field and maxlength = 100 on description ', () => {
      //Visit Plant site
      cy.visit('http://localhost:4200/plant');

      // Interact with the input fields
      cy.get('input[placeholder="Name"]').type('Lorem ipsum dolor sit amet, consectetuer adip');

      cy.get('input[placeholder="Description"]').type('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.');

      // Select the category from the dropdown
      cy.contains('mat-label.ng-star-inserted', 'Selected Category')
        .parents('mat-form-field')
        .find('mat-select')
        .click();
      cy.get('mat-option').contains(category).click();

      // Select the category from the dropdown
      cy.contains('mat-label.ng-star-inserted', 'Selected Sensor')
        .parents('mat-form-field')
        .find('mat-select')
        .click();
      cy.get('mat-option').contains(sensor).click();

      // Click the submit button
      cy.contains('Add Plant').click();

      // Verify the added plant
      cy.contains('table td', 'Lorem ipsum dolor sit amet, consectetuer').should('exist');
      cy.contains('table td', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m').should('exist');
    });


    it('Deleting an incorrectly created plant', () => {
      //Visit Plant site
      cy.visit('http://localhost:4200/plant');

      // Interact with the input fields
      cy.get('input[placeholder="Name"]').type(name);
      cy.get('input[placeholder="Description"]').type(description);

      // Select the category from the dropdown
      cy.contains('mat-label.ng-star-inserted', 'Selected Category')
        .parents('mat-form-field')
        .find('mat-select')
        .click();
      cy.get('mat-option').contains(category).click();


      // Select the category from the dropdown
      cy.contains('mat-label.ng-star-inserted', 'Selected Sensor')
        .parents('mat-form-field')
        .find('mat-select')
        .click();
      cy.get('mat-option').contains(sensor).click();

      // Click the submit button
      cy.contains('Add Plant').click();

      // Verify the added plant
      cy.contains('table td', name).should('exist');
      cy.contains('table td', description).should('exist');

      // Click the delete button for the added plant
      cy.contains('table td', name)
        .siblings('td')
        .contains('Delete')
        .click();

      // Verify that the plant is deleted
      cy.contains('table td', name).should('not.exist');
    });

    it('Don\'t add Plant when no Category and Sensor is selected ', () => {
      //Visit Plant site
      cy.visit('http://localhost:4200/plant');

      // Interact with the input fields
      cy.get('input[placeholder="Name"]').type('Invalid Plant');
      cy.get('input[placeholder="Description"]').type(description);

      // Click the submit button
      cy.contains('Add Plant').click();

      // Verify the added plant
      cy.contains('table td', 'Invalid Plant').should('not.exist');
    });


    it('Add Plant without a description ', () => {
      //Visit Plant site
      cy.visit('http://localhost:4200/plant');

      // Interact with the input fields
      cy.get('input[placeholder="Name"]').type('Plant without Desc.');

      // Select the category from the dropdown
      cy.contains('mat-label.ng-star-inserted', 'Selected Category')
        .parents('mat-form-field')
        .find('mat-select')
        .click();
      cy.get('mat-option').contains(category).click();


      // Select the category from the dropdown
      cy.contains('mat-label.ng-star-inserted', 'Selected Sensor')
        .parents('mat-form-field')
        .find('mat-select')
        .click();
      cy.get('mat-option').contains(sensor).click();

      // Click the submit button
      cy.contains('Add Plant').click();

      // Verify the added plant
      cy.contains('table td', 'Plant without Desc.').should('exist');
    });
  });
});
