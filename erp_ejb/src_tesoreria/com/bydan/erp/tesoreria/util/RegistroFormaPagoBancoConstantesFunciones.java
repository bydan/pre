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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.RegistroFormaPagoBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.RegistroFormaPagoBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.RegistroFormaPagoBancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class RegistroFormaPagoBancoConstantesFunciones extends RegistroFormaPagoBancoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="RegistroFormaPagoBanco";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="RegistroFormaPagoBanco"+RegistroFormaPagoBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="RegistroFormaPagoBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="RegistroFormaPagoBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"_"+RegistroFormaPagoBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/RegistroFormaPagoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"_"+RegistroFormaPagoBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"_"+RegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/RegistroFormaPagoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"_"+RegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RegistroFormaPagoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/RegistroFormaPagoBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+RegistroFormaPagoBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=RegistroFormaPagoBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+RegistroFormaPagoBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=RegistroFormaPagoBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+RegistroFormaPagoBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Registro Forma Pago Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Registro Forma Pago Banco";
	public static final String SCLASSWEBTITULO_LOWER="Registro Forma Pago Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="RegistroFormaPagoBanco";
	public static final String OBJECTNAME="registroformapagobanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="registro_forma_pago_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select registroformapagobanco from "+RegistroFormaPagoBancoConstantesFunciones.SPERSISTENCENAME+" registroformapagobanco";
	public static String QUERYSELECTNATIVE="select "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".version_row,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_empresa,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_sucursal,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_ejercicio,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_periodo,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_asiento_contable,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_tipo_forma_pago,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_estado_registro_forma_pago_banco,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_cliente,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".nombre_banco,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".nombre_girador,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".fecha_vencimiento,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".numero_cuenta,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".numero_cheque,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".valor_monto,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".fecha,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".fecha_vencimiento_original,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".numero_cambio,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_anio,"+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME+".id_mes from "+RegistroFormaPagoBancoConstantesFunciones.SCHEMA+"."+RegistroFormaPagoBancoConstantesFunciones.TABLENAME;//+" as "+RegistroFormaPagoBancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected RegistroFormaPagoBancoConstantesFuncionesAdditional registroformapagobancoConstantesFuncionesAdditional=null;
	
	public RegistroFormaPagoBancoConstantesFuncionesAdditional getRegistroFormaPagoBancoConstantesFuncionesAdditional() {
		return this.registroformapagobancoConstantesFuncionesAdditional;
	}
	
	public void setRegistroFormaPagoBancoConstantesFuncionesAdditional(RegistroFormaPagoBancoConstantesFuncionesAdditional registroformapagobancoConstantesFuncionesAdditional) {
		try {
			this.registroformapagobancoConstantesFuncionesAdditional=registroformapagobancoConstantesFuncionesAdditional;
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
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDTIPOFORMAPAGO= "id_tipo_forma_pago";
    public static final String IDESTADOREGISTROFORMAPAGOBANCO= "id_estado_registro_forma_pago_banco";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NOMBREBANCO= "nombre_banco";
    public static final String NOMBREGIRADOR= "nombre_girador";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String VALORMONTO= "valor_monto";
    public static final String FECHA= "fecha";
    public static final String FECHAVENCIMIENTOORIGINAL= "fecha_vencimiento_original";
    public static final String NUMEROCAMBIO= "numero_cambio";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
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
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDTIPOFORMAPAGO= "Tipo Forma Pago";
		public static final String LABEL_IDTIPOFORMAPAGO_LOWER= "Tipo Forma Pago";
    	public static final String LABEL_IDESTADOREGISTROFORMAPAGOBANCO= "Estado Registro Forma Pago Banco";
		public static final String LABEL_IDESTADOREGISTROFORMAPAGOBANCO_LOWER= "Estado Registro Forma Pago Banco";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NOMBREBANCO= "Nombre Banco";
		public static final String LABEL_NOMBREBANCO_LOWER= "Nombre Banco";
    	public static final String LABEL_NOMBREGIRADOR= "Nombre Girador";
		public static final String LABEL_NOMBREGIRADOR_LOWER= "Nombre Girador";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_NUMEROCHEQUE= "Numero Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_VALORMONTO= "Valor Monto";
		public static final String LABEL_VALORMONTO_LOWER= "Valor Monto";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_FECHAVENCIMIENTOORIGINAL= "Fecha Vencimiento Original";
		public static final String LABEL_FECHAVENCIMIENTOORIGINAL_LOWER= "Fecha Vencimiento Original";
    	public static final String LABEL_NUMEROCAMBIO= "Numero Cambio";
		public static final String LABEL_NUMEROCAMBIO_LOWER= "Numero Cambio";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_BANCO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BANCO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GIRADOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GIRADOR=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	
	public static String getRegistroFormaPagoBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDPERIODO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDTIPOFORMAPAGO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDESTADOREGISTROFORMAPAGOBANCO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREBANCO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREGIRADOR;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.VALORMONTO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_VALORMONTO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.FECHA)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCAMBIO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDANIO)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(RegistroFormaPagoBancoConstantesFunciones.IDMES)) {sLabelColumna=RegistroFormaPagoBancoConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getRegistroFormaPagoBancoDescripcion(RegistroFormaPagoBanco registroformapagobanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(registroformapagobanco !=null/* && registroformapagobanco.getId()!=0*/) {
			if(registroformapagobanco.getId()!=null) {
				sDescripcion=registroformapagobanco.getId().toString();
			}//registroformapagobancoregistroformapagobanco.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getRegistroFormaPagoBancoDescripcionDetallado(RegistroFormaPagoBanco registroformapagobanco) {
		String sDescripcion="";
			
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.ID+"=";
		sDescripcion+=registroformapagobanco.getId().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=registroformapagobanco.getVersionRow().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=registroformapagobanco.getid_empresa().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=registroformapagobanco.getid_sucursal().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=registroformapagobanco.getid_ejercicio().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=registroformapagobanco.getid_periodo().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=registroformapagobanco.getid_asiento_contable().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO+"=";
		sDescripcion+=registroformapagobanco.getid_tipo_forma_pago().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO+"=";
		sDescripcion+=registroformapagobanco.getid_estado_registro_forma_pago_banco().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=registroformapagobanco.getid_cliente().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO+"=";
		sDescripcion+=registroformapagobanco.getnombre_banco()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR+"=";
		sDescripcion+=registroformapagobanco.getnombre_girador()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=registroformapagobanco.getfecha_vencimiento().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=registroformapagobanco.getnumero_cuenta()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=registroformapagobanco.getnumero_cheque()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.VALORMONTO+"=";
		sDescripcion+=registroformapagobanco.getvalor_monto().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.FECHA+"=";
		sDescripcion+=registroformapagobanco.getfecha().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL+"=";
		sDescripcion+=registroformapagobanco.getfecha_vencimiento_original().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO+"=";
		sDescripcion+=registroformapagobanco.getnumero_cambio().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDANIO+"=";
		sDescripcion+=registroformapagobanco.getid_anio().toString()+",";
		sDescripcion+=RegistroFormaPagoBancoConstantesFunciones.IDMES+"=";
		sDescripcion+=registroformapagobanco.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setRegistroFormaPagoBancoDescripcion(RegistroFormaPagoBanco registroformapagobanco,String sValor) throws Exception {			
		if(registroformapagobanco !=null) {
			//registroformapagobancoregistroformapagobanco.getId().toString();
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
		}

		return sDescripcion;
	}

	public static String getTipoFormaPagoDescripcion(TipoFormaPago tipoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoformapago!=null/*&&tipoformapago.getId()>0*/) {
			sDescripcion=TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(tipoformapago);
		}

		return sDescripcion;
	}

	public static String getEstadoRegistroFormaPagoBancoDescripcion(EstadoRegistroFormaPagoBanco estadoregistroformapagobanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoregistroformapagobanco!=null/*&&estadoregistroformapagobanco.getId()>0*/) {
			sDescripcion=EstadoRegistroFormaPagoBancoConstantesFunciones.getEstadoRegistroFormaPagoBancoDescripcion(estadoregistroformapagobanco);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoRegistroFormaPagoBanco")) {
			sNombreIndice="Tipo=  Por Estado Registro Forma Pago Banco";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Forma Pago";
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

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

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

	public static String getDetalleIndiceFK_IdEstadoRegistroFormaPagoBanco(Long id_estado_registro_forma_pago_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_registro_forma_pago_banco!=null) {sDetalleIndice+=" Codigo Unico De Estado Registro Forma Pago Banco="+id_estado_registro_forma_pago_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

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

	public static String getDetalleIndiceFK_IdTipoFormaPago(Long id_tipo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Forma Pago="+id_tipo_forma_pago.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		registroformapagobanco.setnombre_banco(registroformapagobanco.getnombre_banco().trim());
		registroformapagobanco.setnombre_girador(registroformapagobanco.getnombre_girador().trim());
		registroformapagobanco.setnumero_cuenta(registroformapagobanco.getnumero_cuenta().trim());
		registroformapagobanco.setnumero_cheque(registroformapagobanco.getnumero_cheque().trim());
	}
	
	public static void quitarEspaciosRegistroFormaPagoBancos(List<RegistroFormaPagoBanco> registroformapagobancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(RegistroFormaPagoBanco registroformapagobanco: registroformapagobancos) {
			registroformapagobanco.setnombre_banco(registroformapagobanco.getnombre_banco().trim());
			registroformapagobanco.setnombre_girador(registroformapagobanco.getnombre_girador().trim());
			registroformapagobanco.setnumero_cuenta(registroformapagobanco.getnumero_cuenta().trim());
			registroformapagobanco.setnumero_cheque(registroformapagobanco.getnumero_cheque().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && registroformapagobanco.getConCambioAuxiliar()) {
			registroformapagobanco.setIsDeleted(registroformapagobanco.getIsDeletedAuxiliar());	
			registroformapagobanco.setIsNew(registroformapagobanco.getIsNewAuxiliar());	
			registroformapagobanco.setIsChanged(registroformapagobanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			registroformapagobanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			registroformapagobanco.setIsDeletedAuxiliar(false);	
			registroformapagobanco.setIsNewAuxiliar(false);	
			registroformapagobanco.setIsChangedAuxiliar(false);
			
			registroformapagobanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresRegistroFormaPagoBancos(List<RegistroFormaPagoBanco> registroformapagobancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(RegistroFormaPagoBanco registroformapagobanco : registroformapagobancos) {
			if(conAsignarBase && registroformapagobanco.getConCambioAuxiliar()) {
				registroformapagobanco.setIsDeleted(registroformapagobanco.getIsDeletedAuxiliar());	
				registroformapagobanco.setIsNew(registroformapagobanco.getIsNewAuxiliar());	
				registroformapagobanco.setIsChanged(registroformapagobanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				registroformapagobanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				registroformapagobanco.setIsDeletedAuxiliar(false);	
				registroformapagobanco.setIsNewAuxiliar(false);	
				registroformapagobanco.setIsChangedAuxiliar(false);
				
				registroformapagobanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobanco,Boolean conEnteros) throws Exception  {
		registroformapagobanco.setvalor_monto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			registroformapagobanco.setnumero_cambio(0);
		}
	}		
	
	public static void InicializarValoresRegistroFormaPagoBancos(List<RegistroFormaPagoBanco> registroformapagobancos,Boolean conEnteros) throws Exception  {
		
		for(RegistroFormaPagoBanco registroformapagobanco: registroformapagobancos) {
			registroformapagobanco.setvalor_monto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				registroformapagobanco.setnumero_cambio(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaRegistroFormaPagoBanco(List<RegistroFormaPagoBanco> registroformapagobancos,RegistroFormaPagoBanco registroformapagobancoAux) throws Exception  {
		RegistroFormaPagoBancoConstantesFunciones.InicializarValoresRegistroFormaPagoBanco(registroformapagobancoAux,true);
		
		for(RegistroFormaPagoBanco registroformapagobanco: registroformapagobancos) {
			if(registroformapagobanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			registroformapagobancoAux.setvalor_monto(registroformapagobancoAux.getvalor_monto()+registroformapagobanco.getvalor_monto());			
			registroformapagobancoAux.setnumero_cambio(registroformapagobancoAux.getnumero_cambio()+registroformapagobanco.getnumero_cambio());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesRegistroFormaPagoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=RegistroFormaPagoBancoConstantesFunciones.getArrayColumnasGlobalesRegistroFormaPagoBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesRegistroFormaPagoBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(RegistroFormaPagoBancoConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(RegistroFormaPagoBancoConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoRegistroFormaPagoBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<RegistroFormaPagoBanco> registroformapagobancos,RegistroFormaPagoBanco registroformapagobanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(RegistroFormaPagoBanco registroformapagobancoAux: registroformapagobancos) {
			if(registroformapagobancoAux!=null && registroformapagobanco!=null) {
				if((registroformapagobancoAux.getId()==null && registroformapagobanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(registroformapagobancoAux.getId()!=null && registroformapagobanco.getId()!=null){
					if(registroformapagobancoAux.getId().equals(registroformapagobanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaRegistroFormaPagoBanco(List<RegistroFormaPagoBanco> registroformapagobancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_montoTotal=0.0;
	
		for(RegistroFormaPagoBanco registroformapagobanco: registroformapagobancos) {			
			if(registroformapagobanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_montoTotal+=registroformapagobanco.getvalor_monto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.VALORMONTO);
		datoGeneral.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_VALORMONTO);
		datoGeneral.setdValorDouble(valor_montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaRegistroFormaPagoBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_ID, RegistroFormaPagoBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_VERSIONROW, RegistroFormaPagoBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEMPRESA, RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDSUCURSAL, RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEJERCICIO, RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDPERIODO, RegistroFormaPagoBancoConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE, RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDTIPOFORMAPAGO, RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDESTADOREGISTROFORMAPAGOBANCO, RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDCLIENTE, RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREBANCO, RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREGIRADOR, RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTO, RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCUENTA, RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCHEQUE, RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_VALORMONTO, RegistroFormaPagoBancoConstantesFunciones.VALORMONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHA, RegistroFormaPagoBancoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL, RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCAMBIO, RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDANIO, RegistroFormaPagoBancoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,RegistroFormaPagoBancoConstantesFunciones.LABEL_IDMES, RegistroFormaPagoBancoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasRegistroFormaPagoBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.VALORMONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=RegistroFormaPagoBancoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRegistroFormaPagoBanco() throws Exception  {
		return RegistroFormaPagoBancoConstantesFunciones.getTiposSeleccionarRegistroFormaPagoBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRegistroFormaPagoBanco(Boolean conFk) throws Exception  {
		return RegistroFormaPagoBancoConstantesFunciones.getTiposSeleccionarRegistroFormaPagoBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarRegistroFormaPagoBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDESTADOREGISTROFORMAPAGOBANCO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDESTADOREGISTROFORMAPAGOBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREBANCO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREGIRADOR);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREGIRADOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_VALORMONTO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_VALORMONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCAMBIO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesRegistroFormaPagoBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobancoAux) throws Exception {
		
			registroformapagobancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(registroformapagobancoAux.getEmpresa()));
			registroformapagobancoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(registroformapagobancoAux.getSucursal()));
			registroformapagobancoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(registroformapagobancoAux.getEjercicio()));
			registroformapagobancoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(registroformapagobancoAux.getPeriodo()));
			registroformapagobancoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(registroformapagobancoAux.getAsientoContable()));
			registroformapagobancoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(registroformapagobancoAux.getTipoFormaPago()));
			registroformapagobancoAux.setestadoregistroformapagobanco_descripcion(EstadoRegistroFormaPagoBancoConstantesFunciones.getEstadoRegistroFormaPagoBancoDescripcion(registroformapagobancoAux.getEstadoRegistroFormaPagoBanco()));
			registroformapagobancoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(registroformapagobancoAux.getCliente()));
			registroformapagobancoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(registroformapagobancoAux.getAnio()));
			registroformapagobancoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(registroformapagobancoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(List<RegistroFormaPagoBanco> registroformapagobancosTemp) throws Exception {
		for(RegistroFormaPagoBanco registroformapagobancoAux:registroformapagobancosTemp) {
			
			registroformapagobancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(registroformapagobancoAux.getEmpresa()));
			registroformapagobancoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(registroformapagobancoAux.getSucursal()));
			registroformapagobancoAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(registroformapagobancoAux.getEjercicio()));
			registroformapagobancoAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(registroformapagobancoAux.getPeriodo()));
			registroformapagobancoAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(registroformapagobancoAux.getAsientoContable()));
			registroformapagobancoAux.settipoformapago_descripcion(TipoFormaPagoConstantesFunciones.getTipoFormaPagoDescripcion(registroformapagobancoAux.getTipoFormaPago()));
			registroformapagobancoAux.setestadoregistroformapagobanco_descripcion(EstadoRegistroFormaPagoBancoConstantesFunciones.getEstadoRegistroFormaPagoBancoDescripcion(registroformapagobancoAux.getEstadoRegistroFormaPagoBanco()));
			registroformapagobancoAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(registroformapagobancoAux.getCliente()));
			registroformapagobancoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(registroformapagobancoAux.getAnio()));
			registroformapagobancoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(registroformapagobancoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(TipoFormaPago.class));
				classes.add(new Classe(EstadoRegistroFormaPagoBanco.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFormaPago.class)) {
						classes.add(new Classe(TipoFormaPago.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoRegistroFormaPagoBanco.class)) {
						classes.add(new Classe(EstadoRegistroFormaPagoBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfRegistroFormaPagoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(EstadoRegistroFormaPagoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRegistroFormaPagoBanco.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(TipoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFormaPago.class)); continue;
					}

					if(EstadoRegistroFormaPagoBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoRegistroFormaPagoBanco.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return RegistroFormaPagoBancoConstantesFunciones.getClassesRelationshipsOfRegistroFormaPagoBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRegistroFormaPagoBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRegistroFormaPagoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return RegistroFormaPagoBancoConstantesFunciones.getClassesRelationshipsFromStringsOfRegistroFormaPagoBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfRegistroFormaPagoBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(RegistroFormaPagoBanco registroformapagobanco,List<RegistroFormaPagoBanco> registroformapagobancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			RegistroFormaPagoBanco registroformapagobancoEncontrado=null;
			
			for(RegistroFormaPagoBanco registroformapagobancoLocal:registroformapagobancos) {
				if(registroformapagobancoLocal.getId().equals(registroformapagobanco.getId())) {
					registroformapagobancoEncontrado=registroformapagobancoLocal;
					
					registroformapagobancoLocal.setIsChanged(registroformapagobanco.getIsChanged());
					registroformapagobancoLocal.setIsNew(registroformapagobanco.getIsNew());
					registroformapagobancoLocal.setIsDeleted(registroformapagobanco.getIsDeleted());
					
					registroformapagobancoLocal.setGeneralEntityOriginal(registroformapagobanco.getGeneralEntityOriginal());
					
					registroformapagobancoLocal.setId(registroformapagobanco.getId());	
					registroformapagobancoLocal.setVersionRow(registroformapagobanco.getVersionRow());	
					registroformapagobancoLocal.setid_empresa(registroformapagobanco.getid_empresa());	
					registroformapagobancoLocal.setid_sucursal(registroformapagobanco.getid_sucursal());	
					registroformapagobancoLocal.setid_ejercicio(registroformapagobanco.getid_ejercicio());	
					registroformapagobancoLocal.setid_periodo(registroformapagobanco.getid_periodo());	
					registroformapagobancoLocal.setid_asiento_contable(registroformapagobanco.getid_asiento_contable());	
					registroformapagobancoLocal.setid_tipo_forma_pago(registroformapagobanco.getid_tipo_forma_pago());	
					registroformapagobancoLocal.setid_estado_registro_forma_pago_banco(registroformapagobanco.getid_estado_registro_forma_pago_banco());	
					registroformapagobancoLocal.setid_cliente(registroformapagobanco.getid_cliente());	
					registroformapagobancoLocal.setnombre_banco(registroformapagobanco.getnombre_banco());	
					registroformapagobancoLocal.setnombre_girador(registroformapagobanco.getnombre_girador());	
					registroformapagobancoLocal.setfecha_vencimiento(registroformapagobanco.getfecha_vencimiento());	
					registroformapagobancoLocal.setnumero_cuenta(registroformapagobanco.getnumero_cuenta());	
					registroformapagobancoLocal.setnumero_cheque(registroformapagobanco.getnumero_cheque());	
					registroformapagobancoLocal.setvalor_monto(registroformapagobanco.getvalor_monto());	
					registroformapagobancoLocal.setfecha(registroformapagobanco.getfecha());	
					registroformapagobancoLocal.setfecha_vencimiento_original(registroformapagobanco.getfecha_vencimiento_original());	
					registroformapagobancoLocal.setnumero_cambio(registroformapagobanco.getnumero_cambio());	
					registroformapagobancoLocal.setid_anio(registroformapagobanco.getid_anio());	
					registroformapagobancoLocal.setid_mes(registroformapagobanco.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!registroformapagobanco.getIsDeleted()) {
				if(!existe) {
					registroformapagobancos.add(registroformapagobanco);
				}
			} else {
				if(registroformapagobancoEncontrado!=null && permiteQuitar)  {
					registroformapagobancos.remove(registroformapagobancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(RegistroFormaPagoBanco registroformapagobanco,List<RegistroFormaPagoBanco> registroformapagobancos) throws Exception {
		try	{			
			for(RegistroFormaPagoBanco registroformapagobancoLocal:registroformapagobancos) {
				if(registroformapagobancoLocal.getId().equals(registroformapagobanco.getId())) {
					registroformapagobancoLocal.setIsSelected(registroformapagobanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesRegistroFormaPagoBanco(List<RegistroFormaPagoBanco> registroformapagobancosAux) throws Exception {
		//this.registroformapagobancosAux=registroformapagobancosAux;
		
		for(RegistroFormaPagoBanco registroformapagobancoAux:registroformapagobancosAux) {
			if(registroformapagobancoAux.getIsChanged()) {
				registroformapagobancoAux.setIsChanged(false);
			}		
			
			if(registroformapagobancoAux.getIsNew()) {
				registroformapagobancoAux.setIsNew(false);
			}	
			
			if(registroformapagobancoAux.getIsDeleted()) {
				registroformapagobancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobancoAux) throws Exception {
		//this.registroformapagobancoAux=registroformapagobancoAux;
		
			if(registroformapagobancoAux.getIsChanged()) {
				registroformapagobancoAux.setIsChanged(false);
			}		
			
			if(registroformapagobancoAux.getIsNew()) {
				registroformapagobancoAux.setIsNew(false);
			}	
			
			if(registroformapagobancoAux.getIsDeleted()) {
				registroformapagobancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(RegistroFormaPagoBanco registroformapagobancoAsignar,RegistroFormaPagoBanco registroformapagobanco) throws Exception {
		registroformapagobancoAsignar.setId(registroformapagobanco.getId());	
		registroformapagobancoAsignar.setVersionRow(registroformapagobanco.getVersionRow());	
		registroformapagobancoAsignar.setid_empresa(registroformapagobanco.getid_empresa());
		registroformapagobancoAsignar.setempresa_descripcion(registroformapagobanco.getempresa_descripcion());	
		registroformapagobancoAsignar.setid_sucursal(registroformapagobanco.getid_sucursal());
		registroformapagobancoAsignar.setsucursal_descripcion(registroformapagobanco.getsucursal_descripcion());	
		registroformapagobancoAsignar.setid_ejercicio(registroformapagobanco.getid_ejercicio());
		registroformapagobancoAsignar.setejercicio_descripcion(registroformapagobanco.getejercicio_descripcion());	
		registroformapagobancoAsignar.setid_periodo(registroformapagobanco.getid_periodo());
		registroformapagobancoAsignar.setperiodo_descripcion(registroformapagobanco.getperiodo_descripcion());	
		registroformapagobancoAsignar.setid_asiento_contable(registroformapagobanco.getid_asiento_contable());
		registroformapagobancoAsignar.setasientocontable_descripcion(registroformapagobanco.getasientocontable_descripcion());	
		registroformapagobancoAsignar.setid_tipo_forma_pago(registroformapagobanco.getid_tipo_forma_pago());
		registroformapagobancoAsignar.settipoformapago_descripcion(registroformapagobanco.gettipoformapago_descripcion());	
		registroformapagobancoAsignar.setid_estado_registro_forma_pago_banco(registroformapagobanco.getid_estado_registro_forma_pago_banco());
		registroformapagobancoAsignar.setestadoregistroformapagobanco_descripcion(registroformapagobanco.getestadoregistroformapagobanco_descripcion());	
		registroformapagobancoAsignar.setid_cliente(registroformapagobanco.getid_cliente());
		registroformapagobancoAsignar.setcliente_descripcion(registroformapagobanco.getcliente_descripcion());	
		registroformapagobancoAsignar.setnombre_banco(registroformapagobanco.getnombre_banco());	
		registroformapagobancoAsignar.setnombre_girador(registroformapagobanco.getnombre_girador());	
		registroformapagobancoAsignar.setfecha_vencimiento(registroformapagobanco.getfecha_vencimiento());	
		registroformapagobancoAsignar.setnumero_cuenta(registroformapagobanco.getnumero_cuenta());	
		registroformapagobancoAsignar.setnumero_cheque(registroformapagobanco.getnumero_cheque());	
		registroformapagobancoAsignar.setvalor_monto(registroformapagobanco.getvalor_monto());	
		registroformapagobancoAsignar.setfecha(registroformapagobanco.getfecha());	
		registroformapagobancoAsignar.setfecha_vencimiento_original(registroformapagobanco.getfecha_vencimiento_original());	
		registroformapagobancoAsignar.setnumero_cambio(registroformapagobanco.getnumero_cambio());	
		registroformapagobancoAsignar.setid_anio(registroformapagobanco.getid_anio());
		registroformapagobancoAsignar.setanio_descripcion(registroformapagobanco.getanio_descripcion());	
		registroformapagobancoAsignar.setid_mes(registroformapagobanco.getid_mes());
		registroformapagobancoAsignar.setmes_descripcion(registroformapagobanco.getmes_descripcion());	
	}
	
	public static void inicializarRegistroFormaPagoBanco(RegistroFormaPagoBanco registroformapagobanco) throws Exception {
		try {
				registroformapagobanco.setId(0L);	
					
				registroformapagobanco.setid_empresa(-1L);	
				registroformapagobanco.setid_sucursal(-1L);	
				registroformapagobanco.setid_ejercicio(-1L);	
				registroformapagobanco.setid_periodo(-1L);	
				registroformapagobanco.setid_asiento_contable(-1L);	
				registroformapagobanco.setid_tipo_forma_pago(-1L);	
				registroformapagobanco.setid_estado_registro_forma_pago_banco(-1L);	
				registroformapagobanco.setid_cliente(-1L);	
				registroformapagobanco.setnombre_banco("");	
				registroformapagobanco.setnombre_girador("");	
				registroformapagobanco.setfecha_vencimiento(new Date());	
				registroformapagobanco.setnumero_cuenta("");	
				registroformapagobanco.setnumero_cheque("");	
				registroformapagobanco.setvalor_monto(0.0);	
				registroformapagobanco.setfecha(new Date());	
				registroformapagobanco.setfecha_vencimiento_original(new Date());	
				registroformapagobanco.setnumero_cambio(0);	
				registroformapagobanco.setid_anio(null);	
				registroformapagobanco.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderRegistroFormaPagoBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDTIPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDESTADOREGISTROFORMAPAGOBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_NOMBREGIRADOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_VALORMONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_FECHAVENCIMIENTOORIGINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_NUMEROCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(RegistroFormaPagoBancoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataRegistroFormaPagoBanco(String sTipo,Row row,Workbook workbook,RegistroFormaPagoBanco registroformapagobanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.gettipoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getestadoregistroformapagobanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getnombre_banco());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getnombre_girador());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getvalor_monto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getfecha_vencimiento_original());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getnumero_cambio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(registroformapagobanco.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryRegistroFormaPagoBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryRegistroFormaPagoBanco() {
		return this.sFinalQueryRegistroFormaPagoBanco;
	}
	
	public void setsFinalQueryRegistroFormaPagoBanco(String sFinalQueryRegistroFormaPagoBanco) {
		this.sFinalQueryRegistroFormaPagoBanco= sFinalQueryRegistroFormaPagoBanco;
	}
	
	public Border resaltarSeleccionarRegistroFormaPagoBanco=null;
	
	public Border setResaltarSeleccionarRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarRegistroFormaPagoBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarRegistroFormaPagoBanco() {
		return this.resaltarSeleccionarRegistroFormaPagoBanco;
	}
	
	public void setResaltarSeleccionarRegistroFormaPagoBanco(Border borderResaltarSeleccionarRegistroFormaPagoBanco) {
		this.resaltarSeleccionarRegistroFormaPagoBanco= borderResaltarSeleccionarRegistroFormaPagoBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridRegistroFormaPagoBanco=null;
	public Boolean mostraridRegistroFormaPagoBanco=true;
	public Boolean activaridRegistroFormaPagoBanco=true;

	public Border resaltarid_empresaRegistroFormaPagoBanco=null;
	public Boolean mostrarid_empresaRegistroFormaPagoBanco=true;
	public Boolean activarid_empresaRegistroFormaPagoBanco=true;
	public Boolean cargarid_empresaRegistroFormaPagoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarid_sucursalRegistroFormaPagoBanco=null;
	public Boolean mostrarid_sucursalRegistroFormaPagoBanco=true;
	public Boolean activarid_sucursalRegistroFormaPagoBanco=true;
	public Boolean cargarid_sucursalRegistroFormaPagoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarid_ejercicioRegistroFormaPagoBanco=null;
	public Boolean mostrarid_ejercicioRegistroFormaPagoBanco=true;
	public Boolean activarid_ejercicioRegistroFormaPagoBanco=true;
	public Boolean cargarid_ejercicioRegistroFormaPagoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarid_periodoRegistroFormaPagoBanco=null;
	public Boolean mostrarid_periodoRegistroFormaPagoBanco=true;
	public Boolean activarid_periodoRegistroFormaPagoBanco=true;
	public Boolean cargarid_periodoRegistroFormaPagoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableRegistroFormaPagoBanco=null;
	public Boolean mostrarid_asiento_contableRegistroFormaPagoBanco=true;
	public Boolean activarid_asiento_contableRegistroFormaPagoBanco=true;
	public Boolean cargarid_asiento_contableRegistroFormaPagoBanco=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarid_tipo_forma_pagoRegistroFormaPagoBanco=null;
	public Boolean mostrarid_tipo_forma_pagoRegistroFormaPagoBanco=true;
	public Boolean activarid_tipo_forma_pagoRegistroFormaPagoBanco=true;
	public Boolean cargarid_tipo_forma_pagoRegistroFormaPagoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_forma_pagoRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco=null;
	public Boolean mostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco=true;
	public Boolean activarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco=true;
	public Boolean cargarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarid_clienteRegistroFormaPagoBanco=null;
	public Boolean mostrarid_clienteRegistroFormaPagoBanco=true;
	public Boolean activarid_clienteRegistroFormaPagoBanco=true;
	public Boolean cargarid_clienteRegistroFormaPagoBanco=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarnombre_bancoRegistroFormaPagoBanco=null;
	public Boolean mostrarnombre_bancoRegistroFormaPagoBanco=true;
	public Boolean activarnombre_bancoRegistroFormaPagoBanco=true;

	public Border resaltarnombre_giradorRegistroFormaPagoBanco=null;
	public Boolean mostrarnombre_giradorRegistroFormaPagoBanco=true;
	public Boolean activarnombre_giradorRegistroFormaPagoBanco=true;

	public Border resaltarfecha_vencimientoRegistroFormaPagoBanco=null;
	public Boolean mostrarfecha_vencimientoRegistroFormaPagoBanco=true;
	public Boolean activarfecha_vencimientoRegistroFormaPagoBanco=false;

	public Border resaltarnumero_cuentaRegistroFormaPagoBanco=null;
	public Boolean mostrarnumero_cuentaRegistroFormaPagoBanco=true;
	public Boolean activarnumero_cuentaRegistroFormaPagoBanco=true;

	public Border resaltarnumero_chequeRegistroFormaPagoBanco=null;
	public Boolean mostrarnumero_chequeRegistroFormaPagoBanco=true;
	public Boolean activarnumero_chequeRegistroFormaPagoBanco=true;

	public Border resaltarvalor_montoRegistroFormaPagoBanco=null;
	public Boolean mostrarvalor_montoRegistroFormaPagoBanco=true;
	public Boolean activarvalor_montoRegistroFormaPagoBanco=true;

	public Border resaltarfechaRegistroFormaPagoBanco=null;
	public Boolean mostrarfechaRegistroFormaPagoBanco=true;
	public Boolean activarfechaRegistroFormaPagoBanco=false;

	public Border resaltarfecha_vencimiento_originalRegistroFormaPagoBanco=null;
	public Boolean mostrarfecha_vencimiento_originalRegistroFormaPagoBanco=true;
	public Boolean activarfecha_vencimiento_originalRegistroFormaPagoBanco=false;

	public Border resaltarnumero_cambioRegistroFormaPagoBanco=null;
	public Boolean mostrarnumero_cambioRegistroFormaPagoBanco=true;
	public Boolean activarnumero_cambioRegistroFormaPagoBanco=true;

	public Border resaltarid_anioRegistroFormaPagoBanco=null;
	public Boolean mostrarid_anioRegistroFormaPagoBanco=true;
	public Boolean activarid_anioRegistroFormaPagoBanco=false;
	public Boolean cargarid_anioRegistroFormaPagoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioRegistroFormaPagoBanco=false;//ConEventDepend=true

	public Border resaltarid_mesRegistroFormaPagoBanco=null;
	public Boolean mostrarid_mesRegistroFormaPagoBanco=true;
	public Boolean activarid_mesRegistroFormaPagoBanco=false;
	public Boolean cargarid_mesRegistroFormaPagoBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesRegistroFormaPagoBanco=false;//ConEventDepend=true

	
	

	public Border setResaltaridRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltaridRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridRegistroFormaPagoBanco() {
		return this.resaltaridRegistroFormaPagoBanco;
	}

	public void setResaltaridRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltaridRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostraridRegistroFormaPagoBanco() {
		return this.mostraridRegistroFormaPagoBanco;
	}

	public void setMostraridRegistroFormaPagoBanco(Boolean mostraridRegistroFormaPagoBanco) {
		this.mostraridRegistroFormaPagoBanco= mostraridRegistroFormaPagoBanco;
	}

	public Boolean getActivaridRegistroFormaPagoBanco() {
		return this.activaridRegistroFormaPagoBanco;
	}

	public void setActivaridRegistroFormaPagoBanco(Boolean activaridRegistroFormaPagoBanco) {
		this.activaridRegistroFormaPagoBanco= activaridRegistroFormaPagoBanco;
	}

	public Border setResaltarid_empresaRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_empresaRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaRegistroFormaPagoBanco() {
		return this.resaltarid_empresaRegistroFormaPagoBanco;
	}

	public void setResaltarid_empresaRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_empresaRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_empresaRegistroFormaPagoBanco() {
		return this.mostrarid_empresaRegistroFormaPagoBanco;
	}

	public void setMostrarid_empresaRegistroFormaPagoBanco(Boolean mostrarid_empresaRegistroFormaPagoBanco) {
		this.mostrarid_empresaRegistroFormaPagoBanco= mostrarid_empresaRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_empresaRegistroFormaPagoBanco() {
		return this.activarid_empresaRegistroFormaPagoBanco;
	}

	public void setActivarid_empresaRegistroFormaPagoBanco(Boolean activarid_empresaRegistroFormaPagoBanco) {
		this.activarid_empresaRegistroFormaPagoBanco= activarid_empresaRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_empresaRegistroFormaPagoBanco() {
		return this.cargarid_empresaRegistroFormaPagoBanco;
	}

	public void setCargarid_empresaRegistroFormaPagoBanco(Boolean cargarid_empresaRegistroFormaPagoBanco) {
		this.cargarid_empresaRegistroFormaPagoBanco= cargarid_empresaRegistroFormaPagoBanco;
	}

	public Border setResaltarid_sucursalRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_sucursalRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalRegistroFormaPagoBanco() {
		return this.resaltarid_sucursalRegistroFormaPagoBanco;
	}

	public void setResaltarid_sucursalRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_sucursalRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_sucursalRegistroFormaPagoBanco() {
		return this.mostrarid_sucursalRegistroFormaPagoBanco;
	}

	public void setMostrarid_sucursalRegistroFormaPagoBanco(Boolean mostrarid_sucursalRegistroFormaPagoBanco) {
		this.mostrarid_sucursalRegistroFormaPagoBanco= mostrarid_sucursalRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_sucursalRegistroFormaPagoBanco() {
		return this.activarid_sucursalRegistroFormaPagoBanco;
	}

	public void setActivarid_sucursalRegistroFormaPagoBanco(Boolean activarid_sucursalRegistroFormaPagoBanco) {
		this.activarid_sucursalRegistroFormaPagoBanco= activarid_sucursalRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_sucursalRegistroFormaPagoBanco() {
		return this.cargarid_sucursalRegistroFormaPagoBanco;
	}

	public void setCargarid_sucursalRegistroFormaPagoBanco(Boolean cargarid_sucursalRegistroFormaPagoBanco) {
		this.cargarid_sucursalRegistroFormaPagoBanco= cargarid_sucursalRegistroFormaPagoBanco;
	}

	public Border setResaltarid_ejercicioRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioRegistroFormaPagoBanco() {
		return this.resaltarid_ejercicioRegistroFormaPagoBanco;
	}

	public void setResaltarid_ejercicioRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_ejercicioRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioRegistroFormaPagoBanco() {
		return this.mostrarid_ejercicioRegistroFormaPagoBanco;
	}

	public void setMostrarid_ejercicioRegistroFormaPagoBanco(Boolean mostrarid_ejercicioRegistroFormaPagoBanco) {
		this.mostrarid_ejercicioRegistroFormaPagoBanco= mostrarid_ejercicioRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_ejercicioRegistroFormaPagoBanco() {
		return this.activarid_ejercicioRegistroFormaPagoBanco;
	}

	public void setActivarid_ejercicioRegistroFormaPagoBanco(Boolean activarid_ejercicioRegistroFormaPagoBanco) {
		this.activarid_ejercicioRegistroFormaPagoBanco= activarid_ejercicioRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_ejercicioRegistroFormaPagoBanco() {
		return this.cargarid_ejercicioRegistroFormaPagoBanco;
	}

	public void setCargarid_ejercicioRegistroFormaPagoBanco(Boolean cargarid_ejercicioRegistroFormaPagoBanco) {
		this.cargarid_ejercicioRegistroFormaPagoBanco= cargarid_ejercicioRegistroFormaPagoBanco;
	}

	public Border setResaltarid_periodoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_periodoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoRegistroFormaPagoBanco() {
		return this.resaltarid_periodoRegistroFormaPagoBanco;
	}

	public void setResaltarid_periodoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_periodoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_periodoRegistroFormaPagoBanco() {
		return this.mostrarid_periodoRegistroFormaPagoBanco;
	}

	public void setMostrarid_periodoRegistroFormaPagoBanco(Boolean mostrarid_periodoRegistroFormaPagoBanco) {
		this.mostrarid_periodoRegistroFormaPagoBanco= mostrarid_periodoRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_periodoRegistroFormaPagoBanco() {
		return this.activarid_periodoRegistroFormaPagoBanco;
	}

	public void setActivarid_periodoRegistroFormaPagoBanco(Boolean activarid_periodoRegistroFormaPagoBanco) {
		this.activarid_periodoRegistroFormaPagoBanco= activarid_periodoRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_periodoRegistroFormaPagoBanco() {
		return this.cargarid_periodoRegistroFormaPagoBanco;
	}

	public void setCargarid_periodoRegistroFormaPagoBanco(Boolean cargarid_periodoRegistroFormaPagoBanco) {
		this.cargarid_periodoRegistroFormaPagoBanco= cargarid_periodoRegistroFormaPagoBanco;
	}

	public Border setResaltarid_asiento_contableRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableRegistroFormaPagoBanco() {
		return this.resaltarid_asiento_contableRegistroFormaPagoBanco;
	}

	public void setResaltarid_asiento_contableRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_asiento_contableRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableRegistroFormaPagoBanco() {
		return this.mostrarid_asiento_contableRegistroFormaPagoBanco;
	}

	public void setMostrarid_asiento_contableRegistroFormaPagoBanco(Boolean mostrarid_asiento_contableRegistroFormaPagoBanco) {
		this.mostrarid_asiento_contableRegistroFormaPagoBanco= mostrarid_asiento_contableRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_asiento_contableRegistroFormaPagoBanco() {
		return this.activarid_asiento_contableRegistroFormaPagoBanco;
	}

	public void setActivarid_asiento_contableRegistroFormaPagoBanco(Boolean activarid_asiento_contableRegistroFormaPagoBanco) {
		this.activarid_asiento_contableRegistroFormaPagoBanco= activarid_asiento_contableRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_asiento_contableRegistroFormaPagoBanco() {
		return this.cargarid_asiento_contableRegistroFormaPagoBanco;
	}

	public void setCargarid_asiento_contableRegistroFormaPagoBanco(Boolean cargarid_asiento_contableRegistroFormaPagoBanco) {
		this.cargarid_asiento_contableRegistroFormaPagoBanco= cargarid_asiento_contableRegistroFormaPagoBanco;
	}

	public Border setResaltarid_tipo_forma_pagoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_tipo_forma_pagoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_forma_pagoRegistroFormaPagoBanco() {
		return this.resaltarid_tipo_forma_pagoRegistroFormaPagoBanco;
	}

	public void setResaltarid_tipo_forma_pagoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_tipo_forma_pagoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_tipo_forma_pagoRegistroFormaPagoBanco() {
		return this.mostrarid_tipo_forma_pagoRegistroFormaPagoBanco;
	}

	public void setMostrarid_tipo_forma_pagoRegistroFormaPagoBanco(Boolean mostrarid_tipo_forma_pagoRegistroFormaPagoBanco) {
		this.mostrarid_tipo_forma_pagoRegistroFormaPagoBanco= mostrarid_tipo_forma_pagoRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_tipo_forma_pagoRegistroFormaPagoBanco() {
		return this.activarid_tipo_forma_pagoRegistroFormaPagoBanco;
	}

	public void setActivarid_tipo_forma_pagoRegistroFormaPagoBanco(Boolean activarid_tipo_forma_pagoRegistroFormaPagoBanco) {
		this.activarid_tipo_forma_pagoRegistroFormaPagoBanco= activarid_tipo_forma_pagoRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_tipo_forma_pagoRegistroFormaPagoBanco() {
		return this.cargarid_tipo_forma_pagoRegistroFormaPagoBanco;
	}

	public void setCargarid_tipo_forma_pagoRegistroFormaPagoBanco(Boolean cargarid_tipo_forma_pagoRegistroFormaPagoBanco) {
		this.cargarid_tipo_forma_pagoRegistroFormaPagoBanco= cargarid_tipo_forma_pagoRegistroFormaPagoBanco;
	}

	public Border setResaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco() {
		return this.resaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco;
	}

	public void setResaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco() {
		return this.mostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco;
	}

	public void setMostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(Boolean mostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco) {
		this.mostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco= mostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco() {
		return this.activarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco;
	}

	public void setActivarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(Boolean activarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco) {
		this.activarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco= activarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco() {
		return this.cargarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco;
	}

	public void setCargarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(Boolean cargarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco) {
		this.cargarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco= cargarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco;
	}

	public Border setResaltarid_clienteRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_clienteRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteRegistroFormaPagoBanco() {
		return this.resaltarid_clienteRegistroFormaPagoBanco;
	}

	public void setResaltarid_clienteRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_clienteRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_clienteRegistroFormaPagoBanco() {
		return this.mostrarid_clienteRegistroFormaPagoBanco;
	}

	public void setMostrarid_clienteRegistroFormaPagoBanco(Boolean mostrarid_clienteRegistroFormaPagoBanco) {
		this.mostrarid_clienteRegistroFormaPagoBanco= mostrarid_clienteRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_clienteRegistroFormaPagoBanco() {
		return this.activarid_clienteRegistroFormaPagoBanco;
	}

	public void setActivarid_clienteRegistroFormaPagoBanco(Boolean activarid_clienteRegistroFormaPagoBanco) {
		this.activarid_clienteRegistroFormaPagoBanco= activarid_clienteRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_clienteRegistroFormaPagoBanco() {
		return this.cargarid_clienteRegistroFormaPagoBanco;
	}

	public void setCargarid_clienteRegistroFormaPagoBanco(Boolean cargarid_clienteRegistroFormaPagoBanco) {
		this.cargarid_clienteRegistroFormaPagoBanco= cargarid_clienteRegistroFormaPagoBanco;
	}

	public Border setResaltarnombre_bancoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarnombre_bancoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bancoRegistroFormaPagoBanco() {
		return this.resaltarnombre_bancoRegistroFormaPagoBanco;
	}

	public void setResaltarnombre_bancoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarnombre_bancoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarnombre_bancoRegistroFormaPagoBanco() {
		return this.mostrarnombre_bancoRegistroFormaPagoBanco;
	}

	public void setMostrarnombre_bancoRegistroFormaPagoBanco(Boolean mostrarnombre_bancoRegistroFormaPagoBanco) {
		this.mostrarnombre_bancoRegistroFormaPagoBanco= mostrarnombre_bancoRegistroFormaPagoBanco;
	}

	public Boolean getActivarnombre_bancoRegistroFormaPagoBanco() {
		return this.activarnombre_bancoRegistroFormaPagoBanco;
	}

	public void setActivarnombre_bancoRegistroFormaPagoBanco(Boolean activarnombre_bancoRegistroFormaPagoBanco) {
		this.activarnombre_bancoRegistroFormaPagoBanco= activarnombre_bancoRegistroFormaPagoBanco;
	}

	public Border setResaltarnombre_giradorRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarnombre_giradorRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_giradorRegistroFormaPagoBanco() {
		return this.resaltarnombre_giradorRegistroFormaPagoBanco;
	}

	public void setResaltarnombre_giradorRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarnombre_giradorRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarnombre_giradorRegistroFormaPagoBanco() {
		return this.mostrarnombre_giradorRegistroFormaPagoBanco;
	}

	public void setMostrarnombre_giradorRegistroFormaPagoBanco(Boolean mostrarnombre_giradorRegistroFormaPagoBanco) {
		this.mostrarnombre_giradorRegistroFormaPagoBanco= mostrarnombre_giradorRegistroFormaPagoBanco;
	}

	public Boolean getActivarnombre_giradorRegistroFormaPagoBanco() {
		return this.activarnombre_giradorRegistroFormaPagoBanco;
	}

	public void setActivarnombre_giradorRegistroFormaPagoBanco(Boolean activarnombre_giradorRegistroFormaPagoBanco) {
		this.activarnombre_giradorRegistroFormaPagoBanco= activarnombre_giradorRegistroFormaPagoBanco;
	}

	public Border setResaltarfecha_vencimientoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoRegistroFormaPagoBanco() {
		return this.resaltarfecha_vencimientoRegistroFormaPagoBanco;
	}

	public void setResaltarfecha_vencimientoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarfecha_vencimientoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoRegistroFormaPagoBanco() {
		return this.mostrarfecha_vencimientoRegistroFormaPagoBanco;
	}

	public void setMostrarfecha_vencimientoRegistroFormaPagoBanco(Boolean mostrarfecha_vencimientoRegistroFormaPagoBanco) {
		this.mostrarfecha_vencimientoRegistroFormaPagoBanco= mostrarfecha_vencimientoRegistroFormaPagoBanco;
	}

	public Boolean getActivarfecha_vencimientoRegistroFormaPagoBanco() {
		return this.activarfecha_vencimientoRegistroFormaPagoBanco;
	}

	public void setActivarfecha_vencimientoRegistroFormaPagoBanco(Boolean activarfecha_vencimientoRegistroFormaPagoBanco) {
		this.activarfecha_vencimientoRegistroFormaPagoBanco= activarfecha_vencimientoRegistroFormaPagoBanco;
	}

	public Border setResaltarnumero_cuentaRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaRegistroFormaPagoBanco() {
		return this.resaltarnumero_cuentaRegistroFormaPagoBanco;
	}

	public void setResaltarnumero_cuentaRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarnumero_cuentaRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaRegistroFormaPagoBanco() {
		return this.mostrarnumero_cuentaRegistroFormaPagoBanco;
	}

	public void setMostrarnumero_cuentaRegistroFormaPagoBanco(Boolean mostrarnumero_cuentaRegistroFormaPagoBanco) {
		this.mostrarnumero_cuentaRegistroFormaPagoBanco= mostrarnumero_cuentaRegistroFormaPagoBanco;
	}

	public Boolean getActivarnumero_cuentaRegistroFormaPagoBanco() {
		return this.activarnumero_cuentaRegistroFormaPagoBanco;
	}

	public void setActivarnumero_cuentaRegistroFormaPagoBanco(Boolean activarnumero_cuentaRegistroFormaPagoBanco) {
		this.activarnumero_cuentaRegistroFormaPagoBanco= activarnumero_cuentaRegistroFormaPagoBanco;
	}

	public Border setResaltarnumero_chequeRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeRegistroFormaPagoBanco() {
		return this.resaltarnumero_chequeRegistroFormaPagoBanco;
	}

	public void setResaltarnumero_chequeRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarnumero_chequeRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeRegistroFormaPagoBanco() {
		return this.mostrarnumero_chequeRegistroFormaPagoBanco;
	}

	public void setMostrarnumero_chequeRegistroFormaPagoBanco(Boolean mostrarnumero_chequeRegistroFormaPagoBanco) {
		this.mostrarnumero_chequeRegistroFormaPagoBanco= mostrarnumero_chequeRegistroFormaPagoBanco;
	}

	public Boolean getActivarnumero_chequeRegistroFormaPagoBanco() {
		return this.activarnumero_chequeRegistroFormaPagoBanco;
	}

	public void setActivarnumero_chequeRegistroFormaPagoBanco(Boolean activarnumero_chequeRegistroFormaPagoBanco) {
		this.activarnumero_chequeRegistroFormaPagoBanco= activarnumero_chequeRegistroFormaPagoBanco;
	}

	public Border setResaltarvalor_montoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarvalor_montoRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_montoRegistroFormaPagoBanco() {
		return this.resaltarvalor_montoRegistroFormaPagoBanco;
	}

	public void setResaltarvalor_montoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarvalor_montoRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarvalor_montoRegistroFormaPagoBanco() {
		return this.mostrarvalor_montoRegistroFormaPagoBanco;
	}

	public void setMostrarvalor_montoRegistroFormaPagoBanco(Boolean mostrarvalor_montoRegistroFormaPagoBanco) {
		this.mostrarvalor_montoRegistroFormaPagoBanco= mostrarvalor_montoRegistroFormaPagoBanco;
	}

	public Boolean getActivarvalor_montoRegistroFormaPagoBanco() {
		return this.activarvalor_montoRegistroFormaPagoBanco;
	}

	public void setActivarvalor_montoRegistroFormaPagoBanco(Boolean activarvalor_montoRegistroFormaPagoBanco) {
		this.activarvalor_montoRegistroFormaPagoBanco= activarvalor_montoRegistroFormaPagoBanco;
	}

	public Border setResaltarfechaRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarfechaRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaRegistroFormaPagoBanco() {
		return this.resaltarfechaRegistroFormaPagoBanco;
	}

	public void setResaltarfechaRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarfechaRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarfechaRegistroFormaPagoBanco() {
		return this.mostrarfechaRegistroFormaPagoBanco;
	}

	public void setMostrarfechaRegistroFormaPagoBanco(Boolean mostrarfechaRegistroFormaPagoBanco) {
		this.mostrarfechaRegistroFormaPagoBanco= mostrarfechaRegistroFormaPagoBanco;
	}

	public Boolean getActivarfechaRegistroFormaPagoBanco() {
		return this.activarfechaRegistroFormaPagoBanco;
	}

	public void setActivarfechaRegistroFormaPagoBanco(Boolean activarfechaRegistroFormaPagoBanco) {
		this.activarfechaRegistroFormaPagoBanco= activarfechaRegistroFormaPagoBanco;
	}

	public Border setResaltarfecha_vencimiento_originalRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimiento_originalRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimiento_originalRegistroFormaPagoBanco() {
		return this.resaltarfecha_vencimiento_originalRegistroFormaPagoBanco;
	}

	public void setResaltarfecha_vencimiento_originalRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarfecha_vencimiento_originalRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimiento_originalRegistroFormaPagoBanco() {
		return this.mostrarfecha_vencimiento_originalRegistroFormaPagoBanco;
	}

	public void setMostrarfecha_vencimiento_originalRegistroFormaPagoBanco(Boolean mostrarfecha_vencimiento_originalRegistroFormaPagoBanco) {
		this.mostrarfecha_vencimiento_originalRegistroFormaPagoBanco= mostrarfecha_vencimiento_originalRegistroFormaPagoBanco;
	}

	public Boolean getActivarfecha_vencimiento_originalRegistroFormaPagoBanco() {
		return this.activarfecha_vencimiento_originalRegistroFormaPagoBanco;
	}

	public void setActivarfecha_vencimiento_originalRegistroFormaPagoBanco(Boolean activarfecha_vencimiento_originalRegistroFormaPagoBanco) {
		this.activarfecha_vencimiento_originalRegistroFormaPagoBanco= activarfecha_vencimiento_originalRegistroFormaPagoBanco;
	}

	public Border setResaltarnumero_cambioRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarnumero_cambioRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cambioRegistroFormaPagoBanco() {
		return this.resaltarnumero_cambioRegistroFormaPagoBanco;
	}

	public void setResaltarnumero_cambioRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarnumero_cambioRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarnumero_cambioRegistroFormaPagoBanco() {
		return this.mostrarnumero_cambioRegistroFormaPagoBanco;
	}

	public void setMostrarnumero_cambioRegistroFormaPagoBanco(Boolean mostrarnumero_cambioRegistroFormaPagoBanco) {
		this.mostrarnumero_cambioRegistroFormaPagoBanco= mostrarnumero_cambioRegistroFormaPagoBanco;
	}

	public Boolean getActivarnumero_cambioRegistroFormaPagoBanco() {
		return this.activarnumero_cambioRegistroFormaPagoBanco;
	}

	public void setActivarnumero_cambioRegistroFormaPagoBanco(Boolean activarnumero_cambioRegistroFormaPagoBanco) {
		this.activarnumero_cambioRegistroFormaPagoBanco= activarnumero_cambioRegistroFormaPagoBanco;
	}

	public Border setResaltarid_anioRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_anioRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioRegistroFormaPagoBanco() {
		return this.resaltarid_anioRegistroFormaPagoBanco;
	}

	public void setResaltarid_anioRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_anioRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_anioRegistroFormaPagoBanco() {
		return this.mostrarid_anioRegistroFormaPagoBanco;
	}

	public void setMostrarid_anioRegistroFormaPagoBanco(Boolean mostrarid_anioRegistroFormaPagoBanco) {
		this.mostrarid_anioRegistroFormaPagoBanco= mostrarid_anioRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_anioRegistroFormaPagoBanco() {
		return this.activarid_anioRegistroFormaPagoBanco;
	}

	public void setActivarid_anioRegistroFormaPagoBanco(Boolean activarid_anioRegistroFormaPagoBanco) {
		this.activarid_anioRegistroFormaPagoBanco= activarid_anioRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_anioRegistroFormaPagoBanco() {
		return this.cargarid_anioRegistroFormaPagoBanco;
	}

	public void setCargarid_anioRegistroFormaPagoBanco(Boolean cargarid_anioRegistroFormaPagoBanco) {
		this.cargarid_anioRegistroFormaPagoBanco= cargarid_anioRegistroFormaPagoBanco;
	}

	public Border setResaltarid_mesRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//registroformapagobancoBeanSwingJInternalFrame.jTtoolBarRegistroFormaPagoBanco.setBorder(borderResaltar);
		
		this.resaltarid_mesRegistroFormaPagoBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesRegistroFormaPagoBanco() {
		return this.resaltarid_mesRegistroFormaPagoBanco;
	}

	public void setResaltarid_mesRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarid_mesRegistroFormaPagoBanco= borderResaltar;
	}

	public Boolean getMostrarid_mesRegistroFormaPagoBanco() {
		return this.mostrarid_mesRegistroFormaPagoBanco;
	}

	public void setMostrarid_mesRegistroFormaPagoBanco(Boolean mostrarid_mesRegistroFormaPagoBanco) {
		this.mostrarid_mesRegistroFormaPagoBanco= mostrarid_mesRegistroFormaPagoBanco;
	}

	public Boolean getActivarid_mesRegistroFormaPagoBanco() {
		return this.activarid_mesRegistroFormaPagoBanco;
	}

	public void setActivarid_mesRegistroFormaPagoBanco(Boolean activarid_mesRegistroFormaPagoBanco) {
		this.activarid_mesRegistroFormaPagoBanco= activarid_mesRegistroFormaPagoBanco;
	}

	public Boolean getCargarid_mesRegistroFormaPagoBanco() {
		return this.cargarid_mesRegistroFormaPagoBanco;
	}

	public void setCargarid_mesRegistroFormaPagoBanco(Boolean cargarid_mesRegistroFormaPagoBanco) {
		this.cargarid_mesRegistroFormaPagoBanco= cargarid_mesRegistroFormaPagoBanco;
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
		
		
		this.setMostraridRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_empresaRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_sucursalRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_ejercicioRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_periodoRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_asiento_contableRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_tipo_forma_pagoRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_clienteRegistroFormaPagoBanco(esInicial);
		this.setMostrarnombre_bancoRegistroFormaPagoBanco(esInicial);
		this.setMostrarnombre_giradorRegistroFormaPagoBanco(esInicial);
		this.setMostrarfecha_vencimientoRegistroFormaPagoBanco(esInicial);
		this.setMostrarnumero_cuentaRegistroFormaPagoBanco(esInicial);
		this.setMostrarnumero_chequeRegistroFormaPagoBanco(esInicial);
		this.setMostrarvalor_montoRegistroFormaPagoBanco(esInicial);
		this.setMostrarfechaRegistroFormaPagoBanco(esInicial);
		this.setMostrarfecha_vencimiento_originalRegistroFormaPagoBanco(esInicial);
		this.setMostrarnumero_cambioRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_anioRegistroFormaPagoBanco(esInicial);
		this.setMostrarid_mesRegistroFormaPagoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.ID)) {
				this.setMostraridRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setMostrarid_tipo_forma_pagoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO)) {
				this.setMostrarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO)) {
				this.setMostrarnombre_bancoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR)) {
				this.setMostrarnombre_giradorRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.VALORMONTO)) {
				this.setMostrarvalor_montoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHA)) {
				this.setMostrarfechaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setMostrarfecha_vencimiento_originalRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO)) {
				this.setMostrarnumero_cambioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesRegistroFormaPagoBanco(esAsigna);
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
		
		
		this.setActivaridRegistroFormaPagoBanco(esInicial);
		this.setActivarid_empresaRegistroFormaPagoBanco(esInicial);
		this.setActivarid_sucursalRegistroFormaPagoBanco(esInicial);
		this.setActivarid_ejercicioRegistroFormaPagoBanco(esInicial);
		this.setActivarid_periodoRegistroFormaPagoBanco(esInicial);
		this.setActivarid_asiento_contableRegistroFormaPagoBanco(esInicial);
		this.setActivarid_tipo_forma_pagoRegistroFormaPagoBanco(esInicial);
		this.setActivarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(esInicial);
		this.setActivarid_clienteRegistroFormaPagoBanco(esInicial);
		this.setActivarnombre_bancoRegistroFormaPagoBanco(esInicial);
		this.setActivarnombre_giradorRegistroFormaPagoBanco(esInicial);
		this.setActivarfecha_vencimientoRegistroFormaPagoBanco(esInicial);
		this.setActivarnumero_cuentaRegistroFormaPagoBanco(esInicial);
		this.setActivarnumero_chequeRegistroFormaPagoBanco(esInicial);
		this.setActivarvalor_montoRegistroFormaPagoBanco(esInicial);
		this.setActivarfechaRegistroFormaPagoBanco(esInicial);
		this.setActivarfecha_vencimiento_originalRegistroFormaPagoBanco(esInicial);
		this.setActivarnumero_cambioRegistroFormaPagoBanco(esInicial);
		this.setActivarid_anioRegistroFormaPagoBanco(esInicial);
		this.setActivarid_mesRegistroFormaPagoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.ID)) {
				this.setActivaridRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setActivarid_tipo_forma_pagoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO)) {
				this.setActivarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO)) {
				this.setActivarnombre_bancoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR)) {
				this.setActivarnombre_giradorRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.VALORMONTO)) {
				this.setActivarvalor_montoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHA)) {
				this.setActivarfechaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setActivarfecha_vencimiento_originalRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO)) {
				this.setActivarnumero_cambioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDMES)) {
				this.setActivarid_mesRegistroFormaPagoBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_empresaRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_sucursalRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_ejercicioRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_periodoRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_asiento_contableRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_tipo_forma_pagoRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_clienteRegistroFormaPagoBanco(esInicial);
		this.setResaltarnombre_bancoRegistroFormaPagoBanco(esInicial);
		this.setResaltarnombre_giradorRegistroFormaPagoBanco(esInicial);
		this.setResaltarfecha_vencimientoRegistroFormaPagoBanco(esInicial);
		this.setResaltarnumero_cuentaRegistroFormaPagoBanco(esInicial);
		this.setResaltarnumero_chequeRegistroFormaPagoBanco(esInicial);
		this.setResaltarvalor_montoRegistroFormaPagoBanco(esInicial);
		this.setResaltarfechaRegistroFormaPagoBanco(esInicial);
		this.setResaltarfecha_vencimiento_originalRegistroFormaPagoBanco(esInicial);
		this.setResaltarnumero_cambioRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_anioRegistroFormaPagoBanco(esInicial);
		this.setResaltarid_mesRegistroFormaPagoBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.ID)) {
				this.setResaltaridRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDTIPOFORMAPAGO)) {
				this.setResaltarid_tipo_forma_pagoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDESTADOREGISTROFORMAPAGOBANCO)) {
				this.setResaltarid_estado_registro_forma_pago_bancoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NOMBREBANCO)) {
				this.setResaltarnombre_bancoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NOMBREGIRADOR)) {
				this.setResaltarnombre_giradorRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.VALORMONTO)) {
				this.setResaltarvalor_montoRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHA)) {
				this.setResaltarfechaRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.FECHAVENCIMIENTOORIGINAL)) {
				this.setResaltarfecha_vencimiento_originalRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.NUMEROCAMBIO)) {
				this.setResaltarnumero_cambioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioRegistroFormaPagoBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(RegistroFormaPagoBancoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesRegistroFormaPagoBanco(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableRegistroFormaPagoBanco=true;

	public Boolean getMostrarFK_IdAsientoContableRegistroFormaPagoBanco() {
		return this.mostrarFK_IdAsientoContableRegistroFormaPagoBanco;
	}

	public void setMostrarFK_IdAsientoContableRegistroFormaPagoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableRegistroFormaPagoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteRegistroFormaPagoBanco=true;

	public Boolean getMostrarFK_IdClienteRegistroFormaPagoBanco() {
		return this.mostrarFK_IdClienteRegistroFormaPagoBanco;
	}

	public void setMostrarFK_IdClienteRegistroFormaPagoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteRegistroFormaPagoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioRegistroFormaPagoBanco=true;

	public Boolean getMostrarFK_IdEjercicioRegistroFormaPagoBanco() {
		return this.mostrarFK_IdEjercicioRegistroFormaPagoBanco;
	}

	public void setMostrarFK_IdEjercicioRegistroFormaPagoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioRegistroFormaPagoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaRegistroFormaPagoBanco=true;

	public Boolean getMostrarFK_IdEmpresaRegistroFormaPagoBanco() {
		return this.mostrarFK_IdEmpresaRegistroFormaPagoBanco;
	}

	public void setMostrarFK_IdEmpresaRegistroFormaPagoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaRegistroFormaPagoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco=true;

	public Boolean getMostrarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco() {
		return this.mostrarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco;
	}

	public void setMostrarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoRegistroFormaPagoBanco=true;

	public Boolean getMostrarFK_IdPeriodoRegistroFormaPagoBanco() {
		return this.mostrarFK_IdPeriodoRegistroFormaPagoBanco;
	}

	public void setMostrarFK_IdPeriodoRegistroFormaPagoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoRegistroFormaPagoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalRegistroFormaPagoBanco=true;

	public Boolean getMostrarFK_IdSucursalRegistroFormaPagoBanco() {
		return this.mostrarFK_IdSucursalRegistroFormaPagoBanco;
	}

	public void setMostrarFK_IdSucursalRegistroFormaPagoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalRegistroFormaPagoBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoFormaPagoRegistroFormaPagoBanco=true;

	public Boolean getMostrarFK_IdTipoFormaPagoRegistroFormaPagoBanco() {
		return this.mostrarFK_IdTipoFormaPagoRegistroFormaPagoBanco;
	}

	public void setMostrarFK_IdTipoFormaPagoRegistroFormaPagoBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoFormaPagoRegistroFormaPagoBanco= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableRegistroFormaPagoBanco=true;

	public Boolean getActivarFK_IdAsientoContableRegistroFormaPagoBanco() {
		return this.activarFK_IdAsientoContableRegistroFormaPagoBanco;
	}

	public void setActivarFK_IdAsientoContableRegistroFormaPagoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableRegistroFormaPagoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteRegistroFormaPagoBanco=true;

	public Boolean getActivarFK_IdClienteRegistroFormaPagoBanco() {
		return this.activarFK_IdClienteRegistroFormaPagoBanco;
	}

	public void setActivarFK_IdClienteRegistroFormaPagoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdClienteRegistroFormaPagoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioRegistroFormaPagoBanco=true;

	public Boolean getActivarFK_IdEjercicioRegistroFormaPagoBanco() {
		return this.activarFK_IdEjercicioRegistroFormaPagoBanco;
	}

	public void setActivarFK_IdEjercicioRegistroFormaPagoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioRegistroFormaPagoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaRegistroFormaPagoBanco=true;

	public Boolean getActivarFK_IdEmpresaRegistroFormaPagoBanco() {
		return this.activarFK_IdEmpresaRegistroFormaPagoBanco;
	}

	public void setActivarFK_IdEmpresaRegistroFormaPagoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaRegistroFormaPagoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco=true;

	public Boolean getActivarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco() {
		return this.activarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco;
	}

	public void setActivarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoRegistroFormaPagoBanco=true;

	public Boolean getActivarFK_IdPeriodoRegistroFormaPagoBanco() {
		return this.activarFK_IdPeriodoRegistroFormaPagoBanco;
	}

	public void setActivarFK_IdPeriodoRegistroFormaPagoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoRegistroFormaPagoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalRegistroFormaPagoBanco=true;

	public Boolean getActivarFK_IdSucursalRegistroFormaPagoBanco() {
		return this.activarFK_IdSucursalRegistroFormaPagoBanco;
	}

	public void setActivarFK_IdSucursalRegistroFormaPagoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalRegistroFormaPagoBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoFormaPagoRegistroFormaPagoBanco=true;

	public Boolean getActivarFK_IdTipoFormaPagoRegistroFormaPagoBanco() {
		return this.activarFK_IdTipoFormaPagoRegistroFormaPagoBanco;
	}

	public void setActivarFK_IdTipoFormaPagoRegistroFormaPagoBanco(Boolean habilitarResaltar) {
		this.activarFK_IdTipoFormaPagoRegistroFormaPagoBanco= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableRegistroFormaPagoBanco=null;

	public Border getResaltarFK_IdAsientoContableRegistroFormaPagoBanco() {
		return this.resaltarFK_IdAsientoContableRegistroFormaPagoBanco;
	}

	public void setResaltarFK_IdAsientoContableRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableRegistroFormaPagoBanco= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableRegistroFormaPagoBanco= borderResaltar;
	}

	public Border resaltarFK_IdClienteRegistroFormaPagoBanco=null;

	public Border getResaltarFK_IdClienteRegistroFormaPagoBanco() {
		return this.resaltarFK_IdClienteRegistroFormaPagoBanco;
	}

	public void setResaltarFK_IdClienteRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarFK_IdClienteRegistroFormaPagoBanco= borderResaltar;
	}

	public void setResaltarFK_IdClienteRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteRegistroFormaPagoBanco= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioRegistroFormaPagoBanco=null;

	public Border getResaltarFK_IdEjercicioRegistroFormaPagoBanco() {
		return this.resaltarFK_IdEjercicioRegistroFormaPagoBanco;
	}

	public void setResaltarFK_IdEjercicioRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarFK_IdEjercicioRegistroFormaPagoBanco= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioRegistroFormaPagoBanco= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaRegistroFormaPagoBanco=null;

	public Border getResaltarFK_IdEmpresaRegistroFormaPagoBanco() {
		return this.resaltarFK_IdEmpresaRegistroFormaPagoBanco;
	}

	public void setResaltarFK_IdEmpresaRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarFK_IdEmpresaRegistroFormaPagoBanco= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaRegistroFormaPagoBanco= borderResaltar;
	}

	public Border resaltarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco=null;

	public Border getResaltarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco() {
		return this.resaltarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco;
	}

	public void setResaltarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco= borderResaltar;
	}

	public void setResaltarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoRegistroFormaPagoBancoRegistroFormaPagoBanco= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoRegistroFormaPagoBanco=null;

	public Border getResaltarFK_IdPeriodoRegistroFormaPagoBanco() {
		return this.resaltarFK_IdPeriodoRegistroFormaPagoBanco;
	}

	public void setResaltarFK_IdPeriodoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarFK_IdPeriodoRegistroFormaPagoBanco= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoRegistroFormaPagoBanco= borderResaltar;
	}

	public Border resaltarFK_IdSucursalRegistroFormaPagoBanco=null;

	public Border getResaltarFK_IdSucursalRegistroFormaPagoBanco() {
		return this.resaltarFK_IdSucursalRegistroFormaPagoBanco;
	}

	public void setResaltarFK_IdSucursalRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarFK_IdSucursalRegistroFormaPagoBanco= borderResaltar;
	}

	public void setResaltarFK_IdSucursalRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalRegistroFormaPagoBanco= borderResaltar;
	}

	public Border resaltarFK_IdTipoFormaPagoRegistroFormaPagoBanco=null;

	public Border getResaltarFK_IdTipoFormaPagoRegistroFormaPagoBanco() {
		return this.resaltarFK_IdTipoFormaPagoRegistroFormaPagoBanco;
	}

	public void setResaltarFK_IdTipoFormaPagoRegistroFormaPagoBanco(Border borderResaltar) {
		this.resaltarFK_IdTipoFormaPagoRegistroFormaPagoBanco= borderResaltar;
	}

	public void setResaltarFK_IdTipoFormaPagoRegistroFormaPagoBanco(ParametroGeneralUsuario parametroGeneralUsuario/*RegistroFormaPagoBancoBeanSwingJInternalFrame registroformapagobancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoFormaPagoRegistroFormaPagoBanco= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}