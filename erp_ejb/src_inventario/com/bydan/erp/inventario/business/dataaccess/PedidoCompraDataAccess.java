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
import com.bydan.erp.inventario.util.*;//PedidoCompraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class PedidoCompraDataAccess extends  PedidoCompraDataAccessAdditional{ //PedidoCompraDataAccessAdditional,DataAccessHelper<PedidoCompra>
	//static Logger logger = Logger.getLogger(PedidoCompraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pedido_compra";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_modulo,id_ejercicio,id_periodo,id_anio,id_mes,numero_secuencial,id_cliente,id_usuario,id_moneda,id_estado_pedido_compra,total,fecha,id_empleado,responsable,solicitado_por,motivo_solicitud,area_solicitud,para_uso_de,lugar_entrega,descripcion,fecha_emision,fecha_entrega,id_formato,id_tipo_cambio)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,numero_secuencial=?,id_cliente=?,id_usuario=?,id_moneda=?,id_estado_pedido_compra=?,total=?,fecha=?,id_empleado=?,responsable=?,solicitado_por=?,motivo_solicitud=?,area_solicitud=?,para_uso_de=?,lugar_entrega=?,descripcion=?,fecha_emision=?,fecha_entrega=?,id_formato=?,id_tipo_cambio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select pedidocompra from "+PedidoCompraConstantesFunciones.SPERSISTENCENAME+" pedidocompra";
	public static String QUERYSELECTNATIVE="select "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".version_row,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_empresa,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_modulo,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_periodo,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_anio,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_mes,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".numero_secuencial,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_cliente,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_usuario,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_moneda,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_estado_pedido_compra,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".total,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".fecha,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_empleado,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".responsable,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".solicitado_por,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".motivo_solicitud,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".area_solicitud,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".para_uso_de,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".lugar_entrega,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".descripcion,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".fecha_emision,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".fecha_entrega,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_formato,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id_tipo_cambio from "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME;//+" as "+PedidoCompraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".id,"+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+".version_row from "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME;//+" as "+PedidoCompraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PedidoCompraConstantesFunciones.SCHEMA+"."+PedidoCompraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_modulo=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,numero_secuencial=?,id_cliente=?,id_usuario=?,id_moneda=?,id_estado_pedido_compra=?,total=?,fecha=?,id_empleado=?,responsable=?,solicitado_por=?,motivo_solicitud=?,area_solicitud=?,para_uso_de=?,lugar_entrega=?,descripcion=?,fecha_emision=?,fecha_entrega=?,id_formato=?,id_tipo_cambio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PEDIDOCOMPRA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PEDIDOCOMPRA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PEDIDOCOMPRA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PEDIDOCOMPRA_SELECT(?,?)";
	
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
	
	
	protected PedidoCompraDataAccessAdditional pedidocompraDataAccessAdditional=null;
	
	public PedidoCompraDataAccessAdditional getPedidoCompraDataAccessAdditional() {
		return this.pedidocompraDataAccessAdditional;
	}
	
	public void setPedidoCompraDataAccessAdditional(PedidoCompraDataAccessAdditional pedidocompraDataAccessAdditional) {
		try {
			this.pedidocompraDataAccessAdditional=pedidocompraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PedidoCompraDataAccess() {
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
		PedidoCompraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PedidoCompraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PedidoCompraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPedidoCompraOriginal(PedidoCompra pedidocompra)throws Exception  {
		pedidocompra.setPedidoCompraOriginal((PedidoCompra)pedidocompra.clone());		
	}
	
	public void setPedidoComprasOriginal(List<PedidoCompra> pedidocompras)throws Exception  {
		
		for(PedidoCompra pedidocompra:pedidocompras){
			pedidocompra.setPedidoCompraOriginal((PedidoCompra)pedidocompra.clone());
		}
	}
	
	public static void setPedidoCompraOriginalStatic(PedidoCompra pedidocompra)throws Exception  {
		pedidocompra.setPedidoCompraOriginal((PedidoCompra)pedidocompra.clone());		
	}
	
	public static void setPedidoComprasOriginalStatic(List<PedidoCompra> pedidocompras)throws Exception  {
		
		for(PedidoCompra pedidocompra:pedidocompras){
			pedidocompra.setPedidoCompraOriginal((PedidoCompra)pedidocompra.clone());
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
	
	public  PedidoCompra getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoCompra entity = new PedidoCompra();		
		
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
	
	public  PedidoCompra getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoCompra entity = new PedidoCompra();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.PedidoCompra.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPedidoCompraOriginal(new PedidoCompra());
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoCompra("",entity,resultSet); 
				
				//entity.setPedidoCompraOriginal(super.getEntity("",entity.getPedidoCompraOriginal(),resultSet,PedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraOriginal(this.getEntityPedidoCompra("",entity.getPedidoCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoCompra(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PedidoCompra getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoCompra entity = new PedidoCompra();
				
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
	
	public  PedidoCompra getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoCompra entity = new PedidoCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.PedidoCompra.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPedidoCompraOriginal(new PedidoCompra());
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoCompra("",entity,resultSet);    
				
				//entity.setPedidoCompraOriginal(super.getEntity("",entity.getPedidoCompraOriginal(),resultSet,PedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraOriginal(this.getEntityPedidoCompra("",entity.getPedidoCompraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PedidoCompra
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PedidoCompra entity = new PedidoCompra();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.PedidoCompra.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePedidoCompra(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PedidoCompra> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
		
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
	
	public  List<PedidoCompra> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompra();
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoCompra("",entity,resultSet);
      	    	
				//entity.setPedidoCompraOriginal( new PedidoCompra());
      	    	//entity.setPedidoCompraOriginal(super.getEntity("",entity.getPedidoCompraOriginal(),resultSet,PedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraOriginal(this.getEntityPedidoCompra("",entity.getPedidoCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoCompras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
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
	
	public  List<PedidoCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoCompra();
					//entity.setMapPedidoCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPedidoCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=PedidoCompraDataAccess.getEntityPedidoCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoCompraOriginal( new PedidoCompra());
					////entity.setPedidoCompraOriginal(super.getEntity("",entity.getPedidoCompraOriginal(),resultSet,PedidoCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoCompraOriginal(this.getEntityPedidoCompra("",entity.getPedidoCompraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoCompras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PedidoCompra getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoCompra entity = new PedidoCompra();		  
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
	
	public  PedidoCompra getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoCompra entity = new PedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompra();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoCompra();
					//entity.setMapPedidoCompra(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPedidoCompraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoCompra().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=PedidoCompraDataAccess.getEntityPedidoCompra("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoCompraOriginal( new PedidoCompra());
					////entity.setPedidoCompraOriginal(super.getEntity("",entity.getPedidoCompraOriginal(),resultSet,PedidoCompraDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoCompraOriginal(this.getEntityPedidoCompra("",entity.getPedidoCompraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePedidoCompra(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PedidoCompra getEntityPedidoCompra(String strPrefijo,PedidoCompra entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PedidoCompra.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PedidoCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PedidoCompraDataAccess.setFieldReflectionPedidoCompra(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPedidoCompra=PedidoCompraConstantesFunciones.getTodosTiposColumnasPedidoCompra();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPedidoCompra) {
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
							field = PedidoCompra.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PedidoCompra.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PedidoCompraDataAccess.setFieldReflectionPedidoCompra(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPedidoCompra(Field field,String strPrefijo,String sColumn,PedidoCompra entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PedidoCompraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoCompraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.RESPONSABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.SOLICITADOPOR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.MOTIVOSOLICITUD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.AREASOLICITUD:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.PARAUSODE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.LUGARENTREGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoCompraConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoCompraConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoCompraConstantesFunciones.IDTIPOCAMBIO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoCompra>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PedidoCompra();
					entity=super.getEntity("",entity,resultSet,PedidoCompraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPedidoCompra("",entity,resultSet);
					
					//entity.setPedidoCompraOriginal( new PedidoCompra());
					//entity.setPedidoCompraOriginal(super.getEntity("",entity.getPedidoCompraOriginal(),resultSet,PedidoCompraDataAccess.ISWITHSCHEMA));         		
					//entity.setPedidoCompraOriginal(this.getEntityPedidoCompra("",entity.getPedidoCompraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePedidoCompras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoCompra>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoCompraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoCompraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PedidoCompra> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
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
	
	public  List<PedidoCompra> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompra();
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoCompra("",entity,resultSet);
      	    	
				//entity.setPedidoCompraOriginal( new PedidoCompra());
      	    	//entity.setPedidoCompraOriginal(super.getEntity("",entity.getPedidoCompraOriginal(),resultSet,PedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraOriginal(this.getEntityPedidoCompra("",entity.getPedidoCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePedidoCompras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoCompra(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoCompra> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
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
	
	public  List<PedidoCompra> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoCompra> entities = new  ArrayList<PedidoCompra>();
		PedidoCompra entity = new PedidoCompra();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoCompra();
      	    	entity=super.getEntity("",entity,resultSet,PedidoCompraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoCompra("",entity,resultSet);
      	    	
				//entity.setPedidoCompraOriginal( new PedidoCompra());
      	    	//entity.setPedidoCompraOriginal(super.getEntity("",entity.getPedidoCompraOriginal(),resultSet,PedidoCompraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoCompraOriginal(this.getEntityPedidoCompra("",entity.getPedidoCompraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoCompras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PedidoCompra getEntityPedidoCompra(String strPrefijo,PedidoCompra entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDSUCURSAL));
				entity.setid_modulo(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDMODULO));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+PedidoCompraConstantesFunciones.NUMEROSECUENCIAL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDCLIENTE));
				entity.setid_usuario(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDUSUARIO));
				entity.setid_moneda(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDMONEDA));
				entity.setid_estado_pedido_compra(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDESTADOPEDIDOCOMPRA));
				entity.settotal(resultSet.getDouble(strPrefijo+PedidoCompraConstantesFunciones.TOTAL));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PedidoCompraConstantesFunciones.FECHA).getTime()));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDEMPLEADO));
				entity.setresponsable(resultSet.getString(strPrefijo+PedidoCompraConstantesFunciones.RESPONSABLE));
				entity.setsolicitado_por(resultSet.getString(strPrefijo+PedidoCompraConstantesFunciones.SOLICITADOPOR));
				entity.setmotivo_solicitud(resultSet.getString(strPrefijo+PedidoCompraConstantesFunciones.MOTIVOSOLICITUD));
				entity.setarea_solicitud(resultSet.getString(strPrefijo+PedidoCompraConstantesFunciones.AREASOLICITUD));
				entity.setpara_uso_de(resultSet.getString(strPrefijo+PedidoCompraConstantesFunciones.PARAUSODE));
				entity.setlugar_entrega(resultSet.getString(strPrefijo+PedidoCompraConstantesFunciones.LUGARENTREGA));
				entity.setdescripcion(resultSet.getString(strPrefijo+PedidoCompraConstantesFunciones.DESCRIPCION));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PedidoCompraConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+PedidoCompraConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setid_formato(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+PedidoCompraConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPedidoCompra(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PedidoCompra entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PedidoCompraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PedidoCompraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PedidoCompraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PedidoCompraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PedidoCompraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PedidoCompraDataAccess.TABLENAME,PedidoCompraDataAccess.ISWITHSTOREPROCEDURES);
			
			PedidoCompraDataAccess.setPedidoCompraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpedidocompra.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpedidocompra.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Modulo getModulo(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relpedidocompra.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Ejercicio getEjercicio(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpedidocompra.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpedidocompra.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relpedidocompra.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relpedidocompra.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Cliente getCliente(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpedidocompra.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Usuario getUsuario(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relpedidocompra.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relpedidocompra.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public EstadoPedidoCompra getEstadoPedidoCompra(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		EstadoPedidoCompra estadopedidocompra= new EstadoPedidoCompra();

		try {
			EstadoPedidoCompraDataAccess estadopedidocompraDataAccess=new EstadoPedidoCompraDataAccess();

			estadopedidocompraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidocompraDataAccess.setConnexionType(this.connexionType);
			estadopedidocompraDataAccess.setParameterDbType(this.parameterDbType);

			estadopedidocompra=estadopedidocompraDataAccess.getEntity(connexion,relpedidocompra.getid_estado_pedido_compra());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedidocompra;

	}

	public Empleado getEmpleado(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relpedidocompra.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Formato getFormato(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relpedidocompra.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoCambio getTipoCambio(Connexion connexion,PedidoCompra relpedidocompra)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relpedidocompra.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}


		
		public List<Compra> getCompras(Connexion connexion,PedidoCompra pedidocompra)throws SQLException,Exception {

		List<Compra> compras= new ArrayList<Compra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra ON "+CompraConstantesFunciones.SCHEMA+".compra.id_pedido_compra="+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id WHERE "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id="+String.valueOf(pedidocompra.getId());
			} else {
				sQuery=" INNER JOIN compra.PedidoCompra WHERE compra.PedidoCompra.id="+String.valueOf(pedidocompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CompraDataAccess compraDataAccess=new CompraDataAccess();

			compraDataAccess.setConnexionType(this.connexionType);
			compraDataAccess.setParameterDbType(this.parameterDbType);
			compras=compraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return compras;

	}

	public List<DetallePedidoCompra> getDetallePedidoCompras(Connexion connexion,PedidoCompra pedidocompra)throws SQLException,Exception {

		List<DetallePedidoCompra> detallepedidocompras= new ArrayList<DetallePedidoCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra ON "+DetallePedidoCompraConstantesFunciones.SCHEMA+".detalle_pedido_compra.id_pedido_compra="+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id WHERE "+PedidoCompraConstantesFunciones.SCHEMA+".pedido_compra.id="+String.valueOf(pedidocompra.getId());
			} else {
				sQuery=" INNER JOIN detallepedidocompra.PedidoCompra WHERE detallepedidocompra.PedidoCompra.id="+String.valueOf(pedidocompra.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoCompraDataAccess detallepedidocompraDataAccess=new DetallePedidoCompraDataAccess();

			detallepedidocompraDataAccess.setConnexionType(this.connexionType);
			detallepedidocompraDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidocompras=detallepedidocompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidocompras;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PedidoCompra pedidocompra) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!pedidocompra.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(pedidocompra.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(pedidocompra.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(pedidocompra.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(pedidocompra.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(pedidocompra.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(pedidocompra.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(pedidocompra.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(pedidocompra.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(pedidocompra.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(pedidocompra.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(pedidocompra.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_compra=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_compra.setValue(pedidocompra.getid_estado_pedido_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(pedidocompra.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(pedidocompra.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(pedidocompra.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresponsable=new ParameterValue<String>();
					parameterMaintenanceValueresponsable.setValue(pedidocompra.getresponsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresponsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesolicitado_por=new ParameterValue<String>();
					parameterMaintenanceValuesolicitado_por.setValue(pedidocompra.getsolicitado_por());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesolicitado_por);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuemotivo_solicitud=new ParameterValue<String>();
					parameterMaintenanceValuemotivo_solicitud.setValue(pedidocompra.getmotivo_solicitud());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemotivo_solicitud);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuearea_solicitud=new ParameterValue<String>();
					parameterMaintenanceValuearea_solicitud.setValue(pedidocompra.getarea_solicitud());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearea_solicitud);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuepara_uso_de=new ParameterValue<String>();
					parameterMaintenanceValuepara_uso_de.setValue(pedidocompra.getpara_uso_de());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepara_uso_de);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelugar_entrega=new ParameterValue<String>();
					parameterMaintenanceValuelugar_entrega.setValue(pedidocompra.getlugar_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelugar_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(pedidocompra.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(pedidocompra.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(pedidocompra.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(pedidocompra.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(pedidocompra.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
						if(!pedidocompra.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(pedidocompra.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(pedidocompra.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(pedidocompra.getId());
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
	
	public void setIsNewIsChangedFalsePedidoCompra(PedidoCompra pedidocompra)throws Exception  {		
		pedidocompra.setIsNew(false);
		pedidocompra.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePedidoCompras(List<PedidoCompra> pedidocompras)throws Exception  {				
		for(PedidoCompra pedidocompra:pedidocompras) {
			pedidocompra.setIsNew(false);
			pedidocompra.setIsChanged(false);
		}
	}
	
	public void generarExportarPedidoCompra(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
