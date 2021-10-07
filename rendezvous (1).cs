using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Checkup
{
    #region Rendezvous
    public class Rendezvous
    {
        #region Member Variables
        protected int _idrdv;
        protected string _medecinrdv;
        protected string _patientrdv;
        protected string _daterdv;
        #endregion
        #region Constructors
        public Rendezvous() { }
        public Rendezvous(string medecinrdv, string patientrdv, string daterdv)
        {
            this._medecinrdv=medecinrdv;
            this._patientrdv=patientrdv;
            this._daterdv=daterdv;
        }
        #endregion
        #region Public Properties
        public virtual int Idrdv
        {
            get {return _idrdv;}
            set {_idrdv=value;}
        }
        public virtual string Medecinrdv
        {
            get {return _medecinrdv;}
            set {_medecinrdv=value;}
        }
        public virtual string Patientrdv
        {
            get {return _patientrdv;}
            set {_patientrdv=value;}
        }
        public virtual string Daterdv
        {
            get {return _daterdv;}
            set {_daterdv=value;}
        }
        #endregion
    }
    #endregion
}