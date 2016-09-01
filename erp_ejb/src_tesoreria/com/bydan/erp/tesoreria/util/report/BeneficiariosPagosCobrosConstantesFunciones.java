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
package com.bydan.erp.tesoreria.util.report;

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


import com.bydan.erp.tesoreria.util.report.BeneficiariosPagosCobrosConstantesFunciones;
import com.bydan.erp.tesoreria.util.report.BeneficiariosPagosCobrosParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.report.BeneficiariosPagosCobrosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class BeneficiariosPagosCobrosConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="BeneficiariosPagosCobros";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="BeneficiariosPagosCobros"+BeneficiariosPagosCobrosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="BeneficiariosPagosCobrosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="BeneficiariosPagosCobrosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"_"+BeneficiariosPagosCobrosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/BeneficiariosPagosCobrosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"_"+BeneficiariosPagosCobrosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"_"+BeneficiariosPagosCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/BeneficiariosPagosCobrosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"_"+BeneficiariosPagosCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BeneficiariosPagosCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BeneficiariosPagosCobrosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BeneficiariosPagosCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BeneficiariosPagosCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/BeneficiariosPagosCobrosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+BeneficiariosPagosCobrosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=BeneficiariosPagosCobrosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+BeneficiariosPagosCobrosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=BeneficiariosPagosCobrosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+BeneficiariosPagosCobrosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Beneficiarios Pagos Cobroses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Beneficiarios Pagos Cobros";
	public static final String SCLASSWEBTITULO_LOWER="Beneficiarios Pagos Cobros";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="BeneficiariosPagosCobros";
	public static final String OBJECTNAME="beneficiariospagoscobros";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="beneficiarios_pagos_cobros";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select beneficiariospagoscobros from "+BeneficiariosPagosCobrosConstantesFunciones.SPERSISTENCENAME+" beneficiariospagoscobros";
	public static String QUERYSELECTNATIVE="select "+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".id,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".version_row,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".id_empresa,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".id_sucursal,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".id_ejercicio,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".fecha_desde,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".fecha_hasta,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".codigo_cuenta_contable,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".nombre_cuenta_contable,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".numero_mayor,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".numero_cheque,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".beneficiario,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".debito_local,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".credito_local,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".detalle,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".tipo_movimiento,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".valor,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".cuenta,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".fecha,"+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME+".beneficiario_asiento from "+BeneficiariosPagosCobrosConstantesFunciones.SCHEMA+"."+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME;//+" as "+BeneficiariosPagosCobrosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String CODIGOCUENTACONTABLE= "codigo_cuenta_contable";
    public static final String NOMBRECUENTACONTABLE= "nombre_cuenta_contable";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String BENEFICIARIO= "beneficiario";
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String DETALLE= "detalle";
    public static final String TIPOMOVIMIENTO= "tipo_movimiento";
    public static final String VALOR= "valor";
    public static final String CUENTA= "cuenta";
    public static final String FECHA= "fecha";
    public static final String BENEFICIARIOASIENTO= "beneficiario_asiento";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento Base";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_CODIGOCUENTACONTABLE= "Codigo Cuenta Contable";
		public static final String LABEL_CODIGOCUENTACONTABLE_LOWER= "Codigo Cuenta Contable";
    	public static final String LABEL_NOMBRECUENTACONTABLE= "Nombre Cuenta Contable";
		public static final String LABEL_NOMBRECUENTACONTABLE_LOWER= "Nombre Cuenta Contable";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_BENEFICIARIO= "Beneficiario";
		public static final String LABEL_BENEFICIARIO_LOWER= "Beneficiario";
    	public static final String LABEL_DEBITOLOCAL= "Debito Local";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito Local";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_TIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_TIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_CUENTA= "Cuenta";
		public static final String LABEL_CUENTA_LOWER= "Cuenta";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_BENEFICIARIOASIENTO= "Beneficiario Asiento";
		public static final String LABEL_BENEFICIARIOASIENTO_LOWER= "Beneficiario Asiento";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXBENEFICIARIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXBENEFICIARIO_ASIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXBENEFICIARIO_ASIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getBeneficiariosPagosCobrosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEMPRESA)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEJERCICIO)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHADESDE)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHAHASTA)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIO;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.DETALLE)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_TIPOMOVIMIENTO;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.VALOR)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.CUENTA)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_CUENTA;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHA)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO)) {sLabelColumna=BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIOASIENTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getBeneficiariosPagosCobrosDescripcion(BeneficiariosPagosCobros beneficiariospagoscobros) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(beneficiariospagoscobros !=null/* && beneficiariospagoscobros.getId()!=0*/) {
			if(beneficiariospagoscobros.getId()!=null) {
				sDescripcion=beneficiariospagoscobros.getId().toString();
			}//beneficiariospagoscobrosbeneficiariospagoscobros.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getBeneficiariosPagosCobrosDescripcionDetallado(BeneficiariosPagosCobros beneficiariospagoscobros) {
		String sDescripcion="";
			
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.ID+"=";
		sDescripcion+=beneficiariospagoscobros.getId().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=beneficiariospagoscobros.getVersionRow().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=beneficiariospagoscobros.getid_empresa().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=beneficiariospagoscobros.getid_sucursal().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=beneficiariospagoscobros.getid_ejercicio().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=beneficiariospagoscobros.getid_tipo_movimiento().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=beneficiariospagoscobros.getfecha_desde().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=beneficiariospagoscobros.getfecha_hasta().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE+"=";
		sDescripcion+=beneficiariospagoscobros.getcodigo_cuenta_contable()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE+"=";
		sDescripcion+=beneficiariospagoscobros.getnombre_cuenta_contable()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=beneficiariospagoscobros.getnumero_mayor()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=beneficiariospagoscobros.getnumero_cheque()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO+"=";
		sDescripcion+=beneficiariospagoscobros.getbeneficiario()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=beneficiariospagoscobros.getdebito_local().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=beneficiariospagoscobros.getcredito_local().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.DETALLE+"=";
		sDescripcion+=beneficiariospagoscobros.getdetalle()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO+"=";
		sDescripcion+=beneficiariospagoscobros.gettipo_movimiento()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.VALOR+"=";
		sDescripcion+=beneficiariospagoscobros.getvalor().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.CUENTA+"=";
		sDescripcion+=beneficiariospagoscobros.getcuenta()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.FECHA+"=";
		sDescripcion+=beneficiariospagoscobros.getfecha().toString()+",";
		sDescripcion+=BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO+"=";
		sDescripcion+=beneficiariospagoscobros.getbeneficiario_asiento()+",";
			
		return sDescripcion;
	}
	
	public static void setBeneficiariosPagosCobrosDescripcion(BeneficiariosPagosCobros beneficiariospagoscobros,String sValor) throws Exception {			
		if(beneficiariospagoscobros !=null) {
			//beneficiariospagoscobrosbeneficiariospagoscobros.getId().toString();
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

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaBeneficiariosPagosCobros")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Tipo Movimiento Base Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento Base";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaBeneficiariosPagosCobros(Long id_ejercicio,Long id_tipo_movimiento,Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();}
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento Base="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosBeneficiariosPagosCobros(BeneficiariosPagosCobros beneficiariospagoscobros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		beneficiariospagoscobros.setcodigo_cuenta_contable(beneficiariospagoscobros.getcodigo_cuenta_contable().trim());
		beneficiariospagoscobros.setnombre_cuenta_contable(beneficiariospagoscobros.getnombre_cuenta_contable().trim());
		beneficiariospagoscobros.setnumero_mayor(beneficiariospagoscobros.getnumero_mayor().trim());
		beneficiariospagoscobros.setnumero_cheque(beneficiariospagoscobros.getnumero_cheque().trim());
		beneficiariospagoscobros.setbeneficiario(beneficiariospagoscobros.getbeneficiario().trim());
		beneficiariospagoscobros.setdetalle(beneficiariospagoscobros.getdetalle().trim());
		beneficiariospagoscobros.settipo_movimiento(beneficiariospagoscobros.gettipo_movimiento().trim());
		beneficiariospagoscobros.setcuenta(beneficiariospagoscobros.getcuenta().trim());
		beneficiariospagoscobros.setbeneficiario_asiento(beneficiariospagoscobros.getbeneficiario_asiento().trim());
	}
	
	public static void quitarEspaciosBeneficiariosPagosCobross(List<BeneficiariosPagosCobros> beneficiariospagoscobross,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(BeneficiariosPagosCobros beneficiariospagoscobros: beneficiariospagoscobross) {
			beneficiariospagoscobros.setcodigo_cuenta_contable(beneficiariospagoscobros.getcodigo_cuenta_contable().trim());
			beneficiariospagoscobros.setnombre_cuenta_contable(beneficiariospagoscobros.getnombre_cuenta_contable().trim());
			beneficiariospagoscobros.setnumero_mayor(beneficiariospagoscobros.getnumero_mayor().trim());
			beneficiariospagoscobros.setnumero_cheque(beneficiariospagoscobros.getnumero_cheque().trim());
			beneficiariospagoscobros.setbeneficiario(beneficiariospagoscobros.getbeneficiario().trim());
			beneficiariospagoscobros.setdetalle(beneficiariospagoscobros.getdetalle().trim());
			beneficiariospagoscobros.settipo_movimiento(beneficiariospagoscobros.gettipo_movimiento().trim());
			beneficiariospagoscobros.setcuenta(beneficiariospagoscobros.getcuenta().trim());
			beneficiariospagoscobros.setbeneficiario_asiento(beneficiariospagoscobros.getbeneficiario_asiento().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBeneficiariosPagosCobros(BeneficiariosPagosCobros beneficiariospagoscobros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && beneficiariospagoscobros.getConCambioAuxiliar()) {
			beneficiariospagoscobros.setIsDeleted(beneficiariospagoscobros.getIsDeletedAuxiliar());	
			beneficiariospagoscobros.setIsNew(beneficiariospagoscobros.getIsNewAuxiliar());	
			beneficiariospagoscobros.setIsChanged(beneficiariospagoscobros.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			beneficiariospagoscobros.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			beneficiariospagoscobros.setIsDeletedAuxiliar(false);	
			beneficiariospagoscobros.setIsNewAuxiliar(false);	
			beneficiariospagoscobros.setIsChangedAuxiliar(false);
			
			beneficiariospagoscobros.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresBeneficiariosPagosCobross(List<BeneficiariosPagosCobros> beneficiariospagoscobross,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(BeneficiariosPagosCobros beneficiariospagoscobros : beneficiariospagoscobross) {
			if(conAsignarBase && beneficiariospagoscobros.getConCambioAuxiliar()) {
				beneficiariospagoscobros.setIsDeleted(beneficiariospagoscobros.getIsDeletedAuxiliar());	
				beneficiariospagoscobros.setIsNew(beneficiariospagoscobros.getIsNewAuxiliar());	
				beneficiariospagoscobros.setIsChanged(beneficiariospagoscobros.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				beneficiariospagoscobros.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				beneficiariospagoscobros.setIsDeletedAuxiliar(false);	
				beneficiariospagoscobros.setIsNewAuxiliar(false);	
				beneficiariospagoscobros.setIsChangedAuxiliar(false);
				
				beneficiariospagoscobros.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresBeneficiariosPagosCobros(BeneficiariosPagosCobros beneficiariospagoscobros,Boolean conEnteros) throws Exception  {
		beneficiariospagoscobros.setdebito_local(0.0);
		beneficiariospagoscobros.setcredito_local(0.0);
		beneficiariospagoscobros.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresBeneficiariosPagosCobross(List<BeneficiariosPagosCobros> beneficiariospagoscobross,Boolean conEnteros) throws Exception  {
		
		for(BeneficiariosPagosCobros beneficiariospagoscobros: beneficiariospagoscobross) {
			beneficiariospagoscobros.setdebito_local(0.0);
			beneficiariospagoscobros.setcredito_local(0.0);
			beneficiariospagoscobros.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaBeneficiariosPagosCobros(List<BeneficiariosPagosCobros> beneficiariospagoscobross,BeneficiariosPagosCobros beneficiariospagoscobrosAux) throws Exception  {
		BeneficiariosPagosCobrosConstantesFunciones.InicializarValoresBeneficiariosPagosCobros(beneficiariospagoscobrosAux,true);
		
		for(BeneficiariosPagosCobros beneficiariospagoscobros: beneficiariospagoscobross) {
			if(beneficiariospagoscobros.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			beneficiariospagoscobrosAux.setdebito_local(beneficiariospagoscobrosAux.getdebito_local()+beneficiariospagoscobros.getdebito_local());			
			beneficiariospagoscobrosAux.setcredito_local(beneficiariospagoscobrosAux.getcredito_local()+beneficiariospagoscobros.getcredito_local());			
			beneficiariospagoscobrosAux.setvalor(beneficiariospagoscobrosAux.getvalor()+beneficiariospagoscobros.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesBeneficiariosPagosCobros(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=BeneficiariosPagosCobrosConstantesFunciones.getArrayColumnasGlobalesBeneficiariosPagosCobros(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesBeneficiariosPagosCobros(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BeneficiariosPagosCobrosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BeneficiariosPagosCobrosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BeneficiariosPagosCobrosConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(BeneficiariosPagosCobrosConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoBeneficiariosPagosCobros(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<BeneficiariosPagosCobros> beneficiariospagoscobross,BeneficiariosPagosCobros beneficiariospagoscobros,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(BeneficiariosPagosCobros beneficiariospagoscobrosAux: beneficiariospagoscobross) {
			if(beneficiariospagoscobrosAux!=null && beneficiariospagoscobros!=null) {
				if((beneficiariospagoscobrosAux.getId()==null && beneficiariospagoscobros.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(beneficiariospagoscobrosAux.getId()!=null && beneficiariospagoscobros.getId()!=null){
					if(beneficiariospagoscobrosAux.getId().equals(beneficiariospagoscobros.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaBeneficiariosPagosCobros(List<BeneficiariosPagosCobros> beneficiariospagoscobross) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double valorTotal=0.0;
	
		for(BeneficiariosPagosCobros beneficiariospagoscobros: beneficiariospagoscobross) {			
			if(beneficiariospagoscobros.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=beneficiariospagoscobros.getdebito_local();
			credito_localTotal+=beneficiariospagoscobros.getcredito_local();
			valorTotal+=beneficiariospagoscobros.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaBeneficiariosPagosCobros() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_ID, BeneficiariosPagosCobrosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_VERSIONROW, BeneficiariosPagosCobrosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE, BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE, BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROMAYOR, BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROCHEQUE, BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIO, BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_DEBITOLOCAL, BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_CREDITOLOCAL, BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_DETALLE, BeneficiariosPagosCobrosConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_TIPOMOVIMIENTO, BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_VALOR, BeneficiariosPagosCobrosConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_CUENTA, BeneficiariosPagosCobrosConstantesFunciones.CUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHA, BeneficiariosPagosCobrosConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIOASIENTO, BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasBeneficiariosPagosCobros() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.CUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBeneficiariosPagosCobros() throws Exception  {
		return BeneficiariosPagosCobrosConstantesFunciones.getTiposSeleccionarBeneficiariosPagosCobros(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBeneficiariosPagosCobros(Boolean conFk) throws Exception  {
		return BeneficiariosPagosCobrosConstantesFunciones.getTiposSeleccionarBeneficiariosPagosCobros(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarBeneficiariosPagosCobros(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIO);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_TIPOMOVIMIENTO);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_TIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CUENTA);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIOASIENTO);
			reporte.setsDescripcion(BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIOASIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesBeneficiariosPagosCobros(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesBeneficiariosPagosCobros(BeneficiariosPagosCobros beneficiariospagoscobrosAux) throws Exception {
		
			beneficiariospagoscobrosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(beneficiariospagoscobrosAux.getEmpresa()));
			beneficiariospagoscobrosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(beneficiariospagoscobrosAux.getSucursal()));
			beneficiariospagoscobrosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(beneficiariospagoscobrosAux.getEjercicio()));
			beneficiariospagoscobrosAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(beneficiariospagoscobrosAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesBeneficiariosPagosCobros(List<BeneficiariosPagosCobros> beneficiariospagoscobrossTemp) throws Exception {
		for(BeneficiariosPagosCobros beneficiariospagoscobrosAux:beneficiariospagoscobrossTemp) {
			
			beneficiariospagoscobrosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(beneficiariospagoscobrosAux.getEmpresa()));
			beneficiariospagoscobrosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(beneficiariospagoscobrosAux.getSucursal()));
			beneficiariospagoscobrosAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(beneficiariospagoscobrosAux.getEjercicio()));
			beneficiariospagoscobrosAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(beneficiariospagoscobrosAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfBeneficiariosPagosCobros(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(TipoMovimiento.class));
				
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
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfBeneficiariosPagosCobros(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfBeneficiariosPagosCobros(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return BeneficiariosPagosCobrosConstantesFunciones.getClassesRelationshipsOfBeneficiariosPagosCobros(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBeneficiariosPagosCobros(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBeneficiariosPagosCobros(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return BeneficiariosPagosCobrosConstantesFunciones.getClassesRelationshipsFromStringsOfBeneficiariosPagosCobros(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfBeneficiariosPagosCobros(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
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
	public static void actualizarLista(BeneficiariosPagosCobros beneficiariospagoscobros,List<BeneficiariosPagosCobros> beneficiariospagoscobross,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(BeneficiariosPagosCobros beneficiariospagoscobros,List<BeneficiariosPagosCobros> beneficiariospagoscobross) throws Exception {
		try	{			
			for(BeneficiariosPagosCobros beneficiariospagoscobrosLocal:beneficiariospagoscobross) {
				if(beneficiariospagoscobrosLocal.getId().equals(beneficiariospagoscobros.getId())) {
					beneficiariospagoscobrosLocal.setIsSelected(beneficiariospagoscobros.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesBeneficiariosPagosCobros(List<BeneficiariosPagosCobros> beneficiariospagoscobrossAux) throws Exception {
		//this.beneficiariospagoscobrossAux=beneficiariospagoscobrossAux;
		
		for(BeneficiariosPagosCobros beneficiariospagoscobrosAux:beneficiariospagoscobrossAux) {
			if(beneficiariospagoscobrosAux.getIsChanged()) {
				beneficiariospagoscobrosAux.setIsChanged(false);
			}		
			
			if(beneficiariospagoscobrosAux.getIsNew()) {
				beneficiariospagoscobrosAux.setIsNew(false);
			}	
			
			if(beneficiariospagoscobrosAux.getIsDeleted()) {
				beneficiariospagoscobrosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesBeneficiariosPagosCobros(BeneficiariosPagosCobros beneficiariospagoscobrosAux) throws Exception {
		//this.beneficiariospagoscobrosAux=beneficiariospagoscobrosAux;
		
			if(beneficiariospagoscobrosAux.getIsChanged()) {
				beneficiariospagoscobrosAux.setIsChanged(false);
			}		
			
			if(beneficiariospagoscobrosAux.getIsNew()) {
				beneficiariospagoscobrosAux.setIsNew(false);
			}	
			
			if(beneficiariospagoscobrosAux.getIsDeleted()) {
				beneficiariospagoscobrosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(BeneficiariosPagosCobros beneficiariospagoscobrosAsignar,BeneficiariosPagosCobros beneficiariospagoscobros) throws Exception {
		beneficiariospagoscobrosAsignar.setId(beneficiariospagoscobros.getId());	
		beneficiariospagoscobrosAsignar.setVersionRow(beneficiariospagoscobros.getVersionRow());	
		beneficiariospagoscobrosAsignar.setcodigo_cuenta_contable(beneficiariospagoscobros.getcodigo_cuenta_contable());	
		beneficiariospagoscobrosAsignar.setnombre_cuenta_contable(beneficiariospagoscobros.getnombre_cuenta_contable());	
		beneficiariospagoscobrosAsignar.setnumero_mayor(beneficiariospagoscobros.getnumero_mayor());	
		beneficiariospagoscobrosAsignar.setnumero_cheque(beneficiariospagoscobros.getnumero_cheque());	
		beneficiariospagoscobrosAsignar.setbeneficiario(beneficiariospagoscobros.getbeneficiario());	
		beneficiariospagoscobrosAsignar.setdebito_local(beneficiariospagoscobros.getdebito_local());	
		beneficiariospagoscobrosAsignar.setcredito_local(beneficiariospagoscobros.getcredito_local());	
		beneficiariospagoscobrosAsignar.setdetalle(beneficiariospagoscobros.getdetalle());	
		beneficiariospagoscobrosAsignar.settipo_movimiento(beneficiariospagoscobros.gettipo_movimiento());	
		beneficiariospagoscobrosAsignar.setvalor(beneficiariospagoscobros.getvalor());	
		beneficiariospagoscobrosAsignar.setcuenta(beneficiariospagoscobros.getcuenta());	
		beneficiariospagoscobrosAsignar.setfecha(beneficiariospagoscobros.getfecha());	
		beneficiariospagoscobrosAsignar.setbeneficiario_asiento(beneficiariospagoscobros.getbeneficiario_asiento());	
	}
	
	public static void inicializarBeneficiariosPagosCobros(BeneficiariosPagosCobros beneficiariospagoscobros) throws Exception {
		try {
				beneficiariospagoscobros.setId(0L);	
					
				beneficiariospagoscobros.setcodigo_cuenta_contable("");	
				beneficiariospagoscobros.setnombre_cuenta_contable("");	
				beneficiariospagoscobros.setnumero_mayor("");	
				beneficiariospagoscobros.setnumero_cheque("");	
				beneficiariospagoscobros.setbeneficiario("");	
				beneficiariospagoscobros.setdebito_local(0.0);	
				beneficiariospagoscobros.setcredito_local(0.0);	
				beneficiariospagoscobros.setdetalle("");	
				beneficiariospagoscobros.settipo_movimiento("");	
				beneficiariospagoscobros.setvalor(0.0);	
				beneficiariospagoscobros.setcuenta("");	
				beneficiariospagoscobros.setfecha(new Date());	
				beneficiariospagoscobros.setbeneficiario_asiento("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderBeneficiariosPagosCobros(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_TIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_CUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(BeneficiariosPagosCobrosConstantesFunciones.LABEL_BENEFICIARIOASIENTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataBeneficiariosPagosCobros(String sTipo,Row row,Workbook workbook,BeneficiariosPagosCobros beneficiariospagoscobros,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getcodigo_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getnombre_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getbeneficiario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.gettipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getcuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(beneficiariospagoscobros.getbeneficiario_asiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryBeneficiariosPagosCobros="";
	
	public String getsFinalQueryBeneficiariosPagosCobros() {
		return this.sFinalQueryBeneficiariosPagosCobros;
	}
	
	public void setsFinalQueryBeneficiariosPagosCobros(String sFinalQueryBeneficiariosPagosCobros) {
		this.sFinalQueryBeneficiariosPagosCobros= sFinalQueryBeneficiariosPagosCobros;
	}
	
	public Border resaltarSeleccionarBeneficiariosPagosCobros=null;
	
	public Border setResaltarSeleccionarBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarSeleccionarBeneficiariosPagosCobros= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarBeneficiariosPagosCobros() {
		return this.resaltarSeleccionarBeneficiariosPagosCobros;
	}
	
	public void setResaltarSeleccionarBeneficiariosPagosCobros(Border borderResaltarSeleccionarBeneficiariosPagosCobros) {
		this.resaltarSeleccionarBeneficiariosPagosCobros= borderResaltarSeleccionarBeneficiariosPagosCobros;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridBeneficiariosPagosCobros=null;
	public Boolean mostraridBeneficiariosPagosCobros=true;
	public Boolean activaridBeneficiariosPagosCobros=true;

	public Border resaltarid_empresaBeneficiariosPagosCobros=null;
	public Boolean mostrarid_empresaBeneficiariosPagosCobros=true;
	public Boolean activarid_empresaBeneficiariosPagosCobros=true;
	public Boolean cargarid_empresaBeneficiariosPagosCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaBeneficiariosPagosCobros=false;//ConEventDepend=true

	public Border resaltarid_sucursalBeneficiariosPagosCobros=null;
	public Boolean mostrarid_sucursalBeneficiariosPagosCobros=true;
	public Boolean activarid_sucursalBeneficiariosPagosCobros=true;
	public Boolean cargarid_sucursalBeneficiariosPagosCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalBeneficiariosPagosCobros=false;//ConEventDepend=true

	public Border resaltarid_ejercicioBeneficiariosPagosCobros=null;
	public Boolean mostrarid_ejercicioBeneficiariosPagosCobros=true;
	public Boolean activarid_ejercicioBeneficiariosPagosCobros=true;
	public Boolean cargarid_ejercicioBeneficiariosPagosCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioBeneficiariosPagosCobros=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoBeneficiariosPagosCobros=null;
	public Boolean mostrarid_tipo_movimientoBeneficiariosPagosCobros=true;
	public Boolean activarid_tipo_movimientoBeneficiariosPagosCobros=true;
	public Boolean cargarid_tipo_movimientoBeneficiariosPagosCobros=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoBeneficiariosPagosCobros=false;//ConEventDepend=true

	public Border resaltarfecha_desdeBeneficiariosPagosCobros=null;
	public Boolean mostrarfecha_desdeBeneficiariosPagosCobros=true;
	public Boolean activarfecha_desdeBeneficiariosPagosCobros=true;

	public Border resaltarfecha_hastaBeneficiariosPagosCobros=null;
	public Boolean mostrarfecha_hastaBeneficiariosPagosCobros=true;
	public Boolean activarfecha_hastaBeneficiariosPagosCobros=true;

	public Border resaltarcodigo_cuenta_contableBeneficiariosPagosCobros=null;
	public Boolean mostrarcodigo_cuenta_contableBeneficiariosPagosCobros=true;
	public Boolean activarcodigo_cuenta_contableBeneficiariosPagosCobros=true;

	public Border resaltarnombre_cuenta_contableBeneficiariosPagosCobros=null;
	public Boolean mostrarnombre_cuenta_contableBeneficiariosPagosCobros=true;
	public Boolean activarnombre_cuenta_contableBeneficiariosPagosCobros=true;

	public Border resaltarnumero_mayorBeneficiariosPagosCobros=null;
	public Boolean mostrarnumero_mayorBeneficiariosPagosCobros=true;
	public Boolean activarnumero_mayorBeneficiariosPagosCobros=true;

	public Border resaltarnumero_chequeBeneficiariosPagosCobros=null;
	public Boolean mostrarnumero_chequeBeneficiariosPagosCobros=true;
	public Boolean activarnumero_chequeBeneficiariosPagosCobros=true;

	public Border resaltarbeneficiarioBeneficiariosPagosCobros=null;
	public Boolean mostrarbeneficiarioBeneficiariosPagosCobros=true;
	public Boolean activarbeneficiarioBeneficiariosPagosCobros=true;

	public Border resaltardebito_localBeneficiariosPagosCobros=null;
	public Boolean mostrardebito_localBeneficiariosPagosCobros=true;
	public Boolean activardebito_localBeneficiariosPagosCobros=true;

	public Border resaltarcredito_localBeneficiariosPagosCobros=null;
	public Boolean mostrarcredito_localBeneficiariosPagosCobros=true;
	public Boolean activarcredito_localBeneficiariosPagosCobros=true;

	public Border resaltardetalleBeneficiariosPagosCobros=null;
	public Boolean mostrardetalleBeneficiariosPagosCobros=true;
	public Boolean activardetalleBeneficiariosPagosCobros=true;

	public Border resaltartipo_movimientoBeneficiariosPagosCobros=null;
	public Boolean mostrartipo_movimientoBeneficiariosPagosCobros=true;
	public Boolean activartipo_movimientoBeneficiariosPagosCobros=true;

	public Border resaltarvalorBeneficiariosPagosCobros=null;
	public Boolean mostrarvalorBeneficiariosPagosCobros=true;
	public Boolean activarvalorBeneficiariosPagosCobros=true;

	public Border resaltarcuentaBeneficiariosPagosCobros=null;
	public Boolean mostrarcuentaBeneficiariosPagosCobros=true;
	public Boolean activarcuentaBeneficiariosPagosCobros=true;

	public Border resaltarfechaBeneficiariosPagosCobros=null;
	public Boolean mostrarfechaBeneficiariosPagosCobros=true;
	public Boolean activarfechaBeneficiariosPagosCobros=true;

	public Border resaltarbeneficiario_asientoBeneficiariosPagosCobros=null;
	public Boolean mostrarbeneficiario_asientoBeneficiariosPagosCobros=true;
	public Boolean activarbeneficiario_asientoBeneficiariosPagosCobros=true;

	
	

	public Border setResaltaridBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltaridBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridBeneficiariosPagosCobros() {
		return this.resaltaridBeneficiariosPagosCobros;
	}

	public void setResaltaridBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltaridBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostraridBeneficiariosPagosCobros() {
		return this.mostraridBeneficiariosPagosCobros;
	}

	public void setMostraridBeneficiariosPagosCobros(Boolean mostraridBeneficiariosPagosCobros) {
		this.mostraridBeneficiariosPagosCobros= mostraridBeneficiariosPagosCobros;
	}

	public Boolean getActivaridBeneficiariosPagosCobros() {
		return this.activaridBeneficiariosPagosCobros;
	}

	public void setActivaridBeneficiariosPagosCobros(Boolean activaridBeneficiariosPagosCobros) {
		this.activaridBeneficiariosPagosCobros= activaridBeneficiariosPagosCobros;
	}

	public Border setResaltarid_empresaBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarid_empresaBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaBeneficiariosPagosCobros() {
		return this.resaltarid_empresaBeneficiariosPagosCobros;
	}

	public void setResaltarid_empresaBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarid_empresaBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarid_empresaBeneficiariosPagosCobros() {
		return this.mostrarid_empresaBeneficiariosPagosCobros;
	}

	public void setMostrarid_empresaBeneficiariosPagosCobros(Boolean mostrarid_empresaBeneficiariosPagosCobros) {
		this.mostrarid_empresaBeneficiariosPagosCobros= mostrarid_empresaBeneficiariosPagosCobros;
	}

	public Boolean getActivarid_empresaBeneficiariosPagosCobros() {
		return this.activarid_empresaBeneficiariosPagosCobros;
	}

	public void setActivarid_empresaBeneficiariosPagosCobros(Boolean activarid_empresaBeneficiariosPagosCobros) {
		this.activarid_empresaBeneficiariosPagosCobros= activarid_empresaBeneficiariosPagosCobros;
	}

	public Boolean getCargarid_empresaBeneficiariosPagosCobros() {
		return this.cargarid_empresaBeneficiariosPagosCobros;
	}

	public void setCargarid_empresaBeneficiariosPagosCobros(Boolean cargarid_empresaBeneficiariosPagosCobros) {
		this.cargarid_empresaBeneficiariosPagosCobros= cargarid_empresaBeneficiariosPagosCobros;
	}

	public Border setResaltarid_sucursalBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarid_sucursalBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalBeneficiariosPagosCobros() {
		return this.resaltarid_sucursalBeneficiariosPagosCobros;
	}

	public void setResaltarid_sucursalBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarid_sucursalBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarid_sucursalBeneficiariosPagosCobros() {
		return this.mostrarid_sucursalBeneficiariosPagosCobros;
	}

	public void setMostrarid_sucursalBeneficiariosPagosCobros(Boolean mostrarid_sucursalBeneficiariosPagosCobros) {
		this.mostrarid_sucursalBeneficiariosPagosCobros= mostrarid_sucursalBeneficiariosPagosCobros;
	}

	public Boolean getActivarid_sucursalBeneficiariosPagosCobros() {
		return this.activarid_sucursalBeneficiariosPagosCobros;
	}

	public void setActivarid_sucursalBeneficiariosPagosCobros(Boolean activarid_sucursalBeneficiariosPagosCobros) {
		this.activarid_sucursalBeneficiariosPagosCobros= activarid_sucursalBeneficiariosPagosCobros;
	}

	public Boolean getCargarid_sucursalBeneficiariosPagosCobros() {
		return this.cargarid_sucursalBeneficiariosPagosCobros;
	}

	public void setCargarid_sucursalBeneficiariosPagosCobros(Boolean cargarid_sucursalBeneficiariosPagosCobros) {
		this.cargarid_sucursalBeneficiariosPagosCobros= cargarid_sucursalBeneficiariosPagosCobros;
	}

	public Border setResaltarid_ejercicioBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioBeneficiariosPagosCobros() {
		return this.resaltarid_ejercicioBeneficiariosPagosCobros;
	}

	public void setResaltarid_ejercicioBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarid_ejercicioBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioBeneficiariosPagosCobros() {
		return this.mostrarid_ejercicioBeneficiariosPagosCobros;
	}

	public void setMostrarid_ejercicioBeneficiariosPagosCobros(Boolean mostrarid_ejercicioBeneficiariosPagosCobros) {
		this.mostrarid_ejercicioBeneficiariosPagosCobros= mostrarid_ejercicioBeneficiariosPagosCobros;
	}

	public Boolean getActivarid_ejercicioBeneficiariosPagosCobros() {
		return this.activarid_ejercicioBeneficiariosPagosCobros;
	}

	public void setActivarid_ejercicioBeneficiariosPagosCobros(Boolean activarid_ejercicioBeneficiariosPagosCobros) {
		this.activarid_ejercicioBeneficiariosPagosCobros= activarid_ejercicioBeneficiariosPagosCobros;
	}

	public Boolean getCargarid_ejercicioBeneficiariosPagosCobros() {
		return this.cargarid_ejercicioBeneficiariosPagosCobros;
	}

	public void setCargarid_ejercicioBeneficiariosPagosCobros(Boolean cargarid_ejercicioBeneficiariosPagosCobros) {
		this.cargarid_ejercicioBeneficiariosPagosCobros= cargarid_ejercicioBeneficiariosPagosCobros;
	}

	public Border setResaltarid_tipo_movimientoBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoBeneficiariosPagosCobros() {
		return this.resaltarid_tipo_movimientoBeneficiariosPagosCobros;
	}

	public void setResaltarid_tipo_movimientoBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarid_tipo_movimientoBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoBeneficiariosPagosCobros() {
		return this.mostrarid_tipo_movimientoBeneficiariosPagosCobros;
	}

	public void setMostrarid_tipo_movimientoBeneficiariosPagosCobros(Boolean mostrarid_tipo_movimientoBeneficiariosPagosCobros) {
		this.mostrarid_tipo_movimientoBeneficiariosPagosCobros= mostrarid_tipo_movimientoBeneficiariosPagosCobros;
	}

	public Boolean getActivarid_tipo_movimientoBeneficiariosPagosCobros() {
		return this.activarid_tipo_movimientoBeneficiariosPagosCobros;
	}

	public void setActivarid_tipo_movimientoBeneficiariosPagosCobros(Boolean activarid_tipo_movimientoBeneficiariosPagosCobros) {
		this.activarid_tipo_movimientoBeneficiariosPagosCobros= activarid_tipo_movimientoBeneficiariosPagosCobros;
	}

	public Boolean getCargarid_tipo_movimientoBeneficiariosPagosCobros() {
		return this.cargarid_tipo_movimientoBeneficiariosPagosCobros;
	}

	public void setCargarid_tipo_movimientoBeneficiariosPagosCobros(Boolean cargarid_tipo_movimientoBeneficiariosPagosCobros) {
		this.cargarid_tipo_movimientoBeneficiariosPagosCobros= cargarid_tipo_movimientoBeneficiariosPagosCobros;
	}

	public Border setResaltarfecha_desdeBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeBeneficiariosPagosCobros() {
		return this.resaltarfecha_desdeBeneficiariosPagosCobros;
	}

	public void setResaltarfecha_desdeBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarfecha_desdeBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeBeneficiariosPagosCobros() {
		return this.mostrarfecha_desdeBeneficiariosPagosCobros;
	}

	public void setMostrarfecha_desdeBeneficiariosPagosCobros(Boolean mostrarfecha_desdeBeneficiariosPagosCobros) {
		this.mostrarfecha_desdeBeneficiariosPagosCobros= mostrarfecha_desdeBeneficiariosPagosCobros;
	}

	public Boolean getActivarfecha_desdeBeneficiariosPagosCobros() {
		return this.activarfecha_desdeBeneficiariosPagosCobros;
	}

	public void setActivarfecha_desdeBeneficiariosPagosCobros(Boolean activarfecha_desdeBeneficiariosPagosCobros) {
		this.activarfecha_desdeBeneficiariosPagosCobros= activarfecha_desdeBeneficiariosPagosCobros;
	}

	public Border setResaltarfecha_hastaBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaBeneficiariosPagosCobros() {
		return this.resaltarfecha_hastaBeneficiariosPagosCobros;
	}

	public void setResaltarfecha_hastaBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarfecha_hastaBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaBeneficiariosPagosCobros() {
		return this.mostrarfecha_hastaBeneficiariosPagosCobros;
	}

	public void setMostrarfecha_hastaBeneficiariosPagosCobros(Boolean mostrarfecha_hastaBeneficiariosPagosCobros) {
		this.mostrarfecha_hastaBeneficiariosPagosCobros= mostrarfecha_hastaBeneficiariosPagosCobros;
	}

	public Boolean getActivarfecha_hastaBeneficiariosPagosCobros() {
		return this.activarfecha_hastaBeneficiariosPagosCobros;
	}

	public void setActivarfecha_hastaBeneficiariosPagosCobros(Boolean activarfecha_hastaBeneficiariosPagosCobros) {
		this.activarfecha_hastaBeneficiariosPagosCobros= activarfecha_hastaBeneficiariosPagosCobros;
	}

	public Border setResaltarcodigo_cuenta_contableBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_contableBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_contableBeneficiariosPagosCobros() {
		return this.resaltarcodigo_cuenta_contableBeneficiariosPagosCobros;
	}

	public void setResaltarcodigo_cuenta_contableBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarcodigo_cuenta_contableBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_contableBeneficiariosPagosCobros() {
		return this.mostrarcodigo_cuenta_contableBeneficiariosPagosCobros;
	}

	public void setMostrarcodigo_cuenta_contableBeneficiariosPagosCobros(Boolean mostrarcodigo_cuenta_contableBeneficiariosPagosCobros) {
		this.mostrarcodigo_cuenta_contableBeneficiariosPagosCobros= mostrarcodigo_cuenta_contableBeneficiariosPagosCobros;
	}

	public Boolean getActivarcodigo_cuenta_contableBeneficiariosPagosCobros() {
		return this.activarcodigo_cuenta_contableBeneficiariosPagosCobros;
	}

	public void setActivarcodigo_cuenta_contableBeneficiariosPagosCobros(Boolean activarcodigo_cuenta_contableBeneficiariosPagosCobros) {
		this.activarcodigo_cuenta_contableBeneficiariosPagosCobros= activarcodigo_cuenta_contableBeneficiariosPagosCobros;
	}

	public Border setResaltarnombre_cuenta_contableBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contableBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contableBeneficiariosPagosCobros() {
		return this.resaltarnombre_cuenta_contableBeneficiariosPagosCobros;
	}

	public void setResaltarnombre_cuenta_contableBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarnombre_cuenta_contableBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contableBeneficiariosPagosCobros() {
		return this.mostrarnombre_cuenta_contableBeneficiariosPagosCobros;
	}

	public void setMostrarnombre_cuenta_contableBeneficiariosPagosCobros(Boolean mostrarnombre_cuenta_contableBeneficiariosPagosCobros) {
		this.mostrarnombre_cuenta_contableBeneficiariosPagosCobros= mostrarnombre_cuenta_contableBeneficiariosPagosCobros;
	}

	public Boolean getActivarnombre_cuenta_contableBeneficiariosPagosCobros() {
		return this.activarnombre_cuenta_contableBeneficiariosPagosCobros;
	}

	public void setActivarnombre_cuenta_contableBeneficiariosPagosCobros(Boolean activarnombre_cuenta_contableBeneficiariosPagosCobros) {
		this.activarnombre_cuenta_contableBeneficiariosPagosCobros= activarnombre_cuenta_contableBeneficiariosPagosCobros;
	}

	public Border setResaltarnumero_mayorBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorBeneficiariosPagosCobros() {
		return this.resaltarnumero_mayorBeneficiariosPagosCobros;
	}

	public void setResaltarnumero_mayorBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarnumero_mayorBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorBeneficiariosPagosCobros() {
		return this.mostrarnumero_mayorBeneficiariosPagosCobros;
	}

	public void setMostrarnumero_mayorBeneficiariosPagosCobros(Boolean mostrarnumero_mayorBeneficiariosPagosCobros) {
		this.mostrarnumero_mayorBeneficiariosPagosCobros= mostrarnumero_mayorBeneficiariosPagosCobros;
	}

	public Boolean getActivarnumero_mayorBeneficiariosPagosCobros() {
		return this.activarnumero_mayorBeneficiariosPagosCobros;
	}

	public void setActivarnumero_mayorBeneficiariosPagosCobros(Boolean activarnumero_mayorBeneficiariosPagosCobros) {
		this.activarnumero_mayorBeneficiariosPagosCobros= activarnumero_mayorBeneficiariosPagosCobros;
	}

	public Border setResaltarnumero_chequeBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeBeneficiariosPagosCobros() {
		return this.resaltarnumero_chequeBeneficiariosPagosCobros;
	}

	public void setResaltarnumero_chequeBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarnumero_chequeBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeBeneficiariosPagosCobros() {
		return this.mostrarnumero_chequeBeneficiariosPagosCobros;
	}

	public void setMostrarnumero_chequeBeneficiariosPagosCobros(Boolean mostrarnumero_chequeBeneficiariosPagosCobros) {
		this.mostrarnumero_chequeBeneficiariosPagosCobros= mostrarnumero_chequeBeneficiariosPagosCobros;
	}

	public Boolean getActivarnumero_chequeBeneficiariosPagosCobros() {
		return this.activarnumero_chequeBeneficiariosPagosCobros;
	}

	public void setActivarnumero_chequeBeneficiariosPagosCobros(Boolean activarnumero_chequeBeneficiariosPagosCobros) {
		this.activarnumero_chequeBeneficiariosPagosCobros= activarnumero_chequeBeneficiariosPagosCobros;
	}

	public Border setResaltarbeneficiarioBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarbeneficiarioBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiarioBeneficiariosPagosCobros() {
		return this.resaltarbeneficiarioBeneficiariosPagosCobros;
	}

	public void setResaltarbeneficiarioBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarbeneficiarioBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarbeneficiarioBeneficiariosPagosCobros() {
		return this.mostrarbeneficiarioBeneficiariosPagosCobros;
	}

	public void setMostrarbeneficiarioBeneficiariosPagosCobros(Boolean mostrarbeneficiarioBeneficiariosPagosCobros) {
		this.mostrarbeneficiarioBeneficiariosPagosCobros= mostrarbeneficiarioBeneficiariosPagosCobros;
	}

	public Boolean getActivarbeneficiarioBeneficiariosPagosCobros() {
		return this.activarbeneficiarioBeneficiariosPagosCobros;
	}

	public void setActivarbeneficiarioBeneficiariosPagosCobros(Boolean activarbeneficiarioBeneficiariosPagosCobros) {
		this.activarbeneficiarioBeneficiariosPagosCobros= activarbeneficiarioBeneficiariosPagosCobros;
	}

	public Border setResaltardebito_localBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltardebito_localBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localBeneficiariosPagosCobros() {
		return this.resaltardebito_localBeneficiariosPagosCobros;
	}

	public void setResaltardebito_localBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltardebito_localBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrardebito_localBeneficiariosPagosCobros() {
		return this.mostrardebito_localBeneficiariosPagosCobros;
	}

	public void setMostrardebito_localBeneficiariosPagosCobros(Boolean mostrardebito_localBeneficiariosPagosCobros) {
		this.mostrardebito_localBeneficiariosPagosCobros= mostrardebito_localBeneficiariosPagosCobros;
	}

	public Boolean getActivardebito_localBeneficiariosPagosCobros() {
		return this.activardebito_localBeneficiariosPagosCobros;
	}

	public void setActivardebito_localBeneficiariosPagosCobros(Boolean activardebito_localBeneficiariosPagosCobros) {
		this.activardebito_localBeneficiariosPagosCobros= activardebito_localBeneficiariosPagosCobros;
	}

	public Border setResaltarcredito_localBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarcredito_localBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localBeneficiariosPagosCobros() {
		return this.resaltarcredito_localBeneficiariosPagosCobros;
	}

	public void setResaltarcredito_localBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarcredito_localBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarcredito_localBeneficiariosPagosCobros() {
		return this.mostrarcredito_localBeneficiariosPagosCobros;
	}

	public void setMostrarcredito_localBeneficiariosPagosCobros(Boolean mostrarcredito_localBeneficiariosPagosCobros) {
		this.mostrarcredito_localBeneficiariosPagosCobros= mostrarcredito_localBeneficiariosPagosCobros;
	}

	public Boolean getActivarcredito_localBeneficiariosPagosCobros() {
		return this.activarcredito_localBeneficiariosPagosCobros;
	}

	public void setActivarcredito_localBeneficiariosPagosCobros(Boolean activarcredito_localBeneficiariosPagosCobros) {
		this.activarcredito_localBeneficiariosPagosCobros= activarcredito_localBeneficiariosPagosCobros;
	}

	public Border setResaltardetalleBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltardetalleBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleBeneficiariosPagosCobros() {
		return this.resaltardetalleBeneficiariosPagosCobros;
	}

	public void setResaltardetalleBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltardetalleBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrardetalleBeneficiariosPagosCobros() {
		return this.mostrardetalleBeneficiariosPagosCobros;
	}

	public void setMostrardetalleBeneficiariosPagosCobros(Boolean mostrardetalleBeneficiariosPagosCobros) {
		this.mostrardetalleBeneficiariosPagosCobros= mostrardetalleBeneficiariosPagosCobros;
	}

	public Boolean getActivardetalleBeneficiariosPagosCobros() {
		return this.activardetalleBeneficiariosPagosCobros;
	}

	public void setActivardetalleBeneficiariosPagosCobros(Boolean activardetalleBeneficiariosPagosCobros) {
		this.activardetalleBeneficiariosPagosCobros= activardetalleBeneficiariosPagosCobros;
	}

	public Border setResaltartipo_movimientoBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltartipo_movimientoBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_movimientoBeneficiariosPagosCobros() {
		return this.resaltartipo_movimientoBeneficiariosPagosCobros;
	}

	public void setResaltartipo_movimientoBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltartipo_movimientoBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrartipo_movimientoBeneficiariosPagosCobros() {
		return this.mostrartipo_movimientoBeneficiariosPagosCobros;
	}

	public void setMostrartipo_movimientoBeneficiariosPagosCobros(Boolean mostrartipo_movimientoBeneficiariosPagosCobros) {
		this.mostrartipo_movimientoBeneficiariosPagosCobros= mostrartipo_movimientoBeneficiariosPagosCobros;
	}

	public Boolean getActivartipo_movimientoBeneficiariosPagosCobros() {
		return this.activartipo_movimientoBeneficiariosPagosCobros;
	}

	public void setActivartipo_movimientoBeneficiariosPagosCobros(Boolean activartipo_movimientoBeneficiariosPagosCobros) {
		this.activartipo_movimientoBeneficiariosPagosCobros= activartipo_movimientoBeneficiariosPagosCobros;
	}

	public Border setResaltarvalorBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarvalorBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorBeneficiariosPagosCobros() {
		return this.resaltarvalorBeneficiariosPagosCobros;
	}

	public void setResaltarvalorBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarvalorBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarvalorBeneficiariosPagosCobros() {
		return this.mostrarvalorBeneficiariosPagosCobros;
	}

	public void setMostrarvalorBeneficiariosPagosCobros(Boolean mostrarvalorBeneficiariosPagosCobros) {
		this.mostrarvalorBeneficiariosPagosCobros= mostrarvalorBeneficiariosPagosCobros;
	}

	public Boolean getActivarvalorBeneficiariosPagosCobros() {
		return this.activarvalorBeneficiariosPagosCobros;
	}

	public void setActivarvalorBeneficiariosPagosCobros(Boolean activarvalorBeneficiariosPagosCobros) {
		this.activarvalorBeneficiariosPagosCobros= activarvalorBeneficiariosPagosCobros;
	}

	public Border setResaltarcuentaBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarcuentaBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcuentaBeneficiariosPagosCobros() {
		return this.resaltarcuentaBeneficiariosPagosCobros;
	}

	public void setResaltarcuentaBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarcuentaBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarcuentaBeneficiariosPagosCobros() {
		return this.mostrarcuentaBeneficiariosPagosCobros;
	}

	public void setMostrarcuentaBeneficiariosPagosCobros(Boolean mostrarcuentaBeneficiariosPagosCobros) {
		this.mostrarcuentaBeneficiariosPagosCobros= mostrarcuentaBeneficiariosPagosCobros;
	}

	public Boolean getActivarcuentaBeneficiariosPagosCobros() {
		return this.activarcuentaBeneficiariosPagosCobros;
	}

	public void setActivarcuentaBeneficiariosPagosCobros(Boolean activarcuentaBeneficiariosPagosCobros) {
		this.activarcuentaBeneficiariosPagosCobros= activarcuentaBeneficiariosPagosCobros;
	}

	public Border setResaltarfechaBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarfechaBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaBeneficiariosPagosCobros() {
		return this.resaltarfechaBeneficiariosPagosCobros;
	}

	public void setResaltarfechaBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarfechaBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarfechaBeneficiariosPagosCobros() {
		return this.mostrarfechaBeneficiariosPagosCobros;
	}

	public void setMostrarfechaBeneficiariosPagosCobros(Boolean mostrarfechaBeneficiariosPagosCobros) {
		this.mostrarfechaBeneficiariosPagosCobros= mostrarfechaBeneficiariosPagosCobros;
	}

	public Boolean getActivarfechaBeneficiariosPagosCobros() {
		return this.activarfechaBeneficiariosPagosCobros;
	}

	public void setActivarfechaBeneficiariosPagosCobros(Boolean activarfechaBeneficiariosPagosCobros) {
		this.activarfechaBeneficiariosPagosCobros= activarfechaBeneficiariosPagosCobros;
	}

	public Border setResaltarbeneficiario_asientoBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//beneficiariospagoscobrosBeanSwingJInternalFrame.jTtoolBarBeneficiariosPagosCobros.setBorder(borderResaltar);
		
		this.resaltarbeneficiario_asientoBeneficiariosPagosCobros= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarbeneficiario_asientoBeneficiariosPagosCobros() {
		return this.resaltarbeneficiario_asientoBeneficiariosPagosCobros;
	}

	public void setResaltarbeneficiario_asientoBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarbeneficiario_asientoBeneficiariosPagosCobros= borderResaltar;
	}

	public Boolean getMostrarbeneficiario_asientoBeneficiariosPagosCobros() {
		return this.mostrarbeneficiario_asientoBeneficiariosPagosCobros;
	}

	public void setMostrarbeneficiario_asientoBeneficiariosPagosCobros(Boolean mostrarbeneficiario_asientoBeneficiariosPagosCobros) {
		this.mostrarbeneficiario_asientoBeneficiariosPagosCobros= mostrarbeneficiario_asientoBeneficiariosPagosCobros;
	}

	public Boolean getActivarbeneficiario_asientoBeneficiariosPagosCobros() {
		return this.activarbeneficiario_asientoBeneficiariosPagosCobros;
	}

	public void setActivarbeneficiario_asientoBeneficiariosPagosCobros(Boolean activarbeneficiario_asientoBeneficiariosPagosCobros) {
		this.activarbeneficiario_asientoBeneficiariosPagosCobros= activarbeneficiario_asientoBeneficiariosPagosCobros;
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
		
		
		this.setMostraridBeneficiariosPagosCobros(esInicial);
		this.setMostrarid_empresaBeneficiariosPagosCobros(esInicial);
		this.setMostrarid_sucursalBeneficiariosPagosCobros(esInicial);
		this.setMostrarid_ejercicioBeneficiariosPagosCobros(esInicial);
		this.setMostrarid_tipo_movimientoBeneficiariosPagosCobros(esInicial);
		this.setMostrarfecha_desdeBeneficiariosPagosCobros(esInicial);
		this.setMostrarfecha_hastaBeneficiariosPagosCobros(esInicial);
		this.setMostrarcodigo_cuenta_contableBeneficiariosPagosCobros(esInicial);
		this.setMostrarnombre_cuenta_contableBeneficiariosPagosCobros(esInicial);
		this.setMostrarnumero_mayorBeneficiariosPagosCobros(esInicial);
		this.setMostrarnumero_chequeBeneficiariosPagosCobros(esInicial);
		this.setMostrarbeneficiarioBeneficiariosPagosCobros(esInicial);
		this.setMostrardebito_localBeneficiariosPagosCobros(esInicial);
		this.setMostrarcredito_localBeneficiariosPagosCobros(esInicial);
		this.setMostrardetalleBeneficiariosPagosCobros(esInicial);
		this.setMostrartipo_movimientoBeneficiariosPagosCobros(esInicial);
		this.setMostrarvalorBeneficiariosPagosCobros(esInicial);
		this.setMostrarcuentaBeneficiariosPagosCobros(esInicial);
		this.setMostrarfechaBeneficiariosPagosCobros(esInicial);
		this.setMostrarbeneficiario_asientoBeneficiariosPagosCobros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.ID)) {
				this.setMostraridBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setMostrarcodigo_cuenta_contableBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setMostrarnombre_cuenta_contableBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO)) {
				this.setMostrarbeneficiarioBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.DETALLE)) {
				this.setMostrardetalleBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setMostrartipo_movimientoBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.VALOR)) {
				this.setMostrarvalorBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CUENTA)) {
				this.setMostrarcuentaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHA)) {
				this.setMostrarfechaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO)) {
				this.setMostrarbeneficiario_asientoBeneficiariosPagosCobros(esAsigna);
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
		
		
		this.setActivaridBeneficiariosPagosCobros(esInicial);
		this.setActivarid_empresaBeneficiariosPagosCobros(esInicial);
		this.setActivarid_sucursalBeneficiariosPagosCobros(esInicial);
		this.setActivarid_ejercicioBeneficiariosPagosCobros(esInicial);
		this.setActivarid_tipo_movimientoBeneficiariosPagosCobros(esInicial);
		this.setActivarfecha_desdeBeneficiariosPagosCobros(esInicial);
		this.setActivarfecha_hastaBeneficiariosPagosCobros(esInicial);
		this.setActivarcodigo_cuenta_contableBeneficiariosPagosCobros(esInicial);
		this.setActivarnombre_cuenta_contableBeneficiariosPagosCobros(esInicial);
		this.setActivarnumero_mayorBeneficiariosPagosCobros(esInicial);
		this.setActivarnumero_chequeBeneficiariosPagosCobros(esInicial);
		this.setActivarbeneficiarioBeneficiariosPagosCobros(esInicial);
		this.setActivardebito_localBeneficiariosPagosCobros(esInicial);
		this.setActivarcredito_localBeneficiariosPagosCobros(esInicial);
		this.setActivardetalleBeneficiariosPagosCobros(esInicial);
		this.setActivartipo_movimientoBeneficiariosPagosCobros(esInicial);
		this.setActivarvalorBeneficiariosPagosCobros(esInicial);
		this.setActivarcuentaBeneficiariosPagosCobros(esInicial);
		this.setActivarfechaBeneficiariosPagosCobros(esInicial);
		this.setActivarbeneficiario_asientoBeneficiariosPagosCobros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.ID)) {
				this.setActivaridBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setActivarcodigo_cuenta_contableBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setActivarnombre_cuenta_contableBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO)) {
				this.setActivarbeneficiarioBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.DETALLE)) {
				this.setActivardetalleBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setActivartipo_movimientoBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.VALOR)) {
				this.setActivarvalorBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CUENTA)) {
				this.setActivarcuentaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHA)) {
				this.setActivarfechaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO)) {
				this.setActivarbeneficiario_asientoBeneficiariosPagosCobros(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridBeneficiariosPagosCobros(esInicial);
		this.setResaltarid_empresaBeneficiariosPagosCobros(esInicial);
		this.setResaltarid_sucursalBeneficiariosPagosCobros(esInicial);
		this.setResaltarid_ejercicioBeneficiariosPagosCobros(esInicial);
		this.setResaltarid_tipo_movimientoBeneficiariosPagosCobros(esInicial);
		this.setResaltarfecha_desdeBeneficiariosPagosCobros(esInicial);
		this.setResaltarfecha_hastaBeneficiariosPagosCobros(esInicial);
		this.setResaltarcodigo_cuenta_contableBeneficiariosPagosCobros(esInicial);
		this.setResaltarnombre_cuenta_contableBeneficiariosPagosCobros(esInicial);
		this.setResaltarnumero_mayorBeneficiariosPagosCobros(esInicial);
		this.setResaltarnumero_chequeBeneficiariosPagosCobros(esInicial);
		this.setResaltarbeneficiarioBeneficiariosPagosCobros(esInicial);
		this.setResaltardebito_localBeneficiariosPagosCobros(esInicial);
		this.setResaltarcredito_localBeneficiariosPagosCobros(esInicial);
		this.setResaltardetalleBeneficiariosPagosCobros(esInicial);
		this.setResaltartipo_movimientoBeneficiariosPagosCobros(esInicial);
		this.setResaltarvalorBeneficiariosPagosCobros(esInicial);
		this.setResaltarcuentaBeneficiariosPagosCobros(esInicial);
		this.setResaltarfechaBeneficiariosPagosCobros(esInicial);
		this.setResaltarbeneficiario_asientoBeneficiariosPagosCobros(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.ID)) {
				this.setResaltaridBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setResaltarcodigo_cuenta_contableBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setResaltarnombre_cuenta_contableBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIO)) {
				this.setResaltarbeneficiarioBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.DETALLE)) {
				this.setResaltardetalleBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.TIPOMOVIMIENTO)) {
				this.setResaltartipo_movimientoBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.VALOR)) {
				this.setResaltarvalorBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.CUENTA)) {
				this.setResaltarcuentaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.FECHA)) {
				this.setResaltarfechaBeneficiariosPagosCobros(esAsigna);
				continue;
			}

			if(campo.clase.equals(BeneficiariosPagosCobrosConstantesFunciones.BENEFICIARIOASIENTO)) {
				this.setResaltarbeneficiario_asientoBeneficiariosPagosCobros(esAsigna);
				continue;
			}
		}
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


		for(Classe clase:clases) {
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


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros=true;

	public Boolean getMostrarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros() {
		return this.mostrarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros;
	}

	public void setMostrarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros(Boolean visibilidadResaltar) {
		this.mostrarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros=true;

	public Boolean getActivarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros() {
		return this.activarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros;
	}

	public void setActivarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros(Boolean habilitarResaltar) {
		this.activarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros=null;

	public Border getResaltarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros() {
		return this.resaltarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros;
	}

	public void setResaltarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros(Border borderResaltar) {
		this.resaltarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros= borderResaltar;
	}

	public void setResaltarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros(ParametroGeneralUsuario parametroGeneralUsuario/*BeneficiariosPagosCobrosBeanSwingJInternalFrame beneficiariospagoscobrosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaBeneficiariosPagosCobrosBeneficiariosPagosCobros= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}