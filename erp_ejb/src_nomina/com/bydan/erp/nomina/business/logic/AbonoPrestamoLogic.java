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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.AbonoPrestamoConstantesFunciones;
import com.bydan.erp.nomina.util.AbonoPrestamoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.AbonoPrestamoParameterGeneral;
import com.bydan.erp.nomina.business.entity.AbonoPrestamo;
import com.bydan.erp.nomina.business.logic.AbonoPrestamoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class AbonoPrestamoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AbonoPrestamoLogic.class);
	
	protected AbonoPrestamoDataAccess abonoprestamoDataAccess; 	
	protected AbonoPrestamo abonoprestamo;
	protected List<AbonoPrestamo> abonoprestamos;
	protected Object abonoprestamoObject;	
	protected List<Object> abonoprestamosObject;
	
	public static ClassValidator<AbonoPrestamo> abonoprestamoValidator = new ClassValidator<AbonoPrestamo>(AbonoPrestamo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AbonoPrestamoLogicAdditional abonoprestamoLogicAdditional=null;
	
	public AbonoPrestamoLogicAdditional getAbonoPrestamoLogicAdditional() {
		return this.abonoprestamoLogicAdditional;
	}
	
	public void setAbonoPrestamoLogicAdditional(AbonoPrestamoLogicAdditional abonoprestamoLogicAdditional) {
		try {
			this.abonoprestamoLogicAdditional=abonoprestamoLogicAdditional;
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
	
	
	
	
	public  AbonoPrestamoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.abonoprestamoDataAccess = new AbonoPrestamoDataAccess();
			
			this.abonoprestamos= new ArrayList<AbonoPrestamo>();
			this.abonoprestamo= new AbonoPrestamo();
			
			this.abonoprestamoObject=new Object();
			this.abonoprestamosObject=new ArrayList<Object>();
				
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
			
			this.abonoprestamoDataAccess.setConnexionType(this.connexionType);
			this.abonoprestamoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AbonoPrestamoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.abonoprestamoDataAccess = new AbonoPrestamoDataAccess();
			this.abonoprestamos= new ArrayList<AbonoPrestamo>();
			this.abonoprestamo= new AbonoPrestamo();
			this.abonoprestamoObject=new Object();
			this.abonoprestamosObject=new ArrayList<Object>();
			
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
			
			this.abonoprestamoDataAccess.setConnexionType(this.connexionType);
			this.abonoprestamoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AbonoPrestamo getAbonoPrestamo() throws Exception {	
		AbonoPrestamoLogicAdditional.checkAbonoPrestamoToGet(abonoprestamo,this.datosCliente,this.arrDatoGeneral);
		AbonoPrestamoLogicAdditional.updateAbonoPrestamoToGet(abonoprestamo,this.arrDatoGeneral);
		
		return abonoprestamo;
	}
		
	public void setAbonoPrestamo(AbonoPrestamo newAbonoPrestamo) {
		this.abonoprestamo = newAbonoPrestamo;
	}
	
	public AbonoPrestamoDataAccess getAbonoPrestamoDataAccess() {
		return abonoprestamoDataAccess;
	}
	
	public void setAbonoPrestamoDataAccess(AbonoPrestamoDataAccess newabonoprestamoDataAccess) {
		this.abonoprestamoDataAccess = newabonoprestamoDataAccess;
	}
	
	public List<AbonoPrestamo> getAbonoPrestamos() throws Exception {		
		this.quitarAbonoPrestamosNulos();
		
		AbonoPrestamoLogicAdditional.checkAbonoPrestamoToGets(abonoprestamos,this.datosCliente,this.arrDatoGeneral);
		
		for (AbonoPrestamo abonoprestamoLocal: abonoprestamos ) {
			AbonoPrestamoLogicAdditional.updateAbonoPrestamoToGet(abonoprestamoLocal,this.arrDatoGeneral);
		}
		
		return abonoprestamos;
	}
	
	public void setAbonoPrestamos(List<AbonoPrestamo> newAbonoPrestamos) {
		this.abonoprestamos = newAbonoPrestamos;
	}
	
	public Object getAbonoPrestamoObject() {	
		this.abonoprestamoObject=this.abonoprestamoDataAccess.getEntityObject();
		return this.abonoprestamoObject;
	}
		
	public void setAbonoPrestamoObject(Object newAbonoPrestamoObject) {
		this.abonoprestamoObject = newAbonoPrestamoObject;
	}
	
	public List<Object> getAbonoPrestamosObject() {		
		this.abonoprestamosObject=this.abonoprestamoDataAccess.getEntitiesObject();
		return this.abonoprestamosObject;
	}
		
	public void setAbonoPrestamosObject(List<Object> newAbonoPrestamosObject) {
		this.abonoprestamosObject = newAbonoPrestamosObject;
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
		
		if(this.abonoprestamoDataAccess!=null) {
			this.abonoprestamoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			abonoprestamoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			abonoprestamoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		abonoprestamo = new  AbonoPrestamo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			abonoprestamo=abonoprestamoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.abonoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamo);
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
		abonoprestamo = new  AbonoPrestamo();
		  		  
        try {
			
			abonoprestamo=abonoprestamoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.abonoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		abonoprestamo = new  AbonoPrestamo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			abonoprestamo=abonoprestamoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.abonoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamo);
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
		abonoprestamo = new  AbonoPrestamo();
		  		  
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
		abonoprestamo = new  AbonoPrestamo();
		  		  
        try {
			
			abonoprestamo=abonoprestamoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.abonoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		abonoprestamo = new  AbonoPrestamo();
		  		  
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
		abonoprestamo = new  AbonoPrestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =abonoprestamoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		abonoprestamo = new  AbonoPrestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=abonoprestamoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		abonoprestamo = new  AbonoPrestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =abonoprestamoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		abonoprestamo = new  AbonoPrestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=abonoprestamoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		abonoprestamo = new  AbonoPrestamo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =abonoprestamoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		abonoprestamo = new  AbonoPrestamo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=abonoprestamoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
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
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		  		  
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
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		  		  
        try {			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		  		  
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
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
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
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		  		  
        try {
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
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
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
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
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		abonoprestamo = new  AbonoPrestamo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamo=abonoprestamoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamo);
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
		abonoprestamo = new  AbonoPrestamo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamo=abonoprestamoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
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
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		  		  
        try {
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAbonoPrestamosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getTodosAbonoPrestamosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
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
	
	public  void  getTodosAbonoPrestamos(String sFinalQuery,Pagination pagination)throws Exception {
		abonoprestamos = new  ArrayList<AbonoPrestamo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAbonoPrestamo(abonoprestamos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAbonoPrestamo(AbonoPrestamo abonoprestamo) throws Exception {
		Boolean estaValidado=false;
		
		if(abonoprestamo.getIsNew() || abonoprestamo.getIsChanged()) { 
			this.invalidValues = abonoprestamoValidator.getInvalidValues(abonoprestamo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(abonoprestamo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAbonoPrestamo(List<AbonoPrestamo> AbonoPrestamos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AbonoPrestamo abonoprestamoLocal:abonoprestamos) {				
			estaValidadoObjeto=this.validarGuardarAbonoPrestamo(abonoprestamoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAbonoPrestamo(List<AbonoPrestamo> AbonoPrestamos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAbonoPrestamo(abonoprestamos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAbonoPrestamo(AbonoPrestamo AbonoPrestamo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAbonoPrestamo(abonoprestamo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AbonoPrestamo abonoprestamo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+abonoprestamo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AbonoPrestamoConstantesFunciones.getAbonoPrestamoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"abonoprestamo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AbonoPrestamoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AbonoPrestamoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAbonoPrestamoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-saveAbonoPrestamoWithConnection");connexion.begin();			
			
			AbonoPrestamoLogicAdditional.checkAbonoPrestamoToSave(this.abonoprestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AbonoPrestamoLogicAdditional.updateAbonoPrestamoToSave(this.abonoprestamo,this.arrDatoGeneral);
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.abonoprestamo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAbonoPrestamo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAbonoPrestamo(this.abonoprestamo)) {
				AbonoPrestamoDataAccess.save(this.abonoprestamo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.abonoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AbonoPrestamoLogicAdditional.checkAbonoPrestamoToSaveAfter(this.abonoprestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAbonoPrestamo();
			
			connexion.commit();			
			
			if(this.abonoprestamo.getIsDeleted()) {
				this.abonoprestamo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAbonoPrestamo()throws Exception {	
		try {	
			
			AbonoPrestamoLogicAdditional.checkAbonoPrestamoToSave(this.abonoprestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AbonoPrestamoLogicAdditional.updateAbonoPrestamoToSave(this.abonoprestamo,this.arrDatoGeneral);
			
			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.abonoprestamo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAbonoPrestamo(this.abonoprestamo)) {			
				AbonoPrestamoDataAccess.save(this.abonoprestamo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.abonoprestamo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AbonoPrestamoLogicAdditional.checkAbonoPrestamoToSaveAfter(this.abonoprestamo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.abonoprestamo.getIsDeleted()) {
				this.abonoprestamo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAbonoPrestamosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-saveAbonoPrestamosWithConnection");connexion.begin();			
			
			AbonoPrestamoLogicAdditional.checkAbonoPrestamoToSaves(abonoprestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAbonoPrestamos();
			
			Boolean validadoTodosAbonoPrestamo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AbonoPrestamo abonoprestamoLocal:abonoprestamos) {		
				if(abonoprestamoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AbonoPrestamoLogicAdditional.updateAbonoPrestamoToSave(abonoprestamoLocal,this.arrDatoGeneral);
	        	
				AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),abonoprestamoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAbonoPrestamo(abonoprestamoLocal)) {
					AbonoPrestamoDataAccess.save(abonoprestamoLocal, connexion);				
				} else {
					validadoTodosAbonoPrestamo=false;
				}
			}
			
			if(!validadoTodosAbonoPrestamo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AbonoPrestamoLogicAdditional.checkAbonoPrestamoToSavesAfter(abonoprestamos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAbonoPrestamos();
			
			connexion.commit();		
			
			this.quitarAbonoPrestamosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAbonoPrestamos()throws Exception {				
		 try {	
			AbonoPrestamoLogicAdditional.checkAbonoPrestamoToSaves(abonoprestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAbonoPrestamo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AbonoPrestamo abonoprestamoLocal:abonoprestamos) {				
				if(abonoprestamoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AbonoPrestamoLogicAdditional.updateAbonoPrestamoToSave(abonoprestamoLocal,this.arrDatoGeneral);
	        	
				AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),abonoprestamoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAbonoPrestamo(abonoprestamoLocal)) {				
					AbonoPrestamoDataAccess.save(abonoprestamoLocal, connexion);				
				} else {
					validadoTodosAbonoPrestamo=false;
				}
			}
			
			if(!validadoTodosAbonoPrestamo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AbonoPrestamoLogicAdditional.checkAbonoPrestamoToSavesAfter(abonoprestamos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAbonoPrestamosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AbonoPrestamoParameterReturnGeneral procesarAccionAbonoPrestamos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AbonoPrestamo> abonoprestamos,AbonoPrestamoParameterReturnGeneral abonoprestamoParameterGeneral)throws Exception {
		 try {	
			AbonoPrestamoParameterReturnGeneral abonoprestamoReturnGeneral=new AbonoPrestamoParameterReturnGeneral();
	
			AbonoPrestamoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,abonoprestamos,abonoprestamoParameterGeneral,abonoprestamoReturnGeneral);
			
			return abonoprestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AbonoPrestamoParameterReturnGeneral procesarAccionAbonoPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AbonoPrestamo> abonoprestamos,AbonoPrestamoParameterReturnGeneral abonoprestamoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-procesarAccionAbonoPrestamosWithConnection");connexion.begin();			
			
			AbonoPrestamoParameterReturnGeneral abonoprestamoReturnGeneral=new AbonoPrestamoParameterReturnGeneral();
	
			AbonoPrestamoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,abonoprestamos,abonoprestamoParameterGeneral,abonoprestamoReturnGeneral);
			
			this.connexion.commit();
			
			return abonoprestamoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AbonoPrestamoParameterReturnGeneral procesarEventosAbonoPrestamos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AbonoPrestamo> abonoprestamos,AbonoPrestamo abonoprestamo,AbonoPrestamoParameterReturnGeneral abonoprestamoParameterGeneral,Boolean isEsNuevoAbonoPrestamo,ArrayList<Classe> clases)throws Exception {
		 try {	
			AbonoPrestamoParameterReturnGeneral abonoprestamoReturnGeneral=new AbonoPrestamoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				abonoprestamoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AbonoPrestamoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,abonoprestamos,abonoprestamo,abonoprestamoParameterGeneral,abonoprestamoReturnGeneral,isEsNuevoAbonoPrestamo,clases);
			
			return abonoprestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AbonoPrestamoParameterReturnGeneral procesarEventosAbonoPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AbonoPrestamo> abonoprestamos,AbonoPrestamo abonoprestamo,AbonoPrestamoParameterReturnGeneral abonoprestamoParameterGeneral,Boolean isEsNuevoAbonoPrestamo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-procesarEventosAbonoPrestamosWithConnection");connexion.begin();			
			
			AbonoPrestamoParameterReturnGeneral abonoprestamoReturnGeneral=new AbonoPrestamoParameterReturnGeneral();
	
			abonoprestamoReturnGeneral.setAbonoPrestamo(abonoprestamo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				abonoprestamoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AbonoPrestamoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,abonoprestamos,abonoprestamo,abonoprestamoParameterGeneral,abonoprestamoReturnGeneral,isEsNuevoAbonoPrestamo,clases);
			
			this.connexion.commit();
			
			return abonoprestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AbonoPrestamoParameterReturnGeneral procesarImportacionAbonoPrestamosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AbonoPrestamoParameterReturnGeneral abonoprestamoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-procesarImportacionAbonoPrestamosWithConnection");connexion.begin();			
			
			AbonoPrestamoParameterReturnGeneral abonoprestamoReturnGeneral=new AbonoPrestamoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.abonoprestamos=new ArrayList<AbonoPrestamo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.abonoprestamo=new AbonoPrestamo();
				
				
				if(conColumnasBase) {this.abonoprestamo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.abonoprestamo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.abonoprestamo.setnumero(Integer.parseInt(arrColumnas[iColumn++]));
				this.abonoprestamo.setmonto_capital(Double.parseDouble(arrColumnas[iColumn++]));
				this.abonoprestamo.setmonto_interes(Double.parseDouble(arrColumnas[iColumn++]));
				this.abonoprestamo.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.abonoprestamo.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.abonoprestamo.setcodigo_quincena(arrColumnas[iColumn++]);
				
				this.abonoprestamos.add(this.abonoprestamo);
			}
			
			this.saveAbonoPrestamos();
			
			this.connexion.commit();
			
			abonoprestamoReturnGeneral.setConRetornoEstaProcesado(true);
			abonoprestamoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return abonoprestamoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAbonoPrestamosEliminados() throws Exception {				
		
		List<AbonoPrestamo> abonoprestamosAux= new ArrayList<AbonoPrestamo>();
		
		for(AbonoPrestamo abonoprestamo:abonoprestamos) {
			if(!abonoprestamo.getIsDeleted()) {
				abonoprestamosAux.add(abonoprestamo);
			}
		}
		
		abonoprestamos=abonoprestamosAux;
	}
	
	public void quitarAbonoPrestamosNulos() throws Exception {				
		
		List<AbonoPrestamo> abonoprestamosAux= new ArrayList<AbonoPrestamo>();
		
		for(AbonoPrestamo abonoprestamo : this.abonoprestamos) {
			if(abonoprestamo==null) {
				abonoprestamosAux.add(abonoprestamo);
			}
		}
		
		//this.abonoprestamos=abonoprestamosAux;
		
		this.abonoprestamos.removeAll(abonoprestamosAux);
	}
	
	public void getSetVersionRowAbonoPrestamoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(abonoprestamo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((abonoprestamo.getIsDeleted() || (abonoprestamo.getIsChanged()&&!abonoprestamo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=abonoprestamoDataAccess.getSetVersionRowAbonoPrestamo(connexion,abonoprestamo.getId());
				
				if(!abonoprestamo.getVersionRow().equals(timestamp)) {	
					abonoprestamo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				abonoprestamo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAbonoPrestamo()throws Exception {	
		
		if(abonoprestamo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((abonoprestamo.getIsDeleted() || (abonoprestamo.getIsChanged()&&!abonoprestamo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=abonoprestamoDataAccess.getSetVersionRowAbonoPrestamo(connexion,abonoprestamo.getId());
			
			try {							
				if(!abonoprestamo.getVersionRow().equals(timestamp)) {	
					abonoprestamo.setVersionRow(timestamp);
				}
				
				abonoprestamo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAbonoPrestamosWithConnection()throws Exception {	
		if(abonoprestamos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AbonoPrestamo abonoprestamoAux:abonoprestamos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(abonoprestamoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(abonoprestamoAux.getIsDeleted() || (abonoprestamoAux.getIsChanged()&&!abonoprestamoAux.getIsNew())) {
						
						timestamp=abonoprestamoDataAccess.getSetVersionRowAbonoPrestamo(connexion,abonoprestamoAux.getId());
						
						if(!abonoprestamo.getVersionRow().equals(timestamp)) {	
							abonoprestamoAux.setVersionRow(timestamp);
						}
								
						abonoprestamoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAbonoPrestamos()throws Exception {	
		if(abonoprestamos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AbonoPrestamo abonoprestamoAux:abonoprestamos) {
					if(abonoprestamoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(abonoprestamoAux.getIsDeleted() || (abonoprestamoAux.getIsChanged()&&!abonoprestamoAux.getIsNew())) {
						
						timestamp=abonoprestamoDataAccess.getSetVersionRowAbonoPrestamo(connexion,abonoprestamoAux.getId());
						
						if(!abonoprestamoAux.getVersionRow().equals(timestamp)) {	
							abonoprestamoAux.setVersionRow(timestamp);
						}
						
													
						abonoprestamoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AbonoPrestamoParameterReturnGeneral cargarCombosLoteForeignKeyAbonoPrestamoWithConnection(String finalQueryGlobalPrestamo) throws Exception {
		AbonoPrestamoParameterReturnGeneral  abonoprestamoReturnGeneral =new AbonoPrestamoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-cargarCombosLoteForeignKeyAbonoPrestamoWithConnection");connexion.begin();
			
			abonoprestamoReturnGeneral =new AbonoPrestamoParameterReturnGeneral();
			
			

			List<Prestamo> prestamosForeignKey=new ArrayList<Prestamo>();
			PrestamoLogic prestamoLogic=new PrestamoLogic();
			prestamoLogic.setConnexion(this.connexion);
			prestamoLogic.getPrestamoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPrestamo.equals("NONE")) {
				prestamoLogic.getTodosPrestamos(finalQueryGlobalPrestamo,new Pagination());
				prestamosForeignKey=prestamoLogic.getPrestamos();
			}

			abonoprestamoReturnGeneral.setprestamosForeignKey(prestamosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return abonoprestamoReturnGeneral;
	}
	
	public AbonoPrestamoParameterReturnGeneral cargarCombosLoteForeignKeyAbonoPrestamo(String finalQueryGlobalPrestamo) throws Exception {
		AbonoPrestamoParameterReturnGeneral  abonoprestamoReturnGeneral =new AbonoPrestamoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			abonoprestamoReturnGeneral =new AbonoPrestamoParameterReturnGeneral();
			
			

			List<Prestamo> prestamosForeignKey=new ArrayList<Prestamo>();
			PrestamoLogic prestamoLogic=new PrestamoLogic();
			prestamoLogic.setConnexion(this.connexion);
			prestamoLogic.getPrestamoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPrestamo.equals("NONE")) {
				prestamoLogic.getTodosPrestamos(finalQueryGlobalPrestamo,new Pagination());
				prestamosForeignKey=prestamoLogic.getPrestamos();
			}

			abonoprestamoReturnGeneral.setprestamosForeignKey(prestamosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return abonoprestamoReturnGeneral;
	}
	
	
	public void deepLoad(AbonoPrestamo abonoprestamo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AbonoPrestamoLogicAdditional.updateAbonoPrestamoToGet(abonoprestamo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		abonoprestamo.setPrestamo(abonoprestamoDataAccess.getPrestamo(connexion,abonoprestamo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				abonoprestamo.setPrestamo(abonoprestamoDataAccess.getPrestamo(connexion,abonoprestamo));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			abonoprestamo.setPrestamo(abonoprestamoDataAccess.getPrestamo(connexion,abonoprestamo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		abonoprestamo.setPrestamo(abonoprestamoDataAccess.getPrestamo(connexion,abonoprestamo));
		PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
		prestamoLogic.deepLoad(abonoprestamo.getPrestamo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				abonoprestamo.setPrestamo(abonoprestamoDataAccess.getPrestamo(connexion,abonoprestamo));
				PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
				prestamoLogic.deepLoad(abonoprestamo.getPrestamo(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			abonoprestamo.setPrestamo(abonoprestamoDataAccess.getPrestamo(connexion,abonoprestamo));
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamoLogic.deepLoad(abonoprestamo.getPrestamo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AbonoPrestamo abonoprestamo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AbonoPrestamoLogicAdditional.updateAbonoPrestamoToSave(abonoprestamo,this.arrDatoGeneral);
			
AbonoPrestamoDataAccess.save(abonoprestamo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PrestamoDataAccess.save(abonoprestamo.getPrestamo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				PrestamoDataAccess.save(abonoprestamo.getPrestamo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PrestamoDataAccess.save(abonoprestamo.getPrestamo(),connexion);
		PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
		prestamoLogic.deepLoad(abonoprestamo.getPrestamo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)) {
				PrestamoDataAccess.save(abonoprestamo.getPrestamo(),connexion);
				PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
				prestamoLogic.deepSave(abonoprestamo.getPrestamo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AbonoPrestamo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(abonoprestamo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(abonoprestamo);
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
			this.deepLoad(this.abonoprestamo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AbonoPrestamo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(abonoprestamos!=null) {
				for(AbonoPrestamo abonoprestamo:abonoprestamos) {
					this.deepLoad(abonoprestamo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(abonoprestamos);
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
			if(abonoprestamos!=null) {
				for(AbonoPrestamo abonoprestamo:abonoprestamos) {
					this.deepLoad(abonoprestamo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(abonoprestamos);
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
			this.getNewConnexionToDeep(AbonoPrestamo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(abonoprestamo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AbonoPrestamo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(abonoprestamos!=null) {
				for(AbonoPrestamo abonoprestamo:abonoprestamos) {
					this.deepSave(abonoprestamo,isDeep,deepLoadType,clases);
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
			if(abonoprestamos!=null) {
				for(AbonoPrestamo abonoprestamo:abonoprestamos) {
					this.deepSave(abonoprestamo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAbonoPrestamosFK_IdPrestamoWithConnection(String sFinalQuery,Pagination pagination,Long id_prestamo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AbonoPrestamo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPrestamo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPrestamo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_prestamo,AbonoPrestamoConstantesFunciones.IDPRESTAMO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPrestamo);

			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPrestamo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAbonoPrestamosFK_IdPrestamo(String sFinalQuery,Pagination pagination,Long id_prestamo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPrestamo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPrestamo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_prestamo,AbonoPrestamoConstantesFunciones.IDPRESTAMO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPrestamo);

			AbonoPrestamoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPrestamo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			abonoprestamos=abonoprestamoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AbonoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesAbonoPrestamo(this.abonoprestamos);
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
			if(AbonoPrestamoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AbonoPrestamoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AbonoPrestamo abonoprestamo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AbonoPrestamoConstantesFunciones.ISCONAUDITORIA) {
				if(abonoprestamo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AbonoPrestamoDataAccess.TABLENAME, abonoprestamo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AbonoPrestamoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AbonoPrestamoLogic.registrarAuditoriaDetallesAbonoPrestamo(connexion,abonoprestamo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(abonoprestamo.getIsDeleted()) {
					/*if(!abonoprestamo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AbonoPrestamoDataAccess.TABLENAME, abonoprestamo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AbonoPrestamoLogic.registrarAuditoriaDetallesAbonoPrestamo(connexion,abonoprestamo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AbonoPrestamoDataAccess.TABLENAME, abonoprestamo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(abonoprestamo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AbonoPrestamoDataAccess.TABLENAME, abonoprestamo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AbonoPrestamoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AbonoPrestamoLogic.registrarAuditoriaDetallesAbonoPrestamo(connexion,abonoprestamo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAbonoPrestamo(Connexion connexion,AbonoPrestamo abonoprestamo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(abonoprestamo.getIsNew()||!abonoprestamo.getid_prestamo().equals(abonoprestamo.getAbonoPrestamoOriginal().getid_prestamo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(abonoprestamo.getAbonoPrestamoOriginal().getid_prestamo()!=null)
				{
					strValorActual=abonoprestamo.getAbonoPrestamoOriginal().getid_prestamo().toString();
				}
				if(abonoprestamo.getid_prestamo()!=null)
				{
					strValorNuevo=abonoprestamo.getid_prestamo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AbonoPrestamoConstantesFunciones.IDPRESTAMO,strValorActual,strValorNuevo);
			}	
			
			if(abonoprestamo.getIsNew()||!abonoprestamo.getnumero().equals(abonoprestamo.getAbonoPrestamoOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(abonoprestamo.getAbonoPrestamoOriginal().getnumero()!=null)
				{
					strValorActual=abonoprestamo.getAbonoPrestamoOriginal().getnumero().toString();
				}
				if(abonoprestamo.getnumero()!=null)
				{
					strValorNuevo=abonoprestamo.getnumero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AbonoPrestamoConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(abonoprestamo.getIsNew()||!abonoprestamo.getmonto_capital().equals(abonoprestamo.getAbonoPrestamoOriginal().getmonto_capital()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(abonoprestamo.getAbonoPrestamoOriginal().getmonto_capital()!=null)
				{
					strValorActual=abonoprestamo.getAbonoPrestamoOriginal().getmonto_capital().toString();
				}
				if(abonoprestamo.getmonto_capital()!=null)
				{
					strValorNuevo=abonoprestamo.getmonto_capital().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AbonoPrestamoConstantesFunciones.MONTOCAPITAL,strValorActual,strValorNuevo);
			}	
			
			if(abonoprestamo.getIsNew()||!abonoprestamo.getmonto_interes().equals(abonoprestamo.getAbonoPrestamoOriginal().getmonto_interes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(abonoprestamo.getAbonoPrestamoOriginal().getmonto_interes()!=null)
				{
					strValorActual=abonoprestamo.getAbonoPrestamoOriginal().getmonto_interes().toString();
				}
				if(abonoprestamo.getmonto_interes()!=null)
				{
					strValorNuevo=abonoprestamo.getmonto_interes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AbonoPrestamoConstantesFunciones.MONTOINTERES,strValorActual,strValorNuevo);
			}	
			
			if(abonoprestamo.getIsNew()||!abonoprestamo.getvalor().equals(abonoprestamo.getAbonoPrestamoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(abonoprestamo.getAbonoPrestamoOriginal().getvalor()!=null)
				{
					strValorActual=abonoprestamo.getAbonoPrestamoOriginal().getvalor().toString();
				}
				if(abonoprestamo.getvalor()!=null)
				{
					strValorNuevo=abonoprestamo.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AbonoPrestamoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(abonoprestamo.getIsNew()||!abonoprestamo.getfecha_vencimiento().equals(abonoprestamo.getAbonoPrestamoOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(abonoprestamo.getAbonoPrestamoOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=abonoprestamo.getAbonoPrestamoOriginal().getfecha_vencimiento().toString();
				}
				if(abonoprestamo.getfecha_vencimiento()!=null)
				{
					strValorNuevo=abonoprestamo.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AbonoPrestamoConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(abonoprestamo.getIsNew()||!abonoprestamo.getcodigo_quincena().equals(abonoprestamo.getAbonoPrestamoOriginal().getcodigo_quincena()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(abonoprestamo.getAbonoPrestamoOriginal().getcodigo_quincena()!=null)
				{
					strValorActual=abonoprestamo.getAbonoPrestamoOriginal().getcodigo_quincena();
				}
				if(abonoprestamo.getcodigo_quincena()!=null)
				{
					strValorNuevo=abonoprestamo.getcodigo_quincena() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AbonoPrestamoConstantesFunciones.CODIGOQUINCENA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAbonoPrestamoRelacionesWithConnection(AbonoPrestamo abonoprestamo) throws Exception {

		if(!abonoprestamo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAbonoPrestamoRelacionesBase(abonoprestamo,true);
		}
	}

	public void saveAbonoPrestamoRelaciones(AbonoPrestamo abonoprestamo)throws Exception {

		if(!abonoprestamo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAbonoPrestamoRelacionesBase(abonoprestamo,false);
		}
	}

	public void saveAbonoPrestamoRelacionesBase(AbonoPrestamo abonoprestamo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AbonoPrestamo-saveRelacionesWithConnection");}
	

			this.setAbonoPrestamo(abonoprestamo);

			if(AbonoPrestamoLogicAdditional.validarSaveRelaciones(abonoprestamo,this)) {

				AbonoPrestamoLogicAdditional.updateRelacionesToSave(abonoprestamo,this);

				if((abonoprestamo.getIsNew()||abonoprestamo.getIsChanged())&&!abonoprestamo.getIsDeleted()) {
					this.saveAbonoPrestamo();
					this.saveAbonoPrestamoRelacionesDetalles();

				} else if(abonoprestamo.getIsDeleted()) {
					this.saveAbonoPrestamoRelacionesDetalles();
					this.saveAbonoPrestamo();
				}

				AbonoPrestamoLogicAdditional.updateRelacionesToSaveAfter(abonoprestamo,this);

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
	
	
	private void saveAbonoPrestamoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAbonoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AbonoPrestamoConstantesFunciones.getClassesForeignKeysOfAbonoPrestamo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAbonoPrestamo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AbonoPrestamoConstantesFunciones.getClassesRelationshipsOfAbonoPrestamo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
