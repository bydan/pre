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


import com.bydan.erp.contabilidad.util.AsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.AsientoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.AsientoContableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AsientoContableConstantesFunciones extends AsientoContableConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=" order by fecha_emision desc" ;	
	public static final String SNOMBREOPCION="AsientoContable";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AsientoContable"+AsientoContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AsientoContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AsientoContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AsientoContableConstantesFunciones.SCHEMA+"_"+AsientoContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AsientoContableConstantesFunciones.SCHEMA+"_"+AsientoContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AsientoContableConstantesFunciones.SCHEMA+"_"+AsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AsientoContableConstantesFunciones.SCHEMA+"_"+AsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AsientoContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AsientoContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AsientoContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AsientoContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Asiento Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Asiento Contable";
	public static final String SCLASSWEBTITULO_LOWER="Asiento Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AsientoContable";
	public static final String OBJECTNAME="asientocontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="asiento_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select asientocontable from "+AsientoContableConstantesFunciones.SPERSISTENCENAME+" asientocontable";
	public static String QUERYSELECTNATIVE="select "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".version_row,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_empresa,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_sucursal,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_ejercicio,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_periodo,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_anio,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_mes,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_modulo,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_usuario,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_tipo_documento,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".codigo,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".fecha,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".numero_mayor,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_moneda,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".es_retencion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".numero_retencion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".valor,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".es_retencion_iva,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".numero_retencion_iva,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".cotizacion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_cliente,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_tipo_descripcion_asiento,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_formato,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".beneficiario,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".descripcion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".fecha_emision,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".fecha_finalizacion,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_estado_asiento_contable,"+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME+".id_tipo_movimiento_modulo from "+AsientoContableConstantesFunciones.SCHEMA+"."+AsientoContableConstantesFunciones.TABLENAME;//+" as "+AsientoContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected AsientoContableConstantesFuncionesAdditional asientocontableConstantesFuncionesAdditional=null;
	
	public AsientoContableConstantesFuncionesAdditional getAsientoContableConstantesFuncionesAdditional() {
		return this.asientocontableConstantesFuncionesAdditional;
	}
	
	public void setAsientoContableConstantesFuncionesAdditional(AsientoContableConstantesFuncionesAdditional asientocontableConstantesFuncionesAdditional) {
		try {
			this.asientocontableConstantesFuncionesAdditional=asientocontableConstantesFuncionesAdditional;
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
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDMODULO= "id_modulo";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDTIPODOCUMENTO= "id_tipo_documento";
    public static final String CODIGO= "codigo";
    public static final String FECHA= "fecha";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String IDMONEDA= "id_moneda";
    public static final String ESRETENCION= "es_retencion";
    public static final String NUMERORETENCION= "numero_retencion";
    public static final String VALOR= "valor";
    public static final String ESRETENCIONIVA= "es_retencion_iva";
    public static final String NUMERORETENCIONIVA= "numero_retencion_iva";
    public static final String COTIZACION= "cotizacion";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPODESCRIPCIONASIENTO= "id_tipo_descripcion_asiento";
    public static final String IDFORMATO= "id_formato";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String DESCRIPCION= "descripcion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAFINALIZACION= "fecha_finalizacion";
    public static final String IDESTADOASIENTOCONTABLE= "id_estado_asiento_contable";
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
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDTIPODOCUMENTO= "Documento";
		public static final String LABEL_IDTIPODOCUMENTO_LOWER= "Tipo Documento";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "T. Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_NUMEROMAYOR= "No Comp.";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_ESRETENCION= "Ret.";
		public static final String LABEL_ESRETENCION_LOWER= "Es Retencion";
    	public static final String LABEL_NUMERORETENCION= "Num. Ret.";
		public static final String LABEL_NUMERORETENCION_LOWER= "Numero Retencion";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_ESRETENCIONIVA= "Ret.Iva";
		public static final String LABEL_ESRETENCIONIVA_LOWER= "Es Retencion Iva";
    	public static final String LABEL_NUMERORETENCIONIVA= "Num. Ret.Iva";
		public static final String LABEL_NUMERORETENCIONIVA_LOWER= "Numero Retencion Iva";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPODESCRIPCIONASIENTO= "T. Descripcion";
		public static final String LABEL_IDTIPODESCRIPCIONASIENTO_LOWER= "Tipo Descripcion Asiento";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAFINALIZACION= "Fecha Finalizacion";
		public static final String LABEL_FECHAFINALIZACION_LOWER= "Fecha Finalizacion";
    	public static final String LABEL_IDESTADOASIENTOCONTABLE= "Estado Asiento Contable";
		public static final String LABEL_IDESTADOASIENTOCONTABLE_LOWER= "Estado Asiento Contable";
    	public static final String LABEL_IDTIPOMOVIMIENTOMODULO= "Tipo Movimiento Modulo";
		public static final String LABEL_IDTIPOMOVIMIENTOMODULO_LOWER= "Tipo Movimiento Modulo";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_RETENCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_RETENCION_IVA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_RETENCION_IVA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getAsientoContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDEMPRESA)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDEJERCICIO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDPERIODO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDANIO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDMES)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDMODULO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDUSUARIO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDTIPODOCUMENTO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDTIPODOCUMENTO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.CODIGO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.FECHA)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDMONEDA)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.ESRETENCION)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_ESRETENCION;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.NUMERORETENCION)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_NUMERORETENCION;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.VALOR)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.ESRETENCIONIVA)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_ESRETENCIONIVA;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.NUMERORETENCIONIVA)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_NUMERORETENCIONIVA;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.COTIZACION)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDCLIENTE)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDTIPODESCRIPCIONASIENTO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDFORMATO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.BENEFICIARIO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.DESCRIPCION)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.FECHAEMISION)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.FECHAFINALIZACION)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_FECHAFINALIZACION;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE;}
		if(sNombreColumna.equals(AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {sLabelColumna=AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_retencionDescripcion(AsientoContable asientocontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!asientocontable.getes_retencion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_retencionHtmlDescripcion(AsientoContable asientocontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(asientocontable.getId(),asientocontable.getes_retencion());

		return sDescripcion;
	}	
			
			
		
	public static String getes_retencion_ivaDescripcion(AsientoContable asientocontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!asientocontable.getes_retencion_iva()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_retencion_ivaHtmlDescripcion(AsientoContable asientocontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(asientocontable.getId(),asientocontable.getes_retencion_iva());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(asientocontable !=null/* && asientocontable.getId()!=0*/) {
			sDescripcion=asientocontable.getcodigo();//asientocontableasientocontable.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAsientoContableDescripcionDetallado(AsientoContable asientocontable) {
		String sDescripcion="";
			
		sDescripcion+=AsientoContableConstantesFunciones.ID+"=";
		sDescripcion+=asientocontable.getId().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=asientocontable.getVersionRow().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=asientocontable.getid_empresa().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=asientocontable.getid_sucursal().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=asientocontable.getid_ejercicio().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=asientocontable.getid_periodo().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDANIO+"=";
		sDescripcion+=asientocontable.getid_anio().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDMES+"=";
		sDescripcion+=asientocontable.getid_mes().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDMODULO+"=";
		sDescripcion+=asientocontable.getid_modulo().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=asientocontable.getid_usuario().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDTIPODOCUMENTO+"=";
		sDescripcion+=asientocontable.getid_tipo_documento().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.CODIGO+"=";
		sDescripcion+=asientocontable.getcodigo()+",";
		sDescripcion+=AsientoContableConstantesFunciones.FECHA+"=";
		sDescripcion+=asientocontable.getfecha().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=asientocontable.getid_tipo_movimiento().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=asientocontable.getnumero_mayor()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=asientocontable.getid_moneda().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.ESRETENCION+"=";
		sDescripcion+=asientocontable.getes_retencion().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.NUMERORETENCION+"=";
		sDescripcion+=asientocontable.getnumero_retencion()+",";
		sDescripcion+=AsientoContableConstantesFunciones.VALOR+"=";
		sDescripcion+=asientocontable.getvalor().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.ESRETENCIONIVA+"=";
		sDescripcion+=asientocontable.getes_retencion_iva().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.NUMERORETENCIONIVA+"=";
		sDescripcion+=asientocontable.getnumero_retencion_iva()+",";
		sDescripcion+=AsientoContableConstantesFunciones.COTIZACION+"=";
		sDescripcion+=asientocontable.getcotizacion().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=asientocontable.getid_cliente().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO+"=";
		sDescripcion+=asientocontable.getid_tipo_descripcion_asiento().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=asientocontable.getid_formato().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=asientocontable.getbeneficiario()+",";
		sDescripcion+=AsientoContableConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=asientocontable.getdescripcion()+",";
		sDescripcion+=AsientoContableConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=asientocontable.getfecha_emision().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.FECHAFINALIZACION+"=";
		sDescripcion+=asientocontable.getfecha_finalizacion().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE+"=";
		sDescripcion+=asientocontable.getid_estado_asiento_contable().toString()+",";
		sDescripcion+=AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO+"=";
		sDescripcion+=asientocontable.getid_tipo_movimiento_modulo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAsientoContableDescripcion(AsientoContable asientocontable,String sValor) throws Exception {			
		if(asientocontable !=null) {
			asientocontable.setcodigo(sValor);;//asientocontableasientocontable.getcodigo().trim();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getTipoDocumentoDescripcion(TipoDocumento tipodocumento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodocumento!=null/*&&tipodocumento.getId()>0*/) {
			sDescripcion=TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(tipodocumento);
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
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

	public static String getTipoDescripcionAsientoDescripcion(TipoDescripcionAsiento tipodescripcionasiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodescripcionasiento!=null/*&&tipodescripcionasiento.getId()>0*/) {
			sDescripcion=TipoDescripcionAsientoConstantesFunciones.getTipoDescripcionAsientoDescripcion(tipodescripcionasiento);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getEstadoAsientoContableDescripcion(EstadoAsientoContable estadoasientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoasientocontable!=null/*&&estadoasientocontable.getId()>0*/) {
			sDescripcion=EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableDescripcion(estadoasientocontable);
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
		} else if(sNombreIndice.equals("BusquedaPorBeneficiario")) {
			sNombreIndice="Tipo=  Por Beneficiario";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorFechaEmision")) {
			sNombreIndice="Tipo=  Por Fecha Emision";
		} else if(sNombreIndice.equals("BusquedaPorNumeroMayor")) {
			sNombreIndice="Tipo=  Por No Comp.";
		} else if(sNombreIndice.equals("BusquedaPorNumeroRetencion")) {
			sNombreIndice="Tipo=  Por Num. Ret.";
		} else if(sNombreIndice.equals("BusquedaPorValor")) {
			sNombreIndice="Tipo=  Por Valor";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Estado Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
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
		} else if(sNombreIndice.equals("FK_IdTipoDescripcionAsiento")) {
			sNombreIndice="Tipo=  Por T. Descripcion";
		} else if(sNombreIndice.equals("FK_IdTipoDocumento")) {
			sNombreIndice="Tipo=  Por Documento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por T. Movimiento";
		} else if(sNombreIndice.equals("FK_IdTipoMovimientoModulo")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Modulo";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorBeneficiario(String beneficiario) {
		String sDetalleIndice=" Parametros->";
		if(beneficiario!=null) {sDetalleIndice+=" Beneficiario="+beneficiario;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorFechaEmision(Date fecha_emision,Date fecha_emisionFinal) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision!=null) {sDetalleIndice+=" Fecha Emision="+fecha_emision.toString();}
		if(fecha_emisionFinal!=null) {sDetalleIndice+=" Fecha Emision FINAL="+fecha_emisionFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNumeroMayor(String numero_mayor) {
		String sDetalleIndice=" Parametros->";
		if(numero_mayor!=null) {sDetalleIndice+=" No Comp.="+numero_mayor;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNumeroRetencion(String numero_retencion) {
		String sDetalleIndice=" Parametros->";
		if(numero_retencion!=null) {sDetalleIndice+=" Num. Ret.="+numero_retencion;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorValor(Double valor,Double valorFinal) {
		String sDetalleIndice=" Parametros->";
		if(valor!=null) {sDetalleIndice+=" Valor="+valor.toString();}
		if(valorFinal!=null) {sDetalleIndice+=" Valor FINAL="+valorFinal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_estado_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Estado Asiento Contable="+id_estado_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoDescripcionAsiento(Long id_tipo_descripcion_asiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_descripcion_asiento!=null) {sDetalleIndice+=" Codigo Unico De T. Descripcion="+id_tipo_descripcion_asiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDocumento(Long id_tipo_documento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_documento!=null) {sDetalleIndice+=" Codigo Unico De Documento="+id_tipo_documento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De T. Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimientoModulo(Long id_tipo_movimiento_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Modulo="+id_tipo_movimiento_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAsientoContable(AsientoContable asientocontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		asientocontable.setcodigo(asientocontable.getcodigo().trim());
		asientocontable.setnumero_mayor(asientocontable.getnumero_mayor().trim());
		asientocontable.setnumero_retencion(asientocontable.getnumero_retencion().trim());
		asientocontable.setnumero_retencion_iva(asientocontable.getnumero_retencion_iva().trim());
		asientocontable.setbeneficiario(asientocontable.getbeneficiario().trim());
		asientocontable.setdescripcion(asientocontable.getdescripcion().trim());
	}
	
	public static void quitarEspaciosAsientoContables(List<AsientoContable> asientocontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AsientoContable asientocontable: asientocontables) {
			asientocontable.setcodigo(asientocontable.getcodigo().trim());
			asientocontable.setnumero_mayor(asientocontable.getnumero_mayor().trim());
			asientocontable.setnumero_retencion(asientocontable.getnumero_retencion().trim());
			asientocontable.setnumero_retencion_iva(asientocontable.getnumero_retencion_iva().trim());
			asientocontable.setbeneficiario(asientocontable.getbeneficiario().trim());
			asientocontable.setdescripcion(asientocontable.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsientoContable(AsientoContable asientocontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && asientocontable.getConCambioAuxiliar()) {
			asientocontable.setIsDeleted(asientocontable.getIsDeletedAuxiliar());	
			asientocontable.setIsNew(asientocontable.getIsNewAuxiliar());	
			asientocontable.setIsChanged(asientocontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			asientocontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			asientocontable.setIsDeletedAuxiliar(false);	
			asientocontable.setIsNewAuxiliar(false);	
			asientocontable.setIsChangedAuxiliar(false);
			
			asientocontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAsientoContables(List<AsientoContable> asientocontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AsientoContable asientocontable : asientocontables) {
			if(conAsignarBase && asientocontable.getConCambioAuxiliar()) {
				asientocontable.setIsDeleted(asientocontable.getIsDeletedAuxiliar());	
				asientocontable.setIsNew(asientocontable.getIsNewAuxiliar());	
				asientocontable.setIsChanged(asientocontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				asientocontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				asientocontable.setIsDeletedAuxiliar(false);	
				asientocontable.setIsNewAuxiliar(false);	
				asientocontable.setIsChangedAuxiliar(false);
				
				asientocontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAsientoContable(AsientoContable asientocontable,Boolean conEnteros) throws Exception  {
		asientocontable.setvalor(0.0);
		asientocontable.setcotizacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAsientoContables(List<AsientoContable> asientocontables,Boolean conEnteros) throws Exception  {
		
		for(AsientoContable asientocontable: asientocontables) {
			asientocontable.setvalor(0.0);
			asientocontable.setcotizacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAsientoContable(List<AsientoContable> asientocontables,AsientoContable asientocontableAux) throws Exception  {
		AsientoContableConstantesFunciones.InicializarValoresAsientoContable(asientocontableAux,true);
		
		for(AsientoContable asientocontable: asientocontables) {
			if(asientocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			asientocontableAux.setvalor(asientocontableAux.getvalor()+asientocontable.getvalor());			
			asientocontableAux.setcotizacion(asientocontableAux.getcotizacion()+asientocontable.getcotizacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AsientoContableConstantesFunciones.getArrayColumnasGlobalesAsientoContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AsientoContableConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AsientoContableConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AsientoContable> asientocontables,AsientoContable asientocontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AsientoContable asientocontableAux: asientocontables) {
			if(asientocontableAux!=null && asientocontable!=null) {
				if((asientocontableAux.getId()==null && asientocontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(asientocontableAux.getId()!=null && asientocontable.getId()!=null){
					if(asientocontableAux.getId().equals(asientocontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAsientoContable(List<AsientoContable> asientocontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double cotizacionTotal=0.0;
	
		for(AsientoContable asientocontable: asientocontables) {			
			if(asientocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=asientocontable.getvalor();
			cotizacionTotal+=asientocontable.getcotizacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsientoContableConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(AsientoContableConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AsientoContableConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(AsientoContableConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAsientoContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_ID, AsientoContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_VERSIONROW, AsientoContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDEMPRESA, AsientoContableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDSUCURSAL, AsientoContableConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDEJERCICIO, AsientoContableConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDPERIODO, AsientoContableConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDANIO, AsientoContableConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDMES, AsientoContableConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDMODULO, AsientoContableConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDUSUARIO, AsientoContableConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDTIPODOCUMENTO, AsientoContableConstantesFunciones.IDTIPODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_CODIGO, AsientoContableConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_FECHA, AsientoContableConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTO, AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_NUMEROMAYOR, AsientoContableConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDMONEDA, AsientoContableConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_ESRETENCION, AsientoContableConstantesFunciones.ESRETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_NUMERORETENCION, AsientoContableConstantesFunciones.NUMERORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_VALOR, AsientoContableConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_ESRETENCIONIVA, AsientoContableConstantesFunciones.ESRETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_NUMERORETENCIONIVA, AsientoContableConstantesFunciones.NUMERORETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_COTIZACION, AsientoContableConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDCLIENTE, AsientoContableConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDTIPODESCRIPCIONASIENTO, AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDFORMATO, AsientoContableConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_BENEFICIARIO, AsientoContableConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_DESCRIPCION, AsientoContableConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_FECHAEMISION, AsientoContableConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_FECHAFINALIZACION, AsientoContableConstantesFunciones.FECHAFINALIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE, AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO, AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAsientoContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDTIPODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.ESRETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.NUMERORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.ESRETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.NUMERORETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.FECHAFINALIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsientoContable() throws Exception  {
		return AsientoContableConstantesFunciones.getTiposSeleccionarAsientoContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsientoContable(Boolean conFk) throws Exception  {
		return AsientoContableConstantesFunciones.getTiposSeleccionarAsientoContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAsientoContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDTIPODOCUMENTO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDTIPODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_ESRETENCION);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_ESRETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_NUMERORETENCION);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_NUMERORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_ESRETENCIONIVA);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_ESRETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_NUMERORETENCIONIVA);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_NUMERORETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDTIPODESCRIPCIONASIENTO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDTIPODESCRIPCIONASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_FECHAFINALIZACION);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_FECHAFINALIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
			reporte.setsDescripcion(AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAsientoContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAsientoContable(AsientoContable asientocontableAux) throws Exception {
		
			asientocontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asientocontableAux.getEmpresa()));
			asientocontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(asientocontableAux.getSucursal()));
			asientocontableAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(asientocontableAux.getEjercicio()));
			asientocontableAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(asientocontableAux.getPeriodo()));
			asientocontableAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(asientocontableAux.getAnio()));
			asientocontableAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(asientocontableAux.getMes()));
			asientocontableAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(asientocontableAux.getModulo()));
			asientocontableAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(asientocontableAux.getUsuario()));
			asientocontableAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(asientocontableAux.getTipoDocumento()));
			asientocontableAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(asientocontableAux.getTipoMovimiento()));
			asientocontableAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(asientocontableAux.getMoneda()));
			asientocontableAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(asientocontableAux.getCliente()));
			asientocontableAux.settipodescripcionasiento_descripcion(TipoDescripcionAsientoConstantesFunciones.getTipoDescripcionAsientoDescripcion(asientocontableAux.getTipoDescripcionAsiento()));
			asientocontableAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(asientocontableAux.getFormato()));
			asientocontableAux.setestadoasientocontable_descripcion(EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableDescripcion(asientocontableAux.getEstadoAsientoContable()));
			asientocontableAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(asientocontableAux.getTipoMovimientoModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAsientoContable(List<AsientoContable> asientocontablesTemp) throws Exception {
		for(AsientoContable asientocontableAux:asientocontablesTemp) {
			
			asientocontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(asientocontableAux.getEmpresa()));
			asientocontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(asientocontableAux.getSucursal()));
			asientocontableAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(asientocontableAux.getEjercicio()));
			asientocontableAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(asientocontableAux.getPeriodo()));
			asientocontableAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(asientocontableAux.getAnio()));
			asientocontableAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(asientocontableAux.getMes()));
			asientocontableAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(asientocontableAux.getModulo()));
			asientocontableAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(asientocontableAux.getUsuario()));
			asientocontableAux.settipodocumento_descripcion(TipoDocumentoConstantesFunciones.getTipoDocumentoDescripcion(asientocontableAux.getTipoDocumento()));
			asientocontableAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(asientocontableAux.getTipoMovimiento()));
			asientocontableAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(asientocontableAux.getMoneda()));
			asientocontableAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(asientocontableAux.getCliente()));
			asientocontableAux.settipodescripcionasiento_descripcion(TipoDescripcionAsientoConstantesFunciones.getTipoDescripcionAsientoDescripcion(asientocontableAux.getTipoDescripcionAsiento()));
			asientocontableAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(asientocontableAux.getFormato()));
			asientocontableAux.setestadoasientocontable_descripcion(EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableDescripcion(asientocontableAux.getEstadoAsientoContable()));
			asientocontableAux.settipomovimientomodulo_descripcion(TipoMovimientoModuloConstantesFunciones.getTipoMovimientoModuloDescripcion(asientocontableAux.getTipoMovimientoModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(TipoDocumento.class));
				classes.add(new Classe(TipoMovimiento.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoDescripcionAsiento.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(EstadoAsientoContable.class));
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDocumento.class)) {
						classes.add(new Classe(TipoDocumento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDescripcionAsiento.class)) {
						classes.add(new Classe(TipoDescripcionAsiento.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoAsientoContable.class)) {
						classes.add(new Classe(EstadoAsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoDescripcionAsiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDescripcionAsiento.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoAsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoAsientoContable.class)); continue;
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

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(TipoDocumento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDocumento.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoDescripcionAsiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDescripcionAsiento.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(EstadoAsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoAsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsientoContableConstantesFunciones.getClassesRelationshipsOfAsientoContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Sri.class));
				classes.add(new Classe(ImportarExportar.class));
				classes.add(new Classe(DetalleMoviClienProve.class));
				classes.add(new Classe(Prestamo.class));
				classes.add(new Classe(DetalleAsientoContable.class));
				classes.add(new Classe(Retencion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Sri.class)) {
						classes.add(new Classe(Sri.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ImportarExportar.class)) {
						classes.add(new Classe(ImportarExportar.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleMoviClienProve.class)) {
						classes.add(new Classe(DetalleMoviClienProve.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Prestamo.class)) {
						classes.add(new Classe(Prestamo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleAsientoContable.class)) {
						classes.add(new Classe(DetalleAsientoContable.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Retencion.class)) {
						classes.add(new Classe(Retencion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AsientoContableConstantesFunciones.getClassesRelationshipsFromStringsOfAsientoContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(DetalleMoviClienProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMoviClienProve.class)); continue;
					}

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}

					if(DetalleAsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAsientoContable.class)); continue;
					}

					if(Retencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Retencion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Sri.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sri.class)); continue;
					}

					if(ImportarExportar.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ImportarExportar.class)); continue;
					}

					if(DetalleMoviClienProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleMoviClienProve.class)); continue;
					}

					if(Prestamo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Prestamo.class)); continue;
					}

					if(DetalleAsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleAsientoContable.class)); continue;
					}

					if(Retencion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Retencion.class)); continue;
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
	public static void actualizarLista(AsientoContable asientocontable,List<AsientoContable> asientocontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AsientoContable asientocontableEncontrado=null;
			
			for(AsientoContable asientocontableLocal:asientocontables) {
				if(asientocontableLocal.getId().equals(asientocontable.getId())) {
					asientocontableEncontrado=asientocontableLocal;
					
					asientocontableLocal.setIsChanged(asientocontable.getIsChanged());
					asientocontableLocal.setIsNew(asientocontable.getIsNew());
					asientocontableLocal.setIsDeleted(asientocontable.getIsDeleted());
					
					asientocontableLocal.setGeneralEntityOriginal(asientocontable.getGeneralEntityOriginal());
					
					asientocontableLocal.setId(asientocontable.getId());	
					asientocontableLocal.setVersionRow(asientocontable.getVersionRow());	
					asientocontableLocal.setid_empresa(asientocontable.getid_empresa());	
					asientocontableLocal.setid_sucursal(asientocontable.getid_sucursal());	
					asientocontableLocal.setid_ejercicio(asientocontable.getid_ejercicio());	
					asientocontableLocal.setid_periodo(asientocontable.getid_periodo());	
					asientocontableLocal.setid_anio(asientocontable.getid_anio());	
					asientocontableLocal.setid_mes(asientocontable.getid_mes());	
					asientocontableLocal.setid_modulo(asientocontable.getid_modulo());	
					asientocontableLocal.setid_usuario(asientocontable.getid_usuario());	
					asientocontableLocal.setid_tipo_documento(asientocontable.getid_tipo_documento());	
					asientocontableLocal.setcodigo(asientocontable.getcodigo());	
					asientocontableLocal.setfecha(asientocontable.getfecha());	
					asientocontableLocal.setid_tipo_movimiento(asientocontable.getid_tipo_movimiento());	
					asientocontableLocal.setnumero_mayor(asientocontable.getnumero_mayor());	
					asientocontableLocal.setid_moneda(asientocontable.getid_moneda());	
					asientocontableLocal.setes_retencion(asientocontable.getes_retencion());	
					asientocontableLocal.setnumero_retencion(asientocontable.getnumero_retencion());	
					asientocontableLocal.setvalor(asientocontable.getvalor());	
					asientocontableLocal.setes_retencion_iva(asientocontable.getes_retencion_iva());	
					asientocontableLocal.setnumero_retencion_iva(asientocontable.getnumero_retencion_iva());	
					asientocontableLocal.setcotizacion(asientocontable.getcotizacion());	
					asientocontableLocal.setid_cliente(asientocontable.getid_cliente());	
					asientocontableLocal.setid_tipo_descripcion_asiento(asientocontable.getid_tipo_descripcion_asiento());	
					asientocontableLocal.setid_formato(asientocontable.getid_formato());	
					asientocontableLocal.setbeneficiario(asientocontable.getbeneficiario());	
					asientocontableLocal.setdescripcion(asientocontable.getdescripcion());	
					asientocontableLocal.setfecha_emision(asientocontable.getfecha_emision());	
					asientocontableLocal.setfecha_finalizacion(asientocontable.getfecha_finalizacion());	
					asientocontableLocal.setid_estado_asiento_contable(asientocontable.getid_estado_asiento_contable());	
					asientocontableLocal.setid_tipo_movimiento_modulo(asientocontable.getid_tipo_movimiento_modulo());	
					
					
					asientocontableLocal.setSris(asientocontable.getSris());
					asientocontableLocal.setImportarExportars(asientocontable.getImportarExportars());
					asientocontableLocal.setDetalleMoviClienProves(asientocontable.getDetalleMoviClienProves());
					asientocontableLocal.setPrestamos(asientocontable.getPrestamos());
					asientocontableLocal.setDetalleAsientoContables(asientocontable.getDetalleAsientoContables());
					asientocontableLocal.setRetencions(asientocontable.getRetencions());
					
					existe=true;
					break;
				}
			}
			
			if(!asientocontable.getIsDeleted()) {
				if(!existe) {
					asientocontables.add(asientocontable);
				}
			} else {
				if(asientocontableEncontrado!=null && permiteQuitar)  {
					asientocontables.remove(asientocontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AsientoContable asientocontable,List<AsientoContable> asientocontables) throws Exception {
		try	{			
			for(AsientoContable asientocontableLocal:asientocontables) {
				if(asientocontableLocal.getId().equals(asientocontable.getId())) {
					asientocontableLocal.setIsSelected(asientocontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAsientoContable(List<AsientoContable> asientocontablesAux) throws Exception {
		//this.asientocontablesAux=asientocontablesAux;
		
		for(AsientoContable asientocontableAux:asientocontablesAux) {
			if(asientocontableAux.getIsChanged()) {
				asientocontableAux.setIsChanged(false);
			}		
			
			if(asientocontableAux.getIsNew()) {
				asientocontableAux.setIsNew(false);
			}	
			
			if(asientocontableAux.getIsDeleted()) {
				asientocontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAsientoContable(AsientoContable asientocontableAux) throws Exception {
		//this.asientocontableAux=asientocontableAux;
		
			if(asientocontableAux.getIsChanged()) {
				asientocontableAux.setIsChanged(false);
			}		
			
			if(asientocontableAux.getIsNew()) {
				asientocontableAux.setIsNew(false);
			}	
			
			if(asientocontableAux.getIsDeleted()) {
				asientocontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AsientoContable asientocontableAsignar,AsientoContable asientocontable) throws Exception {
		asientocontableAsignar.setId(asientocontable.getId());	
		asientocontableAsignar.setVersionRow(asientocontable.getVersionRow());	
		asientocontableAsignar.setid_empresa(asientocontable.getid_empresa());
		asientocontableAsignar.setempresa_descripcion(asientocontable.getempresa_descripcion());	
		asientocontableAsignar.setid_sucursal(asientocontable.getid_sucursal());
		asientocontableAsignar.setsucursal_descripcion(asientocontable.getsucursal_descripcion());	
		asientocontableAsignar.setid_ejercicio(asientocontable.getid_ejercicio());
		asientocontableAsignar.setejercicio_descripcion(asientocontable.getejercicio_descripcion());	
		asientocontableAsignar.setid_periodo(asientocontable.getid_periodo());
		asientocontableAsignar.setperiodo_descripcion(asientocontable.getperiodo_descripcion());	
		asientocontableAsignar.setid_anio(asientocontable.getid_anio());
		asientocontableAsignar.setanio_descripcion(asientocontable.getanio_descripcion());	
		asientocontableAsignar.setid_mes(asientocontable.getid_mes());
		asientocontableAsignar.setmes_descripcion(asientocontable.getmes_descripcion());	
		asientocontableAsignar.setid_modulo(asientocontable.getid_modulo());
		asientocontableAsignar.setmodulo_descripcion(asientocontable.getmodulo_descripcion());	
		asientocontableAsignar.setid_usuario(asientocontable.getid_usuario());
		asientocontableAsignar.setusuario_descripcion(asientocontable.getusuario_descripcion());	
		asientocontableAsignar.setid_tipo_documento(asientocontable.getid_tipo_documento());
		asientocontableAsignar.settipodocumento_descripcion(asientocontable.gettipodocumento_descripcion());	
		asientocontableAsignar.setcodigo(asientocontable.getcodigo());	
		asientocontableAsignar.setfecha(asientocontable.getfecha());	
		asientocontableAsignar.setid_tipo_movimiento(asientocontable.getid_tipo_movimiento());
		asientocontableAsignar.settipomovimiento_descripcion(asientocontable.gettipomovimiento_descripcion());	
		asientocontableAsignar.setnumero_mayor(asientocontable.getnumero_mayor());	
		asientocontableAsignar.setid_moneda(asientocontable.getid_moneda());
		asientocontableAsignar.setmoneda_descripcion(asientocontable.getmoneda_descripcion());	
		asientocontableAsignar.setes_retencion(asientocontable.getes_retencion());	
		asientocontableAsignar.setnumero_retencion(asientocontable.getnumero_retencion());	
		asientocontableAsignar.setvalor(asientocontable.getvalor());	
		asientocontableAsignar.setes_retencion_iva(asientocontable.getes_retencion_iva());	
		asientocontableAsignar.setnumero_retencion_iva(asientocontable.getnumero_retencion_iva());	
		asientocontableAsignar.setcotizacion(asientocontable.getcotizacion());	
		asientocontableAsignar.setid_cliente(asientocontable.getid_cliente());
		asientocontableAsignar.setcliente_descripcion(asientocontable.getcliente_descripcion());	
		asientocontableAsignar.setid_tipo_descripcion_asiento(asientocontable.getid_tipo_descripcion_asiento());
		asientocontableAsignar.settipodescripcionasiento_descripcion(asientocontable.gettipodescripcionasiento_descripcion());	
		asientocontableAsignar.setid_formato(asientocontable.getid_formato());
		asientocontableAsignar.setformato_descripcion(asientocontable.getformato_descripcion());	
		asientocontableAsignar.setbeneficiario(asientocontable.getbeneficiario());	
		asientocontableAsignar.setdescripcion(asientocontable.getdescripcion());	
		asientocontableAsignar.setfecha_emision(asientocontable.getfecha_emision());	
		asientocontableAsignar.setfecha_finalizacion(asientocontable.getfecha_finalizacion());	
		asientocontableAsignar.setid_estado_asiento_contable(asientocontable.getid_estado_asiento_contable());
		asientocontableAsignar.setestadoasientocontable_descripcion(asientocontable.getestadoasientocontable_descripcion());	
		asientocontableAsignar.setid_tipo_movimiento_modulo(asientocontable.getid_tipo_movimiento_modulo());
		asientocontableAsignar.settipomovimientomodulo_descripcion(asientocontable.gettipomovimientomodulo_descripcion());	
	}
	
	public static void inicializarAsientoContable(AsientoContable asientocontable) throws Exception {
		try {
				asientocontable.setId(0L);	
					
				asientocontable.setid_empresa(-1L);	
				asientocontable.setid_sucursal(-1L);	
				asientocontable.setid_ejercicio(-1L);	
				asientocontable.setid_periodo(-1L);	
				asientocontable.setid_anio(null);	
				asientocontable.setid_mes(null);	
				asientocontable.setid_modulo(-1L);	
				asientocontable.setid_usuario(-1L);	
				asientocontable.setid_tipo_documento(-1L);	
				asientocontable.setcodigo("");	
				asientocontable.setfecha(new Date());	
				asientocontable.setid_tipo_movimiento(-1L);	
				asientocontable.setnumero_mayor("");	
				asientocontable.setid_moneda(-1L);	
				asientocontable.setes_retencion(false);	
				asientocontable.setnumero_retencion("");	
				asientocontable.setvalor(0.0);	
				asientocontable.setes_retencion_iva(false);	
				asientocontable.setnumero_retencion_iva("");	
				asientocontable.setcotizacion(0.0);	
				asientocontable.setid_cliente(null);	
				asientocontable.setid_tipo_descripcion_asiento(-1L);	
				asientocontable.setid_formato(null);	
				asientocontable.setbeneficiario("");	
				asientocontable.setdescripcion("");	
				asientocontable.setfecha_emision(new Date());	
				asientocontable.setfecha_finalizacion(new Date());	
				asientocontable.setid_estado_asiento_contable(1L);	
				asientocontable.setid_tipo_movimiento_modulo(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAsientoContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDTIPODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_ESRETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_NUMERORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_ESRETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_NUMERORETENCIONIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDTIPODESCRIPCIONASIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_FECHAFINALIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDESTADOASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AsientoContableConstantesFunciones.LABEL_IDTIPOMOVIMIENTOMODULO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAsientoContable(String sTipo,Row row,Workbook workbook,AsientoContable asientocontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.gettipodocumento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(asientocontable.getes_retencion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getnumero_retencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(asientocontable.getes_retencion_iva()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getnumero_retencion_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.gettipodescripcionasiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getfecha_finalizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.getestadoasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(asientocontable.gettipomovimientomodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAsientoContable=" order by fecha_emision desc" ;
	
	public String getsFinalQueryAsientoContable() {
		return this.sFinalQueryAsientoContable;
	}
	
	public void setsFinalQueryAsientoContable(String sFinalQueryAsientoContable) {
		this.sFinalQueryAsientoContable= sFinalQueryAsientoContable;
	}
	
	public Border resaltarSeleccionarAsientoContable=null;
	
	public Border setResaltarSeleccionarAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAsientoContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAsientoContable() {
		return this.resaltarSeleccionarAsientoContable;
	}
	
	public void setResaltarSeleccionarAsientoContable(Border borderResaltarSeleccionarAsientoContable) {
		this.resaltarSeleccionarAsientoContable= borderResaltarSeleccionarAsientoContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAsientoContable=null;
	public Boolean mostraridAsientoContable=true;
	public Boolean activaridAsientoContable=true;

	public Border resaltarid_empresaAsientoContable=null;
	public Boolean mostrarid_empresaAsientoContable=true;
	public Boolean activarid_empresaAsientoContable=true;
	public Boolean cargarid_empresaAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_sucursalAsientoContable=null;
	public Boolean mostrarid_sucursalAsientoContable=true;
	public Boolean activarid_sucursalAsientoContable=true;
	public Boolean cargarid_sucursalAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_ejercicioAsientoContable=null;
	public Boolean mostrarid_ejercicioAsientoContable=true;
	public Boolean activarid_ejercicioAsientoContable=true;
	public Boolean cargarid_ejercicioAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_periodoAsientoContable=null;
	public Boolean mostrarid_periodoAsientoContable=true;
	public Boolean activarid_periodoAsientoContable=true;
	public Boolean cargarid_periodoAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_anioAsientoContable=null;
	public Boolean mostrarid_anioAsientoContable=true;
	public Boolean activarid_anioAsientoContable=false;
	public Boolean cargarid_anioAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_mesAsientoContable=null;
	public Boolean mostrarid_mesAsientoContable=true;
	public Boolean activarid_mesAsientoContable=false;
	public Boolean cargarid_mesAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_moduloAsientoContable=null;
	public Boolean mostrarid_moduloAsientoContable=true;
	public Boolean activarid_moduloAsientoContable=true;
	public Boolean cargarid_moduloAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_usuarioAsientoContable=null;
	public Boolean mostrarid_usuarioAsientoContable=true;
	public Boolean activarid_usuarioAsientoContable=true;
	public Boolean cargarid_usuarioAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_tipo_documentoAsientoContable=null;
	public Boolean mostrarid_tipo_documentoAsientoContable=true;
	public Boolean activarid_tipo_documentoAsientoContable=true;
	public Boolean cargarid_tipo_documentoAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_documentoAsientoContable=false;//ConEventDepend=true

	public Border resaltarcodigoAsientoContable=null;
	public Boolean mostrarcodigoAsientoContable=true;
	public Boolean activarcodigoAsientoContable=false;

	public Border resaltarfechaAsientoContable=null;
	public Boolean mostrarfechaAsientoContable=true;
	public Boolean activarfechaAsientoContable=false;

	public Border resaltarid_tipo_movimientoAsientoContable=null;
	public Boolean mostrarid_tipo_movimientoAsientoContable=true;
	public Boolean activarid_tipo_movimientoAsientoContable=true;
	public Boolean cargarid_tipo_movimientoAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoAsientoContable=false;//ConEventDepend=true

	public Border resaltarnumero_mayorAsientoContable=null;
	public Boolean mostrarnumero_mayorAsientoContable=true;
	public Boolean activarnumero_mayorAsientoContable=true;

	public Border resaltarid_monedaAsientoContable=null;
	public Boolean mostrarid_monedaAsientoContable=true;
	public Boolean activarid_monedaAsientoContable=true;
	public Boolean cargarid_monedaAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaAsientoContable=false;//ConEventDepend=true

	public Border resaltares_retencionAsientoContable=null;
	public Boolean mostrares_retencionAsientoContable=true;
	public Boolean activares_retencionAsientoContable=true;

	public Border resaltarnumero_retencionAsientoContable=null;
	public Boolean mostrarnumero_retencionAsientoContable=true;
	public Boolean activarnumero_retencionAsientoContable=false;

	public Border resaltarvalorAsientoContable=null;
	public Boolean mostrarvalorAsientoContable=true;
	public Boolean activarvalorAsientoContable=true;

	public Border resaltares_retencion_ivaAsientoContable=null;
	public Boolean mostrares_retencion_ivaAsientoContable=true;
	public Boolean activares_retencion_ivaAsientoContable=true;

	public Border resaltarnumero_retencion_ivaAsientoContable=null;
	public Boolean mostrarnumero_retencion_ivaAsientoContable=true;
	public Boolean activarnumero_retencion_ivaAsientoContable=false;

	public Border resaltarcotizacionAsientoContable=null;
	public Boolean mostrarcotizacionAsientoContable=true;
	public Boolean activarcotizacionAsientoContable=false;

	public Border resaltarid_clienteAsientoContable=null;
	public Boolean mostrarid_clienteAsientoContable=true;
	public Boolean activarid_clienteAsientoContable=true;
	public Boolean cargarid_clienteAsientoContable=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_tipo_descripcion_asientoAsientoContable=null;
	public Boolean mostrarid_tipo_descripcion_asientoAsientoContable=true;
	public Boolean activarid_tipo_descripcion_asientoAsientoContable=true;
	public Boolean cargarid_tipo_descripcion_asientoAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_descripcion_asientoAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_formatoAsientoContable=null;
	public Boolean mostrarid_formatoAsientoContable=true;
	public Boolean activarid_formatoAsientoContable=true;
	public Boolean cargarid_formatoAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoAsientoContable=false;//ConEventDepend=true

	public Border resaltarbeneficiarioAsientoContable=null;
	public Boolean mostrarbeneficiarioAsientoContable=true;
	public Boolean activarbeneficiarioAsientoContable=true;

	public Border resaltardescripcionAsientoContable=null;
	public Boolean mostrardescripcionAsientoContable=true;
	public Boolean activardescripcionAsientoContable=true;

	public Border resaltarfecha_emisionAsientoContable=null;
	public Boolean mostrarfecha_emisionAsientoContable=true;
	public Boolean activarfecha_emisionAsientoContable=false;

	public Border resaltarfecha_finalizacionAsientoContable=null;
	public Boolean mostrarfecha_finalizacionAsientoContable=true;
	public Boolean activarfecha_finalizacionAsientoContable=false;

	public Border resaltarid_estado_asiento_contableAsientoContable=null;
	public Boolean mostrarid_estado_asiento_contableAsientoContable=true;
	public Boolean activarid_estado_asiento_contableAsientoContable=false;
	public Boolean cargarid_estado_asiento_contableAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_asiento_contableAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimiento_moduloAsientoContable=null;
	public Boolean mostrarid_tipo_movimiento_moduloAsientoContable=true;
	public Boolean activarid_tipo_movimiento_moduloAsientoContable=false;
	public Boolean cargarid_tipo_movimiento_moduloAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimiento_moduloAsientoContable=false;//ConEventDepend=true

	
	

	public Border setResaltaridAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltaridAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAsientoContable() {
		return this.resaltaridAsientoContable;
	}

	public void setResaltaridAsientoContable(Border borderResaltar) {
		this.resaltaridAsientoContable= borderResaltar;
	}

	public Boolean getMostraridAsientoContable() {
		return this.mostraridAsientoContable;
	}

	public void setMostraridAsientoContable(Boolean mostraridAsientoContable) {
		this.mostraridAsientoContable= mostraridAsientoContable;
	}

	public Boolean getActivaridAsientoContable() {
		return this.activaridAsientoContable;
	}

	public void setActivaridAsientoContable(Boolean activaridAsientoContable) {
		this.activaridAsientoContable= activaridAsientoContable;
	}

	public Border setResaltarid_empresaAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_empresaAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAsientoContable() {
		return this.resaltarid_empresaAsientoContable;
	}

	public void setResaltarid_empresaAsientoContable(Border borderResaltar) {
		this.resaltarid_empresaAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_empresaAsientoContable() {
		return this.mostrarid_empresaAsientoContable;
	}

	public void setMostrarid_empresaAsientoContable(Boolean mostrarid_empresaAsientoContable) {
		this.mostrarid_empresaAsientoContable= mostrarid_empresaAsientoContable;
	}

	public Boolean getActivarid_empresaAsientoContable() {
		return this.activarid_empresaAsientoContable;
	}

	public void setActivarid_empresaAsientoContable(Boolean activarid_empresaAsientoContable) {
		this.activarid_empresaAsientoContable= activarid_empresaAsientoContable;
	}

	public Boolean getCargarid_empresaAsientoContable() {
		return this.cargarid_empresaAsientoContable;
	}

	public void setCargarid_empresaAsientoContable(Boolean cargarid_empresaAsientoContable) {
		this.cargarid_empresaAsientoContable= cargarid_empresaAsientoContable;
	}

	public Border setResaltarid_sucursalAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAsientoContable() {
		return this.resaltarid_sucursalAsientoContable;
	}

	public void setResaltarid_sucursalAsientoContable(Border borderResaltar) {
		this.resaltarid_sucursalAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAsientoContable() {
		return this.mostrarid_sucursalAsientoContable;
	}

	public void setMostrarid_sucursalAsientoContable(Boolean mostrarid_sucursalAsientoContable) {
		this.mostrarid_sucursalAsientoContable= mostrarid_sucursalAsientoContable;
	}

	public Boolean getActivarid_sucursalAsientoContable() {
		return this.activarid_sucursalAsientoContable;
	}

	public void setActivarid_sucursalAsientoContable(Boolean activarid_sucursalAsientoContable) {
		this.activarid_sucursalAsientoContable= activarid_sucursalAsientoContable;
	}

	public Boolean getCargarid_sucursalAsientoContable() {
		return this.cargarid_sucursalAsientoContable;
	}

	public void setCargarid_sucursalAsientoContable(Boolean cargarid_sucursalAsientoContable) {
		this.cargarid_sucursalAsientoContable= cargarid_sucursalAsientoContable;
	}

	public Border setResaltarid_ejercicioAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioAsientoContable() {
		return this.resaltarid_ejercicioAsientoContable;
	}

	public void setResaltarid_ejercicioAsientoContable(Border borderResaltar) {
		this.resaltarid_ejercicioAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioAsientoContable() {
		return this.mostrarid_ejercicioAsientoContable;
	}

	public void setMostrarid_ejercicioAsientoContable(Boolean mostrarid_ejercicioAsientoContable) {
		this.mostrarid_ejercicioAsientoContable= mostrarid_ejercicioAsientoContable;
	}

	public Boolean getActivarid_ejercicioAsientoContable() {
		return this.activarid_ejercicioAsientoContable;
	}

	public void setActivarid_ejercicioAsientoContable(Boolean activarid_ejercicioAsientoContable) {
		this.activarid_ejercicioAsientoContable= activarid_ejercicioAsientoContable;
	}

	public Boolean getCargarid_ejercicioAsientoContable() {
		return this.cargarid_ejercicioAsientoContable;
	}

	public void setCargarid_ejercicioAsientoContable(Boolean cargarid_ejercicioAsientoContable) {
		this.cargarid_ejercicioAsientoContable= cargarid_ejercicioAsientoContable;
	}

	public Border setResaltarid_periodoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_periodoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoAsientoContable() {
		return this.resaltarid_periodoAsientoContable;
	}

	public void setResaltarid_periodoAsientoContable(Border borderResaltar) {
		this.resaltarid_periodoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_periodoAsientoContable() {
		return this.mostrarid_periodoAsientoContable;
	}

	public void setMostrarid_periodoAsientoContable(Boolean mostrarid_periodoAsientoContable) {
		this.mostrarid_periodoAsientoContable= mostrarid_periodoAsientoContable;
	}

	public Boolean getActivarid_periodoAsientoContable() {
		return this.activarid_periodoAsientoContable;
	}

	public void setActivarid_periodoAsientoContable(Boolean activarid_periodoAsientoContable) {
		this.activarid_periodoAsientoContable= activarid_periodoAsientoContable;
	}

	public Boolean getCargarid_periodoAsientoContable() {
		return this.cargarid_periodoAsientoContable;
	}

	public void setCargarid_periodoAsientoContable(Boolean cargarid_periodoAsientoContable) {
		this.cargarid_periodoAsientoContable= cargarid_periodoAsientoContable;
	}

	public Border setResaltarid_anioAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_anioAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioAsientoContable() {
		return this.resaltarid_anioAsientoContable;
	}

	public void setResaltarid_anioAsientoContable(Border borderResaltar) {
		this.resaltarid_anioAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_anioAsientoContable() {
		return this.mostrarid_anioAsientoContable;
	}

	public void setMostrarid_anioAsientoContable(Boolean mostrarid_anioAsientoContable) {
		this.mostrarid_anioAsientoContable= mostrarid_anioAsientoContable;
	}

	public Boolean getActivarid_anioAsientoContable() {
		return this.activarid_anioAsientoContable;
	}

	public void setActivarid_anioAsientoContable(Boolean activarid_anioAsientoContable) {
		this.activarid_anioAsientoContable= activarid_anioAsientoContable;
	}

	public Boolean getCargarid_anioAsientoContable() {
		return this.cargarid_anioAsientoContable;
	}

	public void setCargarid_anioAsientoContable(Boolean cargarid_anioAsientoContable) {
		this.cargarid_anioAsientoContable= cargarid_anioAsientoContable;
	}

	public Border setResaltarid_mesAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_mesAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesAsientoContable() {
		return this.resaltarid_mesAsientoContable;
	}

	public void setResaltarid_mesAsientoContable(Border borderResaltar) {
		this.resaltarid_mesAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_mesAsientoContable() {
		return this.mostrarid_mesAsientoContable;
	}

	public void setMostrarid_mesAsientoContable(Boolean mostrarid_mesAsientoContable) {
		this.mostrarid_mesAsientoContable= mostrarid_mesAsientoContable;
	}

	public Boolean getActivarid_mesAsientoContable() {
		return this.activarid_mesAsientoContable;
	}

	public void setActivarid_mesAsientoContable(Boolean activarid_mesAsientoContable) {
		this.activarid_mesAsientoContable= activarid_mesAsientoContable;
	}

	public Boolean getCargarid_mesAsientoContable() {
		return this.cargarid_mesAsientoContable;
	}

	public void setCargarid_mesAsientoContable(Boolean cargarid_mesAsientoContable) {
		this.cargarid_mesAsientoContable= cargarid_mesAsientoContable;
	}

	public Border setResaltarid_moduloAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_moduloAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloAsientoContable() {
		return this.resaltarid_moduloAsientoContable;
	}

	public void setResaltarid_moduloAsientoContable(Border borderResaltar) {
		this.resaltarid_moduloAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_moduloAsientoContable() {
		return this.mostrarid_moduloAsientoContable;
	}

	public void setMostrarid_moduloAsientoContable(Boolean mostrarid_moduloAsientoContable) {
		this.mostrarid_moduloAsientoContable= mostrarid_moduloAsientoContable;
	}

	public Boolean getActivarid_moduloAsientoContable() {
		return this.activarid_moduloAsientoContable;
	}

	public void setActivarid_moduloAsientoContable(Boolean activarid_moduloAsientoContable) {
		this.activarid_moduloAsientoContable= activarid_moduloAsientoContable;
	}

	public Boolean getCargarid_moduloAsientoContable() {
		return this.cargarid_moduloAsientoContable;
	}

	public void setCargarid_moduloAsientoContable(Boolean cargarid_moduloAsientoContable) {
		this.cargarid_moduloAsientoContable= cargarid_moduloAsientoContable;
	}

	public Border setResaltarid_usuarioAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_usuarioAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioAsientoContable() {
		return this.resaltarid_usuarioAsientoContable;
	}

	public void setResaltarid_usuarioAsientoContable(Border borderResaltar) {
		this.resaltarid_usuarioAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_usuarioAsientoContable() {
		return this.mostrarid_usuarioAsientoContable;
	}

	public void setMostrarid_usuarioAsientoContable(Boolean mostrarid_usuarioAsientoContable) {
		this.mostrarid_usuarioAsientoContable= mostrarid_usuarioAsientoContable;
	}

	public Boolean getActivarid_usuarioAsientoContable() {
		return this.activarid_usuarioAsientoContable;
	}

	public void setActivarid_usuarioAsientoContable(Boolean activarid_usuarioAsientoContable) {
		this.activarid_usuarioAsientoContable= activarid_usuarioAsientoContable;
	}

	public Boolean getCargarid_usuarioAsientoContable() {
		return this.cargarid_usuarioAsientoContable;
	}

	public void setCargarid_usuarioAsientoContable(Boolean cargarid_usuarioAsientoContable) {
		this.cargarid_usuarioAsientoContable= cargarid_usuarioAsientoContable;
	}

	public Border setResaltarid_tipo_documentoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_tipo_documentoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_documentoAsientoContable() {
		return this.resaltarid_tipo_documentoAsientoContable;
	}

	public void setResaltarid_tipo_documentoAsientoContable(Border borderResaltar) {
		this.resaltarid_tipo_documentoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_tipo_documentoAsientoContable() {
		return this.mostrarid_tipo_documentoAsientoContable;
	}

	public void setMostrarid_tipo_documentoAsientoContable(Boolean mostrarid_tipo_documentoAsientoContable) {
		this.mostrarid_tipo_documentoAsientoContable= mostrarid_tipo_documentoAsientoContable;
	}

	public Boolean getActivarid_tipo_documentoAsientoContable() {
		return this.activarid_tipo_documentoAsientoContable;
	}

	public void setActivarid_tipo_documentoAsientoContable(Boolean activarid_tipo_documentoAsientoContable) {
		this.activarid_tipo_documentoAsientoContable= activarid_tipo_documentoAsientoContable;
	}

	public Boolean getCargarid_tipo_documentoAsientoContable() {
		return this.cargarid_tipo_documentoAsientoContable;
	}

	public void setCargarid_tipo_documentoAsientoContable(Boolean cargarid_tipo_documentoAsientoContable) {
		this.cargarid_tipo_documentoAsientoContable= cargarid_tipo_documentoAsientoContable;
	}

	public Border setResaltarcodigoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarcodigoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoAsientoContable() {
		return this.resaltarcodigoAsientoContable;
	}

	public void setResaltarcodigoAsientoContable(Border borderResaltar) {
		this.resaltarcodigoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarcodigoAsientoContable() {
		return this.mostrarcodigoAsientoContable;
	}

	public void setMostrarcodigoAsientoContable(Boolean mostrarcodigoAsientoContable) {
		this.mostrarcodigoAsientoContable= mostrarcodigoAsientoContable;
	}

	public Boolean getActivarcodigoAsientoContable() {
		return this.activarcodigoAsientoContable;
	}

	public void setActivarcodigoAsientoContable(Boolean activarcodigoAsientoContable) {
		this.activarcodigoAsientoContable= activarcodigoAsientoContable;
	}

	public Border setResaltarfechaAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarfechaAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAsientoContable() {
		return this.resaltarfechaAsientoContable;
	}

	public void setResaltarfechaAsientoContable(Border borderResaltar) {
		this.resaltarfechaAsientoContable= borderResaltar;
	}

	public Boolean getMostrarfechaAsientoContable() {
		return this.mostrarfechaAsientoContable;
	}

	public void setMostrarfechaAsientoContable(Boolean mostrarfechaAsientoContable) {
		this.mostrarfechaAsientoContable= mostrarfechaAsientoContable;
	}

	public Boolean getActivarfechaAsientoContable() {
		return this.activarfechaAsientoContable;
	}

	public void setActivarfechaAsientoContable(Boolean activarfechaAsientoContable) {
		this.activarfechaAsientoContable= activarfechaAsientoContable;
	}

	public Border setResaltarid_tipo_movimientoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoAsientoContable() {
		return this.resaltarid_tipo_movimientoAsientoContable;
	}

	public void setResaltarid_tipo_movimientoAsientoContable(Border borderResaltar) {
		this.resaltarid_tipo_movimientoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoAsientoContable() {
		return this.mostrarid_tipo_movimientoAsientoContable;
	}

	public void setMostrarid_tipo_movimientoAsientoContable(Boolean mostrarid_tipo_movimientoAsientoContable) {
		this.mostrarid_tipo_movimientoAsientoContable= mostrarid_tipo_movimientoAsientoContable;
	}

	public Boolean getActivarid_tipo_movimientoAsientoContable() {
		return this.activarid_tipo_movimientoAsientoContable;
	}

	public void setActivarid_tipo_movimientoAsientoContable(Boolean activarid_tipo_movimientoAsientoContable) {
		this.activarid_tipo_movimientoAsientoContable= activarid_tipo_movimientoAsientoContable;
	}

	public Boolean getCargarid_tipo_movimientoAsientoContable() {
		return this.cargarid_tipo_movimientoAsientoContable;
	}

	public void setCargarid_tipo_movimientoAsientoContable(Boolean cargarid_tipo_movimientoAsientoContable) {
		this.cargarid_tipo_movimientoAsientoContable= cargarid_tipo_movimientoAsientoContable;
	}

	public Border setResaltarnumero_mayorAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorAsientoContable() {
		return this.resaltarnumero_mayorAsientoContable;
	}

	public void setResaltarnumero_mayorAsientoContable(Border borderResaltar) {
		this.resaltarnumero_mayorAsientoContable= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorAsientoContable() {
		return this.mostrarnumero_mayorAsientoContable;
	}

	public void setMostrarnumero_mayorAsientoContable(Boolean mostrarnumero_mayorAsientoContable) {
		this.mostrarnumero_mayorAsientoContable= mostrarnumero_mayorAsientoContable;
	}

	public Boolean getActivarnumero_mayorAsientoContable() {
		return this.activarnumero_mayorAsientoContable;
	}

	public void setActivarnumero_mayorAsientoContable(Boolean activarnumero_mayorAsientoContable) {
		this.activarnumero_mayorAsientoContable= activarnumero_mayorAsientoContable;
	}

	public Border setResaltarid_monedaAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_monedaAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaAsientoContable() {
		return this.resaltarid_monedaAsientoContable;
	}

	public void setResaltarid_monedaAsientoContable(Border borderResaltar) {
		this.resaltarid_monedaAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_monedaAsientoContable() {
		return this.mostrarid_monedaAsientoContable;
	}

	public void setMostrarid_monedaAsientoContable(Boolean mostrarid_monedaAsientoContable) {
		this.mostrarid_monedaAsientoContable= mostrarid_monedaAsientoContable;
	}

	public Boolean getActivarid_monedaAsientoContable() {
		return this.activarid_monedaAsientoContable;
	}

	public void setActivarid_monedaAsientoContable(Boolean activarid_monedaAsientoContable) {
		this.activarid_monedaAsientoContable= activarid_monedaAsientoContable;
	}

	public Boolean getCargarid_monedaAsientoContable() {
		return this.cargarid_monedaAsientoContable;
	}

	public void setCargarid_monedaAsientoContable(Boolean cargarid_monedaAsientoContable) {
		this.cargarid_monedaAsientoContable= cargarid_monedaAsientoContable;
	}

	public Border setResaltares_retencionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltares_retencionAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_retencionAsientoContable() {
		return this.resaltares_retencionAsientoContable;
	}

	public void setResaltares_retencionAsientoContable(Border borderResaltar) {
		this.resaltares_retencionAsientoContable= borderResaltar;
	}

	public Boolean getMostrares_retencionAsientoContable() {
		return this.mostrares_retencionAsientoContable;
	}

	public void setMostrares_retencionAsientoContable(Boolean mostrares_retencionAsientoContable) {
		this.mostrares_retencionAsientoContable= mostrares_retencionAsientoContable;
	}

	public Boolean getActivares_retencionAsientoContable() {
		return this.activares_retencionAsientoContable;
	}

	public void setActivares_retencionAsientoContable(Boolean activares_retencionAsientoContable) {
		this.activares_retencionAsientoContable= activares_retencionAsientoContable;
	}

	public Border setResaltarnumero_retencionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarnumero_retencionAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencionAsientoContable() {
		return this.resaltarnumero_retencionAsientoContable;
	}

	public void setResaltarnumero_retencionAsientoContable(Border borderResaltar) {
		this.resaltarnumero_retencionAsientoContable= borderResaltar;
	}

	public Boolean getMostrarnumero_retencionAsientoContable() {
		return this.mostrarnumero_retencionAsientoContable;
	}

	public void setMostrarnumero_retencionAsientoContable(Boolean mostrarnumero_retencionAsientoContable) {
		this.mostrarnumero_retencionAsientoContable= mostrarnumero_retencionAsientoContable;
	}

	public Boolean getActivarnumero_retencionAsientoContable() {
		return this.activarnumero_retencionAsientoContable;
	}

	public void setActivarnumero_retencionAsientoContable(Boolean activarnumero_retencionAsientoContable) {
		this.activarnumero_retencionAsientoContable= activarnumero_retencionAsientoContable;
	}

	public Border setResaltarvalorAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarvalorAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorAsientoContable() {
		return this.resaltarvalorAsientoContable;
	}

	public void setResaltarvalorAsientoContable(Border borderResaltar) {
		this.resaltarvalorAsientoContable= borderResaltar;
	}

	public Boolean getMostrarvalorAsientoContable() {
		return this.mostrarvalorAsientoContable;
	}

	public void setMostrarvalorAsientoContable(Boolean mostrarvalorAsientoContable) {
		this.mostrarvalorAsientoContable= mostrarvalorAsientoContable;
	}

	public Boolean getActivarvalorAsientoContable() {
		return this.activarvalorAsientoContable;
	}

	public void setActivarvalorAsientoContable(Boolean activarvalorAsientoContable) {
		this.activarvalorAsientoContable= activarvalorAsientoContable;
	}

	public Border setResaltares_retencion_ivaAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltares_retencion_ivaAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_retencion_ivaAsientoContable() {
		return this.resaltares_retencion_ivaAsientoContable;
	}

	public void setResaltares_retencion_ivaAsientoContable(Border borderResaltar) {
		this.resaltares_retencion_ivaAsientoContable= borderResaltar;
	}

	public Boolean getMostrares_retencion_ivaAsientoContable() {
		return this.mostrares_retencion_ivaAsientoContable;
	}

	public void setMostrares_retencion_ivaAsientoContable(Boolean mostrares_retencion_ivaAsientoContable) {
		this.mostrares_retencion_ivaAsientoContable= mostrares_retencion_ivaAsientoContable;
	}

	public Boolean getActivares_retencion_ivaAsientoContable() {
		return this.activares_retencion_ivaAsientoContable;
	}

	public void setActivares_retencion_ivaAsientoContable(Boolean activares_retencion_ivaAsientoContable) {
		this.activares_retencion_ivaAsientoContable= activares_retencion_ivaAsientoContable;
	}

	public Border setResaltarnumero_retencion_ivaAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarnumero_retencion_ivaAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_retencion_ivaAsientoContable() {
		return this.resaltarnumero_retencion_ivaAsientoContable;
	}

	public void setResaltarnumero_retencion_ivaAsientoContable(Border borderResaltar) {
		this.resaltarnumero_retencion_ivaAsientoContable= borderResaltar;
	}

	public Boolean getMostrarnumero_retencion_ivaAsientoContable() {
		return this.mostrarnumero_retencion_ivaAsientoContable;
	}

	public void setMostrarnumero_retencion_ivaAsientoContable(Boolean mostrarnumero_retencion_ivaAsientoContable) {
		this.mostrarnumero_retencion_ivaAsientoContable= mostrarnumero_retencion_ivaAsientoContable;
	}

	public Boolean getActivarnumero_retencion_ivaAsientoContable() {
		return this.activarnumero_retencion_ivaAsientoContable;
	}

	public void setActivarnumero_retencion_ivaAsientoContable(Boolean activarnumero_retencion_ivaAsientoContable) {
		this.activarnumero_retencion_ivaAsientoContable= activarnumero_retencion_ivaAsientoContable;
	}

	public Border setResaltarcotizacionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarcotizacionAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionAsientoContable() {
		return this.resaltarcotizacionAsientoContable;
	}

	public void setResaltarcotizacionAsientoContable(Border borderResaltar) {
		this.resaltarcotizacionAsientoContable= borderResaltar;
	}

	public Boolean getMostrarcotizacionAsientoContable() {
		return this.mostrarcotizacionAsientoContable;
	}

	public void setMostrarcotizacionAsientoContable(Boolean mostrarcotizacionAsientoContable) {
		this.mostrarcotizacionAsientoContable= mostrarcotizacionAsientoContable;
	}

	public Boolean getActivarcotizacionAsientoContable() {
		return this.activarcotizacionAsientoContable;
	}

	public void setActivarcotizacionAsientoContable(Boolean activarcotizacionAsientoContable) {
		this.activarcotizacionAsientoContable= activarcotizacionAsientoContable;
	}

	public Border setResaltarid_clienteAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_clienteAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteAsientoContable() {
		return this.resaltarid_clienteAsientoContable;
	}

	public void setResaltarid_clienteAsientoContable(Border borderResaltar) {
		this.resaltarid_clienteAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_clienteAsientoContable() {
		return this.mostrarid_clienteAsientoContable;
	}

	public void setMostrarid_clienteAsientoContable(Boolean mostrarid_clienteAsientoContable) {
		this.mostrarid_clienteAsientoContable= mostrarid_clienteAsientoContable;
	}

	public Boolean getActivarid_clienteAsientoContable() {
		return this.activarid_clienteAsientoContable;
	}

	public void setActivarid_clienteAsientoContable(Boolean activarid_clienteAsientoContable) {
		this.activarid_clienteAsientoContable= activarid_clienteAsientoContable;
	}

	public Boolean getCargarid_clienteAsientoContable() {
		return this.cargarid_clienteAsientoContable;
	}

	public void setCargarid_clienteAsientoContable(Boolean cargarid_clienteAsientoContable) {
		this.cargarid_clienteAsientoContable= cargarid_clienteAsientoContable;
	}

	public Border setResaltarid_tipo_descripcion_asientoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_tipo_descripcion_asientoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_descripcion_asientoAsientoContable() {
		return this.resaltarid_tipo_descripcion_asientoAsientoContable;
	}

	public void setResaltarid_tipo_descripcion_asientoAsientoContable(Border borderResaltar) {
		this.resaltarid_tipo_descripcion_asientoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_tipo_descripcion_asientoAsientoContable() {
		return this.mostrarid_tipo_descripcion_asientoAsientoContable;
	}

	public void setMostrarid_tipo_descripcion_asientoAsientoContable(Boolean mostrarid_tipo_descripcion_asientoAsientoContable) {
		this.mostrarid_tipo_descripcion_asientoAsientoContable= mostrarid_tipo_descripcion_asientoAsientoContable;
	}

	public Boolean getActivarid_tipo_descripcion_asientoAsientoContable() {
		return this.activarid_tipo_descripcion_asientoAsientoContable;
	}

	public void setActivarid_tipo_descripcion_asientoAsientoContable(Boolean activarid_tipo_descripcion_asientoAsientoContable) {
		this.activarid_tipo_descripcion_asientoAsientoContable= activarid_tipo_descripcion_asientoAsientoContable;
	}

	public Boolean getCargarid_tipo_descripcion_asientoAsientoContable() {
		return this.cargarid_tipo_descripcion_asientoAsientoContable;
	}

	public void setCargarid_tipo_descripcion_asientoAsientoContable(Boolean cargarid_tipo_descripcion_asientoAsientoContable) {
		this.cargarid_tipo_descripcion_asientoAsientoContable= cargarid_tipo_descripcion_asientoAsientoContable;
	}

	public Border setResaltarid_formatoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_formatoAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoAsientoContable() {
		return this.resaltarid_formatoAsientoContable;
	}

	public void setResaltarid_formatoAsientoContable(Border borderResaltar) {
		this.resaltarid_formatoAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_formatoAsientoContable() {
		return this.mostrarid_formatoAsientoContable;
	}

	public void setMostrarid_formatoAsientoContable(Boolean mostrarid_formatoAsientoContable) {
		this.mostrarid_formatoAsientoContable= mostrarid_formatoAsientoContable;
	}

	public Boolean getActivarid_formatoAsientoContable() {
		return this.activarid_formatoAsientoContable;
	}

	public void setActivarid_formatoAsientoContable(Boolean activarid_formatoAsientoContable) {
		this.activarid_formatoAsientoContable= activarid_formatoAsientoContable;
	}

	public Boolean getCargarid_formatoAsientoContable() {
		return this.cargarid_formatoAsientoContable;
	}

	public void setCargarid_formatoAsientoContable(Boolean cargarid_formatoAsientoContable) {
		this.cargarid_formatoAsientoContable= cargarid_formatoAsientoContable;
	}

	public Border setResaltarbeneficiarioAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioAsientoContable() {
		return this.resaltarbeneficiarioAsientoContable;
	}

	public void setResaltarbeneficiarioAsientoContable(Border borderResaltar) {
		this.resaltarbeneficiarioAsientoContable= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioAsientoContable() {
		return this.mostrarbeneficiarioAsientoContable;
	}

	public void setMostrarbeneficiarioAsientoContable(Boolean mostrarbeneficiarioAsientoContable) {
		this.mostrarbeneficiarioAsientoContable= mostrarbeneficiarioAsientoContable;
	}

	public Boolean getActivarbeneficiarioAsientoContable() {
		return this.activarbeneficiarioAsientoContable;
	}

	public void setActivarbeneficiarioAsientoContable(Boolean activarbeneficiarioAsientoContable) {
		this.activarbeneficiarioAsientoContable= activarbeneficiarioAsientoContable;
	}

	public Border setResaltardescripcionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltardescripcionAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionAsientoContable() {
		return this.resaltardescripcionAsientoContable;
	}

	public void setResaltardescripcionAsientoContable(Border borderResaltar) {
		this.resaltardescripcionAsientoContable= borderResaltar;
	}

	public Boolean getMostrardescripcionAsientoContable() {
		return this.mostrardescripcionAsientoContable;
	}

	public void setMostrardescripcionAsientoContable(Boolean mostrardescripcionAsientoContable) {
		this.mostrardescripcionAsientoContable= mostrardescripcionAsientoContable;
	}

	public Boolean getActivardescripcionAsientoContable() {
		return this.activardescripcionAsientoContable;
	}

	public void setActivardescripcionAsientoContable(Boolean activardescripcionAsientoContable) {
		this.activardescripcionAsientoContable= activardescripcionAsientoContable;
	}

	public Border setResaltarfecha_emisionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionAsientoContable() {
		return this.resaltarfecha_emisionAsientoContable;
	}

	public void setResaltarfecha_emisionAsientoContable(Border borderResaltar) {
		this.resaltarfecha_emisionAsientoContable= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionAsientoContable() {
		return this.mostrarfecha_emisionAsientoContable;
	}

	public void setMostrarfecha_emisionAsientoContable(Boolean mostrarfecha_emisionAsientoContable) {
		this.mostrarfecha_emisionAsientoContable= mostrarfecha_emisionAsientoContable;
	}

	public Boolean getActivarfecha_emisionAsientoContable() {
		return this.activarfecha_emisionAsientoContable;
	}

	public void setActivarfecha_emisionAsientoContable(Boolean activarfecha_emisionAsientoContable) {
		this.activarfecha_emisionAsientoContable= activarfecha_emisionAsientoContable;
	}

	public Border setResaltarfecha_finalizacionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarfecha_finalizacionAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finalizacionAsientoContable() {
		return this.resaltarfecha_finalizacionAsientoContable;
	}

	public void setResaltarfecha_finalizacionAsientoContable(Border borderResaltar) {
		this.resaltarfecha_finalizacionAsientoContable= borderResaltar;
	}

	public Boolean getMostrarfecha_finalizacionAsientoContable() {
		return this.mostrarfecha_finalizacionAsientoContable;
	}

	public void setMostrarfecha_finalizacionAsientoContable(Boolean mostrarfecha_finalizacionAsientoContable) {
		this.mostrarfecha_finalizacionAsientoContable= mostrarfecha_finalizacionAsientoContable;
	}

	public Boolean getActivarfecha_finalizacionAsientoContable() {
		return this.activarfecha_finalizacionAsientoContable;
	}

	public void setActivarfecha_finalizacionAsientoContable(Boolean activarfecha_finalizacionAsientoContable) {
		this.activarfecha_finalizacionAsientoContable= activarfecha_finalizacionAsientoContable;
	}

	public Border setResaltarid_estado_asiento_contableAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_estado_asiento_contableAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_asiento_contableAsientoContable() {
		return this.resaltarid_estado_asiento_contableAsientoContable;
	}

	public void setResaltarid_estado_asiento_contableAsientoContable(Border borderResaltar) {
		this.resaltarid_estado_asiento_contableAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_estado_asiento_contableAsientoContable() {
		return this.mostrarid_estado_asiento_contableAsientoContable;
	}

	public void setMostrarid_estado_asiento_contableAsientoContable(Boolean mostrarid_estado_asiento_contableAsientoContable) {
		this.mostrarid_estado_asiento_contableAsientoContable= mostrarid_estado_asiento_contableAsientoContable;
	}

	public Boolean getActivarid_estado_asiento_contableAsientoContable() {
		return this.activarid_estado_asiento_contableAsientoContable;
	}

	public void setActivarid_estado_asiento_contableAsientoContable(Boolean activarid_estado_asiento_contableAsientoContable) {
		this.activarid_estado_asiento_contableAsientoContable= activarid_estado_asiento_contableAsientoContable;
	}

	public Boolean getCargarid_estado_asiento_contableAsientoContable() {
		return this.cargarid_estado_asiento_contableAsientoContable;
	}

	public void setCargarid_estado_asiento_contableAsientoContable(Boolean cargarid_estado_asiento_contableAsientoContable) {
		this.cargarid_estado_asiento_contableAsientoContable= cargarid_estado_asiento_contableAsientoContable;
	}

	public Border setResaltarid_tipo_movimiento_moduloAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimiento_moduloAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimiento_moduloAsientoContable() {
		return this.resaltarid_tipo_movimiento_moduloAsientoContable;
	}

	public void setResaltarid_tipo_movimiento_moduloAsientoContable(Border borderResaltar) {
		this.resaltarid_tipo_movimiento_moduloAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimiento_moduloAsientoContable() {
		return this.mostrarid_tipo_movimiento_moduloAsientoContable;
	}

	public void setMostrarid_tipo_movimiento_moduloAsientoContable(Boolean mostrarid_tipo_movimiento_moduloAsientoContable) {
		this.mostrarid_tipo_movimiento_moduloAsientoContable= mostrarid_tipo_movimiento_moduloAsientoContable;
	}

	public Boolean getActivarid_tipo_movimiento_moduloAsientoContable() {
		return this.activarid_tipo_movimiento_moduloAsientoContable;
	}

	public void setActivarid_tipo_movimiento_moduloAsientoContable(Boolean activarid_tipo_movimiento_moduloAsientoContable) {
		this.activarid_tipo_movimiento_moduloAsientoContable= activarid_tipo_movimiento_moduloAsientoContable;
	}

	public Boolean getCargarid_tipo_movimiento_moduloAsientoContable() {
		return this.cargarid_tipo_movimiento_moduloAsientoContable;
	}

	public void setCargarid_tipo_movimiento_moduloAsientoContable(Boolean cargarid_tipo_movimiento_moduloAsientoContable) {
		this.cargarid_tipo_movimiento_moduloAsientoContable= cargarid_tipo_movimiento_moduloAsientoContable;
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
		
		
		this.setMostraridAsientoContable(esInicial);
		this.setMostrarid_empresaAsientoContable(esInicial);
		this.setMostrarid_sucursalAsientoContable(esInicial);
		this.setMostrarid_ejercicioAsientoContable(esInicial);
		this.setMostrarid_periodoAsientoContable(esInicial);
		this.setMostrarid_anioAsientoContable(esInicial);
		this.setMostrarid_mesAsientoContable(esInicial);
		this.setMostrarid_moduloAsientoContable(esInicial);
		this.setMostrarid_usuarioAsientoContable(esInicial);
		this.setMostrarid_tipo_documentoAsientoContable(esInicial);
		this.setMostrarcodigoAsientoContable(esInicial);
		this.setMostrarfechaAsientoContable(esInicial);
		this.setMostrarid_tipo_movimientoAsientoContable(esInicial);
		this.setMostrarnumero_mayorAsientoContable(esInicial);
		this.setMostrarid_monedaAsientoContable(esInicial);
		this.setMostrares_retencionAsientoContable(esInicial);
		this.setMostrarnumero_retencionAsientoContable(esInicial);
		this.setMostrarvalorAsientoContable(esInicial);
		this.setMostrares_retencion_ivaAsientoContable(esInicial);
		this.setMostrarnumero_retencion_ivaAsientoContable(esInicial);
		this.setMostrarcotizacionAsientoContable(esInicial);
		this.setMostrarid_clienteAsientoContable(esInicial);
		this.setMostrarid_tipo_descripcion_asientoAsientoContable(esInicial);
		this.setMostrarid_formatoAsientoContable(esInicial);
		this.setMostrarbeneficiarioAsientoContable(esInicial);
		this.setMostrardescripcionAsientoContable(esInicial);
		this.setMostrarfecha_emisionAsientoContable(esInicial);
		this.setMostrarfecha_finalizacionAsientoContable(esInicial);
		this.setMostrarid_estado_asiento_contableAsientoContable(esInicial);
		this.setMostrarid_tipo_movimiento_moduloAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsientoContableConstantesFunciones.ID)) {
				this.setMostraridAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMES)) {
				this.setMostrarid_mesAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setMostrarid_tipo_documentoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHA)) {
				this.setMostrarfechaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.ESRETENCION)) {
				this.setMostrares_retencionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMERORETENCION)) {
				this.setMostrarnumero_retencionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.VALOR)) {
				this.setMostrarvalorAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.ESRETENCIONIVA)) {
				this.setMostrares_retencion_ivaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMERORETENCIONIVA)) {
				this.setMostrarnumero_retencion_ivaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO)) {
				this.setMostrarid_tipo_descripcion_asientoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHAFINALIZACION)) {
				this.setMostrarfecha_finalizacionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE)) {
				this.setMostrarid_estado_asiento_contableAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setMostrarid_tipo_movimiento_moduloAsientoContable(esAsigna);
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
		
		
		this.setActivaridAsientoContable(esInicial);
		this.setActivarid_empresaAsientoContable(esInicial);
		this.setActivarid_sucursalAsientoContable(esInicial);
		this.setActivarid_ejercicioAsientoContable(esInicial);
		this.setActivarid_periodoAsientoContable(esInicial);
		this.setActivarid_anioAsientoContable(esInicial);
		this.setActivarid_mesAsientoContable(esInicial);
		this.setActivarid_moduloAsientoContable(esInicial);
		this.setActivarid_usuarioAsientoContable(esInicial);
		this.setActivarid_tipo_documentoAsientoContable(esInicial);
		this.setActivarcodigoAsientoContable(esInicial);
		this.setActivarfechaAsientoContable(esInicial);
		this.setActivarid_tipo_movimientoAsientoContable(esInicial);
		this.setActivarnumero_mayorAsientoContable(esInicial);
		this.setActivarid_monedaAsientoContable(esInicial);
		this.setActivares_retencionAsientoContable(esInicial);
		this.setActivarnumero_retencionAsientoContable(esInicial);
		this.setActivarvalorAsientoContable(esInicial);
		this.setActivares_retencion_ivaAsientoContable(esInicial);
		this.setActivarnumero_retencion_ivaAsientoContable(esInicial);
		this.setActivarcotizacionAsientoContable(esInicial);
		this.setActivarid_clienteAsientoContable(esInicial);
		this.setActivarid_tipo_descripcion_asientoAsientoContable(esInicial);
		this.setActivarid_formatoAsientoContable(esInicial);
		this.setActivarbeneficiarioAsientoContable(esInicial);
		this.setActivardescripcionAsientoContable(esInicial);
		this.setActivarfecha_emisionAsientoContable(esInicial);
		this.setActivarfecha_finalizacionAsientoContable(esInicial);
		this.setActivarid_estado_asiento_contableAsientoContable(esInicial);
		this.setActivarid_tipo_movimiento_moduloAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsientoContableConstantesFunciones.ID)) {
				this.setActivaridAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDANIO)) {
				this.setActivarid_anioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMES)) {
				this.setActivarid_mesAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setActivarid_tipo_documentoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.CODIGO)) {
				this.setActivarcodigoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHA)) {
				this.setActivarfechaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.ESRETENCION)) {
				this.setActivares_retencionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMERORETENCION)) {
				this.setActivarnumero_retencionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.VALOR)) {
				this.setActivarvalorAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.ESRETENCIONIVA)) {
				this.setActivares_retencion_ivaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMERORETENCIONIVA)) {
				this.setActivarnumero_retencion_ivaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO)) {
				this.setActivarid_tipo_descripcion_asientoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHAFINALIZACION)) {
				this.setActivarfecha_finalizacionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE)) {
				this.setActivarid_estado_asiento_contableAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setActivarid_tipo_movimiento_moduloAsientoContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAsientoContable(esInicial);
		this.setResaltarid_empresaAsientoContable(esInicial);
		this.setResaltarid_sucursalAsientoContable(esInicial);
		this.setResaltarid_ejercicioAsientoContable(esInicial);
		this.setResaltarid_periodoAsientoContable(esInicial);
		this.setResaltarid_anioAsientoContable(esInicial);
		this.setResaltarid_mesAsientoContable(esInicial);
		this.setResaltarid_moduloAsientoContable(esInicial);
		this.setResaltarid_usuarioAsientoContable(esInicial);
		this.setResaltarid_tipo_documentoAsientoContable(esInicial);
		this.setResaltarcodigoAsientoContable(esInicial);
		this.setResaltarfechaAsientoContable(esInicial);
		this.setResaltarid_tipo_movimientoAsientoContable(esInicial);
		this.setResaltarnumero_mayorAsientoContable(esInicial);
		this.setResaltarid_monedaAsientoContable(esInicial);
		this.setResaltares_retencionAsientoContable(esInicial);
		this.setResaltarnumero_retencionAsientoContable(esInicial);
		this.setResaltarvalorAsientoContable(esInicial);
		this.setResaltares_retencion_ivaAsientoContable(esInicial);
		this.setResaltarnumero_retencion_ivaAsientoContable(esInicial);
		this.setResaltarcotizacionAsientoContable(esInicial);
		this.setResaltarid_clienteAsientoContable(esInicial);
		this.setResaltarid_tipo_descripcion_asientoAsientoContable(esInicial);
		this.setResaltarid_formatoAsientoContable(esInicial);
		this.setResaltarbeneficiarioAsientoContable(esInicial);
		this.setResaltardescripcionAsientoContable(esInicial);
		this.setResaltarfecha_emisionAsientoContable(esInicial);
		this.setResaltarfecha_finalizacionAsientoContable(esInicial);
		this.setResaltarid_estado_asiento_contableAsientoContable(esInicial);
		this.setResaltarid_tipo_movimiento_moduloAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AsientoContableConstantesFunciones.ID)) {
				this.setResaltaridAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMES)) {
				this.setResaltarid_mesAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPODOCUMENTO)) {
				this.setResaltarid_tipo_documentoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHA)) {
				this.setResaltarfechaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.ESRETENCION)) {
				this.setResaltares_retencionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMERORETENCION)) {
				this.setResaltarnumero_retencionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.VALOR)) {
				this.setResaltarvalorAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.ESRETENCIONIVA)) {
				this.setResaltares_retencion_ivaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.NUMERORETENCIONIVA)) {
				this.setResaltarnumero_retencion_ivaAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO)) {
				this.setResaltarid_tipo_descripcion_asientoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.FECHAFINALIZACION)) {
				this.setResaltarfecha_finalizacionAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE)) {
				this.setResaltarid_estado_asiento_contableAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO)) {
				this.setResaltarid_tipo_movimiento_moduloAsientoContable(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarSriAsientoContable=null;

	public Border getResaltarSriAsientoContable() {
		return this.resaltarSriAsientoContable;
	}

	public void setResaltarSriAsientoContable(Border borderResaltarSri) {
		if(borderResaltarSri!=null) {
			this.resaltarSriAsientoContable= borderResaltarSri;
		}
	}

	public Border setResaltarSriAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarSri=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltarSri);
			
		this.resaltarSriAsientoContable= borderResaltarSri;

		 return borderResaltarSri;
	}



	public Boolean mostrarSriAsientoContable=true;

	public Boolean getMostrarSriAsientoContable() {
		return this.mostrarSriAsientoContable;
	}

	public void setMostrarSriAsientoContable(Boolean visibilidadResaltarSri) {
		this.mostrarSriAsientoContable= visibilidadResaltarSri;
	}



	public Boolean activarSriAsientoContable=true;

	public Boolean gethabilitarResaltarSriAsientoContable() {
		return this.activarSriAsientoContable;
	}

	public void setActivarSriAsientoContable(Boolean habilitarResaltarSri) {
		this.activarSriAsientoContable= habilitarResaltarSri;
	}


	public Border resaltarImportarExportarAsientoContable=null;

	public Border getResaltarImportarExportarAsientoContable() {
		return this.resaltarImportarExportarAsientoContable;
	}

	public void setResaltarImportarExportarAsientoContable(Border borderResaltarImportarExportar) {
		if(borderResaltarImportarExportar!=null) {
			this.resaltarImportarExportarAsientoContable= borderResaltarImportarExportar;
		}
	}

	public Border setResaltarImportarExportarAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarImportarExportar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltarImportarExportar);
			
		this.resaltarImportarExportarAsientoContable= borderResaltarImportarExportar;

		 return borderResaltarImportarExportar;
	}



	public Boolean mostrarImportarExportarAsientoContable=true;

	public Boolean getMostrarImportarExportarAsientoContable() {
		return this.mostrarImportarExportarAsientoContable;
	}

	public void setMostrarImportarExportarAsientoContable(Boolean visibilidadResaltarImportarExportar) {
		this.mostrarImportarExportarAsientoContable= visibilidadResaltarImportarExportar;
	}



	public Boolean activarImportarExportarAsientoContable=true;

	public Boolean gethabilitarResaltarImportarExportarAsientoContable() {
		return this.activarImportarExportarAsientoContable;
	}

	public void setActivarImportarExportarAsientoContable(Boolean habilitarResaltarImportarExportar) {
		this.activarImportarExportarAsientoContable= habilitarResaltarImportarExportar;
	}


	public Border resaltarDetalleMoviClienProveAsientoContable=null;

	public Border getResaltarDetalleMoviClienProveAsientoContable() {
		return this.resaltarDetalleMoviClienProveAsientoContable;
	}

	public void setResaltarDetalleMoviClienProveAsientoContable(Border borderResaltarDetalleMoviClienProve) {
		if(borderResaltarDetalleMoviClienProve!=null) {
			this.resaltarDetalleMoviClienProveAsientoContable= borderResaltarDetalleMoviClienProve;
		}
	}

	public Border setResaltarDetalleMoviClienProveAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleMoviClienProve=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltarDetalleMoviClienProve);
			
		this.resaltarDetalleMoviClienProveAsientoContable= borderResaltarDetalleMoviClienProve;

		 return borderResaltarDetalleMoviClienProve;
	}



	public Boolean mostrarDetalleMoviClienProveAsientoContable=true;

	public Boolean getMostrarDetalleMoviClienProveAsientoContable() {
		return this.mostrarDetalleMoviClienProveAsientoContable;
	}

	public void setMostrarDetalleMoviClienProveAsientoContable(Boolean visibilidadResaltarDetalleMoviClienProve) {
		this.mostrarDetalleMoviClienProveAsientoContable= visibilidadResaltarDetalleMoviClienProve;
	}



	public Boolean activarDetalleMoviClienProveAsientoContable=true;

	public Boolean gethabilitarResaltarDetalleMoviClienProveAsientoContable() {
		return this.activarDetalleMoviClienProveAsientoContable;
	}

	public void setActivarDetalleMoviClienProveAsientoContable(Boolean habilitarResaltarDetalleMoviClienProve) {
		this.activarDetalleMoviClienProveAsientoContable= habilitarResaltarDetalleMoviClienProve;
	}


	public Border resaltarPrestamoAsientoContable=null;

	public Border getResaltarPrestamoAsientoContable() {
		return this.resaltarPrestamoAsientoContable;
	}

	public void setResaltarPrestamoAsientoContable(Border borderResaltarPrestamo) {
		if(borderResaltarPrestamo!=null) {
			this.resaltarPrestamoAsientoContable= borderResaltarPrestamo;
		}
	}

	public Border setResaltarPrestamoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarPrestamo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltarPrestamo);
			
		this.resaltarPrestamoAsientoContable= borderResaltarPrestamo;

		 return borderResaltarPrestamo;
	}



	public Boolean mostrarPrestamoAsientoContable=true;

	public Boolean getMostrarPrestamoAsientoContable() {
		return this.mostrarPrestamoAsientoContable;
	}

	public void setMostrarPrestamoAsientoContable(Boolean visibilidadResaltarPrestamo) {
		this.mostrarPrestamoAsientoContable= visibilidadResaltarPrestamo;
	}



	public Boolean activarPrestamoAsientoContable=true;

	public Boolean gethabilitarResaltarPrestamoAsientoContable() {
		return this.activarPrestamoAsientoContable;
	}

	public void setActivarPrestamoAsientoContable(Boolean habilitarResaltarPrestamo) {
		this.activarPrestamoAsientoContable= habilitarResaltarPrestamo;
	}


	public Border resaltarDetalleAsientoContableAsientoContable=null;

	public Border getResaltarDetalleAsientoContableAsientoContable() {
		return this.resaltarDetalleAsientoContableAsientoContable;
	}

	public void setResaltarDetalleAsientoContableAsientoContable(Border borderResaltarDetalleAsientoContable) {
		if(borderResaltarDetalleAsientoContable!=null) {
			this.resaltarDetalleAsientoContableAsientoContable= borderResaltarDetalleAsientoContable;
		}
	}

	public Border setResaltarDetalleAsientoContableAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleAsientoContable=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltarDetalleAsientoContable);
			
		this.resaltarDetalleAsientoContableAsientoContable= borderResaltarDetalleAsientoContable;

		 return borderResaltarDetalleAsientoContable;
	}



	public Boolean mostrarDetalleAsientoContableAsientoContable=true;

	public Boolean getMostrarDetalleAsientoContableAsientoContable() {
		return this.mostrarDetalleAsientoContableAsientoContable;
	}

	public void setMostrarDetalleAsientoContableAsientoContable(Boolean visibilidadResaltarDetalleAsientoContable) {
		this.mostrarDetalleAsientoContableAsientoContable= visibilidadResaltarDetalleAsientoContable;
	}



	public Boolean activarDetalleAsientoContableAsientoContable=true;

	public Boolean gethabilitarResaltarDetalleAsientoContableAsientoContable() {
		return this.activarDetalleAsientoContableAsientoContable;
	}

	public void setActivarDetalleAsientoContableAsientoContable(Boolean habilitarResaltarDetalleAsientoContable) {
		this.activarDetalleAsientoContableAsientoContable= habilitarResaltarDetalleAsientoContable;
	}


	public Border resaltarRetencionAsientoContable=null;

	public Border getResaltarRetencionAsientoContable() {
		return this.resaltarRetencionAsientoContable;
	}

	public void setResaltarRetencionAsientoContable(Border borderResaltarRetencion) {
		if(borderResaltarRetencion!=null) {
			this.resaltarRetencionAsientoContable= borderResaltarRetencion;
		}
	}

	public Border setResaltarRetencionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltarRetencion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//asientocontableBeanSwingJInternalFrame.jTtoolBarAsientoContable.setBorder(borderResaltarRetencion);
			
		this.resaltarRetencionAsientoContable= borderResaltarRetencion;

		 return borderResaltarRetencion;
	}



	public Boolean mostrarRetencionAsientoContable=true;

	public Boolean getMostrarRetencionAsientoContable() {
		return this.mostrarRetencionAsientoContable;
	}

	public void setMostrarRetencionAsientoContable(Boolean visibilidadResaltarRetencion) {
		this.mostrarRetencionAsientoContable= visibilidadResaltarRetencion;
	}



	public Boolean activarRetencionAsientoContable=true;

	public Boolean gethabilitarResaltarRetencionAsientoContable() {
		return this.activarRetencionAsientoContable;
	}

	public void setActivarRetencionAsientoContable(Boolean habilitarResaltarRetencion) {
		this.activarRetencionAsientoContable= habilitarResaltarRetencion;
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

		this.setMostrarSriAsientoContable(esInicial);
		this.setMostrarImportarExportarAsientoContable(esInicial);
		this.setMostrarDetalleMoviClienProveAsientoContable(esInicial);
		this.setMostrarPrestamoAsientoContable(esInicial);
		this.setMostrarDetalleAsientoContableAsientoContable(esInicial);
		this.setMostrarRetencionAsientoContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Sri.class)) {
				this.setMostrarSriAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(ImportarExportar.class)) {
				this.setMostrarImportarExportarAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMoviClienProve.class)) {
				this.setMostrarDetalleMoviClienProveAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Prestamo.class)) {
				this.setMostrarPrestamoAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleAsientoContable.class)) {
				this.setMostrarDetalleAsientoContableAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Retencion.class)) {
				this.setMostrarRetencionAsientoContable(esAsigna);
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

		this.setActivarSriAsientoContable(esInicial);
		this.setActivarImportarExportarAsientoContable(esInicial);
		this.setActivarDetalleMoviClienProveAsientoContable(esInicial);
		this.setActivarPrestamoAsientoContable(esInicial);
		this.setActivarDetalleAsientoContableAsientoContable(esInicial);
		this.setActivarRetencionAsientoContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Sri.class)) {
				this.setActivarSriAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(ImportarExportar.class)) {
				this.setActivarImportarExportarAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMoviClienProve.class)) {
				this.setActivarDetalleMoviClienProveAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Prestamo.class)) {
				this.setActivarPrestamoAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleAsientoContable.class)) {
				this.setActivarDetalleAsientoContableAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Retencion.class)) {
				this.setActivarRetencionAsientoContable(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarSriAsientoContable(esInicial);
		this.setResaltarImportarExportarAsientoContable(esInicial);
		this.setResaltarDetalleMoviClienProveAsientoContable(esInicial);
		this.setResaltarPrestamoAsientoContable(esInicial);
		this.setResaltarDetalleAsientoContableAsientoContable(esInicial);
		this.setResaltarRetencionAsientoContable(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Sri.class)) {
				this.setResaltarSriAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(ImportarExportar.class)) {
				this.setResaltarImportarExportarAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleMoviClienProve.class)) {
				this.setResaltarDetalleMoviClienProveAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Prestamo.class)) {
				this.setResaltarPrestamoAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleAsientoContable.class)) {
				this.setResaltarDetalleAsientoContableAsientoContable(esAsigna);
				continue;
			}

			if(clase.clas.equals(Retencion.class)) {
				this.setResaltarRetencionAsientoContable(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorBeneficiarioAsientoContable=true;

	public Boolean getMostrarBusquedaPorBeneficiarioAsientoContable() {
		return this.mostrarBusquedaPorBeneficiarioAsientoContable;
	}

	public void setMostrarBusquedaPorBeneficiarioAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorBeneficiarioAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorCodigoAsientoContable=true;

	public Boolean getMostrarBusquedaPorCodigoAsientoContable() {
		return this.mostrarBusquedaPorCodigoAsientoContable;
	}

	public void setMostrarBusquedaPorCodigoAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorFechaEmisionAsientoContable=true;

	public Boolean getMostrarBusquedaPorFechaEmisionAsientoContable() {
		return this.mostrarBusquedaPorFechaEmisionAsientoContable;
	}

	public void setMostrarBusquedaPorFechaEmisionAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorFechaEmisionAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNumeroMayorAsientoContable=true;

	public Boolean getMostrarBusquedaPorNumeroMayorAsientoContable() {
		return this.mostrarBusquedaPorNumeroMayorAsientoContable;
	}

	public void setMostrarBusquedaPorNumeroMayorAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroMayorAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNumeroRetencionAsientoContable=true;

	public Boolean getMostrarBusquedaPorNumeroRetencionAsientoContable() {
		return this.mostrarBusquedaPorNumeroRetencionAsientoContable;
	}

	public void setMostrarBusquedaPorNumeroRetencionAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroRetencionAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorValorAsientoContable=true;

	public Boolean getMostrarBusquedaPorValorAsientoContable() {
		return this.mostrarBusquedaPorValorAsientoContable;
	}

	public void setMostrarBusquedaPorValorAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorValorAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteAsientoContable=true;

	public Boolean getMostrarFK_IdClienteAsientoContable() {
		return this.mostrarFK_IdClienteAsientoContable;
	}

	public void setMostrarFK_IdClienteAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioAsientoContable=true;

	public Boolean getMostrarFK_IdEjercicioAsientoContable() {
		return this.mostrarFK_IdEjercicioAsientoContable;
	}

	public void setMostrarFK_IdEjercicioAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAsientoContable=true;

	public Boolean getMostrarFK_IdEmpresaAsientoContable() {
		return this.mostrarFK_IdEmpresaAsientoContable;
	}

	public void setMostrarFK_IdEmpresaAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloAsientoContable=true;

	public Boolean getMostrarFK_IdModuloAsientoContable() {
		return this.mostrarFK_IdModuloAsientoContable;
	}

	public void setMostrarFK_IdModuloAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoAsientoContable=true;

	public Boolean getMostrarFK_IdPeriodoAsientoContable() {
		return this.mostrarFK_IdPeriodoAsientoContable;
	}

	public void setMostrarFK_IdPeriodoAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalAsientoContable=true;

	public Boolean getMostrarFK_IdSucursalAsientoContable() {
		return this.mostrarFK_IdSucursalAsientoContable;
	}

	public void setMostrarFK_IdSucursalAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDescripcionAsientoAsientoContable=true;

	public Boolean getMostrarFK_IdTipoDescripcionAsientoAsientoContable() {
		return this.mostrarFK_IdTipoDescripcionAsientoAsientoContable;
	}

	public void setMostrarFK_IdTipoDescripcionAsientoAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDescripcionAsientoAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDocumentoAsientoContable=true;

	public Boolean getMostrarFK_IdTipoDocumentoAsientoContable() {
		return this.mostrarFK_IdTipoDocumentoAsientoContable;
	}

	public void setMostrarFK_IdTipoDocumentoAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDocumentoAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoMovimientoModuloAsientoContable=true;

	public Boolean getMostrarFK_IdTipoMovimientoModuloAsientoContable() {
		return this.mostrarFK_IdTipoMovimientoModuloAsientoContable;
	}

	public void setMostrarFK_IdTipoMovimientoModuloAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoMovimientoModuloAsientoContable= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorBeneficiarioAsientoContable=true;

	public Boolean getActivarBusquedaPorBeneficiarioAsientoContable() {
		return this.activarBusquedaPorBeneficiarioAsientoContable;
	}

	public void setActivarBusquedaPorBeneficiarioAsientoContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorBeneficiarioAsientoContable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorCodigoAsientoContable=true;

	public Boolean getActivarBusquedaPorCodigoAsientoContable() {
		return this.activarBusquedaPorCodigoAsientoContable;
	}

	public void setActivarBusquedaPorCodigoAsientoContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoAsientoContable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorFechaEmisionAsientoContable=true;

	public Boolean getActivarBusquedaPorFechaEmisionAsientoContable() {
		return this.activarBusquedaPorFechaEmisionAsientoContable;
	}

	public void setActivarBusquedaPorFechaEmisionAsientoContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorFechaEmisionAsientoContable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNumeroMayorAsientoContable=true;

	public Boolean getActivarBusquedaPorNumeroMayorAsientoContable() {
		return this.activarBusquedaPorNumeroMayorAsientoContable;
	}

	public void setActivarBusquedaPorNumeroMayorAsientoContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroMayorAsientoContable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNumeroRetencionAsientoContable=true;

	public Boolean getActivarBusquedaPorNumeroRetencionAsientoContable() {
		return this.activarBusquedaPorNumeroRetencionAsientoContable;
	}

	public void setActivarBusquedaPorNumeroRetencionAsientoContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroRetencionAsientoContable= habilitarResaltar;
	}

	public Boolean activarBusquedaPorValorAsientoContable=true;

	public Boolean getActivarBusquedaPorValorAsientoContable() {
		return this.activarBusquedaPorValorAsientoContable;
	}

	public void setActivarBusquedaPorValorAsientoContable(Boolean habilitarResaltar) {
		this.activarBusquedaPorValorAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteAsientoContable=true;

	public Boolean getActivarFK_IdClienteAsientoContable() {
		return this.activarFK_IdClienteAsientoContable;
	}

	public void setActivarFK_IdClienteAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdClienteAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioAsientoContable=true;

	public Boolean getActivarFK_IdEjercicioAsientoContable() {
		return this.activarFK_IdEjercicioAsientoContable;
	}

	public void setActivarFK_IdEjercicioAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAsientoContable=true;

	public Boolean getActivarFK_IdEmpresaAsientoContable() {
		return this.activarFK_IdEmpresaAsientoContable;
	}

	public void setActivarFK_IdEmpresaAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloAsientoContable=true;

	public Boolean getActivarFK_IdModuloAsientoContable() {
		return this.activarFK_IdModuloAsientoContable;
	}

	public void setActivarFK_IdModuloAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdModuloAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoAsientoContable=true;

	public Boolean getActivarFK_IdPeriodoAsientoContable() {
		return this.activarFK_IdPeriodoAsientoContable;
	}

	public void setActivarFK_IdPeriodoAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalAsientoContable=true;

	public Boolean getActivarFK_IdSucursalAsientoContable() {
		return this.activarFK_IdSucursalAsientoContable;
	}

	public void setActivarFK_IdSucursalAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDescripcionAsientoAsientoContable=true;

	public Boolean getActivarFK_IdTipoDescripcionAsientoAsientoContable() {
		return this.activarFK_IdTipoDescripcionAsientoAsientoContable;
	}

	public void setActivarFK_IdTipoDescripcionAsientoAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDescripcionAsientoAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDocumentoAsientoContable=true;

	public Boolean getActivarFK_IdTipoDocumentoAsientoContable() {
		return this.activarFK_IdTipoDocumentoAsientoContable;
	}

	public void setActivarFK_IdTipoDocumentoAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDocumentoAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoMovimientoModuloAsientoContable=true;

	public Boolean getActivarFK_IdTipoMovimientoModuloAsientoContable() {
		return this.activarFK_IdTipoMovimientoModuloAsientoContable;
	}

	public void setActivarFK_IdTipoMovimientoModuloAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdTipoMovimientoModuloAsientoContable= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorBeneficiarioAsientoContable=null;

	public Border getResaltarBusquedaPorBeneficiarioAsientoContable() {
		return this.resaltarBusquedaPorBeneficiarioAsientoContable;
	}

	public void setResaltarBusquedaPorBeneficiarioAsientoContable(Border borderResaltar) {
		this.resaltarBusquedaPorBeneficiarioAsientoContable= borderResaltar;
	}

	public void setResaltarBusquedaPorBeneficiarioAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorBeneficiarioAsientoContable= borderResaltar;
	}

	public Border resaltarBusquedaPorCodigoAsientoContable=null;

	public Border getResaltarBusquedaPorCodigoAsientoContable() {
		return this.resaltarBusquedaPorCodigoAsientoContable;
	}

	public void setResaltarBusquedaPorCodigoAsientoContable(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoAsientoContable= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoAsientoContable= borderResaltar;
	}

	public Border resaltarBusquedaPorFechaEmisionAsientoContable=null;

	public Border getResaltarBusquedaPorFechaEmisionAsientoContable() {
		return this.resaltarBusquedaPorFechaEmisionAsientoContable;
	}

	public void setResaltarBusquedaPorFechaEmisionAsientoContable(Border borderResaltar) {
		this.resaltarBusquedaPorFechaEmisionAsientoContable= borderResaltar;
	}

	public void setResaltarBusquedaPorFechaEmisionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorFechaEmisionAsientoContable= borderResaltar;
	}

	public Border resaltarBusquedaPorNumeroMayorAsientoContable=null;

	public Border getResaltarBusquedaPorNumeroMayorAsientoContable() {
		return this.resaltarBusquedaPorNumeroMayorAsientoContable;
	}

	public void setResaltarBusquedaPorNumeroMayorAsientoContable(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroMayorAsientoContable= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroMayorAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroMayorAsientoContable= borderResaltar;
	}

	public Border resaltarBusquedaPorNumeroRetencionAsientoContable=null;

	public Border getResaltarBusquedaPorNumeroRetencionAsientoContable() {
		return this.resaltarBusquedaPorNumeroRetencionAsientoContable;
	}

	public void setResaltarBusquedaPorNumeroRetencionAsientoContable(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroRetencionAsientoContable= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroRetencionAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroRetencionAsientoContable= borderResaltar;
	}

	public Border resaltarBusquedaPorValorAsientoContable=null;

	public Border getResaltarBusquedaPorValorAsientoContable() {
		return this.resaltarBusquedaPorValorAsientoContable;
	}

	public void setResaltarBusquedaPorValorAsientoContable(Border borderResaltar) {
		this.resaltarBusquedaPorValorAsientoContable= borderResaltar;
	}

	public void setResaltarBusquedaPorValorAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorValorAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdClienteAsientoContable=null;

	public Border getResaltarFK_IdClienteAsientoContable() {
		return this.resaltarFK_IdClienteAsientoContable;
	}

	public void setResaltarFK_IdClienteAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdClienteAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdClienteAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioAsientoContable=null;

	public Border getResaltarFK_IdEjercicioAsientoContable() {
		return this.resaltarFK_IdEjercicioAsientoContable;
	}

	public void setResaltarFK_IdEjercicioAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdEjercicioAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAsientoContable=null;

	public Border getResaltarFK_IdEmpresaAsientoContable() {
		return this.resaltarFK_IdEmpresaAsientoContable;
	}

	public void setResaltarFK_IdEmpresaAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdModuloAsientoContable=null;

	public Border getResaltarFK_IdModuloAsientoContable() {
		return this.resaltarFK_IdModuloAsientoContable;
	}

	public void setResaltarFK_IdModuloAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdModuloAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdModuloAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoAsientoContable=null;

	public Border getResaltarFK_IdPeriodoAsientoContable() {
		return this.resaltarFK_IdPeriodoAsientoContable;
	}

	public void setResaltarFK_IdPeriodoAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdPeriodoAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdSucursalAsientoContable=null;

	public Border getResaltarFK_IdSucursalAsientoContable() {
		return this.resaltarFK_IdSucursalAsientoContable;
	}

	public void setResaltarFK_IdSucursalAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdSucursalAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdSucursalAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdTipoDescripcionAsientoAsientoContable=null;

	public Border getResaltarFK_IdTipoDescripcionAsientoAsientoContable() {
		return this.resaltarFK_IdTipoDescripcionAsientoAsientoContable;
	}

	public void setResaltarFK_IdTipoDescripcionAsientoAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdTipoDescripcionAsientoAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdTipoDescripcionAsientoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDescripcionAsientoAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdTipoDocumentoAsientoContable=null;

	public Border getResaltarFK_IdTipoDocumentoAsientoContable() {
		return this.resaltarFK_IdTipoDocumentoAsientoContable;
	}

	public void setResaltarFK_IdTipoDocumentoAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdTipoDocumentoAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdTipoDocumentoAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDocumentoAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdTipoMovimientoModuloAsientoContable=null;

	public Border getResaltarFK_IdTipoMovimientoModuloAsientoContable() {
		return this.resaltarFK_IdTipoMovimientoModuloAsientoContable;
	}

	public void setResaltarFK_IdTipoMovimientoModuloAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdTipoMovimientoModuloAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdTipoMovimientoModuloAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*AsientoContableBeanSwingJInternalFrame asientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoMovimientoModuloAsientoContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}