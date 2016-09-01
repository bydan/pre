/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.facturacion.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.VendedorVisitaConstantesFunciones;
import com.bydan.erp.facturacion.util.VendedorVisitaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.VendedorVisitaParameterGeneral;
import com.bydan.erp.facturacion.business.entity.VendedorVisita;
import com.bydan.erp.facturacion.business.logic.VendedorVisitaLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class VendedorVisitaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VendedorVisitaLogic.class);
	
	protected VendedorVisitaDataAccess vendedorvisitaDataAccess; 	
	protected VendedorVisita vendedorvisita;
	protected List<VendedorVisita> vendedorvisitas;
	protected Object vendedorvisitaObject;	
	protected List<Object> vendedorvisitasObject;
	
	public static ClassValidator<VendedorVisita> vendedorvisitaValidator = new ClassValidator<VendedorVisita>(VendedorVisita.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VendedorVisitaLogicAdditional vendedorvisitaLogicAdditional=null;
	
	public VendedorVisitaLogicAdditional getVendedorVisitaLogicAdditional() {
		return this.vendedorvisitaLogicAdditional;
	}
	
	public void setVendedorVisitaLogicAdditional(VendedorVisitaLogicAdditional vendedorvisitaLogicAdditional) {
		try {
			this.vendedorvisitaLogicAdditional=vendedorvisitaLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  VendedorVisitaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.vendedorvisitaDataAccess = new VendedorVisitaDataAccess();
			
			this.vendedorvisitas= new ArrayList<VendedorVisita>();
			this.vendedorvisita= new VendedorVisita();
			
			this.vendedorvisitaObject=new Object();
			this.vendedorvisitasObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.vendedorvisitaDataAccess.setConnexionType(this.connexionType);
			this.vendedorvisitaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VendedorVisitaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.vendedorvisitaDataAccess = new VendedorVisitaDataAccess();
			this.vendedorvisitas= new ArrayList<VendedorVisita>();
			this.vendedorvisita= new VendedorVisita();
			this.vendedorvisitaObject=new Object();
			this.vendedorvisitasObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.vendedorvisitaDataAccess.setConnexionType(this.connexionType);
			this.vendedorvisitaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VendedorVisita getVendedorVisita() throws Exception {	
		VendedorVisitaLogicAdditional.checkVendedorVisitaToGet(vendedorvisita,this.datosCliente,this.arrDatoGeneral);
		VendedorVisitaLogicAdditional.updateVendedorVisitaToGet(vendedorvisita,this.arrDatoGeneral);
		
		return vendedorvisita;
	}
		
	public void setVendedorVisita(VendedorVisita newVendedorVisita) {
		this.vendedorvisita = newVendedorVisita;
	}
	
	public VendedorVisitaDataAccess getVendedorVisitaDataAccess() {
		return vendedorvisitaDataAccess;
	}
	
	public void setVendedorVisitaDataAccess(VendedorVisitaDataAccess newvendedorvisitaDataAccess) {
		this.vendedorvisitaDataAccess = newvendedorvisitaDataAccess;
	}
	
	public List<VendedorVisita> getVendedorVisitas() throws Exception {		
		this.quitarVendedorVisitasNulos();
		
		VendedorVisitaLogicAdditional.checkVendedorVisitaToGets(vendedorvisitas,this.datosCliente,this.arrDatoGeneral);
		
		for (VendedorVisita vendedorvisitaLocal: vendedorvisitas ) {
			VendedorVisitaLogicAdditional.updateVendedorVisitaToGet(vendedorvisitaLocal,this.arrDatoGeneral);
		}
		
		return vendedorvisitas;
	}
	
	public void setVendedorVisitas(List<VendedorVisita> newVendedorVisitas) {
		this.vendedorvisitas = newVendedorVisitas;
	}
	
	public Object getVendedorVisitaObject() {	
		this.vendedorvisitaObject=this.vendedorvisitaDataAccess.getEntityObject();
		return this.vendedorvisitaObject;
	}
		
	public void setVendedorVisitaObject(Object newVendedorVisitaObject) {
		this.vendedorvisitaObject = newVendedorVisitaObject;
	}
	
	public List<Object> getVendedorVisitasObject() {		
		this.vendedorvisitasObject=this.vendedorvisitaDataAccess.getEntitiesObject();
		return this.vendedorvisitasObject;
	}
		
	public void setVendedorVisitasObject(List<Object> newVendedorVisitasObject) {
		this.vendedorvisitasObject = newVendedorVisitasObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.vendedorvisitaDataAccess!=null) {
			this.vendedorvisitaDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			vendedorvisitaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			vendedorvisitaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vendedorvisita=vendedorvisitaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vendedorvisita,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisita);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  		  
        try {
			
			vendedorvisita=vendedorvisitaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vendedorvisita,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisita);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vendedorvisita=vendedorvisitaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vendedorvisita,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisita);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  		  
        try {
			
			vendedorvisita=vendedorvisitaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vendedorvisita,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisita);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =vendedorvisitaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vendedorvisita = new  VendedorVisita();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=vendedorvisitaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =vendedorvisitaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vendedorvisita = new  VendedorVisita();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=vendedorvisitaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vendedorvisita = new  VendedorVisita();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =vendedorvisitaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vendedorvisita = new  VendedorVisita();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=vendedorvisitaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		  		  
        try {			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		  		  
        try {
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vendedorvisita = new  VendedorVisita();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisita=vendedorvisitaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisita);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisita);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vendedorvisita = new  VendedorVisita();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisita=vendedorvisitaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisita);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisita);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		  		  
        try {
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVendedorVisitasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getTodosVendedorVisitasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosVendedorVisitas(String sFinalQuery,Pagination pagination)throws Exception {
		vendedorvisitas = new  ArrayList<VendedorVisita>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVendedorVisita(vendedorvisitas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVendedorVisita(VendedorVisita vendedorvisita) throws Exception {
		Boolean estaValidado=false;
		
		if(vendedorvisita.getIsNew() || vendedorvisita.getIsChanged()) { 
			this.invalidValues = vendedorvisitaValidator.getInvalidValues(vendedorvisita);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(vendedorvisita);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVendedorVisita(List<VendedorVisita> VendedorVisitas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(VendedorVisita vendedorvisitaLocal:vendedorvisitas) {				
			estaValidadoObjeto=this.validarGuardarVendedorVisita(vendedorvisitaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVendedorVisita(List<VendedorVisita> VendedorVisitas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVendedorVisita(vendedorvisitas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVendedorVisita(VendedorVisita VendedorVisita) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVendedorVisita(vendedorvisita)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(VendedorVisita vendedorvisita) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+vendedorvisita.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VendedorVisitaConstantesFunciones.getVendedorVisitaLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"vendedorvisita","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VendedorVisitaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VendedorVisitaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVendedorVisitaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-saveVendedorVisitaWithConnection");connexion.begin();			
			
			VendedorVisitaLogicAdditional.checkVendedorVisitaToSave(this.vendedorvisita,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VendedorVisitaLogicAdditional.updateVendedorVisitaToSave(this.vendedorvisita,this.arrDatoGeneral);
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vendedorvisita,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVendedorVisita();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVendedorVisita(this.vendedorvisita)) {
				VendedorVisitaDataAccess.save(this.vendedorvisita, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.vendedorvisita,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VendedorVisitaLogicAdditional.checkVendedorVisitaToSaveAfter(this.vendedorvisita,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVendedorVisita();
			
			connexion.commit();			
			
			if(this.vendedorvisita.getIsDeleted()) {
				this.vendedorvisita=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVendedorVisita()throws Exception {	
		try {	
			
			VendedorVisitaLogicAdditional.checkVendedorVisitaToSave(this.vendedorvisita,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VendedorVisitaLogicAdditional.updateVendedorVisitaToSave(this.vendedorvisita,this.arrDatoGeneral);
			
			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vendedorvisita,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVendedorVisita(this.vendedorvisita)) {			
				VendedorVisitaDataAccess.save(this.vendedorvisita, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.vendedorvisita,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VendedorVisitaLogicAdditional.checkVendedorVisitaToSaveAfter(this.vendedorvisita,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.vendedorvisita.getIsDeleted()) {
				this.vendedorvisita=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVendedorVisitasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-saveVendedorVisitasWithConnection");connexion.begin();			
			
			VendedorVisitaLogicAdditional.checkVendedorVisitaToSaves(vendedorvisitas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVendedorVisitas();
			
			Boolean validadoTodosVendedorVisita=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VendedorVisita vendedorvisitaLocal:vendedorvisitas) {		
				if(vendedorvisitaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VendedorVisitaLogicAdditional.updateVendedorVisitaToSave(vendedorvisitaLocal,this.arrDatoGeneral);
	        	
				VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vendedorvisitaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVendedorVisita(vendedorvisitaLocal)) {
					VendedorVisitaDataAccess.save(vendedorvisitaLocal, connexion);				
				} else {
					validadoTodosVendedorVisita=false;
				}
			}
			
			if(!validadoTodosVendedorVisita) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VendedorVisitaLogicAdditional.checkVendedorVisitaToSavesAfter(vendedorvisitas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVendedorVisitas();
			
			connexion.commit();		
			
			this.quitarVendedorVisitasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVendedorVisitas()throws Exception {				
		 try {	
			VendedorVisitaLogicAdditional.checkVendedorVisitaToSaves(vendedorvisitas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVendedorVisita=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VendedorVisita vendedorvisitaLocal:vendedorvisitas) {				
				if(vendedorvisitaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VendedorVisitaLogicAdditional.updateVendedorVisitaToSave(vendedorvisitaLocal,this.arrDatoGeneral);
	        	
				VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vendedorvisitaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVendedorVisita(vendedorvisitaLocal)) {				
					VendedorVisitaDataAccess.save(vendedorvisitaLocal, connexion);				
				} else {
					validadoTodosVendedorVisita=false;
				}
			}
			
			if(!validadoTodosVendedorVisita) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VendedorVisitaLogicAdditional.checkVendedorVisitaToSavesAfter(vendedorvisitas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVendedorVisitasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VendedorVisitaParameterReturnGeneral procesarAccionVendedorVisitas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VendedorVisita> vendedorvisitas,VendedorVisitaParameterReturnGeneral vendedorvisitaParameterGeneral)throws Exception {
		 try {	
			VendedorVisitaParameterReturnGeneral vendedorvisitaReturnGeneral=new VendedorVisitaParameterReturnGeneral();
	
			VendedorVisitaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vendedorvisitas,vendedorvisitaParameterGeneral,vendedorvisitaReturnGeneral);
			
			return vendedorvisitaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VendedorVisitaParameterReturnGeneral procesarAccionVendedorVisitasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VendedorVisita> vendedorvisitas,VendedorVisitaParameterReturnGeneral vendedorvisitaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-procesarAccionVendedorVisitasWithConnection");connexion.begin();			
			
			VendedorVisitaParameterReturnGeneral vendedorvisitaReturnGeneral=new VendedorVisitaParameterReturnGeneral();
	
			VendedorVisitaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vendedorvisitas,vendedorvisitaParameterGeneral,vendedorvisitaReturnGeneral);
			
			this.connexion.commit();
			
			return vendedorvisitaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VendedorVisitaParameterReturnGeneral procesarEventosVendedorVisitas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VendedorVisita> vendedorvisitas,VendedorVisita vendedorvisita,VendedorVisitaParameterReturnGeneral vendedorvisitaParameterGeneral,Boolean isEsNuevoVendedorVisita,ArrayList<Classe> clases)throws Exception {
		 try {	
			VendedorVisitaParameterReturnGeneral vendedorvisitaReturnGeneral=new VendedorVisitaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vendedorvisitaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VendedorVisitaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vendedorvisitas,vendedorvisita,vendedorvisitaParameterGeneral,vendedorvisitaReturnGeneral,isEsNuevoVendedorVisita,clases);
			
			return vendedorvisitaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VendedorVisitaParameterReturnGeneral procesarEventosVendedorVisitasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VendedorVisita> vendedorvisitas,VendedorVisita vendedorvisita,VendedorVisitaParameterReturnGeneral vendedorvisitaParameterGeneral,Boolean isEsNuevoVendedorVisita,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-procesarEventosVendedorVisitasWithConnection");connexion.begin();			
			
			VendedorVisitaParameterReturnGeneral vendedorvisitaReturnGeneral=new VendedorVisitaParameterReturnGeneral();
	
			vendedorvisitaReturnGeneral.setVendedorVisita(vendedorvisita);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vendedorvisitaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VendedorVisitaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vendedorvisitas,vendedorvisita,vendedorvisitaParameterGeneral,vendedorvisitaReturnGeneral,isEsNuevoVendedorVisita,clases);
			
			this.connexion.commit();
			
			return vendedorvisitaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VendedorVisitaParameterReturnGeneral procesarImportacionVendedorVisitasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VendedorVisitaParameterReturnGeneral vendedorvisitaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-procesarImportacionVendedorVisitasWithConnection");connexion.begin();			
			
			VendedorVisitaParameterReturnGeneral vendedorvisitaReturnGeneral=new VendedorVisitaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.vendedorvisitas=new ArrayList<VendedorVisita>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.vendedorvisita=new VendedorVisita();
				
				
				if(conColumnasBase) {this.vendedorvisita.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.vendedorvisita.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.vendedorvisita.setvisita_real(Double.parseDouble(arrColumnas[iColumn++]));
				this.vendedorvisita.setvisita_propuesta(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.vendedorvisitas.add(this.vendedorvisita);
			}
			
			this.saveVendedorVisitas();
			
			this.connexion.commit();
			
			vendedorvisitaReturnGeneral.setConRetornoEstaProcesado(true);
			vendedorvisitaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return vendedorvisitaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVendedorVisitasEliminados() throws Exception {				
		
		List<VendedorVisita> vendedorvisitasAux= new ArrayList<VendedorVisita>();
		
		for(VendedorVisita vendedorvisita:vendedorvisitas) {
			if(!vendedorvisita.getIsDeleted()) {
				vendedorvisitasAux.add(vendedorvisita);
			}
		}
		
		vendedorvisitas=vendedorvisitasAux;
	}
	
	public void quitarVendedorVisitasNulos() throws Exception {				
		
		List<VendedorVisita> vendedorvisitasAux= new ArrayList<VendedorVisita>();
		
		for(VendedorVisita vendedorvisita : this.vendedorvisitas) {
			if(vendedorvisita==null) {
				vendedorvisitasAux.add(vendedorvisita);
			}
		}
		
		//this.vendedorvisitas=vendedorvisitasAux;
		
		this.vendedorvisitas.removeAll(vendedorvisitasAux);
	}
	
	public void getSetVersionRowVendedorVisitaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(vendedorvisita.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((vendedorvisita.getIsDeleted() || (vendedorvisita.getIsChanged()&&!vendedorvisita.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=vendedorvisitaDataAccess.getSetVersionRowVendedorVisita(connexion,vendedorvisita.getId());
				
				if(!vendedorvisita.getVersionRow().equals(timestamp)) {	
					vendedorvisita.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				vendedorvisita.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVendedorVisita()throws Exception {	
		
		if(vendedorvisita.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((vendedorvisita.getIsDeleted() || (vendedorvisita.getIsChanged()&&!vendedorvisita.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=vendedorvisitaDataAccess.getSetVersionRowVendedorVisita(connexion,vendedorvisita.getId());
			
			try {							
				if(!vendedorvisita.getVersionRow().equals(timestamp)) {	
					vendedorvisita.setVersionRow(timestamp);
				}
				
				vendedorvisita.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVendedorVisitasWithConnection()throws Exception {	
		if(vendedorvisitas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(VendedorVisita vendedorvisitaAux:vendedorvisitas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(vendedorvisitaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vendedorvisitaAux.getIsDeleted() || (vendedorvisitaAux.getIsChanged()&&!vendedorvisitaAux.getIsNew())) {
						
						timestamp=vendedorvisitaDataAccess.getSetVersionRowVendedorVisita(connexion,vendedorvisitaAux.getId());
						
						if(!vendedorvisita.getVersionRow().equals(timestamp)) {	
							vendedorvisitaAux.setVersionRow(timestamp);
						}
								
						vendedorvisitaAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVendedorVisitas()throws Exception {	
		if(vendedorvisitas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(VendedorVisita vendedorvisitaAux:vendedorvisitas) {
					if(vendedorvisitaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vendedorvisitaAux.getIsDeleted() || (vendedorvisitaAux.getIsChanged()&&!vendedorvisitaAux.getIsNew())) {
						
						timestamp=vendedorvisitaDataAccess.getSetVersionRowVendedorVisita(connexion,vendedorvisitaAux.getId());
						
						if(!vendedorvisitaAux.getVersionRow().equals(timestamp)) {	
							vendedorvisitaAux.setVersionRow(timestamp);
						}
						
													
						vendedorvisitaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VendedorVisitaParameterReturnGeneral cargarCombosLoteForeignKeyVendedorVisitaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalVendedor,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		VendedorVisitaParameterReturnGeneral  vendedorvisitaReturnGeneral =new VendedorVisitaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-cargarCombosLoteForeignKeyVendedorVisitaWithConnection");connexion.begin();
			
			vendedorvisitaReturnGeneral =new VendedorVisitaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vendedorvisitaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			vendedorvisitaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			vendedorvisitaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			vendedorvisitaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			vendedorvisitaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			vendedorvisitaReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return vendedorvisitaReturnGeneral;
	}
	
	public VendedorVisitaParameterReturnGeneral cargarCombosLoteForeignKeyVendedorVisita(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalVendedor,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		VendedorVisitaParameterReturnGeneral  vendedorvisitaReturnGeneral =new VendedorVisitaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			vendedorvisitaReturnGeneral =new VendedorVisitaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vendedorvisitaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			vendedorvisitaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			vendedorvisitaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			vendedorvisitaReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			vendedorvisitaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			vendedorvisitaReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return vendedorvisitaReturnGeneral;
	}
	
	
	public void deepLoad(VendedorVisita vendedorvisita,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VendedorVisitaLogicAdditional.updateVendedorVisitaToGet(vendedorvisita,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vendedorvisita.setEmpresa(vendedorvisitaDataAccess.getEmpresa(connexion,vendedorvisita));
		vendedorvisita.setEjercicio(vendedorvisitaDataAccess.getEjercicio(connexion,vendedorvisita));
		vendedorvisita.setPeriodo(vendedorvisitaDataAccess.getPeriodo(connexion,vendedorvisita));
		vendedorvisita.setVendedor(vendedorvisitaDataAccess.getVendedor(connexion,vendedorvisita));
		vendedorvisita.setAnio(vendedorvisitaDataAccess.getAnio(connexion,vendedorvisita));
		vendedorvisita.setMes(vendedorvisitaDataAccess.getMes(connexion,vendedorvisita));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vendedorvisita.setEmpresa(vendedorvisitaDataAccess.getEmpresa(connexion,vendedorvisita));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				vendedorvisita.setEjercicio(vendedorvisitaDataAccess.getEjercicio(connexion,vendedorvisita));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				vendedorvisita.setPeriodo(vendedorvisitaDataAccess.getPeriodo(connexion,vendedorvisita));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				vendedorvisita.setVendedor(vendedorvisitaDataAccess.getVendedor(connexion,vendedorvisita));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				vendedorvisita.setAnio(vendedorvisitaDataAccess.getAnio(connexion,vendedorvisita));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				vendedorvisita.setMes(vendedorvisitaDataAccess.getMes(connexion,vendedorvisita));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setEmpresa(vendedorvisitaDataAccess.getEmpresa(connexion,vendedorvisita));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setEjercicio(vendedorvisitaDataAccess.getEjercicio(connexion,vendedorvisita));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setPeriodo(vendedorvisitaDataAccess.getPeriodo(connexion,vendedorvisita));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setVendedor(vendedorvisitaDataAccess.getVendedor(connexion,vendedorvisita));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setAnio(vendedorvisitaDataAccess.getAnio(connexion,vendedorvisita));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setMes(vendedorvisitaDataAccess.getMes(connexion,vendedorvisita));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vendedorvisita.setEmpresa(vendedorvisitaDataAccess.getEmpresa(connexion,vendedorvisita));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vendedorvisita.getEmpresa(),isDeep,deepLoadType,clases);
				
		vendedorvisita.setEjercicio(vendedorvisitaDataAccess.getEjercicio(connexion,vendedorvisita));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(vendedorvisita.getEjercicio(),isDeep,deepLoadType,clases);
				
		vendedorvisita.setPeriodo(vendedorvisitaDataAccess.getPeriodo(connexion,vendedorvisita));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(vendedorvisita.getPeriodo(),isDeep,deepLoadType,clases);
				
		vendedorvisita.setVendedor(vendedorvisitaDataAccess.getVendedor(connexion,vendedorvisita));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(vendedorvisita.getVendedor(),isDeep,deepLoadType,clases);
				
		vendedorvisita.setAnio(vendedorvisitaDataAccess.getAnio(connexion,vendedorvisita));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(vendedorvisita.getAnio(),isDeep,deepLoadType,clases);
				
		vendedorvisita.setMes(vendedorvisitaDataAccess.getMes(connexion,vendedorvisita));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(vendedorvisita.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vendedorvisita.setEmpresa(vendedorvisitaDataAccess.getEmpresa(connexion,vendedorvisita));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(vendedorvisita.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				vendedorvisita.setEjercicio(vendedorvisitaDataAccess.getEjercicio(connexion,vendedorvisita));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(vendedorvisita.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				vendedorvisita.setPeriodo(vendedorvisitaDataAccess.getPeriodo(connexion,vendedorvisita));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(vendedorvisita.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				vendedorvisita.setVendedor(vendedorvisitaDataAccess.getVendedor(connexion,vendedorvisita));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(vendedorvisita.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				vendedorvisita.setAnio(vendedorvisitaDataAccess.getAnio(connexion,vendedorvisita));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(vendedorvisita.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				vendedorvisita.setMes(vendedorvisitaDataAccess.getMes(connexion,vendedorvisita));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(vendedorvisita.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setEmpresa(vendedorvisitaDataAccess.getEmpresa(connexion,vendedorvisita));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(vendedorvisita.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setEjercicio(vendedorvisitaDataAccess.getEjercicio(connexion,vendedorvisita));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(vendedorvisita.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setPeriodo(vendedorvisitaDataAccess.getPeriodo(connexion,vendedorvisita));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(vendedorvisita.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setVendedor(vendedorvisitaDataAccess.getVendedor(connexion,vendedorvisita));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(vendedorvisita.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setAnio(vendedorvisitaDataAccess.getAnio(connexion,vendedorvisita));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(vendedorvisita.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vendedorvisita.setMes(vendedorvisitaDataAccess.getMes(connexion,vendedorvisita));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(vendedorvisita.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(VendedorVisita vendedorvisita,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VendedorVisitaLogicAdditional.updateVendedorVisitaToSave(vendedorvisita,this.arrDatoGeneral);
			
VendedorVisitaDataAccess.save(vendedorvisita, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vendedorvisita.getEmpresa(),connexion);

		EjercicioDataAccess.save(vendedorvisita.getEjercicio(),connexion);

		PeriodoDataAccess.save(vendedorvisita.getPeriodo(),connexion);

		VendedorDataAccess.save(vendedorvisita.getVendedor(),connexion);

		AnioDataAccess.save(vendedorvisita.getAnio(),connexion);

		MesDataAccess.save(vendedorvisita.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vendedorvisita.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(vendedorvisita.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(vendedorvisita.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(vendedorvisita.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(vendedorvisita.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(vendedorvisita.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vendedorvisita.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vendedorvisita.getEmpresa(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(vendedorvisita.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(vendedorvisita.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(vendedorvisita.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(vendedorvisita.getPeriodo(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(vendedorvisita.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(vendedorvisita.getVendedor(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(vendedorvisita.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(vendedorvisita.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(vendedorvisita.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(vendedorvisita.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vendedorvisita.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(vendedorvisita.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(vendedorvisita.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(vendedorvisita.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(vendedorvisita.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(vendedorvisita.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(vendedorvisita.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(vendedorvisita.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(vendedorvisita.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(vendedorvisita.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(vendedorvisita.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(vendedorvisita.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(VendedorVisita.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(vendedorvisita,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(vendedorvisita);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.vendedorvisita,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisita);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(VendedorVisita.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(vendedorvisitas!=null) {
				for(VendedorVisita vendedorvisita:vendedorvisitas) {
					this.deepLoad(vendedorvisita,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(vendedorvisitas);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(vendedorvisitas!=null) {
				for(VendedorVisita vendedorvisita:vendedorvisitas) {
					this.deepLoad(vendedorvisita,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(vendedorvisitas);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(VendedorVisita.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(vendedorvisita,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(VendedorVisita.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(vendedorvisitas!=null) {
				for(VendedorVisita vendedorvisita:vendedorvisitas) {
					this.deepSave(vendedorvisita,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(vendedorvisitas!=null) {
				for(VendedorVisita vendedorvisita:vendedorvisitas) {
					this.deepSave(vendedorvisita,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVendedorVisitasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,VendedorVisitaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorVisitasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,VendedorVisitaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorVisitasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,VendedorVisitaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorVisitasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,VendedorVisitaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorVisitasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VendedorVisitaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorVisitasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VendedorVisitaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorVisitasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,VendedorVisitaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorVisitasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,VendedorVisitaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorVisitasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,VendedorVisitaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorVisitasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,VendedorVisitaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVendedorVisitasFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VendedorVisita.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,VendedorVisitaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVendedorVisitasFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,VendedorVisitaConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			VendedorVisitaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vendedorvisitas=vendedorvisitaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VendedorVisitaConstantesFunciones.refrescarForeignKeysDescripcionesVendedorVisita(this.vendedorvisitas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VendedorVisitaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VendedorVisitaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,VendedorVisita vendedorvisita,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VendedorVisitaConstantesFunciones.ISCONAUDITORIA) {
				if(vendedorvisita.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VendedorVisitaDataAccess.TABLENAME, vendedorvisita.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VendedorVisitaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VendedorVisitaLogic.registrarAuditoriaDetallesVendedorVisita(connexion,vendedorvisita,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(vendedorvisita.getIsDeleted()) {
					/*if(!vendedorvisita.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VendedorVisitaDataAccess.TABLENAME, vendedorvisita.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VendedorVisitaLogic.registrarAuditoriaDetallesVendedorVisita(connexion,vendedorvisita,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VendedorVisitaDataAccess.TABLENAME, vendedorvisita.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(vendedorvisita.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VendedorVisitaDataAccess.TABLENAME, vendedorvisita.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VendedorVisitaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VendedorVisitaLogic.registrarAuditoriaDetallesVendedorVisita(connexion,vendedorvisita,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVendedorVisita(Connexion connexion,VendedorVisita vendedorvisita)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(vendedorvisita.getIsNew()||!vendedorvisita.getid_empresa().equals(vendedorvisita.getVendedorVisitaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedorvisita.getVendedorVisitaOriginal().getid_empresa()!=null)
				{
					strValorActual=vendedorvisita.getVendedorVisitaOriginal().getid_empresa().toString();
				}
				if(vendedorvisita.getid_empresa()!=null)
				{
					strValorNuevo=vendedorvisita.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorVisitaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(vendedorvisita.getIsNew()||!vendedorvisita.getid_ejercicio().equals(vendedorvisita.getVendedorVisitaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedorvisita.getVendedorVisitaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=vendedorvisita.getVendedorVisitaOriginal().getid_ejercicio().toString();
				}
				if(vendedorvisita.getid_ejercicio()!=null)
				{
					strValorNuevo=vendedorvisita.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorVisitaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(vendedorvisita.getIsNew()||!vendedorvisita.getid_periodo().equals(vendedorvisita.getVendedorVisitaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedorvisita.getVendedorVisitaOriginal().getid_periodo()!=null)
				{
					strValorActual=vendedorvisita.getVendedorVisitaOriginal().getid_periodo().toString();
				}
				if(vendedorvisita.getid_periodo()!=null)
				{
					strValorNuevo=vendedorvisita.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorVisitaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(vendedorvisita.getIsNew()||!vendedorvisita.getid_vendedor().equals(vendedorvisita.getVendedorVisitaOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedorvisita.getVendedorVisitaOriginal().getid_vendedor()!=null)
				{
					strValorActual=vendedorvisita.getVendedorVisitaOriginal().getid_vendedor().toString();
				}
				if(vendedorvisita.getid_vendedor()!=null)
				{
					strValorNuevo=vendedorvisita.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorVisitaConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(vendedorvisita.getIsNew()||!vendedorvisita.getvisita_real().equals(vendedorvisita.getVendedorVisitaOriginal().getvisita_real()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedorvisita.getVendedorVisitaOriginal().getvisita_real()!=null)
				{
					strValorActual=vendedorvisita.getVendedorVisitaOriginal().getvisita_real().toString();
				}
				if(vendedorvisita.getvisita_real()!=null)
				{
					strValorNuevo=vendedorvisita.getvisita_real().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorVisitaConstantesFunciones.VISITAREAL,strValorActual,strValorNuevo);
			}	
			
			if(vendedorvisita.getIsNew()||!vendedorvisita.getvisita_propuesta().equals(vendedorvisita.getVendedorVisitaOriginal().getvisita_propuesta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedorvisita.getVendedorVisitaOriginal().getvisita_propuesta()!=null)
				{
					strValorActual=vendedorvisita.getVendedorVisitaOriginal().getvisita_propuesta().toString();
				}
				if(vendedorvisita.getvisita_propuesta()!=null)
				{
					strValorNuevo=vendedorvisita.getvisita_propuesta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorVisitaConstantesFunciones.VISITAPROPUESTA,strValorActual,strValorNuevo);
			}	
			
			if(vendedorvisita.getIsNew()||!vendedorvisita.getid_anio().equals(vendedorvisita.getVendedorVisitaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedorvisita.getVendedorVisitaOriginal().getid_anio()!=null)
				{
					strValorActual=vendedorvisita.getVendedorVisitaOriginal().getid_anio().toString();
				}
				if(vendedorvisita.getid_anio()!=null)
				{
					strValorNuevo=vendedorvisita.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorVisitaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(vendedorvisita.getIsNew()||!vendedorvisita.getid_mes().equals(vendedorvisita.getVendedorVisitaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vendedorvisita.getVendedorVisitaOriginal().getid_mes()!=null)
				{
					strValorActual=vendedorvisita.getVendedorVisitaOriginal().getid_mes().toString();
				}
				if(vendedorvisita.getid_mes()!=null)
				{
					strValorNuevo=vendedorvisita.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VendedorVisitaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVendedorVisitaRelacionesWithConnection(VendedorVisita vendedorvisita) throws Exception {

		if(!vendedorvisita.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVendedorVisitaRelacionesBase(vendedorvisita,true);
		}
	}

	public void saveVendedorVisitaRelaciones(VendedorVisita vendedorvisita)throws Exception {

		if(!vendedorvisita.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVendedorVisitaRelacionesBase(vendedorvisita,false);
		}
	}

	public void saveVendedorVisitaRelacionesBase(VendedorVisita vendedorvisita,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("VendedorVisita-saveRelacionesWithConnection");}
	

			this.setVendedorVisita(vendedorvisita);

			if(VendedorVisitaLogicAdditional.validarSaveRelaciones(vendedorvisita,this)) {

				VendedorVisitaLogicAdditional.updateRelacionesToSave(vendedorvisita,this);

				if((vendedorvisita.getIsNew()||vendedorvisita.getIsChanged())&&!vendedorvisita.getIsDeleted()) {
					this.saveVendedorVisita();
					this.saveVendedorVisitaRelacionesDetalles();

				} else if(vendedorvisita.getIsDeleted()) {
					this.saveVendedorVisitaRelacionesDetalles();
					this.saveVendedorVisita();
				}

				VendedorVisitaLogicAdditional.updateRelacionesToSaveAfter(vendedorvisita,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveVendedorVisitaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVendedorVisita(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VendedorVisitaConstantesFunciones.getClassesForeignKeysOfVendedorVisita(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVendedorVisita(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VendedorVisitaConstantesFunciones.getClassesRelationshipsOfVendedorVisita(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
