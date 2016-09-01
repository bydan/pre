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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.CajaConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.Caja;
//import com.bydan.erp.puntoventa.business.logic.CajaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class CajaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CajaLogic.class);
	
	protected CajaDataAccess cajaDataAccess; 	
	protected Caja caja;
	protected List<Caja> cajas;
	protected Object cajaObject;	
	protected List<Object> cajasObject;
	
	public static ClassValidator<Caja> cajaValidator = new ClassValidator<Caja>(Caja.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  CajaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cajaDataAccess = new CajaDataAccess();
			
			this.cajas= new ArrayList<Caja>();
			this.caja= new Caja();
			
			this.cajaObject=new Object();
			this.cajasObject=new ArrayList<Object>();
				
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
			
			this.cajaDataAccess.setConnexionType(this.connexionType);
			this.cajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cajaDataAccess = new CajaDataAccess();
			this.cajas= new ArrayList<Caja>();
			this.caja= new Caja();
			this.cajaObject=new Object();
			this.cajasObject=new ArrayList<Object>();
			
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
			
			this.cajaDataAccess.setConnexionType(this.connexionType);
			this.cajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Caja getCaja() throws Exception {	
		//CajaLogicAdditional.checkCajaToGet(caja,this.datosCliente,this.arrDatoGeneral);
		//CajaLogicAdditional.updateCajaToGet(caja,this.arrDatoGeneral);
		
		return caja;
	}
		
	public void setCaja(Caja newCaja) {
		this.caja = newCaja;
	}
	
	public CajaDataAccess getCajaDataAccess() {
		return cajaDataAccess;
	}
	
	public void setCajaDataAccess(CajaDataAccess newcajaDataAccess) {
		this.cajaDataAccess = newcajaDataAccess;
	}
	
	public List<Caja> getCajas() throws Exception {		
		this.quitarCajasNulos();
		
		//CajaLogicAdditional.checkCajaToGets(cajas,this.datosCliente,this.arrDatoGeneral);
		
		for (Caja cajaLocal: cajas ) {
			//CajaLogicAdditional.updateCajaToGet(cajaLocal,this.arrDatoGeneral);
		}
		
		return cajas;
	}
	
	public void setCajas(List<Caja> newCajas) {
		this.cajas = newCajas;
	}
	
	public Object getCajaObject() {	
		this.cajaObject=this.cajaDataAccess.getEntityObject();
		return this.cajaObject;
	}
		
	public void setCajaObject(Object newCajaObject) {
		this.cajaObject = newCajaObject;
	}
	
	public List<Object> getCajasObject() {		
		this.cajasObject=this.cajaDataAccess.getEntitiesObject();
		return this.cajasObject;
	}
		
	public void setCajasObject(List<Object> newCajasObject) {
		this.cajasObject = newCajasObject;
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
		
		if(this.cajaDataAccess!=null) {
			this.cajaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		caja = new  Caja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			caja=cajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.caja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.caja);
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
		caja = new  Caja();
		  		  
        try {
			
			caja=cajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.caja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.caja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		caja = new  Caja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			caja=cajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.caja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.caja);
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
		caja = new  Caja();
		  		  
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
		caja = new  Caja();
		  		  
        try {
			
			caja=cajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.caja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.caja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		caja = new  Caja();
		  		  
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
		caja = new  Caja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		caja = new  Caja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		caja = new  Caja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		caja = new  Caja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		caja = new  Caja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		caja = new  Caja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajas = new  ArrayList<Caja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajas=cajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCaja(cajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
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
		cajas = new  ArrayList<Caja>();
		  		  
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
		cajas = new  ArrayList<Caja>();
		  		  
        try {			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajas=cajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCaja(cajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cajas = new  ArrayList<Caja>();
		  		  
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
		cajas = new  ArrayList<Caja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajas=cajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCaja(cajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
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
		cajas = new  ArrayList<Caja>();
		  		  
        try {
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajas=cajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCaja(cajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
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
		cajas = new  ArrayList<Caja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajas=cajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCaja(cajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
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
		cajas = new  ArrayList<Caja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajas=cajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCaja(cajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		caja = new  Caja();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			caja=cajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCaja(caja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.caja);
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
		caja = new  Caja();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			caja=cajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCaja(caja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.caja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosCajasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cajas = new  ArrayList<Caja>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getTodosCajasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCaja(cajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
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
	
	public  void  getTodosCajas(String sFinalQuery,Pagination pagination)throws Exception {
		cajas = new  ArrayList<Caja>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCaja(cajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCaja(Caja caja) throws Exception {
		Boolean estaValidado=false;
		
		if(caja.getIsNew() || caja.getIsChanged()) { 
			this.invalidValues = cajaValidator.getInvalidValues(caja);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(caja);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCaja(List<Caja> Cajas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Caja cajaLocal:cajas) {				
			estaValidadoObjeto=this.validarGuardarCaja(cajaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCaja(List<Caja> Cajas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCaja(cajas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCaja(Caja Caja) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCaja(caja)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Caja caja) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+caja.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CajaConstantesFunciones.getCajaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"caja","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CajaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CajaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCajaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-saveCajaWithConnection");connexion.begin();			
			
			//CajaLogicAdditional.checkCajaToSave(this.caja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//CajaLogicAdditional.updateCajaToSave(this.caja,this.arrDatoGeneral);
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.caja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCaja();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCaja(this.caja)) {
				CajaDataAccess.save(this.caja, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.caja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//CajaLogicAdditional.checkCajaToSaveAfter(this.caja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCaja();
			
			connexion.commit();			
			
			if(this.caja.getIsDeleted()) {
				this.caja=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCaja()throws Exception {	
		try {	
			
			//CajaLogicAdditional.checkCajaToSave(this.caja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//CajaLogicAdditional.updateCajaToSave(this.caja,this.arrDatoGeneral);
			
			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.caja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCaja(this.caja)) {			
				CajaDataAccess.save(this.caja, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.caja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//CajaLogicAdditional.checkCajaToSaveAfter(this.caja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.caja.getIsDeleted()) {
				this.caja=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCajasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-saveCajasWithConnection");connexion.begin();			
			
			//CajaLogicAdditional.checkCajaToSaves(cajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCajas();
			
			Boolean validadoTodosCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Caja cajaLocal:cajas) {		
				if(cajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//CajaLogicAdditional.updateCajaToSave(cajaLocal,this.arrDatoGeneral);
	        	
				CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCaja(cajaLocal)) {
					CajaDataAccess.save(cajaLocal, connexion);				
				} else {
					validadoTodosCaja=false;
				}
			}
			
			if(!validadoTodosCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//CajaLogicAdditional.checkCajaToSavesAfter(cajas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajas();
			
			connexion.commit();		
			
			this.quitarCajasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCajas()throws Exception {				
		 try {	
			//CajaLogicAdditional.checkCajaToSaves(cajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Caja cajaLocal:cajas) {				
				if(cajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//CajaLogicAdditional.updateCajaToSave(cajaLocal,this.arrDatoGeneral);
	        	
				CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCaja(cajaLocal)) {				
					CajaDataAccess.save(cajaLocal, connexion);				
				} else {
					validadoTodosCaja=false;
				}
			}
			
			if(!validadoTodosCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//CajaLogicAdditional.checkCajaToSavesAfter(cajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCajasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaParameterReturnGeneral procesarAccionCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Caja> cajas,CajaParameterReturnGeneral cajaParameterGeneral)throws Exception {
		 try {	
			CajaParameterReturnGeneral cajaReturnGeneral=new CajaParameterReturnGeneral();
	
			
			return cajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaParameterReturnGeneral procesarAccionCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Caja> cajas,CajaParameterReturnGeneral cajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-procesarAccionCajasWithConnection");connexion.begin();			
			
			CajaParameterReturnGeneral cajaReturnGeneral=new CajaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return cajaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaParameterReturnGeneral procesarEventosCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Caja> cajas,Caja caja,CajaParameterReturnGeneral cajaParameterGeneral,Boolean isEsNuevoCaja,ArrayList<Classe> clases)throws Exception {
		 try {	
			CajaParameterReturnGeneral cajaReturnGeneral=new CajaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return cajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CajaParameterReturnGeneral procesarEventosCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Caja> cajas,Caja caja,CajaParameterReturnGeneral cajaParameterGeneral,Boolean isEsNuevoCaja,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-procesarEventosCajasWithConnection");connexion.begin();			
			
			CajaParameterReturnGeneral cajaReturnGeneral=new CajaParameterReturnGeneral();
	
			cajaReturnGeneral.setCaja(caja);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return cajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaParameterReturnGeneral procesarImportacionCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CajaParameterReturnGeneral cajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-procesarImportacionCajasWithConnection");connexion.begin();			
			
			CajaParameterReturnGeneral cajaReturnGeneral=new CajaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cajas=new ArrayList<Caja>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.caja=new Caja();
				
				
				if(conColumnasBase) {this.caja.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.caja.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.caja.setnombre(arrColumnas[iColumn++]);
				this.caja.setnombre_equipo(arrColumnas[iColumn++]);
				this.caja.setnombre_impresora(arrColumnas[iColumn++]);
				this.caja.setsecuencial_pedido(Long.parseLong(arrColumnas[iColumn++]));
				this.caja.setsecuencial_pedido_formato(arrColumnas[iColumn++]);
				this.caja.setpunto_emision(arrColumnas[iColumn++]);
				this.caja.setestablecimiento(arrColumnas[iColumn++]);
				this.caja.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.caja.setfecha_final(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.caja.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.caja.setdescripcion(arrColumnas[iColumn++]);
				this.caja.setsecuencial_factura(Long.parseLong(arrColumnas[iColumn++]));
				this.caja.setsecuencial_factura_formato(arrColumnas[iColumn++]);
				this.caja.setsecuencial_nota_venta(Long.parseLong(arrColumnas[iColumn++]));
				this.caja.setsecuencial_nota_venta_formato(arrColumnas[iColumn++]);
				this.caja.setsecuencia_nota_credito(Long.parseLong(arrColumnas[iColumn++]));
				this.caja.setsecuencia_nota_credito_formato(arrColumnas[iColumn++]);
				this.caja.setautorizacion_factura(arrColumnas[iColumn++]);
				this.caja.setautorizacion_nota_venta(arrColumnas[iColumn++]);
				this.caja.setautorizacion_nota_credito(arrColumnas[iColumn++]);
				this.caja.setfecha_caduca_factura(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.caja.setfecha_caduca_nota_venta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.caja.setfecha_caduca_nota_credito(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.caja.setserie_factura(arrColumnas[iColumn++]);
				this.caja.setserie_nota_venta(arrColumnas[iColumn++]);
				this.caja.setserie_nota_credito(arrColumnas[iColumn++]);
				this.caja.setsec_inicial_factura(arrColumnas[iColumn++]);
				this.caja.setsec_inicial_nota_venta(arrColumnas[iColumn++]);
				this.caja.setsec_inicial_nota_credito(arrColumnas[iColumn++]);
				this.caja.setsec_final_factura(arrColumnas[iColumn++]);
				this.caja.setsec_final_nota_venta(arrColumnas[iColumn++]);
				this.caja.setsec_final_nota_credito(arrColumnas[iColumn++]);
				
				this.cajas.add(this.caja);
			}
			
			this.saveCajas();
			
			this.connexion.commit();
			
			cajaReturnGeneral.setConRetornoEstaProcesado(true);
			cajaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCajasEliminados() throws Exception {				
		
		List<Caja> cajasAux= new ArrayList<Caja>();
		
		for(Caja caja:cajas) {
			if(!caja.getIsDeleted()) {
				cajasAux.add(caja);
			}
		}
		
		cajas=cajasAux;
	}
	
	public void quitarCajasNulos() throws Exception {				
		
		List<Caja> cajasAux= new ArrayList<Caja>();
		
		for(Caja caja : this.cajas) {
			if(caja==null) {
				cajasAux.add(caja);
			}
		}
		
		//this.cajas=cajasAux;
		
		this.cajas.removeAll(cajasAux);
	}
	
	public void getSetVersionRowCajaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(caja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((caja.getIsDeleted() || (caja.getIsChanged()&&!caja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cajaDataAccess.getSetVersionRowCaja(connexion,caja.getId());
				
				if(!caja.getVersionRow().equals(timestamp)) {	
					caja.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				caja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCaja()throws Exception {	
		
		if(caja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((caja.getIsDeleted() || (caja.getIsChanged()&&!caja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cajaDataAccess.getSetVersionRowCaja(connexion,caja.getId());
			
			try {							
				if(!caja.getVersionRow().equals(timestamp)) {	
					caja.setVersionRow(timestamp);
				}
				
				caja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCajasWithConnection()throws Exception {	
		if(cajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Caja cajaAux:cajas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaAux.getIsDeleted() || (cajaAux.getIsChanged()&&!cajaAux.getIsNew())) {
						
						timestamp=cajaDataAccess.getSetVersionRowCaja(connexion,cajaAux.getId());
						
						if(!caja.getVersionRow().equals(timestamp)) {	
							cajaAux.setVersionRow(timestamp);
						}
								
						cajaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCajas()throws Exception {	
		if(cajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Caja cajaAux:cajas) {
					if(cajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaAux.getIsDeleted() || (cajaAux.getIsChanged()&&!cajaAux.getIsNew())) {
						
						timestamp=cajaDataAccess.getSetVersionRowCaja(connexion,cajaAux.getId());
						
						if(!cajaAux.getVersionRow().equals(timestamp)) {	
							cajaAux.setVersionRow(timestamp);
						}
						
													
						cajaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CajaParameterReturnGeneral cargarCombosLoteForeignKeyCajaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona) throws Exception {
		CajaParameterReturnGeneral  cajaReturnGeneral =new CajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-cargarCombosLoteForeignKeyCajaWithConnection");connexion.begin();
			
			cajaReturnGeneral =new CajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			cajaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			cajaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			cajaReturnGeneral.setzonasForeignKey(zonasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cajaReturnGeneral;
	}
	
	public CajaParameterReturnGeneral cargarCombosLoteForeignKeyCaja(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPais,String finalQueryGlobalCiudad,String finalQueryGlobalZona) throws Exception {
		CajaParameterReturnGeneral  cajaReturnGeneral =new CajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cajaReturnGeneral =new CajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			cajaReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			cajaReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			cajaReturnGeneral.setzonasForeignKey(zonasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cajaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCajaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic=new NotaCreditoPuntoVentaLogic();
			CajaCierreLogic cajacierreLogic=new CajaCierreLogic();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			CajaEgresoLogic cajaegresoLogic=new CajaEgresoLogic();
			CajeroTurnoLogic cajeroturnoLogic=new CajeroTurnoLogic();
			PresupuestoVentasPunVenLogic presupuestoventaspunvenLogic=new PresupuestoVentasPunVenLogic();
			PedidoPuntoVentaLogic pedidopuntoventaLogic=new PedidoPuntoVentaLogic();
			CajaIngresoLogic cajaingresoLogic=new CajaIngresoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCajaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(NotaCreditoPuntoVenta.class));
			classes.add(new Classe(CajaCierre.class));
			classes.add(new Classe(FacturaPuntoVenta.class));
			classes.add(new Classe(CajaEgreso.class));
			classes.add(new Classe(CajeroTurno.class));
			classes.add(new Classe(PresupuestoVentasPunVen.class));
			classes.add(new Classe(PedidoPuntoVenta.class));
			classes.add(new Classe(CajaIngreso.class));
											
			

			notacreditopuntoventaLogic.setConnexion(this.getConnexion());
			notacreditopuntoventaLogic.setDatosCliente(this.datosCliente);
			notacreditopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			cajacierreLogic.setConnexion(this.getConnexion());
			cajacierreLogic.setDatosCliente(this.datosCliente);
			cajacierreLogic.setIsConRefrescarForeignKeys(true);

			facturapuntoventaLogic.setConnexion(this.getConnexion());
			facturapuntoventaLogic.setDatosCliente(this.datosCliente);
			facturapuntoventaLogic.setIsConRefrescarForeignKeys(true);

			cajaegresoLogic.setConnexion(this.getConnexion());
			cajaegresoLogic.setDatosCliente(this.datosCliente);
			cajaegresoLogic.setIsConRefrescarForeignKeys(true);

			cajeroturnoLogic.setConnexion(this.getConnexion());
			cajeroturnoLogic.setDatosCliente(this.datosCliente);
			cajeroturnoLogic.setIsConRefrescarForeignKeys(true);

			presupuestoventaspunvenLogic.setConnexion(this.getConnexion());
			presupuestoventaspunvenLogic.setDatosCliente(this.datosCliente);
			presupuestoventaspunvenLogic.setIsConRefrescarForeignKeys(true);

			pedidopuntoventaLogic.setConnexion(this.getConnexion());
			pedidopuntoventaLogic.setDatosCliente(this.datosCliente);
			pedidopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			cajaingresoLogic.setConnexion(this.getConnexion());
			cajaingresoLogic.setDatosCliente(this.datosCliente);
			cajaingresoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Caja caja:this.cajas) {
				

				classes=new ArrayList<Classe>();
				classes=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(caja.notacreditopuntoventas);
				notacreditopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajaCierreConstantesFunciones.getClassesForeignKeysOfCajaCierre(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajacierreLogic.setCajaCierres(caja.cajacierres);
				cajacierreLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				facturapuntoventaLogic.setFacturaPuntoVentas(caja.facturapuntoventas);
				facturapuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajaEgresoConstantesFunciones.getClassesForeignKeysOfCajaEgreso(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajaegresoLogic.setCajaEgresos(caja.cajaegresos);
				cajaegresoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajeroturnoLogic.setCajeroTurnos(caja.cajeroturnos);
				cajeroturnoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresupuestoVentasPunVenConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasPunVen(new ArrayList<Classe>(),DeepLoadType.NONE);

				presupuestoventaspunvenLogic.setPresupuestoVentasPunVens(caja.presupuestoventaspunvens);
				presupuestoventaspunvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidopuntoventaLogic.setPedidoPuntoVentas(caja.pedidopuntoventas);
				pedidopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CajaIngresoConstantesFunciones.getClassesForeignKeysOfCajaIngreso(new ArrayList<Classe>(),DeepLoadType.NONE);

				cajaingresoLogic.setCajaIngresos(caja.cajaingresos);
				cajaingresoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(Caja caja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//CajaLogicAdditional.updateCajaToGet(caja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		caja.setEmpresa(cajaDataAccess.getEmpresa(connexion,caja));
		caja.setSucursal(cajaDataAccess.getSucursal(connexion,caja));
		caja.setPais(cajaDataAccess.getPais(connexion,caja));
		caja.setCiudad(cajaDataAccess.getCiudad(connexion,caja));
		caja.setZona(cajaDataAccess.getZona(connexion,caja));
		caja.setNotaCreditoPuntoVentas(cajaDataAccess.getNotaCreditoPuntoVentas(connexion,caja));
		caja.setCajaCierres(cajaDataAccess.getCajaCierres(connexion,caja));
		caja.setFacturaPuntoVentas(cajaDataAccess.getFacturaPuntoVentas(connexion,caja));
		caja.setCajaEgresos(cajaDataAccess.getCajaEgresos(connexion,caja));
		caja.setCajeroTurnos(cajaDataAccess.getCajeroTurnos(connexion,caja));
		caja.setPresupuestoVentasPunVens(cajaDataAccess.getPresupuestoVentasPunVens(connexion,caja));
		caja.setPedidoPuntoVentas(cajaDataAccess.getPedidoPuntoVentas(connexion,caja));
		caja.setCajaIngresos(cajaDataAccess.getCajaIngresos(connexion,caja));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				caja.setEmpresa(cajaDataAccess.getEmpresa(connexion,caja));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				caja.setSucursal(cajaDataAccess.getSucursal(connexion,caja));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				caja.setPais(cajaDataAccess.getPais(connexion,caja));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				caja.setCiudad(cajaDataAccess.getCiudad(connexion,caja));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				caja.setZona(cajaDataAccess.getZona(connexion,caja));
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setNotaCreditoPuntoVentas(cajaDataAccess.getNotaCreditoPuntoVentas(connexion,caja));

				if(this.isConDeep) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(this.connexion);
					notacreditopuntoventaLogic.setNotaCreditoPuntoVentas(caja.getNotaCreditoPuntoVentas());
					ArrayList<Classe> classesLocal=NotaCreditoPuntoVentaConstantesFunciones.getClassesForeignKeysOfNotaCreditoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoPuntoVenta(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
					caja.setNotaCreditoPuntoVentas(notacreditopuntoventaLogic.getNotaCreditoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(CajaCierre.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setCajaCierres(cajaDataAccess.getCajaCierres(connexion,caja));

				if(this.isConDeep) {
					CajaCierreLogic cajacierreLogic= new CajaCierreLogic(this.connexion);
					cajacierreLogic.setCajaCierres(caja.getCajaCierres());
					ArrayList<Classe> classesLocal=CajaCierreConstantesFunciones.getClassesForeignKeysOfCajaCierre(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajacierreLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(cajacierreLogic.getCajaCierres());
					caja.setCajaCierres(cajacierreLogic.getCajaCierres());
				}

				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setFacturaPuntoVentas(cajaDataAccess.getFacturaPuntoVentas(connexion,caja));

				if(this.isConDeep) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(this.connexion);
					facturapuntoventaLogic.setFacturaPuntoVentas(caja.getFacturaPuntoVentas());
					ArrayList<Classe> classesLocal=FacturaPuntoVentaConstantesFunciones.getClassesForeignKeysOfFacturaPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					facturapuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FacturaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFacturaPuntoVenta(facturapuntoventaLogic.getFacturaPuntoVentas());
					caja.setFacturaPuntoVentas(facturapuntoventaLogic.getFacturaPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setCajaEgresos(cajaDataAccess.getCajaEgresos(connexion,caja));

				if(this.isConDeep) {
					CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(this.connexion);
					cajaegresoLogic.setCajaEgresos(caja.getCajaEgresos());
					ArrayList<Classe> classesLocal=CajaEgresoConstantesFunciones.getClassesForeignKeysOfCajaEgreso(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajaegresoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaEgresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgreso(cajaegresoLogic.getCajaEgresos());
					caja.setCajaEgresos(cajaegresoLogic.getCajaEgresos());
				}

				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setCajeroTurnos(cajaDataAccess.getCajeroTurnos(connexion,caja));

				if(this.isConDeep) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(this.connexion);
					cajeroturnoLogic.setCajeroTurnos(caja.getCajeroTurnos());
					ArrayList<Classe> classesLocal=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajeroturnoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(cajeroturnoLogic.getCajeroTurnos());
					caja.setCajeroTurnos(cajeroturnoLogic.getCajeroTurnos());
				}

				continue;
			}

			if(clas.clas.equals(PresupuestoVentasPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setPresupuestoVentasPunVens(cajaDataAccess.getPresupuestoVentasPunVens(connexion,caja));

				if(this.isConDeep) {
					PresupuestoVentasPunVenLogic presupuestoventaspunvenLogic= new PresupuestoVentasPunVenLogic(this.connexion);
					presupuestoventaspunvenLogic.setPresupuestoVentasPunVens(caja.getPresupuestoVentasPunVens());
					ArrayList<Classe> classesLocal=PresupuestoVentasPunVenConstantesFunciones.getClassesForeignKeysOfPresupuestoVentasPunVen(new ArrayList<Classe>(),DeepLoadType.NONE);
					presupuestoventaspunvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresupuestoVentasPunVenConstantesFunciones.refrescarForeignKeysDescripcionesPresupuestoVentasPunVen(presupuestoventaspunvenLogic.getPresupuestoVentasPunVens());
					caja.setPresupuestoVentasPunVens(presupuestoventaspunvenLogic.getPresupuestoVentasPunVens());
				}

				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setPedidoPuntoVentas(cajaDataAccess.getPedidoPuntoVentas(connexion,caja));

				if(this.isConDeep) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(this.connexion);
					pedidopuntoventaLogic.setPedidoPuntoVentas(caja.getPedidoPuntoVentas());
					ArrayList<Classe> classesLocal=PedidoPuntoVentaConstantesFunciones.getClassesForeignKeysOfPedidoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesPedidoPuntoVenta(pedidopuntoventaLogic.getPedidoPuntoVentas());
					caja.setPedidoPuntoVentas(pedidopuntoventaLogic.getPedidoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setCajaIngresos(cajaDataAccess.getCajaIngresos(connexion,caja));

				if(this.isConDeep) {
					CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(this.connexion);
					cajaingresoLogic.setCajaIngresos(caja.getCajaIngresos());
					ArrayList<Classe> classesLocal=CajaIngresoConstantesFunciones.getClassesForeignKeysOfCajaIngreso(new ArrayList<Classe>(),DeepLoadType.NONE);
					cajaingresoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CajaIngresoConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngreso(cajaingresoLogic.getCajaIngresos());
					caja.setCajaIngresos(cajaingresoLogic.getCajaIngresos());
				}

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
			caja.setEmpresa(cajaDataAccess.getEmpresa(connexion,caja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			caja.setSucursal(cajaDataAccess.getSucursal(connexion,caja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			caja.setPais(cajaDataAccess.getPais(connexion,caja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			caja.setCiudad(cajaDataAccess.getCiudad(connexion,caja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			caja.setZona(cajaDataAccess.getZona(connexion,caja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			caja.setNotaCreditoPuntoVentas(cajaDataAccess.getNotaCreditoPuntoVentas(connexion,caja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaCierre.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaCierre.class));
			caja.setCajaCierres(cajaDataAccess.getCajaCierres(connexion,caja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaPuntoVenta.class));
			caja.setFacturaPuntoVentas(cajaDataAccess.getFacturaPuntoVentas(connexion,caja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaEgreso.class));
			caja.setCajaEgresos(cajaDataAccess.getCajaEgresos(connexion,caja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajeroTurno.class));
			caja.setCajeroTurnos(cajaDataAccess.getCajeroTurnos(connexion,caja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentasPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentasPunVen.class));
			caja.setPresupuestoVentasPunVens(cajaDataAccess.getPresupuestoVentasPunVens(connexion,caja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoPuntoVenta.class));
			caja.setPedidoPuntoVentas(cajaDataAccess.getPedidoPuntoVentas(connexion,caja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaIngreso.class));
			caja.setCajaIngresos(cajaDataAccess.getCajaIngresos(connexion,caja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		caja.setEmpresa(cajaDataAccess.getEmpresa(connexion,caja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(caja.getEmpresa(),isDeep,deepLoadType,clases);
				
		caja.setSucursal(cajaDataAccess.getSucursal(connexion,caja));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(caja.getSucursal(),isDeep,deepLoadType,clases);
				
		caja.setPais(cajaDataAccess.getPais(connexion,caja));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(caja.getPais(),isDeep,deepLoadType,clases);
				
		caja.setCiudad(cajaDataAccess.getCiudad(connexion,caja));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(caja.getCiudad(),isDeep,deepLoadType,clases);
				
		caja.setZona(cajaDataAccess.getZona(connexion,caja));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(caja.getZona(),isDeep,deepLoadType,clases);
				

		caja.setNotaCreditoPuntoVentas(cajaDataAccess.getNotaCreditoPuntoVentas(connexion,caja));

		for(NotaCreditoPuntoVenta notacreditopuntoventa:caja.getNotaCreditoPuntoVentas()) {
			NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
			notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
		}

		caja.setCajaCierres(cajaDataAccess.getCajaCierres(connexion,caja));

		for(CajaCierre cajacierre:caja.getCajaCierres()) {
			CajaCierreLogic cajacierreLogic= new CajaCierreLogic(connexion);
			cajacierreLogic.deepLoad(cajacierre,isDeep,deepLoadType,clases);
		}

		caja.setFacturaPuntoVentas(cajaDataAccess.getFacturaPuntoVentas(connexion,caja));

		for(FacturaPuntoVenta facturapuntoventa:caja.getFacturaPuntoVentas()) {
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
		}

		caja.setCajaEgresos(cajaDataAccess.getCajaEgresos(connexion,caja));

		for(CajaEgreso cajaegreso:caja.getCajaEgresos()) {
			CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
			cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
		}

		caja.setCajeroTurnos(cajaDataAccess.getCajeroTurnos(connexion,caja));

		for(CajeroTurno cajeroturno:caja.getCajeroTurnos()) {
			CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
			cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
		}

		caja.setPresupuestoVentasPunVens(cajaDataAccess.getPresupuestoVentasPunVens(connexion,caja));

		for(PresupuestoVentasPunVen presupuestoventaspunven:caja.getPresupuestoVentasPunVens()) {
			PresupuestoVentasPunVenLogic presupuestoventaspunvenLogic= new PresupuestoVentasPunVenLogic(connexion);
			presupuestoventaspunvenLogic.deepLoad(presupuestoventaspunven,isDeep,deepLoadType,clases);
		}

		caja.setPedidoPuntoVentas(cajaDataAccess.getPedidoPuntoVentas(connexion,caja));

		for(PedidoPuntoVenta pedidopuntoventa:caja.getPedidoPuntoVentas()) {
			PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
			pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
		}

		caja.setCajaIngresos(cajaDataAccess.getCajaIngresos(connexion,caja));

		for(CajaIngreso cajaingreso:caja.getCajaIngresos()) {
			CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
			cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				caja.setEmpresa(cajaDataAccess.getEmpresa(connexion,caja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(caja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				caja.setSucursal(cajaDataAccess.getSucursal(connexion,caja));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(caja.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				caja.setPais(cajaDataAccess.getPais(connexion,caja));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(caja.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				caja.setCiudad(cajaDataAccess.getCiudad(connexion,caja));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(caja.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				caja.setZona(cajaDataAccess.getZona(connexion,caja));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(caja.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setNotaCreditoPuntoVentas(cajaDataAccess.getNotaCreditoPuntoVentas(connexion,caja));

				for(NotaCreditoPuntoVenta notacreditopuntoventa:caja.getNotaCreditoPuntoVentas()) {
					NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
					notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajaCierre.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setCajaCierres(cajaDataAccess.getCajaCierres(connexion,caja));

				for(CajaCierre cajacierre:caja.getCajaCierres()) {
					CajaCierreLogic cajacierreLogic= new CajaCierreLogic(connexion);
					cajacierreLogic.deepLoad(cajacierre,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setFacturaPuntoVentas(cajaDataAccess.getFacturaPuntoVentas(connexion,caja));

				for(FacturaPuntoVenta facturapuntoventa:caja.getFacturaPuntoVentas()) {
					FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
					facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setCajaEgresos(cajaDataAccess.getCajaEgresos(connexion,caja));

				for(CajaEgreso cajaegreso:caja.getCajaEgresos()) {
					CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
					cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setCajeroTurnos(cajaDataAccess.getCajeroTurnos(connexion,caja));

				for(CajeroTurno cajeroturno:caja.getCajeroTurnos()) {
					CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
					cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresupuestoVentasPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setPresupuestoVentasPunVens(cajaDataAccess.getPresupuestoVentasPunVens(connexion,caja));

				for(PresupuestoVentasPunVen presupuestoventaspunven:caja.getPresupuestoVentasPunVens()) {
					PresupuestoVentasPunVenLogic presupuestoventaspunvenLogic= new PresupuestoVentasPunVenLogic(connexion);
					presupuestoventaspunvenLogic.deepLoad(presupuestoventaspunven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setPedidoPuntoVentas(cajaDataAccess.getPedidoPuntoVentas(connexion,caja));

				for(PedidoPuntoVenta pedidopuntoventa:caja.getPedidoPuntoVentas()) {
					PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
					pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				caja.setCajaIngresos(cajaDataAccess.getCajaIngresos(connexion,caja));

				for(CajaIngreso cajaingreso:caja.getCajaIngresos()) {
					CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
					cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
				}
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
			caja.setEmpresa(cajaDataAccess.getEmpresa(connexion,caja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(caja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			caja.setSucursal(cajaDataAccess.getSucursal(connexion,caja));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(caja.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			caja.setPais(cajaDataAccess.getPais(connexion,caja));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(caja.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			caja.setCiudad(cajaDataAccess.getCiudad(connexion,caja));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(caja.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			caja.setZona(cajaDataAccess.getZona(connexion,caja));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(caja.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoPuntoVenta.class));
			caja.setNotaCreditoPuntoVentas(cajaDataAccess.getNotaCreditoPuntoVentas(connexion,caja));

			for(NotaCreditoPuntoVenta notacreditopuntoventa:caja.getNotaCreditoPuntoVentas()) {
				NotaCreditoPuntoVentaLogic notacreditopuntoventaLogic= new NotaCreditoPuntoVentaLogic(connexion);
				notacreditopuntoventaLogic.deepLoad(notacreditopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaCierre.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaCierre.class));
			caja.setCajaCierres(cajaDataAccess.getCajaCierres(connexion,caja));

			for(CajaCierre cajacierre:caja.getCajaCierres()) {
				CajaCierreLogic cajacierreLogic= new CajaCierreLogic(connexion);
				cajacierreLogic.deepLoad(cajacierre,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FacturaPuntoVenta.class));
			caja.setFacturaPuntoVentas(cajaDataAccess.getFacturaPuntoVentas(connexion,caja));

			for(FacturaPuntoVenta facturapuntoventa:caja.getFacturaPuntoVentas()) {
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepLoad(facturapuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaEgreso.class));
			caja.setCajaEgresos(cajaDataAccess.getCajaEgresos(connexion,caja));

			for(CajaEgreso cajaegreso:caja.getCajaEgresos()) {
				CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
				cajaegresoLogic.deepLoad(cajaegreso,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajeroTurno.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajeroTurno.class));
			caja.setCajeroTurnos(cajaDataAccess.getCajeroTurnos(connexion,caja));

			for(CajeroTurno cajeroturno:caja.getCajeroTurnos()) {
				CajeroTurnoLogic cajeroturnoLogic= new CajeroTurnoLogic(connexion);
				cajeroturnoLogic.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresupuestoVentasPunVen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresupuestoVentasPunVen.class));
			caja.setPresupuestoVentasPunVens(cajaDataAccess.getPresupuestoVentasPunVens(connexion,caja));

			for(PresupuestoVentasPunVen presupuestoventaspunven:caja.getPresupuestoVentasPunVens()) {
				PresupuestoVentasPunVenLogic presupuestoventaspunvenLogic= new PresupuestoVentasPunVenLogic(connexion);
				presupuestoventaspunvenLogic.deepLoad(presupuestoventaspunven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoPuntoVenta.class));
			caja.setPedidoPuntoVentas(cajaDataAccess.getPedidoPuntoVentas(connexion,caja));

			for(PedidoPuntoVenta pedidopuntoventa:caja.getPedidoPuntoVentas()) {
				PedidoPuntoVentaLogic pedidopuntoventaLogic= new PedidoPuntoVentaLogic(connexion);
				pedidopuntoventaLogic.deepLoad(pedidopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CajaIngreso.class));
			caja.setCajaIngresos(cajaDataAccess.getCajaIngresos(connexion,caja));

			for(CajaIngreso cajaingreso:caja.getCajaIngresos()) {
				CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
				cajaingresoLogic.deepLoad(cajaingreso,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Caja caja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Caja.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(caja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(caja);
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
			this.deepLoad(this.caja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.caja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Caja.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cajas!=null) {
				for(Caja caja:cajas) {
					this.deepLoad(caja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(cajas);
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
			if(cajas!=null) {
				for(Caja caja:cajas) {
					this.deepLoad(caja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(cajas);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCajasFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,CajaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajasFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,CajaConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,CajaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,CajaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajasFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Caja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,CajaConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajasFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,CajaConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			CajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajas=cajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaConstantesFunciones.refrescarForeignKeysDescripcionesCaja(this.cajas);
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
			if(CajaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Caja caja,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CajaConstantesFunciones.ISCONAUDITORIA) {
				if(caja.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaDataAccess.TABLENAME, caja.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaLogic.registrarAuditoriaDetallesCaja(connexion,caja,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(caja.getIsDeleted()) {
					/*if(!caja.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CajaDataAccess.TABLENAME, caja.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CajaLogic.registrarAuditoriaDetallesCaja(connexion,caja,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaDataAccess.TABLENAME, caja.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(caja.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaDataAccess.TABLENAME, caja.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaLogic.registrarAuditoriaDetallesCaja(connexion,caja,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCaja(Connexion connexion,Caja caja)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(caja.getIsNew()||!caja.getid_empresa().equals(caja.getCajaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getid_empresa()!=null)
				{
					strValorActual=caja.getCajaOriginal().getid_empresa().toString();
				}
				if(caja.getid_empresa()!=null)
				{
					strValorNuevo=caja.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getid_sucursal().equals(caja.getCajaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getid_sucursal()!=null)
				{
					strValorActual=caja.getCajaOriginal().getid_sucursal().toString();
				}
				if(caja.getid_sucursal()!=null)
				{
					strValorNuevo=caja.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getnombre().equals(caja.getCajaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getnombre()!=null)
				{
					strValorActual=caja.getCajaOriginal().getnombre();
				}
				if(caja.getnombre()!=null)
				{
					strValorNuevo=caja.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getnombre_equipo().equals(caja.getCajaOriginal().getnombre_equipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getnombre_equipo()!=null)
				{
					strValorActual=caja.getCajaOriginal().getnombre_equipo();
				}
				if(caja.getnombre_equipo()!=null)
				{
					strValorNuevo=caja.getnombre_equipo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.NOMBREEQUIPO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getnombre_impresora().equals(caja.getCajaOriginal().getnombre_impresora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getnombre_impresora()!=null)
				{
					strValorActual=caja.getCajaOriginal().getnombre_impresora();
				}
				if(caja.getnombre_impresora()!=null)
				{
					strValorNuevo=caja.getnombre_impresora() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.NOMBREIMPRESORA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsecuencial_pedido().equals(caja.getCajaOriginal().getsecuencial_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsecuencial_pedido()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsecuencial_pedido().toString();
				}
				if(caja.getsecuencial_pedido()!=null)
				{
					strValorNuevo=caja.getsecuencial_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECUENCIALPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsecuencial_pedido_formato().equals(caja.getCajaOriginal().getsecuencial_pedido_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsecuencial_pedido_formato()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsecuencial_pedido_formato();
				}
				if(caja.getsecuencial_pedido_formato()!=null)
				{
					strValorNuevo=caja.getsecuencial_pedido_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECUENCIALPEDIDOFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getpunto_emision().equals(caja.getCajaOriginal().getpunto_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getpunto_emision()!=null)
				{
					strValorActual=caja.getCajaOriginal().getpunto_emision();
				}
				if(caja.getpunto_emision()!=null)
				{
					strValorNuevo=caja.getpunto_emision() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.PUNTOEMISION,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getestablecimiento().equals(caja.getCajaOriginal().getestablecimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getestablecimiento()!=null)
				{
					strValorActual=caja.getCajaOriginal().getestablecimiento();
				}
				if(caja.getestablecimiento()!=null)
				{
					strValorNuevo=caja.getestablecimiento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.ESTABLECIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getfecha_inicio().equals(caja.getCajaOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getfecha_inicio()!=null)
				{
					strValorActual=caja.getCajaOriginal().getfecha_inicio().toString();
				}
				if(caja.getfecha_inicio()!=null)
				{
					strValorNuevo=caja.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getfecha_final().equals(caja.getCajaOriginal().getfecha_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getfecha_final()!=null)
				{
					strValorActual=caja.getCajaOriginal().getfecha_final().toString();
				}
				if(caja.getfecha_final()!=null)
				{
					strValorNuevo=caja.getfecha_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.FECHAFINAL,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getesta_activo().equals(caja.getCajaOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getesta_activo()!=null)
				{
					strValorActual=caja.getCajaOriginal().getesta_activo().toString();
				}
				if(caja.getesta_activo()!=null)
				{
					strValorNuevo=caja.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getdescripcion().equals(caja.getCajaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getdescripcion()!=null)
				{
					strValorActual=caja.getCajaOriginal().getdescripcion();
				}
				if(caja.getdescripcion()!=null)
				{
					strValorNuevo=caja.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsecuencial_factura().equals(caja.getCajaOriginal().getsecuencial_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsecuencial_factura()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsecuencial_factura().toString();
				}
				if(caja.getsecuencial_factura()!=null)
				{
					strValorNuevo=caja.getsecuencial_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECUENCIALFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsecuencial_factura_formato().equals(caja.getCajaOriginal().getsecuencial_factura_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsecuencial_factura_formato()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsecuencial_factura_formato();
				}
				if(caja.getsecuencial_factura_formato()!=null)
				{
					strValorNuevo=caja.getsecuencial_factura_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECUENCIALFACTURAFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsecuencial_nota_venta().equals(caja.getCajaOriginal().getsecuencial_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsecuencial_nota_venta()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsecuencial_nota_venta().toString();
				}
				if(caja.getsecuencial_nota_venta()!=null)
				{
					strValorNuevo=caja.getsecuencial_nota_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECUENCIALNOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsecuencial_nota_venta_formato().equals(caja.getCajaOriginal().getsecuencial_nota_venta_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsecuencial_nota_venta_formato()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsecuencial_nota_venta_formato();
				}
				if(caja.getsecuencial_nota_venta_formato()!=null)
				{
					strValorNuevo=caja.getsecuencial_nota_venta_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECUENCIALNOTAVENTAFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsecuencia_nota_credito().equals(caja.getCajaOriginal().getsecuencia_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsecuencia_nota_credito()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsecuencia_nota_credito().toString();
				}
				if(caja.getsecuencia_nota_credito()!=null)
				{
					strValorNuevo=caja.getsecuencia_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECUENCIANOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsecuencia_nota_credito_formato().equals(caja.getCajaOriginal().getsecuencia_nota_credito_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsecuencia_nota_credito_formato()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsecuencia_nota_credito_formato();
				}
				if(caja.getsecuencia_nota_credito_formato()!=null)
				{
					strValorNuevo=caja.getsecuencia_nota_credito_formato() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECUENCIANOTACREDITOFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getautorizacion_factura().equals(caja.getCajaOriginal().getautorizacion_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getautorizacion_factura()!=null)
				{
					strValorActual=caja.getCajaOriginal().getautorizacion_factura();
				}
				if(caja.getautorizacion_factura()!=null)
				{
					strValorNuevo=caja.getautorizacion_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.AUTORIZACIONFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getautorizacion_nota_venta().equals(caja.getCajaOriginal().getautorizacion_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getautorizacion_nota_venta()!=null)
				{
					strValorActual=caja.getCajaOriginal().getautorizacion_nota_venta();
				}
				if(caja.getautorizacion_nota_venta()!=null)
				{
					strValorNuevo=caja.getautorizacion_nota_venta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.AUTORIZACIONNOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getautorizacion_nota_credito().equals(caja.getCajaOriginal().getautorizacion_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getautorizacion_nota_credito()!=null)
				{
					strValorActual=caja.getCajaOriginal().getautorizacion_nota_credito();
				}
				if(caja.getautorizacion_nota_credito()!=null)
				{
					strValorNuevo=caja.getautorizacion_nota_credito() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.AUTORIZACIONNOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getfecha_caduca_factura().equals(caja.getCajaOriginal().getfecha_caduca_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getfecha_caduca_factura()!=null)
				{
					strValorActual=caja.getCajaOriginal().getfecha_caduca_factura().toString();
				}
				if(caja.getfecha_caduca_factura()!=null)
				{
					strValorNuevo=caja.getfecha_caduca_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.FECHACADUCAFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getfecha_caduca_nota_venta().equals(caja.getCajaOriginal().getfecha_caduca_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getfecha_caduca_nota_venta()!=null)
				{
					strValorActual=caja.getCajaOriginal().getfecha_caduca_nota_venta().toString();
				}
				if(caja.getfecha_caduca_nota_venta()!=null)
				{
					strValorNuevo=caja.getfecha_caduca_nota_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.FECHACADUCANOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getfecha_caduca_nota_credito().equals(caja.getCajaOriginal().getfecha_caduca_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getfecha_caduca_nota_credito()!=null)
				{
					strValorActual=caja.getCajaOriginal().getfecha_caduca_nota_credito().toString();
				}
				if(caja.getfecha_caduca_nota_credito()!=null)
				{
					strValorNuevo=caja.getfecha_caduca_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.FECHACADUCANOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getserie_factura().equals(caja.getCajaOriginal().getserie_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getserie_factura()!=null)
				{
					strValorActual=caja.getCajaOriginal().getserie_factura();
				}
				if(caja.getserie_factura()!=null)
				{
					strValorNuevo=caja.getserie_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SERIEFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getserie_nota_venta().equals(caja.getCajaOriginal().getserie_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getserie_nota_venta()!=null)
				{
					strValorActual=caja.getCajaOriginal().getserie_nota_venta();
				}
				if(caja.getserie_nota_venta()!=null)
				{
					strValorNuevo=caja.getserie_nota_venta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SERIENOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getserie_nota_credito().equals(caja.getCajaOriginal().getserie_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getserie_nota_credito()!=null)
				{
					strValorActual=caja.getCajaOriginal().getserie_nota_credito();
				}
				if(caja.getserie_nota_credito()!=null)
				{
					strValorNuevo=caja.getserie_nota_credito() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SERIENOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsec_inicial_factura().equals(caja.getCajaOriginal().getsec_inicial_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsec_inicial_factura()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsec_inicial_factura();
				}
				if(caja.getsec_inicial_factura()!=null)
				{
					strValorNuevo=caja.getsec_inicial_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECINICIALFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsec_inicial_nota_venta().equals(caja.getCajaOriginal().getsec_inicial_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsec_inicial_nota_venta()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsec_inicial_nota_venta();
				}
				if(caja.getsec_inicial_nota_venta()!=null)
				{
					strValorNuevo=caja.getsec_inicial_nota_venta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECINICIALNOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsec_inicial_nota_credito().equals(caja.getCajaOriginal().getsec_inicial_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsec_inicial_nota_credito()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsec_inicial_nota_credito();
				}
				if(caja.getsec_inicial_nota_credito()!=null)
				{
					strValorNuevo=caja.getsec_inicial_nota_credito() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECINICIALNOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsec_final_factura().equals(caja.getCajaOriginal().getsec_final_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsec_final_factura()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsec_final_factura();
				}
				if(caja.getsec_final_factura()!=null)
				{
					strValorNuevo=caja.getsec_final_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECFINALFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsec_final_nota_venta().equals(caja.getCajaOriginal().getsec_final_nota_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsec_final_nota_venta()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsec_final_nota_venta();
				}
				if(caja.getsec_final_nota_venta()!=null)
				{
					strValorNuevo=caja.getsec_final_nota_venta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECFINALNOTAVENTA,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getsec_final_nota_credito().equals(caja.getCajaOriginal().getsec_final_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getsec_final_nota_credito()!=null)
				{
					strValorActual=caja.getCajaOriginal().getsec_final_nota_credito();
				}
				if(caja.getsec_final_nota_credito()!=null)
				{
					strValorNuevo=caja.getsec_final_nota_credito() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.SECFINALNOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getid_pais().equals(caja.getCajaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getid_pais()!=null)
				{
					strValorActual=caja.getCajaOriginal().getid_pais().toString();
				}
				if(caja.getid_pais()!=null)
				{
					strValorNuevo=caja.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getid_ciudad().equals(caja.getCajaOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getid_ciudad()!=null)
				{
					strValorActual=caja.getCajaOriginal().getid_ciudad().toString();
				}
				if(caja.getid_ciudad()!=null)
				{
					strValorNuevo=caja.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(caja.getIsNew()||!caja.getid_zona().equals(caja.getCajaOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(caja.getCajaOriginal().getid_zona()!=null)
				{
					strValorActual=caja.getCajaOriginal().getid_zona().toString();
				}
				if(caja.getid_zona()!=null)
				{
					strValorNuevo=caja.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaConstantesFunciones.getClassesForeignKeysOfCaja(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaConstantesFunciones.getClassesRelationshipsOfCaja(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}
