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
import com.bydan.erp.puntoventa.util.GrupoClienteFormaPagoConstantesFunciones;
import com.bydan.erp.puntoventa.util.GrupoClienteFormaPagoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.GrupoClienteFormaPagoParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.GrupoClienteFormaPago;
import com.bydan.erp.puntoventa.business.logic.GrupoClienteFormaPagoLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class GrupoClienteFormaPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GrupoClienteFormaPagoLogic.class);
	
	protected GrupoClienteFormaPagoDataAccess grupoclienteformapagoDataAccess; 	
	protected GrupoClienteFormaPago grupoclienteformapago;
	protected List<GrupoClienteFormaPago> grupoclienteformapagos;
	protected Object grupoclienteformapagoObject;	
	protected List<Object> grupoclienteformapagosObject;
	
	public static ClassValidator<GrupoClienteFormaPago> grupoclienteformapagoValidator = new ClassValidator<GrupoClienteFormaPago>(GrupoClienteFormaPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GrupoClienteFormaPagoLogicAdditional grupoclienteformapagoLogicAdditional=null;
	
	public GrupoClienteFormaPagoLogicAdditional getGrupoClienteFormaPagoLogicAdditional() {
		return this.grupoclienteformapagoLogicAdditional;
	}
	
	public void setGrupoClienteFormaPagoLogicAdditional(GrupoClienteFormaPagoLogicAdditional grupoclienteformapagoLogicAdditional) {
		try {
			this.grupoclienteformapagoLogicAdditional=grupoclienteformapagoLogicAdditional;
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
	
	
	
	
	public  GrupoClienteFormaPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.grupoclienteformapagoDataAccess = new GrupoClienteFormaPagoDataAccess();
			
			this.grupoclienteformapagos= new ArrayList<GrupoClienteFormaPago>();
			this.grupoclienteformapago= new GrupoClienteFormaPago();
			
			this.grupoclienteformapagoObject=new Object();
			this.grupoclienteformapagosObject=new ArrayList<Object>();
				
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
			
			this.grupoclienteformapagoDataAccess.setConnexionType(this.connexionType);
			this.grupoclienteformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GrupoClienteFormaPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.grupoclienteformapagoDataAccess = new GrupoClienteFormaPagoDataAccess();
			this.grupoclienteformapagos= new ArrayList<GrupoClienteFormaPago>();
			this.grupoclienteformapago= new GrupoClienteFormaPago();
			this.grupoclienteformapagoObject=new Object();
			this.grupoclienteformapagosObject=new ArrayList<Object>();
			
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
			
			this.grupoclienteformapagoDataAccess.setConnexionType(this.connexionType);
			this.grupoclienteformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GrupoClienteFormaPago getGrupoClienteFormaPago() throws Exception {	
		GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToGet(grupoclienteformapago,this.datosCliente,this.arrDatoGeneral);
		GrupoClienteFormaPagoLogicAdditional.updateGrupoClienteFormaPagoToGet(grupoclienteformapago,this.arrDatoGeneral);
		
		return grupoclienteformapago;
	}
		
	public void setGrupoClienteFormaPago(GrupoClienteFormaPago newGrupoClienteFormaPago) {
		this.grupoclienteformapago = newGrupoClienteFormaPago;
	}
	
	public GrupoClienteFormaPagoDataAccess getGrupoClienteFormaPagoDataAccess() {
		return grupoclienteformapagoDataAccess;
	}
	
	public void setGrupoClienteFormaPagoDataAccess(GrupoClienteFormaPagoDataAccess newgrupoclienteformapagoDataAccess) {
		this.grupoclienteformapagoDataAccess = newgrupoclienteformapagoDataAccess;
	}
	
	public List<GrupoClienteFormaPago> getGrupoClienteFormaPagos() throws Exception {		
		this.quitarGrupoClienteFormaPagosNulos();
		
		GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToGets(grupoclienteformapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (GrupoClienteFormaPago grupoclienteformapagoLocal: grupoclienteformapagos ) {
			GrupoClienteFormaPagoLogicAdditional.updateGrupoClienteFormaPagoToGet(grupoclienteformapagoLocal,this.arrDatoGeneral);
		}
		
		return grupoclienteformapagos;
	}
	
	public void setGrupoClienteFormaPagos(List<GrupoClienteFormaPago> newGrupoClienteFormaPagos) {
		this.grupoclienteformapagos = newGrupoClienteFormaPagos;
	}
	
	public Object getGrupoClienteFormaPagoObject() {	
		this.grupoclienteformapagoObject=this.grupoclienteformapagoDataAccess.getEntityObject();
		return this.grupoclienteformapagoObject;
	}
		
	public void setGrupoClienteFormaPagoObject(Object newGrupoClienteFormaPagoObject) {
		this.grupoclienteformapagoObject = newGrupoClienteFormaPagoObject;
	}
	
	public List<Object> getGrupoClienteFormaPagosObject() {		
		this.grupoclienteformapagosObject=this.grupoclienteformapagoDataAccess.getEntitiesObject();
		return this.grupoclienteformapagosObject;
	}
		
	public void setGrupoClienteFormaPagosObject(List<Object> newGrupoClienteFormaPagosObject) {
		this.grupoclienteformapagosObject = newGrupoClienteFormaPagosObject;
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
		
		if(this.grupoclienteformapagoDataAccess!=null) {
			this.grupoclienteformapagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			grupoclienteformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			grupoclienteformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupoclienteformapago=grupoclienteformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoclienteformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapago);
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
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  		  
        try {
			
			grupoclienteformapago=grupoclienteformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoclienteformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupoclienteformapago=grupoclienteformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoclienteformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapago);
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
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  		  
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
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  		  
        try {
			
			grupoclienteformapago=grupoclienteformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoclienteformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  		  
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
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =grupoclienteformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoclienteformapago = new  GrupoClienteFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=grupoclienteformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =grupoclienteformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoclienteformapago = new  GrupoClienteFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=grupoclienteformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupoclienteformapago = new  GrupoClienteFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =grupoclienteformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoclienteformapago = new  GrupoClienteFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=grupoclienteformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
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
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		  		  
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
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		  		  
        try {			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		  		  
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
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
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
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		  		  
        try {
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
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
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
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
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		grupoclienteformapago = new  GrupoClienteFormaPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapago=grupoclienteformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapago);
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
		grupoclienteformapago = new  GrupoClienteFormaPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapago=grupoclienteformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
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
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		  		  
        try {
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGrupoClienteFormaPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getTodosGrupoClienteFormaPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
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
	
	public  void  getTodosGrupoClienteFormaPagos(String sFinalQuery,Pagination pagination)throws Exception {
		grupoclienteformapagos = new  ArrayList<GrupoClienteFormaPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoClienteFormaPago(grupoclienteformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGrupoClienteFormaPago(GrupoClienteFormaPago grupoclienteformapago) throws Exception {
		Boolean estaValidado=false;
		
		if(grupoclienteformapago.getIsNew() || grupoclienteformapago.getIsChanged()) { 
			this.invalidValues = grupoclienteformapagoValidator.getInvalidValues(grupoclienteformapago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(grupoclienteformapago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGrupoClienteFormaPago(List<GrupoClienteFormaPago> GrupoClienteFormaPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GrupoClienteFormaPago grupoclienteformapagoLocal:grupoclienteformapagos) {				
			estaValidadoObjeto=this.validarGuardarGrupoClienteFormaPago(grupoclienteformapagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGrupoClienteFormaPago(List<GrupoClienteFormaPago> GrupoClienteFormaPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoClienteFormaPago(grupoclienteformapagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGrupoClienteFormaPago(GrupoClienteFormaPago GrupoClienteFormaPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoClienteFormaPago(grupoclienteformapago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GrupoClienteFormaPago grupoclienteformapago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+grupoclienteformapago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GrupoClienteFormaPagoConstantesFunciones.getGrupoClienteFormaPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"grupoclienteformapago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GrupoClienteFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GrupoClienteFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGrupoClienteFormaPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-saveGrupoClienteFormaPagoWithConnection");connexion.begin();			
			
			GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToSave(this.grupoclienteformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoClienteFormaPagoLogicAdditional.updateGrupoClienteFormaPagoToSave(this.grupoclienteformapago,this.arrDatoGeneral);
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupoclienteformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGrupoClienteFormaPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoClienteFormaPago(this.grupoclienteformapago)) {
				GrupoClienteFormaPagoDataAccess.save(this.grupoclienteformapago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.grupoclienteformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToSaveAfter(this.grupoclienteformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoClienteFormaPago();
			
			connexion.commit();			
			
			if(this.grupoclienteformapago.getIsDeleted()) {
				this.grupoclienteformapago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGrupoClienteFormaPago()throws Exception {	
		try {	
			
			GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToSave(this.grupoclienteformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoClienteFormaPagoLogicAdditional.updateGrupoClienteFormaPagoToSave(this.grupoclienteformapago,this.arrDatoGeneral);
			
			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupoclienteformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoClienteFormaPago(this.grupoclienteformapago)) {			
				GrupoClienteFormaPagoDataAccess.save(this.grupoclienteformapago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.grupoclienteformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToSaveAfter(this.grupoclienteformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.grupoclienteformapago.getIsDeleted()) {
				this.grupoclienteformapago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGrupoClienteFormaPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-saveGrupoClienteFormaPagosWithConnection");connexion.begin();			
			
			GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToSaves(grupoclienteformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGrupoClienteFormaPagos();
			
			Boolean validadoTodosGrupoClienteFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoClienteFormaPago grupoclienteformapagoLocal:grupoclienteformapagos) {		
				if(grupoclienteformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoClienteFormaPagoLogicAdditional.updateGrupoClienteFormaPagoToSave(grupoclienteformapagoLocal,this.arrDatoGeneral);
	        	
				GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupoclienteformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoClienteFormaPago(grupoclienteformapagoLocal)) {
					GrupoClienteFormaPagoDataAccess.save(grupoclienteformapagoLocal, connexion);				
				} else {
					validadoTodosGrupoClienteFormaPago=false;
				}
			}
			
			if(!validadoTodosGrupoClienteFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToSavesAfter(grupoclienteformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoClienteFormaPagos();
			
			connexion.commit();		
			
			this.quitarGrupoClienteFormaPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGrupoClienteFormaPagos()throws Exception {				
		 try {	
			GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToSaves(grupoclienteformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGrupoClienteFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoClienteFormaPago grupoclienteformapagoLocal:grupoclienteformapagos) {				
				if(grupoclienteformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoClienteFormaPagoLogicAdditional.updateGrupoClienteFormaPagoToSave(grupoclienteformapagoLocal,this.arrDatoGeneral);
	        	
				GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupoclienteformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoClienteFormaPago(grupoclienteformapagoLocal)) {				
					GrupoClienteFormaPagoDataAccess.save(grupoclienteformapagoLocal, connexion);				
				} else {
					validadoTodosGrupoClienteFormaPago=false;
				}
			}
			
			if(!validadoTodosGrupoClienteFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoClienteFormaPagoLogicAdditional.checkGrupoClienteFormaPagoToSavesAfter(grupoclienteformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGrupoClienteFormaPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoClienteFormaPagoParameterReturnGeneral procesarAccionGrupoClienteFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoClienteFormaPago> grupoclienteformapagos,GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoParameterGeneral)throws Exception {
		 try {	
			GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoReturnGeneral=new GrupoClienteFormaPagoParameterReturnGeneral();
	
			GrupoClienteFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupoclienteformapagos,grupoclienteformapagoParameterGeneral,grupoclienteformapagoReturnGeneral);
			
			return grupoclienteformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoClienteFormaPagoParameterReturnGeneral procesarAccionGrupoClienteFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoClienteFormaPago> grupoclienteformapagos,GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-procesarAccionGrupoClienteFormaPagosWithConnection");connexion.begin();			
			
			GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoReturnGeneral=new GrupoClienteFormaPagoParameterReturnGeneral();
	
			GrupoClienteFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupoclienteformapagos,grupoclienteformapagoParameterGeneral,grupoclienteformapagoReturnGeneral);
			
			this.connexion.commit();
			
			return grupoclienteformapagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoClienteFormaPagoParameterReturnGeneral procesarEventosGrupoClienteFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoClienteFormaPago> grupoclienteformapagos,GrupoClienteFormaPago grupoclienteformapago,GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoParameterGeneral,Boolean isEsNuevoGrupoClienteFormaPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoReturnGeneral=new GrupoClienteFormaPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupoclienteformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoClienteFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupoclienteformapagos,grupoclienteformapago,grupoclienteformapagoParameterGeneral,grupoclienteformapagoReturnGeneral,isEsNuevoGrupoClienteFormaPago,clases);
			
			return grupoclienteformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GrupoClienteFormaPagoParameterReturnGeneral procesarEventosGrupoClienteFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoClienteFormaPago> grupoclienteformapagos,GrupoClienteFormaPago grupoclienteformapago,GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoParameterGeneral,Boolean isEsNuevoGrupoClienteFormaPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-procesarEventosGrupoClienteFormaPagosWithConnection");connexion.begin();			
			
			GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoReturnGeneral=new GrupoClienteFormaPagoParameterReturnGeneral();
	
			grupoclienteformapagoReturnGeneral.setGrupoClienteFormaPago(grupoclienteformapago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupoclienteformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoClienteFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupoclienteformapagos,grupoclienteformapago,grupoclienteformapagoParameterGeneral,grupoclienteformapagoReturnGeneral,isEsNuevoGrupoClienteFormaPago,clases);
			
			this.connexion.commit();
			
			return grupoclienteformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoClienteFormaPagoParameterReturnGeneral procesarImportacionGrupoClienteFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-procesarImportacionGrupoClienteFormaPagosWithConnection");connexion.begin();			
			
			GrupoClienteFormaPagoParameterReturnGeneral grupoclienteformapagoReturnGeneral=new GrupoClienteFormaPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.grupoclienteformapagos=new ArrayList<GrupoClienteFormaPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.grupoclienteformapago=new GrupoClienteFormaPago();
				
				
				if(conColumnasBase) {this.grupoclienteformapago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.grupoclienteformapago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.grupoclienteformapagos.add(this.grupoclienteformapago);
			}
			
			this.saveGrupoClienteFormaPagos();
			
			this.connexion.commit();
			
			grupoclienteformapagoReturnGeneral.setConRetornoEstaProcesado(true);
			grupoclienteformapagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return grupoclienteformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGrupoClienteFormaPagosEliminados() throws Exception {				
		
		List<GrupoClienteFormaPago> grupoclienteformapagosAux= new ArrayList<GrupoClienteFormaPago>();
		
		for(GrupoClienteFormaPago grupoclienteformapago:grupoclienteformapagos) {
			if(!grupoclienteformapago.getIsDeleted()) {
				grupoclienteformapagosAux.add(grupoclienteformapago);
			}
		}
		
		grupoclienteformapagos=grupoclienteformapagosAux;
	}
	
	public void quitarGrupoClienteFormaPagosNulos() throws Exception {				
		
		List<GrupoClienteFormaPago> grupoclienteformapagosAux= new ArrayList<GrupoClienteFormaPago>();
		
		for(GrupoClienteFormaPago grupoclienteformapago : this.grupoclienteformapagos) {
			if(grupoclienteformapago==null) {
				grupoclienteformapagosAux.add(grupoclienteformapago);
			}
		}
		
		//this.grupoclienteformapagos=grupoclienteformapagosAux;
		
		this.grupoclienteformapagos.removeAll(grupoclienteformapagosAux);
	}
	
	public void getSetVersionRowGrupoClienteFormaPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(grupoclienteformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((grupoclienteformapago.getIsDeleted() || (grupoclienteformapago.getIsChanged()&&!grupoclienteformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=grupoclienteformapagoDataAccess.getSetVersionRowGrupoClienteFormaPago(connexion,grupoclienteformapago.getId());
				
				if(!grupoclienteformapago.getVersionRow().equals(timestamp)) {	
					grupoclienteformapago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				grupoclienteformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGrupoClienteFormaPago()throws Exception {	
		
		if(grupoclienteformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((grupoclienteformapago.getIsDeleted() || (grupoclienteformapago.getIsChanged()&&!grupoclienteformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=grupoclienteformapagoDataAccess.getSetVersionRowGrupoClienteFormaPago(connexion,grupoclienteformapago.getId());
			
			try {							
				if(!grupoclienteformapago.getVersionRow().equals(timestamp)) {	
					grupoclienteformapago.setVersionRow(timestamp);
				}
				
				grupoclienteformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGrupoClienteFormaPagosWithConnection()throws Exception {	
		if(grupoclienteformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GrupoClienteFormaPago grupoclienteformapagoAux:grupoclienteformapagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(grupoclienteformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupoclienteformapagoAux.getIsDeleted() || (grupoclienteformapagoAux.getIsChanged()&&!grupoclienteformapagoAux.getIsNew())) {
						
						timestamp=grupoclienteformapagoDataAccess.getSetVersionRowGrupoClienteFormaPago(connexion,grupoclienteformapagoAux.getId());
						
						if(!grupoclienteformapago.getVersionRow().equals(timestamp)) {	
							grupoclienteformapagoAux.setVersionRow(timestamp);
						}
								
						grupoclienteformapagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGrupoClienteFormaPagos()throws Exception {	
		if(grupoclienteformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GrupoClienteFormaPago grupoclienteformapagoAux:grupoclienteformapagos) {
					if(grupoclienteformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupoclienteformapagoAux.getIsDeleted() || (grupoclienteformapagoAux.getIsChanged()&&!grupoclienteformapagoAux.getIsNew())) {
						
						timestamp=grupoclienteformapagoDataAccess.getSetVersionRowGrupoClienteFormaPago(connexion,grupoclienteformapagoAux.getId());
						
						if(!grupoclienteformapagoAux.getVersionRow().equals(timestamp)) {	
							grupoclienteformapagoAux.setVersionRow(timestamp);
						}
						
													
						grupoclienteformapagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GrupoClienteFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyGrupoClienteFormaPagoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalGrupoCliente,String finalQueryGlobalTipoFormaPago) throws Exception {
		GrupoClienteFormaPagoParameterReturnGeneral  grupoclienteformapagoReturnGeneral =new GrupoClienteFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-cargarCombosLoteForeignKeyGrupoClienteFormaPagoWithConnection");connexion.begin();
			
			grupoclienteformapagoReturnGeneral =new GrupoClienteFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupoclienteformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<GrupoCliente> grupoclientesForeignKey=new ArrayList<GrupoCliente>();
			GrupoClienteLogic grupoclienteLogic=new GrupoClienteLogic();
			grupoclienteLogic.setConnexion(this.connexion);
			grupoclienteLogic.getGrupoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoCliente.equals("NONE")) {
				grupoclienteLogic.getTodosGrupoClientes(finalQueryGlobalGrupoCliente,new Pagination());
				grupoclientesForeignKey=grupoclienteLogic.getGrupoClientes();
			}

			grupoclienteformapagoReturnGeneral.setgrupoclientesForeignKey(grupoclientesForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			grupoclienteformapagoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return grupoclienteformapagoReturnGeneral;
	}
	
	public GrupoClienteFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyGrupoClienteFormaPago(String finalQueryGlobalEmpresa,String finalQueryGlobalGrupoCliente,String finalQueryGlobalTipoFormaPago) throws Exception {
		GrupoClienteFormaPagoParameterReturnGeneral  grupoclienteformapagoReturnGeneral =new GrupoClienteFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			grupoclienteformapagoReturnGeneral =new GrupoClienteFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			grupoclienteformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<GrupoCliente> grupoclientesForeignKey=new ArrayList<GrupoCliente>();
			GrupoClienteLogic grupoclienteLogic=new GrupoClienteLogic();
			grupoclienteLogic.setConnexion(this.connexion);
			grupoclienteLogic.getGrupoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoCliente.equals("NONE")) {
				grupoclienteLogic.getTodosGrupoClientes(finalQueryGlobalGrupoCliente,new Pagination());
				grupoclientesForeignKey=grupoclienteLogic.getGrupoClientes();
			}

			grupoclienteformapagoReturnGeneral.setgrupoclientesForeignKey(grupoclientesForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			grupoclienteformapagoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return grupoclienteformapagoReturnGeneral;
	}
	
	
	public void deepLoad(GrupoClienteFormaPago grupoclienteformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GrupoClienteFormaPagoLogicAdditional.updateGrupoClienteFormaPagoToGet(grupoclienteformapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupoclienteformapago.setEmpresa(grupoclienteformapagoDataAccess.getEmpresa(connexion,grupoclienteformapago));
		grupoclienteformapago.setGrupoCliente(grupoclienteformapagoDataAccess.getGrupoCliente(connexion,grupoclienteformapago));
		grupoclienteformapago.setTipoFormaPago(grupoclienteformapagoDataAccess.getTipoFormaPago(connexion,grupoclienteformapago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupoclienteformapago.setEmpresa(grupoclienteformapagoDataAccess.getEmpresa(connexion,grupoclienteformapago));
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				grupoclienteformapago.setGrupoCliente(grupoclienteformapagoDataAccess.getGrupoCliente(connexion,grupoclienteformapago));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				grupoclienteformapago.setTipoFormaPago(grupoclienteformapagoDataAccess.getTipoFormaPago(connexion,grupoclienteformapago));
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
			grupoclienteformapago.setEmpresa(grupoclienteformapagoDataAccess.getEmpresa(connexion,grupoclienteformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupoclienteformapago.setGrupoCliente(grupoclienteformapagoDataAccess.getGrupoCliente(connexion,grupoclienteformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupoclienteformapago.setTipoFormaPago(grupoclienteformapagoDataAccess.getTipoFormaPago(connexion,grupoclienteformapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupoclienteformapago.setEmpresa(grupoclienteformapagoDataAccess.getEmpresa(connexion,grupoclienteformapago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupoclienteformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		grupoclienteformapago.setGrupoCliente(grupoclienteformapagoDataAccess.getGrupoCliente(connexion,grupoclienteformapago));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(grupoclienteformapago.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		grupoclienteformapago.setTipoFormaPago(grupoclienteformapagoDataAccess.getTipoFormaPago(connexion,grupoclienteformapago));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(grupoclienteformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				grupoclienteformapago.setEmpresa(grupoclienteformapagoDataAccess.getEmpresa(connexion,grupoclienteformapago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(grupoclienteformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				grupoclienteformapago.setGrupoCliente(grupoclienteformapagoDataAccess.getGrupoCliente(connexion,grupoclienteformapago));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(grupoclienteformapago.getGrupoCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				grupoclienteformapago.setTipoFormaPago(grupoclienteformapagoDataAccess.getTipoFormaPago(connexion,grupoclienteformapago));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(grupoclienteformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);				
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
			grupoclienteformapago.setEmpresa(grupoclienteformapagoDataAccess.getEmpresa(connexion,grupoclienteformapago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(grupoclienteformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupoclienteformapago.setGrupoCliente(grupoclienteformapagoDataAccess.getGrupoCliente(connexion,grupoclienteformapago));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(grupoclienteformapago.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupoclienteformapago.setTipoFormaPago(grupoclienteformapagoDataAccess.getTipoFormaPago(connexion,grupoclienteformapago));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(grupoclienteformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GrupoClienteFormaPago grupoclienteformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GrupoClienteFormaPagoLogicAdditional.updateGrupoClienteFormaPagoToSave(grupoclienteformapago,this.arrDatoGeneral);
			
GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(grupoclienteformapago.getEmpresa(),connexion);

		GrupoClienteDataAccess.save(grupoclienteformapago.getGrupoCliente(),connexion);

		TipoFormaPagoDataAccess.save(grupoclienteformapago.getTipoFormaPago(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(grupoclienteformapago.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				GrupoClienteDataAccess.save(grupoclienteformapago.getGrupoCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(grupoclienteformapago.getTipoFormaPago(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(grupoclienteformapago.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(grupoclienteformapago.getEmpresa(),isDeep,deepLoadType,clases);
				

		GrupoClienteDataAccess.save(grupoclienteformapago.getGrupoCliente(),connexion);
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(grupoclienteformapago.getGrupoCliente(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(grupoclienteformapago.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(grupoclienteformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(grupoclienteformapago.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(grupoclienteformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				GrupoClienteDataAccess.save(grupoclienteformapago.getGrupoCliente(),connexion);
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepSave(grupoclienteformapago.getGrupoCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(grupoclienteformapago.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(grupoclienteformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(GrupoClienteFormaPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(grupoclienteformapago);
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
			this.deepLoad(this.grupoclienteformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GrupoClienteFormaPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(grupoclienteformapagos!=null) {
				for(GrupoClienteFormaPago grupoclienteformapago:grupoclienteformapagos) {
					this.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(grupoclienteformapagos);
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
			if(grupoclienteformapagos!=null) {
				for(GrupoClienteFormaPago grupoclienteformapago:grupoclienteformapagos) {
					this.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(grupoclienteformapagos);
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
			this.getNewConnexionToDeep(GrupoClienteFormaPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(grupoclienteformapago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GrupoClienteFormaPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(grupoclienteformapagos!=null) {
				for(GrupoClienteFormaPago grupoclienteformapago:grupoclienteformapagos) {
					this.deepSave(grupoclienteformapago,isDeep,deepLoadType,clases);
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
			if(grupoclienteformapagos!=null) {
				for(GrupoClienteFormaPago grupoclienteformapago:grupoclienteformapagos) {
					this.deepSave(grupoclienteformapago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGrupoClienteFormaPagosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClienteFormaPagosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClienteFormaPagosFK_IdGrupoClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_cliente,GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoCliente);

			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClienteFormaPagosFK_IdGrupoCliente(String sFinalQuery,Pagination pagination,Long id_grupo_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_cliente,GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoCliente);

			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoClienteFormaPagosFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoClienteFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoClienteFormaPagosFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			GrupoClienteFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(this.grupoclienteformapagos);
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
			if(GrupoClienteFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoClienteFormaPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GrupoClienteFormaPago grupoclienteformapago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GrupoClienteFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				if(grupoclienteformapago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoClienteFormaPagoDataAccess.TABLENAME, grupoclienteformapago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoClienteFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoClienteFormaPagoLogic.registrarAuditoriaDetallesGrupoClienteFormaPago(connexion,grupoclienteformapago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(grupoclienteformapago.getIsDeleted()) {
					/*if(!grupoclienteformapago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GrupoClienteFormaPagoDataAccess.TABLENAME, grupoclienteformapago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GrupoClienteFormaPagoLogic.registrarAuditoriaDetallesGrupoClienteFormaPago(connexion,grupoclienteformapago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoClienteFormaPagoDataAccess.TABLENAME, grupoclienteformapago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(grupoclienteformapago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoClienteFormaPagoDataAccess.TABLENAME, grupoclienteformapago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoClienteFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GrupoClienteFormaPagoLogic.registrarAuditoriaDetallesGrupoClienteFormaPago(connexion,grupoclienteformapago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGrupoClienteFormaPago(Connexion connexion,GrupoClienteFormaPago grupoclienteformapago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(grupoclienteformapago.getIsNew()||!grupoclienteformapago.getid_empresa().equals(grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_empresa()!=null)
				{
					strValorActual=grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_empresa().toString();
				}
				if(grupoclienteformapago.getid_empresa()!=null)
				{
					strValorNuevo=grupoclienteformapago.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteFormaPagoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(grupoclienteformapago.getIsNew()||!grupoclienteformapago.getid_grupo_cliente().equals(grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_grupo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_grupo_cliente()!=null)
				{
					strValorActual=grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_grupo_cliente().toString();
				}
				if(grupoclienteformapago.getid_grupo_cliente()!=null)
				{
					strValorNuevo=grupoclienteformapago.getid_grupo_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteFormaPagoConstantesFunciones.IDGRUPOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(grupoclienteformapago.getIsNew()||!grupoclienteformapago.getid_tipo_forma_pago().equals(grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=grupoclienteformapago.getGrupoClienteFormaPagoOriginal().getid_tipo_forma_pago().toString();
				}
				if(grupoclienteformapago.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=grupoclienteformapago.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoClienteFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGrupoClienteFormaPagoRelacionesWithConnection(GrupoClienteFormaPago grupoclienteformapago) throws Exception {

		if(!grupoclienteformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoClienteFormaPagoRelacionesBase(grupoclienteformapago,true);
		}
	}

	public void saveGrupoClienteFormaPagoRelaciones(GrupoClienteFormaPago grupoclienteformapago)throws Exception {

		if(!grupoclienteformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoClienteFormaPagoRelacionesBase(grupoclienteformapago,false);
		}
	}

	public void saveGrupoClienteFormaPagoRelacionesBase(GrupoClienteFormaPago grupoclienteformapago,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GrupoClienteFormaPago-saveRelacionesWithConnection");}
	

			this.setGrupoClienteFormaPago(grupoclienteformapago);

			if(GrupoClienteFormaPagoLogicAdditional.validarSaveRelaciones(grupoclienteformapago,this)) {

				GrupoClienteFormaPagoLogicAdditional.updateRelacionesToSave(grupoclienteformapago,this);

				if((grupoclienteformapago.getIsNew()||grupoclienteformapago.getIsChanged())&&!grupoclienteformapago.getIsDeleted()) {
					this.saveGrupoClienteFormaPago();
					this.saveGrupoClienteFormaPagoRelacionesDetalles();

				} else if(grupoclienteformapago.getIsDeleted()) {
					this.saveGrupoClienteFormaPagoRelacionesDetalles();
					this.saveGrupoClienteFormaPago();
				}

				GrupoClienteFormaPagoLogicAdditional.updateRelacionesToSaveAfter(grupoclienteformapago,this);

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
	
	
	private void saveGrupoClienteFormaPagoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoClienteFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoClienteFormaPagoConstantesFunciones.getClassesForeignKeysOfGrupoClienteFormaPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoClienteFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoClienteFormaPagoConstantesFunciones.getClassesRelationshipsOfGrupoClienteFormaPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
