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


import com.bydan.erp.tesoreria.util.CuentaBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.CuentaBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.CuentaBancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



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
final public class CuentaBancoConstantesFunciones extends CuentaBancoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CuentaBanco";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CuentaBanco"+CuentaBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CuentaBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CuentaBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CuentaBancoConstantesFunciones.SCHEMA+"_"+CuentaBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CuentaBancoConstantesFunciones.SCHEMA+"_"+CuentaBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CuentaBancoConstantesFunciones.SCHEMA+"_"+CuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CuentaBancoConstantesFunciones.SCHEMA+"_"+CuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CuentaBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CuentaBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CuentaBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CuentaBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CuentaBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CuentaBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cuenta Bancos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cuenta Banco";
	public static final String SCLASSWEBTITULO_LOWER="Cuenta Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CuentaBanco";
	public static final String OBJECTNAME="cuentabanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="cuenta_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cuentabanco from "+CuentaBancoConstantesFunciones.SPERSISTENCENAME+" cuentabanco";
	public static String QUERYSELECTNATIVE="select "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".version_row,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_empresa,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_sucursal,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_banco,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".codigo,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".numero_cuenta,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".numero_cheque,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".numero_cheque_auxiliar,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".saldo,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".procedencia,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".destino,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".es_banco,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_estado_cuenta_banco,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_ingreso,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_egreso,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_diario,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_cheque,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_retencion,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_retencion_iva from "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME;//+" as "+CuentaBancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CuentaBancoConstantesFuncionesAdditional cuentabancoConstantesFuncionesAdditional=null;
	
	public CuentaBancoConstantesFuncionesAdditional getCuentaBancoConstantesFuncionesAdditional() {
		return this.cuentabancoConstantesFuncionesAdditional;
	}
	
	public void setCuentaBancoConstantesFuncionesAdditional(CuentaBancoConstantesFuncionesAdditional cuentabancoConstantesFuncionesAdditional) {
		try {
			this.cuentabancoConstantesFuncionesAdditional=cuentabancoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBANCO= "id_banco";
    public static final String IDTIPOCUENTABANCOGLOBAL= "id_tipo_cuenta_banco_global";
    public static final String CODIGO= "codigo";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String NUMEROCHEQUE= "numero_cheque";
    public static final String NUMEROCHEQUEAUXILIAR= "numero_cheque_auxiliar";
    public static final String SALDO= "saldo";
    public static final String PROCEDENCIA= "procedencia";
    public static final String DESTINO= "destino";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String ESBANCO= "es_banco";
    public static final String IDESTADOCUENTABANCO= "id_estado_cuenta_banco";
    public static final String IDFORMATOINGRESO= "id_formato_ingreso";
    public static final String IDFORMATOEGRESO= "id_formato_egreso";
    public static final String IDFORMATODIARIO= "id_formato_diario";
    public static final String IDFORMATOCHEQUE= "id_formato_cheque";
    public static final String IDFORMATORETENCION= "id_formato_retencion";
    public static final String IDFORMATORETENCIONIVA= "id_formato_retencion_iva";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDTIPOCUENTABANCOGLOBAL= "Tipo Cuenta";
		public static final String LABEL_IDTIPOCUENTABANCOGLOBAL_LOWER= "Tipo Cuenta Banco Global";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NUMEROCUENTA= "No Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_NUMEROCHEQUE= "No Cheque";
		public static final String LABEL_NUMEROCHEQUE_LOWER= "Numero Cheque";
    	public static final String LABEL_NUMEROCHEQUEAUXILIAR= "No Cheque 2";
		public static final String LABEL_NUMEROCHEQUEAUXILIAR_LOWER= "Numero Cheque Auxiliar";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_PROCEDENCIA= "Procedencia";
		public static final String LABEL_PROCEDENCIA_LOWER= "Procedencia";
    	public static final String LABEL_DESTINO= "Destino";
		public static final String LABEL_DESTINO_LOWER= "Destino";
    	public static final String LABEL_IDCUENTACONTABLE= "C. Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_ESBANCO= "Es Banco";
		public static final String LABEL_ESBANCO_LOWER= "Es Banco";
    	public static final String LABEL_IDESTADOCUENTABANCO= "Estado";
		public static final String LABEL_IDESTADOCUENTABANCO_LOWER= "Estado Cuenta Banco";
    	public static final String LABEL_IDFORMATOINGRESO= "Ingreso";
		public static final String LABEL_IDFORMATOINGRESO_LOWER= "Formato Ingreso";
    	public static final String LABEL_IDFORMATOEGRESO= "Egreso";
		public static final String LABEL_IDFORMATOEGRESO_LOWER= "Formato Egreso";
    	public static final String LABEL_IDFORMATODIARIO= "Diario";
		public static final String LABEL_IDFORMATODIARIO_LOWER= "Formato Diario";
    	public static final String LABEL_IDFORMATOCHEQUE= " Cheque";
		public static final String LABEL_IDFORMATOCHEQUE_LOWER= "Formato Cheque";
    	public static final String LABEL_IDFORMATORETENCION= "Retencion";
		public static final String LABEL_IDFORMATORETENCION_LOWER= "Formato Retencion";
    	public static final String LABEL_IDFORMATORETENCIONIVA= "Retenc. Iva";
		public static final String LABEL_IDFORMATORETENCIONIVA_LOWER= "Formato Retencion Iva";
	
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_CHEQUE_AUXILIAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CHEQUE_AUXILIAR=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXPROCEDENCIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXPROCEDENCIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESTINO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESTINO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getCuentaBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDBANCO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.CODIGO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.NUMEROCHEQUE)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUE;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUEAUXILIAR;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.SALDO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.PROCEDENCIA)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_PROCEDENCIA;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.DESTINO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_DESTINO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.ESBANCO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_ESBANCO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDESTADOCUENTABANCO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDFORMATOINGRESO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDFORMATOINGRESO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDFORMATOEGRESO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDFORMATOEGRESO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDFORMATODIARIO)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDFORMATODIARIO;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDFORMATOCHEQUE)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDFORMATOCHEQUE;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDFORMATORETENCION)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCION;}
		if(sNombreColumna.equals(CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA)) {sLabelColumna=CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCIONIVA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_bancoDescripcion(CuentaBanco cuentabanco) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!cuentabanco.getes_banco()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_bancoHtmlDescripcion(CuentaBanco cuentabanco) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(cuentabanco.getId(),cuentabanco.getes_banco());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
	
	public static String getCuentaBancoDescripcion(CuentaBanco cuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cuentabanco !=null/* && cuentabanco.getId()!=0*/) {
			sDescripcion=cuentabanco.getcodigo();//cuentabancocuentabanco.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCuentaBancoDescripcionDetallado(CuentaBanco cuentabanco) {
		String sDescripcion="";
			
		sDescripcion+=CuentaBancoConstantesFunciones.ID+"=";
		sDescripcion+=cuentabanco.getId().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cuentabanco.getVersionRow().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cuentabanco.getid_empresa().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cuentabanco.getid_sucursal().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDBANCO+"=";
		sDescripcion+=cuentabanco.getid_banco().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL+"=";
		sDescripcion+=cuentabanco.getid_tipo_cuenta_banco_global().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.CODIGO+"=";
		sDescripcion+=cuentabanco.getcodigo()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=cuentabanco.getnumero_cuenta()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.NUMEROCHEQUE+"=";
		sDescripcion+=cuentabanco.getnumero_cheque()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR+"=";
		sDescripcion+=cuentabanco.getnumero_cheque_auxiliar()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.SALDO+"=";
		sDescripcion+=cuentabanco.getsaldo().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.PROCEDENCIA+"=";
		sDescripcion+=cuentabanco.getprocedencia()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.DESTINO+"=";
		sDescripcion+=cuentabanco.getdestino()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=cuentabanco.getid_cuenta_contable().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.ESBANCO+"=";
		sDescripcion+=cuentabanco.getes_banco().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO+"=";
		sDescripcion+=cuentabanco.getid_estado_cuenta_banco().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDFORMATOINGRESO+"=";
		sDescripcion+=cuentabanco.getid_formato_ingreso().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDFORMATOEGRESO+"=";
		sDescripcion+=cuentabanco.getid_formato_egreso().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDFORMATODIARIO+"=";
		sDescripcion+=cuentabanco.getid_formato_diario().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDFORMATOCHEQUE+"=";
		sDescripcion+=cuentabanco.getid_formato_cheque().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDFORMATORETENCION+"=";
		sDescripcion+=cuentabanco.getid_formato_retencion().toString()+",";
		sDescripcion+=CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA+"=";
		sDescripcion+=cuentabanco.getid_formato_retencion_iva().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCuentaBancoDescripcion(CuentaBanco cuentabanco,String sValor) throws Exception {			
		if(cuentabanco !=null) {
			cuentabanco.setcodigo(sValor);;//cuentabancocuentabanco.getcodigo().trim();
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

	public static String getBancoDescripcion(Banco banco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(banco!=null/*&&banco.getId()>0*/) {
			sDescripcion=BancoConstantesFunciones.getBancoDescripcion(banco);
		}

		return sDescripcion;
	}

	public static String getTipoCuentaBancoGlobalDescripcion(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuentabancoglobal!=null/*&&tipocuentabancoglobal.getId()>0*/) {
			sDescripcion=TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(tipocuentabancoglobal);
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

	public static String getEstadoCuentaBancoDescripcion(EstadoCuentaBanco estadocuentabanco) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadocuentabanco!=null/*&&estadocuentabanco.getId()>0*/) {
			sDescripcion=EstadoCuentaBancoConstantesFunciones.getEstadoCuentaBancoDescripcion(estadocuentabanco);
		}

		return sDescripcion;
	}

	public static String getFormatoIngresoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoEgresoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoDiarioDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoChequeDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoRetencionDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getFormatoRetencionIvaDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNumeroCheque")) {
			sNombreIndice="Tipo=  Por No Cheque";
		} else if(sNombreIndice.equals("BusquedaPorNumeroCuenta")) {
			sNombreIndice="Tipo=  Por No Cuenta";
		} else if(sNombreIndice.equals("BusquedaPorProcedencia")) {
			sNombreIndice="Tipo=  Por Procedencia";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por C. Contable";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoCuentaBanco")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormatoCheque")) {
			sNombreIndice="Tipo=  Por  Cheque";
		} else if(sNombreIndice.equals("FK_IdFormatoDiario")) {
			sNombreIndice="Tipo=  Por Diario";
		} else if(sNombreIndice.equals("FK_IdFormatoEgreso")) {
			sNombreIndice="Tipo=  Por Egreso";
		} else if(sNombreIndice.equals("FK_IdFormatoIngreso")) {
			sNombreIndice="Tipo=  Por Ingreso";
		} else if(sNombreIndice.equals("FK_IdFormatoRetencion")) {
			sNombreIndice="Tipo=  Por Retencion";
		} else if(sNombreIndice.equals("FK_IdFormatoRetencionIva")) {
			sNombreIndice="Tipo=  Por Retenc. Iva";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCuentaBancoGlobal")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNumeroCheque(String numero_cheque) {
		String sDetalleIndice=" Parametros->";
		if(numero_cheque!=null) {sDetalleIndice+=" No Cheque="+numero_cheque;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNumeroCuenta(String numero_cuenta) {
		String sDetalleIndice=" Parametros->";
		if(numero_cuenta!=null) {sDetalleIndice+=" No Cuenta="+numero_cuenta;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorProcedencia(String procedencia) {
		String sDetalleIndice=" Parametros->";
		if(procedencia!=null) {sDetalleIndice+=" Procedencia="+procedencia;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De C. Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoCuentaBanco(Long id_estado_cuenta_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_cuenta_banco!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_cuenta_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoCheque(Long id_formato_cheque) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_cheque!=null) {sDetalleIndice+=" Codigo Unico De  Cheque="+id_formato_cheque.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoDiario(Long id_formato_diario) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_diario!=null) {sDetalleIndice+=" Codigo Unico De Diario="+id_formato_diario.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoEgreso(Long id_formato_egreso) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_egreso!=null) {sDetalleIndice+=" Codigo Unico De Egreso="+id_formato_egreso.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoIngreso(Long id_formato_ingreso) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_ingreso!=null) {sDetalleIndice+=" Codigo Unico De Ingreso="+id_formato_ingreso.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoRetencion(Long id_formato_retencion) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_retencion!=null) {sDetalleIndice+=" Codigo Unico De Retencion="+id_formato_retencion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormatoRetencionIva(Long id_formato_retencion_iva) {
		String sDetalleIndice=" Parametros->";
		if(id_formato_retencion_iva!=null) {sDetalleIndice+=" Codigo Unico De Retenc. Iva="+id_formato_retencion_iva.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuentaBancoGlobal(Long id_tipo_cuenta_banco_global) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuenta_banco_global!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta="+id_tipo_cuenta_banco_global.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCuentaBanco(CuentaBanco cuentabanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cuentabanco.setcodigo(cuentabanco.getcodigo().trim());
		cuentabanco.setnumero_cuenta(cuentabanco.getnumero_cuenta().trim());
		cuentabanco.setnumero_cheque(cuentabanco.getnumero_cheque().trim());
		cuentabanco.setnumero_cheque_auxiliar(cuentabanco.getnumero_cheque_auxiliar().trim());
		cuentabanco.setprocedencia(cuentabanco.getprocedencia().trim());
		cuentabanco.setdestino(cuentabanco.getdestino().trim());
	}
	
	public static void quitarEspaciosCuentaBancos(List<CuentaBanco> cuentabancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CuentaBanco cuentabanco: cuentabancos) {
			cuentabanco.setcodigo(cuentabanco.getcodigo().trim());
			cuentabanco.setnumero_cuenta(cuentabanco.getnumero_cuenta().trim());
			cuentabanco.setnumero_cheque(cuentabanco.getnumero_cheque().trim());
			cuentabanco.setnumero_cheque_auxiliar(cuentabanco.getnumero_cheque_auxiliar().trim());
			cuentabanco.setprocedencia(cuentabanco.getprocedencia().trim());
			cuentabanco.setdestino(cuentabanco.getdestino().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaBanco(CuentaBanco cuentabanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cuentabanco.getConCambioAuxiliar()) {
			cuentabanco.setIsDeleted(cuentabanco.getIsDeletedAuxiliar());	
			cuentabanco.setIsNew(cuentabanco.getIsNewAuxiliar());	
			cuentabanco.setIsChanged(cuentabanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cuentabanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cuentabanco.setIsDeletedAuxiliar(false);	
			cuentabanco.setIsNewAuxiliar(false);	
			cuentabanco.setIsChangedAuxiliar(false);
			
			cuentabanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCuentaBancos(List<CuentaBanco> cuentabancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CuentaBanco cuentabanco : cuentabancos) {
			if(conAsignarBase && cuentabanco.getConCambioAuxiliar()) {
				cuentabanco.setIsDeleted(cuentabanco.getIsDeletedAuxiliar());	
				cuentabanco.setIsNew(cuentabanco.getIsNewAuxiliar());	
				cuentabanco.setIsChanged(cuentabanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cuentabanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cuentabanco.setIsDeletedAuxiliar(false);	
				cuentabanco.setIsNewAuxiliar(false);	
				cuentabanco.setIsChangedAuxiliar(false);
				
				cuentabanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCuentaBanco(CuentaBanco cuentabanco,Boolean conEnteros) throws Exception  {
		cuentabanco.setsaldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCuentaBancos(List<CuentaBanco> cuentabancos,Boolean conEnteros) throws Exception  {
		
		for(CuentaBanco cuentabanco: cuentabancos) {
			cuentabanco.setsaldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCuentaBanco(List<CuentaBanco> cuentabancos,CuentaBanco cuentabancoAux) throws Exception  {
		CuentaBancoConstantesFunciones.InicializarValoresCuentaBanco(cuentabancoAux,true);
		
		for(CuentaBanco cuentabanco: cuentabancos) {
			if(cuentabanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cuentabancoAux.setsaldo(cuentabancoAux.getsaldo()+cuentabanco.getsaldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CuentaBancoConstantesFunciones.getArrayColumnasGlobalesCuentaBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaBancoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaBancoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CuentaBancoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CuentaBancoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCuentaBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CuentaBanco> cuentabancos,CuentaBanco cuentabanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CuentaBanco cuentabancoAux: cuentabancos) {
			if(cuentabancoAux!=null && cuentabanco!=null) {
				if((cuentabancoAux.getId()==null && cuentabanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cuentabancoAux.getId()!=null && cuentabanco.getId()!=null){
					if(cuentabancoAux.getId().equals(cuentabanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCuentaBanco(List<CuentaBanco> cuentabancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldoTotal=0.0;
	
		for(CuentaBanco cuentabanco: cuentabancos) {			
			if(cuentabanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldoTotal+=cuentabanco.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CuentaBancoConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCuentaBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_ID, CuentaBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_VERSIONROW, CuentaBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDEMPRESA, CuentaBancoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDSUCURSAL, CuentaBancoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDBANCO, CuentaBancoConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL, CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_CODIGO, CuentaBancoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_NUMEROCUENTA, CuentaBancoConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUE, CuentaBancoConstantesFunciones.NUMEROCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUEAUXILIAR, CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_SALDO, CuentaBancoConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_PROCEDENCIA, CuentaBancoConstantesFunciones.PROCEDENCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_DESTINO, CuentaBancoConstantesFunciones.DESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDCUENTACONTABLE, CuentaBancoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_ESBANCO, CuentaBancoConstantesFunciones.ESBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDESTADOCUENTABANCO, CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDFORMATOINGRESO, CuentaBancoConstantesFunciones.IDFORMATOINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDFORMATOEGRESO, CuentaBancoConstantesFunciones.IDFORMATOEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDFORMATODIARIO, CuentaBancoConstantesFunciones.IDFORMATODIARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDFORMATOCHEQUE, CuentaBancoConstantesFunciones.IDFORMATOCHEQUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCION, CuentaBancoConstantesFunciones.IDFORMATORETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCIONIVA, CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCuentaBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.NUMEROCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.PROCEDENCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.DESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.ESBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDFORMATOINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDFORMATOEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDFORMATODIARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDFORMATOCHEQUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDFORMATORETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaBanco() throws Exception  {
		return CuentaBancoConstantesFunciones.getTiposSeleccionarCuentaBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaBanco(Boolean conFk) throws Exception  {
		return CuentaBancoConstantesFunciones.getTiposSeleccionarCuentaBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCuentaBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUE);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUEAUXILIAR);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUEAUXILIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_PROCEDENCIA);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_PROCEDENCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_DESTINO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_DESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_ESBANCO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_ESBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDESTADOCUENTABANCO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDESTADOCUENTABANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDFORMATOINGRESO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDFORMATOINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDFORMATOEGRESO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDFORMATOEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDFORMATODIARIO);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDFORMATODIARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDFORMATOCHEQUE);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDFORMATOCHEQUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCION);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCIONIVA);
			reporte.setsDescripcion(CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCIONIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCuentaBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaBanco(CuentaBanco cuentabancoAux) throws Exception {
		
			cuentabancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentabancoAux.getEmpresa()));
			cuentabancoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cuentabancoAux.getSucursal()));
			cuentabancoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(cuentabancoAux.getBanco()));
			cuentabancoAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(cuentabancoAux.getTipoCuentaBancoGlobal()));
			cuentabancoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentabancoAux.getCuentaContable()));
			cuentabancoAux.setestadocuentabanco_descripcion(EstadoCuentaBancoConstantesFunciones.getEstadoCuentaBancoDescripcion(cuentabancoAux.getEstadoCuentaBanco()));
			cuentabancoAux.setformatoingreso_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoIngreso()));
			cuentabancoAux.setformatoegreso_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoEgreso()));
			cuentabancoAux.setformatodiario_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoDiario()));
			cuentabancoAux.setformatocheque_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoCheque()));
			cuentabancoAux.setformatoretencion_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoRetencion()));
			cuentabancoAux.setformatoretencioniva_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoRetencionIva()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCuentaBanco(List<CuentaBanco> cuentabancosTemp) throws Exception {
		for(CuentaBanco cuentabancoAux:cuentabancosTemp) {
			
			cuentabancoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cuentabancoAux.getEmpresa()));
			cuentabancoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cuentabancoAux.getSucursal()));
			cuentabancoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(cuentabancoAux.getBanco()));
			cuentabancoAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(cuentabancoAux.getTipoCuentaBancoGlobal()));
			cuentabancoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentabancoAux.getCuentaContable()));
			cuentabancoAux.setestadocuentabanco_descripcion(EstadoCuentaBancoConstantesFunciones.getEstadoCuentaBancoDescripcion(cuentabancoAux.getEstadoCuentaBanco()));
			cuentabancoAux.setformatoingreso_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoIngreso()));
			cuentabancoAux.setformatoegreso_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoEgreso()));
			cuentabancoAux.setformatodiario_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoDiario()));
			cuentabancoAux.setformatocheque_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoCheque()));
			cuentabancoAux.setformatoretencion_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoRetencion()));
			cuentabancoAux.setformatoretencioniva_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(cuentabancoAux.getFormatoRetencionIva()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(TipoCuentaBancoGlobal.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(EstadoCuentaBanco.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Formato.class));
				
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
					if(clas.clas.equals(Banco.class)) {
						classes.add(new Classe(Banco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoCuentaBanco.class)) {
						classes.add(new Classe(EstadoCuentaBanco.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(EstadoCuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCuentaBanco.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(EstadoCuentaBanco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoCuentaBanco.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaBancoConstantesFunciones.getClassesRelationshipsOfCuentaBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PagoAuto.class));
				classes.add(new Classe(AutoriPagoOrdenCompra.class));
				classes.add(new Classe(DetalleChequeGirado.class));
				classes.add(new Classe(AutoriPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PagoAuto.class)) {
						classes.add(new Classe(PagoAuto.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriPagoOrdenCompra.class)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleChequeGirado.class)) {
						classes.add(new Classe(DetalleChequeGirado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriPago.class)) {
						classes.add(new Classe(AutoriPago.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CuentaBancoConstantesFunciones.getClassesRelationshipsFromStringsOfCuentaBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCuentaBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PagoAuto.class)); continue;
					}

					if(AutoriPagoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); continue;
					}

					if(DetalleChequeGirado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleChequeGirado.class)); continue;
					}

					if(AutoriPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PagoAuto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PagoAuto.class)); continue;
					}

					if(AutoriPagoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); continue;
					}

					if(DetalleChequeGirado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleChequeGirado.class)); continue;
					}

					if(AutoriPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPago.class)); continue;
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
	public static void actualizarLista(CuentaBanco cuentabanco,List<CuentaBanco> cuentabancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CuentaBanco cuentabancoEncontrado=null;
			
			for(CuentaBanco cuentabancoLocal:cuentabancos) {
				if(cuentabancoLocal.getId().equals(cuentabanco.getId())) {
					cuentabancoEncontrado=cuentabancoLocal;
					
					cuentabancoLocal.setIsChanged(cuentabanco.getIsChanged());
					cuentabancoLocal.setIsNew(cuentabanco.getIsNew());
					cuentabancoLocal.setIsDeleted(cuentabanco.getIsDeleted());
					
					cuentabancoLocal.setGeneralEntityOriginal(cuentabanco.getGeneralEntityOriginal());
					
					cuentabancoLocal.setId(cuentabanco.getId());	
					cuentabancoLocal.setVersionRow(cuentabanco.getVersionRow());	
					cuentabancoLocal.setid_empresa(cuentabanco.getid_empresa());	
					cuentabancoLocal.setid_sucursal(cuentabanco.getid_sucursal());	
					cuentabancoLocal.setid_banco(cuentabanco.getid_banco());	
					cuentabancoLocal.setid_tipo_cuenta_banco_global(cuentabanco.getid_tipo_cuenta_banco_global());	
					cuentabancoLocal.setcodigo(cuentabanco.getcodigo());	
					cuentabancoLocal.setnumero_cuenta(cuentabanco.getnumero_cuenta());	
					cuentabancoLocal.setnumero_cheque(cuentabanco.getnumero_cheque());	
					cuentabancoLocal.setnumero_cheque_auxiliar(cuentabanco.getnumero_cheque_auxiliar());	
					cuentabancoLocal.setsaldo(cuentabanco.getsaldo());	
					cuentabancoLocal.setprocedencia(cuentabanco.getprocedencia());	
					cuentabancoLocal.setdestino(cuentabanco.getdestino());	
					cuentabancoLocal.setid_cuenta_contable(cuentabanco.getid_cuenta_contable());	
					cuentabancoLocal.setes_banco(cuentabanco.getes_banco());	
					cuentabancoLocal.setid_estado_cuenta_banco(cuentabanco.getid_estado_cuenta_banco());	
					cuentabancoLocal.setid_formato_ingreso(cuentabanco.getid_formato_ingreso());	
					cuentabancoLocal.setid_formato_egreso(cuentabanco.getid_formato_egreso());	
					cuentabancoLocal.setid_formato_diario(cuentabanco.getid_formato_diario());	
					cuentabancoLocal.setid_formato_cheque(cuentabanco.getid_formato_cheque());	
					cuentabancoLocal.setid_formato_retencion(cuentabanco.getid_formato_retencion());	
					cuentabancoLocal.setid_formato_retencion_iva(cuentabanco.getid_formato_retencion_iva());	
					
					
					cuentabancoLocal.setPagoAutos(cuentabanco.getPagoAutos());
					cuentabancoLocal.setAutoriPagoOrdenCompras(cuentabanco.getAutoriPagoOrdenCompras());
					cuentabancoLocal.setDetalleChequeGirados(cuentabanco.getDetalleChequeGirados());
					cuentabancoLocal.setAutoriPagos(cuentabanco.getAutoriPagos());
					
					existe=true;
					break;
				}
			}
			
			if(!cuentabanco.getIsDeleted()) {
				if(!existe) {
					cuentabancos.add(cuentabanco);
				}
			} else {
				if(cuentabancoEncontrado!=null && permiteQuitar)  {
					cuentabancos.remove(cuentabancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CuentaBanco cuentabanco,List<CuentaBanco> cuentabancos) throws Exception {
		try	{			
			for(CuentaBanco cuentabancoLocal:cuentabancos) {
				if(cuentabancoLocal.getId().equals(cuentabanco.getId())) {
					cuentabancoLocal.setIsSelected(cuentabanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCuentaBanco(List<CuentaBanco> cuentabancosAux) throws Exception {
		//this.cuentabancosAux=cuentabancosAux;
		
		for(CuentaBanco cuentabancoAux:cuentabancosAux) {
			if(cuentabancoAux.getIsChanged()) {
				cuentabancoAux.setIsChanged(false);
			}		
			
			if(cuentabancoAux.getIsNew()) {
				cuentabancoAux.setIsNew(false);
			}	
			
			if(cuentabancoAux.getIsDeleted()) {
				cuentabancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCuentaBanco(CuentaBanco cuentabancoAux) throws Exception {
		//this.cuentabancoAux=cuentabancoAux;
		
			if(cuentabancoAux.getIsChanged()) {
				cuentabancoAux.setIsChanged(false);
			}		
			
			if(cuentabancoAux.getIsNew()) {
				cuentabancoAux.setIsNew(false);
			}	
			
			if(cuentabancoAux.getIsDeleted()) {
				cuentabancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CuentaBanco cuentabancoAsignar,CuentaBanco cuentabanco) throws Exception {
		cuentabancoAsignar.setId(cuentabanco.getId());	
		cuentabancoAsignar.setVersionRow(cuentabanco.getVersionRow());	
		cuentabancoAsignar.setid_empresa(cuentabanco.getid_empresa());
		cuentabancoAsignar.setempresa_descripcion(cuentabanco.getempresa_descripcion());	
		cuentabancoAsignar.setid_sucursal(cuentabanco.getid_sucursal());
		cuentabancoAsignar.setsucursal_descripcion(cuentabanco.getsucursal_descripcion());	
		cuentabancoAsignar.setid_banco(cuentabanco.getid_banco());
		cuentabancoAsignar.setbanco_descripcion(cuentabanco.getbanco_descripcion());	
		cuentabancoAsignar.setid_tipo_cuenta_banco_global(cuentabanco.getid_tipo_cuenta_banco_global());
		cuentabancoAsignar.settipocuentabancoglobal_descripcion(cuentabanco.gettipocuentabancoglobal_descripcion());	
		cuentabancoAsignar.setcodigo(cuentabanco.getcodigo());	
		cuentabancoAsignar.setnumero_cuenta(cuentabanco.getnumero_cuenta());	
		cuentabancoAsignar.setnumero_cheque(cuentabanco.getnumero_cheque());	
		cuentabancoAsignar.setnumero_cheque_auxiliar(cuentabanco.getnumero_cheque_auxiliar());	
		cuentabancoAsignar.setsaldo(cuentabanco.getsaldo());	
		cuentabancoAsignar.setprocedencia(cuentabanco.getprocedencia());	
		cuentabancoAsignar.setdestino(cuentabanco.getdestino());	
		cuentabancoAsignar.setid_cuenta_contable(cuentabanco.getid_cuenta_contable());
		cuentabancoAsignar.setcuentacontable_descripcion(cuentabanco.getcuentacontable_descripcion());	
		cuentabancoAsignar.setes_banco(cuentabanco.getes_banco());	
		cuentabancoAsignar.setid_estado_cuenta_banco(cuentabanco.getid_estado_cuenta_banco());
		cuentabancoAsignar.setestadocuentabanco_descripcion(cuentabanco.getestadocuentabanco_descripcion());	
		cuentabancoAsignar.setid_formato_ingreso(cuentabanco.getid_formato_ingreso());
		cuentabancoAsignar.setformatoingreso_descripcion(cuentabanco.getformatoingreso_descripcion());	
		cuentabancoAsignar.setid_formato_egreso(cuentabanco.getid_formato_egreso());
		cuentabancoAsignar.setformatoegreso_descripcion(cuentabanco.getformatoegreso_descripcion());	
		cuentabancoAsignar.setid_formato_diario(cuentabanco.getid_formato_diario());
		cuentabancoAsignar.setformatodiario_descripcion(cuentabanco.getformatodiario_descripcion());	
		cuentabancoAsignar.setid_formato_cheque(cuentabanco.getid_formato_cheque());
		cuentabancoAsignar.setformatocheque_descripcion(cuentabanco.getformatocheque_descripcion());	
		cuentabancoAsignar.setid_formato_retencion(cuentabanco.getid_formato_retencion());
		cuentabancoAsignar.setformatoretencion_descripcion(cuentabanco.getformatoretencion_descripcion());	
		cuentabancoAsignar.setid_formato_retencion_iva(cuentabanco.getid_formato_retencion_iva());
		cuentabancoAsignar.setformatoretencioniva_descripcion(cuentabanco.getformatoretencioniva_descripcion());	
	}
	
	public static void inicializarCuentaBanco(CuentaBanco cuentabanco) throws Exception {
		try {
				cuentabanco.setId(0L);	
					
				cuentabanco.setid_empresa(-1L);	
				cuentabanco.setid_sucursal(-1L);	
				cuentabanco.setid_banco(-1L);	
				cuentabanco.setid_tipo_cuenta_banco_global(-1L);	
				cuentabanco.setcodigo("");	
				cuentabanco.setnumero_cuenta("");	
				cuentabanco.setnumero_cheque("");	
				cuentabanco.setnumero_cheque_auxiliar("");	
				cuentabanco.setsaldo(0.0);	
				cuentabanco.setprocedencia("");	
				cuentabanco.setdestino("");	
				cuentabanco.setid_cuenta_contable(-1L);	
				cuentabanco.setes_banco(false);	
				cuentabanco.setid_estado_cuenta_banco(-1L);	
				cuentabanco.setid_formato_ingreso(-1L);	
				cuentabanco.setid_formato_egreso(-1L);	
				cuentabanco.setid_formato_diario(-1L);	
				cuentabanco.setid_formato_cheque(-1L);	
				cuentabanco.setid_formato_retencion(null);	
				cuentabanco.setid_formato_retencion_iva(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCuentaBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_NUMEROCHEQUEAUXILIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_PROCEDENCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_DESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_ESBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDESTADOCUENTABANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDFORMATOINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDFORMATOEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDFORMATODIARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDFORMATOCHEQUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CuentaBancoConstantesFunciones.LABEL_IDFORMATORETENCIONIVA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCuentaBanco(String sTipo,Row row,Workbook workbook,CuentaBanco cuentabanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.gettipocuentabancoglobal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getnumero_cheque());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getnumero_cheque_auxiliar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getprocedencia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getdestino());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(cuentabanco.getes_banco()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getestadocuentabanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getformatoingreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getformatoegreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getformatodiario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getformatocheque_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getformatoretencion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cuentabanco.getformatoretencioniva_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCuentaBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCuentaBanco() {
		return this.sFinalQueryCuentaBanco;
	}
	
	public void setsFinalQueryCuentaBanco(String sFinalQueryCuentaBanco) {
		this.sFinalQueryCuentaBanco= sFinalQueryCuentaBanco;
	}
	
	public Border resaltarSeleccionarCuentaBanco=null;
	
	public Border setResaltarSeleccionarCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCuentaBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCuentaBanco() {
		return this.resaltarSeleccionarCuentaBanco;
	}
	
	public void setResaltarSeleccionarCuentaBanco(Border borderResaltarSeleccionarCuentaBanco) {
		this.resaltarSeleccionarCuentaBanco= borderResaltarSeleccionarCuentaBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCuentaBanco=null;
	public Boolean mostraridCuentaBanco=true;
	public Boolean activaridCuentaBanco=true;

	public Border resaltarid_empresaCuentaBanco=null;
	public Boolean mostrarid_empresaCuentaBanco=true;
	public Boolean activarid_empresaCuentaBanco=true;
	public Boolean cargarid_empresaCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_sucursalCuentaBanco=null;
	public Boolean mostrarid_sucursalCuentaBanco=true;
	public Boolean activarid_sucursalCuentaBanco=true;
	public Boolean cargarid_sucursalCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_bancoCuentaBanco=null;
	public Boolean mostrarid_bancoCuentaBanco=true;
	public Boolean activarid_bancoCuentaBanco=true;
	public Boolean cargarid_bancoCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_tipo_cuenta_banco_globalCuentaBanco=null;
	public Boolean mostrarid_tipo_cuenta_banco_globalCuentaBanco=true;
	public Boolean activarid_tipo_cuenta_banco_globalCuentaBanco=true;
	public Boolean cargarid_tipo_cuenta_banco_globalCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuenta_banco_globalCuentaBanco=false;//ConEventDepend=true

	public Border resaltarcodigoCuentaBanco=null;
	public Boolean mostrarcodigoCuentaBanco=true;
	public Boolean activarcodigoCuentaBanco=true;

	public Border resaltarnumero_cuentaCuentaBanco=null;
	public Boolean mostrarnumero_cuentaCuentaBanco=true;
	public Boolean activarnumero_cuentaCuentaBanco=true;

	public Border resaltarnumero_chequeCuentaBanco=null;
	public Boolean mostrarnumero_chequeCuentaBanco=true;
	public Boolean activarnumero_chequeCuentaBanco=true;

	public Border resaltarnumero_cheque_auxiliarCuentaBanco=null;
	public Boolean mostrarnumero_cheque_auxiliarCuentaBanco=true;
	public Boolean activarnumero_cheque_auxiliarCuentaBanco=true;

	public Border resaltarsaldoCuentaBanco=null;
	public Boolean mostrarsaldoCuentaBanco=true;
	public Boolean activarsaldoCuentaBanco=true;

	public Border resaltarprocedenciaCuentaBanco=null;
	public Boolean mostrarprocedenciaCuentaBanco=true;
	public Boolean activarprocedenciaCuentaBanco=true;

	public Border resaltardestinoCuentaBanco=null;
	public Boolean mostrardestinoCuentaBanco=true;
	public Boolean activardestinoCuentaBanco=true;

	public Border resaltarid_cuenta_contableCuentaBanco=null;
	public Boolean mostrarid_cuenta_contableCuentaBanco=true;
	public Boolean activarid_cuenta_contableCuentaBanco=true;
	public Boolean cargarid_cuenta_contableCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableCuentaBanco=false;//ConEventDepend=true

	public Border resaltares_bancoCuentaBanco=null;
	public Boolean mostrares_bancoCuentaBanco=true;
	public Boolean activares_bancoCuentaBanco=true;

	public Border resaltarid_estado_cuenta_bancoCuentaBanco=null;
	public Boolean mostrarid_estado_cuenta_bancoCuentaBanco=true;
	public Boolean activarid_estado_cuenta_bancoCuentaBanco=true;
	public Boolean cargarid_estado_cuenta_bancoCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_cuenta_bancoCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_formato_ingresoCuentaBanco=null;
	public Boolean mostrarid_formato_ingresoCuentaBanco=true;
	public Boolean activarid_formato_ingresoCuentaBanco=true;
	public Boolean cargarid_formato_ingresoCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_ingresoCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_formato_egresoCuentaBanco=null;
	public Boolean mostrarid_formato_egresoCuentaBanco=true;
	public Boolean activarid_formato_egresoCuentaBanco=true;
	public Boolean cargarid_formato_egresoCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_egresoCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_formato_diarioCuentaBanco=null;
	public Boolean mostrarid_formato_diarioCuentaBanco=true;
	public Boolean activarid_formato_diarioCuentaBanco=true;
	public Boolean cargarid_formato_diarioCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_diarioCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_formato_chequeCuentaBanco=null;
	public Boolean mostrarid_formato_chequeCuentaBanco=true;
	public Boolean activarid_formato_chequeCuentaBanco=true;
	public Boolean cargarid_formato_chequeCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_chequeCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_formato_retencionCuentaBanco=null;
	public Boolean mostrarid_formato_retencionCuentaBanco=true;
	public Boolean activarid_formato_retencionCuentaBanco=true;
	public Boolean cargarid_formato_retencionCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_retencionCuentaBanco=false;//ConEventDepend=true

	public Border resaltarid_formato_retencion_ivaCuentaBanco=null;
	public Boolean mostrarid_formato_retencion_ivaCuentaBanco=true;
	public Boolean activarid_formato_retencion_ivaCuentaBanco=true;
	public Boolean cargarid_formato_retencion_ivaCuentaBanco=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formato_retencion_ivaCuentaBanco=false;//ConEventDepend=true

	
	

	public Border setResaltaridCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltaridCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCuentaBanco() {
		return this.resaltaridCuentaBanco;
	}

	public void setResaltaridCuentaBanco(Border borderResaltar) {
		this.resaltaridCuentaBanco= borderResaltar;
	}

	public Boolean getMostraridCuentaBanco() {
		return this.mostraridCuentaBanco;
	}

	public void setMostraridCuentaBanco(Boolean mostraridCuentaBanco) {
		this.mostraridCuentaBanco= mostraridCuentaBanco;
	}

	public Boolean getActivaridCuentaBanco() {
		return this.activaridCuentaBanco;
	}

	public void setActivaridCuentaBanco(Boolean activaridCuentaBanco) {
		this.activaridCuentaBanco= activaridCuentaBanco;
	}

	public Border setResaltarid_empresaCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_empresaCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCuentaBanco() {
		return this.resaltarid_empresaCuentaBanco;
	}

	public void setResaltarid_empresaCuentaBanco(Border borderResaltar) {
		this.resaltarid_empresaCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_empresaCuentaBanco() {
		return this.mostrarid_empresaCuentaBanco;
	}

	public void setMostrarid_empresaCuentaBanco(Boolean mostrarid_empresaCuentaBanco) {
		this.mostrarid_empresaCuentaBanco= mostrarid_empresaCuentaBanco;
	}

	public Boolean getActivarid_empresaCuentaBanco() {
		return this.activarid_empresaCuentaBanco;
	}

	public void setActivarid_empresaCuentaBanco(Boolean activarid_empresaCuentaBanco) {
		this.activarid_empresaCuentaBanco= activarid_empresaCuentaBanco;
	}

	public Boolean getCargarid_empresaCuentaBanco() {
		return this.cargarid_empresaCuentaBanco;
	}

	public void setCargarid_empresaCuentaBanco(Boolean cargarid_empresaCuentaBanco) {
		this.cargarid_empresaCuentaBanco= cargarid_empresaCuentaBanco;
	}

	public Border setResaltarid_sucursalCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCuentaBanco() {
		return this.resaltarid_sucursalCuentaBanco;
	}

	public void setResaltarid_sucursalCuentaBanco(Border borderResaltar) {
		this.resaltarid_sucursalCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCuentaBanco() {
		return this.mostrarid_sucursalCuentaBanco;
	}

	public void setMostrarid_sucursalCuentaBanco(Boolean mostrarid_sucursalCuentaBanco) {
		this.mostrarid_sucursalCuentaBanco= mostrarid_sucursalCuentaBanco;
	}

	public Boolean getActivarid_sucursalCuentaBanco() {
		return this.activarid_sucursalCuentaBanco;
	}

	public void setActivarid_sucursalCuentaBanco(Boolean activarid_sucursalCuentaBanco) {
		this.activarid_sucursalCuentaBanco= activarid_sucursalCuentaBanco;
	}

	public Boolean getCargarid_sucursalCuentaBanco() {
		return this.cargarid_sucursalCuentaBanco;
	}

	public void setCargarid_sucursalCuentaBanco(Boolean cargarid_sucursalCuentaBanco) {
		this.cargarid_sucursalCuentaBanco= cargarid_sucursalCuentaBanco;
	}

	public Border setResaltarid_bancoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_bancoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoCuentaBanco() {
		return this.resaltarid_bancoCuentaBanco;
	}

	public void setResaltarid_bancoCuentaBanco(Border borderResaltar) {
		this.resaltarid_bancoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_bancoCuentaBanco() {
		return this.mostrarid_bancoCuentaBanco;
	}

	public void setMostrarid_bancoCuentaBanco(Boolean mostrarid_bancoCuentaBanco) {
		this.mostrarid_bancoCuentaBanco= mostrarid_bancoCuentaBanco;
	}

	public Boolean getActivarid_bancoCuentaBanco() {
		return this.activarid_bancoCuentaBanco;
	}

	public void setActivarid_bancoCuentaBanco(Boolean activarid_bancoCuentaBanco) {
		this.activarid_bancoCuentaBanco= activarid_bancoCuentaBanco;
	}

	public Boolean getCargarid_bancoCuentaBanco() {
		return this.cargarid_bancoCuentaBanco;
	}

	public void setCargarid_bancoCuentaBanco(Boolean cargarid_bancoCuentaBanco) {
		this.cargarid_bancoCuentaBanco= cargarid_bancoCuentaBanco;
	}

	public Border setResaltarid_tipo_cuenta_banco_globalCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuenta_banco_globalCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuenta_banco_globalCuentaBanco() {
		return this.resaltarid_tipo_cuenta_banco_globalCuentaBanco;
	}

	public void setResaltarid_tipo_cuenta_banco_globalCuentaBanco(Border borderResaltar) {
		this.resaltarid_tipo_cuenta_banco_globalCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuenta_banco_globalCuentaBanco() {
		return this.mostrarid_tipo_cuenta_banco_globalCuentaBanco;
	}

	public void setMostrarid_tipo_cuenta_banco_globalCuentaBanco(Boolean mostrarid_tipo_cuenta_banco_globalCuentaBanco) {
		this.mostrarid_tipo_cuenta_banco_globalCuentaBanco= mostrarid_tipo_cuenta_banco_globalCuentaBanco;
	}

	public Boolean getActivarid_tipo_cuenta_banco_globalCuentaBanco() {
		return this.activarid_tipo_cuenta_banco_globalCuentaBanco;
	}

	public void setActivarid_tipo_cuenta_banco_globalCuentaBanco(Boolean activarid_tipo_cuenta_banco_globalCuentaBanco) {
		this.activarid_tipo_cuenta_banco_globalCuentaBanco= activarid_tipo_cuenta_banco_globalCuentaBanco;
	}

	public Boolean getCargarid_tipo_cuenta_banco_globalCuentaBanco() {
		return this.cargarid_tipo_cuenta_banco_globalCuentaBanco;
	}

	public void setCargarid_tipo_cuenta_banco_globalCuentaBanco(Boolean cargarid_tipo_cuenta_banco_globalCuentaBanco) {
		this.cargarid_tipo_cuenta_banco_globalCuentaBanco= cargarid_tipo_cuenta_banco_globalCuentaBanco;
	}

	public Border setResaltarcodigoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarcodigoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCuentaBanco() {
		return this.resaltarcodigoCuentaBanco;
	}

	public void setResaltarcodigoCuentaBanco(Border borderResaltar) {
		this.resaltarcodigoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarcodigoCuentaBanco() {
		return this.mostrarcodigoCuentaBanco;
	}

	public void setMostrarcodigoCuentaBanco(Boolean mostrarcodigoCuentaBanco) {
		this.mostrarcodigoCuentaBanco= mostrarcodigoCuentaBanco;
	}

	public Boolean getActivarcodigoCuentaBanco() {
		return this.activarcodigoCuentaBanco;
	}

	public void setActivarcodigoCuentaBanco(Boolean activarcodigoCuentaBanco) {
		this.activarcodigoCuentaBanco= activarcodigoCuentaBanco;
	}

	public Border setResaltarnumero_cuentaCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaCuentaBanco() {
		return this.resaltarnumero_cuentaCuentaBanco;
	}

	public void setResaltarnumero_cuentaCuentaBanco(Border borderResaltar) {
		this.resaltarnumero_cuentaCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaCuentaBanco() {
		return this.mostrarnumero_cuentaCuentaBanco;
	}

	public void setMostrarnumero_cuentaCuentaBanco(Boolean mostrarnumero_cuentaCuentaBanco) {
		this.mostrarnumero_cuentaCuentaBanco= mostrarnumero_cuentaCuentaBanco;
	}

	public Boolean getActivarnumero_cuentaCuentaBanco() {
		return this.activarnumero_cuentaCuentaBanco;
	}

	public void setActivarnumero_cuentaCuentaBanco(Boolean activarnumero_cuentaCuentaBanco) {
		this.activarnumero_cuentaCuentaBanco= activarnumero_cuentaCuentaBanco;
	}

	public Border setResaltarnumero_chequeCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarnumero_chequeCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_chequeCuentaBanco() {
		return this.resaltarnumero_chequeCuentaBanco;
	}

	public void setResaltarnumero_chequeCuentaBanco(Border borderResaltar) {
		this.resaltarnumero_chequeCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarnumero_chequeCuentaBanco() {
		return this.mostrarnumero_chequeCuentaBanco;
	}

	public void setMostrarnumero_chequeCuentaBanco(Boolean mostrarnumero_chequeCuentaBanco) {
		this.mostrarnumero_chequeCuentaBanco= mostrarnumero_chequeCuentaBanco;
	}

	public Boolean getActivarnumero_chequeCuentaBanco() {
		return this.activarnumero_chequeCuentaBanco;
	}

	public void setActivarnumero_chequeCuentaBanco(Boolean activarnumero_chequeCuentaBanco) {
		this.activarnumero_chequeCuentaBanco= activarnumero_chequeCuentaBanco;
	}

	public Border setResaltarnumero_cheque_auxiliarCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarnumero_cheque_auxiliarCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cheque_auxiliarCuentaBanco() {
		return this.resaltarnumero_cheque_auxiliarCuentaBanco;
	}

	public void setResaltarnumero_cheque_auxiliarCuentaBanco(Border borderResaltar) {
		this.resaltarnumero_cheque_auxiliarCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarnumero_cheque_auxiliarCuentaBanco() {
		return this.mostrarnumero_cheque_auxiliarCuentaBanco;
	}

	public void setMostrarnumero_cheque_auxiliarCuentaBanco(Boolean mostrarnumero_cheque_auxiliarCuentaBanco) {
		this.mostrarnumero_cheque_auxiliarCuentaBanco= mostrarnumero_cheque_auxiliarCuentaBanco;
	}

	public Boolean getActivarnumero_cheque_auxiliarCuentaBanco() {
		return this.activarnumero_cheque_auxiliarCuentaBanco;
	}

	public void setActivarnumero_cheque_auxiliarCuentaBanco(Boolean activarnumero_cheque_auxiliarCuentaBanco) {
		this.activarnumero_cheque_auxiliarCuentaBanco= activarnumero_cheque_auxiliarCuentaBanco;
	}

	public Border setResaltarsaldoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarsaldoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoCuentaBanco() {
		return this.resaltarsaldoCuentaBanco;
	}

	public void setResaltarsaldoCuentaBanco(Border borderResaltar) {
		this.resaltarsaldoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarsaldoCuentaBanco() {
		return this.mostrarsaldoCuentaBanco;
	}

	public void setMostrarsaldoCuentaBanco(Boolean mostrarsaldoCuentaBanco) {
		this.mostrarsaldoCuentaBanco= mostrarsaldoCuentaBanco;
	}

	public Boolean getActivarsaldoCuentaBanco() {
		return this.activarsaldoCuentaBanco;
	}

	public void setActivarsaldoCuentaBanco(Boolean activarsaldoCuentaBanco) {
		this.activarsaldoCuentaBanco= activarsaldoCuentaBanco;
	}

	public Border setResaltarprocedenciaCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarprocedenciaCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprocedenciaCuentaBanco() {
		return this.resaltarprocedenciaCuentaBanco;
	}

	public void setResaltarprocedenciaCuentaBanco(Border borderResaltar) {
		this.resaltarprocedenciaCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarprocedenciaCuentaBanco() {
		return this.mostrarprocedenciaCuentaBanco;
	}

	public void setMostrarprocedenciaCuentaBanco(Boolean mostrarprocedenciaCuentaBanco) {
		this.mostrarprocedenciaCuentaBanco= mostrarprocedenciaCuentaBanco;
	}

	public Boolean getActivarprocedenciaCuentaBanco() {
		return this.activarprocedenciaCuentaBanco;
	}

	public void setActivarprocedenciaCuentaBanco(Boolean activarprocedenciaCuentaBanco) {
		this.activarprocedenciaCuentaBanco= activarprocedenciaCuentaBanco;
	}

	public Border setResaltardestinoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltardestinoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardestinoCuentaBanco() {
		return this.resaltardestinoCuentaBanco;
	}

	public void setResaltardestinoCuentaBanco(Border borderResaltar) {
		this.resaltardestinoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrardestinoCuentaBanco() {
		return this.mostrardestinoCuentaBanco;
	}

	public void setMostrardestinoCuentaBanco(Boolean mostrardestinoCuentaBanco) {
		this.mostrardestinoCuentaBanco= mostrardestinoCuentaBanco;
	}

	public Boolean getActivardestinoCuentaBanco() {
		return this.activardestinoCuentaBanco;
	}

	public void setActivardestinoCuentaBanco(Boolean activardestinoCuentaBanco) {
		this.activardestinoCuentaBanco= activardestinoCuentaBanco;
	}

	public Border setResaltarid_cuenta_contableCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableCuentaBanco() {
		return this.resaltarid_cuenta_contableCuentaBanco;
	}

	public void setResaltarid_cuenta_contableCuentaBanco(Border borderResaltar) {
		this.resaltarid_cuenta_contableCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableCuentaBanco() {
		return this.mostrarid_cuenta_contableCuentaBanco;
	}

	public void setMostrarid_cuenta_contableCuentaBanco(Boolean mostrarid_cuenta_contableCuentaBanco) {
		this.mostrarid_cuenta_contableCuentaBanco= mostrarid_cuenta_contableCuentaBanco;
	}

	public Boolean getActivarid_cuenta_contableCuentaBanco() {
		return this.activarid_cuenta_contableCuentaBanco;
	}

	public void setActivarid_cuenta_contableCuentaBanco(Boolean activarid_cuenta_contableCuentaBanco) {
		this.activarid_cuenta_contableCuentaBanco= activarid_cuenta_contableCuentaBanco;
	}

	public Boolean getCargarid_cuenta_contableCuentaBanco() {
		return this.cargarid_cuenta_contableCuentaBanco;
	}

	public void setCargarid_cuenta_contableCuentaBanco(Boolean cargarid_cuenta_contableCuentaBanco) {
		this.cargarid_cuenta_contableCuentaBanco= cargarid_cuenta_contableCuentaBanco;
	}

	public Border setResaltares_bancoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltares_bancoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_bancoCuentaBanco() {
		return this.resaltares_bancoCuentaBanco;
	}

	public void setResaltares_bancoCuentaBanco(Border borderResaltar) {
		this.resaltares_bancoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrares_bancoCuentaBanco() {
		return this.mostrares_bancoCuentaBanco;
	}

	public void setMostrares_bancoCuentaBanco(Boolean mostrares_bancoCuentaBanco) {
		this.mostrares_bancoCuentaBanco= mostrares_bancoCuentaBanco;
	}

	public Boolean getActivares_bancoCuentaBanco() {
		return this.activares_bancoCuentaBanco;
	}

	public void setActivares_bancoCuentaBanco(Boolean activares_bancoCuentaBanco) {
		this.activares_bancoCuentaBanco= activares_bancoCuentaBanco;
	}

	public Border setResaltarid_estado_cuenta_bancoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_estado_cuenta_bancoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_cuenta_bancoCuentaBanco() {
		return this.resaltarid_estado_cuenta_bancoCuentaBanco;
	}

	public void setResaltarid_estado_cuenta_bancoCuentaBanco(Border borderResaltar) {
		this.resaltarid_estado_cuenta_bancoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_estado_cuenta_bancoCuentaBanco() {
		return this.mostrarid_estado_cuenta_bancoCuentaBanco;
	}

	public void setMostrarid_estado_cuenta_bancoCuentaBanco(Boolean mostrarid_estado_cuenta_bancoCuentaBanco) {
		this.mostrarid_estado_cuenta_bancoCuentaBanco= mostrarid_estado_cuenta_bancoCuentaBanco;
	}

	public Boolean getActivarid_estado_cuenta_bancoCuentaBanco() {
		return this.activarid_estado_cuenta_bancoCuentaBanco;
	}

	public void setActivarid_estado_cuenta_bancoCuentaBanco(Boolean activarid_estado_cuenta_bancoCuentaBanco) {
		this.activarid_estado_cuenta_bancoCuentaBanco= activarid_estado_cuenta_bancoCuentaBanco;
	}

	public Boolean getCargarid_estado_cuenta_bancoCuentaBanco() {
		return this.cargarid_estado_cuenta_bancoCuentaBanco;
	}

	public void setCargarid_estado_cuenta_bancoCuentaBanco(Boolean cargarid_estado_cuenta_bancoCuentaBanco) {
		this.cargarid_estado_cuenta_bancoCuentaBanco= cargarid_estado_cuenta_bancoCuentaBanco;
	}

	public Border setResaltarid_formato_ingresoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_formato_ingresoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_ingresoCuentaBanco() {
		return this.resaltarid_formato_ingresoCuentaBanco;
	}

	public void setResaltarid_formato_ingresoCuentaBanco(Border borderResaltar) {
		this.resaltarid_formato_ingresoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_formato_ingresoCuentaBanco() {
		return this.mostrarid_formato_ingresoCuentaBanco;
	}

	public void setMostrarid_formato_ingresoCuentaBanco(Boolean mostrarid_formato_ingresoCuentaBanco) {
		this.mostrarid_formato_ingresoCuentaBanco= mostrarid_formato_ingresoCuentaBanco;
	}

	public Boolean getActivarid_formato_ingresoCuentaBanco() {
		return this.activarid_formato_ingresoCuentaBanco;
	}

	public void setActivarid_formato_ingresoCuentaBanco(Boolean activarid_formato_ingresoCuentaBanco) {
		this.activarid_formato_ingresoCuentaBanco= activarid_formato_ingresoCuentaBanco;
	}

	public Boolean getCargarid_formato_ingresoCuentaBanco() {
		return this.cargarid_formato_ingresoCuentaBanco;
	}

	public void setCargarid_formato_ingresoCuentaBanco(Boolean cargarid_formato_ingresoCuentaBanco) {
		this.cargarid_formato_ingresoCuentaBanco= cargarid_formato_ingresoCuentaBanco;
	}

	public Border setResaltarid_formato_egresoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_formato_egresoCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_egresoCuentaBanco() {
		return this.resaltarid_formato_egresoCuentaBanco;
	}

	public void setResaltarid_formato_egresoCuentaBanco(Border borderResaltar) {
		this.resaltarid_formato_egresoCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_formato_egresoCuentaBanco() {
		return this.mostrarid_formato_egresoCuentaBanco;
	}

	public void setMostrarid_formato_egresoCuentaBanco(Boolean mostrarid_formato_egresoCuentaBanco) {
		this.mostrarid_formato_egresoCuentaBanco= mostrarid_formato_egresoCuentaBanco;
	}

	public Boolean getActivarid_formato_egresoCuentaBanco() {
		return this.activarid_formato_egresoCuentaBanco;
	}

	public void setActivarid_formato_egresoCuentaBanco(Boolean activarid_formato_egresoCuentaBanco) {
		this.activarid_formato_egresoCuentaBanco= activarid_formato_egresoCuentaBanco;
	}

	public Boolean getCargarid_formato_egresoCuentaBanco() {
		return this.cargarid_formato_egresoCuentaBanco;
	}

	public void setCargarid_formato_egresoCuentaBanco(Boolean cargarid_formato_egresoCuentaBanco) {
		this.cargarid_formato_egresoCuentaBanco= cargarid_formato_egresoCuentaBanco;
	}

	public Border setResaltarid_formato_diarioCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_formato_diarioCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_diarioCuentaBanco() {
		return this.resaltarid_formato_diarioCuentaBanco;
	}

	public void setResaltarid_formato_diarioCuentaBanco(Border borderResaltar) {
		this.resaltarid_formato_diarioCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_formato_diarioCuentaBanco() {
		return this.mostrarid_formato_diarioCuentaBanco;
	}

	public void setMostrarid_formato_diarioCuentaBanco(Boolean mostrarid_formato_diarioCuentaBanco) {
		this.mostrarid_formato_diarioCuentaBanco= mostrarid_formato_diarioCuentaBanco;
	}

	public Boolean getActivarid_formato_diarioCuentaBanco() {
		return this.activarid_formato_diarioCuentaBanco;
	}

	public void setActivarid_formato_diarioCuentaBanco(Boolean activarid_formato_diarioCuentaBanco) {
		this.activarid_formato_diarioCuentaBanco= activarid_formato_diarioCuentaBanco;
	}

	public Boolean getCargarid_formato_diarioCuentaBanco() {
		return this.cargarid_formato_diarioCuentaBanco;
	}

	public void setCargarid_formato_diarioCuentaBanco(Boolean cargarid_formato_diarioCuentaBanco) {
		this.cargarid_formato_diarioCuentaBanco= cargarid_formato_diarioCuentaBanco;
	}

	public Border setResaltarid_formato_chequeCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_formato_chequeCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_chequeCuentaBanco() {
		return this.resaltarid_formato_chequeCuentaBanco;
	}

	public void setResaltarid_formato_chequeCuentaBanco(Border borderResaltar) {
		this.resaltarid_formato_chequeCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_formato_chequeCuentaBanco() {
		return this.mostrarid_formato_chequeCuentaBanco;
	}

	public void setMostrarid_formato_chequeCuentaBanco(Boolean mostrarid_formato_chequeCuentaBanco) {
		this.mostrarid_formato_chequeCuentaBanco= mostrarid_formato_chequeCuentaBanco;
	}

	public Boolean getActivarid_formato_chequeCuentaBanco() {
		return this.activarid_formato_chequeCuentaBanco;
	}

	public void setActivarid_formato_chequeCuentaBanco(Boolean activarid_formato_chequeCuentaBanco) {
		this.activarid_formato_chequeCuentaBanco= activarid_formato_chequeCuentaBanco;
	}

	public Boolean getCargarid_formato_chequeCuentaBanco() {
		return this.cargarid_formato_chequeCuentaBanco;
	}

	public void setCargarid_formato_chequeCuentaBanco(Boolean cargarid_formato_chequeCuentaBanco) {
		this.cargarid_formato_chequeCuentaBanco= cargarid_formato_chequeCuentaBanco;
	}

	public Border setResaltarid_formato_retencionCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_formato_retencionCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_retencionCuentaBanco() {
		return this.resaltarid_formato_retencionCuentaBanco;
	}

	public void setResaltarid_formato_retencionCuentaBanco(Border borderResaltar) {
		this.resaltarid_formato_retencionCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_formato_retencionCuentaBanco() {
		return this.mostrarid_formato_retencionCuentaBanco;
	}

	public void setMostrarid_formato_retencionCuentaBanco(Boolean mostrarid_formato_retencionCuentaBanco) {
		this.mostrarid_formato_retencionCuentaBanco= mostrarid_formato_retencionCuentaBanco;
	}

	public Boolean getActivarid_formato_retencionCuentaBanco() {
		return this.activarid_formato_retencionCuentaBanco;
	}

	public void setActivarid_formato_retencionCuentaBanco(Boolean activarid_formato_retencionCuentaBanco) {
		this.activarid_formato_retencionCuentaBanco= activarid_formato_retencionCuentaBanco;
	}

	public Boolean getCargarid_formato_retencionCuentaBanco() {
		return this.cargarid_formato_retencionCuentaBanco;
	}

	public void setCargarid_formato_retencionCuentaBanco(Boolean cargarid_formato_retencionCuentaBanco) {
		this.cargarid_formato_retencionCuentaBanco= cargarid_formato_retencionCuentaBanco;
	}

	public Border setResaltarid_formato_retencion_ivaCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltar);
		
		this.resaltarid_formato_retencion_ivaCuentaBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formato_retencion_ivaCuentaBanco() {
		return this.resaltarid_formato_retencion_ivaCuentaBanco;
	}

	public void setResaltarid_formato_retencion_ivaCuentaBanco(Border borderResaltar) {
		this.resaltarid_formato_retencion_ivaCuentaBanco= borderResaltar;
	}

	public Boolean getMostrarid_formato_retencion_ivaCuentaBanco() {
		return this.mostrarid_formato_retencion_ivaCuentaBanco;
	}

	public void setMostrarid_formato_retencion_ivaCuentaBanco(Boolean mostrarid_formato_retencion_ivaCuentaBanco) {
		this.mostrarid_formato_retencion_ivaCuentaBanco= mostrarid_formato_retencion_ivaCuentaBanco;
	}

	public Boolean getActivarid_formato_retencion_ivaCuentaBanco() {
		return this.activarid_formato_retencion_ivaCuentaBanco;
	}

	public void setActivarid_formato_retencion_ivaCuentaBanco(Boolean activarid_formato_retencion_ivaCuentaBanco) {
		this.activarid_formato_retencion_ivaCuentaBanco= activarid_formato_retencion_ivaCuentaBanco;
	}

	public Boolean getCargarid_formato_retencion_ivaCuentaBanco() {
		return this.cargarid_formato_retencion_ivaCuentaBanco;
	}

	public void setCargarid_formato_retencion_ivaCuentaBanco(Boolean cargarid_formato_retencion_ivaCuentaBanco) {
		this.cargarid_formato_retencion_ivaCuentaBanco= cargarid_formato_retencion_ivaCuentaBanco;
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
		
		
		this.setMostraridCuentaBanco(esInicial);
		this.setMostrarid_empresaCuentaBanco(esInicial);
		this.setMostrarid_sucursalCuentaBanco(esInicial);
		this.setMostrarid_bancoCuentaBanco(esInicial);
		this.setMostrarid_tipo_cuenta_banco_globalCuentaBanco(esInicial);
		this.setMostrarcodigoCuentaBanco(esInicial);
		this.setMostrarnumero_cuentaCuentaBanco(esInicial);
		this.setMostrarnumero_chequeCuentaBanco(esInicial);
		this.setMostrarnumero_cheque_auxiliarCuentaBanco(esInicial);
		this.setMostrarsaldoCuentaBanco(esInicial);
		this.setMostrarprocedenciaCuentaBanco(esInicial);
		this.setMostrardestinoCuentaBanco(esInicial);
		this.setMostrarid_cuenta_contableCuentaBanco(esInicial);
		this.setMostrares_bancoCuentaBanco(esInicial);
		this.setMostrarid_estado_cuenta_bancoCuentaBanco(esInicial);
		this.setMostrarid_formato_ingresoCuentaBanco(esInicial);
		this.setMostrarid_formato_egresoCuentaBanco(esInicial);
		this.setMostrarid_formato_diarioCuentaBanco(esInicial);
		this.setMostrarid_formato_chequeCuentaBanco(esInicial);
		this.setMostrarid_formato_retencionCuentaBanco(esInicial);
		this.setMostrarid_formato_retencion_ivaCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaBancoConstantesFunciones.ID)) {
				this.setMostraridCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setMostrarid_tipo_cuenta_banco_globalCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCHEQUE)) {
				this.setMostrarnumero_chequeCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR)) {
				this.setMostrarnumero_cheque_auxiliarCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.SALDO)) {
				this.setMostrarsaldoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.PROCEDENCIA)) {
				this.setMostrarprocedenciaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.DESTINO)) {
				this.setMostrardestinoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.ESBANCO)) {
				this.setMostrares_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO)) {
				this.setMostrarid_estado_cuenta_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOINGRESO)) {
				this.setMostrarid_formato_ingresoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOEGRESO)) {
				this.setMostrarid_formato_egresoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATODIARIO)) {
				this.setMostrarid_formato_diarioCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOCHEQUE)) {
				this.setMostrarid_formato_chequeCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATORETENCION)) {
				this.setMostrarid_formato_retencionCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA)) {
				this.setMostrarid_formato_retencion_ivaCuentaBanco(esAsigna);
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
		
		
		this.setActivaridCuentaBanco(esInicial);
		this.setActivarid_empresaCuentaBanco(esInicial);
		this.setActivarid_sucursalCuentaBanco(esInicial);
		this.setActivarid_bancoCuentaBanco(esInicial);
		this.setActivarid_tipo_cuenta_banco_globalCuentaBanco(esInicial);
		this.setActivarcodigoCuentaBanco(esInicial);
		this.setActivarnumero_cuentaCuentaBanco(esInicial);
		this.setActivarnumero_chequeCuentaBanco(esInicial);
		this.setActivarnumero_cheque_auxiliarCuentaBanco(esInicial);
		this.setActivarsaldoCuentaBanco(esInicial);
		this.setActivarprocedenciaCuentaBanco(esInicial);
		this.setActivardestinoCuentaBanco(esInicial);
		this.setActivarid_cuenta_contableCuentaBanco(esInicial);
		this.setActivares_bancoCuentaBanco(esInicial);
		this.setActivarid_estado_cuenta_bancoCuentaBanco(esInicial);
		this.setActivarid_formato_ingresoCuentaBanco(esInicial);
		this.setActivarid_formato_egresoCuentaBanco(esInicial);
		this.setActivarid_formato_diarioCuentaBanco(esInicial);
		this.setActivarid_formato_chequeCuentaBanco(esInicial);
		this.setActivarid_formato_retencionCuentaBanco(esInicial);
		this.setActivarid_formato_retencion_ivaCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaBancoConstantesFunciones.ID)) {
				this.setActivaridCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setActivarid_tipo_cuenta_banco_globalCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCHEQUE)) {
				this.setActivarnumero_chequeCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR)) {
				this.setActivarnumero_cheque_auxiliarCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.SALDO)) {
				this.setActivarsaldoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.PROCEDENCIA)) {
				this.setActivarprocedenciaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.DESTINO)) {
				this.setActivardestinoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.ESBANCO)) {
				this.setActivares_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO)) {
				this.setActivarid_estado_cuenta_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOINGRESO)) {
				this.setActivarid_formato_ingresoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOEGRESO)) {
				this.setActivarid_formato_egresoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATODIARIO)) {
				this.setActivarid_formato_diarioCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOCHEQUE)) {
				this.setActivarid_formato_chequeCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATORETENCION)) {
				this.setActivarid_formato_retencionCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA)) {
				this.setActivarid_formato_retencion_ivaCuentaBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCuentaBanco(esInicial);
		this.setResaltarid_empresaCuentaBanco(esInicial);
		this.setResaltarid_sucursalCuentaBanco(esInicial);
		this.setResaltarid_bancoCuentaBanco(esInicial);
		this.setResaltarid_tipo_cuenta_banco_globalCuentaBanco(esInicial);
		this.setResaltarcodigoCuentaBanco(esInicial);
		this.setResaltarnumero_cuentaCuentaBanco(esInicial);
		this.setResaltarnumero_chequeCuentaBanco(esInicial);
		this.setResaltarnumero_cheque_auxiliarCuentaBanco(esInicial);
		this.setResaltarsaldoCuentaBanco(esInicial);
		this.setResaltarprocedenciaCuentaBanco(esInicial);
		this.setResaltardestinoCuentaBanco(esInicial);
		this.setResaltarid_cuenta_contableCuentaBanco(esInicial);
		this.setResaltares_bancoCuentaBanco(esInicial);
		this.setResaltarid_estado_cuenta_bancoCuentaBanco(esInicial);
		this.setResaltarid_formato_ingresoCuentaBanco(esInicial);
		this.setResaltarid_formato_egresoCuentaBanco(esInicial);
		this.setResaltarid_formato_diarioCuentaBanco(esInicial);
		this.setResaltarid_formato_chequeCuentaBanco(esInicial);
		this.setResaltarid_formato_retencionCuentaBanco(esInicial);
		this.setResaltarid_formato_retencion_ivaCuentaBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CuentaBancoConstantesFunciones.ID)) {
				this.setResaltaridCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setResaltarid_tipo_cuenta_banco_globalCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCHEQUE)) {
				this.setResaltarnumero_chequeCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR)) {
				this.setResaltarnumero_cheque_auxiliarCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.SALDO)) {
				this.setResaltarsaldoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.PROCEDENCIA)) {
				this.setResaltarprocedenciaCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.DESTINO)) {
				this.setResaltardestinoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.ESBANCO)) {
				this.setResaltares_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO)) {
				this.setResaltarid_estado_cuenta_bancoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOINGRESO)) {
				this.setResaltarid_formato_ingresoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOEGRESO)) {
				this.setResaltarid_formato_egresoCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATODIARIO)) {
				this.setResaltarid_formato_diarioCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATOCHEQUE)) {
				this.setResaltarid_formato_chequeCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATORETENCION)) {
				this.setResaltarid_formato_retencionCuentaBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA)) {
				this.setResaltarid_formato_retencion_ivaCuentaBanco(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPagoAutoCuentaBanco=null;

	public Border getResaltarPagoAutoCuentaBanco() {
		return this.resaltarPagoAutoCuentaBanco;
	}

	public void setResaltarPagoAutoCuentaBanco(Border borderResaltarPagoAuto) {
		if(borderResaltarPagoAuto!=null) {
			this.resaltarPagoAutoCuentaBanco= borderResaltarPagoAuto;
		}
	}

	public Border setResaltarPagoAutoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltarPagoAuto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltarPagoAuto);
			
		this.resaltarPagoAutoCuentaBanco= borderResaltarPagoAuto;

		 return borderResaltarPagoAuto;
	}



	public Boolean mostrarPagoAutoCuentaBanco=true;

	public Boolean getMostrarPagoAutoCuentaBanco() {
		return this.mostrarPagoAutoCuentaBanco;
	}

	public void setMostrarPagoAutoCuentaBanco(Boolean visibilidadResaltarPagoAuto) {
		this.mostrarPagoAutoCuentaBanco= visibilidadResaltarPagoAuto;
	}



	public Boolean activarPagoAutoCuentaBanco=true;

	public Boolean gethabilitarResaltarPagoAutoCuentaBanco() {
		return this.activarPagoAutoCuentaBanco;
	}

	public void setActivarPagoAutoCuentaBanco(Boolean habilitarResaltarPagoAuto) {
		this.activarPagoAutoCuentaBanco= habilitarResaltarPagoAuto;
	}


	public Border resaltarAutoriPagoOrdenCompraCuentaBanco=null;

	public Border getResaltarAutoriPagoOrdenCompraCuentaBanco() {
		return this.resaltarAutoriPagoOrdenCompraCuentaBanco;
	}

	public void setResaltarAutoriPagoOrdenCompraCuentaBanco(Border borderResaltarAutoriPagoOrdenCompra) {
		if(borderResaltarAutoriPagoOrdenCompra!=null) {
			this.resaltarAutoriPagoOrdenCompraCuentaBanco= borderResaltarAutoriPagoOrdenCompra;
		}
	}

	public Border setResaltarAutoriPagoOrdenCompraCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltarAutoriPagoOrdenCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltarAutoriPagoOrdenCompra);
			
		this.resaltarAutoriPagoOrdenCompraCuentaBanco= borderResaltarAutoriPagoOrdenCompra;

		 return borderResaltarAutoriPagoOrdenCompra;
	}



	public Boolean mostrarAutoriPagoOrdenCompraCuentaBanco=true;

	public Boolean getMostrarAutoriPagoOrdenCompraCuentaBanco() {
		return this.mostrarAutoriPagoOrdenCompraCuentaBanco;
	}

	public void setMostrarAutoriPagoOrdenCompraCuentaBanco(Boolean visibilidadResaltarAutoriPagoOrdenCompra) {
		this.mostrarAutoriPagoOrdenCompraCuentaBanco= visibilidadResaltarAutoriPagoOrdenCompra;
	}



	public Boolean activarAutoriPagoOrdenCompraCuentaBanco=true;

	public Boolean gethabilitarResaltarAutoriPagoOrdenCompraCuentaBanco() {
		return this.activarAutoriPagoOrdenCompraCuentaBanco;
	}

	public void setActivarAutoriPagoOrdenCompraCuentaBanco(Boolean habilitarResaltarAutoriPagoOrdenCompra) {
		this.activarAutoriPagoOrdenCompraCuentaBanco= habilitarResaltarAutoriPagoOrdenCompra;
	}


	public Border resaltarDetalleChequeGiradoCuentaBanco=null;

	public Border getResaltarDetalleChequeGiradoCuentaBanco() {
		return this.resaltarDetalleChequeGiradoCuentaBanco;
	}

	public void setResaltarDetalleChequeGiradoCuentaBanco(Border borderResaltarDetalleChequeGirado) {
		if(borderResaltarDetalleChequeGirado!=null) {
			this.resaltarDetalleChequeGiradoCuentaBanco= borderResaltarDetalleChequeGirado;
		}
	}

	public Border setResaltarDetalleChequeGiradoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleChequeGirado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltarDetalleChequeGirado);
			
		this.resaltarDetalleChequeGiradoCuentaBanco= borderResaltarDetalleChequeGirado;

		 return borderResaltarDetalleChequeGirado;
	}



	public Boolean mostrarDetalleChequeGiradoCuentaBanco=true;

	public Boolean getMostrarDetalleChequeGiradoCuentaBanco() {
		return this.mostrarDetalleChequeGiradoCuentaBanco;
	}

	public void setMostrarDetalleChequeGiradoCuentaBanco(Boolean visibilidadResaltarDetalleChequeGirado) {
		this.mostrarDetalleChequeGiradoCuentaBanco= visibilidadResaltarDetalleChequeGirado;
	}



	public Boolean activarDetalleChequeGiradoCuentaBanco=true;

	public Boolean gethabilitarResaltarDetalleChequeGiradoCuentaBanco() {
		return this.activarDetalleChequeGiradoCuentaBanco;
	}

	public void setActivarDetalleChequeGiradoCuentaBanco(Boolean habilitarResaltarDetalleChequeGirado) {
		this.activarDetalleChequeGiradoCuentaBanco= habilitarResaltarDetalleChequeGirado;
	}


	public Border resaltarAutoriPagoCuentaBanco=null;

	public Border getResaltarAutoriPagoCuentaBanco() {
		return this.resaltarAutoriPagoCuentaBanco;
	}

	public void setResaltarAutoriPagoCuentaBanco(Border borderResaltarAutoriPago) {
		if(borderResaltarAutoriPago!=null) {
			this.resaltarAutoriPagoCuentaBanco= borderResaltarAutoriPago;
		}
	}

	public Border setResaltarAutoriPagoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltarAutoriPago=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cuentabancoBeanSwingJInternalFrame.jTtoolBarCuentaBanco.setBorder(borderResaltarAutoriPago);
			
		this.resaltarAutoriPagoCuentaBanco= borderResaltarAutoriPago;

		 return borderResaltarAutoriPago;
	}



	public Boolean mostrarAutoriPagoCuentaBanco=true;

	public Boolean getMostrarAutoriPagoCuentaBanco() {
		return this.mostrarAutoriPagoCuentaBanco;
	}

	public void setMostrarAutoriPagoCuentaBanco(Boolean visibilidadResaltarAutoriPago) {
		this.mostrarAutoriPagoCuentaBanco= visibilidadResaltarAutoriPago;
	}



	public Boolean activarAutoriPagoCuentaBanco=true;

	public Boolean gethabilitarResaltarAutoriPagoCuentaBanco() {
		return this.activarAutoriPagoCuentaBanco;
	}

	public void setActivarAutoriPagoCuentaBanco(Boolean habilitarResaltarAutoriPago) {
		this.activarAutoriPagoCuentaBanco= habilitarResaltarAutoriPago;
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

		this.setMostrarPagoAutoCuentaBanco(esInicial);
		this.setMostrarAutoriPagoOrdenCompraCuentaBanco(esInicial);
		this.setMostrarDetalleChequeGiradoCuentaBanco(esInicial);
		this.setMostrarAutoriPagoCuentaBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setMostrarPagoAutoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPagoOrdenCompra.class)) {
				this.setMostrarAutoriPagoOrdenCompraCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleChequeGirado.class)) {
				this.setMostrarDetalleChequeGiradoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setMostrarAutoriPagoCuentaBanco(esAsigna);
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

		this.setActivarPagoAutoCuentaBanco(esInicial);
		this.setActivarAutoriPagoOrdenCompraCuentaBanco(esInicial);
		this.setActivarDetalleChequeGiradoCuentaBanco(esInicial);
		this.setActivarAutoriPagoCuentaBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setActivarPagoAutoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPagoOrdenCompra.class)) {
				this.setActivarAutoriPagoOrdenCompraCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleChequeGirado.class)) {
				this.setActivarDetalleChequeGiradoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setActivarAutoriPagoCuentaBanco(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPagoAutoCuentaBanco(esInicial);
		this.setResaltarAutoriPagoOrdenCompraCuentaBanco(esInicial);
		this.setResaltarDetalleChequeGiradoCuentaBanco(esInicial);
		this.setResaltarAutoriPagoCuentaBanco(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PagoAuto.class)) {
				this.setResaltarPagoAutoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPagoOrdenCompra.class)) {
				this.setResaltarAutoriPagoOrdenCompraCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetalleChequeGirado.class)) {
				this.setResaltarDetalleChequeGiradoCuentaBanco(esAsigna);
				continue;
			}

			if(clase.clas.equals(AutoriPago.class)) {
				this.setResaltarAutoriPagoCuentaBanco(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorCodigoCuentaBanco=true;

	public Boolean getMostrarBusquedaPorCodigoCuentaBanco() {
		return this.mostrarBusquedaPorCodigoCuentaBanco;
	}

	public void setMostrarBusquedaPorCodigoCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoCuentaBanco= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNumeroChequeCuentaBanco=true;

	public Boolean getMostrarBusquedaPorNumeroChequeCuentaBanco() {
		return this.mostrarBusquedaPorNumeroChequeCuentaBanco;
	}

	public void setMostrarBusquedaPorNumeroChequeCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroChequeCuentaBanco= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNumeroCuentaCuentaBanco=true;

	public Boolean getMostrarBusquedaPorNumeroCuentaCuentaBanco() {
		return this.mostrarBusquedaPorNumeroCuentaCuentaBanco;
	}

	public void setMostrarBusquedaPorNumeroCuentaCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNumeroCuentaCuentaBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBancoCuentaBanco=true;

	public Boolean getMostrarFK_IdBancoCuentaBanco() {
		return this.mostrarFK_IdBancoCuentaBanco;
	}

	public void setMostrarFK_IdBancoCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoCuentaBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCuentaBanco=true;

	public Boolean getMostrarFK_IdEmpresaCuentaBanco() {
		return this.mostrarFK_IdEmpresaCuentaBanco;
	}

	public void setMostrarFK_IdEmpresaCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCuentaBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoCuentaBancoCuentaBanco=true;

	public Boolean getMostrarFK_IdEstadoCuentaBancoCuentaBanco() {
		return this.mostrarFK_IdEstadoCuentaBancoCuentaBanco;
	}

	public void setMostrarFK_IdEstadoCuentaBancoCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoCuentaBancoCuentaBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCuentaBanco=true;

	public Boolean getMostrarFK_IdSucursalCuentaBanco() {
		return this.mostrarFK_IdSucursalCuentaBanco;
	}

	public void setMostrarFK_IdSucursalCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCuentaBanco= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaBancoGlobalCuentaBanco=true;

	public Boolean getMostrarFK_IdTipoCuentaBancoGlobalCuentaBanco() {
		return this.mostrarFK_IdTipoCuentaBancoGlobalCuentaBanco;
	}

	public void setMostrarFK_IdTipoCuentaBancoGlobalCuentaBanco(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaBancoGlobalCuentaBanco= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoCuentaBanco=true;

	public Boolean getActivarBusquedaPorCodigoCuentaBanco() {
		return this.activarBusquedaPorCodigoCuentaBanco;
	}

	public void setActivarBusquedaPorCodigoCuentaBanco(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoCuentaBanco= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNumeroChequeCuentaBanco=true;

	public Boolean getActivarBusquedaPorNumeroChequeCuentaBanco() {
		return this.activarBusquedaPorNumeroChequeCuentaBanco;
	}

	public void setActivarBusquedaPorNumeroChequeCuentaBanco(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroChequeCuentaBanco= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNumeroCuentaCuentaBanco=true;

	public Boolean getActivarBusquedaPorNumeroCuentaCuentaBanco() {
		return this.activarBusquedaPorNumeroCuentaCuentaBanco;
	}

	public void setActivarBusquedaPorNumeroCuentaCuentaBanco(Boolean habilitarResaltar) {
		this.activarBusquedaPorNumeroCuentaCuentaBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdBancoCuentaBanco=true;

	public Boolean getActivarFK_IdBancoCuentaBanco() {
		return this.activarFK_IdBancoCuentaBanco;
	}

	public void setActivarFK_IdBancoCuentaBanco(Boolean habilitarResaltar) {
		this.activarFK_IdBancoCuentaBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCuentaBanco=true;

	public Boolean getActivarFK_IdEmpresaCuentaBanco() {
		return this.activarFK_IdEmpresaCuentaBanco;
	}

	public void setActivarFK_IdEmpresaCuentaBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCuentaBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoCuentaBancoCuentaBanco=true;

	public Boolean getActivarFK_IdEstadoCuentaBancoCuentaBanco() {
		return this.activarFK_IdEstadoCuentaBancoCuentaBanco;
	}

	public void setActivarFK_IdEstadoCuentaBancoCuentaBanco(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoCuentaBancoCuentaBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCuentaBanco=true;

	public Boolean getActivarFK_IdSucursalCuentaBanco() {
		return this.activarFK_IdSucursalCuentaBanco;
	}

	public void setActivarFK_IdSucursalCuentaBanco(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCuentaBanco= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaBancoGlobalCuentaBanco=true;

	public Boolean getActivarFK_IdTipoCuentaBancoGlobalCuentaBanco() {
		return this.activarFK_IdTipoCuentaBancoGlobalCuentaBanco;
	}

	public void setActivarFK_IdTipoCuentaBancoGlobalCuentaBanco(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaBancoGlobalCuentaBanco= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoCuentaBanco=null;

	public Border getResaltarBusquedaPorCodigoCuentaBanco() {
		return this.resaltarBusquedaPorCodigoCuentaBanco;
	}

	public void setResaltarBusquedaPorCodigoCuentaBanco(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoCuentaBanco= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoCuentaBanco= borderResaltar;
	}

	public Border resaltarBusquedaPorNumeroChequeCuentaBanco=null;

	public Border getResaltarBusquedaPorNumeroChequeCuentaBanco() {
		return this.resaltarBusquedaPorNumeroChequeCuentaBanco;
	}

	public void setResaltarBusquedaPorNumeroChequeCuentaBanco(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroChequeCuentaBanco= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroChequeCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroChequeCuentaBanco= borderResaltar;
	}

	public Border resaltarBusquedaPorNumeroCuentaCuentaBanco=null;

	public Border getResaltarBusquedaPorNumeroCuentaCuentaBanco() {
		return this.resaltarBusquedaPorNumeroCuentaCuentaBanco;
	}

	public void setResaltarBusquedaPorNumeroCuentaCuentaBanco(Border borderResaltar) {
		this.resaltarBusquedaPorNumeroCuentaCuentaBanco= borderResaltar;
	}

	public void setResaltarBusquedaPorNumeroCuentaCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNumeroCuentaCuentaBanco= borderResaltar;
	}

	public Border resaltarFK_IdBancoCuentaBanco=null;

	public Border getResaltarFK_IdBancoCuentaBanco() {
		return this.resaltarFK_IdBancoCuentaBanco;
	}

	public void setResaltarFK_IdBancoCuentaBanco(Border borderResaltar) {
		this.resaltarFK_IdBancoCuentaBanco= borderResaltar;
	}

	public void setResaltarFK_IdBancoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoCuentaBanco= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCuentaBanco=null;

	public Border getResaltarFK_IdEmpresaCuentaBanco() {
		return this.resaltarFK_IdEmpresaCuentaBanco;
	}

	public void setResaltarFK_IdEmpresaCuentaBanco(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCuentaBanco= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCuentaBanco= borderResaltar;
	}

	public Border resaltarFK_IdEstadoCuentaBancoCuentaBanco=null;

	public Border getResaltarFK_IdEstadoCuentaBancoCuentaBanco() {
		return this.resaltarFK_IdEstadoCuentaBancoCuentaBanco;
	}

	public void setResaltarFK_IdEstadoCuentaBancoCuentaBanco(Border borderResaltar) {
		this.resaltarFK_IdEstadoCuentaBancoCuentaBanco= borderResaltar;
	}

	public void setResaltarFK_IdEstadoCuentaBancoCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoCuentaBancoCuentaBanco= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCuentaBanco=null;

	public Border getResaltarFK_IdSucursalCuentaBanco() {
		return this.resaltarFK_IdSucursalCuentaBanco;
	}

	public void setResaltarFK_IdSucursalCuentaBanco(Border borderResaltar) {
		this.resaltarFK_IdSucursalCuentaBanco= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCuentaBanco= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaBancoGlobalCuentaBanco=null;

	public Border getResaltarFK_IdTipoCuentaBancoGlobalCuentaBanco() {
		return this.resaltarFK_IdTipoCuentaBancoGlobalCuentaBanco;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalCuentaBanco(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaBancoGlobalCuentaBanco= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalCuentaBanco(ParametroGeneralUsuario parametroGeneralUsuario/*CuentaBancoBeanSwingJInternalFrame cuentabancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaBancoGlobalCuentaBanco= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}