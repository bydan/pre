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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.RequisicionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.RequisicionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RequisicionCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RequisicionCompraConstantesFunciones extends RequisicionCompraConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,-10);
	
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
	public static final String SNOMBREOPCION="RequisicionCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RequisicionCompra"+RequisicionCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RequisicionCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RequisicionCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RequisicionCompraConstantesFunciones.SCHEMA+"_"+RequisicionCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RequisicionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RequisicionCompraConstantesFunciones.SCHEMA+"_"+RequisicionCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RequisicionCompraConstantesFunciones.SCHEMA+"_"+RequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RequisicionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RequisicionCompraConstantesFunciones.SCHEMA+"_"+RequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RequisicionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RequisicionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RequisicionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RequisicionCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RequisicionCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RequisicionCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RequisicionCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Requisicion Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Requisicion Compra";
	public static final String SCLASSWEBTITULO_LOWER="Requisicion Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RequisicionCompra";
	public static final String OBJECTNAME="requisicioncompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="requisicion_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select requisicioncompra from "+RequisicionCompraConstantesFunciones.SPERSISTENCENAME+" requisicioncompra";
	public static String QUERYSELECTNATIVE="select "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".version_row,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_empresa,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_sucursal,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_modulo,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_periodo,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_anio,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_mes,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".numero_secuencial,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_cliente,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_usuario,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_moneda,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_estado_requisicion_compra,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".total,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".fecha,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_empleado,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".responsable,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".solicitado_por,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".motivo_solicitud,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".area_solicitud,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".para_uso_de,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".lugar_entrega,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".descripcion,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".fecha_emision,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".fecha_entrega,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_formato,"+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME+".id_tipo_cambio from "+RequisicionCompraConstantesFunciones.SCHEMA+"."+RequisicionCompraConstantesFunciones.TABLENAME;//+" as "+RequisicionCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected RequisicionCompraConstantesFuncionesAdditional requisicioncompraConstantesFuncionesAdditional=null;
	
	public RequisicionCompraConstantesFuncionesAdditional getRequisicionCompraConstantesFuncionesAdditional() {
		return this.requisicioncompraConstantesFuncionesAdditional;
	}
	
	public void setRequisicionCompraConstantesFuncionesAdditional(RequisicionCompraConstantesFuncionesAdditional requisicioncompraConstantesFuncionesAdditional) {
		try {
			this.requisicioncompraConstantesFuncionesAdditional=requisicioncompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDESTADOREQUISICIONCOMPRA= "id_estado_requisicion_compra";
    public static final String TOTAL= "total";
    public static final String FECHA= "fecha";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String RESPONSABLE= "responsable";
    public static final String SOLICITADOPOR= "solicitado_por";
    public static final String MOTIVOSOLICITUD= "motivo_solicitud";
    public static final String AREASOLICITUD= "area_solicitud";
    public static final String PARAUSODE= "para_uso_de";
    public static final String LUGARENTREGA= "lugar_entrega";
    public static final String DESCRIPCION= "descripcion";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "Numero Secuencial";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDESTADOREQUISICIONCOMPRA= "Estado";
		public static final String LABEL_IDESTADOREQUISICIONCOMPRA_LOWER= "Estado Requisicion Compra";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_RESPONSABLE= "Responsable";
		public static final String LABEL_RESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_SOLICITADOPOR= "Solicitado Por";
		public static final String LABEL_SOLICITADOPOR_LOWER= "Solicitado Por";
    	public static final String LABEL_MOTIVOSOLICITUD= "Motivo Solicitud";
		public static final String LABEL_MOTIVOSOLICITUD_LOWER= "Motivo Solicitud";
    	public static final String LABEL_AREASOLICITUD= "Area Solicitud";
		public static final String LABEL_AREASOLICITUD_LOWER= "Area Solicitud";
    	public static final String LABEL_PARAUSODE= "Para Uso De";
		public static final String LABEL_PARAUSODE_LOWER= "Para Uso De";
    	public static final String LABEL_LUGARENTREGA= "Lugar Entrega";
		public static final String LABEL_LUGARENTREGA_LOWER= "Lugar Entrega";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAENTREGA= "Fecha Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "Fecha Entrega";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSOLICITADO_POR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSOLICITADO_POR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMOTIVO_SOLICITUD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXMOTIVO_SOLICITUD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAREA_SOLICITUD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAREA_SOLICITUD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXPARA_USO_DE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPARA_USO_DE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXLUGAR_ENTREGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLUGAR_ENTREGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getRequisicionCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDMODULO)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDANIO)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDMES)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDCLIENTE)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDUSUARIO)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDMONEDA)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDESTADOREQUISICIONCOMPRA;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.TOTAL)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.FECHA)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.RESPONSABLE)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.SOLICITADOPOR)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_SOLICITADOPOR;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.AREASOLICITUD)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_AREASOLICITUD;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.PARAUSODE)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_PARAUSODE;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.LUGARENTREGA)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_LUGARENTREGA;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.FECHAEMISION)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.FECHAENTREGA)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDFORMATO)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(RequisicionCompraConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=RequisicionCompraConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRequisicionCompraDescripcion(RequisicionCompra requisicioncompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(requisicioncompra !=null/* && requisicioncompra.getId()!=0*/) {
			if(requisicioncompra.getId()!=null) {
				sDescripcion=requisicioncompra.getId().toString();
			}//requisicioncomprarequisicioncompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRequisicionCompraDescripcionDetallado(RequisicionCompra requisicioncompra) {
		String sDescripcion="";
			
		sDescripcion+=RequisicionCompraConstantesFunciones.ID+"=";
		sDescripcion+=requisicioncompra.getId().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=requisicioncompra.getVersionRow().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=requisicioncompra.getid_empresa().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=requisicioncompra.getid_sucursal().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDMODULO+"=";
		sDescripcion+=requisicioncompra.getid_modulo().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=requisicioncompra.getid_ejercicio().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=requisicioncompra.getid_periodo().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDANIO+"=";
		sDescripcion+=requisicioncompra.getid_anio().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDMES+"=";
		sDescripcion+=requisicioncompra.getid_mes().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=requisicioncompra.getnumero_secuencial()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=requisicioncompra.getid_cliente().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=requisicioncompra.getid_usuario().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=requisicioncompra.getid_moneda().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA+"=";
		sDescripcion+=requisicioncompra.getid_estado_requisicion_compra().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.TOTAL+"=";
		sDescripcion+=requisicioncompra.gettotal().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.FECHA+"=";
		sDescripcion+=requisicioncompra.getfecha().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=requisicioncompra.getid_empleado().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=requisicioncompra.getresponsable()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.SOLICITADOPOR+"=";
		sDescripcion+=requisicioncompra.getsolicitado_por()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD+"=";
		sDescripcion+=requisicioncompra.getmotivo_solicitud()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.AREASOLICITUD+"=";
		sDescripcion+=requisicioncompra.getarea_solicitud()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.PARAUSODE+"=";
		sDescripcion+=requisicioncompra.getpara_uso_de()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.LUGARENTREGA+"=";
		sDescripcion+=requisicioncompra.getlugar_entrega()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=requisicioncompra.getdescripcion()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=requisicioncompra.getfecha_emision().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=requisicioncompra.getfecha_entrega().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=requisicioncompra.getid_formato().toString()+",";
		sDescripcion+=RequisicionCompraConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=requisicioncompra.getid_tipo_cambio().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRequisicionCompraDescripcion(RequisicionCompra requisicioncompra,String sValor) throws Exception {			
		if(requisicioncompra !=null) {
			//requisicioncomprarequisicioncompra.getId().toString();
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
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

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getEstadoRequisicionCompraDescripcion(EstadoRequisicion estadorequisicion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadorequisicion!=null/*&&estadorequisicion.getId()>0*/) {
			sDescripcion=EstadoRequisicionConstantesFunciones.getEstadoRequisicionDescripcion(estadorequisicion);
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

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
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
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoRequisicionCompra")) {
			sNombreIndice="Tipo=  Por Estado";
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
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
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
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoRequisicionCompra(Long id_estado_requisicion_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_requisicion_compra!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_requisicion_compra.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRequisicionCompra(RequisicionCompra requisicioncompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		requisicioncompra.setnumero_secuencial(requisicioncompra.getnumero_secuencial().trim());
		requisicioncompra.setresponsable(requisicioncompra.getresponsable().trim());
		requisicioncompra.setsolicitado_por(requisicioncompra.getsolicitado_por().trim());
		requisicioncompra.setmotivo_solicitud(requisicioncompra.getmotivo_solicitud().trim());
		requisicioncompra.setarea_solicitud(requisicioncompra.getarea_solicitud().trim());
		requisicioncompra.setpara_uso_de(requisicioncompra.getpara_uso_de().trim());
		requisicioncompra.setlugar_entrega(requisicioncompra.getlugar_entrega().trim());
		requisicioncompra.setdescripcion(requisicioncompra.getdescripcion().trim());
	}
	
	public static void quitarEspaciosRequisicionCompras(List<RequisicionCompra> requisicioncompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RequisicionCompra requisicioncompra: requisicioncompras) {
			requisicioncompra.setnumero_secuencial(requisicioncompra.getnumero_secuencial().trim());
			requisicioncompra.setresponsable(requisicioncompra.getresponsable().trim());
			requisicioncompra.setsolicitado_por(requisicioncompra.getsolicitado_por().trim());
			requisicioncompra.setmotivo_solicitud(requisicioncompra.getmotivo_solicitud().trim());
			requisicioncompra.setarea_solicitud(requisicioncompra.getarea_solicitud().trim());
			requisicioncompra.setpara_uso_de(requisicioncompra.getpara_uso_de().trim());
			requisicioncompra.setlugar_entrega(requisicioncompra.getlugar_entrega().trim());
			requisicioncompra.setdescripcion(requisicioncompra.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRequisicionCompra(RequisicionCompra requisicioncompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && requisicioncompra.getConCambioAuxiliar()) {
			requisicioncompra.setIsDeleted(requisicioncompra.getIsDeletedAuxiliar());	
			requisicioncompra.setIsNew(requisicioncompra.getIsNewAuxiliar());	
			requisicioncompra.setIsChanged(requisicioncompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			requisicioncompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			requisicioncompra.setIsDeletedAuxiliar(false);	
			requisicioncompra.setIsNewAuxiliar(false);	
			requisicioncompra.setIsChangedAuxiliar(false);
			
			requisicioncompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRequisicionCompras(List<RequisicionCompra> requisicioncompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RequisicionCompra requisicioncompra : requisicioncompras) {
			if(conAsignarBase && requisicioncompra.getConCambioAuxiliar()) {
				requisicioncompra.setIsDeleted(requisicioncompra.getIsDeletedAuxiliar());	
				requisicioncompra.setIsNew(requisicioncompra.getIsNewAuxiliar());	
				requisicioncompra.setIsChanged(requisicioncompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				requisicioncompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				requisicioncompra.setIsDeletedAuxiliar(false);	
				requisicioncompra.setIsNewAuxiliar(false);	
				requisicioncompra.setIsChangedAuxiliar(false);
				
				requisicioncompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRequisicionCompra(RequisicionCompra requisicioncompra,Boolean conEnteros) throws Exception  {
		requisicioncompra.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresRequisicionCompras(List<RequisicionCompra> requisicioncompras,Boolean conEnteros) throws Exception  {
		
		for(RequisicionCompra requisicioncompra: requisicioncompras) {
			requisicioncompra.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaRequisicionCompra(List<RequisicionCompra> requisicioncompras,RequisicionCompra requisicioncompraAux) throws Exception  {
		RequisicionCompraConstantesFunciones.InicializarValoresRequisicionCompra(requisicioncompraAux,true);
		
		for(RequisicionCompra requisicioncompra: requisicioncompras) {
			if(requisicioncompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			requisicioncompraAux.settotal(requisicioncompraAux.gettotal()+requisicioncompra.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRequisicionCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RequisicionCompraConstantesFunciones.getArrayColumnasGlobalesRequisicionCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRequisicionCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionCompraConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionCompraConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionCompraConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionCompraConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionCompraConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RequisicionCompraConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RequisicionCompraConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRequisicionCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RequisicionCompra> requisicioncompras,RequisicionCompra requisicioncompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RequisicionCompra requisicioncompraAux: requisicioncompras) {
			if(requisicioncompraAux!=null && requisicioncompra!=null) {
				if((requisicioncompraAux.getId()==null && requisicioncompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(requisicioncompraAux.getId()!=null && requisicioncompra.getId()!=null){
					if(requisicioncompraAux.getId().equals(requisicioncompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRequisicionCompra(List<RequisicionCompra> requisicioncompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double totalTotal=0.0;
	
		for(RequisicionCompra requisicioncompra: requisicioncompras) {			
			if(requisicioncompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			totalTotal+=requisicioncompra.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RequisicionCompraConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRequisicionCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_ID, RequisicionCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_VERSIONROW, RequisicionCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDEMPRESA, RequisicionCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL, RequisicionCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDMODULO, RequisicionCompraConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO, RequisicionCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDPERIODO, RequisicionCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDANIO, RequisicionCompraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDMES, RequisicionCompraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL, RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDCLIENTE, RequisicionCompraConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDUSUARIO, RequisicionCompraConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDMONEDA, RequisicionCompraConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDESTADOREQUISICIONCOMPRA, RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_TOTAL, RequisicionCompraConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_FECHA, RequisicionCompraConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDEMPLEADO, RequisicionCompraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_RESPONSABLE, RequisicionCompraConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_SOLICITADOPOR, RequisicionCompraConstantesFunciones.SOLICITADOPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD, RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_AREASOLICITUD, RequisicionCompraConstantesFunciones.AREASOLICITUD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_PARAUSODE, RequisicionCompraConstantesFunciones.PARAUSODE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_LUGARENTREGA, RequisicionCompraConstantesFunciones.LUGARENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_DESCRIPCION, RequisicionCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_FECHAEMISION, RequisicionCompraConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_FECHAENTREGA, RequisicionCompraConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDFORMATO, RequisicionCompraConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RequisicionCompraConstantesFunciones.LABEL_IDTIPOCAMBIO, RequisicionCompraConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRequisicionCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.SOLICITADOPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.AREASOLICITUD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.PARAUSODE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.LUGARENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RequisicionCompraConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRequisicionCompra() throws Exception  {
		return RequisicionCompraConstantesFunciones.getTiposSeleccionarRequisicionCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRequisicionCompra(Boolean conFk) throws Exception  {
		return RequisicionCompraConstantesFunciones.getTiposSeleccionarRequisicionCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRequisicionCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDESTADOREQUISICIONCOMPRA);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDESTADOREQUISICIONCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_SOLICITADOPOR);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_SOLICITADOPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_AREASOLICITUD);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_AREASOLICITUD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_PARAUSODE);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_PARAUSODE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_LUGARENTREGA);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_LUGARENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RequisicionCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(RequisicionCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRequisicionCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRequisicionCompra(RequisicionCompra requisicioncompraAux) throws Exception {
		
			requisicioncompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(requisicioncompraAux.getEmpresa()));
			requisicioncompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(requisicioncompraAux.getSucursal()));
			requisicioncompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(requisicioncompraAux.getModulo()));
			requisicioncompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(requisicioncompraAux.getEjercicio()));
			requisicioncompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(requisicioncompraAux.getPeriodo()));
			requisicioncompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(requisicioncompraAux.getAnio()));
			requisicioncompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(requisicioncompraAux.getMes()));
			requisicioncompraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(requisicioncompraAux.getCliente()));
			requisicioncompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(requisicioncompraAux.getUsuario()));
			requisicioncompraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(requisicioncompraAux.getMoneda()));
			requisicioncompraAux.setestadorequisicioncompra_descripcion(EstadoRequisicionConstantesFunciones.getEstadoRequisicionDescripcion(requisicioncompraAux.getEstadoRequisicionCompra()));
			requisicioncompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(requisicioncompraAux.getEmpleado()));
			requisicioncompraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(requisicioncompraAux.getFormato()));
			requisicioncompraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(requisicioncompraAux.getTipoCambio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRequisicionCompra(List<RequisicionCompra> requisicioncomprasTemp) throws Exception {
		for(RequisicionCompra requisicioncompraAux:requisicioncomprasTemp) {
			
			requisicioncompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(requisicioncompraAux.getEmpresa()));
			requisicioncompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(requisicioncompraAux.getSucursal()));
			requisicioncompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(requisicioncompraAux.getModulo()));
			requisicioncompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(requisicioncompraAux.getEjercicio()));
			requisicioncompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(requisicioncompraAux.getPeriodo()));
			requisicioncompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(requisicioncompraAux.getAnio()));
			requisicioncompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(requisicioncompraAux.getMes()));
			requisicioncompraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(requisicioncompraAux.getCliente()));
			requisicioncompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(requisicioncompraAux.getUsuario()));
			requisicioncompraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(requisicioncompraAux.getMoneda()));
			requisicioncompraAux.setestadorequisicioncompra_descripcion(EstadoRequisicionConstantesFunciones.getEstadoRequisicionDescripcion(requisicioncompraAux.getEstadoRequisicionCompra()));
			requisicioncompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(requisicioncompraAux.getEmpleado()));
			requisicioncompraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(requisicioncompraAux.getFormato()));
			requisicioncompraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(requisicioncompraAux.getTipoCambio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(EstadoRequisicion.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(TipoCambio.class));
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoRequisicion.class)) {
						classes.add(new Classe(EstadoRequisicion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRequisicionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(EstadoRequisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRequisicion.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(EstadoRequisicion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRequisicion.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RequisicionCompraConstantesFunciones.getClassesRelationshipsOfRequisicionCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRequisicionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleRequisicionCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleRequisicionCompra.class)) {
						classes.add(new Classe(DetalleRequisicionCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRequisicionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RequisicionCompraConstantesFunciones.getClassesRelationshipsFromStringsOfRequisicionCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRequisicionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleRequisicionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleRequisicionCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleRequisicionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleRequisicionCompra.class)); continue;
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
	public static void actualizarLista(RequisicionCompra requisicioncompra,List<RequisicionCompra> requisicioncompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RequisicionCompra requisicioncompraEncontrado=null;
			
			for(RequisicionCompra requisicioncompraLocal:requisicioncompras) {
				if(requisicioncompraLocal.getId().equals(requisicioncompra.getId())) {
					requisicioncompraEncontrado=requisicioncompraLocal;
					
					requisicioncompraLocal.setIsChanged(requisicioncompra.getIsChanged());
					requisicioncompraLocal.setIsNew(requisicioncompra.getIsNew());
					requisicioncompraLocal.setIsDeleted(requisicioncompra.getIsDeleted());
					
					requisicioncompraLocal.setGeneralEntityOriginal(requisicioncompra.getGeneralEntityOriginal());
					
					requisicioncompraLocal.setId(requisicioncompra.getId());	
					requisicioncompraLocal.setVersionRow(requisicioncompra.getVersionRow());	
					requisicioncompraLocal.setid_empresa(requisicioncompra.getid_empresa());	
					requisicioncompraLocal.setid_sucursal(requisicioncompra.getid_sucursal());	
					requisicioncompraLocal.setid_modulo(requisicioncompra.getid_modulo());	
					requisicioncompraLocal.setid_ejercicio(requisicioncompra.getid_ejercicio());	
					requisicioncompraLocal.setid_periodo(requisicioncompra.getid_periodo());	
					requisicioncompraLocal.setid_anio(requisicioncompra.getid_anio());	
					requisicioncompraLocal.setid_mes(requisicioncompra.getid_mes());	
					requisicioncompraLocal.setnumero_secuencial(requisicioncompra.getnumero_secuencial());	
					requisicioncompraLocal.setid_cliente(requisicioncompra.getid_cliente());	
					requisicioncompraLocal.setid_usuario(requisicioncompra.getid_usuario());	
					requisicioncompraLocal.setid_moneda(requisicioncompra.getid_moneda());	
					requisicioncompraLocal.setid_estado_requisicion_compra(requisicioncompra.getid_estado_requisicion_compra());	
					requisicioncompraLocal.settotal(requisicioncompra.gettotal());	
					requisicioncompraLocal.setfecha(requisicioncompra.getfecha());	
					requisicioncompraLocal.setid_empleado(requisicioncompra.getid_empleado());	
					requisicioncompraLocal.setresponsable(requisicioncompra.getresponsable());	
					requisicioncompraLocal.setsolicitado_por(requisicioncompra.getsolicitado_por());	
					requisicioncompraLocal.setmotivo_solicitud(requisicioncompra.getmotivo_solicitud());	
					requisicioncompraLocal.setarea_solicitud(requisicioncompra.getarea_solicitud());	
					requisicioncompraLocal.setpara_uso_de(requisicioncompra.getpara_uso_de());	
					requisicioncompraLocal.setlugar_entrega(requisicioncompra.getlugar_entrega());	
					requisicioncompraLocal.setdescripcion(requisicioncompra.getdescripcion());	
					requisicioncompraLocal.setfecha_emision(requisicioncompra.getfecha_emision());	
					requisicioncompraLocal.setfecha_entrega(requisicioncompra.getfecha_entrega());	
					requisicioncompraLocal.setid_formato(requisicioncompra.getid_formato());	
					requisicioncompraLocal.setid_tipo_cambio(requisicioncompra.getid_tipo_cambio());	
					
					
					requisicioncompraLocal.setDetalleRequisicionCompras(requisicioncompra.getDetalleRequisicionCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!requisicioncompra.getIsDeleted()) {
				if(!existe) {
					requisicioncompras.add(requisicioncompra);
				}
			} else {
				if(requisicioncompraEncontrado!=null && permiteQuitar)  {
					requisicioncompras.remove(requisicioncompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RequisicionCompra requisicioncompra,List<RequisicionCompra> requisicioncompras) throws Exception {
		try	{			
			for(RequisicionCompra requisicioncompraLocal:requisicioncompras) {
				if(requisicioncompraLocal.getId().equals(requisicioncompra.getId())) {
					requisicioncompraLocal.setIsSelected(requisicioncompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRequisicionCompra(List<RequisicionCompra> requisicioncomprasAux) throws Exception {
		//this.requisicioncomprasAux=requisicioncomprasAux;
		
		for(RequisicionCompra requisicioncompraAux:requisicioncomprasAux) {
			if(requisicioncompraAux.getIsChanged()) {
				requisicioncompraAux.setIsChanged(false);
			}		
			
			if(requisicioncompraAux.getIsNew()) {
				requisicioncompraAux.setIsNew(false);
			}	
			
			if(requisicioncompraAux.getIsDeleted()) {
				requisicioncompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRequisicionCompra(RequisicionCompra requisicioncompraAux) throws Exception {
		//this.requisicioncompraAux=requisicioncompraAux;
		
			if(requisicioncompraAux.getIsChanged()) {
				requisicioncompraAux.setIsChanged(false);
			}		
			
			if(requisicioncompraAux.getIsNew()) {
				requisicioncompraAux.setIsNew(false);
			}	
			
			if(requisicioncompraAux.getIsDeleted()) {
				requisicioncompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RequisicionCompra requisicioncompraAsignar,RequisicionCompra requisicioncompra) throws Exception {
		requisicioncompraAsignar.setId(requisicioncompra.getId());	
		requisicioncompraAsignar.setVersionRow(requisicioncompra.getVersionRow());	
		requisicioncompraAsignar.setid_empresa(requisicioncompra.getid_empresa());
		requisicioncompraAsignar.setempresa_descripcion(requisicioncompra.getempresa_descripcion());	
		requisicioncompraAsignar.setid_sucursal(requisicioncompra.getid_sucursal());
		requisicioncompraAsignar.setsucursal_descripcion(requisicioncompra.getsucursal_descripcion());	
		requisicioncompraAsignar.setid_modulo(requisicioncompra.getid_modulo());
		requisicioncompraAsignar.setmodulo_descripcion(requisicioncompra.getmodulo_descripcion());	
		requisicioncompraAsignar.setid_ejercicio(requisicioncompra.getid_ejercicio());
		requisicioncompraAsignar.setejercicio_descripcion(requisicioncompra.getejercicio_descripcion());	
		requisicioncompraAsignar.setid_periodo(requisicioncompra.getid_periodo());
		requisicioncompraAsignar.setperiodo_descripcion(requisicioncompra.getperiodo_descripcion());	
		requisicioncompraAsignar.setid_anio(requisicioncompra.getid_anio());
		requisicioncompraAsignar.setanio_descripcion(requisicioncompra.getanio_descripcion());	
		requisicioncompraAsignar.setid_mes(requisicioncompra.getid_mes());
		requisicioncompraAsignar.setmes_descripcion(requisicioncompra.getmes_descripcion());	
		requisicioncompraAsignar.setnumero_secuencial(requisicioncompra.getnumero_secuencial());	
		requisicioncompraAsignar.setid_cliente(requisicioncompra.getid_cliente());
		requisicioncompraAsignar.setcliente_descripcion(requisicioncompra.getcliente_descripcion());	
		requisicioncompraAsignar.setid_usuario(requisicioncompra.getid_usuario());
		requisicioncompraAsignar.setusuario_descripcion(requisicioncompra.getusuario_descripcion());	
		requisicioncompraAsignar.setid_moneda(requisicioncompra.getid_moneda());
		requisicioncompraAsignar.setmoneda_descripcion(requisicioncompra.getmoneda_descripcion());	
		requisicioncompraAsignar.setid_estado_requisicion_compra(requisicioncompra.getid_estado_requisicion_compra());
		requisicioncompraAsignar.setestadorequisicioncompra_descripcion(requisicioncompra.getestadorequisicioncompra_descripcion());	
		requisicioncompraAsignar.settotal(requisicioncompra.gettotal());	
		requisicioncompraAsignar.setfecha(requisicioncompra.getfecha());	
		requisicioncompraAsignar.setid_empleado(requisicioncompra.getid_empleado());
		requisicioncompraAsignar.setempleado_descripcion(requisicioncompra.getempleado_descripcion());	
		requisicioncompraAsignar.setresponsable(requisicioncompra.getresponsable());	
		requisicioncompraAsignar.setsolicitado_por(requisicioncompra.getsolicitado_por());	
		requisicioncompraAsignar.setmotivo_solicitud(requisicioncompra.getmotivo_solicitud());	
		requisicioncompraAsignar.setarea_solicitud(requisicioncompra.getarea_solicitud());	
		requisicioncompraAsignar.setpara_uso_de(requisicioncompra.getpara_uso_de());	
		requisicioncompraAsignar.setlugar_entrega(requisicioncompra.getlugar_entrega());	
		requisicioncompraAsignar.setdescripcion(requisicioncompra.getdescripcion());	
		requisicioncompraAsignar.setfecha_emision(requisicioncompra.getfecha_emision());	
		requisicioncompraAsignar.setfecha_entrega(requisicioncompra.getfecha_entrega());	
		requisicioncompraAsignar.setid_formato(requisicioncompra.getid_formato());
		requisicioncompraAsignar.setformato_descripcion(requisicioncompra.getformato_descripcion());	
		requisicioncompraAsignar.setid_tipo_cambio(requisicioncompra.getid_tipo_cambio());
		requisicioncompraAsignar.settipocambio_descripcion(requisicioncompra.gettipocambio_descripcion());	
	}
	
	public static void inicializarRequisicionCompra(RequisicionCompra requisicioncompra) throws Exception {
		try {
				requisicioncompra.setId(0L);	
					
				requisicioncompra.setid_empresa(-1L);	
				requisicioncompra.setid_sucursal(-1L);	
				requisicioncompra.setid_modulo(-1L);	
				requisicioncompra.setid_ejercicio(-1L);	
				requisicioncompra.setid_periodo(-1L);	
				requisicioncompra.setid_anio(null);	
				requisicioncompra.setid_mes(null);	
				requisicioncompra.setnumero_secuencial("");	
				requisicioncompra.setid_cliente(-1L);	
				requisicioncompra.setid_usuario(-1L);	
				requisicioncompra.setid_moneda(-1L);	
				requisicioncompra.setid_estado_requisicion_compra(-1L);	
				requisicioncompra.settotal(0.0);	
				requisicioncompra.setfecha(new Date());	
				requisicioncompra.setid_empleado(-1L);	
				requisicioncompra.setresponsable("");	
				requisicioncompra.setsolicitado_por("");	
				requisicioncompra.setmotivo_solicitud("");	
				requisicioncompra.setarea_solicitud("");	
				requisicioncompra.setpara_uso_de("");	
				requisicioncompra.setlugar_entrega("");	
				requisicioncompra.setdescripcion("");	
				requisicioncompra.setfecha_emision(new Date());	
				requisicioncompra.setfecha_entrega(new Date());	
				requisicioncompra.setid_formato(null);	
				requisicioncompra.setid_tipo_cambio(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRequisicionCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDESTADOREQUISICIONCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_SOLICITADOPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_MOTIVOSOLICITUD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_AREASOLICITUD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_PARAUSODE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_LUGARENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RequisicionCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRequisicionCompra(String sTipo,Row row,Workbook workbook,RequisicionCompra requisicioncompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getestadorequisicioncompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getsolicitado_por());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getmotivo_solicitud());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getarea_solicitud());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getpara_uso_de());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getlugar_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(requisicioncompra.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRequisicionCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRequisicionCompra() {
		return this.sFinalQueryRequisicionCompra;
	}
	
	public void setsFinalQueryRequisicionCompra(String sFinalQueryRequisicionCompra) {
		this.sFinalQueryRequisicionCompra= sFinalQueryRequisicionCompra;
	}
	
	public Border resaltarSeleccionarRequisicionCompra=null;
	
	public Border setResaltarSeleccionarRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRequisicionCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRequisicionCompra() {
		return this.resaltarSeleccionarRequisicionCompra;
	}
	
	public void setResaltarSeleccionarRequisicionCompra(Border borderResaltarSeleccionarRequisicionCompra) {
		this.resaltarSeleccionarRequisicionCompra= borderResaltarSeleccionarRequisicionCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRequisicionCompra=null;
	public Boolean mostraridRequisicionCompra=true;
	public Boolean activaridRequisicionCompra=true;

	public Border resaltarid_empresaRequisicionCompra=null;
	public Boolean mostrarid_empresaRequisicionCompra=true;
	public Boolean activarid_empresaRequisicionCompra=true;
	public Boolean cargarid_empresaRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalRequisicionCompra=null;
	public Boolean mostrarid_sucursalRequisicionCompra=true;
	public Boolean activarid_sucursalRequisicionCompra=true;
	public Boolean cargarid_sucursalRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_moduloRequisicionCompra=null;
	public Boolean mostrarid_moduloRequisicionCompra=true;
	public Boolean activarid_moduloRequisicionCompra=true;
	public Boolean cargarid_moduloRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioRequisicionCompra=null;
	public Boolean mostrarid_ejercicioRequisicionCompra=true;
	public Boolean activarid_ejercicioRequisicionCompra=true;
	public Boolean cargarid_ejercicioRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoRequisicionCompra=null;
	public Boolean mostrarid_periodoRequisicionCompra=true;
	public Boolean activarid_periodoRequisicionCompra=true;
	public Boolean cargarid_periodoRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_anioRequisicionCompra=null;
	public Boolean mostrarid_anioRequisicionCompra=true;
	public Boolean activarid_anioRequisicionCompra=false;
	public Boolean cargarid_anioRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_mesRequisicionCompra=null;
	public Boolean mostrarid_mesRequisicionCompra=true;
	public Boolean activarid_mesRequisicionCompra=false;
	public Boolean cargarid_mesRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarnumero_secuencialRequisicionCompra=null;
	public Boolean mostrarnumero_secuencialRequisicionCompra=true;
	public Boolean activarnumero_secuencialRequisicionCompra=false;

	public Border resaltarid_clienteRequisicionCompra=null;
	public Boolean mostrarid_clienteRequisicionCompra=true;
	public Boolean activarid_clienteRequisicionCompra=true;
	public Boolean cargarid_clienteRequisicionCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_usuarioRequisicionCompra=null;
	public Boolean mostrarid_usuarioRequisicionCompra=true;
	public Boolean activarid_usuarioRequisicionCompra=true;
	public Boolean cargarid_usuarioRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_monedaRequisicionCompra=null;
	public Boolean mostrarid_monedaRequisicionCompra=true;
	public Boolean activarid_monedaRequisicionCompra=false;
	public Boolean cargarid_monedaRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_requisicion_compraRequisicionCompra=null;
	public Boolean mostrarid_estado_requisicion_compraRequisicionCompra=true;
	public Boolean activarid_estado_requisicion_compraRequisicionCompra=false;
	public Boolean cargarid_estado_requisicion_compraRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_requisicion_compraRequisicionCompra=false;//ConEventDepend=true

	public Border resaltartotalRequisicionCompra=null;
	public Boolean mostrartotalRequisicionCompra=true;
	public Boolean activartotalRequisicionCompra=false;

	public Border resaltarfechaRequisicionCompra=null;
	public Boolean mostrarfechaRequisicionCompra=true;
	public Boolean activarfechaRequisicionCompra=false;

	public Border resaltarid_empleadoRequisicionCompra=null;
	public Boolean mostrarid_empleadoRequisicionCompra=true;
	public Boolean activarid_empleadoRequisicionCompra=true;
	public Boolean cargarid_empleadoRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarresponsableRequisicionCompra=null;
	public Boolean mostrarresponsableRequisicionCompra=true;
	public Boolean activarresponsableRequisicionCompra=true;

	public Border resaltarsolicitado_porRequisicionCompra=null;
	public Boolean mostrarsolicitado_porRequisicionCompra=true;
	public Boolean activarsolicitado_porRequisicionCompra=true;

	public Border resaltarmotivo_solicitudRequisicionCompra=null;
	public Boolean mostrarmotivo_solicitudRequisicionCompra=true;
	public Boolean activarmotivo_solicitudRequisicionCompra=true;

	public Border resaltararea_solicitudRequisicionCompra=null;
	public Boolean mostrararea_solicitudRequisicionCompra=true;
	public Boolean activararea_solicitudRequisicionCompra=true;

	public Border resaltarpara_uso_deRequisicionCompra=null;
	public Boolean mostrarpara_uso_deRequisicionCompra=true;
	public Boolean activarpara_uso_deRequisicionCompra=true;

	public Border resaltarlugar_entregaRequisicionCompra=null;
	public Boolean mostrarlugar_entregaRequisicionCompra=true;
	public Boolean activarlugar_entregaRequisicionCompra=true;

	public Border resaltardescripcionRequisicionCompra=null;
	public Boolean mostrardescripcionRequisicionCompra=true;
	public Boolean activardescripcionRequisicionCompra=true;

	public Border resaltarfecha_emisionRequisicionCompra=null;
	public Boolean mostrarfecha_emisionRequisicionCompra=true;
	public Boolean activarfecha_emisionRequisicionCompra=true;

	public Border resaltarfecha_entregaRequisicionCompra=null;
	public Boolean mostrarfecha_entregaRequisicionCompra=true;
	public Boolean activarfecha_entregaRequisicionCompra=true;

	public Border resaltarid_formatoRequisicionCompra=null;
	public Boolean mostrarid_formatoRequisicionCompra=true;
	public Boolean activarid_formatoRequisicionCompra=true;
	public Boolean cargarid_formatoRequisicionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoRequisicionCompra=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioRequisicionCompra=null;
	public Boolean mostrarid_tipo_cambioRequisicionCompra=true;
	public Boolean activarid_tipo_cambioRequisicionCompra=false;
	public Boolean cargarid_tipo_cambioRequisicionCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioRequisicionCompra=false;//ConEventDepend=true

	
	

	public Border setResaltaridRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltaridRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRequisicionCompra() {
		return this.resaltaridRequisicionCompra;
	}

	public void setResaltaridRequisicionCompra(Border borderResaltar) {
		this.resaltaridRequisicionCompra= borderResaltar;
	}

	public Boolean getMostraridRequisicionCompra() {
		return this.mostraridRequisicionCompra;
	}

	public void setMostraridRequisicionCompra(Boolean mostraridRequisicionCompra) {
		this.mostraridRequisicionCompra= mostraridRequisicionCompra;
	}

	public Boolean getActivaridRequisicionCompra() {
		return this.activaridRequisicionCompra;
	}

	public void setActivaridRequisicionCompra(Boolean activaridRequisicionCompra) {
		this.activaridRequisicionCompra= activaridRequisicionCompra;
	}

	public Border setResaltarid_empresaRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRequisicionCompra() {
		return this.resaltarid_empresaRequisicionCompra;
	}

	public void setResaltarid_empresaRequisicionCompra(Border borderResaltar) {
		this.resaltarid_empresaRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaRequisicionCompra() {
		return this.mostrarid_empresaRequisicionCompra;
	}

	public void setMostrarid_empresaRequisicionCompra(Boolean mostrarid_empresaRequisicionCompra) {
		this.mostrarid_empresaRequisicionCompra= mostrarid_empresaRequisicionCompra;
	}

	public Boolean getActivarid_empresaRequisicionCompra() {
		return this.activarid_empresaRequisicionCompra;
	}

	public void setActivarid_empresaRequisicionCompra(Boolean activarid_empresaRequisicionCompra) {
		this.activarid_empresaRequisicionCompra= activarid_empresaRequisicionCompra;
	}

	public Boolean getCargarid_empresaRequisicionCompra() {
		return this.cargarid_empresaRequisicionCompra;
	}

	public void setCargarid_empresaRequisicionCompra(Boolean cargarid_empresaRequisicionCompra) {
		this.cargarid_empresaRequisicionCompra= cargarid_empresaRequisicionCompra;
	}

	public Border setResaltarid_sucursalRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRequisicionCompra() {
		return this.resaltarid_sucursalRequisicionCompra;
	}

	public void setResaltarid_sucursalRequisicionCompra(Border borderResaltar) {
		this.resaltarid_sucursalRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRequisicionCompra() {
		return this.mostrarid_sucursalRequisicionCompra;
	}

	public void setMostrarid_sucursalRequisicionCompra(Boolean mostrarid_sucursalRequisicionCompra) {
		this.mostrarid_sucursalRequisicionCompra= mostrarid_sucursalRequisicionCompra;
	}

	public Boolean getActivarid_sucursalRequisicionCompra() {
		return this.activarid_sucursalRequisicionCompra;
	}

	public void setActivarid_sucursalRequisicionCompra(Boolean activarid_sucursalRequisicionCompra) {
		this.activarid_sucursalRequisicionCompra= activarid_sucursalRequisicionCompra;
	}

	public Boolean getCargarid_sucursalRequisicionCompra() {
		return this.cargarid_sucursalRequisicionCompra;
	}

	public void setCargarid_sucursalRequisicionCompra(Boolean cargarid_sucursalRequisicionCompra) {
		this.cargarid_sucursalRequisicionCompra= cargarid_sucursalRequisicionCompra;
	}

	public Border setResaltarid_moduloRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_moduloRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloRequisicionCompra() {
		return this.resaltarid_moduloRequisicionCompra;
	}

	public void setResaltarid_moduloRequisicionCompra(Border borderResaltar) {
		this.resaltarid_moduloRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_moduloRequisicionCompra() {
		return this.mostrarid_moduloRequisicionCompra;
	}

	public void setMostrarid_moduloRequisicionCompra(Boolean mostrarid_moduloRequisicionCompra) {
		this.mostrarid_moduloRequisicionCompra= mostrarid_moduloRequisicionCompra;
	}

	public Boolean getActivarid_moduloRequisicionCompra() {
		return this.activarid_moduloRequisicionCompra;
	}

	public void setActivarid_moduloRequisicionCompra(Boolean activarid_moduloRequisicionCompra) {
		this.activarid_moduloRequisicionCompra= activarid_moduloRequisicionCompra;
	}

	public Boolean getCargarid_moduloRequisicionCompra() {
		return this.cargarid_moduloRequisicionCompra;
	}

	public void setCargarid_moduloRequisicionCompra(Boolean cargarid_moduloRequisicionCompra) {
		this.cargarid_moduloRequisicionCompra= cargarid_moduloRequisicionCompra;
	}

	public Border setResaltarid_ejercicioRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioRequisicionCompra() {
		return this.resaltarid_ejercicioRequisicionCompra;
	}

	public void setResaltarid_ejercicioRequisicionCompra(Border borderResaltar) {
		this.resaltarid_ejercicioRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioRequisicionCompra() {
		return this.mostrarid_ejercicioRequisicionCompra;
	}

	public void setMostrarid_ejercicioRequisicionCompra(Boolean mostrarid_ejercicioRequisicionCompra) {
		this.mostrarid_ejercicioRequisicionCompra= mostrarid_ejercicioRequisicionCompra;
	}

	public Boolean getActivarid_ejercicioRequisicionCompra() {
		return this.activarid_ejercicioRequisicionCompra;
	}

	public void setActivarid_ejercicioRequisicionCompra(Boolean activarid_ejercicioRequisicionCompra) {
		this.activarid_ejercicioRequisicionCompra= activarid_ejercicioRequisicionCompra;
	}

	public Boolean getCargarid_ejercicioRequisicionCompra() {
		return this.cargarid_ejercicioRequisicionCompra;
	}

	public void setCargarid_ejercicioRequisicionCompra(Boolean cargarid_ejercicioRequisicionCompra) {
		this.cargarid_ejercicioRequisicionCompra= cargarid_ejercicioRequisicionCompra;
	}

	public Border setResaltarid_periodoRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_periodoRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoRequisicionCompra() {
		return this.resaltarid_periodoRequisicionCompra;
	}

	public void setResaltarid_periodoRequisicionCompra(Border borderResaltar) {
		this.resaltarid_periodoRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoRequisicionCompra() {
		return this.mostrarid_periodoRequisicionCompra;
	}

	public void setMostrarid_periodoRequisicionCompra(Boolean mostrarid_periodoRequisicionCompra) {
		this.mostrarid_periodoRequisicionCompra= mostrarid_periodoRequisicionCompra;
	}

	public Boolean getActivarid_periodoRequisicionCompra() {
		return this.activarid_periodoRequisicionCompra;
	}

	public void setActivarid_periodoRequisicionCompra(Boolean activarid_periodoRequisicionCompra) {
		this.activarid_periodoRequisicionCompra= activarid_periodoRequisicionCompra;
	}

	public Boolean getCargarid_periodoRequisicionCompra() {
		return this.cargarid_periodoRequisicionCompra;
	}

	public void setCargarid_periodoRequisicionCompra(Boolean cargarid_periodoRequisicionCompra) {
		this.cargarid_periodoRequisicionCompra= cargarid_periodoRequisicionCompra;
	}

	public Border setResaltarid_anioRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_anioRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioRequisicionCompra() {
		return this.resaltarid_anioRequisicionCompra;
	}

	public void setResaltarid_anioRequisicionCompra(Border borderResaltar) {
		this.resaltarid_anioRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_anioRequisicionCompra() {
		return this.mostrarid_anioRequisicionCompra;
	}

	public void setMostrarid_anioRequisicionCompra(Boolean mostrarid_anioRequisicionCompra) {
		this.mostrarid_anioRequisicionCompra= mostrarid_anioRequisicionCompra;
	}

	public Boolean getActivarid_anioRequisicionCompra() {
		return this.activarid_anioRequisicionCompra;
	}

	public void setActivarid_anioRequisicionCompra(Boolean activarid_anioRequisicionCompra) {
		this.activarid_anioRequisicionCompra= activarid_anioRequisicionCompra;
	}

	public Boolean getCargarid_anioRequisicionCompra() {
		return this.cargarid_anioRequisicionCompra;
	}

	public void setCargarid_anioRequisicionCompra(Boolean cargarid_anioRequisicionCompra) {
		this.cargarid_anioRequisicionCompra= cargarid_anioRequisicionCompra;
	}

	public Border setResaltarid_mesRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_mesRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesRequisicionCompra() {
		return this.resaltarid_mesRequisicionCompra;
	}

	public void setResaltarid_mesRequisicionCompra(Border borderResaltar) {
		this.resaltarid_mesRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_mesRequisicionCompra() {
		return this.mostrarid_mesRequisicionCompra;
	}

	public void setMostrarid_mesRequisicionCompra(Boolean mostrarid_mesRequisicionCompra) {
		this.mostrarid_mesRequisicionCompra= mostrarid_mesRequisicionCompra;
	}

	public Boolean getActivarid_mesRequisicionCompra() {
		return this.activarid_mesRequisicionCompra;
	}

	public void setActivarid_mesRequisicionCompra(Boolean activarid_mesRequisicionCompra) {
		this.activarid_mesRequisicionCompra= activarid_mesRequisicionCompra;
	}

	public Boolean getCargarid_mesRequisicionCompra() {
		return this.cargarid_mesRequisicionCompra;
	}

	public void setCargarid_mesRequisicionCompra(Boolean cargarid_mesRequisicionCompra) {
		this.cargarid_mesRequisicionCompra= cargarid_mesRequisicionCompra;
	}

	public Border setResaltarnumero_secuencialRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialRequisicionCompra() {
		return this.resaltarnumero_secuencialRequisicionCompra;
	}

	public void setResaltarnumero_secuencialRequisicionCompra(Border borderResaltar) {
		this.resaltarnumero_secuencialRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialRequisicionCompra() {
		return this.mostrarnumero_secuencialRequisicionCompra;
	}

	public void setMostrarnumero_secuencialRequisicionCompra(Boolean mostrarnumero_secuencialRequisicionCompra) {
		this.mostrarnumero_secuencialRequisicionCompra= mostrarnumero_secuencialRequisicionCompra;
	}

	public Boolean getActivarnumero_secuencialRequisicionCompra() {
		return this.activarnumero_secuencialRequisicionCompra;
	}

	public void setActivarnumero_secuencialRequisicionCompra(Boolean activarnumero_secuencialRequisicionCompra) {
		this.activarnumero_secuencialRequisicionCompra= activarnumero_secuencialRequisicionCompra;
	}

	public Border setResaltarid_clienteRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_clienteRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteRequisicionCompra() {
		return this.resaltarid_clienteRequisicionCompra;
	}

	public void setResaltarid_clienteRequisicionCompra(Border borderResaltar) {
		this.resaltarid_clienteRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_clienteRequisicionCompra() {
		return this.mostrarid_clienteRequisicionCompra;
	}

	public void setMostrarid_clienteRequisicionCompra(Boolean mostrarid_clienteRequisicionCompra) {
		this.mostrarid_clienteRequisicionCompra= mostrarid_clienteRequisicionCompra;
	}

	public Boolean getActivarid_clienteRequisicionCompra() {
		return this.activarid_clienteRequisicionCompra;
	}

	public void setActivarid_clienteRequisicionCompra(Boolean activarid_clienteRequisicionCompra) {
		this.activarid_clienteRequisicionCompra= activarid_clienteRequisicionCompra;
	}

	public Boolean getCargarid_clienteRequisicionCompra() {
		return this.cargarid_clienteRequisicionCompra;
	}

	public void setCargarid_clienteRequisicionCompra(Boolean cargarid_clienteRequisicionCompra) {
		this.cargarid_clienteRequisicionCompra= cargarid_clienteRequisicionCompra;
	}

	public Border setResaltarid_usuarioRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_usuarioRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioRequisicionCompra() {
		return this.resaltarid_usuarioRequisicionCompra;
	}

	public void setResaltarid_usuarioRequisicionCompra(Border borderResaltar) {
		this.resaltarid_usuarioRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_usuarioRequisicionCompra() {
		return this.mostrarid_usuarioRequisicionCompra;
	}

	public void setMostrarid_usuarioRequisicionCompra(Boolean mostrarid_usuarioRequisicionCompra) {
		this.mostrarid_usuarioRequisicionCompra= mostrarid_usuarioRequisicionCompra;
	}

	public Boolean getActivarid_usuarioRequisicionCompra() {
		return this.activarid_usuarioRequisicionCompra;
	}

	public void setActivarid_usuarioRequisicionCompra(Boolean activarid_usuarioRequisicionCompra) {
		this.activarid_usuarioRequisicionCompra= activarid_usuarioRequisicionCompra;
	}

	public Boolean getCargarid_usuarioRequisicionCompra() {
		return this.cargarid_usuarioRequisicionCompra;
	}

	public void setCargarid_usuarioRequisicionCompra(Boolean cargarid_usuarioRequisicionCompra) {
		this.cargarid_usuarioRequisicionCompra= cargarid_usuarioRequisicionCompra;
	}

	public Border setResaltarid_monedaRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_monedaRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaRequisicionCompra() {
		return this.resaltarid_monedaRequisicionCompra;
	}

	public void setResaltarid_monedaRequisicionCompra(Border borderResaltar) {
		this.resaltarid_monedaRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_monedaRequisicionCompra() {
		return this.mostrarid_monedaRequisicionCompra;
	}

	public void setMostrarid_monedaRequisicionCompra(Boolean mostrarid_monedaRequisicionCompra) {
		this.mostrarid_monedaRequisicionCompra= mostrarid_monedaRequisicionCompra;
	}

	public Boolean getActivarid_monedaRequisicionCompra() {
		return this.activarid_monedaRequisicionCompra;
	}

	public void setActivarid_monedaRequisicionCompra(Boolean activarid_monedaRequisicionCompra) {
		this.activarid_monedaRequisicionCompra= activarid_monedaRequisicionCompra;
	}

	public Boolean getCargarid_monedaRequisicionCompra() {
		return this.cargarid_monedaRequisicionCompra;
	}

	public void setCargarid_monedaRequisicionCompra(Boolean cargarid_monedaRequisicionCompra) {
		this.cargarid_monedaRequisicionCompra= cargarid_monedaRequisicionCompra;
	}

	public Border setResaltarid_estado_requisicion_compraRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_requisicion_compraRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_requisicion_compraRequisicionCompra() {
		return this.resaltarid_estado_requisicion_compraRequisicionCompra;
	}

	public void setResaltarid_estado_requisicion_compraRequisicionCompra(Border borderResaltar) {
		this.resaltarid_estado_requisicion_compraRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_requisicion_compraRequisicionCompra() {
		return this.mostrarid_estado_requisicion_compraRequisicionCompra;
	}

	public void setMostrarid_estado_requisicion_compraRequisicionCompra(Boolean mostrarid_estado_requisicion_compraRequisicionCompra) {
		this.mostrarid_estado_requisicion_compraRequisicionCompra= mostrarid_estado_requisicion_compraRequisicionCompra;
	}

	public Boolean getActivarid_estado_requisicion_compraRequisicionCompra() {
		return this.activarid_estado_requisicion_compraRequisicionCompra;
	}

	public void setActivarid_estado_requisicion_compraRequisicionCompra(Boolean activarid_estado_requisicion_compraRequisicionCompra) {
		this.activarid_estado_requisicion_compraRequisicionCompra= activarid_estado_requisicion_compraRequisicionCompra;
	}

	public Boolean getCargarid_estado_requisicion_compraRequisicionCompra() {
		return this.cargarid_estado_requisicion_compraRequisicionCompra;
	}

	public void setCargarid_estado_requisicion_compraRequisicionCompra(Boolean cargarid_estado_requisicion_compraRequisicionCompra) {
		this.cargarid_estado_requisicion_compraRequisicionCompra= cargarid_estado_requisicion_compraRequisicionCompra;
	}

	public Border setResaltartotalRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltartotalRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalRequisicionCompra() {
		return this.resaltartotalRequisicionCompra;
	}

	public void setResaltartotalRequisicionCompra(Border borderResaltar) {
		this.resaltartotalRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrartotalRequisicionCompra() {
		return this.mostrartotalRequisicionCompra;
	}

	public void setMostrartotalRequisicionCompra(Boolean mostrartotalRequisicionCompra) {
		this.mostrartotalRequisicionCompra= mostrartotalRequisicionCompra;
	}

	public Boolean getActivartotalRequisicionCompra() {
		return this.activartotalRequisicionCompra;
	}

	public void setActivartotalRequisicionCompra(Boolean activartotalRequisicionCompra) {
		this.activartotalRequisicionCompra= activartotalRequisicionCompra;
	}

	public Border setResaltarfechaRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarfechaRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaRequisicionCompra() {
		return this.resaltarfechaRequisicionCompra;
	}

	public void setResaltarfechaRequisicionCompra(Border borderResaltar) {
		this.resaltarfechaRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarfechaRequisicionCompra() {
		return this.mostrarfechaRequisicionCompra;
	}

	public void setMostrarfechaRequisicionCompra(Boolean mostrarfechaRequisicionCompra) {
		this.mostrarfechaRequisicionCompra= mostrarfechaRequisicionCompra;
	}

	public Boolean getActivarfechaRequisicionCompra() {
		return this.activarfechaRequisicionCompra;
	}

	public void setActivarfechaRequisicionCompra(Boolean activarfechaRequisicionCompra) {
		this.activarfechaRequisicionCompra= activarfechaRequisicionCompra;
	}

	public Border setResaltarid_empleadoRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_empleadoRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoRequisicionCompra() {
		return this.resaltarid_empleadoRequisicionCompra;
	}

	public void setResaltarid_empleadoRequisicionCompra(Border borderResaltar) {
		this.resaltarid_empleadoRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_empleadoRequisicionCompra() {
		return this.mostrarid_empleadoRequisicionCompra;
	}

	public void setMostrarid_empleadoRequisicionCompra(Boolean mostrarid_empleadoRequisicionCompra) {
		this.mostrarid_empleadoRequisicionCompra= mostrarid_empleadoRequisicionCompra;
	}

	public Boolean getActivarid_empleadoRequisicionCompra() {
		return this.activarid_empleadoRequisicionCompra;
	}

	public void setActivarid_empleadoRequisicionCompra(Boolean activarid_empleadoRequisicionCompra) {
		this.activarid_empleadoRequisicionCompra= activarid_empleadoRequisicionCompra;
	}

	public Boolean getCargarid_empleadoRequisicionCompra() {
		return this.cargarid_empleadoRequisicionCompra;
	}

	public void setCargarid_empleadoRequisicionCompra(Boolean cargarid_empleadoRequisicionCompra) {
		this.cargarid_empleadoRequisicionCompra= cargarid_empleadoRequisicionCompra;
	}

	public Border setResaltarresponsableRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarresponsableRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsableRequisicionCompra() {
		return this.resaltarresponsableRequisicionCompra;
	}

	public void setResaltarresponsableRequisicionCompra(Border borderResaltar) {
		this.resaltarresponsableRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarresponsableRequisicionCompra() {
		return this.mostrarresponsableRequisicionCompra;
	}

	public void setMostrarresponsableRequisicionCompra(Boolean mostrarresponsableRequisicionCompra) {
		this.mostrarresponsableRequisicionCompra= mostrarresponsableRequisicionCompra;
	}

	public Boolean getActivarresponsableRequisicionCompra() {
		return this.activarresponsableRequisicionCompra;
	}

	public void setActivarresponsableRequisicionCompra(Boolean activarresponsableRequisicionCompra) {
		this.activarresponsableRequisicionCompra= activarresponsableRequisicionCompra;
	}

	public Border setResaltarsolicitado_porRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarsolicitado_porRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsolicitado_porRequisicionCompra() {
		return this.resaltarsolicitado_porRequisicionCompra;
	}

	public void setResaltarsolicitado_porRequisicionCompra(Border borderResaltar) {
		this.resaltarsolicitado_porRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarsolicitado_porRequisicionCompra() {
		return this.mostrarsolicitado_porRequisicionCompra;
	}

	public void setMostrarsolicitado_porRequisicionCompra(Boolean mostrarsolicitado_porRequisicionCompra) {
		this.mostrarsolicitado_porRequisicionCompra= mostrarsolicitado_porRequisicionCompra;
	}

	public Boolean getActivarsolicitado_porRequisicionCompra() {
		return this.activarsolicitado_porRequisicionCompra;
	}

	public void setActivarsolicitado_porRequisicionCompra(Boolean activarsolicitado_porRequisicionCompra) {
		this.activarsolicitado_porRequisicionCompra= activarsolicitado_porRequisicionCompra;
	}

	public Border setResaltarmotivo_solicitudRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarmotivo_solicitudRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmotivo_solicitudRequisicionCompra() {
		return this.resaltarmotivo_solicitudRequisicionCompra;
	}

	public void setResaltarmotivo_solicitudRequisicionCompra(Border borderResaltar) {
		this.resaltarmotivo_solicitudRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarmotivo_solicitudRequisicionCompra() {
		return this.mostrarmotivo_solicitudRequisicionCompra;
	}

	public void setMostrarmotivo_solicitudRequisicionCompra(Boolean mostrarmotivo_solicitudRequisicionCompra) {
		this.mostrarmotivo_solicitudRequisicionCompra= mostrarmotivo_solicitudRequisicionCompra;
	}

	public Boolean getActivarmotivo_solicitudRequisicionCompra() {
		return this.activarmotivo_solicitudRequisicionCompra;
	}

	public void setActivarmotivo_solicitudRequisicionCompra(Boolean activarmotivo_solicitudRequisicionCompra) {
		this.activarmotivo_solicitudRequisicionCompra= activarmotivo_solicitudRequisicionCompra;
	}

	public Border setResaltararea_solicitudRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltararea_solicitudRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltararea_solicitudRequisicionCompra() {
		return this.resaltararea_solicitudRequisicionCompra;
	}

	public void setResaltararea_solicitudRequisicionCompra(Border borderResaltar) {
		this.resaltararea_solicitudRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrararea_solicitudRequisicionCompra() {
		return this.mostrararea_solicitudRequisicionCompra;
	}

	public void setMostrararea_solicitudRequisicionCompra(Boolean mostrararea_solicitudRequisicionCompra) {
		this.mostrararea_solicitudRequisicionCompra= mostrararea_solicitudRequisicionCompra;
	}

	public Boolean getActivararea_solicitudRequisicionCompra() {
		return this.activararea_solicitudRequisicionCompra;
	}

	public void setActivararea_solicitudRequisicionCompra(Boolean activararea_solicitudRequisicionCompra) {
		this.activararea_solicitudRequisicionCompra= activararea_solicitudRequisicionCompra;
	}

	public Border setResaltarpara_uso_deRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarpara_uso_deRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpara_uso_deRequisicionCompra() {
		return this.resaltarpara_uso_deRequisicionCompra;
	}

	public void setResaltarpara_uso_deRequisicionCompra(Border borderResaltar) {
		this.resaltarpara_uso_deRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarpara_uso_deRequisicionCompra() {
		return this.mostrarpara_uso_deRequisicionCompra;
	}

	public void setMostrarpara_uso_deRequisicionCompra(Boolean mostrarpara_uso_deRequisicionCompra) {
		this.mostrarpara_uso_deRequisicionCompra= mostrarpara_uso_deRequisicionCompra;
	}

	public Boolean getActivarpara_uso_deRequisicionCompra() {
		return this.activarpara_uso_deRequisicionCompra;
	}

	public void setActivarpara_uso_deRequisicionCompra(Boolean activarpara_uso_deRequisicionCompra) {
		this.activarpara_uso_deRequisicionCompra= activarpara_uso_deRequisicionCompra;
	}

	public Border setResaltarlugar_entregaRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarlugar_entregaRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlugar_entregaRequisicionCompra() {
		return this.resaltarlugar_entregaRequisicionCompra;
	}

	public void setResaltarlugar_entregaRequisicionCompra(Border borderResaltar) {
		this.resaltarlugar_entregaRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarlugar_entregaRequisicionCompra() {
		return this.mostrarlugar_entregaRequisicionCompra;
	}

	public void setMostrarlugar_entregaRequisicionCompra(Boolean mostrarlugar_entregaRequisicionCompra) {
		this.mostrarlugar_entregaRequisicionCompra= mostrarlugar_entregaRequisicionCompra;
	}

	public Boolean getActivarlugar_entregaRequisicionCompra() {
		return this.activarlugar_entregaRequisicionCompra;
	}

	public void setActivarlugar_entregaRequisicionCompra(Boolean activarlugar_entregaRequisicionCompra) {
		this.activarlugar_entregaRequisicionCompra= activarlugar_entregaRequisicionCompra;
	}

	public Border setResaltardescripcionRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltardescripcionRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionRequisicionCompra() {
		return this.resaltardescripcionRequisicionCompra;
	}

	public void setResaltardescripcionRequisicionCompra(Border borderResaltar) {
		this.resaltardescripcionRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionRequisicionCompra() {
		return this.mostrardescripcionRequisicionCompra;
	}

	public void setMostrardescripcionRequisicionCompra(Boolean mostrardescripcionRequisicionCompra) {
		this.mostrardescripcionRequisicionCompra= mostrardescripcionRequisicionCompra;
	}

	public Boolean getActivardescripcionRequisicionCompra() {
		return this.activardescripcionRequisicionCompra;
	}

	public void setActivardescripcionRequisicionCompra(Boolean activardescripcionRequisicionCompra) {
		this.activardescripcionRequisicionCompra= activardescripcionRequisicionCompra;
	}

	public Border setResaltarfecha_emisionRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionRequisicionCompra() {
		return this.resaltarfecha_emisionRequisicionCompra;
	}

	public void setResaltarfecha_emisionRequisicionCompra(Border borderResaltar) {
		this.resaltarfecha_emisionRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionRequisicionCompra() {
		return this.mostrarfecha_emisionRequisicionCompra;
	}

	public void setMostrarfecha_emisionRequisicionCompra(Boolean mostrarfecha_emisionRequisicionCompra) {
		this.mostrarfecha_emisionRequisicionCompra= mostrarfecha_emisionRequisicionCompra;
	}

	public Boolean getActivarfecha_emisionRequisicionCompra() {
		return this.activarfecha_emisionRequisicionCompra;
	}

	public void setActivarfecha_emisionRequisicionCompra(Boolean activarfecha_emisionRequisicionCompra) {
		this.activarfecha_emisionRequisicionCompra= activarfecha_emisionRequisicionCompra;
	}

	public Border setResaltarfecha_entregaRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaRequisicionCompra() {
		return this.resaltarfecha_entregaRequisicionCompra;
	}

	public void setResaltarfecha_entregaRequisicionCompra(Border borderResaltar) {
		this.resaltarfecha_entregaRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaRequisicionCompra() {
		return this.mostrarfecha_entregaRequisicionCompra;
	}

	public void setMostrarfecha_entregaRequisicionCompra(Boolean mostrarfecha_entregaRequisicionCompra) {
		this.mostrarfecha_entregaRequisicionCompra= mostrarfecha_entregaRequisicionCompra;
	}

	public Boolean getActivarfecha_entregaRequisicionCompra() {
		return this.activarfecha_entregaRequisicionCompra;
	}

	public void setActivarfecha_entregaRequisicionCompra(Boolean activarfecha_entregaRequisicionCompra) {
		this.activarfecha_entregaRequisicionCompra= activarfecha_entregaRequisicionCompra;
	}

	public Border setResaltarid_formatoRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_formatoRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoRequisicionCompra() {
		return this.resaltarid_formatoRequisicionCompra;
	}

	public void setResaltarid_formatoRequisicionCompra(Border borderResaltar) {
		this.resaltarid_formatoRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_formatoRequisicionCompra() {
		return this.mostrarid_formatoRequisicionCompra;
	}

	public void setMostrarid_formatoRequisicionCompra(Boolean mostrarid_formatoRequisicionCompra) {
		this.mostrarid_formatoRequisicionCompra= mostrarid_formatoRequisicionCompra;
	}

	public Boolean getActivarid_formatoRequisicionCompra() {
		return this.activarid_formatoRequisicionCompra;
	}

	public void setActivarid_formatoRequisicionCompra(Boolean activarid_formatoRequisicionCompra) {
		this.activarid_formatoRequisicionCompra= activarid_formatoRequisicionCompra;
	}

	public Boolean getCargarid_formatoRequisicionCompra() {
		return this.cargarid_formatoRequisicionCompra;
	}

	public void setCargarid_formatoRequisicionCompra(Boolean cargarid_formatoRequisicionCompra) {
		this.cargarid_formatoRequisicionCompra= cargarid_formatoRequisicionCompra;
	}

	public Border setResaltarid_tipo_cambioRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioRequisicionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioRequisicionCompra() {
		return this.resaltarid_tipo_cambioRequisicionCompra;
	}

	public void setResaltarid_tipo_cambioRequisicionCompra(Border borderResaltar) {
		this.resaltarid_tipo_cambioRequisicionCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioRequisicionCompra() {
		return this.mostrarid_tipo_cambioRequisicionCompra;
	}

	public void setMostrarid_tipo_cambioRequisicionCompra(Boolean mostrarid_tipo_cambioRequisicionCompra) {
		this.mostrarid_tipo_cambioRequisicionCompra= mostrarid_tipo_cambioRequisicionCompra;
	}

	public Boolean getActivarid_tipo_cambioRequisicionCompra() {
		return this.activarid_tipo_cambioRequisicionCompra;
	}

	public void setActivarid_tipo_cambioRequisicionCompra(Boolean activarid_tipo_cambioRequisicionCompra) {
		this.activarid_tipo_cambioRequisicionCompra= activarid_tipo_cambioRequisicionCompra;
	}

	public Boolean getCargarid_tipo_cambioRequisicionCompra() {
		return this.cargarid_tipo_cambioRequisicionCompra;
	}

	public void setCargarid_tipo_cambioRequisicionCompra(Boolean cargarid_tipo_cambioRequisicionCompra) {
		this.cargarid_tipo_cambioRequisicionCompra= cargarid_tipo_cambioRequisicionCompra;
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
		
		
		this.setMostraridRequisicionCompra(esInicial);
		this.setMostrarid_empresaRequisicionCompra(esInicial);
		this.setMostrarid_sucursalRequisicionCompra(esInicial);
		this.setMostrarid_moduloRequisicionCompra(esInicial);
		this.setMostrarid_ejercicioRequisicionCompra(esInicial);
		this.setMostrarid_periodoRequisicionCompra(esInicial);
		this.setMostrarid_anioRequisicionCompra(esInicial);
		this.setMostrarid_mesRequisicionCompra(esInicial);
		this.setMostrarnumero_secuencialRequisicionCompra(esInicial);
		this.setMostrarid_clienteRequisicionCompra(esInicial);
		this.setMostrarid_usuarioRequisicionCompra(esInicial);
		this.setMostrarid_monedaRequisicionCompra(esInicial);
		this.setMostrarid_estado_requisicion_compraRequisicionCompra(esInicial);
		this.setMostrartotalRequisicionCompra(esInicial);
		this.setMostrarfechaRequisicionCompra(esInicial);
		this.setMostrarid_empleadoRequisicionCompra(esInicial);
		this.setMostrarresponsableRequisicionCompra(esInicial);
		this.setMostrarsolicitado_porRequisicionCompra(esInicial);
		this.setMostrarmotivo_solicitudRequisicionCompra(esInicial);
		this.setMostrararea_solicitudRequisicionCompra(esInicial);
		this.setMostrarpara_uso_deRequisicionCompra(esInicial);
		this.setMostrarlugar_entregaRequisicionCompra(esInicial);
		this.setMostrardescripcionRequisicionCompra(esInicial);
		this.setMostrarfecha_emisionRequisicionCompra(esInicial);
		this.setMostrarfecha_entregaRequisicionCompra(esInicial);
		this.setMostrarid_formatoRequisicionCompra(esInicial);
		this.setMostrarid_tipo_cambioRequisicionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.ID)) {
				this.setMostraridRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA)) {
				this.setMostrarid_estado_requisicion_compraRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.TOTAL)) {
				this.setMostrartotalRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHA)) {
				this.setMostrarfechaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsableRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.SOLICITADOPOR)) {
				this.setMostrarsolicitado_porRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD)) {
				this.setMostrarmotivo_solicitudRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.AREASOLICITUD)) {
				this.setMostrararea_solicitudRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.PARAUSODE)) {
				this.setMostrarpara_uso_deRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.LUGARENTREGA)) {
				this.setMostrarlugar_entregaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioRequisicionCompra(esAsigna);
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
		
		
		this.setActivaridRequisicionCompra(esInicial);
		this.setActivarid_empresaRequisicionCompra(esInicial);
		this.setActivarid_sucursalRequisicionCompra(esInicial);
		this.setActivarid_moduloRequisicionCompra(esInicial);
		this.setActivarid_ejercicioRequisicionCompra(esInicial);
		this.setActivarid_periodoRequisicionCompra(esInicial);
		this.setActivarid_anioRequisicionCompra(esInicial);
		this.setActivarid_mesRequisicionCompra(esInicial);
		this.setActivarnumero_secuencialRequisicionCompra(esInicial);
		this.setActivarid_clienteRequisicionCompra(esInicial);
		this.setActivarid_usuarioRequisicionCompra(esInicial);
		this.setActivarid_monedaRequisicionCompra(esInicial);
		this.setActivarid_estado_requisicion_compraRequisicionCompra(esInicial);
		this.setActivartotalRequisicionCompra(esInicial);
		this.setActivarfechaRequisicionCompra(esInicial);
		this.setActivarid_empleadoRequisicionCompra(esInicial);
		this.setActivarresponsableRequisicionCompra(esInicial);
		this.setActivarsolicitado_porRequisicionCompra(esInicial);
		this.setActivarmotivo_solicitudRequisicionCompra(esInicial);
		this.setActivararea_solicitudRequisicionCompra(esInicial);
		this.setActivarpara_uso_deRequisicionCompra(esInicial);
		this.setActivarlugar_entregaRequisicionCompra(esInicial);
		this.setActivardescripcionRequisicionCompra(esInicial);
		this.setActivarfecha_emisionRequisicionCompra(esInicial);
		this.setActivarfecha_entregaRequisicionCompra(esInicial);
		this.setActivarid_formatoRequisicionCompra(esInicial);
		this.setActivarid_tipo_cambioRequisicionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.ID)) {
				this.setActivaridRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMES)) {
				this.setActivarid_mesRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA)) {
				this.setActivarid_estado_requisicion_compraRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.TOTAL)) {
				this.setActivartotalRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHA)) {
				this.setActivarfechaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsableRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.SOLICITADOPOR)) {
				this.setActivarsolicitado_porRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD)) {
				this.setActivarmotivo_solicitudRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.AREASOLICITUD)) {
				this.setActivararea_solicitudRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.PARAUSODE)) {
				this.setActivarpara_uso_deRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.LUGARENTREGA)) {
				this.setActivarlugar_entregaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioRequisicionCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRequisicionCompra(esInicial);
		this.setResaltarid_empresaRequisicionCompra(esInicial);
		this.setResaltarid_sucursalRequisicionCompra(esInicial);
		this.setResaltarid_moduloRequisicionCompra(esInicial);
		this.setResaltarid_ejercicioRequisicionCompra(esInicial);
		this.setResaltarid_periodoRequisicionCompra(esInicial);
		this.setResaltarid_anioRequisicionCompra(esInicial);
		this.setResaltarid_mesRequisicionCompra(esInicial);
		this.setResaltarnumero_secuencialRequisicionCompra(esInicial);
		this.setResaltarid_clienteRequisicionCompra(esInicial);
		this.setResaltarid_usuarioRequisicionCompra(esInicial);
		this.setResaltarid_monedaRequisicionCompra(esInicial);
		this.setResaltarid_estado_requisicion_compraRequisicionCompra(esInicial);
		this.setResaltartotalRequisicionCompra(esInicial);
		this.setResaltarfechaRequisicionCompra(esInicial);
		this.setResaltarid_empleadoRequisicionCompra(esInicial);
		this.setResaltarresponsableRequisicionCompra(esInicial);
		this.setResaltarsolicitado_porRequisicionCompra(esInicial);
		this.setResaltarmotivo_solicitudRequisicionCompra(esInicial);
		this.setResaltararea_solicitudRequisicionCompra(esInicial);
		this.setResaltarpara_uso_deRequisicionCompra(esInicial);
		this.setResaltarlugar_entregaRequisicionCompra(esInicial);
		this.setResaltardescripcionRequisicionCompra(esInicial);
		this.setResaltarfecha_emisionRequisicionCompra(esInicial);
		this.setResaltarfecha_entregaRequisicionCompra(esInicial);
		this.setResaltarid_formatoRequisicionCompra(esInicial);
		this.setResaltarid_tipo_cambioRequisicionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.ID)) {
				this.setResaltaridRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDESTADOREQUISICIONCOMPRA)) {
				this.setResaltarid_estado_requisicion_compraRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.TOTAL)) {
				this.setResaltartotalRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHA)) {
				this.setResaltarfechaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsableRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.SOLICITADOPOR)) {
				this.setResaltarsolicitado_porRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.MOTIVOSOLICITUD)) {
				this.setResaltarmotivo_solicitudRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.AREASOLICITUD)) {
				this.setResaltararea_solicitudRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.PARAUSODE)) {
				this.setResaltarpara_uso_deRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.LUGARENTREGA)) {
				this.setResaltarlugar_entregaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoRequisicionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(RequisicionCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioRequisicionCompra(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleRequisicionCompraRequisicionCompra=null;

	public Border getResaltarDetalleRequisicionCompraRequisicionCompra() {
		return this.resaltarDetalleRequisicionCompraRequisicionCompra;
	}

	public void setResaltarDetalleRequisicionCompraRequisicionCompra(Border borderResaltarDetalleRequisicionCompra) {
		if(borderResaltarDetalleRequisicionCompra!=null) {
			this.resaltarDetalleRequisicionCompraRequisicionCompra= borderResaltarDetalleRequisicionCompra;
		}
	}

	public Border setResaltarDetalleRequisicionCompraRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleRequisicionCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//requisicioncompraBeanSwingJInternalFrame.jTtoolBarRequisicionCompra.setBorder(borderResaltarDetalleRequisicionCompra);
			
		this.resaltarDetalleRequisicionCompraRequisicionCompra= borderResaltarDetalleRequisicionCompra;

		 return borderResaltarDetalleRequisicionCompra;
	}



	public Boolean mostrarDetalleRequisicionCompraRequisicionCompra=true;

	public Boolean getMostrarDetalleRequisicionCompraRequisicionCompra() {
		return this.mostrarDetalleRequisicionCompraRequisicionCompra;
	}

	public void setMostrarDetalleRequisicionCompraRequisicionCompra(Boolean visibilidadResaltarDetalleRequisicionCompra) {
		this.mostrarDetalleRequisicionCompraRequisicionCompra= visibilidadResaltarDetalleRequisicionCompra;
	}



	public Boolean activarDetalleRequisicionCompraRequisicionCompra=true;

	public Boolean gethabilitarResaltarDetalleRequisicionCompraRequisicionCompra() {
		return this.activarDetalleRequisicionCompraRequisicionCompra;
	}

	public void setActivarDetalleRequisicionCompraRequisicionCompra(Boolean habilitarResaltarDetalleRequisicionCompra) {
		this.activarDetalleRequisicionCompraRequisicionCompra= habilitarResaltarDetalleRequisicionCompra;
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

		this.setMostrarDetalleRequisicionCompraRequisicionCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRequisicionCompra.class)) {
				this.setMostrarDetalleRequisicionCompraRequisicionCompra(esAsigna);
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

		this.setActivarDetalleRequisicionCompraRequisicionCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRequisicionCompra.class)) {
				this.setActivarDetalleRequisicionCompraRequisicionCompra(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleRequisicionCompraRequisicionCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleRequisicionCompra.class)) {
				this.setResaltarDetalleRequisicionCompraRequisicionCompra(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdClienteRequisicionCompra=true;

	public Boolean getMostrarFK_IdClienteRequisicionCompra() {
		return this.mostrarFK_IdClienteRequisicionCompra;
	}

	public void setMostrarFK_IdClienteRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioRequisicionCompra=true;

	public Boolean getMostrarFK_IdEjercicioRequisicionCompra() {
		return this.mostrarFK_IdEjercicioRequisicionCompra;
	}

	public void setMostrarFK_IdEjercicioRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoRequisicionCompra=true;

	public Boolean getMostrarFK_IdEmpleadoRequisicionCompra() {
		return this.mostrarFK_IdEmpleadoRequisicionCompra;
	}

	public void setMostrarFK_IdEmpleadoRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRequisicionCompra=true;

	public Boolean getMostrarFK_IdEmpresaRequisicionCompra() {
		return this.mostrarFK_IdEmpresaRequisicionCompra;
	}

	public void setMostrarFK_IdEmpresaRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoRequisicionCompraRequisicionCompra=true;

	public Boolean getMostrarFK_IdEstadoRequisicionCompraRequisicionCompra() {
		return this.mostrarFK_IdEstadoRequisicionCompraRequisicionCompra;
	}

	public void setMostrarFK_IdEstadoRequisicionCompraRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoRequisicionCompraRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloRequisicionCompra=true;

	public Boolean getMostrarFK_IdModuloRequisicionCompra() {
		return this.mostrarFK_IdModuloRequisicionCompra;
	}

	public void setMostrarFK_IdModuloRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoRequisicionCompra=true;

	public Boolean getMostrarFK_IdPeriodoRequisicionCompra() {
		return this.mostrarFK_IdPeriodoRequisicionCompra;
	}

	public void setMostrarFK_IdPeriodoRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalRequisicionCompra=true;

	public Boolean getMostrarFK_IdSucursalRequisicionCompra() {
		return this.mostrarFK_IdSucursalRequisicionCompra;
	}

	public void setMostrarFK_IdSucursalRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalRequisicionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioRequisicionCompra=true;

	public Boolean getMostrarFK_IdUsuarioRequisicionCompra() {
		return this.mostrarFK_IdUsuarioRequisicionCompra;
	}

	public void setMostrarFK_IdUsuarioRequisicionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioRequisicionCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdClienteRequisicionCompra=true;

	public Boolean getActivarFK_IdClienteRequisicionCompra() {
		return this.activarFK_IdClienteRequisicionCompra;
	}

	public void setActivarFK_IdClienteRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdClienteRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioRequisicionCompra=true;

	public Boolean getActivarFK_IdEjercicioRequisicionCompra() {
		return this.activarFK_IdEjercicioRequisicionCompra;
	}

	public void setActivarFK_IdEjercicioRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoRequisicionCompra=true;

	public Boolean getActivarFK_IdEmpleadoRequisicionCompra() {
		return this.activarFK_IdEmpleadoRequisicionCompra;
	}

	public void setActivarFK_IdEmpleadoRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRequisicionCompra=true;

	public Boolean getActivarFK_IdEmpresaRequisicionCompra() {
		return this.activarFK_IdEmpresaRequisicionCompra;
	}

	public void setActivarFK_IdEmpresaRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoRequisicionCompraRequisicionCompra=true;

	public Boolean getActivarFK_IdEstadoRequisicionCompraRequisicionCompra() {
		return this.activarFK_IdEstadoRequisicionCompraRequisicionCompra;
	}

	public void setActivarFK_IdEstadoRequisicionCompraRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoRequisicionCompraRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloRequisicionCompra=true;

	public Boolean getActivarFK_IdModuloRequisicionCompra() {
		return this.activarFK_IdModuloRequisicionCompra;
	}

	public void setActivarFK_IdModuloRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdModuloRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoRequisicionCompra=true;

	public Boolean getActivarFK_IdPeriodoRequisicionCompra() {
		return this.activarFK_IdPeriodoRequisicionCompra;
	}

	public void setActivarFK_IdPeriodoRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalRequisicionCompra=true;

	public Boolean getActivarFK_IdSucursalRequisicionCompra() {
		return this.activarFK_IdSucursalRequisicionCompra;
	}

	public void setActivarFK_IdSucursalRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalRequisicionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioRequisicionCompra=true;

	public Boolean getActivarFK_IdUsuarioRequisicionCompra() {
		return this.activarFK_IdUsuarioRequisicionCompra;
	}

	public void setActivarFK_IdUsuarioRequisicionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioRequisicionCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdClienteRequisicionCompra=null;

	public Border getResaltarFK_IdClienteRequisicionCompra() {
		return this.resaltarFK_IdClienteRequisicionCompra;
	}

	public void setResaltarFK_IdClienteRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdClienteRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdClienteRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioRequisicionCompra=null;

	public Border getResaltarFK_IdEjercicioRequisicionCompra() {
		return this.resaltarFK_IdEjercicioRequisicionCompra;
	}

	public void setResaltarFK_IdEjercicioRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoRequisicionCompra=null;

	public Border getResaltarFK_IdEmpleadoRequisicionCompra() {
		return this.resaltarFK_IdEmpleadoRequisicionCompra;
	}

	public void setResaltarFK_IdEmpleadoRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRequisicionCompra=null;

	public Border getResaltarFK_IdEmpresaRequisicionCompra() {
		return this.resaltarFK_IdEmpresaRequisicionCompra;
	}

	public void setResaltarFK_IdEmpresaRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoRequisicionCompraRequisicionCompra=null;

	public Border getResaltarFK_IdEstadoRequisicionCompraRequisicionCompra() {
		return this.resaltarFK_IdEstadoRequisicionCompraRequisicionCompra;
	}

	public void setResaltarFK_IdEstadoRequisicionCompraRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoRequisicionCompraRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoRequisicionCompraRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoRequisicionCompraRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdModuloRequisicionCompra=null;

	public Border getResaltarFK_IdModuloRequisicionCompra() {
		return this.resaltarFK_IdModuloRequisicionCompra;
	}

	public void setResaltarFK_IdModuloRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdModuloRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdModuloRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoRequisicionCompra=null;

	public Border getResaltarFK_IdPeriodoRequisicionCompra() {
		return this.resaltarFK_IdPeriodoRequisicionCompra;
	}

	public void setResaltarFK_IdPeriodoRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalRequisicionCompra=null;

	public Border getResaltarFK_IdSucursalRequisicionCompra() {
		return this.resaltarFK_IdSucursalRequisicionCompra;
	}

	public void setResaltarFK_IdSucursalRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalRequisicionCompra= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioRequisicionCompra=null;

	public Border getResaltarFK_IdUsuarioRequisicionCompra() {
		return this.resaltarFK_IdUsuarioRequisicionCompra;
	}

	public void setResaltarFK_IdUsuarioRequisicionCompra(Border borderResaltar) {
		this.resaltarFK_IdUsuarioRequisicionCompra= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioRequisicionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*RequisicionCompraBeanSwingJInternalFrame requisicioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioRequisicionCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}