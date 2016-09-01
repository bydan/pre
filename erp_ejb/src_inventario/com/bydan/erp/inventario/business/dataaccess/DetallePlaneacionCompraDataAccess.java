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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//DetallePlaneacionCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class DetallePlaneacionCompraDataAccess extends  DetallePlaneacionCompraDataAccessAdditional{ //DetallePlaneacionCompraDataAccessAdditional,DataAccessHelper<DetallePlaneacionCompra>
	//static Logger logger = Logger.getLogger(DetallePlaneacionCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_planeacion_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_planeacion_compra,id_linea,id_producto,id_unidad,stock,dia_minimo,stock_minimo,dia_maximo,stock_maximo,salida,stock_mensual,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_planeacion_compra=?,id_linea=?,id_producto=?,id_unidad=?,stock=?,dia_minimo=?,stock_minimo=?,dia_maximo=?,stock_maximo=?,salida=?,stock_mensual=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleplaneacioncompra from "+DetallePlaneacionCompraConstantesFunciones.SPERSISTENCENAME+" detalleplaneacioncompra";
	public static String QUERYSELECTNATIVE="select "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".version_row,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_empresa,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_periodo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_planeacion_compra,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_linea,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_producto,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id_unidad,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".stock,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".dia_minimo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".stock_minimo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".dia_maximo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".stock_maximo,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".salida,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".stock_mensual,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".descripcion from "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME;//+" as "+DetallePlaneacionCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".id,"+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+".version_row from "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME;//+" as "+DetallePlaneacionCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetallePlaneacionCompraConstantesFunciones.SCHEMA+"."+DetallePlaneacionCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_planeacion_compra=?,id_linea=?,id_producto=?,id_unidad=?,stock=?,dia_minimo=?,stock_minimo=?,dia_maximo=?,stock_maximo=?,salida=?,stock_mensual=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLEPLANEACIONCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLEPLANEACIONCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLEPLANEACIONCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLEPLANEACIONCOMPRA_SELECT(?,?)";
	
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
	
	
	protected DetallePlaneacionCompraDataAccessAdditional detalleplaneacioncompraDataAccessAdditional=null;
	
	public DetallePlaneacionCompraDataAccessAdditional getDetallePlaneacionCompraDataAccessAdditional() {
		return this.detalleplaneacioncompraDataAccessAdditional;
	}
	
	public void setDetallePlaneacionCompraDataAccessAdditional(DetallePlaneacionCompraDataAccessAdditional detalleplaneacioncompraDataAccessAdditional) {
		try {
			this.detalleplaneacioncompraDataAccessAdditional=detalleplaneacioncompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetallePlaneacionCompraDataAccess() {
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
		DetallePlaneacionCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetallePlaneacionCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetallePlaneacionCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetallePlaneacionCompraOriginal(DetallePlaneacionCompra detalleplaneacioncompra)throws Exception  {
		detalleplaneacioncompra.setDetallePlaneacionCompraOriginal((DetallePlaneacionCompra)detalleplaneacioncompra.clone());		
	}
	
	public void setDetallePlaneacionComprasOriginal(List<DetallePlaneacionCompra> detalleplaneacioncompras)throws Exception  {
		
		for(DetallePlaneacionCompra detalleplaneacioncompra:detalleplaneacioncompras){
			detalleplaneacioncompra.setDetallePlaneacionCompraOriginal((DetallePlaneacionCompra)detalleplaneacioncompra.clone());
		}
	}
	
	public static void setDetallePlaneacionCompraOriginalStatic(DetallePlaneacionCompra detalleplaneacioncompra)throws Exception  {
		detalleplaneacioncompra.setDetallePlaneacionCompraOriginal((DetallePlaneacionCompra)detalleplaneacioncompra.clone());		
	}
	
	public static void setDetallePlaneacionComprasOriginalStatic(List<DetallePlaneacionCompra> detalleplaneacioncompras)throws Exception  {
		
		for(DetallePlaneacionCompra detalleplaneacioncompra:detalleplaneacioncompras){
			detalleplaneacioncompra.setDetallePlaneacionCompraOriginal((DetallePlaneacionCompra)detalleplaneacioncompra.clone());
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
	
	public  DetallePlaneacionCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		
		
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
	
	public  DetallePlaneacionCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.DetallePlaneacionCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetallePlaneacionCompraOriginal(new DetallePlaneacionCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePlaneacionCompra("",entity,resultSet); 
				
				//entity.setDetallePlaneacionCompraOriginal(super.getEntity("",entity.getDetallePlaneacionCompraOriginal(),resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePlaneacionCompraOriginal(this.getEntityDetallePlaneacionCompra("",entity.getDetallePlaneacionCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePlaneacionCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetallePlaneacionCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();
				
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
	
	public  DetallePlaneacionCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetallePlaneacionCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetallePlaneacionCompraOriginal(new DetallePlaneacionCompra());
      	    	entity=super.getEntity("",entity,resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetallePlaneacionCompra("",entity,resultSet);    
				
				//entity.setDetallePlaneacionCompraOriginal(super.getEntity("",entity.getDetallePlaneacionCompraOriginal(),resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePlaneacionCompraOriginal(this.getEntityDetallePlaneacionCompra("",entity.getDetallePlaneacionCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetallePlaneacionCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetallePlaneacionCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.DetallePlaneacionCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetallePlaneacionCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetallePlaneacionCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
		
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
	
	public  List<DetallePlaneacionCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePlaneacionCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePlaneacionCompra("",entity,resultSet);
      	    	
				//entity.setDetallePlaneacionCompraOriginal( new DetallePlaneacionCompra());
      	    	//entity.setDetallePlaneacionCompraOriginal(super.getEntity("",entity.getDetallePlaneacionCompraOriginal(),resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePlaneacionCompraOriginal(this.getEntityDetallePlaneacionCompra("",entity.getDetallePlaneacionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePlaneacionCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePlaneacionCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
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
	
	public  List<DetallePlaneacionCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePlaneacionCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePlaneacionCompra();
					//entity.setMapDetallePlaneacionCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetallePlaneacionCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePlaneacionCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetallePlaneacionCompraDataAccess.getEntityDetallePlaneacionCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePlaneacionCompraOriginal( new DetallePlaneacionCompra());
					////entity.setDetallePlaneacionCompraOriginal(super.getEntity("",entity.getDetallePlaneacionCompraOriginal(),resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePlaneacionCompraOriginal(this.getEntityDetallePlaneacionCompra("",entity.getDetallePlaneacionCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePlaneacionCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetallePlaneacionCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
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
	
	public  DetallePlaneacionCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePlaneacionCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapDetallePlaneacionCompra();
					//entity.setMapDetallePlaneacionCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetallePlaneacionCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetallePlaneacionCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA);         		
					entity=DetallePlaneacionCompraDataAccess.getEntityDetallePlaneacionCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetallePlaneacionCompraOriginal( new DetallePlaneacionCompra());
					////entity.setDetallePlaneacionCompraOriginal(super.getEntity("",entity.getDetallePlaneacionCompraOriginal(),resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setDetallePlaneacionCompraOriginal(this.getEntityDetallePlaneacionCompra("",entity.getDetallePlaneacionCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetallePlaneacionCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetallePlaneacionCompra getEntityDetallePlaneacionCompra(String strPrefijo,DetallePlaneacionCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetallePlaneacionCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetallePlaneacionCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetallePlaneacionCompraDataAccess.setFieldReflectionDetallePlaneacionCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetallePlaneacionCompra=DetallePlaneacionCompraConstantesFunciones.getTodosTiposColumnasDetallePlaneacionCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetallePlaneacionCompra) {
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
							field = DetallePlaneacionCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetallePlaneacionCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetallePlaneacionCompraDataAccess.setFieldReflectionDetallePlaneacionCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetallePlaneacionCompra(Field field,String strPrefijo,String sColumn,DetallePlaneacionCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetallePlaneacionCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.STOCK:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.DIAMINIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.SALIDA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetallePlaneacionCompraConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePlaneacionCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetallePlaneacionCompra();
					entity=super.getEntity("",entity,resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetallePlaneacionCompra("",entity,resultSet);
					
					//entity.setDetallePlaneacionCompraOriginal( new DetallePlaneacionCompra());
					//entity.setDetallePlaneacionCompraOriginal(super.getEntity("",entity.getDetallePlaneacionCompraOriginal(),resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setDetallePlaneacionCompraOriginal(this.getEntityDetallePlaneacionCompra("",entity.getDetallePlaneacionCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetallePlaneacionCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetallePlaneacionCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetallePlaneacionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetallePlaneacionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetallePlaneacionCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
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
	
	public  List<DetallePlaneacionCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePlaneacionCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePlaneacionCompra("",entity,resultSet);
      	    	
				//entity.setDetallePlaneacionCompraOriginal( new DetallePlaneacionCompra());
      	    	//entity.setDetallePlaneacionCompraOriginal(super.getEntity("",entity.getDetallePlaneacionCompraOriginal(),resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePlaneacionCompraOriginal(this.getEntityDetallePlaneacionCompra("",entity.getDetallePlaneacionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetallePlaneacionCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetallePlaneacionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetallePlaneacionCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
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
	
	public  List<DetallePlaneacionCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetallePlaneacionCompra> entities = new  ArrayList<DetallePlaneacionCompra>();
		DetallePlaneacionCompra entity = new DetallePlaneacionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetallePlaneacionCompra();
      	    	entity=super.getEntity("",entity,resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetallePlaneacionCompra("",entity,resultSet);
      	    	
				//entity.setDetallePlaneacionCompraOriginal( new DetallePlaneacionCompra());
      	    	//entity.setDetallePlaneacionCompraOriginal(super.getEntity("",entity.getDetallePlaneacionCompraOriginal(),resultSet,DetallePlaneacionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetallePlaneacionCompraOriginal(this.getEntityDetallePlaneacionCompra("",entity.getDetallePlaneacionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetallePlaneacionCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetallePlaneacionCompra getEntityDetallePlaneacionCompra(String strPrefijo,DetallePlaneacionCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetallePlaneacionCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetallePlaneacionCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetallePlaneacionCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetallePlaneacionCompraConstantesFunciones.IDPERIODO));
				entity.setid_planeacion_compra(resultSet.getLong(strPrefijo+DetallePlaneacionCompraConstantesFunciones.IDPLANEACIONCOMPRA));
				entity.setid_linea(resultSet.getLong(strPrefijo+DetallePlaneacionCompraConstantesFunciones.IDLINEA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetallePlaneacionCompraConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetallePlaneacionCompraConstantesFunciones.IDUNIDAD));
				entity.setstock(resultSet.getDouble(strPrefijo+DetallePlaneacionCompraConstantesFunciones.STOCK));
				entity.setdia_minimo(resultSet.getInt(strPrefijo+DetallePlaneacionCompraConstantesFunciones.DIAMINIMO));
				entity.setstock_minimo(resultSet.getDouble(strPrefijo+DetallePlaneacionCompraConstantesFunciones.STOCKMINIMO));
				entity.setdia_maximo(resultSet.getInt(strPrefijo+DetallePlaneacionCompraConstantesFunciones.DIAMAXIMO));
				entity.setstock_maximo(resultSet.getDouble(strPrefijo+DetallePlaneacionCompraConstantesFunciones.STOCKMAXIMO));
				entity.setsalida(resultSet.getDouble(strPrefijo+DetallePlaneacionCompraConstantesFunciones.SALIDA));
				entity.setstock_mensual(resultSet.getDouble(strPrefijo+DetallePlaneacionCompraConstantesFunciones.STOCKMENSUAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetallePlaneacionCompraConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetallePlaneacionCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetallePlaneacionCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetallePlaneacionCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetallePlaneacionCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetallePlaneacionCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetallePlaneacionCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetallePlaneacionCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetallePlaneacionCompraDataAccess.TABLENAME,DetallePlaneacionCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			DetallePlaneacionCompraDataAccess.setDetallePlaneacionCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,DetallePlaneacionCompra reldetalleplaneacioncompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleplaneacioncompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetallePlaneacionCompra reldetalleplaneacioncompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleplaneacioncompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetallePlaneacionCompra reldetalleplaneacioncompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleplaneacioncompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetallePlaneacionCompra reldetalleplaneacioncompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleplaneacioncompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public PlaneacionCompra getPlaneacionCompra(Connexion connexion,DetallePlaneacionCompra reldetalleplaneacioncompra)throws SQLException,Exception {

		PlaneacionCompra planeacioncompra= new PlaneacionCompra();

		try {
			PlaneacionCompraDataAccess planeacioncompraDataAccess=new PlaneacionCompraDataAccess();

			planeacioncompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			planeacioncompraDataAccess.setConnexionType(this.connexionType);
			planeacioncompraDataAccess.setParameterDbType(this.parameterDbType);

			planeacioncompra=planeacioncompraDataAccess.getEntity(connexion,reldetalleplaneacioncompra.getid_planeacion_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return planeacioncompra;

	}

	public Linea getLinea(Connexion connexion,DetallePlaneacionCompra reldetalleplaneacioncompra)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,reldetalleplaneacioncompra.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Producto getProducto(Connexion connexion,DetallePlaneacionCompra reldetalleplaneacioncompra)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetalleplaneacioncompra.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetallePlaneacionCompra reldetalleplaneacioncompra)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetalleplaneacioncompra.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetallePlaneacionCompra detalleplaneacioncompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleplaneacioncompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleplaneacioncompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleplaneacioncompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleplaneacioncompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleplaneacioncompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_planeacion_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_planeacion_compra.setValue(detalleplaneacioncompra.getid_planeacion_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_planeacion_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(detalleplaneacioncompra.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detalleplaneacioncompra.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detalleplaneacioncompra.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuestock=new ParameterValue<Double>();
					parameterMaintenanceValuestock.setValue(detalleplaneacioncompra.getstock());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia_minimo=new ParameterValue<Integer>();
					parameterMaintenanceValuedia_minimo.setValue(detalleplaneacioncompra.getdia_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuestock_minimo=new ParameterValue<Double>();
					parameterMaintenanceValuestock_minimo.setValue(detalleplaneacioncompra.getstock_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuedia_maximo=new ParameterValue<Integer>();
					parameterMaintenanceValuedia_maximo.setValue(detalleplaneacioncompra.getdia_maximo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedia_maximo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuestock_maximo=new ParameterValue<Double>();
					parameterMaintenanceValuestock_maximo.setValue(detalleplaneacioncompra.getstock_maximo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock_maximo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesalida=new ParameterValue<Double>();
					parameterMaintenanceValuesalida.setValue(detalleplaneacioncompra.getsalida());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesalida);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuestock_mensual=new ParameterValue<Double>();
					parameterMaintenanceValuestock_mensual.setValue(detalleplaneacioncompra.getstock_mensual());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock_mensual);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalleplaneacioncompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleplaneacioncompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleplaneacioncompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleplaneacioncompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleplaneacioncompra.getId());
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
	
	public void setIsNewIsChangedFalseDetallePlaneacionCompra(DetallePlaneacionCompra detalleplaneacioncompra)throws Exception  {		
		detalleplaneacioncompra.setIsNew(false);
		detalleplaneacioncompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetallePlaneacionCompras(List<DetallePlaneacionCompra> detalleplaneacioncompras)throws Exception  {				
		for(DetallePlaneacionCompra detalleplaneacioncompra:detalleplaneacioncompras) {
			detalleplaneacioncompra.setIsNew(false);
			detalleplaneacioncompra.setIsChanged(false);
		}
	}
	
	public void generarExportarDetallePlaneacionCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
