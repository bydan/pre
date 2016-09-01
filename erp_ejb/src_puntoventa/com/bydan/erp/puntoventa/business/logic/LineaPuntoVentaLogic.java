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
import com.bydan.erp.puntoventa.util.LineaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.LineaPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.LineaPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.LineaPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.LineaPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class LineaPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(LineaPuntoVentaLogic.class);
	
	protected LineaPuntoVentaDataAccess lineapuntoventaDataAccess; 	
	protected LineaPuntoVenta lineapuntoventa;
	protected List<LineaPuntoVenta> lineapuntoventas;
	protected Object lineapuntoventaObject;	
	protected List<Object> lineapuntoventasObject;
	
	public static ClassValidator<LineaPuntoVenta> lineapuntoventaValidator = new ClassValidator<LineaPuntoVenta>(LineaPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected LineaPuntoVentaLogicAdditional lineapuntoventaLogicAdditional=null;
	
	public LineaPuntoVentaLogicAdditional getLineaPuntoVentaLogicAdditional() {
		return this.lineapuntoventaLogicAdditional;
	}
	
	public void setLineaPuntoVentaLogicAdditional(LineaPuntoVentaLogicAdditional lineapuntoventaLogicAdditional) {
		try {
			this.lineapuntoventaLogicAdditional=lineapuntoventaLogicAdditional;
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
	
	
	
	
	public  LineaPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.lineapuntoventaDataAccess = new LineaPuntoVentaDataAccess();
			
			this.lineapuntoventas= new ArrayList<LineaPuntoVenta>();
			this.lineapuntoventa= new LineaPuntoVenta();
			
			this.lineapuntoventaObject=new Object();
			this.lineapuntoventasObject=new ArrayList<Object>();
				
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
			
			this.lineapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.lineapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  LineaPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.lineapuntoventaDataAccess = new LineaPuntoVentaDataAccess();
			this.lineapuntoventas= new ArrayList<LineaPuntoVenta>();
			this.lineapuntoventa= new LineaPuntoVenta();
			this.lineapuntoventaObject=new Object();
			this.lineapuntoventasObject=new ArrayList<Object>();
			
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
			
			this.lineapuntoventaDataAccess.setConnexionType(this.connexionType);
			this.lineapuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public LineaPuntoVenta getLineaPuntoVenta() throws Exception {	
		LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToGet(lineapuntoventa,this.datosCliente,this.arrDatoGeneral);
		LineaPuntoVentaLogicAdditional.updateLineaPuntoVentaToGet(lineapuntoventa,this.arrDatoGeneral);
		
		return lineapuntoventa;
	}
		
	public void setLineaPuntoVenta(LineaPuntoVenta newLineaPuntoVenta) {
		this.lineapuntoventa = newLineaPuntoVenta;
	}
	
	public LineaPuntoVentaDataAccess getLineaPuntoVentaDataAccess() {
		return lineapuntoventaDataAccess;
	}
	
	public void setLineaPuntoVentaDataAccess(LineaPuntoVentaDataAccess newlineapuntoventaDataAccess) {
		this.lineapuntoventaDataAccess = newlineapuntoventaDataAccess;
	}
	
	public List<LineaPuntoVenta> getLineaPuntoVentas() throws Exception {		
		this.quitarLineaPuntoVentasNulos();
		
		LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToGets(lineapuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (LineaPuntoVenta lineapuntoventaLocal: lineapuntoventas ) {
			LineaPuntoVentaLogicAdditional.updateLineaPuntoVentaToGet(lineapuntoventaLocal,this.arrDatoGeneral);
		}
		
		return lineapuntoventas;
	}
	
	public void setLineaPuntoVentas(List<LineaPuntoVenta> newLineaPuntoVentas) {
		this.lineapuntoventas = newLineaPuntoVentas;
	}
	
	public Object getLineaPuntoVentaObject() {	
		this.lineapuntoventaObject=this.lineapuntoventaDataAccess.getEntityObject();
		return this.lineapuntoventaObject;
	}
		
	public void setLineaPuntoVentaObject(Object newLineaPuntoVentaObject) {
		this.lineapuntoventaObject = newLineaPuntoVentaObject;
	}
	
	public List<Object> getLineaPuntoVentasObject() {		
		this.lineapuntoventasObject=this.lineapuntoventaDataAccess.getEntitiesObject();
		return this.lineapuntoventasObject;
	}
		
	public void setLineaPuntoVentasObject(List<Object> newLineaPuntoVentasObject) {
		this.lineapuntoventasObject = newLineaPuntoVentasObject;
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
		
		if(this.lineapuntoventaDataAccess!=null) {
			this.lineapuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			lineapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			lineapuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		lineapuntoventa = new  LineaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			lineapuntoventa=lineapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventa);
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
		lineapuntoventa = new  LineaPuntoVenta();
		  		  
        try {
			
			lineapuntoventa=lineapuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		lineapuntoventa = new  LineaPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			lineapuntoventa=lineapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventa);
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
		lineapuntoventa = new  LineaPuntoVenta();
		  		  
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
		lineapuntoventa = new  LineaPuntoVenta();
		  		  
        try {
			
			lineapuntoventa=lineapuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		lineapuntoventa = new  LineaPuntoVenta();
		  		  
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
		lineapuntoventa = new  LineaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =lineapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lineapuntoventa = new  LineaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=lineapuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineapuntoventa = new  LineaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =lineapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lineapuntoventa = new  LineaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=lineapuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineapuntoventa = new  LineaPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =lineapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		lineapuntoventa = new  LineaPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=lineapuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
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
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		  		  
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
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		  		  
        try {			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		  		  
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
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
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
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		  		  
        try {
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
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
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
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
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		lineapuntoventa = new  LineaPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventa=lineapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventa);
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
		lineapuntoventa = new  LineaPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventa=lineapuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
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
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		  		  
        try {
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosLineaPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getTodosLineaPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
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
	
	public  void  getTodosLineaPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		lineapuntoventas = new  ArrayList<LineaPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLineaPuntoVenta(lineapuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarLineaPuntoVenta(LineaPuntoVenta lineapuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(lineapuntoventa.getIsNew() || lineapuntoventa.getIsChanged()) { 
			this.invalidValues = lineapuntoventaValidator.getInvalidValues(lineapuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(lineapuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarLineaPuntoVenta(List<LineaPuntoVenta> LineaPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(LineaPuntoVenta lineapuntoventaLocal:lineapuntoventas) {				
			estaValidadoObjeto=this.validarGuardarLineaPuntoVenta(lineapuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarLineaPuntoVenta(List<LineaPuntoVenta> LineaPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLineaPuntoVenta(lineapuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarLineaPuntoVenta(LineaPuntoVenta LineaPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLineaPuntoVenta(lineapuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(LineaPuntoVenta lineapuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+lineapuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=LineaPuntoVentaConstantesFunciones.getLineaPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"lineapuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(LineaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(LineaPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveLineaPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-saveLineaPuntoVentaWithConnection");connexion.begin();			
			
			LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToSave(this.lineapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LineaPuntoVentaLogicAdditional.updateLineaPuntoVentaToSave(this.lineapuntoventa,this.arrDatoGeneral);
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.lineapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowLineaPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLineaPuntoVenta(this.lineapuntoventa)) {
				LineaPuntoVentaDataAccess.save(this.lineapuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.lineapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToSaveAfter(this.lineapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLineaPuntoVenta();
			
			connexion.commit();			
			
			if(this.lineapuntoventa.getIsDeleted()) {
				this.lineapuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveLineaPuntoVenta()throws Exception {	
		try {	
			
			LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToSave(this.lineapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LineaPuntoVentaLogicAdditional.updateLineaPuntoVentaToSave(this.lineapuntoventa,this.arrDatoGeneral);
			
			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.lineapuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLineaPuntoVenta(this.lineapuntoventa)) {			
				LineaPuntoVentaDataAccess.save(this.lineapuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.lineapuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToSaveAfter(this.lineapuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.lineapuntoventa.getIsDeleted()) {
				this.lineapuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveLineaPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-saveLineaPuntoVentasWithConnection");connexion.begin();			
			
			LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToSaves(lineapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowLineaPuntoVentas();
			
			Boolean validadoTodosLineaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LineaPuntoVenta lineapuntoventaLocal:lineapuntoventas) {		
				if(lineapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LineaPuntoVentaLogicAdditional.updateLineaPuntoVentaToSave(lineapuntoventaLocal,this.arrDatoGeneral);
	        	
				LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lineapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLineaPuntoVenta(lineapuntoventaLocal)) {
					LineaPuntoVentaDataAccess.save(lineapuntoventaLocal, connexion);				
				} else {
					validadoTodosLineaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosLineaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToSavesAfter(lineapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLineaPuntoVentas();
			
			connexion.commit();		
			
			this.quitarLineaPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveLineaPuntoVentas()throws Exception {				
		 try {	
			LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToSaves(lineapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosLineaPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LineaPuntoVenta lineapuntoventaLocal:lineapuntoventas) {				
				if(lineapuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LineaPuntoVentaLogicAdditional.updateLineaPuntoVentaToSave(lineapuntoventaLocal,this.arrDatoGeneral);
	        	
				LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lineapuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLineaPuntoVenta(lineapuntoventaLocal)) {				
					LineaPuntoVentaDataAccess.save(lineapuntoventaLocal, connexion);				
				} else {
					validadoTodosLineaPuntoVenta=false;
				}
			}
			
			if(!validadoTodosLineaPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LineaPuntoVentaLogicAdditional.checkLineaPuntoVentaToSavesAfter(lineapuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarLineaPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LineaPuntoVentaParameterReturnGeneral procesarAccionLineaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LineaPuntoVenta> lineapuntoventas,LineaPuntoVentaParameterReturnGeneral lineapuntoventaParameterGeneral)throws Exception {
		 try {	
			LineaPuntoVentaParameterReturnGeneral lineapuntoventaReturnGeneral=new LineaPuntoVentaParameterReturnGeneral();
	
			LineaPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,lineapuntoventas,lineapuntoventaParameterGeneral,lineapuntoventaReturnGeneral);
			
			return lineapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LineaPuntoVentaParameterReturnGeneral procesarAccionLineaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LineaPuntoVenta> lineapuntoventas,LineaPuntoVentaParameterReturnGeneral lineapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-procesarAccionLineaPuntoVentasWithConnection");connexion.begin();			
			
			LineaPuntoVentaParameterReturnGeneral lineapuntoventaReturnGeneral=new LineaPuntoVentaParameterReturnGeneral();
	
			LineaPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,lineapuntoventas,lineapuntoventaParameterGeneral,lineapuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return lineapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LineaPuntoVentaParameterReturnGeneral procesarEventosLineaPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LineaPuntoVenta> lineapuntoventas,LineaPuntoVenta lineapuntoventa,LineaPuntoVentaParameterReturnGeneral lineapuntoventaParameterGeneral,Boolean isEsNuevoLineaPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			LineaPuntoVentaParameterReturnGeneral lineapuntoventaReturnGeneral=new LineaPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lineapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LineaPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,lineapuntoventas,lineapuntoventa,lineapuntoventaParameterGeneral,lineapuntoventaReturnGeneral,isEsNuevoLineaPuntoVenta,clases);
			
			return lineapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public LineaPuntoVentaParameterReturnGeneral procesarEventosLineaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LineaPuntoVenta> lineapuntoventas,LineaPuntoVenta lineapuntoventa,LineaPuntoVentaParameterReturnGeneral lineapuntoventaParameterGeneral,Boolean isEsNuevoLineaPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-procesarEventosLineaPuntoVentasWithConnection");connexion.begin();			
			
			LineaPuntoVentaParameterReturnGeneral lineapuntoventaReturnGeneral=new LineaPuntoVentaParameterReturnGeneral();
	
			lineapuntoventaReturnGeneral.setLineaPuntoVenta(lineapuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lineapuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LineaPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,lineapuntoventas,lineapuntoventa,lineapuntoventaParameterGeneral,lineapuntoventaReturnGeneral,isEsNuevoLineaPuntoVenta,clases);
			
			this.connexion.commit();
			
			return lineapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LineaPuntoVentaParameterReturnGeneral procesarImportacionLineaPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,LineaPuntoVentaParameterReturnGeneral lineapuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-procesarImportacionLineaPuntoVentasWithConnection");connexion.begin();			
			
			LineaPuntoVentaParameterReturnGeneral lineapuntoventaReturnGeneral=new LineaPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.lineapuntoventas=new ArrayList<LineaPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.lineapuntoventa=new LineaPuntoVenta();
				
				
				if(conColumnasBase) {this.lineapuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.lineapuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.lineapuntoventa.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.lineapuntoventas.add(this.lineapuntoventa);
			}
			
			this.saveLineaPuntoVentas();
			
			this.connexion.commit();
			
			lineapuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			lineapuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return lineapuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarLineaPuntoVentasEliminados() throws Exception {				
		
		List<LineaPuntoVenta> lineapuntoventasAux= new ArrayList<LineaPuntoVenta>();
		
		for(LineaPuntoVenta lineapuntoventa:lineapuntoventas) {
			if(!lineapuntoventa.getIsDeleted()) {
				lineapuntoventasAux.add(lineapuntoventa);
			}
		}
		
		lineapuntoventas=lineapuntoventasAux;
	}
	
	public void quitarLineaPuntoVentasNulos() throws Exception {				
		
		List<LineaPuntoVenta> lineapuntoventasAux= new ArrayList<LineaPuntoVenta>();
		
		for(LineaPuntoVenta lineapuntoventa : this.lineapuntoventas) {
			if(lineapuntoventa==null) {
				lineapuntoventasAux.add(lineapuntoventa);
			}
		}
		
		//this.lineapuntoventas=lineapuntoventasAux;
		
		this.lineapuntoventas.removeAll(lineapuntoventasAux);
	}
	
	public void getSetVersionRowLineaPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(lineapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((lineapuntoventa.getIsDeleted() || (lineapuntoventa.getIsChanged()&&!lineapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=lineapuntoventaDataAccess.getSetVersionRowLineaPuntoVenta(connexion,lineapuntoventa.getId());
				
				if(!lineapuntoventa.getVersionRow().equals(timestamp)) {	
					lineapuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				lineapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLineaPuntoVenta()throws Exception {	
		
		if(lineapuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((lineapuntoventa.getIsDeleted() || (lineapuntoventa.getIsChanged()&&!lineapuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=lineapuntoventaDataAccess.getSetVersionRowLineaPuntoVenta(connexion,lineapuntoventa.getId());
			
			try {							
				if(!lineapuntoventa.getVersionRow().equals(timestamp)) {	
					lineapuntoventa.setVersionRow(timestamp);
				}
				
				lineapuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowLineaPuntoVentasWithConnection()throws Exception {	
		if(lineapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(LineaPuntoVenta lineapuntoventaAux:lineapuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(lineapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lineapuntoventaAux.getIsDeleted() || (lineapuntoventaAux.getIsChanged()&&!lineapuntoventaAux.getIsNew())) {
						
						timestamp=lineapuntoventaDataAccess.getSetVersionRowLineaPuntoVenta(connexion,lineapuntoventaAux.getId());
						
						if(!lineapuntoventa.getVersionRow().equals(timestamp)) {	
							lineapuntoventaAux.setVersionRow(timestamp);
						}
								
						lineapuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowLineaPuntoVentas()throws Exception {	
		if(lineapuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(LineaPuntoVenta lineapuntoventaAux:lineapuntoventas) {
					if(lineapuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lineapuntoventaAux.getIsDeleted() || (lineapuntoventaAux.getIsChanged()&&!lineapuntoventaAux.getIsNew())) {
						
						timestamp=lineapuntoventaDataAccess.getSetVersionRowLineaPuntoVenta(connexion,lineapuntoventaAux.getId());
						
						if(!lineapuntoventaAux.getVersionRow().equals(timestamp)) {	
							lineapuntoventaAux.setVersionRow(timestamp);
						}
						
													
						lineapuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public LineaPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyLineaPuntoVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca) throws Exception {
		LineaPuntoVentaParameterReturnGeneral  lineapuntoventaReturnGeneral =new LineaPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyLineaPuntoVentaWithConnection");connexion.begin();
			
			lineapuntoventaReturnGeneral =new LineaPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			lineapuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			lineapuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			lineapuntoventaReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			lineapuntoventaReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			lineapuntoventaReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			lineapuntoventaReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return lineapuntoventaReturnGeneral;
	}
	
	public LineaPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyLineaPuntoVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalLinea,String finalQueryGlobalLineaGrupo,String finalQueryGlobalLineaCategoria,String finalQueryGlobalLineaMarca) throws Exception {
		LineaPuntoVentaParameterReturnGeneral  lineapuntoventaReturnGeneral =new LineaPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			lineapuntoventaReturnGeneral =new LineaPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			lineapuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			lineapuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Linea> lineasForeignKey=new ArrayList<Linea>();
			LineaLogic lineaLogic=new LineaLogic();
			lineaLogic.setConnexion(this.connexion);
			lineaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLinea.equals("NONE")) {
				lineaLogic.getTodosLineas(finalQueryGlobalLinea,new Pagination());
				lineasForeignKey=lineaLogic.getLineas();
			}

			lineapuntoventaReturnGeneral.setlineasForeignKey(lineasForeignKey);


			List<Linea> lineagruposForeignKey=new ArrayList<Linea>();
			LineaLogic lineagrupoLogic=new LineaLogic();
			lineagrupoLogic.setConnexion(this.connexion);
			lineagrupoLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaGrupo.equals("NONE")) {
				lineagrupoLogic.getTodosLineas(finalQueryGlobalLineaGrupo,new Pagination());
				lineagruposForeignKey=lineagrupoLogic.getLineas();
			}

			lineapuntoventaReturnGeneral.setlineagruposForeignKey(lineagruposForeignKey);


			List<Linea> lineacategoriasForeignKey=new ArrayList<Linea>();
			LineaLogic lineacategoriaLogic=new LineaLogic();
			lineacategoriaLogic.setConnexion(this.connexion);
			lineacategoriaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaCategoria.equals("NONE")) {
				lineacategoriaLogic.getTodosLineas(finalQueryGlobalLineaCategoria,new Pagination());
				lineacategoriasForeignKey=lineacategoriaLogic.getLineas();
			}

			lineapuntoventaReturnGeneral.setlineacategoriasForeignKey(lineacategoriasForeignKey);


			List<Linea> lineamarcasForeignKey=new ArrayList<Linea>();
			LineaLogic lineamarcaLogic=new LineaLogic();
			lineamarcaLogic.setConnexion(this.connexion);
			lineamarcaLogic.getLineaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaMarca.equals("NONE")) {
				lineamarcaLogic.getTodosLineas(finalQueryGlobalLineaMarca,new Pagination());
				lineamarcasForeignKey=lineamarcaLogic.getLineas();
			}

			lineapuntoventaReturnGeneral.setlineamarcasForeignKey(lineamarcasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return lineapuntoventaReturnGeneral;
	}
	
	
	public void deepLoad(LineaPuntoVenta lineapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			LineaPuntoVentaLogicAdditional.updateLineaPuntoVentaToGet(lineapuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		lineapuntoventa.setEmpresa(lineapuntoventaDataAccess.getEmpresa(connexion,lineapuntoventa));
		lineapuntoventa.setSucursal(lineapuntoventaDataAccess.getSucursal(connexion,lineapuntoventa));
		lineapuntoventa.setLinea(lineapuntoventaDataAccess.getLinea(connexion,lineapuntoventa));
		lineapuntoventa.setLineaGrupo(lineapuntoventaDataAccess.getLineaGrupo(connexion,lineapuntoventa));
		lineapuntoventa.setLineaCategoria(lineapuntoventaDataAccess.getLineaCategoria(connexion,lineapuntoventa));
		lineapuntoventa.setLineaMarca(lineapuntoventaDataAccess.getLineaMarca(connexion,lineapuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				lineapuntoventa.setEmpresa(lineapuntoventaDataAccess.getEmpresa(connexion,lineapuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				lineapuntoventa.setSucursal(lineapuntoventaDataAccess.getSucursal(connexion,lineapuntoventa));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				lineapuntoventa.setLinea(lineapuntoventaDataAccess.getLinea(connexion,lineapuntoventa));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				lineapuntoventa.setLineaGrupo(lineapuntoventaDataAccess.getLineaGrupo(connexion,lineapuntoventa));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				lineapuntoventa.setLineaCategoria(lineapuntoventaDataAccess.getLineaCategoria(connexion,lineapuntoventa));
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				lineapuntoventa.setLineaMarca(lineapuntoventaDataAccess.getLineaMarca(connexion,lineapuntoventa));
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
			lineapuntoventa.setEmpresa(lineapuntoventaDataAccess.getEmpresa(connexion,lineapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setSucursal(lineapuntoventaDataAccess.getSucursal(connexion,lineapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setLinea(lineapuntoventaDataAccess.getLinea(connexion,lineapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setLineaGrupo(lineapuntoventaDataAccess.getLineaGrupo(connexion,lineapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setLineaCategoria(lineapuntoventaDataAccess.getLineaCategoria(connexion,lineapuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setLineaMarca(lineapuntoventaDataAccess.getLineaMarca(connexion,lineapuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		lineapuntoventa.setEmpresa(lineapuntoventaDataAccess.getEmpresa(connexion,lineapuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(lineapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		lineapuntoventa.setSucursal(lineapuntoventaDataAccess.getSucursal(connexion,lineapuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(lineapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		lineapuntoventa.setLinea(lineapuntoventaDataAccess.getLinea(connexion,lineapuntoventa));
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(lineapuntoventa.getLinea(),isDeep,deepLoadType,clases);
				
		lineapuntoventa.setLineaGrupo(lineapuntoventaDataAccess.getLineaGrupo(connexion,lineapuntoventa));
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(lineapuntoventa.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		lineapuntoventa.setLineaCategoria(lineapuntoventaDataAccess.getLineaCategoria(connexion,lineapuntoventa));
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(lineapuntoventa.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		lineapuntoventa.setLineaMarca(lineapuntoventaDataAccess.getLineaMarca(connexion,lineapuntoventa));
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(lineapuntoventa.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				lineapuntoventa.setEmpresa(lineapuntoventaDataAccess.getEmpresa(connexion,lineapuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(lineapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				lineapuntoventa.setSucursal(lineapuntoventaDataAccess.getSucursal(connexion,lineapuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(lineapuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				lineapuntoventa.setLinea(lineapuntoventaDataAccess.getLinea(connexion,lineapuntoventa));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(lineapuntoventa.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				lineapuntoventa.setLineaGrupo(lineapuntoventaDataAccess.getLineaGrupo(connexion,lineapuntoventa));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(lineapuntoventa.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				lineapuntoventa.setLineaCategoria(lineapuntoventaDataAccess.getLineaCategoria(connexion,lineapuntoventa));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(lineapuntoventa.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				lineapuntoventa.setLineaMarca(lineapuntoventaDataAccess.getLineaMarca(connexion,lineapuntoventa));
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepLoad(lineapuntoventa.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			lineapuntoventa.setEmpresa(lineapuntoventaDataAccess.getEmpresa(connexion,lineapuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(lineapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setSucursal(lineapuntoventaDataAccess.getSucursal(connexion,lineapuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(lineapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setLinea(lineapuntoventaDataAccess.getLinea(connexion,lineapuntoventa));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(lineapuntoventa.getLinea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setLineaGrupo(lineapuntoventaDataAccess.getLineaGrupo(connexion,lineapuntoventa));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(lineapuntoventa.getLineaGrupo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setLineaCategoria(lineapuntoventaDataAccess.getLineaCategoria(connexion,lineapuntoventa));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(lineapuntoventa.getLineaCategoria(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Linea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineapuntoventa.setLineaMarca(lineapuntoventaDataAccess.getLineaMarca(connexion,lineapuntoventa));
			LineaLogic lineaLogic= new LineaLogic(connexion);
			lineaLogic.deepLoad(lineapuntoventa.getLineaMarca(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(LineaPuntoVenta lineapuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			LineaPuntoVentaLogicAdditional.updateLineaPuntoVentaToSave(lineapuntoventa,this.arrDatoGeneral);
			
LineaPuntoVentaDataAccess.save(lineapuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(lineapuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(lineapuntoventa.getSucursal(),connexion);

		LineaDataAccess.save(lineapuntoventa.getLinea(),connexion);

		LineaDataAccess.save(lineapuntoventa.getLineaGrupo(),connexion);

		LineaDataAccess.save(lineapuntoventa.getLineaCategoria(),connexion);

		LineaDataAccess.save(lineapuntoventa.getLineaMarca(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(lineapuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(lineapuntoventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(lineapuntoventa.getLinea(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(lineapuntoventa.getLineaGrupo(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(lineapuntoventa.getLineaCategoria(),connexion);
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(lineapuntoventa.getLineaMarca(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(lineapuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(lineapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(lineapuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(lineapuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(lineapuntoventa.getLinea(),connexion);
		LineaLogic lineaLogic= new LineaLogic(connexion);
		lineaLogic.deepLoad(lineapuntoventa.getLinea(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(lineapuntoventa.getLineaGrupo(),connexion);
		LineaLogic lineagrupoLogic= new LineaLogic(connexion);
		lineagrupoLogic.deepLoad(lineapuntoventa.getLineaGrupo(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(lineapuntoventa.getLineaCategoria(),connexion);
		LineaLogic lineacategoriaLogic= new LineaLogic(connexion);
		lineacategoriaLogic.deepLoad(lineapuntoventa.getLineaCategoria(),isDeep,deepLoadType,clases);
				

		LineaDataAccess.save(lineapuntoventa.getLineaMarca(),connexion);
		LineaLogic lineamarcaLogic= new LineaLogic(connexion);
		lineamarcaLogic.deepLoad(lineapuntoventa.getLineaMarca(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(lineapuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(lineapuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(lineapuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(lineapuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(lineapuntoventa.getLinea(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(lineapuntoventa.getLinea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(lineapuntoventa.getLineaGrupo(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(lineapuntoventa.getLineaGrupo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(lineapuntoventa.getLineaCategoria(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(lineapuntoventa.getLineaCategoria(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Linea.class)) {
				LineaDataAccess.save(lineapuntoventa.getLineaMarca(),connexion);
				LineaLogic lineaLogic= new LineaLogic(connexion);
				lineaLogic.deepSave(lineapuntoventa.getLineaMarca(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(LineaPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(lineapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(lineapuntoventa);
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
			this.deepLoad(this.lineapuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LineaPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(lineapuntoventas!=null) {
				for(LineaPuntoVenta lineapuntoventa:lineapuntoventas) {
					this.deepLoad(lineapuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(lineapuntoventas);
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
			if(lineapuntoventas!=null) {
				for(LineaPuntoVenta lineapuntoventa:lineapuntoventas) {
					this.deepLoad(lineapuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(lineapuntoventas);
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
			this.getNewConnexionToDeep(LineaPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(lineapuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(LineaPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(lineapuntoventas!=null) {
				for(LineaPuntoVenta lineapuntoventa:lineapuntoventas) {
					this.deepSave(lineapuntoventa,isDeep,deepLoadType,clases);
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
			if(lineapuntoventas!=null) {
				for(LineaPuntoVenta lineapuntoventa:lineapuntoventas) {
					this.deepSave(lineapuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getLineaPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaPuntoVentasFK_IdLineaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,LineaPuntoVentaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaPuntoVentasFK_IdLinea(String sFinalQuery,Pagination pagination,Long id_linea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLinea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLinea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea,LineaPuntoVentaConstantesFunciones.IDLINEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLinea);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLinea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaPuntoVentasFK_IdLineaCategoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaPuntoVentasFK_IdLineaCategoria(String sFinalQuery,Pagination pagination,Long id_linea_categoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaCategoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaCategoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_categoria,LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaCategoria);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaCategoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaPuntoVentasFK_IdLineaGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaPuntoVentasFK_IdLineaGrupo(String sFinalQuery,Pagination pagination,Long id_linea_grupo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaGrupo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaGrupo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_grupo,LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaGrupo);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaPuntoVentasFK_IdLineaMarcaWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,LineaPuntoVentaConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaPuntoVentasFK_IdLineaMarca(String sFinalQuery,Pagination pagination,Long id_linea_marca)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaMarca= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaMarca.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_marca,LineaPuntoVentaConstantesFunciones.IDLINEAMARCA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaMarca);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaMarca","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,LineaPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,LineaPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			LineaPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineapuntoventas=lineapuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesLineaPuntoVenta(this.lineapuntoventas);
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
			if(LineaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,LineaPuntoVenta lineapuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LineaPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(lineapuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaPuntoVentaDataAccess.TABLENAME, lineapuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LineaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LineaPuntoVentaLogic.registrarAuditoriaDetallesLineaPuntoVenta(connexion,lineapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(lineapuntoventa.getIsDeleted()) {
					/*if(!lineapuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,LineaPuntoVentaDataAccess.TABLENAME, lineapuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////LineaPuntoVentaLogic.registrarAuditoriaDetallesLineaPuntoVenta(connexion,lineapuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaPuntoVentaDataAccess.TABLENAME, lineapuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(lineapuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaPuntoVentaDataAccess.TABLENAME, lineapuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LineaPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LineaPuntoVentaLogic.registrarAuditoriaDetallesLineaPuntoVenta(connexion,lineapuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesLineaPuntoVenta(Connexion connexion,LineaPuntoVenta lineapuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(lineapuntoventa.getIsNew()||!lineapuntoventa.getid_empresa().equals(lineapuntoventa.getLineaPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineapuntoventa.getLineaPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=lineapuntoventa.getLineaPuntoVentaOriginal().getid_empresa().toString();
				}
				if(lineapuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=lineapuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(lineapuntoventa.getIsNew()||!lineapuntoventa.getid_sucursal().equals(lineapuntoventa.getLineaPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineapuntoventa.getLineaPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=lineapuntoventa.getLineaPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(lineapuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=lineapuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(lineapuntoventa.getIsNew()||!lineapuntoventa.getid_linea().equals(lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea()!=null)
				{
					strValorActual=lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea().toString();
				}
				if(lineapuntoventa.getid_linea()!=null)
				{
					strValorNuevo=lineapuntoventa.getid_linea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaPuntoVentaConstantesFunciones.IDLINEA,strValorActual,strValorNuevo);
			}	
			
			if(lineapuntoventa.getIsNew()||!lineapuntoventa.getid_linea_grupo().equals(lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_grupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_grupo()!=null)
				{
					strValorActual=lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_grupo().toString();
				}
				if(lineapuntoventa.getid_linea_grupo()!=null)
				{
					strValorNuevo=lineapuntoventa.getid_linea_grupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaPuntoVentaConstantesFunciones.IDLINEAGRUPO,strValorActual,strValorNuevo);
			}	
			
			if(lineapuntoventa.getIsNew()||!lineapuntoventa.getid_linea_categoria().equals(lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_categoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_categoria()!=null)
				{
					strValorActual=lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_categoria().toString();
				}
				if(lineapuntoventa.getid_linea_categoria()!=null)
				{
					strValorNuevo=lineapuntoventa.getid_linea_categoria().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaPuntoVentaConstantesFunciones.IDLINEACATEGORIA,strValorActual,strValorNuevo);
			}	
			
			if(lineapuntoventa.getIsNew()||!lineapuntoventa.getid_linea_marca().equals(lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_marca()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_marca()!=null)
				{
					strValorActual=lineapuntoventa.getLineaPuntoVentaOriginal().getid_linea_marca().toString();
				}
				if(lineapuntoventa.getid_linea_marca()!=null)
				{
					strValorNuevo=lineapuntoventa.getid_linea_marca().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaPuntoVentaConstantesFunciones.IDLINEAMARCA,strValorActual,strValorNuevo);
			}	
			
			if(lineapuntoventa.getIsNew()||!lineapuntoventa.getesta_activo().equals(lineapuntoventa.getLineaPuntoVentaOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineapuntoventa.getLineaPuntoVentaOriginal().getesta_activo()!=null)
				{
					strValorActual=lineapuntoventa.getLineaPuntoVentaOriginal().getesta_activo().toString();
				}
				if(lineapuntoventa.getesta_activo()!=null)
				{
					strValorNuevo=lineapuntoventa.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaPuntoVentaConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveLineaPuntoVentaRelacionesWithConnection(LineaPuntoVenta lineapuntoventa) throws Exception {

		if(!lineapuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLineaPuntoVentaRelacionesBase(lineapuntoventa,true);
		}
	}

	public void saveLineaPuntoVentaRelaciones(LineaPuntoVenta lineapuntoventa)throws Exception {

		if(!lineapuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLineaPuntoVentaRelacionesBase(lineapuntoventa,false);
		}
	}

	public void saveLineaPuntoVentaRelacionesBase(LineaPuntoVenta lineapuntoventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("LineaPuntoVenta-saveRelacionesWithConnection");}
	

			this.setLineaPuntoVenta(lineapuntoventa);

			if(LineaPuntoVentaLogicAdditional.validarSaveRelaciones(lineapuntoventa,this)) {

				LineaPuntoVentaLogicAdditional.updateRelacionesToSave(lineapuntoventa,this);

				if((lineapuntoventa.getIsNew()||lineapuntoventa.getIsChanged())&&!lineapuntoventa.getIsDeleted()) {
					this.saveLineaPuntoVenta();
					this.saveLineaPuntoVentaRelacionesDetalles();

				} else if(lineapuntoventa.getIsDeleted()) {
					this.saveLineaPuntoVentaRelacionesDetalles();
					this.saveLineaPuntoVenta();
				}

				LineaPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(lineapuntoventa,this);

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
	
	
	private void saveLineaPuntoVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfLineaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LineaPuntoVentaConstantesFunciones.getClassesForeignKeysOfLineaPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LineaPuntoVentaConstantesFunciones.getClassesRelationshipsOfLineaPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
