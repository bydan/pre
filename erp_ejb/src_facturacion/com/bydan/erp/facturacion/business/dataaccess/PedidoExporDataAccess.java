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
import com.bydan.erp.facturacion.util.*;//PedidoExporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;




@SuppressWarnings("unused")
final public class PedidoExporDataAccess extends  PedidoExporDataAccessAdditional{ //PedidoExporDataAccessAdditional,DataAccessHelper<PedidoExpor>
	//static Logger logger = Logger.getLogger(PedidoExporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="pedido_expor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_anio,id_mes,id_usuario,numero,numero_preimpreso,fecha_emision,fecha_vencimiento,id_moneda,cotizacion,id_empleado,id_tipo_precio,id_formato,direccion,id_cliente,telefono,ruc,id_pais,lugar_entrega,embarque,negociacion,id_transporte,id_vendedor,forma_pago,id_sub_cliente,id_consignatario,id_consultor,orden,id_estado_pedido,descripcion,monto,saldo,disponible,descuento_porcentaje,total_con_iva,suman,descuento_valor,total_sin_iva,total_descuento,flete,total,subtotal,seguros,iva,financiamiento,monto_retencion,otro,ice,fecha,fecha_servidor,id_tipo_cambio,numero_fue,id_centro_costo,id_responsable,hora_inicio,hora_fin,id_transportista)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,numero=?,numero_preimpreso=?,fecha_emision=?,fecha_vencimiento=?,id_moneda=?,cotizacion=?,id_empleado=?,id_tipo_precio=?,id_formato=?,direccion=?,id_cliente=?,telefono=?,ruc=?,id_pais=?,lugar_entrega=?,embarque=?,negociacion=?,id_transporte=?,id_vendedor=?,forma_pago=?,id_sub_cliente=?,id_consignatario=?,id_consultor=?,orden=?,id_estado_pedido=?,descripcion=?,monto=?,saldo=?,disponible=?,descuento_porcentaje=?,total_con_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,total_descuento=?,flete=?,total=?,subtotal=?,seguros=?,iva=?,financiamiento=?,monto_retencion=?,otro=?,ice=?,fecha=?,fecha_servidor=?,id_tipo_cambio=?,numero_fue=?,id_centro_costo=?,id_responsable=?,hora_inicio=?,hora_fin=?,id_transportista=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select pedidoexpor from "+PedidoExporConstantesFunciones.SPERSISTENCENAME+" pedidoexpor";
	public static String QUERYSELECTNATIVE="select "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".version_row,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_empresa,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_sucursal,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_ejercicio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_periodo,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_anio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_mes,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_usuario,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".numero,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".numero_preimpreso,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".fecha_emision,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".fecha_vencimiento,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_moneda,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".cotizacion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_empleado,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_tipo_precio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_formato,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".direccion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_cliente,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".telefono,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".ruc,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_pais,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".lugar_entrega,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".embarque,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".negociacion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_transporte,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_vendedor,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".forma_pago,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_sub_cliente,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_consignatario,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_consultor,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".orden,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_estado_pedido,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".descripcion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".monto,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".saldo,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".disponible,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".descuento_porcentaje,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".total_con_iva,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".suman,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".descuento_valor,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".total_sin_iva,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".total_descuento,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".flete,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".total,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".subtotal,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".seguros,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".iva,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".financiamiento,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".monto_retencion,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".otro,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".ice,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".fecha,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".fecha_servidor,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_tipo_cambio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".numero_fue,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_centro_costo,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_responsable,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".hora_inicio,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".hora_fin,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id_transportista from "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME;//+" as "+PedidoExporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".id,"+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+".version_row from "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME;//+" as "+PedidoExporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PedidoExporConstantesFunciones.SCHEMA+"."+PedidoExporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_anio=?,id_mes=?,id_usuario=?,numero=?,numero_preimpreso=?,fecha_emision=?,fecha_vencimiento=?,id_moneda=?,cotizacion=?,id_empleado=?,id_tipo_precio=?,id_formato=?,direccion=?,id_cliente=?,telefono=?,ruc=?,id_pais=?,lugar_entrega=?,embarque=?,negociacion=?,id_transporte=?,id_vendedor=?,forma_pago=?,id_sub_cliente=?,id_consignatario=?,id_consultor=?,orden=?,id_estado_pedido=?,descripcion=?,monto=?,saldo=?,disponible=?,descuento_porcentaje=?,total_con_iva=?,suman=?,descuento_valor=?,total_sin_iva=?,total_descuento=?,flete=?,total=?,subtotal=?,seguros=?,iva=?,financiamiento=?,monto_retencion=?,otro=?,ice=?,fecha=?,fecha_servidor=?,id_tipo_cambio=?,numero_fue=?,id_centro_costo=?,id_responsable=?,hora_inicio=?,hora_fin=?,id_transportista=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PEDIDOEXPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PEDIDOEXPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PEDIDOEXPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PEDIDOEXPOR_SELECT(?,?)";
	
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
	
	
	protected PedidoExporDataAccessAdditional pedidoexporDataAccessAdditional=null;
	
