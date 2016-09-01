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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//PedidoPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class PedidoPuntoVentaDataAccess extends  PedidoPuntoVentaDataAccessAdditional{ //PedidoPuntoVentaDataAccessAdditional,DataAccessHelper<PedidoPuntoVenta>
	//static Logger logger = Logger.getLogger(PedidoPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pedido_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,id_vendedor,id_caja,id_cliente,id_tipo_precio,id_mesa,id_estado_pedido_punto_venta,numero_secuencial,codigo_cliente,nombre_cliente,direccion_cliente,telefono_cliente,tarjeta_cliente,fecha,hora,sub_total,iva,ice,descuento,total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_vendedor=?,id_caja=?,id_cliente=?,id_tipo_precio=?,id_mesa=?,id_estado_pedido_punto_venta=?,numero_secuencial=?,codigo_cliente=?,nombre_cliente=?,direccion_cliente=?,telefono_cliente=?,tarjeta_cliente=?,fecha=?,hora=?,sub_total=?,iva=?,ice=?,descuento=?,total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select pedidopuntoventa from "+PedidoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" pedidopuntoventa";
	public static String QUERYSELECTNATIVE="select "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_usuario,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_vendedor,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_caja,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_precio,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_mesa,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id_estado_pedido_punto_venta,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".codigo_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".nombre_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".direccion_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".telefono_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".tarjeta_cliente,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".fecha,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".hora,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".iva,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".ice,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".total from "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+PedidoPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".id,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial from "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+PedidoPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PedidoPuntoVentaConstantesFunciones.SCHEMA+"."+PedidoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_vendedor=?,id_caja=?,id_cliente=?,id_tipo_precio=?,id_mesa=?,id_estado_pedido_punto_venta=?,numero_secuencial=?,codigo_cliente=?,nombre_cliente=?,direccion_cliente=?,telefono_cliente=?,tarjeta_cliente=?,fecha=?,hora=?,sub_total=?,iva=?,ice=?,descuento=?,total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PEDIDOPUNTOVENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PEDIDOPUNTOVENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PEDIDOPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PEDIDOPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	protected PedidoPuntoVentaDataAccessAdditional pedidopuntoventaDataAccessAdditional=null;
	
	public PedidoPuntoVentaDataAccessAdditional getPedidoPuntoVentaDataAccessAdditional() {
		return this.pedidopuntoventaDataAccessAdditional;
	}
	
	public void setPedidoPuntoVentaDataAccessAdditional(PedidoPuntoVentaDataAccessAdditional pedidopuntoventaDataAccessAdditional) {
		try {
			this.pedidopuntoventaDataAccessAdditional=pedidopuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PedidoPuntoVentaDataAccess() {
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
		PedidoPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PedidoPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PedidoPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPedidoPuntoVentaOriginal(PedidoPuntoVenta pedidopuntoventa)throws Exception  {
		pedidopuntoventa.setPedidoPuntoVentaOriginal((PedidoPuntoVenta)pedidopuntoventa.clone());		
	}
	
	public void setPedidoPuntoVentasOriginal(List<PedidoPuntoVenta> pedidopuntoventas)throws Exception  {
		
		for(PedidoPuntoVenta pedidopuntoventa:pedidopuntoventas){
			pedidopuntoventa.setPedidoPuntoVentaOriginal((PedidoPuntoVenta)pedidopuntoventa.clone());
		}
	}
	
	public static void setPedidoPuntoVentaOriginalStatic(PedidoPuntoVenta pedidopuntoventa)throws Exception  {
		pedidopuntoventa.setPedidoPuntoVentaOriginal((PedidoPuntoVenta)pedidopuntoventa.clone());		
	}
	
	public static void setPedidoPuntoVentasOriginalStatic(List<PedidoPuntoVenta> pedidopuntoventas)throws Exception  {
		
		for(PedidoPuntoVenta pedidopuntoventa:pedidopuntoventas){
			pedidopuntoventa.setPedidoPuntoVentaOriginal((PedidoPuntoVenta)pedidopuntoventa.clone());
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
	
	public  PedidoPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		
		
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
	
	public  PedidoPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.PedidoPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPedidoPuntoVentaOriginal(new PedidoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoPuntoVenta("",entity,resultSet); 
				
				//entity.setPedidoPuntoVentaOriginal(super.getEntity("",entity.getPedidoPuntoVentaOriginal(),resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoPuntoVentaOriginal(this.getEntityPedidoPuntoVenta("",entity.getPedidoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PedidoPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoPuntoVenta entity = new PedidoPuntoVenta();
				
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
	
	public  PedidoPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoPuntoVenta entity = new PedidoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.PedidoPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPedidoPuntoVentaOriginal(new PedidoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoPuntoVenta("",entity,resultSet);    
				
				//entity.setPedidoPuntoVentaOriginal(super.getEntity("",entity.getPedidoPuntoVentaOriginal(),resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoPuntoVentaOriginal(this.getEntityPedidoPuntoVenta("",entity.getPedidoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PedidoPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PedidoPuntoVenta entity = new PedidoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.PedidoPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePedidoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PedidoPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
		
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
	
	public  List<PedidoPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setPedidoPuntoVentaOriginal( new PedidoPuntoVenta());
      	    	//entity.setPedidoPuntoVentaOriginal(super.getEntity("",entity.getPedidoPuntoVentaOriginal(),resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoPuntoVentaOriginal(this.getEntityPedidoPuntoVenta("",entity.getPedidoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
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
	
	public  List<PedidoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoPuntoVenta();
					//entity.setMapPedidoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPedidoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=PedidoPuntoVentaDataAccess.getEntityPedidoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoPuntoVentaOriginal( new PedidoPuntoVenta());
					////entity.setPedidoPuntoVentaOriginal(super.getEntity("",entity.getPedidoPuntoVentaOriginal(),resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoPuntoVentaOriginal(this.getEntityPedidoPuntoVenta("",entity.getPedidoPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PedidoPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
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
	
	public  PedidoPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoPuntoVenta();
					//entity.setMapPedidoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPedidoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=PedidoPuntoVentaDataAccess.getEntityPedidoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoPuntoVentaOriginal( new PedidoPuntoVenta());
					////entity.setPedidoPuntoVentaOriginal(super.getEntity("",entity.getPedidoPuntoVentaOriginal(),resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoPuntoVentaOriginal(this.getEntityPedidoPuntoVenta("",entity.getPedidoPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePedidoPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PedidoPuntoVenta getEntityPedidoPuntoVenta(String strPrefijo,PedidoPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PedidoPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PedidoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PedidoPuntoVentaDataAccess.setFieldReflectionPedidoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPedidoPuntoVenta=PedidoPuntoVentaConstantesFunciones.getTodosTiposColumnasPedidoPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPedidoPuntoVenta) {
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
							field = PedidoPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PedidoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PedidoPuntoVentaDataAccess.setFieldReflectionPedidoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPedidoPuntoVenta(Field field,String strPrefijo,String sColumn,PedidoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PedidoPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDMESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.HORA:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoPuntoVentaConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PedidoPuntoVenta();
					entity=super.getEntity("",entity,resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPedidoPuntoVenta("",entity,resultSet);
					
					//entity.setPedidoPuntoVentaOriginal( new PedidoPuntoVenta());
					//entity.setPedidoPuntoVentaOriginal(super.getEntity("",entity.getPedidoPuntoVentaOriginal(),resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setPedidoPuntoVentaOriginal(this.getEntityPedidoPuntoVenta("",entity.getPedidoPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePedidoPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PedidoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
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
	
	public  List<PedidoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setPedidoPuntoVentaOriginal( new PedidoPuntoVenta());
      	    	//entity.setPedidoPuntoVentaOriginal(super.getEntity("",entity.getPedidoPuntoVentaOriginal(),resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoPuntoVentaOriginal(this.getEntityPedidoPuntoVenta("",entity.getPedidoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePedidoPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
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
	
	public  List<PedidoPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoPuntoVenta> entities = new  ArrayList<PedidoPuntoVenta>();
		PedidoPuntoVenta entity = new PedidoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setPedidoPuntoVentaOriginal( new PedidoPuntoVenta());
      	    	//entity.setPedidoPuntoVentaOriginal(super.getEntity("",entity.getPedidoPuntoVentaOriginal(),resultSet,PedidoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoPuntoVentaOriginal(this.getEntityPedidoPuntoVenta("",entity.getPedidoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PedidoPuntoVenta getEntityPedidoPuntoVenta(String strPrefijo,PedidoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDUSUARIO));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDVENDEDOR));
				entity.setid_caja(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDCAJA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDCLIENTE));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDTIPOPRECIO));
				entity.setid_mesa(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDMESA));
				entity.setid_estado_pedido_punto_venta(resultSet.getLong(strPrefijo+PedidoPuntoVentaConstantesFunciones.IDESTADOPEDIDOPUNTOVENTA));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL));
				entity.setcodigo_cliente(resultSet.getString(strPrefijo+PedidoPuntoVentaConstantesFunciones.CODIGOCLIENTE));
				entity.setnombre_cliente(resultSet.getString(strPrefijo+PedidoPuntoVentaConstantesFunciones.NOMBRECLIENTE));
				entity.setdireccion_cliente(resultSet.getString(strPrefijo+PedidoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE));
				entity.settelefono_cliente(resultSet.getString(strPrefijo+PedidoPuntoVentaConstantesFunciones.TELEFONOCLIENTE));
				entity.settarjeta_cliente(resultSet.getString(strPrefijo+PedidoPuntoVentaConstantesFunciones.TARJETACLIENTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PedidoPuntoVentaConstantesFunciones.FECHA).getTime()));
				entity.sethora(resultSet.getTime(strPrefijo+PedidoPuntoVentaConstantesFunciones.HORA));
				entity.setsub_total(resultSet.getDouble(strPrefijo+PedidoPuntoVentaConstantesFunciones.SUBTOTAL));
				entity.setiva(resultSet.getDouble(strPrefijo+PedidoPuntoVentaConstantesFunciones.IVA));
				entity.setice(resultSet.getDouble(strPrefijo+PedidoPuntoVentaConstantesFunciones.ICE));
				entity.setdescuento(resultSet.getDouble(strPrefijo+PedidoPuntoVentaConstantesFunciones.DESCUENTO));
				entity.settotal(resultSet.getDouble(strPrefijo+PedidoPuntoVentaConstantesFunciones.TOTAL));
			} else {
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+PedidoPuntoVentaConstantesFunciones.NUMERO_SECUENCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPedidoPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PedidoPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PedidoPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PedidoPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PedidoPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PedidoPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PedidoPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PedidoPuntoVentaDataAccess.TABLENAME,PedidoPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			PedidoPuntoVentaDataAccess.setPedidoPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpedidopuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpedidopuntoventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relpedidopuntoventa.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Vendedor getVendedor(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relpedidopuntoventa.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Caja getCaja(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);

			caja=cajaDataAccess.getEntity(connexion,relpedidopuntoventa.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}

	public Cliente getCliente(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpedidopuntoventa.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relpedidopuntoventa.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Mesa getMesa(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		Mesa mesa= new Mesa();

		try {
			MesaDataAccess mesaDataAccess=new MesaDataAccess();

			mesaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesaDataAccess.setConnexionType(this.connexionType);
			mesaDataAccess.setParameterDbType(this.parameterDbType);

			mesa=mesaDataAccess.getEntity(connexion,relpedidopuntoventa.getid_mesa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mesa;

	}

	public EstadoPedidoPuntoVenta getEstadoPedidoPuntoVenta(Connexion connexion,PedidoPuntoVenta relpedidopuntoventa)throws SQLException,Exception {

		EstadoPedidoPuntoVenta estadopedidopuntoventa= new EstadoPedidoPuntoVenta();

		try {
			EstadoPedidoPuntoVentaDataAccess estadopedidopuntoventaDataAccess=new EstadoPedidoPuntoVentaDataAccess();

			estadopedidopuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			estadopedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			estadopedidopuntoventa=estadopedidopuntoventaDataAccess.getEntity(connexion,relpedidopuntoventa.getid_estado_pedido_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedidopuntoventa;

	}


		
		public List<DetallePedidoPuntoVenta> getDetallePedidoPuntoVentas(Connexion connexion,PedidoPuntoVenta pedidopuntoventa)throws SQLException,Exception {

		List<DetallePedidoPuntoVenta> detallepedidopuntoventas= new ArrayList<DetallePedidoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoPuntoVentaConstantesFunciones.SCHEMA+".pedido_punto_venta ON "+DetallePedidoPuntoVentaConstantesFunciones.SCHEMA+".detalle_pedido_punto_venta.id_pedido_punto_venta="+PedidoPuntoVentaConstantesFunciones.SCHEMA+".pedido_punto_venta.id WHERE "+PedidoPuntoVentaConstantesFunciones.SCHEMA+".pedido_punto_venta.id="+String.valueOf(pedidopuntoventa.getId());
			} else {
				sQuery=" INNER JOIN detallepedidopuntoventa.PedidoPuntoVenta WHERE detallepedidopuntoventa.PedidoPuntoVenta.id="+String.valueOf(pedidopuntoventa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoPuntoVentaDataAccess detallepedidopuntoventaDataAccess=new DetallePedidoPuntoVentaDataAccess();

			detallepedidopuntoventaDataAccess.setConnexionType(this.connexionType);
			detallepedidopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidopuntoventas=detallepedidopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidopuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PedidoPuntoVenta pedidopuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!pedidopuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(pedidopuntoventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(pedidopuntoventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(pedidopuntoventa.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(pedidopuntoventa.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_caja.setValue(pedidopuntoventa.getid_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(pedidopuntoventa.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(pedidopuntoventa.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mesa=new ParameterValue<Long>();
					parameterMaintenanceValueid_mesa.setValue(pedidopuntoventa.getid_mesa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mesa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido_punto_venta.setValue(pedidopuntoventa.getid_estado_pedido_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(pedidopuntoventa.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_cliente=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_cliente.setValue(pedidopuntoventa.getcodigo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_cliente=new ParameterValue<String>();
					parameterMaintenanceValuenombre_cliente.setValue(pedidopuntoventa.getnombre_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_cliente=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_cliente.setValue(pedidopuntoventa.getdireccion_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_cliente.setValue(pedidopuntoventa.gettelefono_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetarjeta_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetarjeta_cliente.setValue(pedidopuntoventa.gettarjeta_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetarjeta_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(pedidopuntoventa.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora=new ParameterValue<Time>();
					parameterMaintenanceValuehora.setValue(pedidopuntoventa.gethora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(pedidopuntoventa.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(pedidopuntoventa.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(pedidopuntoventa.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(pedidopuntoventa.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(pedidopuntoventa.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
						if(!pedidopuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(pedidopuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(pedidopuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(pedidopuntoventa.getId());
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
	
	public void setIsNewIsChangedFalsePedidoPuntoVenta(PedidoPuntoVenta pedidopuntoventa)throws Exception  {		
		pedidopuntoventa.setIsNew(false);
		pedidopuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePedidoPuntoVentas(List<PedidoPuntoVenta> pedidopuntoventas)throws Exception  {				
		for(PedidoPuntoVenta pedidopuntoventa:pedidopuntoventas) {
			pedidopuntoventa.setIsNew(false);
			pedidopuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarPedidoPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
