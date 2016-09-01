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
package com.bydan.erp.contabilidad.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.contabilidad.util.AsientoContableCajaChicaConstantesFunciones;
import com.bydan.erp.contabilidad.util.AsientoContableCajaChicaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.AsientoContableCajaChicaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AsientoContableCajaChicaConstantesFunciones extends AsientoContableCajaChicaConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="AsientoContableCajaChica";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AsientoContableCajaChica"+AsientoContableCajaChicaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AsientoContableCajaChicaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AsientoContableCajaChicaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+AsientoContableCajaChicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+AsientoContableCajaChicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+AsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+AsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AsientoContableCajaChicaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AsientoContableCajaChicaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AsientoContableCajaChicaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AsientoContableCajaChicaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Asiento Contable Caja Chicas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Asiento Contable Caja Chica";
	public static final String SCLASSWEBTITULO_LOWER="Asiento Contable Caja Chica";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AsientoContableCajaChica";
	public static final String OBJECTNAME="asientocontablecajachica";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="asiento_contable_caja_chica";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select asientocontablecajachica from "+AsientoContableCajaChicaConstantesFunciones.SPERSISTENCENAME+" asientocontablecajachica";
	public static String QUERYSELECTNATIVE="select "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_empresa,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_sucursal,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_ejercicio,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_periodo,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_usuario,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_anio,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_mes,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".secuencial,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_moneda,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".fecha,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_empleado,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_estado_asiento_contable,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".es_proveedor,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_cliente,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_transaccion,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_documento,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".detalle,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_modulo,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo from "+AsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+AsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+AsientoContableCajaChicaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected AsientoContableCajaChicaConstantesFuncionesAdditional asientocontablecajachicaConstantesFuncionesAdditional=null;
	
	public AsientoContableCajaChicaConstantesFuncionesAdditional getAsientoContableCajaChicaConstantesFuncionesAdditional() {
		return this.asientocontablecajachicaConstantesFuncionesAdditional;
	}
	
	public void setAsientoContableCajaChicaConstantesFuncionesAdditional(AsientoContableCajaChicaConstantesFuncionesAdditional asientocontablecajachicaConstantesFuncionesAdditional) {
		try {
			this.asientocontablecajachicaConstantesFuncionesAdditional=asientocontablecajachicaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String SECUENCIAL= "secuencial";
    public static final String IDMONEDA= "id_moneda";
    public static final String FECHA= "fecha";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTADOASIENTOCONTABLECAJACHICA= "id_estado_asiento_contable";
    public static final String ESPROVEEDOR= "es_proveedor";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String DETALLE= "detalle";
    public static final String IDMODULO= "id_modulo";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDTIPOMOVIMIENTOMODULO= "id_tipo_movimiento_modulo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTADOASIENTOCONTABLECAJACHICA= "Estado";
		public static final String LABEL_IDESTADOASIENTOCONTABLECAJACHICA_LOWER= "Estado Asiento Contable Caja Chica";
    	public static final String LABEL_ESPROVEEDOR= "Es Proveedor";
		public static final String LABEL_ESPROVEEDOR_LOWER= "Es Proveedor";
    	public static final String LABEL_IDCLIENTE= "Cliente/Prove";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTRANSACCION= "Tipo";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTIPODOCUMENTO= "T Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_IDCUENTACONTABLE= "Cta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_IDTIPOMOVIMIENTOMODULO= "Movimiento Modulo";
		public static final String LABEL_IDTIPOMOVIMIENTOMODULO_LOWER= "Tipo Movimiento Modulo";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getAsientoContableCajaChicaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDUSUARIO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDANIO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDMES)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.SECUENCIAL)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDMONEDA)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.FECHA)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLECAJACHICA;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDCLIENTE)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.DETALLE)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDMODULO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {sLabelColumna=AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_proveedorDescripcion(AsientoContableCajaChica asientocontablecajachica) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!asientocontablecajachica.getes_proveedor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_proveedorHtmlDescripcion(AsientoContableCajaChica asientocontablecajachica) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(asientocontablecajachica.getId(),asientocontablecajachica.getes_proveedor());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
	
	public static String getAsientoContableCajaChicaDescripcion(AsientoContableCajaChica asientocontablecajachica) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(asientocontablecajachica !=null/* && asientocontablecajachica.getId()!=0*/) {
			sDescripcion=asientocontablecajachica.getsecuencial().toString();//asientocontablecajachicaasientocontablecajachica.getsecuencial().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAsientoContableCajaChicaDescripcionDetallado(AsientoContableCajaChica asientocontablecajachica) {
		String sDescripcion="";
			
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.ID+"=";
		sDescripcion+=asientocontablecajachica.getId().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=asientocontablecajachica.getVersionRow().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=asientocontablecajachica.getid_empresa().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=asientocontablecajachica.getid_sucursal().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=asientocontablecajachica.getid_ejercicio().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=asientocontablecajachica.getid_periodo().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=asientocontablecajachica.getid_usuario().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDANIO+"=";
		sDescripcion+=asientocontablecajachica.getid_anio().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDMES+"=";
		sDescripcion+=asientocontablecajachica.getid_mes().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=asientocontablecajachica.getsecuencial().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=asientocontablecajachica.getid_moneda().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.FECHA+"=";
		sDescripcion+=asientocontablecajachica.getfecha().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=asientocontablecajachica.getid_empleado().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA+"=";
		sDescripcion+=asientocontablecajachica.getid_estado_asiento_contable().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR+"=";
		sDescripcion+=asientocontablecajachica.getes_proveedor().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=asientocontablecajachica.getid_cliente().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=asientocontablecajachica.getid_transaccion().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=asientocontablecajachica.getid_tipo_documento().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=asientocontablecajachica.getid_cuenta_contable().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.DETALLE+"=";
		sDescripcion+=asientocontablecajachica.getdetalle()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDMODULO+"=";
		sDescripcion+=asientocontablecajachica.getid_modulo().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=asientocontablecajachica.getid_tipo_movimiento().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=asientocontablecajachica.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO+"=";
		sDescripcion+=asientocontablecajachica.getid_tipo_movimiento_modulo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAsientoContableCajaChicaDescripcion(AsientoContableCajaChica asientocontablecajachica,String sValor) throws Exception {			
		if(asientocontablecajachica !=null) {
			;//asientocontablecajachicaasientocontablecajachica.getsecuencial().toString().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getEstadoAsientoContableCajaChicaDescripcion(EstadoAsientoContableCajaChica estadoasientocontablecajachica) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoasientocontablecajachica!=null/*&&estadoasientocontablecajachica.getId()>0*/) {
			sDescripcion=EstadoAsientoContableCajaChicaConstantesFunciones.getEstadoAsientoContableCajaChicaDescripcion(estadoasientocontablecajachica);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoModuloDescripcion(TipoMovimientoModulo tipomovimientomodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimientomodulo!=null/*&&tipomovimientomodulo.getId()>0*/) {
			sDescripcion=TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(tipomovimientomodulo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente/Prove";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoAsientoContableCajaChica")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por T Documento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimientoModulo")) {
			sNombreIndice="Tipo=  Por Movimiento Modulo";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Tipo";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente/Prove="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoAsientoContableCajaChica(Long id_estado_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De T Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimientoModulo(Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_transaccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachica,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		asientocontablecajachica.setdetalle(asientocontablecajachica.getdetalle().trim());
	}
	
	public static void quitarEspaciosAsientoContableCajaChicas(List<AsientoContableCajaChica> asientocontablecajachicas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AsientoContableCajaChica asientocontablecajachica: asientocontablecajachicas) {
			asientocontablecajachica.setdetalle(asientocontablecajachica.getdetalle().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachica,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && asientocontablecajachica.getConCambioAuxiliar()) {
			asientocontablecajachica.setIsDeleted(asientocontablecajachica.getIsDeletedAuxiliar());	
			asientocontablecajachica.setIsNew(asientocontablecajachica.getIsNewAuxiliar());	
			asientocontablecajachica.setIsChanged(asientocontablecajachica.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			asientocontablecajachica.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			asientocontablecajachica.setIsDeletedAuxiliar(false);	
			asientocontablecajachica.setIsNewAuxiliar(false);	
			asientocontablecajachica.setIsChangedAuxiliar(false);
			
			asientocontablecajachica.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsientoContableCajaChicas(List<AsientoContableCajaChica> asientocontablecajachicas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AsientoContableCajaChica asientocontablecajachica : asientocontablecajachicas) {
			if(conAsignarBase && asientocontablecajachica.getConCambioAuxiliar()) {
				asientocontablecajachica.setIsDeleted(asientocontablecajachica.getIsDeletedAuxiliar());	
				asientocontablecajachica.setIsNew(asientocontablecajachica.getIsNewAuxiliar());	
				asientocontablecajachica.setIsChanged(asientocontablecajachica.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				asientocontablecajachica.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				asientocontablecajachica.setIsDeletedAuxiliar(false);	
				asientocontablecajachica.setIsNewAuxiliar(false);	
				asientocontablecajachica.setIsChangedAuxiliar(false);
				
				asientocontablecajachica.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachica,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			asientocontablecajachica.setsecuencial(0L);
		}
	}		
	
	public static void InicializarValoresAsientoContableCajaChicas(List<AsientoContableCajaChica> asientocontablecajachicas,Boolean conEnteros) throws Exception  {
		
		for(AsientoContableCajaChica asientocontablecajachica: asientocontablecajachicas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				asientocontablecajachica.setsecuencial(0L);
			}
		}				
	}
	
	public static void TotalizarValoresFilaAsientoContableCajaChica(List<AsientoContableCajaChica> asientocontablecajachicas,AsientoContableCajaChica asientocontablecajachicaAux) throws Exception  {
		AsientoContableCajaChicaConstantesFunciones.InicializarValoresAsientoContableCajaChica(asientocontablecajachicaAux,true);
		
		for(AsientoContableCajaChica asientocontablecajachica: asientocontablecajachicas) {
			if(asientocontablecajachica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			asientocontablecajachicaAux.setsecuencial(asientocontablecajachicaAux.getsecuencial()+asientocontablecajachica.getsecuencial());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AsientoContableCajaChicaConstantesFunciones.getArrayColumnasGlobalesAsientoContableCajaChica(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableCajaChicaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableCajaChicaConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableCajaChicaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableCajaChicaConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableCajaChicaConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableCajaChicaConstantesFunciones.IDMONEDA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableCajaChicaConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableCajaChicaConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AsientoContableCajaChica> asientocontablecajachicas,AsientoContableCajaChica asientocontablecajachica,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AsientoContableCajaChica asientocontablecajachicaAux: asientocontablecajachicas) {
			if(asientocontablecajachicaAux!=null && asientocontablecajachica!=null) {
				if((asientocontablecajachicaAux.getId()==null && asientocontablecajachica.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(asientocontablecajachicaAux.getId()!=null && asientocontablecajachica.getId()!=null){
					if(asientocontablecajachicaAux.getId().equals(asientocontablecajachica.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAsientoContableCajaChica(List<AsientoContableCajaChica> asientocontablecajachicas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AsientoContableCajaChica asientocontablecajachica: asientocontablecajachicas) {			
			if(asientocontablecajachica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAsientoContableCajaChica() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_ID, AsientoContableCajaChicaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_VERSIONROW, AsientoContableCajaChicaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA, AsientoContableCajaChicaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL, AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO, AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO, AsientoContableCajaChicaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDUSUARIO, AsientoContableCajaChicaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO, AsientoContableCajaChicaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDMES, AsientoContableCajaChicaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_SECUENCIAL, AsientoContableCajaChicaConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDMONEDA, AsientoContableCajaChicaConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_FECHA, AsientoContableCajaChicaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPLEADO, AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLECAJACHICA, AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR, AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDCLIENTE, AsientoContableCajaChicaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION, AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPODOCUMENTO, AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDCUENTACONTABLE, AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE, AsientoContableCajaChicaConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO, AsientoContableCajaChicaConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO, AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAsientoContableCajaChica() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsientoContableCajaChica() throws Exception  {
		return AsientoContableCajaChicaConstantesFunciones.getTiposSeleccionarAsientoContableCajaChica(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsientoContableCajaChica(Boolean conFk) throws Exception  {
		return AsientoContableCajaChicaConstantesFunciones.getTiposSeleccionarAsientoContableCajaChica(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsientoContableCajaChica(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLECAJACHICA);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLECAJACHICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
			reporte.setsDescripcion(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAsientoContableCajaChica(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachicaAux) throws Exception {
		
			asientocontablecajachicaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asientocontablecajachicaAux.getEmpresa()));
			asientocontablecajachicaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(asientocontablecajachicaAux.getSucursal()));
			asientocontablecajachicaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(asientocontablecajachicaAux.getEjercicio()));
			asientocontablecajachicaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(asientocontablecajachicaAux.getPeriodo()));
			asientocontablecajachicaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(asientocontablecajachicaAux.getUsuario()));
			asientocontablecajachicaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(asientocontablecajachicaAux.getAnio()));
			asientocontablecajachicaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(asientocontablecajachicaAux.getMes()));
			asientocontablecajachicaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(asientocontablecajachicaAux.getMoneda()));
			asientocontablecajachicaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(asientocontablecajachicaAux.getEmpleado()));
			asientocontablecajachicaAux.setestadoasientocontablecajachica_descripcion(EstadoAsientoContableCajaChicaConstantesFunciones.getEstadoAsientoContableCajaChicaDescripcion(asientocontablecajachicaAux.getEstadoAsientoContableCajaChica()));
			asientocontablecajachicaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(asientocontablecajachicaAux.getCliente()));
			asientocontablecajachicaAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(asientocontablecajachicaAux.getTransaccion()));
			asientocontablecajachicaAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(asientocontablecajachicaAux.getTipoDocumento()));
			asientocontablecajachicaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(asientocontablecajachicaAux.getCuentaContable()));
			asientocontablecajachicaAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(asientocontablecajachicaAux.getModulo()));
			asientocontablecajachicaAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(asientocontablecajachicaAux.getTipoMovimiento()));
			asientocontablecajachicaAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(asientocontablecajachicaAux.getTipoTransaccionModulo()));
			asientocontablecajachicaAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(asientocontablecajachicaAux.getTipoMovimientoModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAsientoContableCajaChica(List<AsientoContableCajaChica> asientocontablecajachicasTemp) throws Exception {
		for(AsientoContableCajaChica asientocontablecajachicaAux:asientocontablecajachicasTemp) {
			
			asientocontablecajachicaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asientocontablecajachicaAux.getEmpresa()));
			asientocontablecajachicaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(asientocontablecajachicaAux.getSucursal()));
			asientocontablecajachicaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(asientocontablecajachicaAux.getEjercicio()));
			asientocontablecajachicaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(asientocontablecajachicaAux.getPeriodo()));
			asientocontablecajachicaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(asientocontablecajachicaAux.getUsuario()));
			asientocontablecajachicaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(asientocontablecajachicaAux.getAnio()));
			asientocontablecajachicaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(asientocontablecajachicaAux.getMes()));
			asientocontablecajachicaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(asientocontablecajachicaAux.getMoneda()));
			asientocontablecajachicaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(asientocontablecajachicaAux.getEmpleado()));
			asientocontablecajachicaAux.setestadoasientocontablecajachica_descripcion(EstadoAsientoContableCajaChicaConstantesFunciones.getEstadoAsientoContableCajaChicaDescripcion(asientocontablecajachicaAux.getEstadoAsientoContableCajaChica()));
			asientocontablecajachicaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(asientocontablecajachicaAux.getCliente()));
			asientocontablecajachicaAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(asientocontablecajachicaAux.getTransaccion()));
			asientocontablecajachicaAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(asientocontablecajachicaAux.getTipoDocumento()));
			asientocontablecajachicaAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(asientocontablecajachicaAux.getCuentaContable()));
			asientocontablecajachicaAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(asientocontablecajachicaAux.getModulo()));
			asientocontablecajachicaAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(asientocontablecajachicaAux.getTipoMovimiento()));
			asientocontablecajachicaAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(asientocontablecajachicaAux.getTipoTransaccionModulo()));
			asientocontablecajachicaAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(asientocontablecajachicaAux.getTipoMovimientoModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(EstadoAsientoContableCajaChica.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(TipoMovimientoModulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoAsientoContableCajaChica.class)) {
						classes.add(new Classe(EstadoAsientoContableCajaChica.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimientoModulo.class)) {
						classes.add(new Classe(TipoMovimientoModulo.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EstadoAsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoAsientoContableCajaChica.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EstadoAsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoAsientoContableCajaChica.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(TipoMovimientoModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimientoModulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsOfAsientoContableCajaChica(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleAsientoContableCajaChica.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleAsientoContableCajaChica.class)) {
						classes.add(new Classe(DetalleAsientoContableCajaChica.class)); break;
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsFromStringsOfAsientoContableCajaChica(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleAsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAsientoContableCajaChica.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleAsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAsientoContableCajaChica.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(AsientoContableCajaChica asientocontablecajachica,List<AsientoContableCajaChica> asientocontablecajachicas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AsientoContableCajaChica asientocontablecajachicaEncontrado=null;
			
			for(AsientoContableCajaChica asientocontablecajachicaLocal:asientocontablecajachicas) {
				if(asientocontablecajachicaLocal.getId().equals(asientocontablecajachica.getId())) {
					asientocontablecajachicaEncontrado=asientocontablecajachicaLocal;
					
					asientocontablecajachicaLocal.setIsChanged(asientocontablecajachica.getIsChanged());
					asientocontablecajachicaLocal.setIsNew(asientocontablecajachica.getIsNew());
					asientocontablecajachicaLocal.setIsDeleted(asientocontablecajachica.getIsDeleted());
					
					asientocontablecajachicaLocal.setGeneralEntityOriginal(asientocontablecajachica.getGeneralEntityOriginal());
					
					asientocontablecajachicaLocal.setId(asientocontablecajachica.getId());	
					asientocontablecajachicaLocal.setVersionRow(asientocontablecajachica.getVersionRow());	
					asientocontablecajachicaLocal.setid_empresa(asientocontablecajachica.getid_empresa());	
					asientocontablecajachicaLocal.setid_sucursal(asientocontablecajachica.getid_sucursal());	
					asientocontablecajachicaLocal.setid_ejercicio(asientocontablecajachica.getid_ejercicio());	
					asientocontablecajachicaLocal.setid_periodo(asientocontablecajachica.getid_periodo());	
					asientocontablecajachicaLocal.setid_usuario(asientocontablecajachica.getid_usuario());	
					asientocontablecajachicaLocal.setid_anio(asientocontablecajachica.getid_anio());	
					asientocontablecajachicaLocal.setid_mes(asientocontablecajachica.getid_mes());	
					asientocontablecajachicaLocal.setsecuencial(asientocontablecajachica.getsecuencial());	
					asientocontablecajachicaLocal.setid_moneda(asientocontablecajachica.getid_moneda());	
					asientocontablecajachicaLocal.setfecha(asientocontablecajachica.getfecha());	
					asientocontablecajachicaLocal.setid_empleado(asientocontablecajachica.getid_empleado());	
					asientocontablecajachicaLocal.setid_estado_asiento_contable(asientocontablecajachica.getid_estado_asiento_contable());	
					asientocontablecajachicaLocal.setes_proveedor(asientocontablecajachica.getes_proveedor());	
					asientocontablecajachicaLocal.setid_cliente(asientocontablecajachica.getid_cliente());	
					asientocontablecajachicaLocal.setid_transaccion(asientocontablecajachica.getid_transaccion());	
					asientocontablecajachicaLocal.setid_tipo_documento(asientocontablecajachica.getid_tipo_documento());	
					asientocontablecajachicaLocal.setid_cuenta_contable(asientocontablecajachica.getid_cuenta_contable());	
					asientocontablecajachicaLocal.setdetalle(asientocontablecajachica.getdetalle());	
					asientocontablecajachicaLocal.setid_modulo(asientocontablecajachica.getid_modulo());	
					asientocontablecajachicaLocal.setid_tipo_movimiento(asientocontablecajachica.getid_tipo_movimiento());	
					asientocontablecajachicaLocal.setid_tipo_transaccion_modulo(asientocontablecajachica.getid_tipo_transaccion_modulo());	
					asientocontablecajachicaLocal.setid_tipo_movimiento_modulo(asientocontablecajachica.getid_tipo_movimiento_modulo());	
					
					
					asientocontablecajachicaLocal.setDetalleAsientoContableCajaChicas(asientocontablecajachica.getDetalleAsientoContableCajaChicas());
					
					existe=true;
					break;
				}
			}
			
			if(!asientocontablecajachica.getIsDeleted()) {
				if(!existe) {
					asientocontablecajachicas.add(asientocontablecajachica);
				}
			} else {
				if(asientocontablecajachicaEncontrado!=null && permiteQuitar)  {
					asientocontablecajachicas.remove(asientocontablecajachicaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AsientoContableCajaChica asientocontablecajachica,List<AsientoContableCajaChica> asientocontablecajachicas) throws Exception {
		try	{			
			for(AsientoContableCajaChica asientocontablecajachicaLocal:asientocontablecajachicas) {
				if(asientocontablecajachicaLocal.getId().equals(asientocontablecajachica.getId())) {
					asientocontablecajachicaLocal.setIsSelected(asientocontablecajachica.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAsientoContableCajaChica(List<AsientoContableCajaChica> asientocontablecajachicasAux) throws Exception {
		//this.asientocontablecajachicasAux=asientocontablecajachicasAux;
		
		for(AsientoContableCajaChica asientocontablecajachicaAux:asientocontablecajachicasAux) {
			if(asientocontablecajachicaAux.getIsChanged()) {
				asientocontablecajachicaAux.setIsChanged(false);
			}		
			
			if(asientocontablecajachicaAux.getIsNew()) {
				asientocontablecajachicaAux.setIsNew(false);
			}	
			
			if(asientocontablecajachicaAux.getIsDeleted()) {
				asientocontablecajachicaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachicaAux) throws Exception {
		//this.asientocontablecajachicaAux=asientocontablecajachicaAux;
		
			if(asientocontablecajachicaAux.getIsChanged()) {
				asientocontablecajachicaAux.setIsChanged(false);
			}		
			
			if(asientocontablecajachicaAux.getIsNew()) {
				asientocontablecajachicaAux.setIsNew(false);
			}	
			
			if(asientocontablecajachicaAux.getIsDeleted()) {
				asientocontablecajachicaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AsientoContableCajaChica asientocontablecajachicaAsignar,AsientoContableCajaChica asientocontablecajachica) throws Exception {
		asientocontablecajachicaAsignar.setId(asientocontablecajachica.getId());	
		asientocontablecajachicaAsignar.setVersionRow(asientocontablecajachica.getVersionRow());	
		asientocontablecajachicaAsignar.setid_empresa(asientocontablecajachica.getid_empresa());
		asientocontablecajachicaAsignar.setempresa_descripcion(asientocontablecajachica.getempresa_descripcion());	
		asientocontablecajachicaAsignar.setid_sucursal(asientocontablecajachica.getid_sucursal());
		asientocontablecajachicaAsignar.setsucursal_descripcion(asientocontablecajachica.getsucursal_descripcion());	
		asientocontablecajachicaAsignar.setid_ejercicio(asientocontablecajachica.getid_ejercicio());
		asientocontablecajachicaAsignar.setejercicio_descripcion(asientocontablecajachica.getejercicio_descripcion());	
		asientocontablecajachicaAsignar.setid_periodo(asientocontablecajachica.getid_periodo());
		asientocontablecajachicaAsignar.setperiodo_descripcion(asientocontablecajachica.getperiodo_descripcion());	
		asientocontablecajachicaAsignar.setid_usuario(asientocontablecajachica.getid_usuario());
		asientocontablecajachicaAsignar.setusuario_descripcion(asientocontablecajachica.getusuario_descripcion());	
		asientocontablecajachicaAsignar.setid_anio(asientocontablecajachica.getid_anio());
		asientocontablecajachicaAsignar.setanio_descripcion(asientocontablecajachica.getanio_descripcion());	
		asientocontablecajachicaAsignar.setid_mes(asientocontablecajachica.getid_mes());
		asientocontablecajachicaAsignar.setmes_descripcion(asientocontablecajachica.getmes_descripcion());	
		asientocontablecajachicaAsignar.setsecuencial(asientocontablecajachica.getsecuencial());	
		asientocontablecajachicaAsignar.setid_moneda(asientocontablecajachica.getid_moneda());
		asientocontablecajachicaAsignar.setmoneda_descripcion(asientocontablecajachica.getmoneda_descripcion());	
		asientocontablecajachicaAsignar.setfecha(asientocontablecajachica.getfecha());	
		asientocontablecajachicaAsignar.setid_empleado(asientocontablecajachica.getid_empleado());
		asientocontablecajachicaAsignar.setempleado_descripcion(asientocontablecajachica.getempleado_descripcion());	
		asientocontablecajachicaAsignar.setid_estado_asiento_contable(asientocontablecajachica.getid_estado_asiento_contable());
		asientocontablecajachicaAsignar.setestadoasientocontablecajachica_descripcion(asientocontablecajachica.getestadoasientocontablecajachica_descripcion());	
		asientocontablecajachicaAsignar.setes_proveedor(asientocontablecajachica.getes_proveedor());	
		asientocontablecajachicaAsignar.setid_cliente(asientocontablecajachica.getid_cliente());
		asientocontablecajachicaAsignar.setcliente_descripcion(asientocontablecajachica.getcliente_descripcion());	
		asientocontablecajachicaAsignar.setid_transaccion(asientocontablecajachica.getid_transaccion());
		asientocontablecajachicaAsignar.settransaccion_descripcion(asientocontablecajachica.gettransaccion_descripcion());	
		asientocontablecajachicaAsignar.setid_tipo_documento(asientocontablecajachica.getid_tipo_documento());
		asientocontablecajachicaAsignar.settipodocumento_descripcion(asientocontablecajachica.gettipodocumento_descripcion());	
		asientocontablecajachicaAsignar.setid_cuenta_contable(asientocontablecajachica.getid_cuenta_contable());
		asientocontablecajachicaAsignar.setcuentacontable_descripcion(asientocontablecajachica.getcuentacontable_descripcion());	
		asientocontablecajachicaAsignar.setdetalle(asientocontablecajachica.getdetalle());	
		asientocontablecajachicaAsignar.setid_modulo(asientocontablecajachica.getid_modulo());
		asientocontablecajachicaAsignar.setmodulo_descripcion(asientocontablecajachica.getmodulo_descripcion());	
		asientocontablecajachicaAsignar.setid_tipo_movimiento(asientocontablecajachica.getid_tipo_movimiento());
		asientocontablecajachicaAsignar.settipomovimiento_descripcion(asientocontablecajachica.gettipomovimiento_descripcion());	
		asientocontablecajachicaAsignar.setid_tipo_transaccion_modulo(asientocontablecajachica.getid_tipo_transaccion_modulo());
		asientocontablecajachicaAsignar.settipotransaccionmodulo_descripcion(asientocontablecajachica.gettipotransaccionmodulo_descripcion());	
		asientocontablecajachicaAsignar.setid_tipo_movimiento_modulo(asientocontablecajachica.getid_tipo_movimiento_modulo());
		asientocontablecajachicaAsignar.settipomovimientomodulo_descripcion(asientocontablecajachica.gettipomovimientomodulo_descripcion());	
	}
	
	public static void inicializarAsientoContableCajaChica(AsientoContableCajaChica asientocontablecajachica) throws Exception {
		try {
				asientocontablecajachica.setId(0L);	
					
				asientocontablecajachica.setid_empresa(-1L);	
				asientocontablecajachica.setid_sucursal(-1L);	
				asientocontablecajachica.setid_ejercicio(-1L);	
				asientocontablecajachica.setid_periodo(-1L);	
				asientocontablecajachica.setid_usuario(-1L);	
				asientocontablecajachica.setid_anio(null);	
				asientocontablecajachica.setid_mes(null);	
				asientocontablecajachica.setsecuencial(0L);	
				asientocontablecajachica.setid_moneda(-1L);	
				asientocontablecajachica.setfecha(new Date());	
				asientocontablecajachica.setid_empleado(-1L);	
				asientocontablecajachica.setid_estado_asiento_contable(-1L);	
				asientocontablecajachica.setes_proveedor(false);	
				asientocontablecajachica.setid_cliente(-1L);	
				asientocontablecajachica.setid_transaccion(-1L);	
				asientocontablecajachica.setid_tipo_documento(-1L);	
				asientocontablecajachica.setid_cuenta_contable(-1L);	
				asientocontablecajachica.setdetalle("");	
				asientocontablecajachica.setid_modulo(-1L);	
				asientocontablecajachica.setid_tipo_movimiento(-1L);	
				asientocontablecajachica.setid_tipo_transaccion_modulo(null);	
				asientocontablecajachica.setid_tipo_movimiento_modulo(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAsientoContableCajaChica(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLECAJACHICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAsientoContableCajaChica(String sTipo,Row row,Workbook workbook,AsientoContableCajaChica asientocontablecajachica,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getestadoasientocontablecajachica_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(asientocontablecajachica.getes_proveedor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontablecajachica.gettipomovimientomodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAsientoContableCajaChica=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAsientoContableCajaChica() {
		return this.sFinalQueryAsientoContableCajaChica;
	}
	
	public void setsFinalQueryAsientoContableCajaChica(String sFinalQueryAsientoContableCajaChica) {
		this.sFinalQueryAsientoContableCajaChica= sFinalQueryAsientoContableCajaChica;
	}
	
	public Border resaltarSeleccionarAsientoContableCajaChica=null;
	
	public Border setResaltarSeleccionarAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAsientoContableCajaChica= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAsientoContableCajaChica() {
		return this.resaltarSeleccionarAsientoContableCajaChica;
	}
	
	public void setResaltarSeleccionarAsientoContableCajaChica(Border borderResaltarSeleccionarAsientoContableCajaChica) {
		this.resaltarSeleccionarAsientoContableCajaChica= borderResaltarSeleccionarAsientoContableCajaChica;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAsientoContableCajaChica=null;
	public Boolean mostraridAsientoContableCajaChica=true;
	public Boolean activaridAsientoContableCajaChica=true;

	public Border resaltarid_empresaAsientoContableCajaChica=null;
	public Boolean mostrarid_empresaAsientoContableCajaChica=true;
	public Boolean activarid_empresaAsientoContableCajaChica=true;
	public Boolean cargarid_empresaAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_sucursalAsientoContableCajaChica=null;
	public Boolean mostrarid_sucursalAsientoContableCajaChica=true;
	public Boolean activarid_sucursalAsientoContableCajaChica=true;
	public Boolean cargarid_sucursalAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_ejercicioAsientoContableCajaChica=null;
	public Boolean mostrarid_ejercicioAsientoContableCajaChica=true;
	public Boolean activarid_ejercicioAsientoContableCajaChica=true;
	public Boolean cargarid_ejercicioAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_periodoAsientoContableCajaChica=null;
	public Boolean mostrarid_periodoAsientoContableCajaChica=true;
	public Boolean activarid_periodoAsientoContableCajaChica=true;
	public Boolean cargarid_periodoAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_usuarioAsientoContableCajaChica=null;
	public Boolean mostrarid_usuarioAsientoContableCajaChica=true;
	public Boolean activarid_usuarioAsientoContableCajaChica=true;
	public Boolean cargarid_usuarioAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_anioAsientoContableCajaChica=null;
	public Boolean mostrarid_anioAsientoContableCajaChica=true;
	public Boolean activarid_anioAsientoContableCajaChica=false;
	public Boolean cargarid_anioAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_mesAsientoContableCajaChica=null;
	public Boolean mostrarid_mesAsientoContableCajaChica=true;
	public Boolean activarid_mesAsientoContableCajaChica=false;
	public Boolean cargarid_mesAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarsecuencialAsientoContableCajaChica=null;
	public Boolean mostrarsecuencialAsientoContableCajaChica=true;
	public Boolean activarsecuencialAsientoContableCajaChica=true;

	public Border resaltarid_monedaAsientoContableCajaChica=null;
	public Boolean mostrarid_monedaAsientoContableCajaChica=true;
	public Boolean activarid_monedaAsientoContableCajaChica=true;
	public Boolean cargarid_monedaAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarfechaAsientoContableCajaChica=null;
	public Boolean mostrarfechaAsientoContableCajaChica=true;
	public Boolean activarfechaAsientoContableCajaChica=true;

	public Border resaltarid_empleadoAsientoContableCajaChica=null;
	public Boolean mostrarid_empleadoAsientoContableCajaChica=true;
	public Boolean activarid_empleadoAsientoContableCajaChica=true;
	public Boolean cargarid_empleadoAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_estado_asiento_contableAsientoContableCajaChica=null;
	public Boolean mostrarid_estado_asiento_contableAsientoContableCajaChica=true;
	public Boolean activarid_estado_asiento_contableAsientoContableCajaChica=true;
	public Boolean cargarid_estado_asiento_contableAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_asiento_contableAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltares_proveedorAsientoContableCajaChica=null;
	public Boolean mostrares_proveedorAsientoContableCajaChica=true;
	public Boolean activares_proveedorAsientoContableCajaChica=true;

	public Border resaltarid_clienteAsientoContableCajaChica=null;
	public Boolean mostrarid_clienteAsientoContableCajaChica=true;
	public Boolean activarid_clienteAsientoContableCajaChica=true;
	public Boolean cargarid_clienteAsientoContableCajaChica=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_transaccionAsientoContableCajaChica=null;
	public Boolean mostrarid_transaccionAsientoContableCajaChica=true;
	public Boolean activarid_transaccionAsientoContableCajaChica=true;
	public Boolean cargarid_transaccionAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_tipo_documentoAsientoContableCajaChica=null;
	public Boolean mostrarid_tipo_documentoAsientoContableCajaChica=true;
	public Boolean activarid_tipo_documentoAsientoContableCajaChica=true;
	public Boolean cargarid_tipo_documentoAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableAsientoContableCajaChica=null;
	public Boolean mostrarid_cuenta_contableAsientoContableCajaChica=true;
	public Boolean activarid_cuenta_contableAsientoContableCajaChica=true;
	public Boolean cargarid_cuenta_contableAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltardetalleAsientoContableCajaChica=null;
	public Boolean mostrardetalleAsientoContableCajaChica=true;
	public Boolean activardetalleAsientoContableCajaChica=true;

	public Border resaltarid_moduloAsientoContableCajaChica=null;
	public Boolean mostrarid_moduloAsientoContableCajaChica=true;
	public Boolean activarid_moduloAsientoContableCajaChica=true;
	public Boolean cargarid_moduloAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoAsientoContableCajaChica=null;
	public Boolean mostrarid_tipo_movimientoAsientoContableCajaChica=true;
	public Boolean activarid_tipo_movimientoAsientoContableCajaChica=false;
	public Boolean cargarid_tipo_movimientoAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloAsientoContableCajaChica=null;
	public Boolean mostrarid_tipo_transaccion_moduloAsientoContableCajaChica=true;
	public Boolean activarid_tipo_transaccion_moduloAsientoContableCajaChica=false;
	public Boolean cargarid_tipo_transaccion_moduloAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimiento_moduloAsientoContableCajaChica=null;
	public Boolean mostrarid_tipo_movimiento_moduloAsientoContableCajaChica=true;
	public Boolean activarid_tipo_movimiento_moduloAsientoContableCajaChica=false;
	public Boolean cargarid_tipo_movimiento_moduloAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimiento_moduloAsientoContableCajaChica=false;//ConEventDepend=true

	
	

	public Border setResaltaridAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltaridAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAsientoContableCajaChica() {
		return this.resaltaridAsientoContableCajaChica;
	}

	public void setResaltaridAsientoContableCajaChica(Border borderResaltar) {
		this.resaltaridAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostraridAsientoContableCajaChica() {
		return this.mostraridAsientoContableCajaChica;
	}

	public void setMostraridAsientoContableCajaChica(Boolean mostraridAsientoContableCajaChica) {
		this.mostraridAsientoContableCajaChica= mostraridAsientoContableCajaChica;
	}

	public Boolean getActivaridAsientoContableCajaChica() {
		return this.activaridAsientoContableCajaChica;
	}

	public void setActivaridAsientoContableCajaChica(Boolean activaridAsientoContableCajaChica) {
		this.activaridAsientoContableCajaChica= activaridAsientoContableCajaChica;
	}

	public Border setResaltarid_empresaAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_empresaAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAsientoContableCajaChica() {
		return this.resaltarid_empresaAsientoContableCajaChica;
	}

	public void setResaltarid_empresaAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_empresaAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_empresaAsientoContableCajaChica() {
		return this.mostrarid_empresaAsientoContableCajaChica;
	}

	public void setMostrarid_empresaAsientoContableCajaChica(Boolean mostrarid_empresaAsientoContableCajaChica) {
		this.mostrarid_empresaAsientoContableCajaChica= mostrarid_empresaAsientoContableCajaChica;
	}

	public Boolean getActivarid_empresaAsientoContableCajaChica() {
		return this.activarid_empresaAsientoContableCajaChica;
	}

	public void setActivarid_empresaAsientoContableCajaChica(Boolean activarid_empresaAsientoContableCajaChica) {
		this.activarid_empresaAsientoContableCajaChica= activarid_empresaAsientoContableCajaChica;
	}

	public Boolean getCargarid_empresaAsientoContableCajaChica() {
		return this.cargarid_empresaAsientoContableCajaChica;
	}

	public void setCargarid_empresaAsientoContableCajaChica(Boolean cargarid_empresaAsientoContableCajaChica) {
		this.cargarid_empresaAsientoContableCajaChica= cargarid_empresaAsientoContableCajaChica;
	}

	public Border setResaltarid_sucursalAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAsientoContableCajaChica() {
		return this.resaltarid_sucursalAsientoContableCajaChica;
	}

	public void setResaltarid_sucursalAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_sucursalAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAsientoContableCajaChica() {
		return this.mostrarid_sucursalAsientoContableCajaChica;
	}

	public void setMostrarid_sucursalAsientoContableCajaChica(Boolean mostrarid_sucursalAsientoContableCajaChica) {
		this.mostrarid_sucursalAsientoContableCajaChica= mostrarid_sucursalAsientoContableCajaChica;
	}

	public Boolean getActivarid_sucursalAsientoContableCajaChica() {
		return this.activarid_sucursalAsientoContableCajaChica;
	}

	public void setActivarid_sucursalAsientoContableCajaChica(Boolean activarid_sucursalAsientoContableCajaChica) {
		this.activarid_sucursalAsientoContableCajaChica= activarid_sucursalAsientoContableCajaChica;
	}

	public Boolean getCargarid_sucursalAsientoContableCajaChica() {
		return this.cargarid_sucursalAsientoContableCajaChica;
	}

	public void setCargarid_sucursalAsientoContableCajaChica(Boolean cargarid_sucursalAsientoContableCajaChica) {
		this.cargarid_sucursalAsientoContableCajaChica= cargarid_sucursalAsientoContableCajaChica;
	}

	public Border setResaltarid_ejercicioAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioAsientoContableCajaChica() {
		return this.resaltarid_ejercicioAsientoContableCajaChica;
	}

	public void setResaltarid_ejercicioAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_ejercicioAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioAsientoContableCajaChica() {
		return this.mostrarid_ejercicioAsientoContableCajaChica;
	}

	public void setMostrarid_ejercicioAsientoContableCajaChica(Boolean mostrarid_ejercicioAsientoContableCajaChica) {
		this.mostrarid_ejercicioAsientoContableCajaChica= mostrarid_ejercicioAsientoContableCajaChica;
	}

	public Boolean getActivarid_ejercicioAsientoContableCajaChica() {
		return this.activarid_ejercicioAsientoContableCajaChica;
	}

	public void setActivarid_ejercicioAsientoContableCajaChica(Boolean activarid_ejercicioAsientoContableCajaChica) {
		this.activarid_ejercicioAsientoContableCajaChica= activarid_ejercicioAsientoContableCajaChica;
	}

	public Boolean getCargarid_ejercicioAsientoContableCajaChica() {
		return this.cargarid_ejercicioAsientoContableCajaChica;
	}

	public void setCargarid_ejercicioAsientoContableCajaChica(Boolean cargarid_ejercicioAsientoContableCajaChica) {
		this.cargarid_ejercicioAsientoContableCajaChica= cargarid_ejercicioAsientoContableCajaChica;
	}

	public Border setResaltarid_periodoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_periodoAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoAsientoContableCajaChica() {
		return this.resaltarid_periodoAsientoContableCajaChica;
	}

	public void setResaltarid_periodoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_periodoAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_periodoAsientoContableCajaChica() {
		return this.mostrarid_periodoAsientoContableCajaChica;
	}

	public void setMostrarid_periodoAsientoContableCajaChica(Boolean mostrarid_periodoAsientoContableCajaChica) {
		this.mostrarid_periodoAsientoContableCajaChica= mostrarid_periodoAsientoContableCajaChica;
	}

	public Boolean getActivarid_periodoAsientoContableCajaChica() {
		return this.activarid_periodoAsientoContableCajaChica;
	}

	public void setActivarid_periodoAsientoContableCajaChica(Boolean activarid_periodoAsientoContableCajaChica) {
		this.activarid_periodoAsientoContableCajaChica= activarid_periodoAsientoContableCajaChica;
	}

	public Boolean getCargarid_periodoAsientoContableCajaChica() {
		return this.cargarid_periodoAsientoContableCajaChica;
	}

	public void setCargarid_periodoAsientoContableCajaChica(Boolean cargarid_periodoAsientoContableCajaChica) {
		this.cargarid_periodoAsientoContableCajaChica= cargarid_periodoAsientoContableCajaChica;
	}

	public Border setResaltarid_usuarioAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_usuarioAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioAsientoContableCajaChica() {
		return this.resaltarid_usuarioAsientoContableCajaChica;
	}

	public void setResaltarid_usuarioAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_usuarioAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_usuarioAsientoContableCajaChica() {
		return this.mostrarid_usuarioAsientoContableCajaChica;
	}

	public void setMostrarid_usuarioAsientoContableCajaChica(Boolean mostrarid_usuarioAsientoContableCajaChica) {
		this.mostrarid_usuarioAsientoContableCajaChica= mostrarid_usuarioAsientoContableCajaChica;
	}

	public Boolean getActivarid_usuarioAsientoContableCajaChica() {
		return this.activarid_usuarioAsientoContableCajaChica;
	}

	public void setActivarid_usuarioAsientoContableCajaChica(Boolean activarid_usuarioAsientoContableCajaChica) {
		this.activarid_usuarioAsientoContableCajaChica= activarid_usuarioAsientoContableCajaChica;
	}

	public Boolean getCargarid_usuarioAsientoContableCajaChica() {
		return this.cargarid_usuarioAsientoContableCajaChica;
	}

	public void setCargarid_usuarioAsientoContableCajaChica(Boolean cargarid_usuarioAsientoContableCajaChica) {
		this.cargarid_usuarioAsientoContableCajaChica= cargarid_usuarioAsientoContableCajaChica;
	}

	public Border setResaltarid_anioAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_anioAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioAsientoContableCajaChica() {
		return this.resaltarid_anioAsientoContableCajaChica;
	}

	public void setResaltarid_anioAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_anioAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_anioAsientoContableCajaChica() {
		return this.mostrarid_anioAsientoContableCajaChica;
	}

	public void setMostrarid_anioAsientoContableCajaChica(Boolean mostrarid_anioAsientoContableCajaChica) {
		this.mostrarid_anioAsientoContableCajaChica= mostrarid_anioAsientoContableCajaChica;
	}

	public Boolean getActivarid_anioAsientoContableCajaChica() {
		return this.activarid_anioAsientoContableCajaChica;
	}

	public void setActivarid_anioAsientoContableCajaChica(Boolean activarid_anioAsientoContableCajaChica) {
		this.activarid_anioAsientoContableCajaChica= activarid_anioAsientoContableCajaChica;
	}

	public Boolean getCargarid_anioAsientoContableCajaChica() {
		return this.cargarid_anioAsientoContableCajaChica;
	}

	public void setCargarid_anioAsientoContableCajaChica(Boolean cargarid_anioAsientoContableCajaChica) {
		this.cargarid_anioAsientoContableCajaChica= cargarid_anioAsientoContableCajaChica;
	}

	public Border setResaltarid_mesAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_mesAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesAsientoContableCajaChica() {
		return this.resaltarid_mesAsientoContableCajaChica;
	}

	public void setResaltarid_mesAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_mesAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_mesAsientoContableCajaChica() {
		return this.mostrarid_mesAsientoContableCajaChica;
	}

	public void setMostrarid_mesAsientoContableCajaChica(Boolean mostrarid_mesAsientoContableCajaChica) {
		this.mostrarid_mesAsientoContableCajaChica= mostrarid_mesAsientoContableCajaChica;
	}

	public Boolean getActivarid_mesAsientoContableCajaChica() {
		return this.activarid_mesAsientoContableCajaChica;
	}

	public void setActivarid_mesAsientoContableCajaChica(Boolean activarid_mesAsientoContableCajaChica) {
		this.activarid_mesAsientoContableCajaChica= activarid_mesAsientoContableCajaChica;
	}

	public Boolean getCargarid_mesAsientoContableCajaChica() {
		return this.cargarid_mesAsientoContableCajaChica;
	}

	public void setCargarid_mesAsientoContableCajaChica(Boolean cargarid_mesAsientoContableCajaChica) {
		this.cargarid_mesAsientoContableCajaChica= cargarid_mesAsientoContableCajaChica;
	}

	public Border setResaltarsecuencialAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarsecuencialAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialAsientoContableCajaChica() {
		return this.resaltarsecuencialAsientoContableCajaChica;
	}

	public void setResaltarsecuencialAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarsecuencialAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarsecuencialAsientoContableCajaChica() {
		return this.mostrarsecuencialAsientoContableCajaChica;
	}

	public void setMostrarsecuencialAsientoContableCajaChica(Boolean mostrarsecuencialAsientoContableCajaChica) {
		this.mostrarsecuencialAsientoContableCajaChica= mostrarsecuencialAsientoContableCajaChica;
	}

	public Boolean getActivarsecuencialAsientoContableCajaChica() {
		return this.activarsecuencialAsientoContableCajaChica;
	}

	public void setActivarsecuencialAsientoContableCajaChica(Boolean activarsecuencialAsientoContableCajaChica) {
		this.activarsecuencialAsientoContableCajaChica= activarsecuencialAsientoContableCajaChica;
	}

	public Border setResaltarid_monedaAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_monedaAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaAsientoContableCajaChica() {
		return this.resaltarid_monedaAsientoContableCajaChica;
	}

	public void setResaltarid_monedaAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_monedaAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_monedaAsientoContableCajaChica() {
		return this.mostrarid_monedaAsientoContableCajaChica;
	}

	public void setMostrarid_monedaAsientoContableCajaChica(Boolean mostrarid_monedaAsientoContableCajaChica) {
		this.mostrarid_monedaAsientoContableCajaChica= mostrarid_monedaAsientoContableCajaChica;
	}

	public Boolean getActivarid_monedaAsientoContableCajaChica() {
		return this.activarid_monedaAsientoContableCajaChica;
	}

	public void setActivarid_monedaAsientoContableCajaChica(Boolean activarid_monedaAsientoContableCajaChica) {
		this.activarid_monedaAsientoContableCajaChica= activarid_monedaAsientoContableCajaChica;
	}

	public Boolean getCargarid_monedaAsientoContableCajaChica() {
		return this.cargarid_monedaAsientoContableCajaChica;
	}

	public void setCargarid_monedaAsientoContableCajaChica(Boolean cargarid_monedaAsientoContableCajaChica) {
		this.cargarid_monedaAsientoContableCajaChica= cargarid_monedaAsientoContableCajaChica;
	}

	public Border setResaltarfechaAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarfechaAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAsientoContableCajaChica() {
		return this.resaltarfechaAsientoContableCajaChica;
	}

	public void setResaltarfechaAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarfechaAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarfechaAsientoContableCajaChica() {
		return this.mostrarfechaAsientoContableCajaChica;
	}

	public void setMostrarfechaAsientoContableCajaChica(Boolean mostrarfechaAsientoContableCajaChica) {
		this.mostrarfechaAsientoContableCajaChica= mostrarfechaAsientoContableCajaChica;
	}

	public Boolean getActivarfechaAsientoContableCajaChica() {
		return this.activarfechaAsientoContableCajaChica;
	}

	public void setActivarfechaAsientoContableCajaChica(Boolean activarfechaAsientoContableCajaChica) {
		this.activarfechaAsientoContableCajaChica= activarfechaAsientoContableCajaChica;
	}

	public Border setResaltarid_empleadoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_empleadoAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoAsientoContableCajaChica() {
		return this.resaltarid_empleadoAsientoContableCajaChica;
	}

	public void setResaltarid_empleadoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_empleadoAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_empleadoAsientoContableCajaChica() {
		return this.mostrarid_empleadoAsientoContableCajaChica;
	}

	public void setMostrarid_empleadoAsientoContableCajaChica(Boolean mostrarid_empleadoAsientoContableCajaChica) {
		this.mostrarid_empleadoAsientoContableCajaChica= mostrarid_empleadoAsientoContableCajaChica;
	}

	public Boolean getActivarid_empleadoAsientoContableCajaChica() {
		return this.activarid_empleadoAsientoContableCajaChica;
	}

	public void setActivarid_empleadoAsientoContableCajaChica(Boolean activarid_empleadoAsientoContableCajaChica) {
		this.activarid_empleadoAsientoContableCajaChica= activarid_empleadoAsientoContableCajaChica;
	}

	public Boolean getCargarid_empleadoAsientoContableCajaChica() {
		return this.cargarid_empleadoAsientoContableCajaChica;
	}

	public void setCargarid_empleadoAsientoContableCajaChica(Boolean cargarid_empleadoAsientoContableCajaChica) {
		this.cargarid_empleadoAsientoContableCajaChica= cargarid_empleadoAsientoContableCajaChica;
	}

	public Border setResaltarid_estado_asiento_contableAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_estado_asiento_contableAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_asiento_contableAsientoContableCajaChica() {
		return this.resaltarid_estado_asiento_contableAsientoContableCajaChica;
	}

	public void setResaltarid_estado_asiento_contableAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_estado_asiento_contableAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_estado_asiento_contableAsientoContableCajaChica() {
		return this.mostrarid_estado_asiento_contableAsientoContableCajaChica;
	}

	public void setMostrarid_estado_asiento_contableAsientoContableCajaChica(Boolean mostrarid_estado_asiento_contableAsientoContableCajaChica) {
		this.mostrarid_estado_asiento_contableAsientoContableCajaChica= mostrarid_estado_asiento_contableAsientoContableCajaChica;
	}

	public Boolean getActivarid_estado_asiento_contableAsientoContableCajaChica() {
		return this.activarid_estado_asiento_contableAsientoContableCajaChica;
	}

	public void setActivarid_estado_asiento_contableAsientoContableCajaChica(Boolean activarid_estado_asiento_contableAsientoContableCajaChica) {
		this.activarid_estado_asiento_contableAsientoContableCajaChica= activarid_estado_asiento_contableAsientoContableCajaChica;
	}

	public Boolean getCargarid_estado_asiento_contableAsientoContableCajaChica() {
		return this.cargarid_estado_asiento_contableAsientoContableCajaChica;
	}

	public void setCargarid_estado_asiento_contableAsientoContableCajaChica(Boolean cargarid_estado_asiento_contableAsientoContableCajaChica) {
		this.cargarid_estado_asiento_contableAsientoContableCajaChica= cargarid_estado_asiento_contableAsientoContableCajaChica;
	}

	public Border setResaltares_proveedorAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltares_proveedorAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_proveedorAsientoContableCajaChica() {
		return this.resaltares_proveedorAsientoContableCajaChica;
	}

	public void setResaltares_proveedorAsientoContableCajaChica(Border borderResaltar) {
		this.resaltares_proveedorAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrares_proveedorAsientoContableCajaChica() {
		return this.mostrares_proveedorAsientoContableCajaChica;
	}

	public void setMostrares_proveedorAsientoContableCajaChica(Boolean mostrares_proveedorAsientoContableCajaChica) {
		this.mostrares_proveedorAsientoContableCajaChica= mostrares_proveedorAsientoContableCajaChica;
	}

	public Boolean getActivares_proveedorAsientoContableCajaChica() {
		return this.activares_proveedorAsientoContableCajaChica;
	}

	public void setActivares_proveedorAsientoContableCajaChica(Boolean activares_proveedorAsientoContableCajaChica) {
		this.activares_proveedorAsientoContableCajaChica= activares_proveedorAsientoContableCajaChica;
	}

	public Border setResaltarid_clienteAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_clienteAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteAsientoContableCajaChica() {
		return this.resaltarid_clienteAsientoContableCajaChica;
	}

	public void setResaltarid_clienteAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_clienteAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_clienteAsientoContableCajaChica() {
		return this.mostrarid_clienteAsientoContableCajaChica;
	}

	public void setMostrarid_clienteAsientoContableCajaChica(Boolean mostrarid_clienteAsientoContableCajaChica) {
		this.mostrarid_clienteAsientoContableCajaChica= mostrarid_clienteAsientoContableCajaChica;
	}

	public Boolean getActivarid_clienteAsientoContableCajaChica() {
		return this.activarid_clienteAsientoContableCajaChica;
	}

	public void setActivarid_clienteAsientoContableCajaChica(Boolean activarid_clienteAsientoContableCajaChica) {
		this.activarid_clienteAsientoContableCajaChica= activarid_clienteAsientoContableCajaChica;
	}

	public Boolean getCargarid_clienteAsientoContableCajaChica() {
		return this.cargarid_clienteAsientoContableCajaChica;
	}

	public void setCargarid_clienteAsientoContableCajaChica(Boolean cargarid_clienteAsientoContableCajaChica) {
		this.cargarid_clienteAsientoContableCajaChica= cargarid_clienteAsientoContableCajaChica;
	}

	public Border setResaltarid_transaccionAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_transaccionAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionAsientoContableCajaChica() {
		return this.resaltarid_transaccionAsientoContableCajaChica;
	}

	public void setResaltarid_transaccionAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_transaccionAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_transaccionAsientoContableCajaChica() {
		return this.mostrarid_transaccionAsientoContableCajaChica;
	}

	public void setMostrarid_transaccionAsientoContableCajaChica(Boolean mostrarid_transaccionAsientoContableCajaChica) {
		this.mostrarid_transaccionAsientoContableCajaChica= mostrarid_transaccionAsientoContableCajaChica;
	}

	public Boolean getActivarid_transaccionAsientoContableCajaChica() {
		return this.activarid_transaccionAsientoContableCajaChica;
	}

	public void setActivarid_transaccionAsientoContableCajaChica(Boolean activarid_transaccionAsientoContableCajaChica) {
		this.activarid_transaccionAsientoContableCajaChica= activarid_transaccionAsientoContableCajaChica;
	}

	public Boolean getCargarid_transaccionAsientoContableCajaChica() {
		return this.cargarid_transaccionAsientoContableCajaChica;
	}

	public void setCargarid_transaccionAsientoContableCajaChica(Boolean cargarid_transaccionAsientoContableCajaChica) {
		this.cargarid_transaccionAsientoContableCajaChica= cargarid_transaccionAsientoContableCajaChica;
	}

	public Border setResaltarid_tipo_documentoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoAsientoContableCajaChica() {
		return this.resaltarid_tipo_documentoAsientoContableCajaChica;
	}

	public void setResaltarid_tipo_documentoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_tipo_documentoAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoAsientoContableCajaChica() {
		return this.mostrarid_tipo_documentoAsientoContableCajaChica;
	}

	public void setMostrarid_tipo_documentoAsientoContableCajaChica(Boolean mostrarid_tipo_documentoAsientoContableCajaChica) {
		this.mostrarid_tipo_documentoAsientoContableCajaChica= mostrarid_tipo_documentoAsientoContableCajaChica;
	}

	public Boolean getActivarid_tipo_documentoAsientoContableCajaChica() {
		return this.activarid_tipo_documentoAsientoContableCajaChica;
	}

	public void setActivarid_tipo_documentoAsientoContableCajaChica(Boolean activarid_tipo_documentoAsientoContableCajaChica) {
		this.activarid_tipo_documentoAsientoContableCajaChica= activarid_tipo_documentoAsientoContableCajaChica;
	}

	public Boolean getCargarid_tipo_documentoAsientoContableCajaChica() {
		return this.cargarid_tipo_documentoAsientoContableCajaChica;
	}

	public void setCargarid_tipo_documentoAsientoContableCajaChica(Boolean cargarid_tipo_documentoAsientoContableCajaChica) {
		this.cargarid_tipo_documentoAsientoContableCajaChica= cargarid_tipo_documentoAsientoContableCajaChica;
	}

	public Border setResaltarid_cuenta_contableAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableAsientoContableCajaChica() {
		return this.resaltarid_cuenta_contableAsientoContableCajaChica;
	}

	public void setResaltarid_cuenta_contableAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_cuenta_contableAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableAsientoContableCajaChica() {
		return this.mostrarid_cuenta_contableAsientoContableCajaChica;
	}

	public void setMostrarid_cuenta_contableAsientoContableCajaChica(Boolean mostrarid_cuenta_contableAsientoContableCajaChica) {
		this.mostrarid_cuenta_contableAsientoContableCajaChica= mostrarid_cuenta_contableAsientoContableCajaChica;
	}

	public Boolean getActivarid_cuenta_contableAsientoContableCajaChica() {
		return this.activarid_cuenta_contableAsientoContableCajaChica;
	}

	public void setActivarid_cuenta_contableAsientoContableCajaChica(Boolean activarid_cuenta_contableAsientoContableCajaChica) {
		this.activarid_cuenta_contableAsientoContableCajaChica= activarid_cuenta_contableAsientoContableCajaChica;
	}

	public Boolean getCargarid_cuenta_contableAsientoContableCajaChica() {
		return this.cargarid_cuenta_contableAsientoContableCajaChica;
	}

	public void setCargarid_cuenta_contableAsientoContableCajaChica(Boolean cargarid_cuenta_contableAsientoContableCajaChica) {
		this.cargarid_cuenta_contableAsientoContableCajaChica= cargarid_cuenta_contableAsientoContableCajaChica;
	}

	public Border setResaltardetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltardetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleAsientoContableCajaChica() {
		return this.resaltardetalleAsientoContableCajaChica;
	}

	public void setResaltardetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltardetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrardetalleAsientoContableCajaChica() {
		return this.mostrardetalleAsientoContableCajaChica;
	}

	public void setMostrardetalleAsientoContableCajaChica(Boolean mostrardetalleAsientoContableCajaChica) {
		this.mostrardetalleAsientoContableCajaChica= mostrardetalleAsientoContableCajaChica;
	}

	public Boolean getActivardetalleAsientoContableCajaChica() {
		return this.activardetalleAsientoContableCajaChica;
	}

	public void setActivardetalleAsientoContableCajaChica(Boolean activardetalleAsientoContableCajaChica) {
		this.activardetalleAsientoContableCajaChica= activardetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_moduloAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_moduloAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloAsientoContableCajaChica() {
		return this.resaltarid_moduloAsientoContableCajaChica;
	}

	public void setResaltarid_moduloAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_moduloAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_moduloAsientoContableCajaChica() {
		return this.mostrarid_moduloAsientoContableCajaChica;
	}

	public void setMostrarid_moduloAsientoContableCajaChica(Boolean mostrarid_moduloAsientoContableCajaChica) {
		this.mostrarid_moduloAsientoContableCajaChica= mostrarid_moduloAsientoContableCajaChica;
	}

	public Boolean getActivarid_moduloAsientoContableCajaChica() {
		return this.activarid_moduloAsientoContableCajaChica;
	}

	public void setActivarid_moduloAsientoContableCajaChica(Boolean activarid_moduloAsientoContableCajaChica) {
		this.activarid_moduloAsientoContableCajaChica= activarid_moduloAsientoContableCajaChica;
	}

	public Boolean getCargarid_moduloAsientoContableCajaChica() {
		return this.cargarid_moduloAsientoContableCajaChica;
	}

	public void setCargarid_moduloAsientoContableCajaChica(Boolean cargarid_moduloAsientoContableCajaChica) {
		this.cargarid_moduloAsientoContableCajaChica= cargarid_moduloAsientoContableCajaChica;
	}

	public Border setResaltarid_tipo_movimientoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoAsientoContableCajaChica() {
		return this.resaltarid_tipo_movimientoAsientoContableCajaChica;
	}

	public void setResaltarid_tipo_movimientoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_tipo_movimientoAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoAsientoContableCajaChica() {
		return this.mostrarid_tipo_movimientoAsientoContableCajaChica;
	}

	public void setMostrarid_tipo_movimientoAsientoContableCajaChica(Boolean mostrarid_tipo_movimientoAsientoContableCajaChica) {
		this.mostrarid_tipo_movimientoAsientoContableCajaChica= mostrarid_tipo_movimientoAsientoContableCajaChica;
	}

	public Boolean getActivarid_tipo_movimientoAsientoContableCajaChica() {
		return this.activarid_tipo_movimientoAsientoContableCajaChica;
	}

	public void setActivarid_tipo_movimientoAsientoContableCajaChica(Boolean activarid_tipo_movimientoAsientoContableCajaChica) {
		this.activarid_tipo_movimientoAsientoContableCajaChica= activarid_tipo_movimientoAsientoContableCajaChica;
	}

	public Boolean getCargarid_tipo_movimientoAsientoContableCajaChica() {
		return this.cargarid_tipo_movimientoAsientoContableCajaChica;
	}

	public void setCargarid_tipo_movimientoAsientoContableCajaChica(Boolean cargarid_tipo_movimientoAsientoContableCajaChica) {
		this.cargarid_tipo_movimientoAsientoContableCajaChica= cargarid_tipo_movimientoAsientoContableCajaChica;
	}

	public Border setResaltarid_tipo_transaccion_moduloAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloAsientoContableCajaChica() {
		return this.resaltarid_tipo_transaccion_moduloAsientoContableCajaChica;
	}

	public void setResaltarid_tipo_transaccion_moduloAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloAsientoContableCajaChica() {
		return this.mostrarid_tipo_transaccion_moduloAsientoContableCajaChica;
	}

	public void setMostrarid_tipo_transaccion_moduloAsientoContableCajaChica(Boolean mostrarid_tipo_transaccion_moduloAsientoContableCajaChica) {
		this.mostrarid_tipo_transaccion_moduloAsientoContableCajaChica= mostrarid_tipo_transaccion_moduloAsientoContableCajaChica;
	}

	public Boolean getActivarid_tipo_transaccion_moduloAsientoContableCajaChica() {
		return this.activarid_tipo_transaccion_moduloAsientoContableCajaChica;
	}

	public void setActivarid_tipo_transaccion_moduloAsientoContableCajaChica(Boolean activarid_tipo_transaccion_moduloAsientoContableCajaChica) {
		this.activarid_tipo_transaccion_moduloAsientoContableCajaChica= activarid_tipo_transaccion_moduloAsientoContableCajaChica;
	}

	public Boolean getCargarid_tipo_transaccion_moduloAsientoContableCajaChica() {
		return this.cargarid_tipo_transaccion_moduloAsientoContableCajaChica;
	}

	public void setCargarid_tipo_transaccion_moduloAsientoContableCajaChica(Boolean cargarid_tipo_transaccion_moduloAsientoContableCajaChica) {
		this.cargarid_tipo_transaccion_moduloAsientoContableCajaChica= cargarid_tipo_transaccion_moduloAsientoContableCajaChica;
	}

	public Border setResaltarid_tipo_movimiento_moduloAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimiento_moduloAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimiento_moduloAsientoContableCajaChica() {
		return this.resaltarid_tipo_movimiento_moduloAsientoContableCajaChica;
	}

	public void setResaltarid_tipo_movimiento_moduloAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_tipo_movimiento_moduloAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimiento_moduloAsientoContableCajaChica() {
		return this.mostrarid_tipo_movimiento_moduloAsientoContableCajaChica;
	}

	public void setMostrarid_tipo_movimiento_moduloAsientoContableCajaChica(Boolean mostrarid_tipo_movimiento_moduloAsientoContableCajaChica) {
		this.mostrarid_tipo_movimiento_moduloAsientoContableCajaChica= mostrarid_tipo_movimiento_moduloAsientoContableCajaChica;
	}

	public Boolean getActivarid_tipo_movimiento_moduloAsientoContableCajaChica() {
		return this.activarid_tipo_movimiento_moduloAsientoContableCajaChica;
	}

	public void setActivarid_tipo_movimiento_moduloAsientoContableCajaChica(Boolean activarid_tipo_movimiento_moduloAsientoContableCajaChica) {
		this.activarid_tipo_movimiento_moduloAsientoContableCajaChica= activarid_tipo_movimiento_moduloAsientoContableCajaChica;
	}

	public Boolean getCargarid_tipo_movimiento_moduloAsientoContableCajaChica() {
		return this.cargarid_tipo_movimiento_moduloAsientoContableCajaChica;
	}

	public void setCargarid_tipo_movimiento_moduloAsientoContableCajaChica(Boolean cargarid_tipo_movimiento_moduloAsientoContableCajaChica) {
		this.cargarid_tipo_movimiento_moduloAsientoContableCajaChica= cargarid_tipo_movimiento_moduloAsientoContableCajaChica;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridAsientoContableCajaChica(esInicial);
		this.setMostrarid_empresaAsientoContableCajaChica(esInicial);
		this.setMostrarid_sucursalAsientoContableCajaChica(esInicial);
		this.setMostrarid_ejercicioAsientoContableCajaChica(esInicial);
		this.setMostrarid_periodoAsientoContableCajaChica(esInicial);
		this.setMostrarid_usuarioAsientoContableCajaChica(esInicial);
		this.setMostrarid_anioAsientoContableCajaChica(esInicial);
		this.setMostrarid_mesAsientoContableCajaChica(esInicial);
		this.setMostrarsecuencialAsientoContableCajaChica(esInicial);
		this.setMostrarid_monedaAsientoContableCajaChica(esInicial);
		this.setMostrarfechaAsientoContableCajaChica(esInicial);
		this.setMostrarid_empleadoAsientoContableCajaChica(esInicial);
		this.setMostrarid_estado_asiento_contableAsientoContableCajaChica(esInicial);
		this.setMostrares_proveedorAsientoContableCajaChica(esInicial);
		this.setMostrarid_clienteAsientoContableCajaChica(esInicial);
		this.setMostrarid_transaccionAsientoContableCajaChica(esInicial);
		this.setMostrarid_tipo_documentoAsientoContableCajaChica(esInicial);
		this.setMostrarid_cuenta_contableAsientoContableCajaChica(esInicial);
		this.setMostrardetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_moduloAsientoContableCajaChica(esInicial);
		this.setMostrarid_tipo_movimientoAsientoContableCajaChica(esInicial);
		this.setMostrarid_tipo_transaccion_moduloAsientoContableCajaChica(esInicial);
		this.setMostrarid_tipo_movimiento_moduloAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setMostraridAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.FECHA)) {
				this.setMostrarfechaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA)) {
				this.setMostrarid_estado_asiento_contableAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR)) {
				this.setMostrares_proveedorAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.DETALLE)) {
				this.setMostrardetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setMostrarid_tipo_movimiento_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridAsientoContableCajaChica(esInicial);
		this.setActivarid_empresaAsientoContableCajaChica(esInicial);
		this.setActivarid_sucursalAsientoContableCajaChica(esInicial);
		this.setActivarid_ejercicioAsientoContableCajaChica(esInicial);
		this.setActivarid_periodoAsientoContableCajaChica(esInicial);
		this.setActivarid_usuarioAsientoContableCajaChica(esInicial);
		this.setActivarid_anioAsientoContableCajaChica(esInicial);
		this.setActivarid_mesAsientoContableCajaChica(esInicial);
		this.setActivarsecuencialAsientoContableCajaChica(esInicial);
		this.setActivarid_monedaAsientoContableCajaChica(esInicial);
		this.setActivarfechaAsientoContableCajaChica(esInicial);
		this.setActivarid_empleadoAsientoContableCajaChica(esInicial);
		this.setActivarid_estado_asiento_contableAsientoContableCajaChica(esInicial);
		this.setActivares_proveedorAsientoContableCajaChica(esInicial);
		this.setActivarid_clienteAsientoContableCajaChica(esInicial);
		this.setActivarid_transaccionAsientoContableCajaChica(esInicial);
		this.setActivarid_tipo_documentoAsientoContableCajaChica(esInicial);
		this.setActivarid_cuenta_contableAsientoContableCajaChica(esInicial);
		this.setActivardetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_moduloAsientoContableCajaChica(esInicial);
		this.setActivarid_tipo_movimientoAsientoContableCajaChica(esInicial);
		this.setActivarid_tipo_transaccion_moduloAsientoContableCajaChica(esInicial);
		this.setActivarid_tipo_movimiento_moduloAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setActivaridAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMES)) {
				this.setActivarid_mesAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.FECHA)) {
				this.setActivarfechaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA)) {
				this.setActivarid_estado_asiento_contableAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR)) {
				this.setActivares_proveedorAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.DETALLE)) {
				this.setActivardetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setActivarid_tipo_movimiento_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAsientoContableCajaChica(esInicial);
		this.setResaltarid_empresaAsientoContableCajaChica(esInicial);
		this.setResaltarid_sucursalAsientoContableCajaChica(esInicial);
		this.setResaltarid_ejercicioAsientoContableCajaChica(esInicial);
		this.setResaltarid_periodoAsientoContableCajaChica(esInicial);
		this.setResaltarid_usuarioAsientoContableCajaChica(esInicial);
		this.setResaltarid_anioAsientoContableCajaChica(esInicial);
		this.setResaltarid_mesAsientoContableCajaChica(esInicial);
		this.setResaltarsecuencialAsientoContableCajaChica(esInicial);
		this.setResaltarid_monedaAsientoContableCajaChica(esInicial);
		this.setResaltarfechaAsientoContableCajaChica(esInicial);
		this.setResaltarid_empleadoAsientoContableCajaChica(esInicial);
		this.setResaltarid_estado_asiento_contableAsientoContableCajaChica(esInicial);
		this.setResaltares_proveedorAsientoContableCajaChica(esInicial);
		this.setResaltarid_clienteAsientoContableCajaChica(esInicial);
		this.setResaltarid_transaccionAsientoContableCajaChica(esInicial);
		this.setResaltarid_tipo_documentoAsientoContableCajaChica(esInicial);
		this.setResaltarid_cuenta_contableAsientoContableCajaChica(esInicial);
		this.setResaltardetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_moduloAsientoContableCajaChica(esInicial);
		this.setResaltarid_tipo_movimientoAsientoContableCajaChica(esInicial);
		this.setResaltarid_tipo_transaccion_moduloAsientoContableCajaChica(esInicial);
		this.setResaltarid_tipo_movimiento_moduloAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setResaltaridAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.FECHA)) {
				this.setResaltarfechaAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDESTADOASIENTOCONTABLECAJACHICA)) {
				this.setResaltarid_estado_asiento_contableAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR)) {
				this.setResaltares_proveedorAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.DETALLE)) {
				this.setResaltardetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableCajaChicaConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setResaltarid_tipo_movimiento_moduloAsientoContableCajaChica(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica=null;

	public Border getResaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica() {
		return this.resaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica;
	}

	public void setResaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica(Border borderResaltarDetalleAsientoContableCajaChica) {
		if(borderResaltarDetalleAsientoContableCajaChica!=null) {
			this.resaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica= borderResaltarDetalleAsientoContableCajaChica;
		}
	}

	public Border setResaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleAsientoContableCajaChica=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//asientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarAsientoContableCajaChica.setBorder(borderResaltarDetalleAsientoContableCajaChica);
			
		this.resaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica= borderResaltarDetalleAsientoContableCajaChica;

		 return borderResaltarDetalleAsientoContableCajaChica;
	}



	public Boolean mostrarDetalleAsientoContableCajaChicaAsientoContableCajaChica=true;

	public Boolean getMostrarDetalleAsientoContableCajaChicaAsientoContableCajaChica() {
		return this.mostrarDetalleAsientoContableCajaChicaAsientoContableCajaChica;
	}

	public void setMostrarDetalleAsientoContableCajaChicaAsientoContableCajaChica(Boolean visibilidadResaltarDetalleAsientoContableCajaChica) {
		this.mostrarDetalleAsientoContableCajaChicaAsientoContableCajaChica= visibilidadResaltarDetalleAsientoContableCajaChica;
	}



	public Boolean activarDetalleAsientoContableCajaChicaAsientoContableCajaChica=true;

	public Boolean gethabilitarResaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica() {
		return this.activarDetalleAsientoContableCajaChicaAsientoContableCajaChica;
	}

	public void setActivarDetalleAsientoContableCajaChicaAsientoContableCajaChica(Boolean habilitarResaltarDetalleAsientoContableCajaChica) {
		this.activarDetalleAsientoContableCajaChicaAsientoContableCajaChica= habilitarResaltarDetalleAsientoContableCajaChica;
	}
		
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setMostrarDetalleAsientoContableCajaChicaAsientoContableCajaChica(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleAsientoContableCajaChica.class)) {
				this.setMostrarDetalleAsientoContableCajaChicaAsientoContableCajaChica(esAsigna);
				continue;
			}
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}

		this.setActivarDetalleAsientoContableCajaChicaAsientoContableCajaChica(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleAsientoContableCajaChica.class)) {
				this.setActivarDetalleAsientoContableCajaChicaAsientoContableCajaChica(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleAsientoContableCajaChica.class)) {
				this.setResaltarDetalleAsientoContableCajaChicaAsientoContableCajaChica(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdClienteAsientoContableCajaChica() {
		return this.mostrarFK_IdClienteAsientoContableCajaChica;
	}

	public void setMostrarFK_IdClienteAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdEjercicioAsientoContableCajaChica() {
		return this.mostrarFK_IdEjercicioAsientoContableCajaChica;
	}

	public void setMostrarFK_IdEjercicioAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdEmpleadoAsientoContableCajaChica() {
		return this.mostrarFK_IdEmpleadoAsientoContableCajaChica;
	}

	public void setMostrarFK_IdEmpleadoAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdEmpresaAsientoContableCajaChica() {
		return this.mostrarFK_IdEmpresaAsientoContableCajaChica;
	}

	public void setMostrarFK_IdEmpresaAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdModuloAsientoContableCajaChica() {
		return this.mostrarFK_IdModuloAsientoContableCajaChica;
	}

	public void setMostrarFK_IdModuloAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdPeriodoAsientoContableCajaChica() {
		return this.mostrarFK_IdPeriodoAsientoContableCajaChica;
	}

	public void setMostrarFK_IdPeriodoAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdSucursalAsientoContableCajaChica() {
		return this.mostrarFK_IdSucursalAsientoContableCajaChica;
	}

	public void setMostrarFK_IdSucursalAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdTipoDocumentoAsientoContableCajaChica() {
		return this.mostrarFK_IdTipoDocumentoAsientoContableCajaChica;
	}

	public void setMostrarFK_IdTipoDocumentoAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoModuloAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdTipoMovimientoModuloAsientoContableCajaChica() {
		return this.mostrarFK_IdTipoMovimientoModuloAsientoContableCajaChica;
	}

	public void setMostrarFK_IdTipoMovimientoModuloAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoModuloAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloAsientoContableCajaChica() {
		return this.mostrarFK_IdTipoTransaccionModuloAsientoContableCajaChica;
	}

	public void setMostrarFK_IdTipoTransaccionModuloAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdTransaccionAsientoContableCajaChica() {
		return this.mostrarFK_IdTransaccionAsientoContableCajaChica;
	}

	public void setMostrarFK_IdTransaccionAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdUsuarioAsientoContableCajaChica() {
		return this.mostrarFK_IdUsuarioAsientoContableCajaChica;
	}

	public void setMostrarFK_IdUsuarioAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioAsientoContableCajaChica= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdClienteAsientoContableCajaChica() {
		return this.activarFK_IdClienteAsientoContableCajaChica;
	}

	public void setActivarFK_IdClienteAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdClienteAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdEjercicioAsientoContableCajaChica() {
		return this.activarFK_IdEjercicioAsientoContableCajaChica;
	}

	public void setActivarFK_IdEjercicioAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdEmpleadoAsientoContableCajaChica() {
		return this.activarFK_IdEmpleadoAsientoContableCajaChica;
	}

	public void setActivarFK_IdEmpleadoAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdEmpresaAsientoContableCajaChica() {
		return this.activarFK_IdEmpresaAsientoContableCajaChica;
	}

	public void setActivarFK_IdEmpresaAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdModuloAsientoContableCajaChica() {
		return this.activarFK_IdModuloAsientoContableCajaChica;
	}

	public void setActivarFK_IdModuloAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdModuloAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdPeriodoAsientoContableCajaChica() {
		return this.activarFK_IdPeriodoAsientoContableCajaChica;
	}

	public void setActivarFK_IdPeriodoAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdSucursalAsientoContableCajaChica() {
		return this.activarFK_IdSucursalAsientoContableCajaChica;
	}

	public void setActivarFK_IdSucursalAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdTipoDocumentoAsientoContableCajaChica() {
		return this.activarFK_IdTipoDocumentoAsientoContableCajaChica;
	}

	public void setActivarFK_IdTipoDocumentoAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoModuloAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdTipoMovimientoModuloAsientoContableCajaChica() {
		return this.activarFK_IdTipoMovimientoModuloAsientoContableCajaChica;
	}

	public void setActivarFK_IdTipoMovimientoModuloAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoModuloAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloAsientoContableCajaChica() {
		return this.activarFK_IdTipoTransaccionModuloAsientoContableCajaChica;
	}

	public void setActivarFK_IdTipoTransaccionModuloAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdTransaccionAsientoContableCajaChica() {
		return this.activarFK_IdTransaccionAsientoContableCajaChica;
	}

	public void setActivarFK_IdTransaccionAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdUsuarioAsientoContableCajaChica() {
		return this.activarFK_IdUsuarioAsientoContableCajaChica;
	}

	public void setActivarFK_IdUsuarioAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioAsientoContableCajaChica= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteAsientoContableCajaChica=null;

	public Border getResaltarFK_IdClienteAsientoContableCajaChica() {
		return this.resaltarFK_IdClienteAsientoContableCajaChica;
	}

	public void setResaltarFK_IdClienteAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdClienteAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdClienteAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioAsientoContableCajaChica=null;

	public Border getResaltarFK_IdEjercicioAsientoContableCajaChica() {
		return this.resaltarFK_IdEjercicioAsientoContableCajaChica;
	}

	public void setResaltarFK_IdEjercicioAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdEjercicioAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoAsientoContableCajaChica=null;

	public Border getResaltarFK_IdEmpleadoAsientoContableCajaChica() {
		return this.resaltarFK_IdEmpleadoAsientoContableCajaChica;
	}

	public void setResaltarFK_IdEmpleadoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAsientoContableCajaChica=null;

	public Border getResaltarFK_IdEmpresaAsientoContableCajaChica() {
		return this.resaltarFK_IdEmpresaAsientoContableCajaChica;
	}

	public void setResaltarFK_IdEmpresaAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdModuloAsientoContableCajaChica=null;

	public Border getResaltarFK_IdModuloAsientoContableCajaChica() {
		return this.resaltarFK_IdModuloAsientoContableCajaChica;
	}

	public void setResaltarFK_IdModuloAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdModuloAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdModuloAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoAsientoContableCajaChica=null;

	public Border getResaltarFK_IdPeriodoAsientoContableCajaChica() {
		return this.resaltarFK_IdPeriodoAsientoContableCajaChica;
	}

	public void setResaltarFK_IdPeriodoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdPeriodoAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdSucursalAsientoContableCajaChica=null;

	public Border getResaltarFK_IdSucursalAsientoContableCajaChica() {
		return this.resaltarFK_IdSucursalAsientoContableCajaChica;
	}

	public void setResaltarFK_IdSucursalAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdSucursalAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdSucursalAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoAsientoContableCajaChica=null;

	public Border getResaltarFK_IdTipoDocumentoAsientoContableCajaChica() {
		return this.resaltarFK_IdTipoDocumentoAsientoContableCajaChica;
	}

	public void setResaltarFK_IdTipoDocumentoAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoModuloAsientoContableCajaChica=null;

	public Border getResaltarFK_IdTipoMovimientoModuloAsientoContableCajaChica() {
		return this.resaltarFK_IdTipoMovimientoModuloAsientoContableCajaChica;
	}

	public void setResaltarFK_IdTipoMovimientoModuloAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoModuloAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoModuloAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoModuloAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloAsientoContableCajaChica=null;

	public Border getResaltarFK_IdTipoTransaccionModuloAsientoContableCajaChica() {
		return this.resaltarFK_IdTipoTransaccionModuloAsientoContableCajaChica;
	}

	public void setResaltarFK_IdTipoTransaccionModuloAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionAsientoContableCajaChica=null;

	public Border getResaltarFK_IdTransaccionAsientoContableCajaChica() {
		return this.resaltarFK_IdTransaccionAsientoContableCajaChica;
	}

	public void setResaltarFK_IdTransaccionAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdTransaccionAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioAsientoContableCajaChica=null;

	public Border getResaltarFK_IdUsuarioAsientoContableCajaChica() {
		return this.resaltarFK_IdUsuarioAsientoContableCajaChica;
	}

	public void setResaltarFK_IdUsuarioAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdUsuarioAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableCajaChicaBeanSwingJInternalFrame asientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioAsientoContableCajaChica= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}