	public PedidoExporDataAccessAdditional getPedidoExporDataAccessAdditional() {
		return this.pedidoexporDataAccessAdditional;
	}
	
	public void setPedidoExporDataAccessAdditional(PedidoExporDataAccessAdditional pedidoexporDataAccessAdditional) {
		try {
			this.pedidoexporDataAccessAdditional=pedidoexporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PedidoExporDataAccess() {
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
		PedidoExporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PedidoExporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PedidoExporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPedidoExporOriginal(PedidoExpor pedidoexpor)throws Exception  {
		pedidoexpor.setPedidoExporOriginal((PedidoExpor)pedidoexpor.clone());		
	}
	
	public void setPedidoExporsOriginal(List<PedidoExpor> pedidoexpors)throws Exception  {
		
		for(PedidoExpor pedidoexpor:pedidoexpors){
			pedidoexpor.setPedidoExporOriginal((PedidoExpor)pedidoexpor.clone());
		}
	}
	
	public static void setPedidoExporOriginalStatic(PedidoExpor pedidoexpor)throws Exception  {
		pedidoexpor.setPedidoExporOriginal((PedidoExpor)pedidoexpor.clone());		
	}
	
	public static void setPedidoExporsOriginalStatic(List<PedidoExpor> pedidoexpors)throws Exception  {
		
		for(PedidoExpor pedidoexpor:pedidoexpors){
			pedidoexpor.setPedidoExporOriginal((PedidoExpor)pedidoexpor.clone());
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
	
	public  PedidoExpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoExpor entity = new PedidoExpor();		
		
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
	
	public  PedidoExpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PedidoExpor entity = new PedidoExpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.PedidoExpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPedidoExporOriginal(new PedidoExpor());
      	    	entity=super.getEntity("",entity,resultSet,PedidoExporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoExpor("",entity,resultSet); 
				
				//entity.setPedidoExporOriginal(super.getEntity("",entity.getPedidoExporOriginal(),resultSet,PedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoExporOriginal(this.getEntityPedidoExpor("",entity.getPedidoExporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoExpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PedidoExpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoExpor entity = new PedidoExpor();
				
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
	
	public  PedidoExpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PedidoExpor entity = new PedidoExpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.PedidoExpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPedidoExporOriginal(new PedidoExpor());
      	    	entity=super.getEntity("",entity,resultSet,PedidoExporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPedidoExpor("",entity,resultSet);    
				
				//entity.setPedidoExporOriginal(super.getEntity("",entity.getPedidoExporOriginal(),resultSet,PedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoExporOriginal(this.getEntityPedidoExpor("",entity.getPedidoExporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePedidoExpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PedidoExpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PedidoExpor entity = new PedidoExpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.PedidoExpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePedidoExpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PedidoExpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
		
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
	
	public  List<PedidoExpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoExpor();
      	    	entity=super.getEntity("",entity,resultSet,PedidoExporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoExpor("",entity,resultSet);
      	    	
				//entity.setPedidoExporOriginal( new PedidoExpor());
      	    	//entity.setPedidoExporOriginal(super.getEntity("",entity.getPedidoExporOriginal(),resultSet,PedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoExporOriginal(this.getEntityPedidoExpor("",entity.getPedidoExporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoExpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoExpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
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
	
	public  List<PedidoExpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoExpor();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoExpor();
					//entity.setMapPedidoExpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPedidoExporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoExpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoExporDataAccess.ISWITHSCHEMA);         		
					entity=PedidoExporDataAccess.getEntityPedidoExpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoExporOriginal( new PedidoExpor());
					////entity.setPedidoExporOriginal(super.getEntity("",entity.getPedidoExporOriginal(),resultSet,PedidoExporDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoExporOriginal(this.getEntityPedidoExpor("",entity.getPedidoExporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoExpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PedidoExpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoExpor entity = new PedidoExpor();		  
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
	
	public  PedidoExpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PedidoExpor entity = new PedidoExpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoExpor();
				
				if(conMapGenerico) {
					entity.inicializarMapPedidoExpor();
					//entity.setMapPedidoExpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPedidoExporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPedidoExpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PedidoExporDataAccess.ISWITHSCHEMA);         		
					entity=PedidoExporDataAccess.getEntityPedidoExpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPedidoExporOriginal( new PedidoExpor());
					////entity.setPedidoExporOriginal(super.getEntity("",entity.getPedidoExporOriginal(),resultSet,PedidoExporDataAccess.ISWITHSCHEMA));         		
					////entity.setPedidoExporOriginal(this.getEntityPedidoExpor("",entity.getPedidoExporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePedidoExpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PedidoExpor getEntityPedidoExpor(String strPrefijo,PedidoExpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PedidoExpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PedidoExpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PedidoExporDataAccess.setFieldReflectionPedidoExpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPedidoExpor=PedidoExporConstantesFunciones.getTodosTiposColumnasPedidoExpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPedidoExpor) {
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
							field = PedidoExpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PedidoExpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PedidoExporDataAccess.setFieldReflectionPedidoExpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPedidoExpor(Field field,String strPrefijo,String sColumn,PedidoExpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PedidoExporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.NUMERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoExporConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoExporConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.COTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.LUGARENTREGA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.EMBARQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.NEGOCIACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.FORMAPAGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDSUBCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDCONSIGNATARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDCONSULTOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.MONTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.SALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.DISPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.TOTALCONIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.SUMAN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.TOTALDESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.SEGUROS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.MONTORETENCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.OTRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoExporConstantesFunciones.FECHASERVIDOR:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case PedidoExporConstantesFunciones.IDTIPOCAMBIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.NUMEROFUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDRESPONSABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.HORAINICIO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.HORAFIN:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case PedidoExporConstantesFunciones.IDTRANSPORTISTA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoExpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new PedidoExpor();
					entity=super.getEntity("",entity,resultSet,PedidoExporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPedidoExpor("",entity,resultSet);
					
					//entity.setPedidoExporOriginal( new PedidoExpor());
					//entity.setPedidoExporOriginal(super.getEntity("",entity.getPedidoExporOriginal(),resultSet,PedidoExporDataAccess.ISWITHSCHEMA));         		
					//entity.setPedidoExporOriginal(this.getEntityPedidoExpor("",entity.getPedidoExporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePedidoExpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PedidoExpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PedidoExporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PedidoExporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<PedidoExpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
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
	
	public  List<PedidoExpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoExpor();
      	    	entity=super.getEntity("",entity,resultSet,PedidoExporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoExpor("",entity,resultSet);
      	    	
				//entity.setPedidoExporOriginal( new PedidoExpor());
      	    	//entity.setPedidoExporOriginal(super.getEntity("",entity.getPedidoExporOriginal(),resultSet,PedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoExporOriginal(this.getEntityPedidoExpor("",entity.getPedidoExporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePedidoExpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPedidoExpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PedidoExpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
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
	
	public  List<PedidoExpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PedidoExpor> entities = new  ArrayList<PedidoExpor>();
		PedidoExpor entity = new PedidoExpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PedidoExpor();
      	    	entity=super.getEntity("",entity,resultSet,PedidoExporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPedidoExpor("",entity,resultSet);
      	    	
				//entity.setPedidoExporOriginal( new PedidoExpor());
      	    	//entity.setPedidoExporOriginal(super.getEntity("",entity.getPedidoExporOriginal(),resultSet,PedidoExporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPedidoExporOriginal(this.getEntityPedidoExpor("",entity.getPedidoExporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePedidoExpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PedidoExpor getEntityPedidoExpor(String strPrefijo,PedidoExpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDPERIODO));
				entity.setid_anio(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_usuario(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDUSUARIO));
				entity.setnumero(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.NUMERO));
				entity.setnumero_preimpreso(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.NUMEROAUTORIZACION));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+PedidoExporConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+PedidoExporConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setid_moneda(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDMONEDA));
				entity.setcotizacion(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.COTIZACION));
				entity.setid_empleado(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDEMPLEADO));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDTIPOPRECIO));
				entity.setid_formato(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDFORMATO));if(resultSet.wasNull()) {entity.setid_formato(null); }
				entity.setdireccion(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.DIRECCION));
				entity.setid_cliente(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDCLIENTE));
				entity.settelefono(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.TELEFONO));
				entity.setruc(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.RUC));
				entity.setid_pais(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDPAIS));if(resultSet.wasNull()) {entity.setid_pais(null); }
				entity.setlugar_entrega(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.LUGARENTREGA));
				entity.setembarque(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.EMBARQUE));
				entity.setnegociacion(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.NEGOCIACION));
				entity.setid_transporte(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDTRANSPORTE));if(resultSet.wasNull()) {entity.setid_transporte(null); }
				entity.setid_vendedor(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDVENDEDOR));if(resultSet.wasNull()) {entity.setid_vendedor(null); }
				entity.setforma_pago(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.FORMAPAGO));
				entity.setid_sub_cliente(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDSUBCLIENTE));if(resultSet.wasNull()) {entity.setid_sub_cliente(null); }
				entity.setid_consignatario(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDCONSIGNATARIO));if(resultSet.wasNull()) {entity.setid_consignatario(null); }
				entity.setid_consultor(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDCONSULTOR));if(resultSet.wasNull()) {entity.setid_consultor(null); }
				entity.setorden(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.ORDEN));
				entity.setid_estado_pedido(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDESTADOPEDIDOEXPOR));
				entity.setdescripcion(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.DESCRIPCION));
				entity.setmonto(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.MONTO));
				entity.setsaldo(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.SALDO));
				entity.setdisponible(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.DISPONIBLE));
				entity.setdescuento_porcentaje(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.DESCUENTOPORCENTAJE));
				entity.settotal_con_iva(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.TOTALCONIVA));
				entity.setsuman(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.SUMAN));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.DESCUENTOVALOR));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.TOTALSINIVA));
				entity.settotal_descuento(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.TOTALDESCUENTO));
				entity.setflete(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.FLETE));
				entity.settotal(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.TOTAL));
				entity.setsubtotal(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.SUBTOTAL));
				entity.setseguros(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.SEGUROS));
				entity.setiva(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.IVA));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.FINANCIAMIENTO));
				entity.setmonto_retencion(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.MONTORETENCION));
				entity.setotro(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.OTRO));
				entity.setice(resultSet.getDouble(strPrefijo+PedidoExporConstantesFunciones.ICE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+PedidoExporConstantesFunciones.FECHA).getTime()));
				entity.setfecha_servidor(new Date(resultSet.getDate(strPrefijo+PedidoExporConstantesFunciones.FECHASERVIDOR).getTime()));
				entity.setid_tipo_cambio(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDTIPOCAMBIO));if(resultSet.wasNull()) {entity.setid_tipo_cambio(null); }
				entity.setnumero_fue(resultSet.getString(strPrefijo+PedidoExporConstantesFunciones.NUMEROFUE));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_responsable(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDRESPONSABLE));
				entity.sethora_inicio(resultSet.getTime(strPrefijo+PedidoExporConstantesFunciones.HORAINICIO));
				entity.sethora_fin(resultSet.getTime(strPrefijo+PedidoExporConstantesFunciones.HORAFIN));
				entity.setid_transportista(resultSet.getLong(strPrefijo+PedidoExporConstantesFunciones.IDTRANSPORTISTA));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPedidoExpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PedidoExpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PedidoExporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PedidoExporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PedidoExporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PedidoExporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PedidoExporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PedidoExporDataAccess.TABLENAME,PedidoExporDataAccess.ISWITHSTOREPROCEDURES);
			
			PedidoExporDataAccess.setPedidoExporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpedidoexpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpedidoexpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpedidoexpor.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpedidoexpor.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Anio getAnio(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,relpedidoexpor.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relpedidoexpor.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Usuario getUsuario(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relpedidoexpor.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Moneda getMoneda(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relpedidoexpor.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public Empleado getEmpleado(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relpedidoexpor.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relpedidoexpor.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Formato getFormato(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relpedidoexpor.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Cliente getCliente(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relpedidoexpor.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Pais getPais(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relpedidoexpor.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Transporte getTransporte(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Transporte transporte= new Transporte();

		try {
			TransporteDataAccess transporteDataAccess=new TransporteDataAccess();

			transporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transporteDataAccess.setConnexionType(this.connexionType);
			transporteDataAccess.setParameterDbType(this.parameterDbType);

			transporte=transporteDataAccess.getEntity(connexion,relpedidoexpor.getid_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transporte;

	}

	public Vendedor getVendedor(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relpedidoexpor.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public SubCliente getSubCliente(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		SubCliente subcliente= new SubCliente();

		try {
			SubClienteDataAccess subclienteDataAccess=new SubClienteDataAccess();

			subclienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			subclienteDataAccess.setConnexionType(this.connexionType);
			subclienteDataAccess.setParameterDbType(this.parameterDbType);

			subcliente=subclienteDataAccess.getEntity(connexion,relpedidoexpor.getid_sub_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return subcliente;

	}

	public Consignatario getConsignatario(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Consignatario consignatario= new Consignatario();

		try {
			ConsignatarioDataAccess consignatarioDataAccess=new ConsignatarioDataAccess();

			consignatarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			consignatarioDataAccess.setConnexionType(this.connexionType);
			consignatarioDataAccess.setParameterDbType(this.parameterDbType);

			consignatario=consignatarioDataAccess.getEntity(connexion,relpedidoexpor.getid_consignatario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consignatario;

	}

	public Consultor getConsultor(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Consultor consultor= new Consultor();

		try {
			ConsultorDataAccess consultorDataAccess=new ConsultorDataAccess();

			consultorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			consultorDataAccess.setConnexionType(this.connexionType);
			consultorDataAccess.setParameterDbType(this.parameterDbType);

			consultor=consultorDataAccess.getEntity(connexion,relpedidoexpor.getid_consultor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return consultor;

	}

	public EstadoPedido getEstadoPedidoExpor(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		EstadoPedido estadopedido= new EstadoPedido();

		try {
			EstadoPedidoDataAccess estadopedidoDataAccess=new EstadoPedidoDataAccess();

			//estadopedidoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadopedidoDataAccess.setConnexionType(this.connexionType);
			estadopedidoDataAccess.setParameterDbType(this.parameterDbType);

			estadopedido=estadopedidoDataAccess.getEntity(connexion,relpedidoexpor.getid_estado_pedido());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadopedido;

	}

	public TipoCambio getTipoCambio(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		TipoCambio tipocambio= new TipoCambio();

		try {
			TipoCambioDataAccess tipocambioDataAccess=new TipoCambioDataAccess();

			tipocambioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocambioDataAccess.setConnexionType(this.connexionType);
			tipocambioDataAccess.setParameterDbType(this.parameterDbType);

			tipocambio=tipocambioDataAccess.getEntity(connexion,relpedidoexpor.getid_tipo_cambio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocambio;

	}

	public CentroCosto getCentroCosto(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relpedidoexpor.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Responsable getResponsable(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Responsable responsable= new Responsable();

		try {
			ResponsableDataAccess responsableDataAccess=new ResponsableDataAccess();

			responsableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			responsableDataAccess.setConnexionType(this.connexionType);
			responsableDataAccess.setParameterDbType(this.parameterDbType);

			responsable=responsableDataAccess.getEntity(connexion,relpedidoexpor.getid_responsable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return responsable;

	}

	public Transportista getTransportista(Connexion connexion,PedidoExpor relpedidoexpor)throws SQLException,Exception {

		Transportista transportista= new Transportista();

		try {
			TransportistaDataAccess transportistaDataAccess=new TransportistaDataAccess();

			transportistaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transportistaDataAccess.setConnexionType(this.connexionType);
			transportistaDataAccess.setParameterDbType(this.parameterDbType);

			transportista=transportistaDataAccess.getEntity(connexion,relpedidoexpor.getid_transportista());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transportista;

	}


		
		public List<DetallePedidoExpor> getDetallePedidoExpors(Connexion connexion,PedidoExpor pedidoexpor)throws SQLException,Exception {

		List<DetallePedidoExpor> detallepedidoexpors= new ArrayList<DetallePedidoExpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor ON "+DetallePedidoExporConstantesFunciones.SCHEMA+".detalle_pedido_expor.id_pedido_expor="+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id WHERE "+PedidoExporConstantesFunciones.SCHEMA+".pedido_expor.id="+String.valueOf(pedidoexpor.getId());
			} else {
				sQuery=" INNER JOIN detallepedidoexpor.PedidoExpor WHERE detallepedidoexpor.PedidoExpor.id="+String.valueOf(pedidoexpor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetallePedidoExporDataAccess detallepedidoexporDataAccess=new DetallePedidoExporDataAccess();

			detallepedidoexporDataAccess.setConnexionType(this.connexionType);
			detallepedidoexporDataAccess.setParameterDbType(this.parameterDbType);
			detallepedidoexpors=detallepedidoexporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallepedidoexpors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PedidoExpor pedidoexpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!pedidoexpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(pedidoexpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(pedidoexpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(pedidoexpor.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(pedidoexpor.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(pedidoexpor.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(pedidoexpor.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(pedidoexpor.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(pedidoexpor.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_preimpreso=new ParameterValue<String>();
					parameterMaintenanceValuenumero_preimpreso.setValue(pedidoexpor.getnumero_preimpreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_preimpreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(pedidoexpor.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(pedidoexpor.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(pedidoexpor.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecotizacion=new ParameterValue<Double>();
					parameterMaintenanceValuecotizacion.setValue(pedidoexpor.getcotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(pedidoexpor.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(pedidoexpor.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(pedidoexpor.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(pedidoexpor.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(pedidoexpor.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(pedidoexpor.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(pedidoexpor.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(pedidoexpor.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuelugar_entrega=new ParameterValue<String>();
					parameterMaintenanceValuelugar_entrega.setValue(pedidoexpor.getlugar_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelugar_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueembarque=new ParameterValue<String>();
					parameterMaintenanceValueembarque.setValue(pedidoexpor.getembarque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueembarque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenegociacion=new ParameterValue<String>();
					parameterMaintenanceValuenegociacion.setValue(pedidoexpor.getnegociacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenegociacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_transporte.setValue(pedidoexpor.getid_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(pedidoexpor.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueforma_pago=new ParameterValue<String>();
					parameterMaintenanceValueforma_pago.setValue(pedidoexpor.getforma_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueforma_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sub_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_sub_cliente.setValue(pedidoexpor.getid_sub_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sub_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_consignatario=new ParameterValue<Long>();
					parameterMaintenanceValueid_consignatario.setValue(pedidoexpor.getid_consignatario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_consignatario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_consultor=new ParameterValue<Long>();
					parameterMaintenanceValueid_consultor.setValue(pedidoexpor.getid_consultor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_consultor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueorden=new ParameterValue<String>();
					parameterMaintenanceValueorden.setValue(pedidoexpor.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_pedido=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_pedido.setValue(pedidoexpor.getid_estado_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(pedidoexpor.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto=new ParameterValue<Double>();
					parameterMaintenanceValuemonto.setValue(pedidoexpor.getmonto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesaldo=new ParameterValue<Double>();
					parameterMaintenanceValuesaldo.setValue(pedidoexpor.getsaldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedisponible=new ParameterValue<Double>();
					parameterMaintenanceValuedisponible.setValue(pedidoexpor.getdisponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedisponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_porcentaje.setValue(pedidoexpor.getdescuento_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_con_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_con_iva.setValue(pedidoexpor.gettotal_con_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_con_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesuman=new ParameterValue<Double>();
					parameterMaintenanceValuesuman.setValue(pedidoexpor.getsuman());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesuman);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(pedidoexpor.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(pedidoexpor.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_descuento=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_descuento.setValue(pedidoexpor.gettotal_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(pedidoexpor.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(pedidoexpor.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesubtotal=new ParameterValue<Double>();
					parameterMaintenanceValuesubtotal.setValue(pedidoexpor.getsubtotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesubtotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueseguros=new ParameterValue<Double>();
					parameterMaintenanceValueseguros.setValue(pedidoexpor.getseguros());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueseguros);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(pedidoexpor.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(pedidoexpor.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_retencion=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_retencion.setValue(pedidoexpor.getmonto_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotro=new ParameterValue<Double>();
					parameterMaintenanceValueotro.setValue(pedidoexpor.getotro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(pedidoexpor.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(pedidoexpor.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_servidor=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_servidor.setValue(pedidoexpor.getfecha_servidor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_servidor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cambio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cambio.setValue(pedidoexpor.getid_tipo_cambio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cambio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_fue=new ParameterValue<String>();
					parameterMaintenanceValuenumero_fue.setValue(pedidoexpor.getnumero_fue());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_fue);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(pedidoexpor.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_responsable=new ParameterValue<Long>();
					parameterMaintenanceValueid_responsable.setValue(pedidoexpor.getid_responsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_responsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_inicio=new ParameterValue<Time>();
					parameterMaintenanceValuehora_inicio.setValue(pedidoexpor.gethora_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_fin=new ParameterValue<Time>();
					parameterMaintenanceValuehora_fin.setValue(pedidoexpor.gethora_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transportista=new ParameterValue<Long>();
					parameterMaintenanceValueid_transportista.setValue(pedidoexpor.getid_transportista());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transportista);
					parametersTemp.add(parameterMaintenance);
					
						if(!pedidoexpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(pedidoexpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(pedidoexpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(pedidoexpor.getId());
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
	
	public void setIsNewIsChangedFalsePedidoExpor(PedidoExpor pedidoexpor)throws Exception  {		
		pedidoexpor.setIsNew(false);
		pedidoexpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePedidoExpors(List<PedidoExpor> pedidoexpors)throws Exception  {				
		for(PedidoExpor pedidoexpor:pedidoexpors) {
			pedidoexpor.setIsNew(false);
			pedidoexpor.setIsChanged(false);
		}
	}
	
	public void generarExportarPedidoExpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
