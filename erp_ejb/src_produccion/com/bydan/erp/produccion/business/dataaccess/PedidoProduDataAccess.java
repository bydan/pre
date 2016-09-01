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
package com.bydan.erp.produccion.business.dataaccess;

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

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//PedidoProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class PedidoProduDataAccess extends  PedidoProduDataAccessAdditional{ //PedidoProduDataAccessAdditional,DataAccessHelper<PedidoProdu>
	//static Logger logger = Logger.getLogger(PedidoProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pedido_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_formato,id_tipo_prioridad_empresa_produ,id_empleado_responsable,secuencial,id_cliente,direccion_cliente,telefono_cliente,ruc_cliente,lote,fecha_pedido,fecha_entrega,es_uso_interno,fecha,descripcion,id_estado_orden_produ)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_formato=?,id_tipo_prioridad_empresa_produ=?,id_empleado_responsable=?,secuencial=?,id_cliente=?,direccion_cliente=?,telefono_cliente=?,ruc_cliente=?,lote=?,fecha_pedido=?,fecha_entrega=?,es_uso_interno=?,fecha=?,descripcion=?,id_estado_orden_produ=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select pedidoprodu from "+PedidoProduConstantesFunciones.SPERSISTENCENAME+" pedidoprodu";
	public static String QUERYSELECTNATIVE="select "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".version_row,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_empresa,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_periodo,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_formato,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_tipo_prioridad_empresa_produ,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_empleado_responsable,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".secuencial,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_cliente,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".direccion_cliente,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".telefono_cliente,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".ruc_cliente,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".lote,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".fecha_pedido,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".es_uso_interno,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".fecha,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".descripcion,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id_estado_orden_produ from "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME;//+" as "+PedidoProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".id,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".version_row,"+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+".secuencial from "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME;//+" as "+PedidoProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PedidoProduConstantesFunciones.SCHEMA+"."+PedidoProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_formato=?,id_tipo_prioridad_empresa_produ=?,id_empleado_responsable=?,secuencial=?,id_cliente=?,direccion_cliente=?,telefono_cliente=?,ruc_cliente=?,lote=?,fecha_pedido=?,fecha_entrega=?,es_uso_interno=?,fecha=?,descripcion=?,id_estado_orden_produ=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PEDIDOPRODU_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PEDIDOPRODU_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PEDIDOPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PEDIDOPRODU_SELECT(?,?)";
	
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
	
	
	protected PedidoProduDataAccessAdditional pedidoproduDataAccessAdditional=null;
	
	public PedidoProduDataAccessAdditional getPedidoProduDataAccessAdditional() {
		return this.pedidoproduDataAccessAdditional;
	}
	
	public void setPedidoProduDataAccessAdditional(PedidoProduDataAccessAdditional pedidoproduDataAccessAdditional) {
		try {
			this.pedidoproduDataAccessAdditional=pedidoproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PedidoProduDataAccess() {
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
		PedidoProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PedidoProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PedidoProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPedidoProduOriginal(PedidoProdu pedidoprodu)throws Exception  {
		pedidoprodu.setPedidoProduOriginal((PedidoProdu)pedidoprodu.clone());		
	}
	
	public void setPedidoProdusOriginal(List<PedidoProdu> pedidoprodus)throws Exception  {
		
		for(PedidoProdu pedidoprodu:pedidoprodus){
			pedidoprodu.setPedidoProduOriginal((PedidoProdu)pedidoprodu.clone());
		}
	}
	
	public static void setPedidoProduOriginalStatic(PedidoProdu pedidoprodu)throws Exception  {
		pedidoprodu.setPedidoProduOriginal((PedidoProdu)pedidoprodu.clone());		
	}
	
	public static void setPedidoProdusOriginalStatic(List<PedidoProdu> pedidoprodus)throws Exception  {
		
		for(PedidoProdu pedidoprodu:pedidoprodus){
			pedidoprodu.setPedidoProduOriginal((PedidoProdu)pedidoprodu.clone());
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
	
	public  PedidoProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoProdu entity = new PedidoProdu();		
		
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
	
	public  PedidoProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoProdu entity = new PedidoProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.PedidoProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPedidoProduOriginal(new PedidoProdu());
      	    	entity=super.getEntity("",entity,resultSet,PedidoProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoProdu("",entity,resultSet); 
				
				//entity.setPedidoProduOriginal(super.getEntity("",entity.getPedidoProduOriginal(),resultSet,PedidoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoProduOriginal(this.getEntityPedidoProdu("",entity.getPedidoProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PedidoProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoProdu entity = new PedidoProdu();
				
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
	
	public  PedidoProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoProdu entity = new PedidoProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.PedidoProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPedidoProduOriginal(new PedidoProdu());
      	    	entity=super.getEntity("",entity,resultSet,PedidoProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoProdu("",entity,resultSet);    
				
				//entity.setPedidoProduOriginal(super.getEntity("",entity.getPedidoProduOriginal(),resultSet,PedidoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoProduOriginal(this.getEntityPedidoProdu("",entity.getPedidoProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PedidoProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PedidoProdu entity = new PedidoProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.PedidoProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePedidoProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PedidoProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
		
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
	
	public  List<PedidoProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoProdu();
      	    	entity=super.getEntity("",entity,resultSet,PedidoProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoProdu("",entity,resultSet);
      	    	
				//entity.setPedidoProduOriginal( new PedidoProdu());
      	    	//entity.setPedidoProduOriginal(super.getEntity("",entity.getPedidoProduOriginal(),resultSet,PedidoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoProduOriginal(this.getEntityPedidoProdu("",entity.getPedidoProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
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
	
	public  List<PedidoProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoProdu();
					//entity.setMapPedidoProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPedidoProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoProduDataAccess.ISWITHSCHEMA);         		
					entity=PedidoProduDataAccess.getEntityPedidoProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoProduOriginal( new PedidoProdu());
					////entity.setPedidoProduOriginal(super.getEntity("",entity.getPedidoProduOriginal(),resultSet,PedidoProduDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoProduOriginal(this.getEntityPedidoProdu("",entity.getPedidoProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PedidoProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoProdu entity = new PedidoProdu();		  
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
	
	public  PedidoProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoProdu entity = new PedidoProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoProdu();
					//entity.setMapPedidoProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPedidoProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoProduDataAccess.ISWITHSCHEMA);         		
					entity=PedidoProduDataAccess.getEntityPedidoProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoProduOriginal( new PedidoProdu());
					////entity.setPedidoProduOriginal(super.getEntity("",entity.getPedidoProduOriginal(),resultSet,PedidoProduDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoProduOriginal(this.getEntityPedidoProdu("",entity.getPedidoProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePedidoProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PedidoProdu getEntityPedidoProdu(String strPrefijo,PedidoProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PedidoProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PedidoProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PedidoProduDataAccess.setFieldReflectionPedidoProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPedidoProdu=PedidoProduConstantesFunciones.getTodosTiposColumnasPedidoProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPedidoProdu) {
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
							field = PedidoProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PedidoProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PedidoProduDataAccess.setFieldReflectionPedidoProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPedidoProdu(Field field,String strPrefijo,String sColumn,PedidoProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PedidoProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.DIRECCIONCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.TELEFONOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.RUCCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.LOTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.FECHAPEDIDO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoProduConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoProduConstantesFunciones.ESUSOINTERNO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoProduConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoProduConstantesFunciones.IDESTADOORDENPRODU:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PedidoProdu();
					entity=super.getEntity("",entity,resultSet,PedidoProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPedidoProdu("",entity,resultSet);
					
					//entity.setPedidoProduOriginal( new PedidoProdu());
					//entity.setPedidoProduOriginal(super.getEntity("",entity.getPedidoProduOriginal(),resultSet,PedidoProduDataAccess.ISWITHSCHEMA));         		
					//entity.setPedidoProduOriginal(this.getEntityPedidoProdu("",entity.getPedidoProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePedidoProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PedidoProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
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
	
	public  List<PedidoProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoProdu();
      	    	entity=super.getEntity("",entity,resultSet,PedidoProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoProdu("",entity,resultSet);
      	    	
				//entity.setPedidoProduOriginal( new PedidoProdu());
      	    	//entity.setPedidoProduOriginal(super.getEntity("",entity.getPedidoProduOriginal(),resultSet,PedidoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoProduOriginal(this.getEntityPedidoProdu("",entity.getPedidoProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePedidoProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
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
	
	public  List<PedidoProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoProdu> entities = new  ArrayList<PedidoProdu>();
		PedidoProdu entity = new PedidoProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoProdu();
      	    	entity=super.getEntity("",entity,resultSet,PedidoProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoProdu("",entity,resultSet);
      	    	
				//entity.setPedidoProduOriginal( new PedidoProdu());
      	    	//entity.setPedidoProduOriginal(super.getEntity("",entity.getPedidoProduOriginal(),resultSet,PedidoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoProduOriginal(this.getEntityPedidoProdu("",entity.getPedidoProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PedidoProdu getEntityPedidoProdu(String strPrefijo,PedidoProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDPERIODO));
				entity.setid_formato(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setid_tipo_prioridad_empresa_produ(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDTIPOPRIORIDADEMPRESAPRODU));
				entity.setid_empleado_responsable(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDEMPLEADORESPONSABLE));
				entity.setsecuencial(resultSet.getString(strPrefijo+PedidoProduConstantesFunciones.SECUENCIAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDCLIENTE));
				entity.setdireccion_cliente(resultSet.getString(strPrefijo+PedidoProduConstantesFunciones.DIRECCIONCLIENTE));
				entity.settelefono_cliente(resultSet.getString(strPrefijo+PedidoProduConstantesFunciones.TELEFONOCLIENTE));
				entity.setruc_cliente(resultSet.getString(strPrefijo+PedidoProduConstantesFunciones.RUCCLIENTE));
				entity.setlote(resultSet.getString(strPrefijo+PedidoProduConstantesFunciones.LOTE));
				entity.setfecha_pedido(new Date(resultSet.getDate(strPrefijo+PedidoProduConstantesFunciones.FECHAPEDIDO).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+PedidoProduConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setes_uso_interno(resultSet.getBoolean(strPrefijo+PedidoProduConstantesFunciones.ESUSOINTERNO));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PedidoProduConstantesFunciones.FECHA).getTime()));
				entity.setdescripcion(resultSet.getString(strPrefijo+PedidoProduConstantesFunciones.DESCRIPCION));
				entity.setid_estado_orden_produ(resultSet.getLong(strPrefijo+PedidoProduConstantesFunciones.IDESTADOORDENPRODU));
			} else {
				entity.setsecuencial(resultSet.getString(strPrefijo+PedidoProduConstantesFunciones.SECUENCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPedidoProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PedidoProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PedidoProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PedidoProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PedidoProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PedidoProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PedidoProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PedidoProduDataAccess.TABLENAME,PedidoProduDataAccess.ISWITHSTOREPROCEDURES);
			
			PedidoProduDataAccess.setPedidoProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpedidoprodu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpedidoprodu.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpedidoprodu.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpedidoprodu.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Formato getFormato(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relpedidoprodu.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoPrioridadEmpresaProdu getTipoPrioridadEmpresaProdu(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		TipoPrioridadEmpresaProdu tipoprioridadempresaprodu= new TipoPrioridadEmpresaProdu();

		try {
			TipoPrioridadEmpresaProduDataAccess tipoprioridadempresaproduDataAccess=new TipoPrioridadEmpresaProduDataAccess();

			tipoprioridadempresaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprioridadempresaproduDataAccess.setConnexionType(this.connexionType);
			tipoprioridadempresaproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoprioridadempresaprodu=tipoprioridadempresaproduDataAccess.getEntity(connexion,relpedidoprodu.getid_tipo_prioridad_empresa_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprioridadempresaprodu;

	}

	public Empleado getEmpleadoResponsable(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relpedidoprodu.getid_empleado_responsable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Cliente getCliente(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpedidoprodu.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public EstadoOrdenProdu getEstadoOrdenProdu(Connexion connexion,PedidoProdu relpedidoprodu)throws SQLException,Exception {

		EstadoOrdenProdu estadoordenprodu= new EstadoOrdenProdu();

		try {
			EstadoOrdenProduDataAccess estadoordenproduDataAccess=new EstadoOrdenProduDataAccess();

			estadoordenproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoordenproduDataAccess.setConnexionType(this.connexionType);
			estadoordenproduDataAccess.setParameterDbType(this.parameterDbType);

			estadoordenprodu=estadoordenproduDataAccess.getEntity(connexion,relpedidoprodu.getid_estado_orden_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoordenprodu;

	}


		
		public List<PedidoDetaProdu> getPedidoDetaProdus(Connexion connexion,PedidoProdu pedidoprodu)throws SQLException,Exception {

		List<PedidoDetaProdu> pedidodetaprodus= new ArrayList<PedidoDetaProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoProduConstantesFunciones.SCHEMA+".pedido_produ ON "+PedidoDetaProduConstantesFunciones.SCHEMA+".pedido_deta_produ.id_pedido_produ="+PedidoProduConstantesFunciones.SCHEMA+".pedido_produ.id WHERE "+PedidoProduConstantesFunciones.SCHEMA+".pedido_produ.id="+String.valueOf(pedidoprodu.getId());
			} else {
				sQuery=" INNER JOIN pedidodetaprodu.PedidoProdu WHERE pedidodetaprodu.PedidoProdu.id="+String.valueOf(pedidoprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoDetaProduDataAccess pedidodetaproduDataAccess=new PedidoDetaProduDataAccess();

			pedidodetaproduDataAccess.setConnexionType(this.connexionType);
			pedidodetaproduDataAccess.setParameterDbType(this.parameterDbType);
			pedidodetaprodus=pedidodetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidodetaprodus;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PedidoProdu pedidoprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!pedidoprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(pedidoprodu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(pedidoprodu.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(pedidoprodu.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(pedidoprodu.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(pedidoprodu.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_prioridad_empresa_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_prioridad_empresa_produ.setValue(pedidoprodu.getid_tipo_prioridad_empresa_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_prioridad_empresa_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_responsable=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_responsable.setValue(pedidoprodu.getid_empleado_responsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_responsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesecuencial=new ParameterValue<String>();
					parameterMaintenanceValuesecuencial.setValue(pedidoprodu.getsecuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesecuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(pedidoprodu.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_cliente=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_cliente.setValue(pedidoprodu.getdireccion_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_cliente.setValue(pedidoprodu.gettelefono_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc_cliente=new ParameterValue<String>();
					parameterMaintenanceValueruc_cliente.setValue(pedidoprodu.getruc_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelote=new ParameterValue<String>();
					parameterMaintenanceValuelote.setValue(pedidoprodu.getlote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_pedido=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_pedido.setValue(pedidoprodu.getfecha_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(pedidoprodu.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_uso_interno=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_uso_interno.setValue(pedidoprodu.getes_uso_interno());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_uso_interno);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(pedidoprodu.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(pedidoprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_orden_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_orden_produ.setValue(pedidoprodu.getid_estado_orden_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_orden_produ);
					parametersTemp.add(parameterMaintenance);
					
						if(!pedidoprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(pedidoprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(pedidoprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(pedidoprodu.getId());
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
	
	public void setIsNewIsChangedFalsePedidoProdu(PedidoProdu pedidoprodu)throws Exception  {		
		pedidoprodu.setIsNew(false);
		pedidoprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePedidoProdus(List<PedidoProdu> pedidoprodus)throws Exception  {				
		for(PedidoProdu pedidoprodu:pedidoprodus) {
			pedidoprodu.setIsNew(false);
			pedidoprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarPedidoProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
