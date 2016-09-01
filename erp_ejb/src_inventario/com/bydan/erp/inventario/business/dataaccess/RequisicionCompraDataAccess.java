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
import com.bydan.erp.inventario.util.*;//RequisicionCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class RequisicionCompraDataAccess extends  RequisicionCompraDataAccessAdditional{ //RequisicionCompraDataAccessAdditional,DataAccessHelper<RequisicionCompra>
	//static Logger logger = Logger.getLogger(RequisicionCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="requisicion_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_ejercicio,id_periodo,id_anio,id_mes,numero_secuencial,id_cliente,id_usuario,id_moneda,id_estado_requisicion_compra,total,fecha,id_empleado,responsable,solicitado_por,motivo_solicitud,area_solicitud,para_uso_de,lugar_entrega,descripcion,fecha_emision,fecha_entrega,id_formato,id_tipo_cambio)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,numero_secuencial=?,id_cliente=?,id_usuario=?,id_moneda=?,id_estado_requisicion_compra=?,total=?,fecha=?,id_empleado=?,responsable=?,solicitado_por=?,motivo_solicitud=?,area_solicitud=?,para_uso_de=?,lugar_entrega=?,descripcion=?,fecha_emision=?,fecha_entrega=?,id_formato=?,id_tipo_cambio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select requisicioncompra from "+RequisicionCompraConstantesFunciones.SPERSISTENCENAME+" requisicioncompra";
	public static String QUERYSELECTNATIVE="select "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".version_row,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_empresa,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_sucursal,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_modulo,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_periodo,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_anio,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_mes,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".numero_secuencial,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_cliente,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_usuario,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_moneda,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_estado_requisicion_compra,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".total,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".fecha,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_empleado,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".responsable,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".solicitado_por,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".motivo_solicitud,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".area_solicitud,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".para_uso_de,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".lugar_entrega,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".descripcion,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".fecha_emision,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".fecha_entrega,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_formato,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_tipo_cambio from "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME;//+" as "+RequisicionCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".version_row from "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME;//+" as "+RequisicionCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,numero_secuencial=?,id_cliente=?,id_usuario=?,id_moneda=?,id_estado_requisicion_compra=?,total=?,fecha=?,id_empleado=?,responsable=?,solicitado_por=?,motivo_solicitud=?,area_solicitud=?,para_uso_de=?,lugar_entrega=?,descripcion=?,fecha_emision=?,fecha_entrega=?,id_formato=?,id_tipo_cambio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_REQUISICIONCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_REQUISICIONCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_REQUISICIONCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_REQUISICIONCOMPRA_SELECT(?,?)";
	
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
	
	
	protected RequisicionCompraDataAccessAdditional requisicioncompraDataAccessAdditional=null;
	
	public RequisicionCompraDataAccessAdditional getRequisicionCompraDataAccessAdditional() {
		return this.requisicioncompraDataAccessAdditional;
	}
	
	public void setRequisicionCompraDataAccessAdditional(RequisicionCompraDataAccessAdditional requisicioncompraDataAccessAdditional) {
		try {
			this.requisicioncompraDataAccessAdditional=requisicioncompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RequisicionCompraDataAccess() {
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
		RequisicionCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RequisicionCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RequisicionCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRequisicionCompraOriginal(RequisicionCompra requisicioncompra)throws Exception  {
		requisicioncompra.setRequisicionCompraOriginal((RequisicionCompra)requisicioncompra.clone());		
	}
	
	public void setRequisicionComprasOriginal(List<RequisicionCompra> requisicioncompras)throws Exception  {
		
		for(RequisicionCompra requisicioncompra:requisicioncompras){
			requisicioncompra.setRequisicionCompraOriginal((RequisicionCompra)requisicioncompra.clone());
		}
	}
	
	public static void setRequisicionCompraOriginalStatic(RequisicionCompra requisicioncompra)throws Exception  {
		requisicioncompra.setRequisicionCompraOriginal((RequisicionCompra)requisicioncompra.clone());		
	}
	
	public static void setRequisicionComprasOriginalStatic(List<RequisicionCompra> requisicioncompras)throws Exception  {
		
		for(RequisicionCompra requisicioncompra:requisicioncompras){
			requisicioncompra.setRequisicionCompraOriginal((RequisicionCompra)requisicioncompra.clone());
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
	
	public  RequisicionCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RequisicionCompra entity = new RequisicionCompra();		
		
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
	
	public  RequisicionCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RequisicionCompra entity = new RequisicionCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.RequisicionCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRequisicionCompraOriginal(new RequisicionCompra());
      	    	entity=super.getEntity("",entity,resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRequisicionCompra("",entity,resultSet); 
				
				//entity.setRequisicionCompraOriginal(super.getEntity("",entity.getRequisicionCompraOriginal(),resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionCompraOriginal(this.getEntityRequisicionCompra("",entity.getRequisicionCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRequisicionCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RequisicionCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RequisicionCompra entity = new RequisicionCompra();
				
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
	
	public  RequisicionCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RequisicionCompra entity = new RequisicionCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.RequisicionCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRequisicionCompraOriginal(new RequisicionCompra());
      	    	entity=super.getEntity("",entity,resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRequisicionCompra("",entity,resultSet);    
				
				//entity.setRequisicionCompraOriginal(super.getEntity("",entity.getRequisicionCompraOriginal(),resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionCompraOriginal(this.getEntityRequisicionCompra("",entity.getRequisicionCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRequisicionCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RequisicionCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RequisicionCompra entity = new RequisicionCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.RequisicionCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRequisicionCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RequisicionCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
		
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
	
	public  List<RequisicionCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RequisicionCompra();
      	    	entity=super.getEntity("",entity,resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRequisicionCompra("",entity,resultSet);
      	    	
				//entity.setRequisicionCompraOriginal( new RequisicionCompra());
      	    	//entity.setRequisicionCompraOriginal(super.getEntity("",entity.getRequisicionCompraOriginal(),resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionCompraOriginal(this.getEntityRequisicionCompra("",entity.getRequisicionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRequisicionCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RequisicionCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
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
	
	public  List<RequisicionCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RequisicionCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapRequisicionCompra();
					//entity.setMapRequisicionCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRequisicionCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRequisicionCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA);         		
					entity=RequisicionCompraDataAccess.getEntityRequisicionCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRequisicionCompraOriginal( new RequisicionCompra());
					////entity.setRequisicionCompraOriginal(super.getEntity("",entity.getRequisicionCompraOriginal(),resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setRequisicionCompraOriginal(this.getEntityRequisicionCompra("",entity.getRequisicionCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRequisicionCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RequisicionCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RequisicionCompra entity = new RequisicionCompra();		  
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
	
	public  RequisicionCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RequisicionCompra entity = new RequisicionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RequisicionCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapRequisicionCompra();
					//entity.setMapRequisicionCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRequisicionCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRequisicionCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA);         		
					entity=RequisicionCompraDataAccess.getEntityRequisicionCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRequisicionCompraOriginal( new RequisicionCompra());
					////entity.setRequisicionCompraOriginal(super.getEntity("",entity.getRequisicionCompraOriginal(),resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setRequisicionCompraOriginal(this.getEntityRequisicionCompra("",entity.getRequisicionCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRequisicionCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RequisicionCompra getEntityRequisicionCompra(String strPrefijo,RequisicionCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RequisicionCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RequisicionCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RequisicionCompraDataAccess.setFieldReflectionRequisicionCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRequisicionCompra=RequisicionCompraConstantesFunciones.getTodosTiposColumnasRequisicionCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRequisicionCompra) {
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
							field = RequisicionCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RequisicionCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RequisicionCompraDataAccess.setFieldReflectionRequisicionCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRequisicionCompra(Field field,String strPrefijo,String sColumn,RequisicionCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RequisicionCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RequisicionCompraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.RESPONSABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.SOLICITADOPOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.AREASOLICITUD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.PARAUSODE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.LUGARENTREGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RequisicionCompraConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case RequisicionCompraConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RequisicionCompraConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RequisicionCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RequisicionCompra();
					entity=super.getEntity("",entity,resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRequisicionCompra("",entity,resultSet);
					
					//entity.setRequisicionCompraOriginal( new RequisicionCompra());
					//entity.setRequisicionCompraOriginal(super.getEntity("",entity.getRequisicionCompraOriginal(),resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setRequisicionCompraOriginal(this.getEntityRequisicionCompra("",entity.getRequisicionCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRequisicionCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RequisicionCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RequisicionCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RequisicionCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RequisicionCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
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
	
	public  List<RequisicionCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RequisicionCompra();
      	    	entity=super.getEntity("",entity,resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRequisicionCompra("",entity,resultSet);
      	    	
				//entity.setRequisicionCompraOriginal( new RequisicionCompra());
      	    	//entity.setRequisicionCompraOriginal(super.getEntity("",entity.getRequisicionCompraOriginal(),resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionCompraOriginal(this.getEntityRequisicionCompra("",entity.getRequisicionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRequisicionCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRequisicionCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RequisicionCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
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
	
	public  List<RequisicionCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RequisicionCompra> entities = new  ArrayList<RequisicionCompra>();
		RequisicionCompra entity = new RequisicionCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RequisicionCompra();
      	    	entity=super.getEntity("",entity,resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRequisicionCompra("",entity,resultSet);
      	    	
				//entity.setRequisicionCompraOriginal( new RequisicionCompra());
      	    	//entity.setRequisicionCompraOriginal(super.getEntity("",entity.getRequisicionCompraOriginal(),resultSet,RequisicionCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRequisicionCompraOriginal(this.getEntityRequisicionCompra("",entity.getRequisicionCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRequisicionCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RequisicionCompra getEntityRequisicionCompra(String strPrefijo,RequisicionCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDCLIENTE));
				entity.setid_usuario(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDUSUARIO));
				entity.setid_moneda(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDMONEDA));
				entity.setid_estado_requisicion_compra(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA));
				entity.settotal(resultSet.getDouble(strPrefijo+RequisicionCompraConstantesFunciones.TOTAL));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+RequisicionCompraConstantesFunciones.FECHA).getTime()));
				entity.setid_empleado(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDEMPLEADO));
				entity.setresponsable(resultSet.getString(strPrefijo+RequisicionCompraConstantesFunciones.RESPONSABLE));
				entity.setsolicitado_por(resultSet.getString(strPrefijo+RequisicionCompraConstantesFunciones.SOLICITADOPOR));
				entity.setmotivo_solicitud(resultSet.getString(strPrefijo+RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD));
				entity.setarea_solicitud(resultSet.getString(strPrefijo+RequisicionCompraConstantesFunciones.AREASOLICITUD));
				entity.setpara_uso_de(resultSet.getString(strPrefijo+RequisicionCompraConstantesFunciones.PARAUSODE));
				entity.setlugar_entrega(resultSet.getString(strPrefijo+RequisicionCompraConstantesFunciones.LUGARENTREGA));
				entity.setdescripcion(resultSet.getString(strPrefijo+RequisicionCompraConstantesFunciones.DESCRIPCION));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+RequisicionCompraConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+RequisicionCompraConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setid_formato(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+RequisicionCompraConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRequisicionCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RequisicionCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RequisicionCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RequisicionCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RequisicionCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RequisicionCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RequisicionCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RequisicionCompraDataAccess.TABLENAME,RequisicionCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			RequisicionCompraDataAccess.setRequisicionCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relrequisicioncompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relrequisicioncompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relrequisicioncompra.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relrequisicioncompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relrequisicioncompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relrequisicioncompra.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relrequisicioncompra.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Cliente getCliente(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relrequisicioncompra.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Usuario getUsuario(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relrequisicioncompra.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relrequisicioncompra.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public EstadoRequisicion getEstadoRequisicionCompra(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		EstadoRequisicion estadorequisicion= new EstadoRequisicion();

		try {
			EstadoRequisicionDataAccess estadorequisicionDataAccess=new EstadoRequisicionDataAccess();

			estadorequisicionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadorequisicionDataAccess.setConnexionType(this.connexionType);
			estadorequisicionDataAccess.setParameterDbType(this.parameterDbType);

			estadorequisicion=estadorequisicionDataAccess.getEntity(connexion,relrequisicioncompra.getid_estado_requisicion_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadorequisicion;

	}

	public Empleado getEmpleado(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relrequisicioncompra.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Formato getFormato(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relrequisicioncompra.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoCambio getTipoCambio(Connexion connexion,RequisicionCompra relrequisicioncompra)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relrequisicioncompra.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}


		
		public List<DetalleRequisicionCompra> getDetalleRequisicionCompras(Connexion connexion,RequisicionCompra requisicioncompra)throws SQLException,Exception {

		List<DetalleRequisicionCompra> detallerequisicioncompras= new ArrayList<DetalleRequisicionCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+RequisicionCompraConstantesFunciones.SCHEMA+".requisicion_compra ON "+DetalleRequisicionCompraConstantesFunciones.SCHEMA+".detalle_requisicion_compra.id_requisicion_compra="+RequisicionCompraConstantesFunciones.SCHEMA+".requisicion_compra.id WHERE "+RequisicionCompraConstantesFunciones.SCHEMA+".requisicion_compra.id="+String.valueOf(requisicioncompra.getId());
			} else {
				sQuery=" INNER JOIN detallerequisicioncompra.RequisicionCompra WHERE detallerequisicioncompra.RequisicionCompra.id="+String.valueOf(requisicioncompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleRequisicionCompraDataAccess detallerequisicioncompraDataAccess=new DetalleRequisicionCompraDataAccess();

			detallerequisicioncompraDataAccess.setConnexionType(this.connexionType);
			detallerequisicioncompraDataAccess.setParameterDbType(this.parameterDbType);
			detallerequisicioncompras=detallerequisicioncompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallerequisicioncompras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RequisicionCompra requisicioncompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!requisicioncompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(requisicioncompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(requisicioncompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(requisicioncompra.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(requisicioncompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(requisicioncompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(requisicioncompra.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(requisicioncompra.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(requisicioncompra.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(requisicioncompra.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(requisicioncompra.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(requisicioncompra.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_requisicion_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_requisicion_compra.setValue(requisicioncompra.getid_estado_requisicion_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_requisicion_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(requisicioncompra.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(requisicioncompra.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(requisicioncompra.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresponsable=new ParameterValue<String>();
					parameterMaintenanceValueresponsable.setValue(requisicioncompra.getresponsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresponsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesolicitado_por=new ParameterValue<String>();
					parameterMaintenanceValuesolicitado_por.setValue(requisicioncompra.getsolicitado_por());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesolicitado_por);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemotivo_solicitud=new ParameterValue<String>();
					parameterMaintenanceValuemotivo_solicitud.setValue(requisicioncompra.getmotivo_solicitud());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemotivo_solicitud);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuearea_solicitud=new ParameterValue<String>();
					parameterMaintenanceValuearea_solicitud.setValue(requisicioncompra.getarea_solicitud());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearea_solicitud);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepara_uso_de=new ParameterValue<String>();
					parameterMaintenanceValuepara_uso_de.setValue(requisicioncompra.getpara_uso_de());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_uso_de);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelugar_entrega=new ParameterValue<String>();
					parameterMaintenanceValuelugar_entrega.setValue(requisicioncompra.getlugar_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelugar_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(requisicioncompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(requisicioncompra.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(requisicioncompra.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(requisicioncompra.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(requisicioncompra.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
						if(!requisicioncompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(requisicioncompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(requisicioncompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(requisicioncompra.getId());
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
	
	public void setIsNewIsChangedFalseRequisicionCompra(RequisicionCompra requisicioncompra)throws Exception  {		
		requisicioncompra.setIsNew(false);
		requisicioncompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRequisicionCompras(List<RequisicionCompra> requisicioncompras)throws Exception  {				
		for(RequisicionCompra requisicioncompra:requisicioncompras) {
			requisicioncompra.setIsNew(false);
			requisicioncompra.setIsChanged(false);
		}
	}
	
	public void generarExportarRequisicionCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
