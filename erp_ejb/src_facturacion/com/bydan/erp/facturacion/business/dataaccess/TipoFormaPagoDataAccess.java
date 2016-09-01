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
package com.bydan.erp.facturacion.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoFormaPagoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class TipoFormaPagoDataAccess extends  TipoFormaPagoDataAccessAdditional{ //TipoFormaPagoDataAccessAdditional,DataAccessHelper<TipoFormaPago>
	//static Logger logger = Logger.getLogger(TipoFormaPagoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_forma_pago";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_tipo_grupo_forma_pago,nombre,siglas,con_detalle,con_cuotas,id_tipo_transaccion_modulo,id_transaccion,id_cuenta_contable,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_tipo_grupo_forma_pago=?,nombre=?,siglas=?,con_detalle=?,con_cuotas=?,id_tipo_transaccion_modulo=?,id_transaccion=?,id_cuenta_contable=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoformapago from "+TipoFormaPagoConstantesFunciones.SPERSISTENCENAME+" tipoformapago";
	public static String QUERYSELECTNATIVE="select "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_empresa,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_sucursal,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_modulo,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_tipo_grupo_forma_pago,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".nombre,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".siglas,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".con_detalle,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".con_cuotas,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_transaccion,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".descripcion from "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME;//+" as "+TipoFormaPagoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".id,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".version_row,"+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+".nombre from "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME;//+" as "+TipoFormaPagoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoFormaPagoConstantesFunciones.SCHEMA+"."+TipoFormaPagoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_tipo_grupo_forma_pago=?,nombre=?,siglas=?,con_detalle=?,con_cuotas=?,id_tipo_transaccion_modulo=?,id_transaccion=?,id_cuenta_contable=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOFORMAPAGO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOFORMAPAGO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOFORMAPAGO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOFORMAPAGO_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected TipoFormaPagoDataAccessAdditional tipoformapagoDataAccessAdditional=null;
	
	public TipoFormaPagoDataAccessAdditional getTipoFormaPagoDataAccessAdditional() {
		return this.tipoformapagoDataAccessAdditional;
	}
	
	public void setTipoFormaPagoDataAccessAdditional(TipoFormaPagoDataAccessAdditional tipoformapagoDataAccessAdditional) {
		try {
			this.tipoformapagoDataAccessAdditional=tipoformapagoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoFormaPagoDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		TipoFormaPagoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoFormaPagoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoFormaPagoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
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

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setTipoFormaPagoOriginal(TipoFormaPago tipoformapago)throws Exception  {
		tipoformapago.setTipoFormaPagoOriginal((TipoFormaPago)tipoformapago.clone());		
	}
	
	public void setTipoFormaPagosOriginal(List<TipoFormaPago> tipoformapagos)throws Exception  {
		
		for(TipoFormaPago tipoformapago:tipoformapagos){
			tipoformapago.setTipoFormaPagoOriginal((TipoFormaPago)tipoformapago.clone());
		}
	}
	
	public static void setTipoFormaPagoOriginalStatic(TipoFormaPago tipoformapago)throws Exception  {
		tipoformapago.setTipoFormaPagoOriginal((TipoFormaPago)tipoformapago.clone());		
	}
	
	public static void setTipoFormaPagosOriginalStatic(List<TipoFormaPago> tipoformapagos)throws Exception  {
		
		for(TipoFormaPago tipoformapago:tipoformapagos){
			tipoformapago.setTipoFormaPagoOriginal((TipoFormaPago)tipoformapago.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  TipoFormaPago getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoFormaPago entity = new TipoFormaPago();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  TipoFormaPago getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoFormaPago entity = new TipoFormaPago();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoFormaPago.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoFormaPagoOriginal(new TipoFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoFormaPago("",entity,resultSet); 
				
				//entity.setTipoFormaPagoOriginal(super.getEntity("",entity.getTipoFormaPagoOriginal(),resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormaPagoOriginal(this.getEntityTipoFormaPago("",entity.getTipoFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoFormaPago(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoFormaPago getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoFormaPago entity = new TipoFormaPago();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoFormaPago getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoFormaPago entity = new TipoFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoFormaPago.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoFormaPagoOriginal(new TipoFormaPago());
      	    	entity=super.getEntity("",entity,resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoFormaPago("",entity,resultSet);    
				
				//entity.setTipoFormaPagoOriginal(super.getEntity("",entity.getTipoFormaPagoOriginal(),resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormaPagoOriginal(this.getEntityTipoFormaPago("",entity.getTipoFormaPagoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoFormaPago
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoFormaPago entity = new TipoFormaPago();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoFormaPago.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseTipoFormaPago(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoFormaPago> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoFormaPago> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFormaPago("",entity,resultSet);
      	    	
				//entity.setTipoFormaPagoOriginal( new TipoFormaPago());
      	    	//entity.setTipoFormaPagoOriginal(super.getEntity("",entity.getTipoFormaPagoOriginal(),resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormaPagoOriginal(this.getEntityTipoFormaPago("",entity.getTipoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFormaPagos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoFormaPago();
					//entity.setMapTipoFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=TipoFormaPagoDataAccess.getEntityTipoFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoFormaPagoOriginal( new TipoFormaPago());
					////entity.setTipoFormaPagoOriginal(super.getEntity("",entity.getTipoFormaPagoOriginal(),resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoFormaPagoOriginal(this.getEntityTipoFormaPago("",entity.getTipoFormaPagoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFormaPagos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoFormaPago getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  TipoFormaPago getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormaPago();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoFormaPago();
					//entity.setMapTipoFormaPago(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoFormaPagoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoFormaPago().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=TipoFormaPagoDataAccess.getEntityTipoFormaPago("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoFormaPagoOriginal( new TipoFormaPago());
					////entity.setTipoFormaPagoOriginal(super.getEntity("",entity.getTipoFormaPagoOriginal(),resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoFormaPagoOriginal(this.getEntityTipoFormaPago("",entity.getTipoFormaPagoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoFormaPago(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoFormaPago getEntityTipoFormaPago(String strPrefijo,TipoFormaPago entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoFormaPago.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoFormaPagoDataAccess.setFieldReflectionTipoFormaPago(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoFormaPago=TipoFormaPagoConstantesFunciones.getTodosTiposColumnasTipoFormaPago();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoFormaPago) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = TipoFormaPago.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoFormaPago.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoFormaPagoDataAccess.setFieldReflectionTipoFormaPago(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoFormaPago(Field field,String strPrefijo,String sColumn,TipoFormaPago entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoFormaPagoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.SIGLAS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.CONDETALLE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.CONCUOTAS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.IDTRANSACCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoFormaPagoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoFormaPago>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new TipoFormaPago();
					entity=super.getEntity("",entity,resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoFormaPago("",entity,resultSet);
					
					//entity.setTipoFormaPagoOriginal( new TipoFormaPago());
					//entity.setTipoFormaPagoOriginal(super.getEntity("",entity.getTipoFormaPagoOriginal(),resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoFormaPagoOriginal(this.getEntityTipoFormaPago("",entity.getTipoFormaPagoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoFormaPagos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoFormaPago>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoFormaPagoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoFormaPagoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<TipoFormaPago> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoFormaPago> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFormaPago("",entity,resultSet);
      	    	
				//entity.setTipoFormaPagoOriginal( new TipoFormaPago());
      	    	//entity.setTipoFormaPagoOriginal(super.getEntity("",entity.getTipoFormaPagoOriginal(),resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormaPagoOriginal(this.getEntityTipoFormaPago("",entity.getTipoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoFormaPagos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoFormaPago(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoFormaPago> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<TipoFormaPago> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoFormaPago> entities = new  ArrayList<TipoFormaPago>();
		TipoFormaPago entity = new TipoFormaPago();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoFormaPago();
      	    	entity=super.getEntity("",entity,resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoFormaPago("",entity,resultSet);
      	    	
				//entity.setTipoFormaPagoOriginal( new TipoFormaPago());
      	    	//entity.setTipoFormaPagoOriginal(super.getEntity("",entity.getTipoFormaPagoOriginal(),resultSet,TipoFormaPagoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoFormaPagoOriginal(this.getEntityTipoFormaPago("",entity.getTipoFormaPagoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoFormaPagos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoFormaPago getEntityTipoFormaPago(String strPrefijo,TipoFormaPago entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoFormaPagoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TipoFormaPagoConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+TipoFormaPagoConstantesFunciones.IDMODULO));if(resultSet.wasNull()) {entity.setid_modulo(null); }
				entity.setid_tipo_grupo_forma_pago(resultSet.getLong(strPrefijo+TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoFormaPagoConstantesFunciones.NOMBRE));
				entity.setsiglas(resultSet.getString(strPrefijo+TipoFormaPagoConstantesFunciones.SIGLAS));
				entity.setcon_detalle(resultSet.getBoolean(strPrefijo+TipoFormaPagoConstantesFunciones.CONDETALLE));
				entity.setcon_cuotas(resultSet.getBoolean(strPrefijo+TipoFormaPagoConstantesFunciones.CONCUOTAS));
				entity.setid_tipo_transaccion_modulo(resultSet.getLong(strPrefijo+TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO));if(resultSet.wasNull()) {entity.setid_tipo_transaccion_modulo(null); }
				entity.setid_transaccion(resultSet.getLong(strPrefijo+TipoFormaPagoConstantesFunciones.IDTRANSACCION));if(resultSet.wasNull()) {entity.setid_transaccion(null); }
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE));if(resultSet.wasNull()) {entity.setid_cuenta_contable(null); }
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoFormaPagoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoFormaPagoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoFormaPago(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoFormaPago entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoFormaPagoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoFormaPagoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoFormaPagoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoFormaPagoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoFormaPagoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoFormaPagoDataAccess.TABLENAME,TipoFormaPagoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoFormaPagoDataAccess.setTipoFormaPagoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoFormaPago reltipoformapago)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoformapago.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TipoFormaPago reltipoformapago)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltipoformapago.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,TipoFormaPago reltipoformapago)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,reltipoformapago.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public TipoGrupoFormaPago getTipoGrupoFormaPago(Connexion connexion,TipoFormaPago reltipoformapago)throws SQLException,Exception {

		TipoGrupoFormaPago tipogrupoformapago= new TipoGrupoFormaPago();

		try {
			TipoGrupoFormaPagoDataAccess tipogrupoformapagoDataAccess=new TipoGrupoFormaPagoDataAccess();

			tipogrupoformapagoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogrupoformapagoDataAccess.setConnexionType(this.connexionType);
			tipogrupoformapagoDataAccess.setParameterDbType(this.parameterDbType);

			tipogrupoformapago=tipogrupoformapagoDataAccess.getEntity(connexion,reltipoformapago.getid_tipo_grupo_forma_pago());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogrupoformapago;

	}

	public TipoTransaccionModulo getTipoTransaccionModulo(Connexion connexion,TipoFormaPago reltipoformapago)throws SQLException,Exception {

		TipoTransaccionModulo tipotransaccionmodulo= new TipoTransaccionModulo();

		try {
			TipoTransaccionModuloDataAccess tipotransaccionmoduloDataAccess=new TipoTransaccionModuloDataAccess();

			tipotransaccionmoduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotransaccionmoduloDataAccess.setConnexionType(this.connexionType);
			tipotransaccionmoduloDataAccess.setParameterDbType(this.parameterDbType);

			tipotransaccionmodulo=tipotransaccionmoduloDataAccess.getEntity(connexion,reltipoformapago.getid_tipo_transaccion_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotransaccionmodulo;

	}

	public Transaccion getTransaccion(Connexion connexion,TipoFormaPago reltipoformapago)throws SQLException,Exception {

		Transaccion transaccion= new Transaccion();

		try {
			TransaccionDataAccess transaccionDataAccess=new TransaccionDataAccess();

			transaccionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccionDataAccess.setConnexionType(this.connexionType);
			transaccionDataAccess.setParameterDbType(this.parameterDbType);

			transaccion=transaccionDataAccess.getEntity(connexion,reltipoformapago.getid_transaccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccion;

	}

	public CuentaContable getCuentaContable(Connexion connexion,TipoFormaPago reltipoformapago)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipoformapago.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<RegistroFormaPagoBanco> getRegistroFormaPagoBancos(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<RegistroFormaPagoBanco> registroformapagobancos= new ArrayList<RegistroFormaPagoBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+".registro_forma_pago_banco.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN registroformapagobanco.TipoFormaPago WHERE registroformapagobanco.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			RegistroFormaPagoBancoDataAccess registroformapagobancoDataAccess=new RegistroFormaPagoBancoDataAccess();

			registroformapagobancoDataAccess.setConnexionType(this.connexionType);
			registroformapagobancoDataAccess.setParameterDbType(this.parameterDbType);
			registroformapagobancos=registroformapagobancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return registroformapagobancos;

	}

	public List<DetaFormaPagoFactu> getDetaFormaPagoFactus(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<DetaFormaPagoFactu> detaformapagofactus= new ArrayList<DetaFormaPagoFactu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+DetaFormaPagoFactuConstantesFunciones.SCHEMA+".deta_forma_pago_factu.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN detaformapagofactu.TipoFormaPago WHERE detaformapagofactu.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaFormaPagoFactuDataAccess detaformapagofactuDataAccess=new DetaFormaPagoFactuDataAccess();

			detaformapagofactuDataAccess.setConnexionType(this.connexionType);
			detaformapagofactuDataAccess.setParameterDbType(this.parameterDbType);
			detaformapagofactus=detaformapagofactuDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detaformapagofactus;

	}

	public List<GrupoClienteFormaPago> getGrupoClienteFormaPagos(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<GrupoClienteFormaPago> grupoclienteformapagos= new ArrayList<GrupoClienteFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+GrupoClienteFormaPagoConstantesFunciones.SCHEMA+".grupo_cliente_forma_pago.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN grupoclienteformapago.TipoFormaPago WHERE grupoclienteformapago.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			GrupoClienteFormaPagoDataAccess grupoclienteformapagoDataAccess=new GrupoClienteFormaPagoDataAccess();

			grupoclienteformapagoDataAccess.setConnexionType(this.connexionType);
			grupoclienteformapagoDataAccess.setParameterDbType(this.parameterDbType);
			grupoclienteformapagos=grupoclienteformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupoclienteformapagos;

	}

	public List<DetaFormaPago> getDetaFormaPagos(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<DetaFormaPago> detaformapagos= new ArrayList<DetaFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+DetaFormaPagoConstantesFunciones.SCHEMA+".deta_forma_pago.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN detaformapago.TipoFormaPago WHERE detaformapago.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaFormaPagoDataAccess detaformapagoDataAccess=new DetaFormaPagoDataAccess();

			detaformapagoDataAccess.setConnexionType(this.connexionType);
			detaformapagoDataAccess.setParameterDbType(this.parameterDbType);
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detaformapagos;

	}

	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.TipoFormaPago WHERE formapagopuntoventa.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess=new FormaPagoPuntoVentaDataAccess();

			formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagopuntoventas;

	}

	public List<ChequePostFechado> getChequePostFechados(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<ChequePostFechado> chequepostfechados= new ArrayList<ChequePostFechado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+ChequePostFechadoConstantesFunciones.SCHEMA+".cheque_post_fechado.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN chequepostfechado.TipoFormaPago WHERE chequepostfechado.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ChequePostFechadoDataAccess chequepostfechadoDataAccess=new ChequePostFechadoDataAccess();

			chequepostfechadoDataAccess.setConnexionType(this.connexionType);
			chequepostfechadoDataAccess.setParameterDbType(this.parameterDbType);
			chequepostfechados=chequepostfechadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return chequepostfechados;

	}

	public List<FormaPago> getFormaPagos(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<FormaPago> formapagos= new ArrayList<FormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+FormaPagoConstantesFunciones.SCHEMA+".forma_pago.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN formapago.TipoFormaPago WHERE formapago.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoDataAccess formapagoDataAccess=new FormaPagoDataAccess();

			formapagoDataAccess.setConnexionType(this.connexionType);
			formapagoDataAccess.setParameterDbType(this.parameterDbType);
			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagos;

	}

	public List<FormaPagoInven> getFormaPagoInvens(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<FormaPagoInven> formapagoinvens= new ArrayList<FormaPagoInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+FormaPagoInvenConstantesFunciones.SCHEMA+".forma_pago_inven.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN formapagoinven.TipoFormaPago WHERE formapagoinven.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoInvenDataAccess formapagoinvenDataAccess=new FormaPagoInvenDataAccess();

			formapagoinvenDataAccess.setConnexionType(this.connexionType);
			formapagoinvenDataAccess.setParameterDbType(this.parameterDbType);
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagoinvens;

	}

	public List<DetallePago> getDetallePagos(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<DetallePago> detallepagos= new ArrayList<DetallePago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+DetallePagoConstantesFunciones.SCHEMA+".detalle_pago.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN detallepago.TipoFormaPago WHERE detallepago.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePagoDataAccess detallepagoDataAccess=new DetallePagoDataAccess();

			detallepagoDataAccess.setConnexionType(this.connexionType);
			detallepagoDataAccess.setParameterDbType(this.parameterDbType);
			detallepagos=detallepagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepagos;

	}

	public List<CierreCaja> getCierreCajas(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<CierreCaja> cierrecajas= new ArrayList<CierreCaja>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+CierreCajaConstantesFunciones.SCHEMA+".cierre_caja.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN cierrecaja.TipoFormaPago WHERE cierrecaja.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CierreCajaDataAccess cierrecajaDataAccess=new CierreCajaDataAccess();

			cierrecajaDataAccess.setConnexionType(this.connexionType);
			cierrecajaDataAccess.setParameterDbType(this.parameterDbType);
			cierrecajas=cierrecajaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cierrecajas;

	}

	public List<HistorialFormaPago> getHistorialFormaPagos(Connexion connexion,TipoFormaPago tipoformapago)throws SQLException,Exception {

		List<HistorialFormaPago> historialformapagos= new ArrayList<HistorialFormaPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago ON "+HistorialFormaPagoConstantesFunciones.SCHEMA+".historial_forma_pago.id_tipo_forma_pago="+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id WHERE "+TipoFormaPagoConstantesFunciones.SCHEMA+".tipo_forma_pago.id="+String.valueOf(tipoformapago.getId());
			} else {
				sQuery=" INNER JOIN historialformapago.TipoFormaPago WHERE historialformapago.TipoFormaPago.id="+String.valueOf(tipoformapago.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			HistorialFormaPagoDataAccess historialformapagoDataAccess=new HistorialFormaPagoDataAccess();

			historialformapagoDataAccess.setConnexionType(this.connexionType);
			historialformapagoDataAccess.setParameterDbType(this.parameterDbType);
			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return historialformapagos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoFormaPago tipoformapago) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoformapago.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoformapago.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(tipoformapago.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(tipoformapago.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_grupo_forma_pago=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_grupo_forma_pago.setValue(tipoformapago.getid_tipo_grupo_forma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_grupo_forma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoformapago.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesiglas=new ParameterValue<String>();
					parameterMaintenanceValuesiglas.setValue(tipoformapago.getsiglas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesiglas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_detalle=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_detalle.setValue(tipoformapago.getcon_detalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_detalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cuotas=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cuotas.setValue(tipoformapago.getcon_cuotas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cuotas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_transaccion_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_transaccion_modulo.setValue(tipoformapago.getid_tipo_transaccion_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_transaccion_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion.setValue(tipoformapago.getid_transaccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(tipoformapago.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipoformapago.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoformapago.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoformapago.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoformapago.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoformapago.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseTipoFormaPago(TipoFormaPago tipoformapago)throws Exception  {		
		tipoformapago.setIsNew(false);
		tipoformapago.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoFormaPagos(List<TipoFormaPago> tipoformapagos)throws Exception  {				
		for(TipoFormaPago tipoformapago:tipoformapagos) {
			tipoformapago.setIsNew(false);
			tipoformapago.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoFormaPago(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
