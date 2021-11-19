<?php

namespace App\Form;

use App\Entity\Evenement;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class EvenementType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('titreeven',TextType::class, [ 'attr'=>[ 'placeholder'=>"Saisir le titre de l'evenement"]])
            ->add('descriptioneven',TextType::class, [ 'attr'=>[ 'placeholder'=>"Saisir la description de l'evenement"]])
            ->add('dateDebut')
            ->add('dateFin')
            ->add('lieuEven', TextType::class, [ 'attr'=>[ 'placeholder'=>"Saisir le lieu de l'evenement"]])
            ->add('invites', TextType::class, [ 'attr'=>[ 'placeholder'=>"Saisir l'invité"]])
            ->add('responsable', TextType::class, [ 'attr'=>[ 'placeholder'=>"Saisir le responsable de l'evenement"]])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Evenement::class,
        ]);
    }
}
