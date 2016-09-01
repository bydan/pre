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


import com.bydan.erp.contabilidad.util.ParametroContaConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroContaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroContaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroContaConstantesFunciones extends ParametroContaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroConta";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroConta"+ParametroContaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroContaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroContaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroContaConstantesFunciones.SCHEMA+"_"+ParametroContaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroContaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroContaConstantesFunciones.SCHEMA+"_"+ParametroContaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroContaConstantesFunciones.SCHEMA+"_"+ParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroContaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroContaConstantesFunciones.SCHEMA+"_"+ParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroContaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroContaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroContaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroContaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroContaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroContaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroContaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Contabilidads";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Contabilidad";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Conta";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroConta";
	public static final String OBJECTNAME="parametroconta";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="parametro_conta";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametroconta from "+ParametroContaConstantesFunciones.SPERSISTENCENAME+" parametroconta";
	public static String QUERYSELECTNATIVE="select "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".version_row,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_empresa,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_moneda,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_moneda_extranjera,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_mascara,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".numero_nivel,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".es_presupuesto,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".es_lote,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_secuencial_automatico,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_cuentas_niff,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_centro_costo_mascara,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".con_centro_costo_nueva_estructura,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".centro_costo_numero_nivel,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_activo,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_pasivo,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_patrimonio,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_egreso,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_resumen,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_deudor,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_acreedor,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso1,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso2,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso3,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_egreso1,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_egreso2,"+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME+".id_cuenta_contable_egreso3 from "+ParametroContaConstantesFunciones.SCHEMA+"."+ParametroContaConstantesFunciones.TABLENAME;//+" as "+ParametroContaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroContaConstantesFuncionesAdditional parametrocontaConstantesFuncionesAdditional=null;
	
	public ParametroContaConstantesFuncionesAdditional getParametroContaConstantesFuncionesAdditional() {
		return this.parametrocontaConstantesFuncionesAdditional;
	}
	
	public void setParametroContaConstantesFuncionesAdditional(ParametroContaConstantesFuncionesAdditional parametrocontaConstantesFuncionesAdditional) {
		try {
			this.parametrocontaConstantesFuncionesAdditional=parametrocontaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDMONEDAEXTRANJERA= "id_moneda_extranjera";
    public static final String CONMASCARA= "con_mascara";
    public static final String NUMERONIVEL= "numero_nivel";
    public static final String ESPRESUPUESTO= "es_presupuesto";
    public static final String ESLOTE= "es_lote";
    public static final String CONSECUENCIALAUTOMATICO= "con_secuencial_automatico";
    public static final String CONCUENTASNIFF= "con_cuentas_niff";
    public static final String CONCENTROCOSTOMASCARA= "con_centro_costo_mascara";
    public static final String CONCENTROCOSTONUEVAESTRUCTURA= "con_centro_costo_nueva_estructura";
    public static final String CENTROCOSTONUMERONIVEL= "centro_costo_numero_nivel";
    public static final String IDCUENTACONTABLEACTIVO= "id_cuenta_contable_activo";
    public static final String IDCUENTACONTABLEPASIVO= "id_cuenta_contable_pasivo";
    public static final String IDCUENTACONTABLEPATRIMONIO= "id_cuenta_contable_patrimonio";
    public static final String IDCUENTACONTABLEINGRESO= "id_cuenta_contable_ingreso";
    public static final String IDCUENTACONTABLEEGRESO= "id_cuenta_contable_egreso";
    public static final String IDCUENTACONTABLERESUMEN= "id_cuenta_contable_resumen";
    public static final String IDCUENTACONTABLEDEUDOR= "id_cuenta_contable_deudor";
    public static final String IDCUENTACONTABLEACREEDOR= "id_cuenta_contable_acreedor";
    public static final String IDCUENTACONTABLEINGRESO1= "id_cuenta_contable_ingreso1";
    public static final String IDCUENTACONTABLEINGRESO2= "id_cuenta_contable_ingreso2";
    public static final String IDCUENTACONTABLEINGRESO3= "id_cuenta_contable_ingreso3";
    public static final String IDCUENTACONTABLEEGRESO1= "id_cuenta_contable_egreso1";
    public static final String IDCUENTACONTABLEEGRESO2= "id_cuenta_contable_egreso2";
    public static final String IDCUENTACONTABLEEGRESO3= "id_cuenta_contable_egreso3";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMONEDA= "Moneda Local";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDMONEDAEXTRANJERA= "Moneda Extranjera";
		public static final String LABEL_IDMONEDAEXTRANJERA_LOWER= "Moneda Extranjera";
    	public static final String LABEL_CONMASCARA= "Mascara";
		public static final String LABEL_CONMASCARA_LOWER= "con Mascara";
    	public static final String LABEL_NUMERONIVEL= "Numero Nivel";
		public static final String LABEL_NUMERONIVEL_LOWER= "Numero Nivel";
    	public static final String LABEL_ESPRESUPUESTO= "Presupuesto";
		public static final String LABEL_ESPRESUPUESTO_LOWER= "Es Presupuesto";
    	public static final String LABEL_ESLOTE= "Lote";
		public static final String LABEL_ESLOTE_LOWER= "Es Lote";
    	public static final String LABEL_CONSECUENCIALAUTOMATICO= "Secuencial  Auto.";
		public static final String LABEL_CONSECUENCIALAUTOMATICO_LOWER= "con Secuencial Automatico";
    	public static final String LABEL_CONCUENTASNIFF= "Cuentas Niff";
		public static final String LABEL_CONCUENTASNIFF_LOWER= "con Cuentas Niff";
    	public static final String LABEL_CONCENTROCOSTOMASCARA= "Mascara Centro Costo";
		public static final String LABEL_CONCENTROCOSTOMASCARA_LOWER= "con Centro Costo Mascara";
    	public static final String LABEL_CONCENTROCOSTONUEVAESTRUCTURA= "Nueva Estructura Centro C.";
		public static final String LABEL_CONCENTROCOSTONUEVAESTRUCTURA_LOWER= "con Centro Costo Nueva Estructura";
    	public static final String LABEL_CENTROCOSTONUMERONIVEL= "Centro C. No Nivel";
		public static final String LABEL_CENTROCOSTONUMERONIVEL_LOWER= "Centro Costo Numero Nivel";
    	public static final String LABEL_IDCUENTACONTABLEACTIVO= "Cuenta C. Activo";
		public static final String LABEL_IDCUENTACONTABLEACTIVO_LOWER= "Cuenta Contable Activo";
    	public static final String LABEL_IDCUENTACONTABLEPASIVO= "Cuenta C. Pasivo";
		public static final String LABEL_IDCUENTACONTABLEPASIVO_LOWER= "Cuenta Contable Pasivo";
    	public static final String LABEL_IDCUENTACONTABLEPATRIMONIO= "Cuenta C. Patrimonio";
		public static final String LABEL_IDCUENTACONTABLEPATRIMONIO_LOWER= "Cuenta Contable Patrimonio";
    	public static final String LABEL_IDCUENTACONTABLEINGRESO= "Cuenta C. Ingreso";
		public static final String LABEL_IDCUENTACONTABLEINGRESO_LOWER= "Cuenta Contable Ingreso";
    	public static final String LABEL_IDCUENTACONTABLEEGRESO= "Cuenta C. Egreso";
		public static final String LABEL_IDCUENTACONTABLEEGRESO_LOWER= "Cuenta Contable Egreso";
    	public static final String LABEL_IDCUENTACONTABLERESUMEN= "Cuenta C. Resumen";
		public static final String LABEL_IDCUENTACONTABLERESUMEN_LOWER= "Cuenta Contable Resumen";
    	public static final String LABEL_IDCUENTACONTABLEDEUDOR= "Cuenta C. Deudor";
		public static final String LABEL_IDCUENTACONTABLEDEUDOR_LOWER= "Cuenta Contable Deudor";
    	public static final String LABEL_IDCUENTACONTABLEACREEDOR= "Cuenta C. Acreedor";
		public static final String LABEL_IDCUENTACONTABLEACREEDOR_LOWER= "Cuenta Contable Acreedor";
    	public static final String LABEL_IDCUENTACONTABLEINGRESO1= "Cuenta C. Ingreso1";
		public static final String LABEL_IDCUENTACONTABLEINGRESO1_LOWER= "Cuenta Contable Ingreso1";
    	public static final String LABEL_IDCUENTACONTABLEINGRESO2= "Cuenta C. Ingreso 2";
		public static final String LABEL_IDCUENTACONTABLEINGRESO2_LOWER= "Cuenta Contable Ingreso2";
    	public static final String LABEL_IDCUENTACONTABLEINGRESO3= "Cuenta C. Ingreso 3";
		public static final String LABEL_IDCUENTACONTABLEINGRESO3_LOWER= "Cuenta Contable Ingreso3";
    	public static final String LABEL_IDCUENTACONTABLEEGRESO1= "Cuenta C. Egreso 1";
		public static final String LABEL_IDCUENTACONTABLEEGRESO1_LOWER= "Cuenta Contable Egreso1";
    	public static final String LABEL_IDCUENTACONTABLEEGRESO2= "Cuenta C. Egreso 2";
		public static final String LABEL_IDCUENTACONTABLEEGRESO2_LOWER= "Cuenta Contable Egreso2";
    	public static final String LABEL_IDCUENTACONTABLEEGRESO3= "Cuenta C. Egreso 3";
		public static final String LABEL_IDCUENTACONTABLEEGRESO3_LOWER= "Cuenta Contable Egreso3";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getParametroContaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDMONEDA)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDMONEDAEXTRANJERA;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.CONMASCARA)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_CONMASCARA;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.NUMERONIVEL)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_NUMERONIVEL;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.ESPRESUPUESTO)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_ESPRESUPUESTO;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.ESLOTE)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_ESLOTE;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_CONSECUENCIALAUTOMATICO;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.CONCUENTASNIFF)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_CONCUENTASNIFF;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTOMASCARA;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTONUEVAESTRUCTURA;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_CENTROCOSTONUMERONIVEL;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLERESUMEN;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEDEUDOR;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACREEDOR;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO1;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO2;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO3;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO1;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO2;}
		if(sNombreColumna.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3)) {sLabelColumna=ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO3;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getcon_mascaraDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroconta.getcon_mascara()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_mascaraHtmlDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroconta.getId(),parametroconta.getcon_mascara());

		return sDescripcion;
	}	
			
		
	public static String getes_presupuestoDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroconta.getes_presupuesto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_presupuestoHtmlDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroconta.getId(),parametroconta.getes_presupuesto());

		return sDescripcion;
	}	
		
	public static String getes_loteDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroconta.getes_lote()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_loteHtmlDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroconta.getId(),parametroconta.getes_lote());

		return sDescripcion;
	}	
		
	public static String getcon_secuencial_automaticoDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroconta.getcon_secuencial_automatico()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_secuencial_automaticoHtmlDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroconta.getId(),parametroconta.getcon_secuencial_automatico());

		return sDescripcion;
	}	
		
	public static String getcon_cuentas_niffDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroconta.getcon_cuentas_niff()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_cuentas_niffHtmlDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroconta.getId(),parametroconta.getcon_cuentas_niff());

		return sDescripcion;
	}	
		
	public static String getcon_centro_costo_mascaraDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroconta.getcon_centro_costo_mascara()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_centro_costo_mascaraHtmlDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroconta.getId(),parametroconta.getcon_centro_costo_mascara());

		return sDescripcion;
	}	
		
	public static String getcon_centro_costo_nueva_estructuraDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!parametroconta.getcon_centro_costo_nueva_estructura()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_centro_costo_nueva_estructuraHtmlDescripcion(ParametroConta parametroconta) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(parametroconta.getId(),parametroconta.getcon_centro_costo_nueva_estructura());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getParametroContaDescripcion(ParametroConta parametroconta) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametroconta !=null/* && parametroconta.getId()!=0*/) {
			if(parametroconta.getId()!=null) {
				sDescripcion=parametroconta.getId().toString();
			}//parametrocontaparametroconta.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroContaDescripcionDetallado(ParametroConta parametroconta) {
		String sDescripcion="";
			
		sDescripcion+=ParametroContaConstantesFunciones.ID+"=";
		sDescripcion+=parametroconta.getId().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametroconta.getVersionRow().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametroconta.getid_empresa().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=parametroconta.getid_moneda().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA+"=";
		sDescripcion+=parametroconta.getid_moneda_extranjera().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.CONMASCARA+"=";
		sDescripcion+=parametroconta.getcon_mascara().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.NUMERONIVEL+"=";
		sDescripcion+=parametroconta.getnumero_nivel().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.ESPRESUPUESTO+"=";
		sDescripcion+=parametroconta.getes_presupuesto().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.ESLOTE+"=";
		sDescripcion+=parametroconta.getes_lote().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO+"=";
		sDescripcion+=parametroconta.getcon_secuencial_automatico().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.CONCUENTASNIFF+"=";
		sDescripcion+=parametroconta.getcon_cuentas_niff().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA+"=";
		sDescripcion+=parametroconta.getcon_centro_costo_mascara().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA+"=";
		sDescripcion+=parametroconta.getcon_centro_costo_nueva_estructura().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL+"=";
		sDescripcion+=parametroconta.getcentro_costo_numero_nivel().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_activo().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_pasivo().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_patrimonio().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_ingreso().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_egreso().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_resumen().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_deudor().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_acreedor().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_ingreso1().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_ingreso2().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_ingreso3().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_egreso1().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_egreso2().toString()+",";
		sDescripcion+=ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3+"=";
		sDescripcion+=parametroconta.getid_cuenta_contable_egreso3().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroContaDescripcion(ParametroConta parametroconta,String sValor) throws Exception {			
		if(parametroconta !=null) {
			//parametrocontaparametroconta.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getMonedaExtranjeraDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getCuentaContableActivoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContablePasivoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContablePatrimonioDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIngresoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableEgresoDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableResumenDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDeudorDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableAcreedorDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIngreso1Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIngreso2Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableIngreso3Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableEgreso1Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableEgreso2Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableEgreso3Descripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContableAcreedor")) {
			sNombreIndice="Tipo=  Por Cuenta C. Acreedor";
		} else if(sNombreIndice.equals("FK_IdCuentaContableActivo")) {
			sNombreIndice="Tipo=  Por Cuenta C. Activo";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDeudor")) {
			sNombreIndice="Tipo=  Por Cuenta C. Deudor";
		} else if(sNombreIndice.equals("FK_IdCuentaContableEgreso")) {
			sNombreIndice="Tipo=  Por Cuenta C. Egreso";
		} else if(sNombreIndice.equals("FK_IdCuentaContableEgreso1")) {
			sNombreIndice="Tipo=  Por Cuenta C. Egreso 1";
		} else if(sNombreIndice.equals("FK_IdCuentaContableEgreso2")) {
			sNombreIndice="Tipo=  Por Cuenta C. Egreso 2";
		} else if(sNombreIndice.equals("FK_IdCuentaContableEgreso3")) {
			sNombreIndice="Tipo=  Por Cuenta C. Egreso 3";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIngreso")) {
			sNombreIndice="Tipo=  Por Cuenta C. Ingreso";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIngreso1")) {
			sNombreIndice="Tipo=  Por Cuenta C. Ingreso1";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIngreso2")) {
			sNombreIndice="Tipo=  Por Cuenta C. Ingreso 2";
		} else if(sNombreIndice.equals("FK_IdCuentaContableIngreso3")) {
			sNombreIndice="Tipo=  Por Cuenta C. Ingreso 3";
		} else if(sNombreIndice.equals("FK_IdCuentaContablePasivo")) {
			sNombreIndice="Tipo=  Por Cuenta C. Pasivo";
		} else if(sNombreIndice.equals("FK_IdCuentaContablePatrimonio")) {
			sNombreIndice="Tipo=  Por Cuenta C. Patrimonio";
		} else if(sNombreIndice.equals("FK_IdCuentaContableResumen")) {
			sNombreIndice="Tipo=  Por Cuenta C. Resumen";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda Local";
		} else if(sNombreIndice.equals("FK_IdMonedaExtranjera")) {
			sNombreIndice="Tipo=  Por Moneda Extranjera";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContableAcreedor(Long id_cuenta_contable_acreedor) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_acreedor!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Acreedor="+id_cuenta_contable_acreedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableActivo(Long id_cuenta_contable_activo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_activo!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Activo="+id_cuenta_contable_activo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDeudor(Long id_cuenta_contable_deudor) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_deudor!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Deudor="+id_cuenta_contable_deudor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableEgreso(Long id_cuenta_contable_egreso) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_egreso!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Egreso="+id_cuenta_contable_egreso.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableEgreso1(Long id_cuenta_contable_egreso1) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_egreso1!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Egreso 1="+id_cuenta_contable_egreso1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableEgreso2(Long id_cuenta_contable_egreso2) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_egreso2!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Egreso 2="+id_cuenta_contable_egreso2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableEgreso3(Long id_cuenta_contable_egreso3) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_egreso3!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Egreso 3="+id_cuenta_contable_egreso3.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIngreso(Long id_cuenta_contable_ingreso) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_ingreso!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Ingreso="+id_cuenta_contable_ingreso.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIngreso1(Long id_cuenta_contable_ingreso1) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_ingreso1!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Ingreso1="+id_cuenta_contable_ingreso1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIngreso2(Long id_cuenta_contable_ingreso2) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_ingreso2!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Ingreso 2="+id_cuenta_contable_ingreso2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableIngreso3(Long id_cuenta_contable_ingreso3) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_ingreso3!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Ingreso 3="+id_cuenta_contable_ingreso3.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContablePasivo(Long id_cuenta_contable_pasivo) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_pasivo!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Pasivo="+id_cuenta_contable_pasivo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContablePatrimonio(Long id_cuenta_contable_patrimonio) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_patrimonio!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Patrimonio="+id_cuenta_contable_patrimonio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableResumen(Long id_cuenta_contable_resumen) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_resumen!=null) {sDetalleIndice+=" Codigo Unico De Cuenta C. Resumen="+id_cuenta_contable_resumen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda Local="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMonedaExtranjera(Long id_moneda_extranjera) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda_extranjera!=null) {sDetalleIndice+=" Codigo Unico De Moneda Extranjera="+id_moneda_extranjera.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroConta(ParametroConta parametroconta,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroContas(List<ParametroConta> parametrocontas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroConta parametroconta: parametrocontas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroConta(ParametroConta parametroconta,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametroconta.getConCambioAuxiliar()) {
			parametroconta.setIsDeleted(parametroconta.getIsDeletedAuxiliar());	
			parametroconta.setIsNew(parametroconta.getIsNewAuxiliar());	
			parametroconta.setIsChanged(parametroconta.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametroconta.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametroconta.setIsDeletedAuxiliar(false);	
			parametroconta.setIsNewAuxiliar(false);	
			parametroconta.setIsChangedAuxiliar(false);
			
			parametroconta.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroContas(List<ParametroConta> parametrocontas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroConta parametroconta : parametrocontas) {
			if(conAsignarBase && parametroconta.getConCambioAuxiliar()) {
				parametroconta.setIsDeleted(parametroconta.getIsDeletedAuxiliar());	
				parametroconta.setIsNew(parametroconta.getIsNewAuxiliar());	
				parametroconta.setIsChanged(parametroconta.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametroconta.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametroconta.setIsDeletedAuxiliar(false);	
				parametroconta.setIsNewAuxiliar(false);	
				parametroconta.setIsChangedAuxiliar(false);
				
				parametroconta.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroConta(ParametroConta parametroconta,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			parametroconta.setnumero_nivel(0);
			parametroconta.setcentro_costo_numero_nivel(0);
		}
	}		
	
	public static void InicializarValoresParametroContas(List<ParametroConta> parametrocontas,Boolean conEnteros) throws Exception  {
		
		for(ParametroConta parametroconta: parametrocontas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				parametroconta.setnumero_nivel(0);
				parametroconta.setcentro_costo_numero_nivel(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroConta(List<ParametroConta> parametrocontas,ParametroConta parametrocontaAux) throws Exception  {
		ParametroContaConstantesFunciones.InicializarValoresParametroConta(parametrocontaAux,true);
		
		for(ParametroConta parametroconta: parametrocontas) {
			if(parametroconta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			parametrocontaAux.setnumero_nivel(parametrocontaAux.getnumero_nivel()+parametroconta.getnumero_nivel());			
			parametrocontaAux.setcentro_costo_numero_nivel(parametrocontaAux.getcentro_costo_numero_nivel()+parametroconta.getcentro_costo_numero_nivel());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroConta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroContaConstantesFunciones.getArrayColumnasGlobalesParametroConta(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroConta(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroContaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroContaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroContaConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroContaConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroConta(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroConta> parametrocontas,ParametroConta parametroconta,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroConta parametrocontaAux: parametrocontas) {
			if(parametrocontaAux!=null && parametroconta!=null) {
				if((parametrocontaAux.getId()==null && parametroconta.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrocontaAux.getId()!=null && parametroconta.getId()!=null){
					if(parametrocontaAux.getId().equals(parametroconta.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroConta(List<ParametroConta> parametrocontas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroConta parametroconta: parametrocontas) {			
			if(parametroconta.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroConta() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_ID, ParametroContaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_VERSIONROW, ParametroContaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDEMPRESA, ParametroContaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDMONEDA, ParametroContaConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDMONEDAEXTRANJERA, ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_CONMASCARA, ParametroContaConstantesFunciones.CONMASCARA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_NUMERONIVEL, ParametroContaConstantesFunciones.NUMERONIVEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_ESPRESUPUESTO, ParametroContaConstantesFunciones.ESPRESUPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_ESLOTE, ParametroContaConstantesFunciones.ESLOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_CONSECUENCIALAUTOMATICO, ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_CONCUENTASNIFF, ParametroContaConstantesFunciones.CONCUENTASNIFF,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTOMASCARA, ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTONUEVAESTRUCTURA, ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_CENTROCOSTONUMERONIVEL, ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO, ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO, ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO, ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO, ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO, ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLERESUMEN, ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEDEUDOR, ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACREEDOR, ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO1, ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO2, ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO3, ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO1, ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO2, ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO3, ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroConta() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.CONMASCARA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.NUMERONIVEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.ESPRESUPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.ESLOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.CONCUENTASNIFF;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroConta() throws Exception  {
		return ParametroContaConstantesFunciones.getTiposSeleccionarParametroConta(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroConta(Boolean conFk) throws Exception  {
		return ParametroContaConstantesFunciones.getTiposSeleccionarParametroConta(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroConta(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDMONEDAEXTRANJERA);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDMONEDAEXTRANJERA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_CONMASCARA);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_CONMASCARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_NUMERONIVEL);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_NUMERONIVEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_ESPRESUPUESTO);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_ESPRESUPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_ESLOTE);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_ESLOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_CONSECUENCIALAUTOMATICO);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_CONSECUENCIALAUTOMATICO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_CONCUENTASNIFF);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_CONCUENTASNIFF);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTOMASCARA);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTOMASCARA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTONUEVAESTRUCTURA);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTONUEVAESTRUCTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_CENTROCOSTONUMERONIVEL);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_CENTROCOSTONUMERONIVEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLERESUMEN);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLERESUMEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEDEUDOR);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEDEUDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACREEDOR);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACREEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO1);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO2);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO3);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO1);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO2);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO3);
			reporte.setsDescripcion(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroConta(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroConta(ParametroConta parametrocontaAux) throws Exception {
		
			parametrocontaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocontaAux.getEmpresa()));
			parametrocontaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrocontaAux.getMoneda()));
			parametrocontaAux.setmonedaextranjera_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrocontaAux.getMonedaExtranjera()));
			parametrocontaAux.setcuentacontableactivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableActivo()));
			parametrocontaAux.setcuentacontablepasivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContablePasivo()));
			parametrocontaAux.setcuentacontablepatrimonio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContablePatrimonio()));
			parametrocontaAux.setcuentacontableingreso_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableIngreso()));
			parametrocontaAux.setcuentacontableegreso_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableEgreso()));
			parametrocontaAux.setcuentacontableresumen_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableResumen()));
			parametrocontaAux.setcuentacontabledeudor_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableDeudor()));
			parametrocontaAux.setcuentacontableacreedor_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableAcreedor()));
			parametrocontaAux.setcuentacontableingreso1_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableIngreso1()));
			parametrocontaAux.setcuentacontableingreso2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableIngreso2()));
			parametrocontaAux.setcuentacontableingreso3_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableIngreso3()));
			parametrocontaAux.setcuentacontableegreso1_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableEgreso1()));
			parametrocontaAux.setcuentacontableegreso2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableEgreso2()));
			parametrocontaAux.setcuentacontableegreso3_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableEgreso3()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroConta(List<ParametroConta> parametrocontasTemp) throws Exception {
		for(ParametroConta parametrocontaAux:parametrocontasTemp) {
			
			parametrocontaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrocontaAux.getEmpresa()));
			parametrocontaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrocontaAux.getMoneda()));
			parametrocontaAux.setmonedaextranjera_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(parametrocontaAux.getMonedaExtranjera()));
			parametrocontaAux.setcuentacontableactivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableActivo()));
			parametrocontaAux.setcuentacontablepasivo_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContablePasivo()));
			parametrocontaAux.setcuentacontablepatrimonio_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContablePatrimonio()));
			parametrocontaAux.setcuentacontableingreso_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableIngreso()));
			parametrocontaAux.setcuentacontableegreso_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableEgreso()));
			parametrocontaAux.setcuentacontableresumen_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableResumen()));
			parametrocontaAux.setcuentacontabledeudor_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableDeudor()));
			parametrocontaAux.setcuentacontableacreedor_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableAcreedor()));
			parametrocontaAux.setcuentacontableingreso1_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableIngreso1()));
			parametrocontaAux.setcuentacontableingreso2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableIngreso2()));
			parametrocontaAux.setcuentacontableingreso3_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableIngreso3()));
			parametrocontaAux.setcuentacontableegreso1_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableEgreso1()));
			parametrocontaAux.setcuentacontableegreso2_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableEgreso2()));
			parametrocontaAux.setcuentacontableegreso3_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(parametrocontaAux.getCuentaContableEgreso3()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroContaConstantesFunciones.getClassesRelationshipsOfParametroConta(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroContaDetalle.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroContaDetalle.class)) {
						classes.add(new Classe(ParametroContaDetalle.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroContaConstantesFunciones.getClassesRelationshipsFromStringsOfParametroConta(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroConta(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroContaDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContaDetalle.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroContaDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroContaDetalle.class)); continue;
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
	public static void actualizarLista(ParametroConta parametroconta,List<ParametroConta> parametrocontas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroConta parametrocontaEncontrado=null;
			
			for(ParametroConta parametrocontaLocal:parametrocontas) {
				if(parametrocontaLocal.getId().equals(parametroconta.getId())) {
					parametrocontaEncontrado=parametrocontaLocal;
					
					parametrocontaLocal.setIsChanged(parametroconta.getIsChanged());
					parametrocontaLocal.setIsNew(parametroconta.getIsNew());
					parametrocontaLocal.setIsDeleted(parametroconta.getIsDeleted());
					
					parametrocontaLocal.setGeneralEntityOriginal(parametroconta.getGeneralEntityOriginal());
					
					parametrocontaLocal.setId(parametroconta.getId());	
					parametrocontaLocal.setVersionRow(parametroconta.getVersionRow());	
					parametrocontaLocal.setid_empresa(parametroconta.getid_empresa());	
					parametrocontaLocal.setid_moneda(parametroconta.getid_moneda());	
					parametrocontaLocal.setid_moneda_extranjera(parametroconta.getid_moneda_extranjera());	
					parametrocontaLocal.setcon_mascara(parametroconta.getcon_mascara());	
					parametrocontaLocal.setnumero_nivel(parametroconta.getnumero_nivel());	
					parametrocontaLocal.setes_presupuesto(parametroconta.getes_presupuesto());	
					parametrocontaLocal.setes_lote(parametroconta.getes_lote());	
					parametrocontaLocal.setcon_secuencial_automatico(parametroconta.getcon_secuencial_automatico());	
					parametrocontaLocal.setcon_cuentas_niff(parametroconta.getcon_cuentas_niff());	
					parametrocontaLocal.setcon_centro_costo_mascara(parametroconta.getcon_centro_costo_mascara());	
					parametrocontaLocal.setcon_centro_costo_nueva_estructura(parametroconta.getcon_centro_costo_nueva_estructura());	
					parametrocontaLocal.setcentro_costo_numero_nivel(parametroconta.getcentro_costo_numero_nivel());	
					parametrocontaLocal.setid_cuenta_contable_activo(parametroconta.getid_cuenta_contable_activo());	
					parametrocontaLocal.setid_cuenta_contable_pasivo(parametroconta.getid_cuenta_contable_pasivo());	
					parametrocontaLocal.setid_cuenta_contable_patrimonio(parametroconta.getid_cuenta_contable_patrimonio());	
					parametrocontaLocal.setid_cuenta_contable_ingreso(parametroconta.getid_cuenta_contable_ingreso());	
					parametrocontaLocal.setid_cuenta_contable_egreso(parametroconta.getid_cuenta_contable_egreso());	
					parametrocontaLocal.setid_cuenta_contable_resumen(parametroconta.getid_cuenta_contable_resumen());	
					parametrocontaLocal.setid_cuenta_contable_deudor(parametroconta.getid_cuenta_contable_deudor());	
					parametrocontaLocal.setid_cuenta_contable_acreedor(parametroconta.getid_cuenta_contable_acreedor());	
					parametrocontaLocal.setid_cuenta_contable_ingreso1(parametroconta.getid_cuenta_contable_ingreso1());	
					parametrocontaLocal.setid_cuenta_contable_ingreso2(parametroconta.getid_cuenta_contable_ingreso2());	
					parametrocontaLocal.setid_cuenta_contable_ingreso3(parametroconta.getid_cuenta_contable_ingreso3());	
					parametrocontaLocal.setid_cuenta_contable_egreso1(parametroconta.getid_cuenta_contable_egreso1());	
					parametrocontaLocal.setid_cuenta_contable_egreso2(parametroconta.getid_cuenta_contable_egreso2());	
					parametrocontaLocal.setid_cuenta_contable_egreso3(parametroconta.getid_cuenta_contable_egreso3());	
					
					
					parametrocontaLocal.setParametroContaDetalles(parametroconta.getParametroContaDetalles());
					
					existe=true;
					break;
				}
			}
			
			if(!parametroconta.getIsDeleted()) {
				if(!existe) {
					parametrocontas.add(parametroconta);
				}
			} else {
				if(parametrocontaEncontrado!=null && permiteQuitar)  {
					parametrocontas.remove(parametrocontaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroConta parametroconta,List<ParametroConta> parametrocontas) throws Exception {
		try	{			
			for(ParametroConta parametrocontaLocal:parametrocontas) {
				if(parametrocontaLocal.getId().equals(parametroconta.getId())) {
					parametrocontaLocal.setIsSelected(parametroconta.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroConta(List<ParametroConta> parametrocontasAux) throws Exception {
		//this.parametrocontasAux=parametrocontasAux;
		
		for(ParametroConta parametrocontaAux:parametrocontasAux) {
			if(parametrocontaAux.getIsChanged()) {
				parametrocontaAux.setIsChanged(false);
			}		
			
			if(parametrocontaAux.getIsNew()) {
				parametrocontaAux.setIsNew(false);
			}	
			
			if(parametrocontaAux.getIsDeleted()) {
				parametrocontaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroConta(ParametroConta parametrocontaAux) throws Exception {
		//this.parametrocontaAux=parametrocontaAux;
		
			if(parametrocontaAux.getIsChanged()) {
				parametrocontaAux.setIsChanged(false);
			}		
			
			if(parametrocontaAux.getIsNew()) {
				parametrocontaAux.setIsNew(false);
			}	
			
			if(parametrocontaAux.getIsDeleted()) {
				parametrocontaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroConta parametrocontaAsignar,ParametroConta parametroconta) throws Exception {
		parametrocontaAsignar.setId(parametroconta.getId());	
		parametrocontaAsignar.setVersionRow(parametroconta.getVersionRow());	
		parametrocontaAsignar.setid_empresa(parametroconta.getid_empresa());
		parametrocontaAsignar.setempresa_descripcion(parametroconta.getempresa_descripcion());	
		parametrocontaAsignar.setid_moneda(parametroconta.getid_moneda());
		parametrocontaAsignar.setmoneda_descripcion(parametroconta.getmoneda_descripcion());	
		parametrocontaAsignar.setid_moneda_extranjera(parametroconta.getid_moneda_extranjera());
		parametrocontaAsignar.setmonedaextranjera_descripcion(parametroconta.getmonedaextranjera_descripcion());	
		parametrocontaAsignar.setcon_mascara(parametroconta.getcon_mascara());	
		parametrocontaAsignar.setnumero_nivel(parametroconta.getnumero_nivel());	
		parametrocontaAsignar.setes_presupuesto(parametroconta.getes_presupuesto());	
		parametrocontaAsignar.setes_lote(parametroconta.getes_lote());	
		parametrocontaAsignar.setcon_secuencial_automatico(parametroconta.getcon_secuencial_automatico());	
		parametrocontaAsignar.setcon_cuentas_niff(parametroconta.getcon_cuentas_niff());	
		parametrocontaAsignar.setcon_centro_costo_mascara(parametroconta.getcon_centro_costo_mascara());	
		parametrocontaAsignar.setcon_centro_costo_nueva_estructura(parametroconta.getcon_centro_costo_nueva_estructura());	
		parametrocontaAsignar.setcentro_costo_numero_nivel(parametroconta.getcentro_costo_numero_nivel());	
		parametrocontaAsignar.setid_cuenta_contable_activo(parametroconta.getid_cuenta_contable_activo());
		parametrocontaAsignar.setcuentacontableactivo_descripcion(parametroconta.getcuentacontableactivo_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_pasivo(parametroconta.getid_cuenta_contable_pasivo());
		parametrocontaAsignar.setcuentacontablepasivo_descripcion(parametroconta.getcuentacontablepasivo_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_patrimonio(parametroconta.getid_cuenta_contable_patrimonio());
		parametrocontaAsignar.setcuentacontablepatrimonio_descripcion(parametroconta.getcuentacontablepatrimonio_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_ingreso(parametroconta.getid_cuenta_contable_ingreso());
		parametrocontaAsignar.setcuentacontableingreso_descripcion(parametroconta.getcuentacontableingreso_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_egreso(parametroconta.getid_cuenta_contable_egreso());
		parametrocontaAsignar.setcuentacontableegreso_descripcion(parametroconta.getcuentacontableegreso_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_resumen(parametroconta.getid_cuenta_contable_resumen());
		parametrocontaAsignar.setcuentacontableresumen_descripcion(parametroconta.getcuentacontableresumen_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_deudor(parametroconta.getid_cuenta_contable_deudor());
		parametrocontaAsignar.setcuentacontabledeudor_descripcion(parametroconta.getcuentacontabledeudor_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_acreedor(parametroconta.getid_cuenta_contable_acreedor());
		parametrocontaAsignar.setcuentacontableacreedor_descripcion(parametroconta.getcuentacontableacreedor_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_ingreso1(parametroconta.getid_cuenta_contable_ingreso1());
		parametrocontaAsignar.setcuentacontableingreso1_descripcion(parametroconta.getcuentacontableingreso1_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_ingreso2(parametroconta.getid_cuenta_contable_ingreso2());
		parametrocontaAsignar.setcuentacontableingreso2_descripcion(parametroconta.getcuentacontableingreso2_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_ingreso3(parametroconta.getid_cuenta_contable_ingreso3());
		parametrocontaAsignar.setcuentacontableingreso3_descripcion(parametroconta.getcuentacontableingreso3_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_egreso1(parametroconta.getid_cuenta_contable_egreso1());
		parametrocontaAsignar.setcuentacontableegreso1_descripcion(parametroconta.getcuentacontableegreso1_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_egreso2(parametroconta.getid_cuenta_contable_egreso2());
		parametrocontaAsignar.setcuentacontableegreso2_descripcion(parametroconta.getcuentacontableegreso2_descripcion());	
		parametrocontaAsignar.setid_cuenta_contable_egreso3(parametroconta.getid_cuenta_contable_egreso3());
		parametrocontaAsignar.setcuentacontableegreso3_descripcion(parametroconta.getcuentacontableegreso3_descripcion());	
	}
	
	public static void inicializarParametroConta(ParametroConta parametroconta) throws Exception {
		try {
				parametroconta.setId(0L);	
					
				parametroconta.setid_empresa(-1L);	
				parametroconta.setid_moneda(-1L);	
				parametroconta.setid_moneda_extranjera(-1L);	
				parametroconta.setcon_mascara(false);	
				parametroconta.setnumero_nivel(0);	
				parametroconta.setes_presupuesto(false);	
				parametroconta.setes_lote(false);	
				parametroconta.setcon_secuencial_automatico(false);	
				parametroconta.setcon_cuentas_niff(false);	
				parametroconta.setcon_centro_costo_mascara(false);	
				parametroconta.setcon_centro_costo_nueva_estructura(false);	
				parametroconta.setcentro_costo_numero_nivel(0);	
				parametroconta.setid_cuenta_contable_activo(-1L);	
				parametroconta.setid_cuenta_contable_pasivo(-1L);	
				parametroconta.setid_cuenta_contable_patrimonio(-1L);	
				parametroconta.setid_cuenta_contable_ingreso(-1L);	
				parametroconta.setid_cuenta_contable_egreso(-1L);	
				parametroconta.setid_cuenta_contable_resumen(-1L);	
				parametroconta.setid_cuenta_contable_deudor(-1L);	
				parametroconta.setid_cuenta_contable_acreedor(-1L);	
				parametroconta.setid_cuenta_contable_ingreso1(null);	
				parametroconta.setid_cuenta_contable_ingreso2(null);	
				parametroconta.setid_cuenta_contable_ingreso3(null);	
				parametroconta.setid_cuenta_contable_egreso1(null);	
				parametroconta.setid_cuenta_contable_egreso2(null);	
				parametroconta.setid_cuenta_contable_egreso3(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroConta(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDMONEDAEXTRANJERA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_CONMASCARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_NUMERONIVEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_ESPRESUPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_ESLOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_CONSECUENCIALAUTOMATICO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_CONCUENTASNIFF);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTOMASCARA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_CONCENTROCOSTONUEVAESTRUCTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_CENTROCOSTONUMERONIVEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACTIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPASIVO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEPATRIMONIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLERESUMEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEDEUDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEACREEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEINGRESO3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroContaConstantesFunciones.LABEL_IDCUENTACONTABLEEGRESO3);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroConta(String sTipo,Row row,Workbook workbook,ParametroConta parametroconta,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getmonedaextranjera_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroconta.getcon_mascara()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getnumero_nivel());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroconta.getes_presupuesto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroconta.getes_lote()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroconta.getcon_secuencial_automatico()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroconta.getcon_cuentas_niff()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroconta.getcon_centro_costo_mascara()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(parametroconta.getcon_centro_costo_nueva_estructura()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcentro_costo_numero_nivel());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableactivo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontablepasivo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontablepatrimonio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableingreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableegreso_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableresumen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontabledeudor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableacreedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableingreso1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableingreso2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableingreso3_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableegreso1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableegreso2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametroconta.getcuentacontableegreso3_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroConta=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroConta() {
		return this.sFinalQueryParametroConta;
	}
	
	public void setsFinalQueryParametroConta(String sFinalQueryParametroConta) {
		this.sFinalQueryParametroConta= sFinalQueryParametroConta;
	}
	
	public Border resaltarSeleccionarParametroConta=null;
	
	public Border setResaltarSeleccionarParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroConta= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroConta() {
		return this.resaltarSeleccionarParametroConta;
	}
	
	public void setResaltarSeleccionarParametroConta(Border borderResaltarSeleccionarParametroConta) {
		this.resaltarSeleccionarParametroConta= borderResaltarSeleccionarParametroConta;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroConta=null;
	public Boolean mostraridParametroConta=true;
	public Boolean activaridParametroConta=true;

	public Border resaltarid_empresaParametroConta=null;
	public Boolean mostrarid_empresaParametroConta=true;
	public Boolean activarid_empresaParametroConta=true;
	public Boolean cargarid_empresaParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroConta=false;//ConEventDepend=true

	public Border resaltarid_monedaParametroConta=null;
	public Boolean mostrarid_monedaParametroConta=true;
	public Boolean activarid_monedaParametroConta=true;
	public Boolean cargarid_monedaParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaParametroConta=false;//ConEventDepend=true

	public Border resaltarid_moneda_extranjeraParametroConta=null;
	public Boolean mostrarid_moneda_extranjeraParametroConta=true;
	public Boolean activarid_moneda_extranjeraParametroConta=true;
	public Boolean cargarid_moneda_extranjeraParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moneda_extranjeraParametroConta=false;//ConEventDepend=true

	public Border resaltarcon_mascaraParametroConta=null;
	public Boolean mostrarcon_mascaraParametroConta=true;
	public Boolean activarcon_mascaraParametroConta=true;

	public Border resaltarnumero_nivelParametroConta=null;
	public Boolean mostrarnumero_nivelParametroConta=true;
	public Boolean activarnumero_nivelParametroConta=true;

	public Border resaltares_presupuestoParametroConta=null;
	public Boolean mostrares_presupuestoParametroConta=true;
	public Boolean activares_presupuestoParametroConta=true;

	public Border resaltares_loteParametroConta=null;
	public Boolean mostrares_loteParametroConta=true;
	public Boolean activares_loteParametroConta=true;

	public Border resaltarcon_secuencial_automaticoParametroConta=null;
	public Boolean mostrarcon_secuencial_automaticoParametroConta=true;
	public Boolean activarcon_secuencial_automaticoParametroConta=true;

	public Border resaltarcon_cuentas_niffParametroConta=null;
	public Boolean mostrarcon_cuentas_niffParametroConta=true;
	public Boolean activarcon_cuentas_niffParametroConta=true;

	public Border resaltarcon_centro_costo_mascaraParametroConta=null;
	public Boolean mostrarcon_centro_costo_mascaraParametroConta=true;
	public Boolean activarcon_centro_costo_mascaraParametroConta=true;

	public Border resaltarcon_centro_costo_nueva_estructuraParametroConta=null;
	public Boolean mostrarcon_centro_costo_nueva_estructuraParametroConta=true;
	public Boolean activarcon_centro_costo_nueva_estructuraParametroConta=true;

	public Border resaltarcentro_costo_numero_nivelParametroConta=null;
	public Boolean mostrarcentro_costo_numero_nivelParametroConta=true;
	public Boolean activarcentro_costo_numero_nivelParametroConta=true;

	public Border resaltarid_cuenta_contable_activoParametroConta=null;
	public Boolean mostrarid_cuenta_contable_activoParametroConta=true;
	public Boolean activarid_cuenta_contable_activoParametroConta=true;
	public Boolean cargarid_cuenta_contable_activoParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_activoParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_pasivoParametroConta=null;
	public Boolean mostrarid_cuenta_contable_pasivoParametroConta=true;
	public Boolean activarid_cuenta_contable_pasivoParametroConta=true;
	public Boolean cargarid_cuenta_contable_pasivoParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_pasivoParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_patrimonioParametroConta=null;
	public Boolean mostrarid_cuenta_contable_patrimonioParametroConta=true;
	public Boolean activarid_cuenta_contable_patrimonioParametroConta=true;
	public Boolean cargarid_cuenta_contable_patrimonioParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_patrimonioParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ingresoParametroConta=null;
	public Boolean mostrarid_cuenta_contable_ingresoParametroConta=true;
	public Boolean activarid_cuenta_contable_ingresoParametroConta=true;
	public Boolean cargarid_cuenta_contable_ingresoParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ingresoParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_egresoParametroConta=null;
	public Boolean mostrarid_cuenta_contable_egresoParametroConta=true;
	public Boolean activarid_cuenta_contable_egresoParametroConta=true;
	public Boolean cargarid_cuenta_contable_egresoParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_egresoParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_resumenParametroConta=null;
	public Boolean mostrarid_cuenta_contable_resumenParametroConta=true;
	public Boolean activarid_cuenta_contable_resumenParametroConta=true;
	public Boolean cargarid_cuenta_contable_resumenParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_resumenParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_deudorParametroConta=null;
	public Boolean mostrarid_cuenta_contable_deudorParametroConta=true;
	public Boolean activarid_cuenta_contable_deudorParametroConta=true;
	public Boolean cargarid_cuenta_contable_deudorParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_deudorParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_acreedorParametroConta=null;
	public Boolean mostrarid_cuenta_contable_acreedorParametroConta=true;
	public Boolean activarid_cuenta_contable_acreedorParametroConta=true;
	public Boolean cargarid_cuenta_contable_acreedorParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_acreedorParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ingreso1ParametroConta=null;
	public Boolean mostrarid_cuenta_contable_ingreso1ParametroConta=true;
	public Boolean activarid_cuenta_contable_ingreso1ParametroConta=true;
	public Boolean cargarid_cuenta_contable_ingreso1ParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ingreso1ParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ingreso2ParametroConta=null;
	public Boolean mostrarid_cuenta_contable_ingreso2ParametroConta=true;
	public Boolean activarid_cuenta_contable_ingreso2ParametroConta=true;
	public Boolean cargarid_cuenta_contable_ingreso2ParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ingreso2ParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_ingreso3ParametroConta=null;
	public Boolean mostrarid_cuenta_contable_ingreso3ParametroConta=true;
	public Boolean activarid_cuenta_contable_ingreso3ParametroConta=true;
	public Boolean cargarid_cuenta_contable_ingreso3ParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_ingreso3ParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_egreso1ParametroConta=null;
	public Boolean mostrarid_cuenta_contable_egreso1ParametroConta=true;
	public Boolean activarid_cuenta_contable_egreso1ParametroConta=true;
	public Boolean cargarid_cuenta_contable_egreso1ParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_egreso1ParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_egreso2ParametroConta=null;
	public Boolean mostrarid_cuenta_contable_egreso2ParametroConta=true;
	public Boolean activarid_cuenta_contable_egreso2ParametroConta=true;
	public Boolean cargarid_cuenta_contable_egreso2ParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_egreso2ParametroConta=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_egreso3ParametroConta=null;
	public Boolean mostrarid_cuenta_contable_egreso3ParametroConta=true;
	public Boolean activarid_cuenta_contable_egreso3ParametroConta=true;
	public Boolean cargarid_cuenta_contable_egreso3ParametroConta=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_egreso3ParametroConta=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltaridParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroConta() {
		return this.resaltaridParametroConta;
	}

	public void setResaltaridParametroConta(Border borderResaltar) {
		this.resaltaridParametroConta= borderResaltar;
	}

	public Boolean getMostraridParametroConta() {
		return this.mostraridParametroConta;
	}

	public void setMostraridParametroConta(Boolean mostraridParametroConta) {
		this.mostraridParametroConta= mostraridParametroConta;
	}

	public Boolean getActivaridParametroConta() {
		return this.activaridParametroConta;
	}

	public void setActivaridParametroConta(Boolean activaridParametroConta) {
		this.activaridParametroConta= activaridParametroConta;
	}

	public Border setResaltarid_empresaParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroConta() {
		return this.resaltarid_empresaParametroConta;
	}

	public void setResaltarid_empresaParametroConta(Border borderResaltar) {
		this.resaltarid_empresaParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroConta() {
		return this.mostrarid_empresaParametroConta;
	}

	public void setMostrarid_empresaParametroConta(Boolean mostrarid_empresaParametroConta) {
		this.mostrarid_empresaParametroConta= mostrarid_empresaParametroConta;
	}

	public Boolean getActivarid_empresaParametroConta() {
		return this.activarid_empresaParametroConta;
	}

	public void setActivarid_empresaParametroConta(Boolean activarid_empresaParametroConta) {
		this.activarid_empresaParametroConta= activarid_empresaParametroConta;
	}

	public Boolean getCargarid_empresaParametroConta() {
		return this.cargarid_empresaParametroConta;
	}

	public void setCargarid_empresaParametroConta(Boolean cargarid_empresaParametroConta) {
		this.cargarid_empresaParametroConta= cargarid_empresaParametroConta;
	}

	public Border setResaltarid_monedaParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_monedaParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaParametroConta() {
		return this.resaltarid_monedaParametroConta;
	}

	public void setResaltarid_monedaParametroConta(Border borderResaltar) {
		this.resaltarid_monedaParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_monedaParametroConta() {
		return this.mostrarid_monedaParametroConta;
	}

	public void setMostrarid_monedaParametroConta(Boolean mostrarid_monedaParametroConta) {
		this.mostrarid_monedaParametroConta= mostrarid_monedaParametroConta;
	}

	public Boolean getActivarid_monedaParametroConta() {
		return this.activarid_monedaParametroConta;
	}

	public void setActivarid_monedaParametroConta(Boolean activarid_monedaParametroConta) {
		this.activarid_monedaParametroConta= activarid_monedaParametroConta;
	}

	public Boolean getCargarid_monedaParametroConta() {
		return this.cargarid_monedaParametroConta;
	}

	public void setCargarid_monedaParametroConta(Boolean cargarid_monedaParametroConta) {
		this.cargarid_monedaParametroConta= cargarid_monedaParametroConta;
	}

	public Border setResaltarid_moneda_extranjeraParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_moneda_extranjeraParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moneda_extranjeraParametroConta() {
		return this.resaltarid_moneda_extranjeraParametroConta;
	}

	public void setResaltarid_moneda_extranjeraParametroConta(Border borderResaltar) {
		this.resaltarid_moneda_extranjeraParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_moneda_extranjeraParametroConta() {
		return this.mostrarid_moneda_extranjeraParametroConta;
	}

	public void setMostrarid_moneda_extranjeraParametroConta(Boolean mostrarid_moneda_extranjeraParametroConta) {
		this.mostrarid_moneda_extranjeraParametroConta= mostrarid_moneda_extranjeraParametroConta;
	}

	public Boolean getActivarid_moneda_extranjeraParametroConta() {
		return this.activarid_moneda_extranjeraParametroConta;
	}

	public void setActivarid_moneda_extranjeraParametroConta(Boolean activarid_moneda_extranjeraParametroConta) {
		this.activarid_moneda_extranjeraParametroConta= activarid_moneda_extranjeraParametroConta;
	}

	public Boolean getCargarid_moneda_extranjeraParametroConta() {
		return this.cargarid_moneda_extranjeraParametroConta;
	}

	public void setCargarid_moneda_extranjeraParametroConta(Boolean cargarid_moneda_extranjeraParametroConta) {
		this.cargarid_moneda_extranjeraParametroConta= cargarid_moneda_extranjeraParametroConta;
	}

	public Border setResaltarcon_mascaraParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarcon_mascaraParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_mascaraParametroConta() {
		return this.resaltarcon_mascaraParametroConta;
	}

	public void setResaltarcon_mascaraParametroConta(Border borderResaltar) {
		this.resaltarcon_mascaraParametroConta= borderResaltar;
	}

	public Boolean getMostrarcon_mascaraParametroConta() {
		return this.mostrarcon_mascaraParametroConta;
	}

	public void setMostrarcon_mascaraParametroConta(Boolean mostrarcon_mascaraParametroConta) {
		this.mostrarcon_mascaraParametroConta= mostrarcon_mascaraParametroConta;
	}

	public Boolean getActivarcon_mascaraParametroConta() {
		return this.activarcon_mascaraParametroConta;
	}

	public void setActivarcon_mascaraParametroConta(Boolean activarcon_mascaraParametroConta) {
		this.activarcon_mascaraParametroConta= activarcon_mascaraParametroConta;
	}

	public Border setResaltarnumero_nivelParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarnumero_nivelParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_nivelParametroConta() {
		return this.resaltarnumero_nivelParametroConta;
	}

	public void setResaltarnumero_nivelParametroConta(Border borderResaltar) {
		this.resaltarnumero_nivelParametroConta= borderResaltar;
	}

	public Boolean getMostrarnumero_nivelParametroConta() {
		return this.mostrarnumero_nivelParametroConta;
	}

	public void setMostrarnumero_nivelParametroConta(Boolean mostrarnumero_nivelParametroConta) {
		this.mostrarnumero_nivelParametroConta= mostrarnumero_nivelParametroConta;
	}

	public Boolean getActivarnumero_nivelParametroConta() {
		return this.activarnumero_nivelParametroConta;
	}

	public void setActivarnumero_nivelParametroConta(Boolean activarnumero_nivelParametroConta) {
		this.activarnumero_nivelParametroConta= activarnumero_nivelParametroConta;
	}

	public Border setResaltares_presupuestoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltares_presupuestoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_presupuestoParametroConta() {
		return this.resaltares_presupuestoParametroConta;
	}

	public void setResaltares_presupuestoParametroConta(Border borderResaltar) {
		this.resaltares_presupuestoParametroConta= borderResaltar;
	}

	public Boolean getMostrares_presupuestoParametroConta() {
		return this.mostrares_presupuestoParametroConta;
	}

	public void setMostrares_presupuestoParametroConta(Boolean mostrares_presupuestoParametroConta) {
		this.mostrares_presupuestoParametroConta= mostrares_presupuestoParametroConta;
	}

	public Boolean getActivares_presupuestoParametroConta() {
		return this.activares_presupuestoParametroConta;
	}

	public void setActivares_presupuestoParametroConta(Boolean activares_presupuestoParametroConta) {
		this.activares_presupuestoParametroConta= activares_presupuestoParametroConta;
	}

	public Border setResaltares_loteParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltares_loteParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_loteParametroConta() {
		return this.resaltares_loteParametroConta;
	}

	public void setResaltares_loteParametroConta(Border borderResaltar) {
		this.resaltares_loteParametroConta= borderResaltar;
	}

	public Boolean getMostrares_loteParametroConta() {
		return this.mostrares_loteParametroConta;
	}

	public void setMostrares_loteParametroConta(Boolean mostrares_loteParametroConta) {
		this.mostrares_loteParametroConta= mostrares_loteParametroConta;
	}

	public Boolean getActivares_loteParametroConta() {
		return this.activares_loteParametroConta;
	}

	public void setActivares_loteParametroConta(Boolean activares_loteParametroConta) {
		this.activares_loteParametroConta= activares_loteParametroConta;
	}

	public Border setResaltarcon_secuencial_automaticoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarcon_secuencial_automaticoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_secuencial_automaticoParametroConta() {
		return this.resaltarcon_secuencial_automaticoParametroConta;
	}

	public void setResaltarcon_secuencial_automaticoParametroConta(Border borderResaltar) {
		this.resaltarcon_secuencial_automaticoParametroConta= borderResaltar;
	}

	public Boolean getMostrarcon_secuencial_automaticoParametroConta() {
		return this.mostrarcon_secuencial_automaticoParametroConta;
	}

	public void setMostrarcon_secuencial_automaticoParametroConta(Boolean mostrarcon_secuencial_automaticoParametroConta) {
		this.mostrarcon_secuencial_automaticoParametroConta= mostrarcon_secuencial_automaticoParametroConta;
	}

	public Boolean getActivarcon_secuencial_automaticoParametroConta() {
		return this.activarcon_secuencial_automaticoParametroConta;
	}

	public void setActivarcon_secuencial_automaticoParametroConta(Boolean activarcon_secuencial_automaticoParametroConta) {
		this.activarcon_secuencial_automaticoParametroConta= activarcon_secuencial_automaticoParametroConta;
	}

	public Border setResaltarcon_cuentas_niffParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarcon_cuentas_niffParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_cuentas_niffParametroConta() {
		return this.resaltarcon_cuentas_niffParametroConta;
	}

	public void setResaltarcon_cuentas_niffParametroConta(Border borderResaltar) {
		this.resaltarcon_cuentas_niffParametroConta= borderResaltar;
	}

	public Boolean getMostrarcon_cuentas_niffParametroConta() {
		return this.mostrarcon_cuentas_niffParametroConta;
	}

	public void setMostrarcon_cuentas_niffParametroConta(Boolean mostrarcon_cuentas_niffParametroConta) {
		this.mostrarcon_cuentas_niffParametroConta= mostrarcon_cuentas_niffParametroConta;
	}

	public Boolean getActivarcon_cuentas_niffParametroConta() {
		return this.activarcon_cuentas_niffParametroConta;
	}

	public void setActivarcon_cuentas_niffParametroConta(Boolean activarcon_cuentas_niffParametroConta) {
		this.activarcon_cuentas_niffParametroConta= activarcon_cuentas_niffParametroConta;
	}

	public Border setResaltarcon_centro_costo_mascaraParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarcon_centro_costo_mascaraParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_centro_costo_mascaraParametroConta() {
		return this.resaltarcon_centro_costo_mascaraParametroConta;
	}

	public void setResaltarcon_centro_costo_mascaraParametroConta(Border borderResaltar) {
		this.resaltarcon_centro_costo_mascaraParametroConta= borderResaltar;
	}

	public Boolean getMostrarcon_centro_costo_mascaraParametroConta() {
		return this.mostrarcon_centro_costo_mascaraParametroConta;
	}

	public void setMostrarcon_centro_costo_mascaraParametroConta(Boolean mostrarcon_centro_costo_mascaraParametroConta) {
		this.mostrarcon_centro_costo_mascaraParametroConta= mostrarcon_centro_costo_mascaraParametroConta;
	}

	public Boolean getActivarcon_centro_costo_mascaraParametroConta() {
		return this.activarcon_centro_costo_mascaraParametroConta;
	}

	public void setActivarcon_centro_costo_mascaraParametroConta(Boolean activarcon_centro_costo_mascaraParametroConta) {
		this.activarcon_centro_costo_mascaraParametroConta= activarcon_centro_costo_mascaraParametroConta;
	}

	public Border setResaltarcon_centro_costo_nueva_estructuraParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarcon_centro_costo_nueva_estructuraParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_centro_costo_nueva_estructuraParametroConta() {
		return this.resaltarcon_centro_costo_nueva_estructuraParametroConta;
	}

	public void setResaltarcon_centro_costo_nueva_estructuraParametroConta(Border borderResaltar) {
		this.resaltarcon_centro_costo_nueva_estructuraParametroConta= borderResaltar;
	}

	public Boolean getMostrarcon_centro_costo_nueva_estructuraParametroConta() {
		return this.mostrarcon_centro_costo_nueva_estructuraParametroConta;
	}

	public void setMostrarcon_centro_costo_nueva_estructuraParametroConta(Boolean mostrarcon_centro_costo_nueva_estructuraParametroConta) {
		this.mostrarcon_centro_costo_nueva_estructuraParametroConta= mostrarcon_centro_costo_nueva_estructuraParametroConta;
	}

	public Boolean getActivarcon_centro_costo_nueva_estructuraParametroConta() {
		return this.activarcon_centro_costo_nueva_estructuraParametroConta;
	}

	public void setActivarcon_centro_costo_nueva_estructuraParametroConta(Boolean activarcon_centro_costo_nueva_estructuraParametroConta) {
		this.activarcon_centro_costo_nueva_estructuraParametroConta= activarcon_centro_costo_nueva_estructuraParametroConta;
	}

	public Border setResaltarcentro_costo_numero_nivelParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarcentro_costo_numero_nivelParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcentro_costo_numero_nivelParametroConta() {
		return this.resaltarcentro_costo_numero_nivelParametroConta;
	}

	public void setResaltarcentro_costo_numero_nivelParametroConta(Border borderResaltar) {
		this.resaltarcentro_costo_numero_nivelParametroConta= borderResaltar;
	}

	public Boolean getMostrarcentro_costo_numero_nivelParametroConta() {
		return this.mostrarcentro_costo_numero_nivelParametroConta;
	}

	public void setMostrarcentro_costo_numero_nivelParametroConta(Boolean mostrarcentro_costo_numero_nivelParametroConta) {
		this.mostrarcentro_costo_numero_nivelParametroConta= mostrarcentro_costo_numero_nivelParametroConta;
	}

	public Boolean getActivarcentro_costo_numero_nivelParametroConta() {
		return this.activarcentro_costo_numero_nivelParametroConta;
	}

	public void setActivarcentro_costo_numero_nivelParametroConta(Boolean activarcentro_costo_numero_nivelParametroConta) {
		this.activarcentro_costo_numero_nivelParametroConta= activarcentro_costo_numero_nivelParametroConta;
	}

	public Border setResaltarid_cuenta_contable_activoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_activoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_activoParametroConta() {
		return this.resaltarid_cuenta_contable_activoParametroConta;
	}

	public void setResaltarid_cuenta_contable_activoParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_activoParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_activoParametroConta() {
		return this.mostrarid_cuenta_contable_activoParametroConta;
	}

	public void setMostrarid_cuenta_contable_activoParametroConta(Boolean mostrarid_cuenta_contable_activoParametroConta) {
		this.mostrarid_cuenta_contable_activoParametroConta= mostrarid_cuenta_contable_activoParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_activoParametroConta() {
		return this.activarid_cuenta_contable_activoParametroConta;
	}

	public void setActivarid_cuenta_contable_activoParametroConta(Boolean activarid_cuenta_contable_activoParametroConta) {
		this.activarid_cuenta_contable_activoParametroConta= activarid_cuenta_contable_activoParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_activoParametroConta() {
		return this.cargarid_cuenta_contable_activoParametroConta;
	}

	public void setCargarid_cuenta_contable_activoParametroConta(Boolean cargarid_cuenta_contable_activoParametroConta) {
		this.cargarid_cuenta_contable_activoParametroConta= cargarid_cuenta_contable_activoParametroConta;
	}

	public Border setResaltarid_cuenta_contable_pasivoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_pasivoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_pasivoParametroConta() {
		return this.resaltarid_cuenta_contable_pasivoParametroConta;
	}

	public void setResaltarid_cuenta_contable_pasivoParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_pasivoParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_pasivoParametroConta() {
		return this.mostrarid_cuenta_contable_pasivoParametroConta;
	}

	public void setMostrarid_cuenta_contable_pasivoParametroConta(Boolean mostrarid_cuenta_contable_pasivoParametroConta) {
		this.mostrarid_cuenta_contable_pasivoParametroConta= mostrarid_cuenta_contable_pasivoParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_pasivoParametroConta() {
		return this.activarid_cuenta_contable_pasivoParametroConta;
	}

	public void setActivarid_cuenta_contable_pasivoParametroConta(Boolean activarid_cuenta_contable_pasivoParametroConta) {
		this.activarid_cuenta_contable_pasivoParametroConta= activarid_cuenta_contable_pasivoParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_pasivoParametroConta() {
		return this.cargarid_cuenta_contable_pasivoParametroConta;
	}

	public void setCargarid_cuenta_contable_pasivoParametroConta(Boolean cargarid_cuenta_contable_pasivoParametroConta) {
		this.cargarid_cuenta_contable_pasivoParametroConta= cargarid_cuenta_contable_pasivoParametroConta;
	}

	public Border setResaltarid_cuenta_contable_patrimonioParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_patrimonioParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_patrimonioParametroConta() {
		return this.resaltarid_cuenta_contable_patrimonioParametroConta;
	}

	public void setResaltarid_cuenta_contable_patrimonioParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_patrimonioParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_patrimonioParametroConta() {
		return this.mostrarid_cuenta_contable_patrimonioParametroConta;
	}

	public void setMostrarid_cuenta_contable_patrimonioParametroConta(Boolean mostrarid_cuenta_contable_patrimonioParametroConta) {
		this.mostrarid_cuenta_contable_patrimonioParametroConta= mostrarid_cuenta_contable_patrimonioParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_patrimonioParametroConta() {
		return this.activarid_cuenta_contable_patrimonioParametroConta;
	}

	public void setActivarid_cuenta_contable_patrimonioParametroConta(Boolean activarid_cuenta_contable_patrimonioParametroConta) {
		this.activarid_cuenta_contable_patrimonioParametroConta= activarid_cuenta_contable_patrimonioParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_patrimonioParametroConta() {
		return this.cargarid_cuenta_contable_patrimonioParametroConta;
	}

	public void setCargarid_cuenta_contable_patrimonioParametroConta(Boolean cargarid_cuenta_contable_patrimonioParametroConta) {
		this.cargarid_cuenta_contable_patrimonioParametroConta= cargarid_cuenta_contable_patrimonioParametroConta;
	}

	public Border setResaltarid_cuenta_contable_ingresoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ingresoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ingresoParametroConta() {
		return this.resaltarid_cuenta_contable_ingresoParametroConta;
	}

	public void setResaltarid_cuenta_contable_ingresoParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ingresoParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ingresoParametroConta() {
		return this.mostrarid_cuenta_contable_ingresoParametroConta;
	}

	public void setMostrarid_cuenta_contable_ingresoParametroConta(Boolean mostrarid_cuenta_contable_ingresoParametroConta) {
		this.mostrarid_cuenta_contable_ingresoParametroConta= mostrarid_cuenta_contable_ingresoParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_ingresoParametroConta() {
		return this.activarid_cuenta_contable_ingresoParametroConta;
	}

	public void setActivarid_cuenta_contable_ingresoParametroConta(Boolean activarid_cuenta_contable_ingresoParametroConta) {
		this.activarid_cuenta_contable_ingresoParametroConta= activarid_cuenta_contable_ingresoParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_ingresoParametroConta() {
		return this.cargarid_cuenta_contable_ingresoParametroConta;
	}

	public void setCargarid_cuenta_contable_ingresoParametroConta(Boolean cargarid_cuenta_contable_ingresoParametroConta) {
		this.cargarid_cuenta_contable_ingresoParametroConta= cargarid_cuenta_contable_ingresoParametroConta;
	}

	public Border setResaltarid_cuenta_contable_egresoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_egresoParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_egresoParametroConta() {
		return this.resaltarid_cuenta_contable_egresoParametroConta;
	}

	public void setResaltarid_cuenta_contable_egresoParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_egresoParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_egresoParametroConta() {
		return this.mostrarid_cuenta_contable_egresoParametroConta;
	}

	public void setMostrarid_cuenta_contable_egresoParametroConta(Boolean mostrarid_cuenta_contable_egresoParametroConta) {
		this.mostrarid_cuenta_contable_egresoParametroConta= mostrarid_cuenta_contable_egresoParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_egresoParametroConta() {
		return this.activarid_cuenta_contable_egresoParametroConta;
	}

	public void setActivarid_cuenta_contable_egresoParametroConta(Boolean activarid_cuenta_contable_egresoParametroConta) {
		this.activarid_cuenta_contable_egresoParametroConta= activarid_cuenta_contable_egresoParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_egresoParametroConta() {
		return this.cargarid_cuenta_contable_egresoParametroConta;
	}

	public void setCargarid_cuenta_contable_egresoParametroConta(Boolean cargarid_cuenta_contable_egresoParametroConta) {
		this.cargarid_cuenta_contable_egresoParametroConta= cargarid_cuenta_contable_egresoParametroConta;
	}

	public Border setResaltarid_cuenta_contable_resumenParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_resumenParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_resumenParametroConta() {
		return this.resaltarid_cuenta_contable_resumenParametroConta;
	}

	public void setResaltarid_cuenta_contable_resumenParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_resumenParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_resumenParametroConta() {
		return this.mostrarid_cuenta_contable_resumenParametroConta;
	}

	public void setMostrarid_cuenta_contable_resumenParametroConta(Boolean mostrarid_cuenta_contable_resumenParametroConta) {
		this.mostrarid_cuenta_contable_resumenParametroConta= mostrarid_cuenta_contable_resumenParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_resumenParametroConta() {
		return this.activarid_cuenta_contable_resumenParametroConta;
	}

	public void setActivarid_cuenta_contable_resumenParametroConta(Boolean activarid_cuenta_contable_resumenParametroConta) {
		this.activarid_cuenta_contable_resumenParametroConta= activarid_cuenta_contable_resumenParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_resumenParametroConta() {
		return this.cargarid_cuenta_contable_resumenParametroConta;
	}

	public void setCargarid_cuenta_contable_resumenParametroConta(Boolean cargarid_cuenta_contable_resumenParametroConta) {
		this.cargarid_cuenta_contable_resumenParametroConta= cargarid_cuenta_contable_resumenParametroConta;
	}

	public Border setResaltarid_cuenta_contable_deudorParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_deudorParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_deudorParametroConta() {
		return this.resaltarid_cuenta_contable_deudorParametroConta;
	}

	public void setResaltarid_cuenta_contable_deudorParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_deudorParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_deudorParametroConta() {
		return this.mostrarid_cuenta_contable_deudorParametroConta;
	}

	public void setMostrarid_cuenta_contable_deudorParametroConta(Boolean mostrarid_cuenta_contable_deudorParametroConta) {
		this.mostrarid_cuenta_contable_deudorParametroConta= mostrarid_cuenta_contable_deudorParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_deudorParametroConta() {
		return this.activarid_cuenta_contable_deudorParametroConta;
	}

	public void setActivarid_cuenta_contable_deudorParametroConta(Boolean activarid_cuenta_contable_deudorParametroConta) {
		this.activarid_cuenta_contable_deudorParametroConta= activarid_cuenta_contable_deudorParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_deudorParametroConta() {
		return this.cargarid_cuenta_contable_deudorParametroConta;
	}

	public void setCargarid_cuenta_contable_deudorParametroConta(Boolean cargarid_cuenta_contable_deudorParametroConta) {
		this.cargarid_cuenta_contable_deudorParametroConta= cargarid_cuenta_contable_deudorParametroConta;
	}

	public Border setResaltarid_cuenta_contable_acreedorParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_acreedorParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_acreedorParametroConta() {
		return this.resaltarid_cuenta_contable_acreedorParametroConta;
	}

	public void setResaltarid_cuenta_contable_acreedorParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_acreedorParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_acreedorParametroConta() {
		return this.mostrarid_cuenta_contable_acreedorParametroConta;
	}

	public void setMostrarid_cuenta_contable_acreedorParametroConta(Boolean mostrarid_cuenta_contable_acreedorParametroConta) {
		this.mostrarid_cuenta_contable_acreedorParametroConta= mostrarid_cuenta_contable_acreedorParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_acreedorParametroConta() {
		return this.activarid_cuenta_contable_acreedorParametroConta;
	}

	public void setActivarid_cuenta_contable_acreedorParametroConta(Boolean activarid_cuenta_contable_acreedorParametroConta) {
		this.activarid_cuenta_contable_acreedorParametroConta= activarid_cuenta_contable_acreedorParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_acreedorParametroConta() {
		return this.cargarid_cuenta_contable_acreedorParametroConta;
	}

	public void setCargarid_cuenta_contable_acreedorParametroConta(Boolean cargarid_cuenta_contable_acreedorParametroConta) {
		this.cargarid_cuenta_contable_acreedorParametroConta= cargarid_cuenta_contable_acreedorParametroConta;
	}

	public Border setResaltarid_cuenta_contable_ingreso1ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ingreso1ParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ingreso1ParametroConta() {
		return this.resaltarid_cuenta_contable_ingreso1ParametroConta;
	}

	public void setResaltarid_cuenta_contable_ingreso1ParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ingreso1ParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ingreso1ParametroConta() {
		return this.mostrarid_cuenta_contable_ingreso1ParametroConta;
	}

	public void setMostrarid_cuenta_contable_ingreso1ParametroConta(Boolean mostrarid_cuenta_contable_ingreso1ParametroConta) {
		this.mostrarid_cuenta_contable_ingreso1ParametroConta= mostrarid_cuenta_contable_ingreso1ParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_ingreso1ParametroConta() {
		return this.activarid_cuenta_contable_ingreso1ParametroConta;
	}

	public void setActivarid_cuenta_contable_ingreso1ParametroConta(Boolean activarid_cuenta_contable_ingreso1ParametroConta) {
		this.activarid_cuenta_contable_ingreso1ParametroConta= activarid_cuenta_contable_ingreso1ParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_ingreso1ParametroConta() {
		return this.cargarid_cuenta_contable_ingreso1ParametroConta;
	}

	public void setCargarid_cuenta_contable_ingreso1ParametroConta(Boolean cargarid_cuenta_contable_ingreso1ParametroConta) {
		this.cargarid_cuenta_contable_ingreso1ParametroConta= cargarid_cuenta_contable_ingreso1ParametroConta;
	}

	public Border setResaltarid_cuenta_contable_ingreso2ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ingreso2ParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ingreso2ParametroConta() {
		return this.resaltarid_cuenta_contable_ingreso2ParametroConta;
	}

	public void setResaltarid_cuenta_contable_ingreso2ParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ingreso2ParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ingreso2ParametroConta() {
		return this.mostrarid_cuenta_contable_ingreso2ParametroConta;
	}

	public void setMostrarid_cuenta_contable_ingreso2ParametroConta(Boolean mostrarid_cuenta_contable_ingreso2ParametroConta) {
		this.mostrarid_cuenta_contable_ingreso2ParametroConta= mostrarid_cuenta_contable_ingreso2ParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_ingreso2ParametroConta() {
		return this.activarid_cuenta_contable_ingreso2ParametroConta;
	}

	public void setActivarid_cuenta_contable_ingreso2ParametroConta(Boolean activarid_cuenta_contable_ingreso2ParametroConta) {
		this.activarid_cuenta_contable_ingreso2ParametroConta= activarid_cuenta_contable_ingreso2ParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_ingreso2ParametroConta() {
		return this.cargarid_cuenta_contable_ingreso2ParametroConta;
	}

	public void setCargarid_cuenta_contable_ingreso2ParametroConta(Boolean cargarid_cuenta_contable_ingreso2ParametroConta) {
		this.cargarid_cuenta_contable_ingreso2ParametroConta= cargarid_cuenta_contable_ingreso2ParametroConta;
	}

	public Border setResaltarid_cuenta_contable_ingreso3ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_ingreso3ParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_ingreso3ParametroConta() {
		return this.resaltarid_cuenta_contable_ingreso3ParametroConta;
	}

	public void setResaltarid_cuenta_contable_ingreso3ParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_ingreso3ParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_ingreso3ParametroConta() {
		return this.mostrarid_cuenta_contable_ingreso3ParametroConta;
	}

	public void setMostrarid_cuenta_contable_ingreso3ParametroConta(Boolean mostrarid_cuenta_contable_ingreso3ParametroConta) {
		this.mostrarid_cuenta_contable_ingreso3ParametroConta= mostrarid_cuenta_contable_ingreso3ParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_ingreso3ParametroConta() {
		return this.activarid_cuenta_contable_ingreso3ParametroConta;
	}

	public void setActivarid_cuenta_contable_ingreso3ParametroConta(Boolean activarid_cuenta_contable_ingreso3ParametroConta) {
		this.activarid_cuenta_contable_ingreso3ParametroConta= activarid_cuenta_contable_ingreso3ParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_ingreso3ParametroConta() {
		return this.cargarid_cuenta_contable_ingreso3ParametroConta;
	}

	public void setCargarid_cuenta_contable_ingreso3ParametroConta(Boolean cargarid_cuenta_contable_ingreso3ParametroConta) {
		this.cargarid_cuenta_contable_ingreso3ParametroConta= cargarid_cuenta_contable_ingreso3ParametroConta;
	}

	public Border setResaltarid_cuenta_contable_egreso1ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_egreso1ParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_egreso1ParametroConta() {
		return this.resaltarid_cuenta_contable_egreso1ParametroConta;
	}

	public void setResaltarid_cuenta_contable_egreso1ParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_egreso1ParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_egreso1ParametroConta() {
		return this.mostrarid_cuenta_contable_egreso1ParametroConta;
	}

	public void setMostrarid_cuenta_contable_egreso1ParametroConta(Boolean mostrarid_cuenta_contable_egreso1ParametroConta) {
		this.mostrarid_cuenta_contable_egreso1ParametroConta= mostrarid_cuenta_contable_egreso1ParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_egreso1ParametroConta() {
		return this.activarid_cuenta_contable_egreso1ParametroConta;
	}

	public void setActivarid_cuenta_contable_egreso1ParametroConta(Boolean activarid_cuenta_contable_egreso1ParametroConta) {
		this.activarid_cuenta_contable_egreso1ParametroConta= activarid_cuenta_contable_egreso1ParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_egreso1ParametroConta() {
		return this.cargarid_cuenta_contable_egreso1ParametroConta;
	}

	public void setCargarid_cuenta_contable_egreso1ParametroConta(Boolean cargarid_cuenta_contable_egreso1ParametroConta) {
		this.cargarid_cuenta_contable_egreso1ParametroConta= cargarid_cuenta_contable_egreso1ParametroConta;
	}

	public Border setResaltarid_cuenta_contable_egreso2ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_egreso2ParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_egreso2ParametroConta() {
		return this.resaltarid_cuenta_contable_egreso2ParametroConta;
	}

	public void setResaltarid_cuenta_contable_egreso2ParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_egreso2ParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_egreso2ParametroConta() {
		return this.mostrarid_cuenta_contable_egreso2ParametroConta;
	}

	public void setMostrarid_cuenta_contable_egreso2ParametroConta(Boolean mostrarid_cuenta_contable_egreso2ParametroConta) {
		this.mostrarid_cuenta_contable_egreso2ParametroConta= mostrarid_cuenta_contable_egreso2ParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_egreso2ParametroConta() {
		return this.activarid_cuenta_contable_egreso2ParametroConta;
	}

	public void setActivarid_cuenta_contable_egreso2ParametroConta(Boolean activarid_cuenta_contable_egreso2ParametroConta) {
		this.activarid_cuenta_contable_egreso2ParametroConta= activarid_cuenta_contable_egreso2ParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_egreso2ParametroConta() {
		return this.cargarid_cuenta_contable_egreso2ParametroConta;
	}

	public void setCargarid_cuenta_contable_egreso2ParametroConta(Boolean cargarid_cuenta_contable_egreso2ParametroConta) {
		this.cargarid_cuenta_contable_egreso2ParametroConta= cargarid_cuenta_contable_egreso2ParametroConta;
	}

	public Border setResaltarid_cuenta_contable_egreso3ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_egreso3ParametroConta= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_egreso3ParametroConta() {
		return this.resaltarid_cuenta_contable_egreso3ParametroConta;
	}

	public void setResaltarid_cuenta_contable_egreso3ParametroConta(Border borderResaltar) {
		this.resaltarid_cuenta_contable_egreso3ParametroConta= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_egreso3ParametroConta() {
		return this.mostrarid_cuenta_contable_egreso3ParametroConta;
	}

	public void setMostrarid_cuenta_contable_egreso3ParametroConta(Boolean mostrarid_cuenta_contable_egreso3ParametroConta) {
		this.mostrarid_cuenta_contable_egreso3ParametroConta= mostrarid_cuenta_contable_egreso3ParametroConta;
	}

	public Boolean getActivarid_cuenta_contable_egreso3ParametroConta() {
		return this.activarid_cuenta_contable_egreso3ParametroConta;
	}

	public void setActivarid_cuenta_contable_egreso3ParametroConta(Boolean activarid_cuenta_contable_egreso3ParametroConta) {
		this.activarid_cuenta_contable_egreso3ParametroConta= activarid_cuenta_contable_egreso3ParametroConta;
	}

	public Boolean getCargarid_cuenta_contable_egreso3ParametroConta() {
		return this.cargarid_cuenta_contable_egreso3ParametroConta;
	}

	public void setCargarid_cuenta_contable_egreso3ParametroConta(Boolean cargarid_cuenta_contable_egreso3ParametroConta) {
		this.cargarid_cuenta_contable_egreso3ParametroConta= cargarid_cuenta_contable_egreso3ParametroConta;
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
		
		
		this.setMostraridParametroConta(esInicial);
		this.setMostrarid_empresaParametroConta(esInicial);
		this.setMostrarid_monedaParametroConta(esInicial);
		this.setMostrarid_moneda_extranjeraParametroConta(esInicial);
		this.setMostrarcon_mascaraParametroConta(esInicial);
		this.setMostrarnumero_nivelParametroConta(esInicial);
		this.setMostrares_presupuestoParametroConta(esInicial);
		this.setMostrares_loteParametroConta(esInicial);
		this.setMostrarcon_secuencial_automaticoParametroConta(esInicial);
		this.setMostrarcon_cuentas_niffParametroConta(esInicial);
		this.setMostrarcon_centro_costo_mascaraParametroConta(esInicial);
		this.setMostrarcon_centro_costo_nueva_estructuraParametroConta(esInicial);
		this.setMostrarcentro_costo_numero_nivelParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_activoParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_pasivoParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_patrimonioParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_ingresoParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_egresoParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_resumenParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_deudorParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_acreedorParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_ingreso1ParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_ingreso2ParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_ingreso3ParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_egreso1ParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_egreso2ParametroConta(esInicial);
		this.setMostrarid_cuenta_contable_egreso3ParametroConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContaConstantesFunciones.ID)) {
				this.setMostraridParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA)) {
				this.setMostrarid_moneda_extranjeraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONMASCARA)) {
				this.setMostrarcon_mascaraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.NUMERONIVEL)) {
				this.setMostrarnumero_nivelParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.ESPRESUPUESTO)) {
				this.setMostrares_presupuestoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.ESLOTE)) {
				this.setMostrares_loteParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO)) {
				this.setMostrarcon_secuencial_automaticoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCUENTASNIFF)) {
				this.setMostrarcon_cuentas_niffParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA)) {
				this.setMostrarcon_centro_costo_mascaraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA)) {
				this.setMostrarcon_centro_costo_nueva_estructuraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL)) {
				this.setMostrarcentro_costo_numero_nivelParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO)) {
				this.setMostrarid_cuenta_contable_activoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO)) {
				this.setMostrarid_cuenta_contable_pasivoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO)) {
				this.setMostrarid_cuenta_contable_patrimonioParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO)) {
				this.setMostrarid_cuenta_contable_ingresoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO)) {
				this.setMostrarid_cuenta_contable_egresoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN)) {
				this.setMostrarid_cuenta_contable_resumenParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR)) {
				this.setMostrarid_cuenta_contable_deudorParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR)) {
				this.setMostrarid_cuenta_contable_acreedorParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1)) {
				this.setMostrarid_cuenta_contable_ingreso1ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2)) {
				this.setMostrarid_cuenta_contable_ingreso2ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3)) {
				this.setMostrarid_cuenta_contable_ingreso3ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1)) {
				this.setMostrarid_cuenta_contable_egreso1ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2)) {
				this.setMostrarid_cuenta_contable_egreso2ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3)) {
				this.setMostrarid_cuenta_contable_egreso3ParametroConta(esAsigna);
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
		
		
		this.setActivaridParametroConta(esInicial);
		this.setActivarid_empresaParametroConta(esInicial);
		this.setActivarid_monedaParametroConta(esInicial);
		this.setActivarid_moneda_extranjeraParametroConta(esInicial);
		this.setActivarcon_mascaraParametroConta(esInicial);
		this.setActivarnumero_nivelParametroConta(esInicial);
		this.setActivares_presupuestoParametroConta(esInicial);
		this.setActivares_loteParametroConta(esInicial);
		this.setActivarcon_secuencial_automaticoParametroConta(esInicial);
		this.setActivarcon_cuentas_niffParametroConta(esInicial);
		this.setActivarcon_centro_costo_mascaraParametroConta(esInicial);
		this.setActivarcon_centro_costo_nueva_estructuraParametroConta(esInicial);
		this.setActivarcentro_costo_numero_nivelParametroConta(esInicial);
		this.setActivarid_cuenta_contable_activoParametroConta(esInicial);
		this.setActivarid_cuenta_contable_pasivoParametroConta(esInicial);
		this.setActivarid_cuenta_contable_patrimonioParametroConta(esInicial);
		this.setActivarid_cuenta_contable_ingresoParametroConta(esInicial);
		this.setActivarid_cuenta_contable_egresoParametroConta(esInicial);
		this.setActivarid_cuenta_contable_resumenParametroConta(esInicial);
		this.setActivarid_cuenta_contable_deudorParametroConta(esInicial);
		this.setActivarid_cuenta_contable_acreedorParametroConta(esInicial);
		this.setActivarid_cuenta_contable_ingreso1ParametroConta(esInicial);
		this.setActivarid_cuenta_contable_ingreso2ParametroConta(esInicial);
		this.setActivarid_cuenta_contable_ingreso3ParametroConta(esInicial);
		this.setActivarid_cuenta_contable_egreso1ParametroConta(esInicial);
		this.setActivarid_cuenta_contable_egreso2ParametroConta(esInicial);
		this.setActivarid_cuenta_contable_egreso3ParametroConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContaConstantesFunciones.ID)) {
				this.setActivaridParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA)) {
				this.setActivarid_moneda_extranjeraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONMASCARA)) {
				this.setActivarcon_mascaraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.NUMERONIVEL)) {
				this.setActivarnumero_nivelParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.ESPRESUPUESTO)) {
				this.setActivares_presupuestoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.ESLOTE)) {
				this.setActivares_loteParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO)) {
				this.setActivarcon_secuencial_automaticoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCUENTASNIFF)) {
				this.setActivarcon_cuentas_niffParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA)) {
				this.setActivarcon_centro_costo_mascaraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA)) {
				this.setActivarcon_centro_costo_nueva_estructuraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL)) {
				this.setActivarcentro_costo_numero_nivelParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO)) {
				this.setActivarid_cuenta_contable_activoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO)) {
				this.setActivarid_cuenta_contable_pasivoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO)) {
				this.setActivarid_cuenta_contable_patrimonioParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO)) {
				this.setActivarid_cuenta_contable_ingresoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO)) {
				this.setActivarid_cuenta_contable_egresoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN)) {
				this.setActivarid_cuenta_contable_resumenParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR)) {
				this.setActivarid_cuenta_contable_deudorParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR)) {
				this.setActivarid_cuenta_contable_acreedorParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1)) {
				this.setActivarid_cuenta_contable_ingreso1ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2)) {
				this.setActivarid_cuenta_contable_ingreso2ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3)) {
				this.setActivarid_cuenta_contable_ingreso3ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1)) {
				this.setActivarid_cuenta_contable_egreso1ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2)) {
				this.setActivarid_cuenta_contable_egreso2ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3)) {
				this.setActivarid_cuenta_contable_egreso3ParametroConta(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroConta(esInicial);
		this.setResaltarid_empresaParametroConta(esInicial);
		this.setResaltarid_monedaParametroConta(esInicial);
		this.setResaltarid_moneda_extranjeraParametroConta(esInicial);
		this.setResaltarcon_mascaraParametroConta(esInicial);
		this.setResaltarnumero_nivelParametroConta(esInicial);
		this.setResaltares_presupuestoParametroConta(esInicial);
		this.setResaltares_loteParametroConta(esInicial);
		this.setResaltarcon_secuencial_automaticoParametroConta(esInicial);
		this.setResaltarcon_cuentas_niffParametroConta(esInicial);
		this.setResaltarcon_centro_costo_mascaraParametroConta(esInicial);
		this.setResaltarcon_centro_costo_nueva_estructuraParametroConta(esInicial);
		this.setResaltarcentro_costo_numero_nivelParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_activoParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_pasivoParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_patrimonioParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_ingresoParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_egresoParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_resumenParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_deudorParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_acreedorParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_ingreso1ParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_ingreso2ParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_ingreso3ParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_egreso1ParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_egreso2ParametroConta(esInicial);
		this.setResaltarid_cuenta_contable_egreso3ParametroConta(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroContaConstantesFunciones.ID)) {
				this.setResaltaridParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA)) {
				this.setResaltarid_moneda_extranjeraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONMASCARA)) {
				this.setResaltarcon_mascaraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.NUMERONIVEL)) {
				this.setResaltarnumero_nivelParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.ESPRESUPUESTO)) {
				this.setResaltares_presupuestoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.ESLOTE)) {
				this.setResaltares_loteParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO)) {
				this.setResaltarcon_secuencial_automaticoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCUENTASNIFF)) {
				this.setResaltarcon_cuentas_niffParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA)) {
				this.setResaltarcon_centro_costo_mascaraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA)) {
				this.setResaltarcon_centro_costo_nueva_estructuraParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL)) {
				this.setResaltarcentro_costo_numero_nivelParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO)) {
				this.setResaltarid_cuenta_contable_activoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO)) {
				this.setResaltarid_cuenta_contable_pasivoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO)) {
				this.setResaltarid_cuenta_contable_patrimonioParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO)) {
				this.setResaltarid_cuenta_contable_ingresoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO)) {
				this.setResaltarid_cuenta_contable_egresoParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN)) {
				this.setResaltarid_cuenta_contable_resumenParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR)) {
				this.setResaltarid_cuenta_contable_deudorParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR)) {
				this.setResaltarid_cuenta_contable_acreedorParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1)) {
				this.setResaltarid_cuenta_contable_ingreso1ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2)) {
				this.setResaltarid_cuenta_contable_ingreso2ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3)) {
				this.setResaltarid_cuenta_contable_ingreso3ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1)) {
				this.setResaltarid_cuenta_contable_egreso1ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2)) {
				this.setResaltarid_cuenta_contable_egreso2ParametroConta(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3)) {
				this.setResaltarid_cuenta_contable_egreso3ParametroConta(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroContaDetalleParametroConta=null;

	public Border getResaltarParametroContaDetalleParametroConta() {
		return this.resaltarParametroContaDetalleParametroConta;
	}

	public void setResaltarParametroContaDetalleParametroConta(Border borderResaltarParametroContaDetalle) {
		if(borderResaltarParametroContaDetalle!=null) {
			this.resaltarParametroContaDetalleParametroConta= borderResaltarParametroContaDetalle;
		}
	}

	public Border setResaltarParametroContaDetalleParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroContaDetalle=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//parametrocontaBeanSwingJInternalFrame.jTtoolBarParametroConta.setBorder(borderResaltarParametroContaDetalle);
			
		this.resaltarParametroContaDetalleParametroConta= borderResaltarParametroContaDetalle;

		 return borderResaltarParametroContaDetalle;
	}



	public Boolean mostrarParametroContaDetalleParametroConta=true;

	public Boolean getMostrarParametroContaDetalleParametroConta() {
		return this.mostrarParametroContaDetalleParametroConta;
	}

	public void setMostrarParametroContaDetalleParametroConta(Boolean visibilidadResaltarParametroContaDetalle) {
		this.mostrarParametroContaDetalleParametroConta= visibilidadResaltarParametroContaDetalle;
	}



	public Boolean activarParametroContaDetalleParametroConta=true;

	public Boolean gethabilitarResaltarParametroContaDetalleParametroConta() {
		return this.activarParametroContaDetalleParametroConta;
	}

	public void setActivarParametroContaDetalleParametroConta(Boolean habilitarResaltarParametroContaDetalle) {
		this.activarParametroContaDetalleParametroConta= habilitarResaltarParametroContaDetalle;
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

		this.setMostrarParametroContaDetalleParametroConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContaDetalle.class)) {
				this.setMostrarParametroContaDetalleParametroConta(esAsigna);
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

		this.setActivarParametroContaDetalleParametroConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContaDetalle.class)) {
				this.setActivarParametroContaDetalleParametroConta(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroContaDetalleParametroConta(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroContaDetalle.class)) {
				this.setResaltarParametroContaDetalleParametroConta(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCuentaContableAcreedorParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableAcreedorParametroConta() {
		return this.mostrarFK_IdCuentaContableAcreedorParametroConta;
	}

	public void setMostrarFK_IdCuentaContableAcreedorParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableAcreedorParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableActivoParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableActivoParametroConta() {
		return this.mostrarFK_IdCuentaContableActivoParametroConta;
	}

	public void setMostrarFK_IdCuentaContableActivoParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableActivoParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDeudorParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableDeudorParametroConta() {
		return this.mostrarFK_IdCuentaContableDeudorParametroConta;
	}

	public void setMostrarFK_IdCuentaContableDeudorParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDeudorParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableEgresoParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableEgresoParametroConta() {
		return this.mostrarFK_IdCuentaContableEgresoParametroConta;
	}

	public void setMostrarFK_IdCuentaContableEgresoParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableEgresoParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableEgreso1ParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableEgreso1ParametroConta() {
		return this.mostrarFK_IdCuentaContableEgreso1ParametroConta;
	}

	public void setMostrarFK_IdCuentaContableEgreso1ParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableEgreso1ParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableEgreso2ParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableEgreso2ParametroConta() {
		return this.mostrarFK_IdCuentaContableEgreso2ParametroConta;
	}

	public void setMostrarFK_IdCuentaContableEgreso2ParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableEgreso2ParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableEgreso3ParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableEgreso3ParametroConta() {
		return this.mostrarFK_IdCuentaContableEgreso3ParametroConta;
	}

	public void setMostrarFK_IdCuentaContableEgreso3ParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableEgreso3ParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIngresoParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableIngresoParametroConta() {
		return this.mostrarFK_IdCuentaContableIngresoParametroConta;
	}

	public void setMostrarFK_IdCuentaContableIngresoParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIngresoParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIngreso1ParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableIngreso1ParametroConta() {
		return this.mostrarFK_IdCuentaContableIngreso1ParametroConta;
	}

	public void setMostrarFK_IdCuentaContableIngreso1ParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIngreso1ParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIngreso2ParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableIngreso2ParametroConta() {
		return this.mostrarFK_IdCuentaContableIngreso2ParametroConta;
	}

	public void setMostrarFK_IdCuentaContableIngreso2ParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIngreso2ParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableIngreso3ParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableIngreso3ParametroConta() {
		return this.mostrarFK_IdCuentaContableIngreso3ParametroConta;
	}

	public void setMostrarFK_IdCuentaContableIngreso3ParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableIngreso3ParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePasivoParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContablePasivoParametroConta() {
		return this.mostrarFK_IdCuentaContablePasivoParametroConta;
	}

	public void setMostrarFK_IdCuentaContablePasivoParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePasivoParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContablePatrimonioParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContablePatrimonioParametroConta() {
		return this.mostrarFK_IdCuentaContablePatrimonioParametroConta;
	}

	public void setMostrarFK_IdCuentaContablePatrimonioParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContablePatrimonioParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableResumenParametroConta=true;

	public Boolean getMostrarFK_IdCuentaContableResumenParametroConta() {
		return this.mostrarFK_IdCuentaContableResumenParametroConta;
	}

	public void setMostrarFK_IdCuentaContableResumenParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableResumenParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaParametroConta=true;

	public Boolean getMostrarFK_IdEmpresaParametroConta() {
		return this.mostrarFK_IdEmpresaParametroConta;
	}

	public void setMostrarFK_IdEmpresaParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaParametroConta=true;

	public Boolean getMostrarFK_IdMonedaParametroConta() {
		return this.mostrarFK_IdMonedaParametroConta;
	}

	public void setMostrarFK_IdMonedaParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaParametroConta= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaExtranjeraParametroConta=true;

	public Boolean getMostrarFK_IdMonedaExtranjeraParametroConta() {
		return this.mostrarFK_IdMonedaExtranjeraParametroConta;
	}

	public void setMostrarFK_IdMonedaExtranjeraParametroConta(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaExtranjeraParametroConta= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableAcreedorParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableAcreedorParametroConta() {
		return this.activarFK_IdCuentaContableAcreedorParametroConta;
	}

	public void setActivarFK_IdCuentaContableAcreedorParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableAcreedorParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableActivoParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableActivoParametroConta() {
		return this.activarFK_IdCuentaContableActivoParametroConta;
	}

	public void setActivarFK_IdCuentaContableActivoParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableActivoParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDeudorParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableDeudorParametroConta() {
		return this.activarFK_IdCuentaContableDeudorParametroConta;
	}

	public void setActivarFK_IdCuentaContableDeudorParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDeudorParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableEgresoParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableEgresoParametroConta() {
		return this.activarFK_IdCuentaContableEgresoParametroConta;
	}

	public void setActivarFK_IdCuentaContableEgresoParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableEgresoParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableEgreso1ParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableEgreso1ParametroConta() {
		return this.activarFK_IdCuentaContableEgreso1ParametroConta;
	}

	public void setActivarFK_IdCuentaContableEgreso1ParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableEgreso1ParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableEgreso2ParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableEgreso2ParametroConta() {
		return this.activarFK_IdCuentaContableEgreso2ParametroConta;
	}

	public void setActivarFK_IdCuentaContableEgreso2ParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableEgreso2ParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableEgreso3ParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableEgreso3ParametroConta() {
		return this.activarFK_IdCuentaContableEgreso3ParametroConta;
	}

	public void setActivarFK_IdCuentaContableEgreso3ParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableEgreso3ParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIngresoParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableIngresoParametroConta() {
		return this.activarFK_IdCuentaContableIngresoParametroConta;
	}

	public void setActivarFK_IdCuentaContableIngresoParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIngresoParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIngreso1ParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableIngreso1ParametroConta() {
		return this.activarFK_IdCuentaContableIngreso1ParametroConta;
	}

	public void setActivarFK_IdCuentaContableIngreso1ParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIngreso1ParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIngreso2ParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableIngreso2ParametroConta() {
		return this.activarFK_IdCuentaContableIngreso2ParametroConta;
	}

	public void setActivarFK_IdCuentaContableIngreso2ParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIngreso2ParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableIngreso3ParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableIngreso3ParametroConta() {
		return this.activarFK_IdCuentaContableIngreso3ParametroConta;
	}

	public void setActivarFK_IdCuentaContableIngreso3ParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableIngreso3ParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePasivoParametroConta=true;

	public Boolean getActivarFK_IdCuentaContablePasivoParametroConta() {
		return this.activarFK_IdCuentaContablePasivoParametroConta;
	}

	public void setActivarFK_IdCuentaContablePasivoParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePasivoParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContablePatrimonioParametroConta=true;

	public Boolean getActivarFK_IdCuentaContablePatrimonioParametroConta() {
		return this.activarFK_IdCuentaContablePatrimonioParametroConta;
	}

	public void setActivarFK_IdCuentaContablePatrimonioParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContablePatrimonioParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableResumenParametroConta=true;

	public Boolean getActivarFK_IdCuentaContableResumenParametroConta() {
		return this.activarFK_IdCuentaContableResumenParametroConta;
	}

	public void setActivarFK_IdCuentaContableResumenParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableResumenParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaParametroConta=true;

	public Boolean getActivarFK_IdEmpresaParametroConta() {
		return this.activarFK_IdEmpresaParametroConta;
	}

	public void setActivarFK_IdEmpresaParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaParametroConta=true;

	public Boolean getActivarFK_IdMonedaParametroConta() {
		return this.activarFK_IdMonedaParametroConta;
	}

	public void setActivarFK_IdMonedaParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaParametroConta= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaExtranjeraParametroConta=true;

	public Boolean getActivarFK_IdMonedaExtranjeraParametroConta() {
		return this.activarFK_IdMonedaExtranjeraParametroConta;
	}

	public void setActivarFK_IdMonedaExtranjeraParametroConta(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaExtranjeraParametroConta= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableAcreedorParametroConta=null;

	public Border getResaltarFK_IdCuentaContableAcreedorParametroConta() {
		return this.resaltarFK_IdCuentaContableAcreedorParametroConta;
	}

	public void setResaltarFK_IdCuentaContableAcreedorParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableAcreedorParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableAcreedorParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableAcreedorParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableActivoParametroConta=null;

	public Border getResaltarFK_IdCuentaContableActivoParametroConta() {
		return this.resaltarFK_IdCuentaContableActivoParametroConta;
	}

	public void setResaltarFK_IdCuentaContableActivoParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableActivoParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableActivoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableActivoParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDeudorParametroConta=null;

	public Border getResaltarFK_IdCuentaContableDeudorParametroConta() {
		return this.resaltarFK_IdCuentaContableDeudorParametroConta;
	}

	public void setResaltarFK_IdCuentaContableDeudorParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDeudorParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDeudorParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDeudorParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableEgresoParametroConta=null;

	public Border getResaltarFK_IdCuentaContableEgresoParametroConta() {
		return this.resaltarFK_IdCuentaContableEgresoParametroConta;
	}

	public void setResaltarFK_IdCuentaContableEgresoParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableEgresoParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableEgresoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableEgresoParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableEgreso1ParametroConta=null;

	public Border getResaltarFK_IdCuentaContableEgreso1ParametroConta() {
		return this.resaltarFK_IdCuentaContableEgreso1ParametroConta;
	}

	public void setResaltarFK_IdCuentaContableEgreso1ParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableEgreso1ParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableEgreso1ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableEgreso1ParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableEgreso2ParametroConta=null;

	public Border getResaltarFK_IdCuentaContableEgreso2ParametroConta() {
		return this.resaltarFK_IdCuentaContableEgreso2ParametroConta;
	}

	public void setResaltarFK_IdCuentaContableEgreso2ParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableEgreso2ParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableEgreso2ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableEgreso2ParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableEgreso3ParametroConta=null;

	public Border getResaltarFK_IdCuentaContableEgreso3ParametroConta() {
		return this.resaltarFK_IdCuentaContableEgreso3ParametroConta;
	}

	public void setResaltarFK_IdCuentaContableEgreso3ParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableEgreso3ParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableEgreso3ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableEgreso3ParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIngresoParametroConta=null;

	public Border getResaltarFK_IdCuentaContableIngresoParametroConta() {
		return this.resaltarFK_IdCuentaContableIngresoParametroConta;
	}

	public void setResaltarFK_IdCuentaContableIngresoParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIngresoParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIngresoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIngresoParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIngreso1ParametroConta=null;

	public Border getResaltarFK_IdCuentaContableIngreso1ParametroConta() {
		return this.resaltarFK_IdCuentaContableIngreso1ParametroConta;
	}

	public void setResaltarFK_IdCuentaContableIngreso1ParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIngreso1ParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIngreso1ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIngreso1ParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIngreso2ParametroConta=null;

	public Border getResaltarFK_IdCuentaContableIngreso2ParametroConta() {
		return this.resaltarFK_IdCuentaContableIngreso2ParametroConta;
	}

	public void setResaltarFK_IdCuentaContableIngreso2ParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIngreso2ParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIngreso2ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIngreso2ParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableIngreso3ParametroConta=null;

	public Border getResaltarFK_IdCuentaContableIngreso3ParametroConta() {
		return this.resaltarFK_IdCuentaContableIngreso3ParametroConta;
	}

	public void setResaltarFK_IdCuentaContableIngreso3ParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableIngreso3ParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableIngreso3ParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableIngreso3ParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePasivoParametroConta=null;

	public Border getResaltarFK_IdCuentaContablePasivoParametroConta() {
		return this.resaltarFK_IdCuentaContablePasivoParametroConta;
	}

	public void setResaltarFK_IdCuentaContablePasivoParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePasivoParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePasivoParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePasivoParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContablePatrimonioParametroConta=null;

	public Border getResaltarFK_IdCuentaContablePatrimonioParametroConta() {
		return this.resaltarFK_IdCuentaContablePatrimonioParametroConta;
	}

	public void setResaltarFK_IdCuentaContablePatrimonioParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContablePatrimonioParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContablePatrimonioParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContablePatrimonioParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableResumenParametroConta=null;

	public Border getResaltarFK_IdCuentaContableResumenParametroConta() {
		return this.resaltarFK_IdCuentaContableResumenParametroConta;
	}

	public void setResaltarFK_IdCuentaContableResumenParametroConta(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableResumenParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableResumenParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableResumenParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaParametroConta=null;

	public Border getResaltarFK_IdEmpresaParametroConta() {
		return this.resaltarFK_IdEmpresaParametroConta;
	}

	public void setResaltarFK_IdEmpresaParametroConta(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdMonedaParametroConta=null;

	public Border getResaltarFK_IdMonedaParametroConta() {
		return this.resaltarFK_IdMonedaParametroConta;
	}

	public void setResaltarFK_IdMonedaParametroConta(Border borderResaltar) {
		this.resaltarFK_IdMonedaParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdMonedaParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaParametroConta= borderResaltar;
	}

	public Border resaltarFK_IdMonedaExtranjeraParametroConta=null;

	public Border getResaltarFK_IdMonedaExtranjeraParametroConta() {
		return this.resaltarFK_IdMonedaExtranjeraParametroConta;
	}

	public void setResaltarFK_IdMonedaExtranjeraParametroConta(Border borderResaltar) {
		this.resaltarFK_IdMonedaExtranjeraParametroConta= borderResaltar;
	}

	public void setResaltarFK_IdMonedaExtranjeraParametroConta(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroContaBeanSwingJInternalFrame parametrocontaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaExtranjeraParametroConta= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}