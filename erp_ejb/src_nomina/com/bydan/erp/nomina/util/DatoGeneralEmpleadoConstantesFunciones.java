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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.DatoGeneralEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.DatoGeneralEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DatoGeneralEmpleadoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DatoGeneralEmpleadoConstantesFunciones extends DatoGeneralEmpleadoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DatoGeneralEmpleado";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DatoGeneralEmpleado"+DatoGeneralEmpleadoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DatoGeneralEmpleadoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DatoGeneralEmpleadoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"_"+DatoGeneralEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DatoGeneralEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"_"+DatoGeneralEmpleadoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"_"+DatoGeneralEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DatoGeneralEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"_"+DatoGeneralEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoGeneralEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoGeneralEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoGeneralEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoGeneralEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DatoGeneralEmpleadoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DatoGeneralEmpleadoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DatoGeneralEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DatoGeneralEmpleadoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DatoGeneralEmpleadoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DatoGeneralEmpleadoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Dato General Empleados";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Dato General Empleado";
	public static final String SCLASSWEBTITULO_LOWER="Dato General Empleado";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DatoGeneralEmpleado";
	public static final String OBJECTNAME="datogeneralempleado";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="dato_general_empleado";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select datogeneralempleado from "+DatoGeneralEmpleadoConstantesFunciones.SPERSISTENCENAME+" datogeneralempleado";
	public static String QUERYSELECTNATIVE="select "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".version_row,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_numero_patronal,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_afiliacion,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".carnet_iess,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".sectorial_iess,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_pais,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_provincia,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_canton,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_parroquia,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".fecha_nacimiento,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".fecha_fallece,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor_evaluacion,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".numero_horas,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor_hora,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".salario,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_moneda,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".numero_contrato,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_contrato,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor1,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor2,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor3,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor4,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor5,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".valor6,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_aporta_seguro_social,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_recibe_horas_extras,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_descuento_impuestos,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".pension_alimenticia,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_pago_por_horas,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".con_anticipo,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_libreta_mili,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".libreta_militar,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_grupo_forma_pago,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_banco,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".numero_cuenta,"+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME+".id_tipo_sangre from "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+"."+DatoGeneralEmpleadoConstantesFunciones.TABLENAME;//+" as "+DatoGeneralEmpleadoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DatoGeneralEmpleadoConstantesFuncionesAdditional datogeneralempleadoConstantesFuncionesAdditional=null;
	
	public DatoGeneralEmpleadoConstantesFuncionesAdditional getDatoGeneralEmpleadoConstantesFuncionesAdditional() {
		return this.datogeneralempleadoConstantesFuncionesAdditional;
	}
	
	public void setDatoGeneralEmpleadoConstantesFuncionesAdditional(DatoGeneralEmpleadoConstantesFuncionesAdditional datogeneralempleadoConstantesFuncionesAdditional) {
		try {
			this.datogeneralempleadoConstantesFuncionesAdditional=datogeneralempleadoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDNUMEROPATRONAL= "id_numero_patronal";
    public static final String IDTIPOAFILIACION= "id_tipo_afiliacion";
    public static final String CARNETIESS= "carnet_iess";
    public static final String SECTORIALIESS= "sectorial_iess";
    public static final String IDPAIS= "id_pais";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCANTON= "id_canton";
    public static final String IDPARROQUIA= "id_parroquia";
    public static final String FECHANACIMIENTO= "fecha_nacimiento";
    public static final String FECHAFALLECE= "fecha_fallece";
    public static final String VALOREVALUACION= "valor_evaluacion";
    public static final String NUMEROHORAS= "numero_horas";
    public static final String VALORHORA= "valor_hora";
    public static final String SALARIO= "salario";
    public static final String IDMONEDA= "id_moneda";
    public static final String NUMEROCONTRATO= "numero_contrato";
    public static final String IDTIPOCONTRATO= "id_tipo_contrato";
    public static final String VALOR1= "valor1";
    public static final String VALOR2= "valor2";
    public static final String VALOR3= "valor3";
    public static final String VALOR4= "valor4";
    public static final String VALOR5= "valor5";
    public static final String VALOR6= "valor6";
    public static final String CONAPORTASEGUROSOCIAL= "con_aporta_seguro_social";
    public static final String CONRECIBEHORASEXTRAS= "con_recibe_horas_extras";
    public static final String CONDESCUENTOIMPUESTOS= "con_descuento_impuestos";
    public static final String PENSIONALIMENTICIA= "pension_alimenticia";
    public static final String CONPAGOPORHORAS= "con_pago_por_horas";
    public static final String CONANTICIPO= "con_anticipo";
    public static final String IDTIPOLIBRETAMILI= "id_tipo_libreta_mili";
    public static final String LIBRETAMILITAR= "libreta_militar";
    public static final String IDTIPOGRUPOFORMAPAGO= "id_tipo_grupo_forma_pago";
    public static final String IDBANCO= "id_banco";
    public static final String IDTIPOCUENTABANCOGLOBAL= "id_tipo_cuenta_banco_global";
    public static final String NUMEROCUENTA= "numero_cuenta";
    public static final String IDTIPOSANGRE= "id_tipo_sangre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDNUMEROPATRONAL= "Numero Patronal";
		public static final String LABEL_IDNUMEROPATRONAL_LOWER= "Numero Patronal";
    	public static final String LABEL_IDTIPOAFILIACION= "Tipo Afiliacion";
		public static final String LABEL_IDTIPOAFILIACION_LOWER= "Tipo Afiliacion";
    	public static final String LABEL_CARNETIESS= "Carnet Iess";
		public static final String LABEL_CARNETIESS_LOWER= "Carnet Iess";
    	public static final String LABEL_SECTORIALIESS= "Sectorial Iess";
		public static final String LABEL_SECTORIALIESS_LOWER= "Sectorial Iess";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCANTON= "Canton";
		public static final String LABEL_IDCANTON_LOWER= "Canton";
    	public static final String LABEL_IDPARROQUIA= "Parroquia";
		public static final String LABEL_IDPARROQUIA_LOWER= "Parroquia";
    	public static final String LABEL_FECHANACIMIENTO= "Fecha Nacimiento";
		public static final String LABEL_FECHANACIMIENTO_LOWER= "Fecha Nacimiento";
    	public static final String LABEL_FECHAFALLECE= "Fecha Fallece";
		public static final String LABEL_FECHAFALLECE_LOWER= "Fecha Fallece";
    	public static final String LABEL_VALOREVALUACION= "Valor Evaluacion";
		public static final String LABEL_VALOREVALUACION_LOWER= "Valor Evaluacion";
    	public static final String LABEL_NUMEROHORAS= "Numero Horas";
		public static final String LABEL_NUMEROHORAS_LOWER= "Numero Horas";
    	public static final String LABEL_VALORHORA= "Valor Hora";
		public static final String LABEL_VALORHORA_LOWER= "Valor Hora";
    	public static final String LABEL_SALARIO= "Salario";
		public static final String LABEL_SALARIO_LOWER= "Salario";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_NUMEROCONTRATO= "Numero Contrato";
		public static final String LABEL_NUMEROCONTRATO_LOWER= "Numero Contrato";
    	public static final String LABEL_IDTIPOCONTRATO= "Tipo Contrato";
		public static final String LABEL_IDTIPOCONTRATO_LOWER= "Tipo Contrato";
    	public static final String LABEL_VALOR1= "Valor1";
		public static final String LABEL_VALOR1_LOWER= "Valor1";
    	public static final String LABEL_VALOR2= "Valor2";
		public static final String LABEL_VALOR2_LOWER= "Valor2";
    	public static final String LABEL_VALOR3= "Valor3";
		public static final String LABEL_VALOR3_LOWER= "Valor3";
    	public static final String LABEL_VALOR4= "Valor4";
		public static final String LABEL_VALOR4_LOWER= "Valor4";
    	public static final String LABEL_VALOR5= "Valor5";
		public static final String LABEL_VALOR5_LOWER= "Valor5";
    	public static final String LABEL_VALOR6= "Valor6";
		public static final String LABEL_VALOR6_LOWER= "Valor6";
    	public static final String LABEL_CONAPORTASEGUROSOCIAL= "Con Aporta Seguro Social";
		public static final String LABEL_CONAPORTASEGUROSOCIAL_LOWER= "Con Aporta Seguro Social";
    	public static final String LABEL_CONRECIBEHORASEXTRAS= "Con Recibe Horas Extras";
		public static final String LABEL_CONRECIBEHORASEXTRAS_LOWER= "Con Recibe Horas Extras";
    	public static final String LABEL_CONDESCUENTOIMPUESTOS= "Con Descuento Impuestos";
		public static final String LABEL_CONDESCUENTOIMPUESTOS_LOWER= "Con Descuento Impuestos";
    	public static final String LABEL_PENSIONALIMENTICIA= "Pension Alimenticia";
		public static final String LABEL_PENSIONALIMENTICIA_LOWER= "Pension Alimenticia";
    	public static final String LABEL_CONPAGOPORHORAS= "Con Pago Por Horas";
		public static final String LABEL_CONPAGOPORHORAS_LOWER= "Con Pago Por Horas";
    	public static final String LABEL_CONANTICIPO= "Con Anticipo";
		public static final String LABEL_CONANTICIPO_LOWER= "Con Anticipo";
    	public static final String LABEL_IDTIPOLIBRETAMILI= "Tipo Libreta Mili";
		public static final String LABEL_IDTIPOLIBRETAMILI_LOWER= "Tipo Libreta Mili";
    	public static final String LABEL_LIBRETAMILITAR= "Libreta Militar";
		public static final String LABEL_LIBRETAMILITAR_LOWER= "Libreta Militar";
    	public static final String LABEL_IDTIPOGRUPOFORMAPAGO= "Tipo Grupo Forma Pago";
		public static final String LABEL_IDTIPOGRUPOFORMAPAGO_LOWER= "Tipo Grupo Forma Pago";
    	public static final String LABEL_IDBANCO= "Banco";
		public static final String LABEL_IDBANCO_LOWER= "Banco";
    	public static final String LABEL_IDTIPOCUENTABANCOGLOBAL= "Tipo Cuenta Banco Global";
		public static final String LABEL_IDTIPOCUENTABANCOGLOBAL_LOWER= "Tipo Cuenta Banco Global";
    	public static final String LABEL_NUMEROCUENTA= "Numero Cuenta";
		public static final String LABEL_NUMEROCUENTA_LOWER= "Numero Cuenta";
    	public static final String LABEL_IDTIPOSANGRE= "Tipo Sangre";
		public static final String LABEL_IDTIPOSANGRE_LOWER= "Tipo Sangre";
	
		
		
		
		
	public static final String SREGEXCARNET_IESS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCARNET_IESS=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECTORIAL_IESS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECTORIAL_IESS=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_CONTRATO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CONTRATO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXLIBRETA_MILITAR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLIBRETA_MILITAR=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNUMERO_CUENTA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_CUENTA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getDatoGeneralEmpleadoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDNUMEROPATRONAL;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOAFILIACION;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.CARNETIESS)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_CARNETIESS;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_SECTORIALIESS;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDPAIS)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDCANTON)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDCANTON;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPARROQUIA;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHANACIMIENTO;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHAFALLECE;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOREVALUACION;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROHORAS;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.VALORHORA)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_VALORHORA;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.SALARIO)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_SALARIO;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDMONEDA)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCONTRATO;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR1)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR1;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR2)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR2;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR3)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR3;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR4)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR4;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR5)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR5;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR6)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR6;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_CONAPORTASEGUROSOCIAL;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_CONRECIBEHORASEXTRAS;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_CONDESCUENTOIMPUESTOS;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_PENSIONALIMENTICIA;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_CONPAGOPORHORAS;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_CONANTICIPO;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOLIBRETAMILI;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_LIBRETAMILITAR;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDBANCO)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDBANCO;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCUENTA;}
		if(sNombreColumna.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE)) {sLabelColumna=DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOSANGRE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_aporta_seguro_socialDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datogeneralempleado.getcon_aporta_seguro_social()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_aporta_seguro_socialHtmlDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datogeneralempleado.getId(),datogeneralempleado.getcon_aporta_seguro_social());

		return sDescripcion;
	}	
		
	public static String getcon_recibe_horas_extrasDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datogeneralempleado.getcon_recibe_horas_extras()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_recibe_horas_extrasHtmlDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datogeneralempleado.getId(),datogeneralempleado.getcon_recibe_horas_extras());

		return sDescripcion;
	}	
		
	public static String getcon_descuento_impuestosDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datogeneralempleado.getcon_descuento_impuestos()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_descuento_impuestosHtmlDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datogeneralempleado.getId(),datogeneralempleado.getcon_descuento_impuestos());

		return sDescripcion;
	}	
			
		
	public static String getcon_pago_por_horasDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datogeneralempleado.getcon_pago_por_horas()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_pago_por_horasHtmlDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datogeneralempleado.getId(),datogeneralempleado.getcon_pago_por_horas());

		return sDescripcion;
	}	
		
	public static String getcon_anticipoDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!datogeneralempleado.getcon_anticipo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_anticipoHtmlDescripcion(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(datogeneralempleado.getId(),datogeneralempleado.getcon_anticipo());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
	
	public static String getDatoGeneralEmpleadoDescripcion(DatoGeneralEmpleado datogeneralempleado) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(datogeneralempleado !=null/* && datogeneralempleado.getId()!=0*/) {
			sDescripcion=datogeneralempleado.getcarnet_iess();//datogeneralempleadodatogeneralempleado.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDatoGeneralEmpleadoDescripcionDetallado(DatoGeneralEmpleado datogeneralempleado) {
		String sDescripcion="";
			
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.ID+"=";
		sDescripcion+=datogeneralempleado.getId().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=datogeneralempleado.getVersionRow().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL+"=";
		sDescripcion+=datogeneralempleado.getid_numero_patronal().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION+"=";
		sDescripcion+=datogeneralempleado.getid_tipo_afiliacion().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.CARNETIESS+"=";
		sDescripcion+=datogeneralempleado.getcarnet_iess()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS+"=";
		sDescripcion+=datogeneralempleado.getsectorial_iess()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDPAIS+"=";
		sDescripcion+=datogeneralempleado.getid_pais().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=datogeneralempleado.getid_provincia().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDCANTON+"=";
		sDescripcion+=datogeneralempleado.getid_canton().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA+"=";
		sDescripcion+=datogeneralempleado.getid_parroquia().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO+"=";
		sDescripcion+=datogeneralempleado.getfecha_nacimiento().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE+"=";
		sDescripcion+=datogeneralempleado.getfecha_fallece().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION+"=";
		sDescripcion+=datogeneralempleado.getvalor_evaluacion().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS+"=";
		sDescripcion+=datogeneralempleado.getnumero_horas().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VALORHORA+"=";
		sDescripcion+=datogeneralempleado.getvalor_hora().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.SALARIO+"=";
		sDescripcion+=datogeneralempleado.getsalario().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=datogeneralempleado.getid_moneda().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO+"=";
		sDescripcion+=datogeneralempleado.getnumero_contrato()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO+"=";
		sDescripcion+=datogeneralempleado.getid_tipo_contrato().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VALOR1+"=";
		sDescripcion+=datogeneralempleado.getvalor1().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VALOR2+"=";
		sDescripcion+=datogeneralempleado.getvalor2().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VALOR3+"=";
		sDescripcion+=datogeneralempleado.getvalor3().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VALOR4+"=";
		sDescripcion+=datogeneralempleado.getvalor4().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VALOR5+"=";
		sDescripcion+=datogeneralempleado.getvalor5().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.VALOR6+"=";
		sDescripcion+=datogeneralempleado.getvalor6().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL+"=";
		sDescripcion+=datogeneralempleado.getcon_aporta_seguro_social().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS+"=";
		sDescripcion+=datogeneralempleado.getcon_recibe_horas_extras().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS+"=";
		sDescripcion+=datogeneralempleado.getcon_descuento_impuestos().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA+"=";
		sDescripcion+=datogeneralempleado.getpension_alimenticia().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS+"=";
		sDescripcion+=datogeneralempleado.getcon_pago_por_horas().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO+"=";
		sDescripcion+=datogeneralempleado.getcon_anticipo().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI+"=";
		sDescripcion+=datogeneralempleado.getid_tipo_libreta_mili().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR+"=";
		sDescripcion+=datogeneralempleado.getlibreta_militar()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO+"=";
		sDescripcion+=datogeneralempleado.getid_tipo_grupo_forma_pago().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDBANCO+"=";
		sDescripcion+=datogeneralempleado.getid_banco().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL+"=";
		sDescripcion+=datogeneralempleado.getid_tipo_cuenta_banco_global().toString()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA+"=";
		sDescripcion+=datogeneralempleado.getnumero_cuenta()+",";
		sDescripcion+=DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE+"=";
		sDescripcion+=datogeneralempleado.getid_tipo_sangre().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDatoGeneralEmpleadoDescripcion(DatoGeneralEmpleado datogeneralempleado,String sValor) throws Exception {			
		if(datogeneralempleado !=null) {
			datogeneralempleado.setcarnet_iess(sValor);//datogeneralempleadodatogeneralempleado.getId().toString();
		}		
	}
	
		

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getNumeroPatronalDescripcion(NumeroPatronal numeropatronal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(numeropatronal!=null/*&&numeropatronal.getId()>0*/) {
			sDescripcion=NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(numeropatronal);
		}

		return sDescripcion;
	}

	public static String getTipoAfiliacionDescripcion(TipoAfiliacion tipoafiliacion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipoafiliacion!=null/*&&tipoafiliacion.getId()>0*/) {
			sDescripcion=TipoAfiliacionConstantesFunciones.getTipoAfiliacionDescripcion(tipoafiliacion);
		}

		return sDescripcion;
	}

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}

	public static String getProvinciaDescripcion(Provincia provincia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(provincia!=null/*&&provincia.getId()>0*/) {
			sDescripcion=ProvinciaConstantesFunciones.getProvinciaDescripcion(provincia);
		}

		return sDescripcion;
	}

	public static String getCantonDescripcion(Canton canton) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(canton!=null/*&&canton.getId()>0*/) {
			sDescripcion=CantonConstantesFunciones.getCantonDescripcion(canton);
		}

		return sDescripcion;
	}

	public static String getParroquiaDescripcion(Parroquia parroquia) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(parroquia!=null/*&&parroquia.getId()>0*/) {
			sDescripcion=ParroquiaConstantesFunciones.getParroquiaDescripcion(parroquia);
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

	public static String getTipoContratoDescripcion(TipoContrato tipocontrato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocontrato!=null/*&&tipocontrato.getId()>0*/) {
			sDescripcion=TipoContratoConstantesFunciones.getTipoContratoDescripcion(tipocontrato);
		}

		return sDescripcion;
	}

	public static String getTipoLibretaMiliDescripcion(TipoLibretaMili tipolibretamili) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipolibretamili!=null/*&&tipolibretamili.getId()>0*/) {
			sDescripcion=TipoLibretaMiliConstantesFunciones.getTipoLibretaMiliDescripcion(tipolibretamili);
		}

		return sDescripcion;
	}

	public static String getTipoGrupoFormaPagoDescripcion(TipoGrupoFormaPago tipogrupoformapago) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogrupoformapago!=null/*&&tipogrupoformapago.getId()>0*/) {
			sDescripcion=TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(tipogrupoformapago);
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

	public static String getTipoSangreDescripcion(TipoSangre tiposangre) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tiposangre!=null/*&&tiposangre.getId()>0*/) {
			sDescripcion=TipoSangreConstantesFunciones.getTipoSangreDescripcion(tiposangre);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdBanco")) {
			sNombreIndice="Tipo=  Por Banco";
		} else if(sNombreIndice.equals("FK_IdCanton")) {
			sNombreIndice="Tipo=  Por Canton";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por ";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdNumeroPatronal")) {
			sNombreIndice="Tipo=  Por Numero Patronal";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("FK_IdParroquia")) {
			sNombreIndice="Tipo=  Por Parroquia";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		} else if(sNombreIndice.equals("FK_IdTipoAfiliacion")) {
			sNombreIndice="Tipo=  Por Tipo Afiliacion";
		} else if(sNombreIndice.equals("FK_IdTipoContrato")) {
			sNombreIndice="Tipo=  Por Tipo Contrato";
		} else if(sNombreIndice.equals("FK_IdTipoCuentaBancoGlobal")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta Banco Global";
		} else if(sNombreIndice.equals("FK_IdTipoGrupoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Grupo Forma Pago";
		} else if(sNombreIndice.equals("FK_IdTipoLibretaMili")) {
			sNombreIndice="Tipo=  Por Tipo Libreta Mili";
		} else if(sNombreIndice.equals("FK_IdTipoSangre")) {
			sNombreIndice="Tipo=  Por Tipo Sangre";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdBanco(Long id_banco) {
		String sDetalleIndice=" Parametros->";
		if(id_banco!=null) {sDetalleIndice+=" Codigo Unico De Banco="+id_banco.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCanton(Long id_canton) {
		String sDetalleIndice=" Parametros->";
		if(id_canton!=null) {sDetalleIndice+=" Codigo Unico De Canton="+id_canton.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De ="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdNumeroPatronal(Long id_numero_patronal) {
		String sDetalleIndice=" Parametros->";
		if(id_numero_patronal!=null) {sDetalleIndice+=" Codigo Unico De Numero Patronal="+id_numero_patronal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdParroquia(Long id_parroquia) {
		String sDetalleIndice=" Parametros->";
		if(id_parroquia!=null) {sDetalleIndice+=" Codigo Unico De Parroquia="+id_parroquia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProvincia(Long id_provincia) {
		String sDetalleIndice=" Parametros->";
		if(id_provincia!=null) {sDetalleIndice+=" Codigo Unico De Provincia="+id_provincia.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoAfiliacion(Long id_tipo_afiliacion) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_afiliacion!=null) {sDetalleIndice+=" Codigo Unico De Tipo Afiliacion="+id_tipo_afiliacion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoContrato(Long id_tipo_contrato) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_contrato!=null) {sDetalleIndice+=" Codigo Unico De Tipo Contrato="+id_tipo_contrato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuentaBancoGlobal(Long id_tipo_cuenta_banco_global) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuenta_banco_global!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta Banco Global="+id_tipo_cuenta_banco_global.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGrupoFormaPago(Long id_tipo_grupo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_grupo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Grupo Forma Pago="+id_tipo_grupo_forma_pago.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoLibretaMili(Long id_tipo_libreta_mili) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_libreta_mili!=null) {sDetalleIndice+=" Codigo Unico De Tipo Libreta Mili="+id_tipo_libreta_mili.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoSangre(Long id_tipo_sangre) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_sangre!=null) {sDetalleIndice+=" Codigo Unico De Tipo Sangre="+id_tipo_sangre.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleado,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		datogeneralempleado.setcarnet_iess(datogeneralempleado.getcarnet_iess().trim());
		datogeneralempleado.setsectorial_iess(datogeneralempleado.getsectorial_iess().trim());
		datogeneralempleado.setnumero_contrato(datogeneralempleado.getnumero_contrato().trim());
		datogeneralempleado.setlibreta_militar(datogeneralempleado.getlibreta_militar().trim());
		datogeneralempleado.setnumero_cuenta(datogeneralempleado.getnumero_cuenta().trim());
	}
	
	public static void quitarEspaciosDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DatoGeneralEmpleado datogeneralempleado: datogeneralempleados) {
			datogeneralempleado.setcarnet_iess(datogeneralempleado.getcarnet_iess().trim());
			datogeneralempleado.setsectorial_iess(datogeneralempleado.getsectorial_iess().trim());
			datogeneralempleado.setnumero_contrato(datogeneralempleado.getnumero_contrato().trim());
			datogeneralempleado.setlibreta_militar(datogeneralempleado.getlibreta_militar().trim());
			datogeneralempleado.setnumero_cuenta(datogeneralempleado.getnumero_cuenta().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleado,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && datogeneralempleado.getConCambioAuxiliar()) {
			datogeneralempleado.setIsDeleted(datogeneralempleado.getIsDeletedAuxiliar());	
			datogeneralempleado.setIsNew(datogeneralempleado.getIsNewAuxiliar());	
			datogeneralempleado.setIsChanged(datogeneralempleado.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			datogeneralempleado.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			datogeneralempleado.setIsDeletedAuxiliar(false);	
			datogeneralempleado.setIsNewAuxiliar(false);	
			datogeneralempleado.setIsChangedAuxiliar(false);
			
			datogeneralempleado.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DatoGeneralEmpleado datogeneralempleado : datogeneralempleados) {
			if(conAsignarBase && datogeneralempleado.getConCambioAuxiliar()) {
				datogeneralempleado.setIsDeleted(datogeneralempleado.getIsDeletedAuxiliar());	
				datogeneralempleado.setIsNew(datogeneralempleado.getIsNewAuxiliar());	
				datogeneralempleado.setIsChanged(datogeneralempleado.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				datogeneralempleado.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				datogeneralempleado.setIsDeletedAuxiliar(false);	
				datogeneralempleado.setIsNewAuxiliar(false);	
				datogeneralempleado.setIsChangedAuxiliar(false);
				
				datogeneralempleado.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleado,Boolean conEnteros) throws Exception  {
		datogeneralempleado.setvalor_evaluacion(0.0);
		datogeneralempleado.setnumero_horas(0.0);
		datogeneralempleado.setvalor_hora(0.0);
		datogeneralempleado.setsalario(0.0);
		datogeneralempleado.setvalor1(0.0);
		datogeneralempleado.setvalor2(0.0);
		datogeneralempleado.setvalor3(0.0);
		datogeneralempleado.setvalor4(0.0);
		datogeneralempleado.setvalor5(0.0);
		datogeneralempleado.setvalor6(0.0);
		datogeneralempleado.setpension_alimenticia(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados,Boolean conEnteros) throws Exception  {
		
		for(DatoGeneralEmpleado datogeneralempleado: datogeneralempleados) {
			datogeneralempleado.setvalor_evaluacion(0.0);
			datogeneralempleado.setnumero_horas(0.0);
			datogeneralempleado.setvalor_hora(0.0);
			datogeneralempleado.setsalario(0.0);
			datogeneralempleado.setvalor1(0.0);
			datogeneralempleado.setvalor2(0.0);
			datogeneralempleado.setvalor3(0.0);
			datogeneralempleado.setvalor4(0.0);
			datogeneralempleado.setvalor5(0.0);
			datogeneralempleado.setvalor6(0.0);
			datogeneralempleado.setpension_alimenticia(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDatoGeneralEmpleado(List<DatoGeneralEmpleado> datogeneralempleados,DatoGeneralEmpleado datogeneralempleadoAux) throws Exception  {
		DatoGeneralEmpleadoConstantesFunciones.InicializarValoresDatoGeneralEmpleado(datogeneralempleadoAux,true);
		
		for(DatoGeneralEmpleado datogeneralempleado: datogeneralempleados) {
			if(datogeneralempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			datogeneralempleadoAux.setvalor_evaluacion(datogeneralempleadoAux.getvalor_evaluacion()+datogeneralempleado.getvalor_evaluacion());			
			datogeneralempleadoAux.setnumero_horas(datogeneralempleadoAux.getnumero_horas()+datogeneralempleado.getnumero_horas());			
			datogeneralempleadoAux.setvalor_hora(datogeneralempleadoAux.getvalor_hora()+datogeneralempleado.getvalor_hora());			
			datogeneralempleadoAux.setsalario(datogeneralempleadoAux.getsalario()+datogeneralempleado.getsalario());			
			datogeneralempleadoAux.setvalor1(datogeneralempleadoAux.getvalor1()+datogeneralempleado.getvalor1());			
			datogeneralempleadoAux.setvalor2(datogeneralempleadoAux.getvalor2()+datogeneralempleado.getvalor2());			
			datogeneralempleadoAux.setvalor3(datogeneralempleadoAux.getvalor3()+datogeneralempleado.getvalor3());			
			datogeneralempleadoAux.setvalor4(datogeneralempleadoAux.getvalor4()+datogeneralempleado.getvalor4());			
			datogeneralempleadoAux.setvalor5(datogeneralempleadoAux.getvalor5()+datogeneralempleado.getvalor5());			
			datogeneralempleadoAux.setvalor6(datogeneralempleadoAux.getvalor6()+datogeneralempleado.getvalor6());			
			datogeneralempleadoAux.setpension_alimenticia(datogeneralempleadoAux.getpension_alimenticia()+datogeneralempleado.getpension_alimenticia());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoGeneralEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DatoGeneralEmpleadoConstantesFunciones.getArrayColumnasGlobalesDatoGeneralEmpleado(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDatoGeneralEmpleado(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DatoGeneralEmpleadoConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DatoGeneralEmpleadoConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDatoGeneralEmpleado(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DatoGeneralEmpleado> datogeneralempleados,DatoGeneralEmpleado datogeneralempleado,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DatoGeneralEmpleado datogeneralempleadoAux: datogeneralempleados) {
			if(datogeneralempleadoAux!=null && datogeneralempleado!=null) {
				if((datogeneralempleadoAux.getId()==null && datogeneralempleado.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(datogeneralempleadoAux.getId()!=null && datogeneralempleado.getId()!=null){
					if(datogeneralempleadoAux.getId().equals(datogeneralempleado.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDatoGeneralEmpleado(List<DatoGeneralEmpleado> datogeneralempleados) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_evaluacionTotal=0.0;
		Double numero_horasTotal=0.0;
		Double valor_horaTotal=0.0;
		Double salarioTotal=0.0;
		Double valor1Total=0.0;
		Double valor2Total=0.0;
		Double valor3Total=0.0;
		Double valor4Total=0.0;
		Double valor5Total=0.0;
		Double valor6Total=0.0;
		Double pension_alimenticiaTotal=0.0;
	
		for(DatoGeneralEmpleado datogeneralempleado: datogeneralempleados) {			
			if(datogeneralempleado.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_evaluacionTotal+=datogeneralempleado.getvalor_evaluacion();
			numero_horasTotal+=datogeneralempleado.getnumero_horas();
			valor_horaTotal+=datogeneralempleado.getvalor_hora();
			salarioTotal+=datogeneralempleado.getsalario();
			valor1Total+=datogeneralempleado.getvalor1();
			valor2Total+=datogeneralempleado.getvalor2();
			valor3Total+=datogeneralempleado.getvalor3();
			valor4Total+=datogeneralempleado.getvalor4();
			valor5Total+=datogeneralempleado.getvalor5();
			valor6Total+=datogeneralempleado.getvalor6();
			pension_alimenticiaTotal+=datogeneralempleado.getpension_alimenticia();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOREVALUACION);
		datoGeneral.setdValorDouble(valor_evaluacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROHORAS);
		datoGeneral.setdValorDouble(numero_horasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.VALORHORA);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALORHORA);
		datoGeneral.setdValorDouble(valor_horaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.SALARIO);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_SALARIO);
		datoGeneral.setdValorDouble(salarioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.VALOR1);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR1);
		datoGeneral.setdValorDouble(valor1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.VALOR2);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR2);
		datoGeneral.setdValorDouble(valor2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.VALOR3);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR3);
		datoGeneral.setdValorDouble(valor3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.VALOR4);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR4);
		datoGeneral.setdValorDouble(valor4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.VALOR5);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR5);
		datoGeneral.setdValorDouble(valor5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.VALOR6);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR6);
		datoGeneral.setdValorDouble(valor6Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA);
		datoGeneral.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_PENSIONALIMENTICIA);
		datoGeneral.setdValorDouble(pension_alimenticiaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDatoGeneralEmpleado() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_ID, DatoGeneralEmpleadoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VERSIONROW, DatoGeneralEmpleadoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDNUMEROPATRONAL, DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOAFILIACION, DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_CARNETIESS, DatoGeneralEmpleadoConstantesFunciones.CARNETIESS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_SECTORIALIESS, DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPAIS, DatoGeneralEmpleadoConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPROVINCIA, DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDCANTON, DatoGeneralEmpleadoConstantesFunciones.IDCANTON,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPARROQUIA, DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHANACIMIENTO, DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHAFALLECE, DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOREVALUACION, DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROHORAS, DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VALORHORA, DatoGeneralEmpleadoConstantesFunciones.VALORHORA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_SALARIO, DatoGeneralEmpleadoConstantesFunciones.SALARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDMONEDA, DatoGeneralEmpleadoConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCONTRATO, DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO, DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR1, DatoGeneralEmpleadoConstantesFunciones.VALOR1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR2, DatoGeneralEmpleadoConstantesFunciones.VALOR2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR3, DatoGeneralEmpleadoConstantesFunciones.VALOR3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR4, DatoGeneralEmpleadoConstantesFunciones.VALOR4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR5, DatoGeneralEmpleadoConstantesFunciones.VALOR5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR6, DatoGeneralEmpleadoConstantesFunciones.VALOR6,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_CONAPORTASEGUROSOCIAL, DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_CONRECIBEHORASEXTRAS, DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_CONDESCUENTOIMPUESTOS, DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_PENSIONALIMENTICIA, DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_CONPAGOPORHORAS, DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_CONANTICIPO, DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOLIBRETAMILI, DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_LIBRETAMILITAR, DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO, DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDBANCO, DatoGeneralEmpleadoConstantesFunciones.IDBANCO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL, DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCUENTA, DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOSANGRE, DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDatoGeneralEmpleado() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.CARNETIESS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDCANTON;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VALORHORA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.SALARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VALOR1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VALOR2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VALOR3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VALOR4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VALOR5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.VALOR6;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDBANCO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoGeneralEmpleado() throws Exception  {
		return DatoGeneralEmpleadoConstantesFunciones.getTiposSeleccionarDatoGeneralEmpleado(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoGeneralEmpleado(Boolean conFk) throws Exception  {
		return DatoGeneralEmpleadoConstantesFunciones.getTiposSeleccionarDatoGeneralEmpleado(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDatoGeneralEmpleado(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDNUMEROPATRONAL);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDNUMEROPATRONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOAFILIACION);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOAFILIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_CARNETIESS);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_CARNETIESS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_SECTORIALIESS);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_SECTORIALIESS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDCANTON);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDCANTON);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPARROQUIA);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPARROQUIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHANACIMIENTO);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHANACIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHAFALLECE);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHAFALLECE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOREVALUACION);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOREVALUACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROHORAS);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROHORAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALORHORA);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALORHORA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_SALARIO);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_SALARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCONTRATO);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCONTRATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR1);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR2);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR3);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR4);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR5);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR6);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR6);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONAPORTASEGUROSOCIAL);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONAPORTASEGUROSOCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONRECIBEHORASEXTRAS);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONRECIBEHORASEXTRAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONDESCUENTOIMPUESTOS);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONDESCUENTOIMPUESTOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_PENSIONALIMENTICIA);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_PENSIONALIMENTICIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONPAGOPORHORAS);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONPAGOPORHORAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONANTICIPO);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONANTICIPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOLIBRETAMILI);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOLIBRETAMILI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_LIBRETAMILITAR);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_LIBRETAMILITAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDBANCO);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDBANCO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCUENTA);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCUENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOSANGRE);
			reporte.setsDescripcion(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOSANGRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDatoGeneralEmpleado(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleadoAux) throws Exception {
		
			datogeneralempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(datogeneralempleadoAux.getEmpleado()));
			datogeneralempleadoAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(datogeneralempleadoAux.getNumeroPatronal()));
			datogeneralempleadoAux.settipoafiliacion_descripcion(TipoAfiliacionConstantesFunciones.getTipoAfiliacionDescripcion(datogeneralempleadoAux.getTipoAfiliacion()));
			datogeneralempleadoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(datogeneralempleadoAux.getPais()));
			datogeneralempleadoAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(datogeneralempleadoAux.getProvincia()));
			datogeneralempleadoAux.setcanton_descripcion(CantonConstantesFunciones.getCantonDescripcion(datogeneralempleadoAux.getCanton()));
			datogeneralempleadoAux.setparroquia_descripcion(ParroquiaConstantesFunciones.getParroquiaDescripcion(datogeneralempleadoAux.getParroquia()));
			datogeneralempleadoAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(datogeneralempleadoAux.getMoneda()));
			datogeneralempleadoAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(datogeneralempleadoAux.getTipoContrato()));
			datogeneralempleadoAux.settipolibretamili_descripcion(TipoLibretaMiliConstantesFunciones.getTipoLibretaMiliDescripcion(datogeneralempleadoAux.getTipoLibretaMili()));
			datogeneralempleadoAux.settipogrupoformapago_descripcion(TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(datogeneralempleadoAux.getTipoGrupoFormaPago()));
			datogeneralempleadoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(datogeneralempleadoAux.getBanco()));
			datogeneralempleadoAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(datogeneralempleadoAux.getTipoCuentaBancoGlobal()));
			datogeneralempleadoAux.settiposangre_descripcion(TipoSangreConstantesFunciones.getTipoSangreDescripcion(datogeneralempleadoAux.getTipoSangre()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDatoGeneralEmpleado(List<DatoGeneralEmpleado> datogeneralempleadosTemp) throws Exception {
		for(DatoGeneralEmpleado datogeneralempleadoAux:datogeneralempleadosTemp) {
			
			datogeneralempleadoAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(datogeneralempleadoAux.getEmpleado()));
			datogeneralempleadoAux.setnumeropatronal_descripcion(NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(datogeneralempleadoAux.getNumeroPatronal()));
			datogeneralempleadoAux.settipoafiliacion_descripcion(TipoAfiliacionConstantesFunciones.getTipoAfiliacionDescripcion(datogeneralempleadoAux.getTipoAfiliacion()));
			datogeneralempleadoAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(datogeneralempleadoAux.getPais()));
			datogeneralempleadoAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(datogeneralempleadoAux.getProvincia()));
			datogeneralempleadoAux.setcanton_descripcion(CantonConstantesFunciones.getCantonDescripcion(datogeneralempleadoAux.getCanton()));
			datogeneralempleadoAux.setparroquia_descripcion(ParroquiaConstantesFunciones.getParroquiaDescripcion(datogeneralempleadoAux.getParroquia()));
			datogeneralempleadoAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(datogeneralempleadoAux.getMoneda()));
			datogeneralempleadoAux.settipocontrato_descripcion(TipoContratoConstantesFunciones.getTipoContratoDescripcion(datogeneralempleadoAux.getTipoContrato()));
			datogeneralempleadoAux.settipolibretamili_descripcion(TipoLibretaMiliConstantesFunciones.getTipoLibretaMiliDescripcion(datogeneralempleadoAux.getTipoLibretaMili()));
			datogeneralempleadoAux.settipogrupoformapago_descripcion(TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(datogeneralempleadoAux.getTipoGrupoFormaPago()));
			datogeneralempleadoAux.setbanco_descripcion(BancoConstantesFunciones.getBancoDescripcion(datogeneralempleadoAux.getBanco()));
			datogeneralempleadoAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(datogeneralempleadoAux.getTipoCuentaBancoGlobal()));
			datogeneralempleadoAux.settiposangre_descripcion(TipoSangreConstantesFunciones.getTipoSangreDescripcion(datogeneralempleadoAux.getTipoSangre()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDatoGeneralEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(NumeroPatronal.class));
				classes.add(new Classe(TipoAfiliacion.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Canton.class));
				classes.add(new Classe(Parroquia.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(TipoContrato.class));
				classes.add(new Classe(TipoLibretaMili.class));
				classes.add(new Classe(TipoGrupoFormaPago.class));
				classes.add(new Classe(Banco.class));
				classes.add(new Classe(TipoCuentaBancoGlobal.class));
				classes.add(new Classe(TipoSangre.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NumeroPatronal.class)) {
						classes.add(new Classe(NumeroPatronal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoAfiliacion.class)) {
						classes.add(new Classe(TipoAfiliacion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Provincia.class)) {
						classes.add(new Classe(Provincia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Canton.class)) {
						classes.add(new Classe(Canton.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Parroquia.class)) {
						classes.add(new Classe(Parroquia.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoContrato.class)) {
						classes.add(new Classe(TipoContrato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoLibretaMili.class)) {
						classes.add(new Classe(TipoLibretaMili.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGrupoFormaPago.class)) {
						classes.add(new Classe(TipoGrupoFormaPago.class));
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
					if(clas.clas.equals(TipoSangre.class)) {
						classes.add(new Classe(TipoSangre.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDatoGeneralEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(TipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAfiliacion.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Canton.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Canton.class)); continue;
					}

					if(Parroquia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Parroquia.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}

					if(TipoLibretaMili.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLibretaMili.class)); continue;
					}

					if(TipoGrupoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFormaPago.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}

					if(TipoSangre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoSangre.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(NumeroPatronal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NumeroPatronal.class)); continue;
					}

					if(TipoAfiliacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoAfiliacion.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Provincia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Provincia.class)); continue;
					}

					if(Canton.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Canton.class)); continue;
					}

					if(Parroquia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Parroquia.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoContrato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoContrato.class)); continue;
					}

					if(TipoLibretaMili.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLibretaMili.class)); continue;
					}

					if(TipoGrupoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFormaPago.class)); continue;
					}

					if(Banco.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Banco.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}

					if(TipoSangre.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoSangre.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoGeneralEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoGeneralEmpleadoConstantesFunciones.getClassesRelationshipsOfDatoGeneralEmpleado(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoGeneralEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoGeneralEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DatoGeneralEmpleadoConstantesFunciones.getClassesRelationshipsFromStringsOfDatoGeneralEmpleado(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDatoGeneralEmpleado(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DatoGeneralEmpleado datogeneralempleado,List<DatoGeneralEmpleado> datogeneralempleados,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DatoGeneralEmpleado datogeneralempleadoEncontrado=null;
			
			for(DatoGeneralEmpleado datogeneralempleadoLocal:datogeneralempleados) {
				if(datogeneralempleadoLocal.getId().equals(datogeneralempleado.getId())) {
					datogeneralempleadoEncontrado=datogeneralempleadoLocal;
					
					datogeneralempleadoLocal.setIsChanged(datogeneralempleado.getIsChanged());
					datogeneralempleadoLocal.setIsNew(datogeneralempleado.getIsNew());
					datogeneralempleadoLocal.setIsDeleted(datogeneralempleado.getIsDeleted());
					
					datogeneralempleadoLocal.setGeneralEntityOriginal(datogeneralempleado.getGeneralEntityOriginal());
					
					datogeneralempleadoLocal.setId(datogeneralempleado.getId());	
					datogeneralempleadoLocal.setVersionRow(datogeneralempleado.getVersionRow());	
					datogeneralempleadoLocal.setid_numero_patronal(datogeneralempleado.getid_numero_patronal());	
					datogeneralempleadoLocal.setid_tipo_afiliacion(datogeneralempleado.getid_tipo_afiliacion());	
					datogeneralempleadoLocal.setcarnet_iess(datogeneralempleado.getcarnet_iess());	
					datogeneralempleadoLocal.setsectorial_iess(datogeneralempleado.getsectorial_iess());	
					datogeneralempleadoLocal.setid_pais(datogeneralempleado.getid_pais());	
					datogeneralempleadoLocal.setid_provincia(datogeneralempleado.getid_provincia());	
					datogeneralempleadoLocal.setid_canton(datogeneralempleado.getid_canton());	
					datogeneralempleadoLocal.setid_parroquia(datogeneralempleado.getid_parroquia());	
					datogeneralempleadoLocal.setfecha_nacimiento(datogeneralempleado.getfecha_nacimiento());	
					datogeneralempleadoLocal.setfecha_fallece(datogeneralempleado.getfecha_fallece());	
					datogeneralempleadoLocal.setvalor_evaluacion(datogeneralempleado.getvalor_evaluacion());	
					datogeneralempleadoLocal.setnumero_horas(datogeneralempleado.getnumero_horas());	
					datogeneralempleadoLocal.setvalor_hora(datogeneralempleado.getvalor_hora());	
					datogeneralempleadoLocal.setsalario(datogeneralempleado.getsalario());	
					datogeneralempleadoLocal.setid_moneda(datogeneralempleado.getid_moneda());	
					datogeneralempleadoLocal.setnumero_contrato(datogeneralempleado.getnumero_contrato());	
					datogeneralempleadoLocal.setid_tipo_contrato(datogeneralempleado.getid_tipo_contrato());	
					datogeneralempleadoLocal.setvalor1(datogeneralempleado.getvalor1());	
					datogeneralempleadoLocal.setvalor2(datogeneralempleado.getvalor2());	
					datogeneralempleadoLocal.setvalor3(datogeneralempleado.getvalor3());	
					datogeneralempleadoLocal.setvalor4(datogeneralempleado.getvalor4());	
					datogeneralempleadoLocal.setvalor5(datogeneralempleado.getvalor5());	
					datogeneralempleadoLocal.setvalor6(datogeneralempleado.getvalor6());	
					datogeneralempleadoLocal.setcon_aporta_seguro_social(datogeneralempleado.getcon_aporta_seguro_social());	
					datogeneralempleadoLocal.setcon_recibe_horas_extras(datogeneralempleado.getcon_recibe_horas_extras());	
					datogeneralempleadoLocal.setcon_descuento_impuestos(datogeneralempleado.getcon_descuento_impuestos());	
					datogeneralempleadoLocal.setpension_alimenticia(datogeneralempleado.getpension_alimenticia());	
					datogeneralempleadoLocal.setcon_pago_por_horas(datogeneralempleado.getcon_pago_por_horas());	
					datogeneralempleadoLocal.setcon_anticipo(datogeneralempleado.getcon_anticipo());	
					datogeneralempleadoLocal.setid_tipo_libreta_mili(datogeneralempleado.getid_tipo_libreta_mili());	
					datogeneralempleadoLocal.setlibreta_militar(datogeneralempleado.getlibreta_militar());	
					datogeneralempleadoLocal.setid_tipo_grupo_forma_pago(datogeneralempleado.getid_tipo_grupo_forma_pago());	
					datogeneralempleadoLocal.setid_banco(datogeneralempleado.getid_banco());	
					datogeneralempleadoLocal.setid_tipo_cuenta_banco_global(datogeneralempleado.getid_tipo_cuenta_banco_global());	
					datogeneralempleadoLocal.setnumero_cuenta(datogeneralempleado.getnumero_cuenta());	
					datogeneralempleadoLocal.setid_tipo_sangre(datogeneralempleado.getid_tipo_sangre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!datogeneralempleado.getIsDeleted()) {
				if(!existe) {
					datogeneralempleados.add(datogeneralempleado);
				}
			} else {
				if(datogeneralempleadoEncontrado!=null && permiteQuitar)  {
					datogeneralempleados.remove(datogeneralempleadoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DatoGeneralEmpleado datogeneralempleado,List<DatoGeneralEmpleado> datogeneralempleados) throws Exception {
		try	{			
			for(DatoGeneralEmpleado datogeneralempleadoLocal:datogeneralempleados) {
				if(datogeneralempleadoLocal.getId().equals(datogeneralempleado.getId())) {
					datogeneralempleadoLocal.setIsSelected(datogeneralempleado.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDatoGeneralEmpleado(List<DatoGeneralEmpleado> datogeneralempleadosAux) throws Exception {
		//this.datogeneralempleadosAux=datogeneralempleadosAux;
		
		for(DatoGeneralEmpleado datogeneralempleadoAux:datogeneralempleadosAux) {
			if(datogeneralempleadoAux.getIsChanged()) {
				datogeneralempleadoAux.setIsChanged(false);
			}		
			
			if(datogeneralempleadoAux.getIsNew()) {
				datogeneralempleadoAux.setIsNew(false);
			}	
			
			if(datogeneralempleadoAux.getIsDeleted()) {
				datogeneralempleadoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleadoAux) throws Exception {
		//this.datogeneralempleadoAux=datogeneralempleadoAux;
		
			if(datogeneralempleadoAux.getIsChanged()) {
				datogeneralempleadoAux.setIsChanged(false);
			}		
			
			if(datogeneralempleadoAux.getIsNew()) {
				datogeneralempleadoAux.setIsNew(false);
			}	
			
			if(datogeneralempleadoAux.getIsDeleted()) {
				datogeneralempleadoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DatoGeneralEmpleado datogeneralempleadoAsignar,DatoGeneralEmpleado datogeneralempleado) throws Exception {
		datogeneralempleadoAsignar.setId(datogeneralempleado.getId());	
		datogeneralempleadoAsignar.setVersionRow(datogeneralempleado.getVersionRow());	
		datogeneralempleadoAsignar.setid_numero_patronal(datogeneralempleado.getid_numero_patronal());
		datogeneralempleadoAsignar.setnumeropatronal_descripcion(datogeneralempleado.getnumeropatronal_descripcion());	
		datogeneralempleadoAsignar.setid_tipo_afiliacion(datogeneralempleado.getid_tipo_afiliacion());
		datogeneralempleadoAsignar.settipoafiliacion_descripcion(datogeneralempleado.gettipoafiliacion_descripcion());	
		datogeneralempleadoAsignar.setcarnet_iess(datogeneralempleado.getcarnet_iess());	
		datogeneralempleadoAsignar.setsectorial_iess(datogeneralempleado.getsectorial_iess());	
		datogeneralempleadoAsignar.setid_pais(datogeneralempleado.getid_pais());
		datogeneralempleadoAsignar.setpais_descripcion(datogeneralempleado.getpais_descripcion());	
		datogeneralempleadoAsignar.setid_provincia(datogeneralempleado.getid_provincia());
		datogeneralempleadoAsignar.setprovincia_descripcion(datogeneralempleado.getprovincia_descripcion());	
		datogeneralempleadoAsignar.setid_canton(datogeneralempleado.getid_canton());
		datogeneralempleadoAsignar.setcanton_descripcion(datogeneralempleado.getcanton_descripcion());	
		datogeneralempleadoAsignar.setid_parroquia(datogeneralempleado.getid_parroquia());
		datogeneralempleadoAsignar.setparroquia_descripcion(datogeneralempleado.getparroquia_descripcion());	
		datogeneralempleadoAsignar.setfecha_nacimiento(datogeneralempleado.getfecha_nacimiento());	
		datogeneralempleadoAsignar.setfecha_fallece(datogeneralempleado.getfecha_fallece());	
		datogeneralempleadoAsignar.setvalor_evaluacion(datogeneralempleado.getvalor_evaluacion());	
		datogeneralempleadoAsignar.setnumero_horas(datogeneralempleado.getnumero_horas());	
		datogeneralempleadoAsignar.setvalor_hora(datogeneralempleado.getvalor_hora());	
		datogeneralempleadoAsignar.setsalario(datogeneralempleado.getsalario());	
		datogeneralempleadoAsignar.setid_moneda(datogeneralempleado.getid_moneda());
		datogeneralempleadoAsignar.setmoneda_descripcion(datogeneralempleado.getmoneda_descripcion());	
		datogeneralempleadoAsignar.setnumero_contrato(datogeneralempleado.getnumero_contrato());	
		datogeneralempleadoAsignar.setid_tipo_contrato(datogeneralempleado.getid_tipo_contrato());
		datogeneralempleadoAsignar.settipocontrato_descripcion(datogeneralempleado.gettipocontrato_descripcion());	
		datogeneralempleadoAsignar.setvalor1(datogeneralempleado.getvalor1());	
		datogeneralempleadoAsignar.setvalor2(datogeneralempleado.getvalor2());	
		datogeneralempleadoAsignar.setvalor3(datogeneralempleado.getvalor3());	
		datogeneralempleadoAsignar.setvalor4(datogeneralempleado.getvalor4());	
		datogeneralempleadoAsignar.setvalor5(datogeneralempleado.getvalor5());	
		datogeneralempleadoAsignar.setvalor6(datogeneralempleado.getvalor6());	
		datogeneralempleadoAsignar.setcon_aporta_seguro_social(datogeneralempleado.getcon_aporta_seguro_social());	
		datogeneralempleadoAsignar.setcon_recibe_horas_extras(datogeneralempleado.getcon_recibe_horas_extras());	
		datogeneralempleadoAsignar.setcon_descuento_impuestos(datogeneralempleado.getcon_descuento_impuestos());	
		datogeneralempleadoAsignar.setpension_alimenticia(datogeneralempleado.getpension_alimenticia());	
		datogeneralempleadoAsignar.setcon_pago_por_horas(datogeneralempleado.getcon_pago_por_horas());	
		datogeneralempleadoAsignar.setcon_anticipo(datogeneralempleado.getcon_anticipo());	
		datogeneralempleadoAsignar.setid_tipo_libreta_mili(datogeneralempleado.getid_tipo_libreta_mili());
		datogeneralempleadoAsignar.settipolibretamili_descripcion(datogeneralempleado.gettipolibretamili_descripcion());	
		datogeneralempleadoAsignar.setlibreta_militar(datogeneralempleado.getlibreta_militar());	
		datogeneralempleadoAsignar.setid_tipo_grupo_forma_pago(datogeneralempleado.getid_tipo_grupo_forma_pago());
		datogeneralempleadoAsignar.settipogrupoformapago_descripcion(datogeneralempleado.gettipogrupoformapago_descripcion());	
		datogeneralempleadoAsignar.setid_banco(datogeneralempleado.getid_banco());
		datogeneralempleadoAsignar.setbanco_descripcion(datogeneralempleado.getbanco_descripcion());	
		datogeneralempleadoAsignar.setid_tipo_cuenta_banco_global(datogeneralempleado.getid_tipo_cuenta_banco_global());
		datogeneralempleadoAsignar.settipocuentabancoglobal_descripcion(datogeneralempleado.gettipocuentabancoglobal_descripcion());	
		datogeneralempleadoAsignar.setnumero_cuenta(datogeneralempleado.getnumero_cuenta());	
		datogeneralempleadoAsignar.setid_tipo_sangre(datogeneralempleado.getid_tipo_sangre());
		datogeneralempleadoAsignar.settiposangre_descripcion(datogeneralempleado.gettiposangre_descripcion());	
	}
	
	public static void inicializarDatoGeneralEmpleado(DatoGeneralEmpleado datogeneralempleado) throws Exception {
		try {
				datogeneralempleado.setId(-1L);	
					
				datogeneralempleado.setid_numero_patronal(-1L);	
				datogeneralempleado.setid_tipo_afiliacion(-1L);	
				datogeneralempleado.setcarnet_iess("");	
				datogeneralempleado.setsectorial_iess("");	
				datogeneralempleado.setid_pais(-1L);	
				datogeneralempleado.setid_provincia(-1L);	
				datogeneralempleado.setid_canton(-1L);	
				datogeneralempleado.setid_parroquia(-1L);	
				datogeneralempleado.setfecha_nacimiento(new Date());	
				datogeneralempleado.setfecha_fallece(new Date());	
				datogeneralempleado.setvalor_evaluacion(0.0);	
				datogeneralempleado.setnumero_horas(0.0);	
				datogeneralempleado.setvalor_hora(0.0);	
				datogeneralempleado.setsalario(0.0);	
				datogeneralempleado.setid_moneda(-1L);	
				datogeneralempleado.setnumero_contrato("");	
				datogeneralempleado.setid_tipo_contrato(-1L);	
				datogeneralempleado.setvalor1(0.0);	
				datogeneralempleado.setvalor2(0.0);	
				datogeneralempleado.setvalor3(0.0);	
				datogeneralempleado.setvalor4(0.0);	
				datogeneralempleado.setvalor5(0.0);	
				datogeneralempleado.setvalor6(0.0);	
				datogeneralempleado.setcon_aporta_seguro_social(false);	
				datogeneralempleado.setcon_recibe_horas_extras(false);	
				datogeneralempleado.setcon_descuento_impuestos(false);	
				datogeneralempleado.setpension_alimenticia(0.0);	
				datogeneralempleado.setcon_pago_por_horas(false);	
				datogeneralempleado.setcon_anticipo(false);	
				datogeneralempleado.setid_tipo_libreta_mili(-1L);	
				datogeneralempleado.setlibreta_militar("");	
				datogeneralempleado.setid_tipo_grupo_forma_pago(-1L);	
				datogeneralempleado.setid_banco(-1L);	
				datogeneralempleado.setid_tipo_cuenta_banco_global(-1L);	
				datogeneralempleado.setnumero_cuenta("");	
				datogeneralempleado.setid_tipo_sangre(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDatoGeneralEmpleado(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDNUMEROPATRONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOAFILIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_CARNETIESS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_SECTORIALIESS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDCANTON);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDPARROQUIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHANACIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_FECHAFALLECE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOREVALUACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROHORAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALORHORA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_SALARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCONTRATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCONTRATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_VALOR6);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONAPORTASEGUROSOCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONRECIBEHORASEXTRAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONDESCUENTOIMPUESTOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_PENSIONALIMENTICIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONPAGOPORHORAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_CONANTICIPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOLIBRETAMILI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_LIBRETAMILITAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDBANCO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_NUMEROCUENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DatoGeneralEmpleadoConstantesFunciones.LABEL_IDTIPOSANGRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDatoGeneralEmpleado(String sTipo,Row row,Workbook workbook,DatoGeneralEmpleado datogeneralempleado,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getnumeropatronal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.gettipoafiliacion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getcarnet_iess());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getsectorial_iess());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getcanton_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getparroquia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getfecha_nacimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getfecha_fallece());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getvalor_evaluacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getnumero_horas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getvalor_hora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getsalario());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getnumero_contrato());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.gettipocontrato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getvalor1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getvalor2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getvalor3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getvalor4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getvalor5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getvalor6());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datogeneralempleado.getcon_aporta_seguro_social()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datogeneralempleado.getcon_recibe_horas_extras()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datogeneralempleado.getcon_descuento_impuestos()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getpension_alimenticia());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datogeneralempleado.getcon_pago_por_horas()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(datogeneralempleado.getcon_anticipo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.gettipolibretamili_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getlibreta_militar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.gettipogrupoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getbanco_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.gettipocuentabancoglobal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.getnumero_cuenta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(datogeneralempleado.gettiposangre_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDatoGeneralEmpleado=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDatoGeneralEmpleado() {
		return this.sFinalQueryDatoGeneralEmpleado;
	}
	
	public void setsFinalQueryDatoGeneralEmpleado(String sFinalQueryDatoGeneralEmpleado) {
		this.sFinalQueryDatoGeneralEmpleado= sFinalQueryDatoGeneralEmpleado;
	}
	
	public Border resaltarSeleccionarDatoGeneralEmpleado=null;
	
	public Border setResaltarSeleccionarDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDatoGeneralEmpleado= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDatoGeneralEmpleado() {
		return this.resaltarSeleccionarDatoGeneralEmpleado;
	}
	
	public void setResaltarSeleccionarDatoGeneralEmpleado(Border borderResaltarSeleccionarDatoGeneralEmpleado) {
		this.resaltarSeleccionarDatoGeneralEmpleado= borderResaltarSeleccionarDatoGeneralEmpleado;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltarid_empleadoDatoGeneralEmpleado=null;
	public Boolean mostrarid_empleadoDatoGeneralEmpleado=true;
	public Boolean activarid_empleadoDatoGeneralEmpleado=true;
	public Boolean cargarid_empleadoDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarid_numero_patronalDatoGeneralEmpleado=null;
	public Boolean mostrarid_numero_patronalDatoGeneralEmpleado=true;
	public Boolean activarid_numero_patronalDatoGeneralEmpleado=true;
	public Boolean cargarid_numero_patronalDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_numero_patronalDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_afiliacionDatoGeneralEmpleado=null;
	public Boolean mostrarid_tipo_afiliacionDatoGeneralEmpleado=true;
	public Boolean activarid_tipo_afiliacionDatoGeneralEmpleado=true;
	public Boolean cargarid_tipo_afiliacionDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_afiliacionDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarcarnet_iessDatoGeneralEmpleado=null;
	public Boolean mostrarcarnet_iessDatoGeneralEmpleado=true;
	public Boolean activarcarnet_iessDatoGeneralEmpleado=true;

	public Border resaltarsectorial_iessDatoGeneralEmpleado=null;
	public Boolean mostrarsectorial_iessDatoGeneralEmpleado=true;
	public Boolean activarsectorial_iessDatoGeneralEmpleado=true;

	public Border resaltarid_paisDatoGeneralEmpleado=null;
	public Boolean mostrarid_paisDatoGeneralEmpleado=true;
	public Boolean activarid_paisDatoGeneralEmpleado=true;
	public Boolean cargarid_paisDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarid_provinciaDatoGeneralEmpleado=null;
	public Boolean mostrarid_provinciaDatoGeneralEmpleado=true;
	public Boolean activarid_provinciaDatoGeneralEmpleado=true;
	public Boolean cargarid_provinciaDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarid_cantonDatoGeneralEmpleado=null;
	public Boolean mostrarid_cantonDatoGeneralEmpleado=true;
	public Boolean activarid_cantonDatoGeneralEmpleado=true;
	public Boolean cargarid_cantonDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cantonDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarid_parroquiaDatoGeneralEmpleado=null;
	public Boolean mostrarid_parroquiaDatoGeneralEmpleado=true;
	public Boolean activarid_parroquiaDatoGeneralEmpleado=true;
	public Boolean cargarid_parroquiaDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_parroquiaDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarfecha_nacimientoDatoGeneralEmpleado=null;
	public Boolean mostrarfecha_nacimientoDatoGeneralEmpleado=true;
	public Boolean activarfecha_nacimientoDatoGeneralEmpleado=false;

	public Border resaltarfecha_falleceDatoGeneralEmpleado=null;
	public Boolean mostrarfecha_falleceDatoGeneralEmpleado=true;
	public Boolean activarfecha_falleceDatoGeneralEmpleado=false;

	public Border resaltarvalor_evaluacionDatoGeneralEmpleado=null;
	public Boolean mostrarvalor_evaluacionDatoGeneralEmpleado=true;
	public Boolean activarvalor_evaluacionDatoGeneralEmpleado=true;

	public Border resaltarnumero_horasDatoGeneralEmpleado=null;
	public Boolean mostrarnumero_horasDatoGeneralEmpleado=true;
	public Boolean activarnumero_horasDatoGeneralEmpleado=true;

	public Border resaltarvalor_horaDatoGeneralEmpleado=null;
	public Boolean mostrarvalor_horaDatoGeneralEmpleado=true;
	public Boolean activarvalor_horaDatoGeneralEmpleado=true;

	public Border resaltarsalarioDatoGeneralEmpleado=null;
	public Boolean mostrarsalarioDatoGeneralEmpleado=true;
	public Boolean activarsalarioDatoGeneralEmpleado=true;

	public Border resaltarid_monedaDatoGeneralEmpleado=null;
	public Boolean mostrarid_monedaDatoGeneralEmpleado=true;
	public Boolean activarid_monedaDatoGeneralEmpleado=true;
	public Boolean cargarid_monedaDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarnumero_contratoDatoGeneralEmpleado=null;
	public Boolean mostrarnumero_contratoDatoGeneralEmpleado=true;
	public Boolean activarnumero_contratoDatoGeneralEmpleado=true;

	public Border resaltarid_tipo_contratoDatoGeneralEmpleado=null;
	public Boolean mostrarid_tipo_contratoDatoGeneralEmpleado=true;
	public Boolean activarid_tipo_contratoDatoGeneralEmpleado=true;
	public Boolean cargarid_tipo_contratoDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_contratoDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarvalor1DatoGeneralEmpleado=null;
	public Boolean mostrarvalor1DatoGeneralEmpleado=true;
	public Boolean activarvalor1DatoGeneralEmpleado=true;

	public Border resaltarvalor2DatoGeneralEmpleado=null;
	public Boolean mostrarvalor2DatoGeneralEmpleado=true;
	public Boolean activarvalor2DatoGeneralEmpleado=true;

	public Border resaltarvalor3DatoGeneralEmpleado=null;
	public Boolean mostrarvalor3DatoGeneralEmpleado=true;
	public Boolean activarvalor3DatoGeneralEmpleado=true;

	public Border resaltarvalor4DatoGeneralEmpleado=null;
	public Boolean mostrarvalor4DatoGeneralEmpleado=true;
	public Boolean activarvalor4DatoGeneralEmpleado=true;

	public Border resaltarvalor5DatoGeneralEmpleado=null;
	public Boolean mostrarvalor5DatoGeneralEmpleado=true;
	public Boolean activarvalor5DatoGeneralEmpleado=true;

	public Border resaltarvalor6DatoGeneralEmpleado=null;
	public Boolean mostrarvalor6DatoGeneralEmpleado=true;
	public Boolean activarvalor6DatoGeneralEmpleado=true;

	public Border resaltarcon_aporta_seguro_socialDatoGeneralEmpleado=null;
	public Boolean mostrarcon_aporta_seguro_socialDatoGeneralEmpleado=true;
	public Boolean activarcon_aporta_seguro_socialDatoGeneralEmpleado=true;

	public Border resaltarcon_recibe_horas_extrasDatoGeneralEmpleado=null;
	public Boolean mostrarcon_recibe_horas_extrasDatoGeneralEmpleado=true;
	public Boolean activarcon_recibe_horas_extrasDatoGeneralEmpleado=true;

	public Border resaltarcon_descuento_impuestosDatoGeneralEmpleado=null;
	public Boolean mostrarcon_descuento_impuestosDatoGeneralEmpleado=true;
	public Boolean activarcon_descuento_impuestosDatoGeneralEmpleado=true;

	public Border resaltarpension_alimenticiaDatoGeneralEmpleado=null;
	public Boolean mostrarpension_alimenticiaDatoGeneralEmpleado=true;
	public Boolean activarpension_alimenticiaDatoGeneralEmpleado=true;

	public Border resaltarcon_pago_por_horasDatoGeneralEmpleado=null;
	public Boolean mostrarcon_pago_por_horasDatoGeneralEmpleado=true;
	public Boolean activarcon_pago_por_horasDatoGeneralEmpleado=true;

	public Border resaltarcon_anticipoDatoGeneralEmpleado=null;
	public Boolean mostrarcon_anticipoDatoGeneralEmpleado=true;
	public Boolean activarcon_anticipoDatoGeneralEmpleado=true;

	public Border resaltarid_tipo_libreta_miliDatoGeneralEmpleado=null;
	public Boolean mostrarid_tipo_libreta_miliDatoGeneralEmpleado=true;
	public Boolean activarid_tipo_libreta_miliDatoGeneralEmpleado=true;
	public Boolean cargarid_tipo_libreta_miliDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_libreta_miliDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarlibreta_militarDatoGeneralEmpleado=null;
	public Boolean mostrarlibreta_militarDatoGeneralEmpleado=true;
	public Boolean activarlibreta_militarDatoGeneralEmpleado=true;

	public Border resaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado=null;
	public Boolean mostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado=true;
	public Boolean activarid_tipo_grupo_forma_pagoDatoGeneralEmpleado=true;
	public Boolean cargarid_tipo_grupo_forma_pagoDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_grupo_forma_pagoDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarid_bancoDatoGeneralEmpleado=null;
	public Boolean mostrarid_bancoDatoGeneralEmpleado=true;
	public Boolean activarid_bancoDatoGeneralEmpleado=true;
	public Boolean cargarid_bancoDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bancoDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado=null;
	public Boolean mostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado=true;
	public Boolean activarid_tipo_cuenta_banco_globalDatoGeneralEmpleado=true;
	public Boolean cargarid_tipo_cuenta_banco_globalDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuenta_banco_globalDatoGeneralEmpleado=false;//ConEventDepend=true

	public Border resaltarnumero_cuentaDatoGeneralEmpleado=null;
	public Boolean mostrarnumero_cuentaDatoGeneralEmpleado=true;
	public Boolean activarnumero_cuentaDatoGeneralEmpleado=true;

	public Border resaltarid_tipo_sangreDatoGeneralEmpleado=null;
	public Boolean mostrarid_tipo_sangreDatoGeneralEmpleado=true;
	public Boolean activarid_tipo_sangreDatoGeneralEmpleado=true;
	public Boolean cargarid_tipo_sangreDatoGeneralEmpleado=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_sangreDatoGeneralEmpleado=false;//ConEventDepend=true

	
	

	public Border setResaltarid_empleadoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_empleadoDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoDatoGeneralEmpleado() {
		return this.resaltarid_empleadoDatoGeneralEmpleado;
	}

	public void setResaltarid_empleadoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_empleadoDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_empleadoDatoGeneralEmpleado() {
		return this.mostrarid_empleadoDatoGeneralEmpleado;
	}

	public void setMostrarid_empleadoDatoGeneralEmpleado(Boolean mostrarid_empleadoDatoGeneralEmpleado) {
		this.mostrarid_empleadoDatoGeneralEmpleado= mostrarid_empleadoDatoGeneralEmpleado;
	}

	public Boolean getActivarid_empleadoDatoGeneralEmpleado() {
		return this.activarid_empleadoDatoGeneralEmpleado;
	}

	public void setActivarid_empleadoDatoGeneralEmpleado(Boolean activarid_empleadoDatoGeneralEmpleado) {
		this.activarid_empleadoDatoGeneralEmpleado= activarid_empleadoDatoGeneralEmpleado;
	}

	public Boolean getCargarid_empleadoDatoGeneralEmpleado() {
		return this.cargarid_empleadoDatoGeneralEmpleado;
	}

	public void setCargarid_empleadoDatoGeneralEmpleado(Boolean cargarid_empleadoDatoGeneralEmpleado) {
		this.cargarid_empleadoDatoGeneralEmpleado= cargarid_empleadoDatoGeneralEmpleado;
	}

	public Border setResaltarid_numero_patronalDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_numero_patronalDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_numero_patronalDatoGeneralEmpleado() {
		return this.resaltarid_numero_patronalDatoGeneralEmpleado;
	}

	public void setResaltarid_numero_patronalDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_numero_patronalDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_numero_patronalDatoGeneralEmpleado() {
		return this.mostrarid_numero_patronalDatoGeneralEmpleado;
	}

	public void setMostrarid_numero_patronalDatoGeneralEmpleado(Boolean mostrarid_numero_patronalDatoGeneralEmpleado) {
		this.mostrarid_numero_patronalDatoGeneralEmpleado= mostrarid_numero_patronalDatoGeneralEmpleado;
	}

	public Boolean getActivarid_numero_patronalDatoGeneralEmpleado() {
		return this.activarid_numero_patronalDatoGeneralEmpleado;
	}

	public void setActivarid_numero_patronalDatoGeneralEmpleado(Boolean activarid_numero_patronalDatoGeneralEmpleado) {
		this.activarid_numero_patronalDatoGeneralEmpleado= activarid_numero_patronalDatoGeneralEmpleado;
	}

	public Boolean getCargarid_numero_patronalDatoGeneralEmpleado() {
		return this.cargarid_numero_patronalDatoGeneralEmpleado;
	}

	public void setCargarid_numero_patronalDatoGeneralEmpleado(Boolean cargarid_numero_patronalDatoGeneralEmpleado) {
		this.cargarid_numero_patronalDatoGeneralEmpleado= cargarid_numero_patronalDatoGeneralEmpleado;
	}

	public Border setResaltarid_tipo_afiliacionDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_afiliacionDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_afiliacionDatoGeneralEmpleado() {
		return this.resaltarid_tipo_afiliacionDatoGeneralEmpleado;
	}

	public void setResaltarid_tipo_afiliacionDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_afiliacionDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_afiliacionDatoGeneralEmpleado() {
		return this.mostrarid_tipo_afiliacionDatoGeneralEmpleado;
	}

	public void setMostrarid_tipo_afiliacionDatoGeneralEmpleado(Boolean mostrarid_tipo_afiliacionDatoGeneralEmpleado) {
		this.mostrarid_tipo_afiliacionDatoGeneralEmpleado= mostrarid_tipo_afiliacionDatoGeneralEmpleado;
	}

	public Boolean getActivarid_tipo_afiliacionDatoGeneralEmpleado() {
		return this.activarid_tipo_afiliacionDatoGeneralEmpleado;
	}

	public void setActivarid_tipo_afiliacionDatoGeneralEmpleado(Boolean activarid_tipo_afiliacionDatoGeneralEmpleado) {
		this.activarid_tipo_afiliacionDatoGeneralEmpleado= activarid_tipo_afiliacionDatoGeneralEmpleado;
	}

	public Boolean getCargarid_tipo_afiliacionDatoGeneralEmpleado() {
		return this.cargarid_tipo_afiliacionDatoGeneralEmpleado;
	}

	public void setCargarid_tipo_afiliacionDatoGeneralEmpleado(Boolean cargarid_tipo_afiliacionDatoGeneralEmpleado) {
		this.cargarid_tipo_afiliacionDatoGeneralEmpleado= cargarid_tipo_afiliacionDatoGeneralEmpleado;
	}

	public Border setResaltarcarnet_iessDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarcarnet_iessDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcarnet_iessDatoGeneralEmpleado() {
		return this.resaltarcarnet_iessDatoGeneralEmpleado;
	}

	public void setResaltarcarnet_iessDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarcarnet_iessDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarcarnet_iessDatoGeneralEmpleado() {
		return this.mostrarcarnet_iessDatoGeneralEmpleado;
	}

	public void setMostrarcarnet_iessDatoGeneralEmpleado(Boolean mostrarcarnet_iessDatoGeneralEmpleado) {
		this.mostrarcarnet_iessDatoGeneralEmpleado= mostrarcarnet_iessDatoGeneralEmpleado;
	}

	public Boolean getActivarcarnet_iessDatoGeneralEmpleado() {
		return this.activarcarnet_iessDatoGeneralEmpleado;
	}

	public void setActivarcarnet_iessDatoGeneralEmpleado(Boolean activarcarnet_iessDatoGeneralEmpleado) {
		this.activarcarnet_iessDatoGeneralEmpleado= activarcarnet_iessDatoGeneralEmpleado;
	}

	public Border setResaltarsectorial_iessDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarsectorial_iessDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsectorial_iessDatoGeneralEmpleado() {
		return this.resaltarsectorial_iessDatoGeneralEmpleado;
	}

	public void setResaltarsectorial_iessDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarsectorial_iessDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarsectorial_iessDatoGeneralEmpleado() {
		return this.mostrarsectorial_iessDatoGeneralEmpleado;
	}

	public void setMostrarsectorial_iessDatoGeneralEmpleado(Boolean mostrarsectorial_iessDatoGeneralEmpleado) {
		this.mostrarsectorial_iessDatoGeneralEmpleado= mostrarsectorial_iessDatoGeneralEmpleado;
	}

	public Boolean getActivarsectorial_iessDatoGeneralEmpleado() {
		return this.activarsectorial_iessDatoGeneralEmpleado;
	}

	public void setActivarsectorial_iessDatoGeneralEmpleado(Boolean activarsectorial_iessDatoGeneralEmpleado) {
		this.activarsectorial_iessDatoGeneralEmpleado= activarsectorial_iessDatoGeneralEmpleado;
	}

	public Border setResaltarid_paisDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_paisDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisDatoGeneralEmpleado() {
		return this.resaltarid_paisDatoGeneralEmpleado;
	}

	public void setResaltarid_paisDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_paisDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_paisDatoGeneralEmpleado() {
		return this.mostrarid_paisDatoGeneralEmpleado;
	}

	public void setMostrarid_paisDatoGeneralEmpleado(Boolean mostrarid_paisDatoGeneralEmpleado) {
		this.mostrarid_paisDatoGeneralEmpleado= mostrarid_paisDatoGeneralEmpleado;
	}

	public Boolean getActivarid_paisDatoGeneralEmpleado() {
		return this.activarid_paisDatoGeneralEmpleado;
	}

	public void setActivarid_paisDatoGeneralEmpleado(Boolean activarid_paisDatoGeneralEmpleado) {
		this.activarid_paisDatoGeneralEmpleado= activarid_paisDatoGeneralEmpleado;
	}

	public Boolean getCargarid_paisDatoGeneralEmpleado() {
		return this.cargarid_paisDatoGeneralEmpleado;
	}

	public void setCargarid_paisDatoGeneralEmpleado(Boolean cargarid_paisDatoGeneralEmpleado) {
		this.cargarid_paisDatoGeneralEmpleado= cargarid_paisDatoGeneralEmpleado;
	}

	public Border setResaltarid_provinciaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_provinciaDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaDatoGeneralEmpleado() {
		return this.resaltarid_provinciaDatoGeneralEmpleado;
	}

	public void setResaltarid_provinciaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_provinciaDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_provinciaDatoGeneralEmpleado() {
		return this.mostrarid_provinciaDatoGeneralEmpleado;
	}

	public void setMostrarid_provinciaDatoGeneralEmpleado(Boolean mostrarid_provinciaDatoGeneralEmpleado) {
		this.mostrarid_provinciaDatoGeneralEmpleado= mostrarid_provinciaDatoGeneralEmpleado;
	}

	public Boolean getActivarid_provinciaDatoGeneralEmpleado() {
		return this.activarid_provinciaDatoGeneralEmpleado;
	}

	public void setActivarid_provinciaDatoGeneralEmpleado(Boolean activarid_provinciaDatoGeneralEmpleado) {
		this.activarid_provinciaDatoGeneralEmpleado= activarid_provinciaDatoGeneralEmpleado;
	}

	public Boolean getCargarid_provinciaDatoGeneralEmpleado() {
		return this.cargarid_provinciaDatoGeneralEmpleado;
	}

	public void setCargarid_provinciaDatoGeneralEmpleado(Boolean cargarid_provinciaDatoGeneralEmpleado) {
		this.cargarid_provinciaDatoGeneralEmpleado= cargarid_provinciaDatoGeneralEmpleado;
	}

	public Border setResaltarid_cantonDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_cantonDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cantonDatoGeneralEmpleado() {
		return this.resaltarid_cantonDatoGeneralEmpleado;
	}

	public void setResaltarid_cantonDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_cantonDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_cantonDatoGeneralEmpleado() {
		return this.mostrarid_cantonDatoGeneralEmpleado;
	}

	public void setMostrarid_cantonDatoGeneralEmpleado(Boolean mostrarid_cantonDatoGeneralEmpleado) {
		this.mostrarid_cantonDatoGeneralEmpleado= mostrarid_cantonDatoGeneralEmpleado;
	}

	public Boolean getActivarid_cantonDatoGeneralEmpleado() {
		return this.activarid_cantonDatoGeneralEmpleado;
	}

	public void setActivarid_cantonDatoGeneralEmpleado(Boolean activarid_cantonDatoGeneralEmpleado) {
		this.activarid_cantonDatoGeneralEmpleado= activarid_cantonDatoGeneralEmpleado;
	}

	public Boolean getCargarid_cantonDatoGeneralEmpleado() {
		return this.cargarid_cantonDatoGeneralEmpleado;
	}

	public void setCargarid_cantonDatoGeneralEmpleado(Boolean cargarid_cantonDatoGeneralEmpleado) {
		this.cargarid_cantonDatoGeneralEmpleado= cargarid_cantonDatoGeneralEmpleado;
	}

	public Border setResaltarid_parroquiaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_parroquiaDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_parroquiaDatoGeneralEmpleado() {
		return this.resaltarid_parroquiaDatoGeneralEmpleado;
	}

	public void setResaltarid_parroquiaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_parroquiaDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_parroquiaDatoGeneralEmpleado() {
		return this.mostrarid_parroquiaDatoGeneralEmpleado;
	}

	public void setMostrarid_parroquiaDatoGeneralEmpleado(Boolean mostrarid_parroquiaDatoGeneralEmpleado) {
		this.mostrarid_parroquiaDatoGeneralEmpleado= mostrarid_parroquiaDatoGeneralEmpleado;
	}

	public Boolean getActivarid_parroquiaDatoGeneralEmpleado() {
		return this.activarid_parroquiaDatoGeneralEmpleado;
	}

	public void setActivarid_parroquiaDatoGeneralEmpleado(Boolean activarid_parroquiaDatoGeneralEmpleado) {
		this.activarid_parroquiaDatoGeneralEmpleado= activarid_parroquiaDatoGeneralEmpleado;
	}

	public Boolean getCargarid_parroquiaDatoGeneralEmpleado() {
		return this.cargarid_parroquiaDatoGeneralEmpleado;
	}

	public void setCargarid_parroquiaDatoGeneralEmpleado(Boolean cargarid_parroquiaDatoGeneralEmpleado) {
		this.cargarid_parroquiaDatoGeneralEmpleado= cargarid_parroquiaDatoGeneralEmpleado;
	}

	public Border setResaltarfecha_nacimientoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarfecha_nacimientoDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_nacimientoDatoGeneralEmpleado() {
		return this.resaltarfecha_nacimientoDatoGeneralEmpleado;
	}

	public void setResaltarfecha_nacimientoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarfecha_nacimientoDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarfecha_nacimientoDatoGeneralEmpleado() {
		return this.mostrarfecha_nacimientoDatoGeneralEmpleado;
	}

	public void setMostrarfecha_nacimientoDatoGeneralEmpleado(Boolean mostrarfecha_nacimientoDatoGeneralEmpleado) {
		this.mostrarfecha_nacimientoDatoGeneralEmpleado= mostrarfecha_nacimientoDatoGeneralEmpleado;
	}

	public Boolean getActivarfecha_nacimientoDatoGeneralEmpleado() {
		return this.activarfecha_nacimientoDatoGeneralEmpleado;
	}

	public void setActivarfecha_nacimientoDatoGeneralEmpleado(Boolean activarfecha_nacimientoDatoGeneralEmpleado) {
		this.activarfecha_nacimientoDatoGeneralEmpleado= activarfecha_nacimientoDatoGeneralEmpleado;
	}

	public Border setResaltarfecha_falleceDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarfecha_falleceDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_falleceDatoGeneralEmpleado() {
		return this.resaltarfecha_falleceDatoGeneralEmpleado;
	}

	public void setResaltarfecha_falleceDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarfecha_falleceDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarfecha_falleceDatoGeneralEmpleado() {
		return this.mostrarfecha_falleceDatoGeneralEmpleado;
	}

	public void setMostrarfecha_falleceDatoGeneralEmpleado(Boolean mostrarfecha_falleceDatoGeneralEmpleado) {
		this.mostrarfecha_falleceDatoGeneralEmpleado= mostrarfecha_falleceDatoGeneralEmpleado;
	}

	public Boolean getActivarfecha_falleceDatoGeneralEmpleado() {
		return this.activarfecha_falleceDatoGeneralEmpleado;
	}

	public void setActivarfecha_falleceDatoGeneralEmpleado(Boolean activarfecha_falleceDatoGeneralEmpleado) {
		this.activarfecha_falleceDatoGeneralEmpleado= activarfecha_falleceDatoGeneralEmpleado;
	}

	public Border setResaltarvalor_evaluacionDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_evaluacionDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_evaluacionDatoGeneralEmpleado() {
		return this.resaltarvalor_evaluacionDatoGeneralEmpleado;
	}

	public void setResaltarvalor_evaluacionDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarvalor_evaluacionDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_evaluacionDatoGeneralEmpleado() {
		return this.mostrarvalor_evaluacionDatoGeneralEmpleado;
	}

	public void setMostrarvalor_evaluacionDatoGeneralEmpleado(Boolean mostrarvalor_evaluacionDatoGeneralEmpleado) {
		this.mostrarvalor_evaluacionDatoGeneralEmpleado= mostrarvalor_evaluacionDatoGeneralEmpleado;
	}

	public Boolean getActivarvalor_evaluacionDatoGeneralEmpleado() {
		return this.activarvalor_evaluacionDatoGeneralEmpleado;
	}

	public void setActivarvalor_evaluacionDatoGeneralEmpleado(Boolean activarvalor_evaluacionDatoGeneralEmpleado) {
		this.activarvalor_evaluacionDatoGeneralEmpleado= activarvalor_evaluacionDatoGeneralEmpleado;
	}

	public Border setResaltarnumero_horasDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_horasDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_horasDatoGeneralEmpleado() {
		return this.resaltarnumero_horasDatoGeneralEmpleado;
	}

	public void setResaltarnumero_horasDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarnumero_horasDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_horasDatoGeneralEmpleado() {
		return this.mostrarnumero_horasDatoGeneralEmpleado;
	}

	public void setMostrarnumero_horasDatoGeneralEmpleado(Boolean mostrarnumero_horasDatoGeneralEmpleado) {
		this.mostrarnumero_horasDatoGeneralEmpleado= mostrarnumero_horasDatoGeneralEmpleado;
	}

	public Boolean getActivarnumero_horasDatoGeneralEmpleado() {
		return this.activarnumero_horasDatoGeneralEmpleado;
	}

	public void setActivarnumero_horasDatoGeneralEmpleado(Boolean activarnumero_horasDatoGeneralEmpleado) {
		this.activarnumero_horasDatoGeneralEmpleado= activarnumero_horasDatoGeneralEmpleado;
	}

	public Border setResaltarvalor_horaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor_horaDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_horaDatoGeneralEmpleado() {
		return this.resaltarvalor_horaDatoGeneralEmpleado;
	}

	public void setResaltarvalor_horaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarvalor_horaDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor_horaDatoGeneralEmpleado() {
		return this.mostrarvalor_horaDatoGeneralEmpleado;
	}

	public void setMostrarvalor_horaDatoGeneralEmpleado(Boolean mostrarvalor_horaDatoGeneralEmpleado) {
		this.mostrarvalor_horaDatoGeneralEmpleado= mostrarvalor_horaDatoGeneralEmpleado;
	}

	public Boolean getActivarvalor_horaDatoGeneralEmpleado() {
		return this.activarvalor_horaDatoGeneralEmpleado;
	}

	public void setActivarvalor_horaDatoGeneralEmpleado(Boolean activarvalor_horaDatoGeneralEmpleado) {
		this.activarvalor_horaDatoGeneralEmpleado= activarvalor_horaDatoGeneralEmpleado;
	}

	public Border setResaltarsalarioDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarsalarioDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsalarioDatoGeneralEmpleado() {
		return this.resaltarsalarioDatoGeneralEmpleado;
	}

	public void setResaltarsalarioDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarsalarioDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarsalarioDatoGeneralEmpleado() {
		return this.mostrarsalarioDatoGeneralEmpleado;
	}

	public void setMostrarsalarioDatoGeneralEmpleado(Boolean mostrarsalarioDatoGeneralEmpleado) {
		this.mostrarsalarioDatoGeneralEmpleado= mostrarsalarioDatoGeneralEmpleado;
	}

	public Boolean getActivarsalarioDatoGeneralEmpleado() {
		return this.activarsalarioDatoGeneralEmpleado;
	}

	public void setActivarsalarioDatoGeneralEmpleado(Boolean activarsalarioDatoGeneralEmpleado) {
		this.activarsalarioDatoGeneralEmpleado= activarsalarioDatoGeneralEmpleado;
	}

	public Border setResaltarid_monedaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_monedaDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaDatoGeneralEmpleado() {
		return this.resaltarid_monedaDatoGeneralEmpleado;
	}

	public void setResaltarid_monedaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_monedaDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_monedaDatoGeneralEmpleado() {
		return this.mostrarid_monedaDatoGeneralEmpleado;
	}

	public void setMostrarid_monedaDatoGeneralEmpleado(Boolean mostrarid_monedaDatoGeneralEmpleado) {
		this.mostrarid_monedaDatoGeneralEmpleado= mostrarid_monedaDatoGeneralEmpleado;
	}

	public Boolean getActivarid_monedaDatoGeneralEmpleado() {
		return this.activarid_monedaDatoGeneralEmpleado;
	}

	public void setActivarid_monedaDatoGeneralEmpleado(Boolean activarid_monedaDatoGeneralEmpleado) {
		this.activarid_monedaDatoGeneralEmpleado= activarid_monedaDatoGeneralEmpleado;
	}

	public Boolean getCargarid_monedaDatoGeneralEmpleado() {
		return this.cargarid_monedaDatoGeneralEmpleado;
	}

	public void setCargarid_monedaDatoGeneralEmpleado(Boolean cargarid_monedaDatoGeneralEmpleado) {
		this.cargarid_monedaDatoGeneralEmpleado= cargarid_monedaDatoGeneralEmpleado;
	}

	public Border setResaltarnumero_contratoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_contratoDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_contratoDatoGeneralEmpleado() {
		return this.resaltarnumero_contratoDatoGeneralEmpleado;
	}

	public void setResaltarnumero_contratoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarnumero_contratoDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_contratoDatoGeneralEmpleado() {
		return this.mostrarnumero_contratoDatoGeneralEmpleado;
	}

	public void setMostrarnumero_contratoDatoGeneralEmpleado(Boolean mostrarnumero_contratoDatoGeneralEmpleado) {
		this.mostrarnumero_contratoDatoGeneralEmpleado= mostrarnumero_contratoDatoGeneralEmpleado;
	}

	public Boolean getActivarnumero_contratoDatoGeneralEmpleado() {
		return this.activarnumero_contratoDatoGeneralEmpleado;
	}

	public void setActivarnumero_contratoDatoGeneralEmpleado(Boolean activarnumero_contratoDatoGeneralEmpleado) {
		this.activarnumero_contratoDatoGeneralEmpleado= activarnumero_contratoDatoGeneralEmpleado;
	}

	public Border setResaltarid_tipo_contratoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_contratoDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_contratoDatoGeneralEmpleado() {
		return this.resaltarid_tipo_contratoDatoGeneralEmpleado;
	}

	public void setResaltarid_tipo_contratoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_contratoDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_contratoDatoGeneralEmpleado() {
		return this.mostrarid_tipo_contratoDatoGeneralEmpleado;
	}

	public void setMostrarid_tipo_contratoDatoGeneralEmpleado(Boolean mostrarid_tipo_contratoDatoGeneralEmpleado) {
		this.mostrarid_tipo_contratoDatoGeneralEmpleado= mostrarid_tipo_contratoDatoGeneralEmpleado;
	}

	public Boolean getActivarid_tipo_contratoDatoGeneralEmpleado() {
		return this.activarid_tipo_contratoDatoGeneralEmpleado;
	}

	public void setActivarid_tipo_contratoDatoGeneralEmpleado(Boolean activarid_tipo_contratoDatoGeneralEmpleado) {
		this.activarid_tipo_contratoDatoGeneralEmpleado= activarid_tipo_contratoDatoGeneralEmpleado;
	}

	public Boolean getCargarid_tipo_contratoDatoGeneralEmpleado() {
		return this.cargarid_tipo_contratoDatoGeneralEmpleado;
	}

	public void setCargarid_tipo_contratoDatoGeneralEmpleado(Boolean cargarid_tipo_contratoDatoGeneralEmpleado) {
		this.cargarid_tipo_contratoDatoGeneralEmpleado= cargarid_tipo_contratoDatoGeneralEmpleado;
	}

	public Border setResaltarvalor1DatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor1DatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor1DatoGeneralEmpleado() {
		return this.resaltarvalor1DatoGeneralEmpleado;
	}

	public void setResaltarvalor1DatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarvalor1DatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor1DatoGeneralEmpleado() {
		return this.mostrarvalor1DatoGeneralEmpleado;
	}

	public void setMostrarvalor1DatoGeneralEmpleado(Boolean mostrarvalor1DatoGeneralEmpleado) {
		this.mostrarvalor1DatoGeneralEmpleado= mostrarvalor1DatoGeneralEmpleado;
	}

	public Boolean getActivarvalor1DatoGeneralEmpleado() {
		return this.activarvalor1DatoGeneralEmpleado;
	}

	public void setActivarvalor1DatoGeneralEmpleado(Boolean activarvalor1DatoGeneralEmpleado) {
		this.activarvalor1DatoGeneralEmpleado= activarvalor1DatoGeneralEmpleado;
	}

	public Border setResaltarvalor2DatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor2DatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor2DatoGeneralEmpleado() {
		return this.resaltarvalor2DatoGeneralEmpleado;
	}

	public void setResaltarvalor2DatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarvalor2DatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor2DatoGeneralEmpleado() {
		return this.mostrarvalor2DatoGeneralEmpleado;
	}

	public void setMostrarvalor2DatoGeneralEmpleado(Boolean mostrarvalor2DatoGeneralEmpleado) {
		this.mostrarvalor2DatoGeneralEmpleado= mostrarvalor2DatoGeneralEmpleado;
	}

	public Boolean getActivarvalor2DatoGeneralEmpleado() {
		return this.activarvalor2DatoGeneralEmpleado;
	}

	public void setActivarvalor2DatoGeneralEmpleado(Boolean activarvalor2DatoGeneralEmpleado) {
		this.activarvalor2DatoGeneralEmpleado= activarvalor2DatoGeneralEmpleado;
	}

	public Border setResaltarvalor3DatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor3DatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor3DatoGeneralEmpleado() {
		return this.resaltarvalor3DatoGeneralEmpleado;
	}

	public void setResaltarvalor3DatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarvalor3DatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor3DatoGeneralEmpleado() {
		return this.mostrarvalor3DatoGeneralEmpleado;
	}

	public void setMostrarvalor3DatoGeneralEmpleado(Boolean mostrarvalor3DatoGeneralEmpleado) {
		this.mostrarvalor3DatoGeneralEmpleado= mostrarvalor3DatoGeneralEmpleado;
	}

	public Boolean getActivarvalor3DatoGeneralEmpleado() {
		return this.activarvalor3DatoGeneralEmpleado;
	}

	public void setActivarvalor3DatoGeneralEmpleado(Boolean activarvalor3DatoGeneralEmpleado) {
		this.activarvalor3DatoGeneralEmpleado= activarvalor3DatoGeneralEmpleado;
	}

	public Border setResaltarvalor4DatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor4DatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor4DatoGeneralEmpleado() {
		return this.resaltarvalor4DatoGeneralEmpleado;
	}

	public void setResaltarvalor4DatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarvalor4DatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor4DatoGeneralEmpleado() {
		return this.mostrarvalor4DatoGeneralEmpleado;
	}

	public void setMostrarvalor4DatoGeneralEmpleado(Boolean mostrarvalor4DatoGeneralEmpleado) {
		this.mostrarvalor4DatoGeneralEmpleado= mostrarvalor4DatoGeneralEmpleado;
	}

	public Boolean getActivarvalor4DatoGeneralEmpleado() {
		return this.activarvalor4DatoGeneralEmpleado;
	}

	public void setActivarvalor4DatoGeneralEmpleado(Boolean activarvalor4DatoGeneralEmpleado) {
		this.activarvalor4DatoGeneralEmpleado= activarvalor4DatoGeneralEmpleado;
	}

	public Border setResaltarvalor5DatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor5DatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor5DatoGeneralEmpleado() {
		return this.resaltarvalor5DatoGeneralEmpleado;
	}

	public void setResaltarvalor5DatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarvalor5DatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor5DatoGeneralEmpleado() {
		return this.mostrarvalor5DatoGeneralEmpleado;
	}

	public void setMostrarvalor5DatoGeneralEmpleado(Boolean mostrarvalor5DatoGeneralEmpleado) {
		this.mostrarvalor5DatoGeneralEmpleado= mostrarvalor5DatoGeneralEmpleado;
	}

	public Boolean getActivarvalor5DatoGeneralEmpleado() {
		return this.activarvalor5DatoGeneralEmpleado;
	}

	public void setActivarvalor5DatoGeneralEmpleado(Boolean activarvalor5DatoGeneralEmpleado) {
		this.activarvalor5DatoGeneralEmpleado= activarvalor5DatoGeneralEmpleado;
	}

	public Border setResaltarvalor6DatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarvalor6DatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor6DatoGeneralEmpleado() {
		return this.resaltarvalor6DatoGeneralEmpleado;
	}

	public void setResaltarvalor6DatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarvalor6DatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarvalor6DatoGeneralEmpleado() {
		return this.mostrarvalor6DatoGeneralEmpleado;
	}

	public void setMostrarvalor6DatoGeneralEmpleado(Boolean mostrarvalor6DatoGeneralEmpleado) {
		this.mostrarvalor6DatoGeneralEmpleado= mostrarvalor6DatoGeneralEmpleado;
	}

	public Boolean getActivarvalor6DatoGeneralEmpleado() {
		return this.activarvalor6DatoGeneralEmpleado;
	}

	public void setActivarvalor6DatoGeneralEmpleado(Boolean activarvalor6DatoGeneralEmpleado) {
		this.activarvalor6DatoGeneralEmpleado= activarvalor6DatoGeneralEmpleado;
	}

	public Border setResaltarcon_aporta_seguro_socialDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarcon_aporta_seguro_socialDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_aporta_seguro_socialDatoGeneralEmpleado() {
		return this.resaltarcon_aporta_seguro_socialDatoGeneralEmpleado;
	}

	public void setResaltarcon_aporta_seguro_socialDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarcon_aporta_seguro_socialDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarcon_aporta_seguro_socialDatoGeneralEmpleado() {
		return this.mostrarcon_aporta_seguro_socialDatoGeneralEmpleado;
	}

	public void setMostrarcon_aporta_seguro_socialDatoGeneralEmpleado(Boolean mostrarcon_aporta_seguro_socialDatoGeneralEmpleado) {
		this.mostrarcon_aporta_seguro_socialDatoGeneralEmpleado= mostrarcon_aporta_seguro_socialDatoGeneralEmpleado;
	}

	public Boolean getActivarcon_aporta_seguro_socialDatoGeneralEmpleado() {
		return this.activarcon_aporta_seguro_socialDatoGeneralEmpleado;
	}

	public void setActivarcon_aporta_seguro_socialDatoGeneralEmpleado(Boolean activarcon_aporta_seguro_socialDatoGeneralEmpleado) {
		this.activarcon_aporta_seguro_socialDatoGeneralEmpleado= activarcon_aporta_seguro_socialDatoGeneralEmpleado;
	}

	public Border setResaltarcon_recibe_horas_extrasDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarcon_recibe_horas_extrasDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_recibe_horas_extrasDatoGeneralEmpleado() {
		return this.resaltarcon_recibe_horas_extrasDatoGeneralEmpleado;
	}

	public void setResaltarcon_recibe_horas_extrasDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarcon_recibe_horas_extrasDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarcon_recibe_horas_extrasDatoGeneralEmpleado() {
		return this.mostrarcon_recibe_horas_extrasDatoGeneralEmpleado;
	}

	public void setMostrarcon_recibe_horas_extrasDatoGeneralEmpleado(Boolean mostrarcon_recibe_horas_extrasDatoGeneralEmpleado) {
		this.mostrarcon_recibe_horas_extrasDatoGeneralEmpleado= mostrarcon_recibe_horas_extrasDatoGeneralEmpleado;
	}

	public Boolean getActivarcon_recibe_horas_extrasDatoGeneralEmpleado() {
		return this.activarcon_recibe_horas_extrasDatoGeneralEmpleado;
	}

	public void setActivarcon_recibe_horas_extrasDatoGeneralEmpleado(Boolean activarcon_recibe_horas_extrasDatoGeneralEmpleado) {
		this.activarcon_recibe_horas_extrasDatoGeneralEmpleado= activarcon_recibe_horas_extrasDatoGeneralEmpleado;
	}

	public Border setResaltarcon_descuento_impuestosDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarcon_descuento_impuestosDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_descuento_impuestosDatoGeneralEmpleado() {
		return this.resaltarcon_descuento_impuestosDatoGeneralEmpleado;
	}

	public void setResaltarcon_descuento_impuestosDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarcon_descuento_impuestosDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarcon_descuento_impuestosDatoGeneralEmpleado() {
		return this.mostrarcon_descuento_impuestosDatoGeneralEmpleado;
	}

	public void setMostrarcon_descuento_impuestosDatoGeneralEmpleado(Boolean mostrarcon_descuento_impuestosDatoGeneralEmpleado) {
		this.mostrarcon_descuento_impuestosDatoGeneralEmpleado= mostrarcon_descuento_impuestosDatoGeneralEmpleado;
	}

	public Boolean getActivarcon_descuento_impuestosDatoGeneralEmpleado() {
		return this.activarcon_descuento_impuestosDatoGeneralEmpleado;
	}

	public void setActivarcon_descuento_impuestosDatoGeneralEmpleado(Boolean activarcon_descuento_impuestosDatoGeneralEmpleado) {
		this.activarcon_descuento_impuestosDatoGeneralEmpleado= activarcon_descuento_impuestosDatoGeneralEmpleado;
	}

	public Border setResaltarpension_alimenticiaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarpension_alimenticiaDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpension_alimenticiaDatoGeneralEmpleado() {
		return this.resaltarpension_alimenticiaDatoGeneralEmpleado;
	}

	public void setResaltarpension_alimenticiaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarpension_alimenticiaDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarpension_alimenticiaDatoGeneralEmpleado() {
		return this.mostrarpension_alimenticiaDatoGeneralEmpleado;
	}

	public void setMostrarpension_alimenticiaDatoGeneralEmpleado(Boolean mostrarpension_alimenticiaDatoGeneralEmpleado) {
		this.mostrarpension_alimenticiaDatoGeneralEmpleado= mostrarpension_alimenticiaDatoGeneralEmpleado;
	}

	public Boolean getActivarpension_alimenticiaDatoGeneralEmpleado() {
		return this.activarpension_alimenticiaDatoGeneralEmpleado;
	}

	public void setActivarpension_alimenticiaDatoGeneralEmpleado(Boolean activarpension_alimenticiaDatoGeneralEmpleado) {
		this.activarpension_alimenticiaDatoGeneralEmpleado= activarpension_alimenticiaDatoGeneralEmpleado;
	}

	public Border setResaltarcon_pago_por_horasDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarcon_pago_por_horasDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_pago_por_horasDatoGeneralEmpleado() {
		return this.resaltarcon_pago_por_horasDatoGeneralEmpleado;
	}

	public void setResaltarcon_pago_por_horasDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarcon_pago_por_horasDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarcon_pago_por_horasDatoGeneralEmpleado() {
		return this.mostrarcon_pago_por_horasDatoGeneralEmpleado;
	}

	public void setMostrarcon_pago_por_horasDatoGeneralEmpleado(Boolean mostrarcon_pago_por_horasDatoGeneralEmpleado) {
		this.mostrarcon_pago_por_horasDatoGeneralEmpleado= mostrarcon_pago_por_horasDatoGeneralEmpleado;
	}

	public Boolean getActivarcon_pago_por_horasDatoGeneralEmpleado() {
		return this.activarcon_pago_por_horasDatoGeneralEmpleado;
	}

	public void setActivarcon_pago_por_horasDatoGeneralEmpleado(Boolean activarcon_pago_por_horasDatoGeneralEmpleado) {
		this.activarcon_pago_por_horasDatoGeneralEmpleado= activarcon_pago_por_horasDatoGeneralEmpleado;
	}

	public Border setResaltarcon_anticipoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarcon_anticipoDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_anticipoDatoGeneralEmpleado() {
		return this.resaltarcon_anticipoDatoGeneralEmpleado;
	}

	public void setResaltarcon_anticipoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarcon_anticipoDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarcon_anticipoDatoGeneralEmpleado() {
		return this.mostrarcon_anticipoDatoGeneralEmpleado;
	}

	public void setMostrarcon_anticipoDatoGeneralEmpleado(Boolean mostrarcon_anticipoDatoGeneralEmpleado) {
		this.mostrarcon_anticipoDatoGeneralEmpleado= mostrarcon_anticipoDatoGeneralEmpleado;
	}

	public Boolean getActivarcon_anticipoDatoGeneralEmpleado() {
		return this.activarcon_anticipoDatoGeneralEmpleado;
	}

	public void setActivarcon_anticipoDatoGeneralEmpleado(Boolean activarcon_anticipoDatoGeneralEmpleado) {
		this.activarcon_anticipoDatoGeneralEmpleado= activarcon_anticipoDatoGeneralEmpleado;
	}

	public Border setResaltarid_tipo_libreta_miliDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_libreta_miliDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_libreta_miliDatoGeneralEmpleado() {
		return this.resaltarid_tipo_libreta_miliDatoGeneralEmpleado;
	}

	public void setResaltarid_tipo_libreta_miliDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_libreta_miliDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_libreta_miliDatoGeneralEmpleado() {
		return this.mostrarid_tipo_libreta_miliDatoGeneralEmpleado;
	}

	public void setMostrarid_tipo_libreta_miliDatoGeneralEmpleado(Boolean mostrarid_tipo_libreta_miliDatoGeneralEmpleado) {
		this.mostrarid_tipo_libreta_miliDatoGeneralEmpleado= mostrarid_tipo_libreta_miliDatoGeneralEmpleado;
	}

	public Boolean getActivarid_tipo_libreta_miliDatoGeneralEmpleado() {
		return this.activarid_tipo_libreta_miliDatoGeneralEmpleado;
	}

	public void setActivarid_tipo_libreta_miliDatoGeneralEmpleado(Boolean activarid_tipo_libreta_miliDatoGeneralEmpleado) {
		this.activarid_tipo_libreta_miliDatoGeneralEmpleado= activarid_tipo_libreta_miliDatoGeneralEmpleado;
	}

	public Boolean getCargarid_tipo_libreta_miliDatoGeneralEmpleado() {
		return this.cargarid_tipo_libreta_miliDatoGeneralEmpleado;
	}

	public void setCargarid_tipo_libreta_miliDatoGeneralEmpleado(Boolean cargarid_tipo_libreta_miliDatoGeneralEmpleado) {
		this.cargarid_tipo_libreta_miliDatoGeneralEmpleado= cargarid_tipo_libreta_miliDatoGeneralEmpleado;
	}

	public Border setResaltarlibreta_militarDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarlibreta_militarDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlibreta_militarDatoGeneralEmpleado() {
		return this.resaltarlibreta_militarDatoGeneralEmpleado;
	}

	public void setResaltarlibreta_militarDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarlibreta_militarDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarlibreta_militarDatoGeneralEmpleado() {
		return this.mostrarlibreta_militarDatoGeneralEmpleado;
	}

	public void setMostrarlibreta_militarDatoGeneralEmpleado(Boolean mostrarlibreta_militarDatoGeneralEmpleado) {
		this.mostrarlibreta_militarDatoGeneralEmpleado= mostrarlibreta_militarDatoGeneralEmpleado;
	}

	public Boolean getActivarlibreta_militarDatoGeneralEmpleado() {
		return this.activarlibreta_militarDatoGeneralEmpleado;
	}

	public void setActivarlibreta_militarDatoGeneralEmpleado(Boolean activarlibreta_militarDatoGeneralEmpleado) {
		this.activarlibreta_militarDatoGeneralEmpleado= activarlibreta_militarDatoGeneralEmpleado;
	}

	public Border setResaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado() {
		return this.resaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado;
	}

	public void setResaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado() {
		return this.mostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado;
	}

	public void setMostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(Boolean mostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado) {
		this.mostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado= mostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado;
	}

	public Boolean getActivarid_tipo_grupo_forma_pagoDatoGeneralEmpleado() {
		return this.activarid_tipo_grupo_forma_pagoDatoGeneralEmpleado;
	}

	public void setActivarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(Boolean activarid_tipo_grupo_forma_pagoDatoGeneralEmpleado) {
		this.activarid_tipo_grupo_forma_pagoDatoGeneralEmpleado= activarid_tipo_grupo_forma_pagoDatoGeneralEmpleado;
	}

	public Boolean getCargarid_tipo_grupo_forma_pagoDatoGeneralEmpleado() {
		return this.cargarid_tipo_grupo_forma_pagoDatoGeneralEmpleado;
	}

	public void setCargarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(Boolean cargarid_tipo_grupo_forma_pagoDatoGeneralEmpleado) {
		this.cargarid_tipo_grupo_forma_pagoDatoGeneralEmpleado= cargarid_tipo_grupo_forma_pagoDatoGeneralEmpleado;
	}

	public Border setResaltarid_bancoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_bancoDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bancoDatoGeneralEmpleado() {
		return this.resaltarid_bancoDatoGeneralEmpleado;
	}

	public void setResaltarid_bancoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_bancoDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_bancoDatoGeneralEmpleado() {
		return this.mostrarid_bancoDatoGeneralEmpleado;
	}

	public void setMostrarid_bancoDatoGeneralEmpleado(Boolean mostrarid_bancoDatoGeneralEmpleado) {
		this.mostrarid_bancoDatoGeneralEmpleado= mostrarid_bancoDatoGeneralEmpleado;
	}

	public Boolean getActivarid_bancoDatoGeneralEmpleado() {
		return this.activarid_bancoDatoGeneralEmpleado;
	}

	public void setActivarid_bancoDatoGeneralEmpleado(Boolean activarid_bancoDatoGeneralEmpleado) {
		this.activarid_bancoDatoGeneralEmpleado= activarid_bancoDatoGeneralEmpleado;
	}

	public Boolean getCargarid_bancoDatoGeneralEmpleado() {
		return this.cargarid_bancoDatoGeneralEmpleado;
	}

	public void setCargarid_bancoDatoGeneralEmpleado(Boolean cargarid_bancoDatoGeneralEmpleado) {
		this.cargarid_bancoDatoGeneralEmpleado= cargarid_bancoDatoGeneralEmpleado;
	}

	public Border setResaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado() {
		return this.resaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado;
	}

	public void setResaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado() {
		return this.mostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado;
	}

	public void setMostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(Boolean mostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado) {
		this.mostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado= mostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado;
	}

	public Boolean getActivarid_tipo_cuenta_banco_globalDatoGeneralEmpleado() {
		return this.activarid_tipo_cuenta_banco_globalDatoGeneralEmpleado;
	}

	public void setActivarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(Boolean activarid_tipo_cuenta_banco_globalDatoGeneralEmpleado) {
		this.activarid_tipo_cuenta_banco_globalDatoGeneralEmpleado= activarid_tipo_cuenta_banco_globalDatoGeneralEmpleado;
	}

	public Boolean getCargarid_tipo_cuenta_banco_globalDatoGeneralEmpleado() {
		return this.cargarid_tipo_cuenta_banco_globalDatoGeneralEmpleado;
	}

	public void setCargarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(Boolean cargarid_tipo_cuenta_banco_globalDatoGeneralEmpleado) {
		this.cargarid_tipo_cuenta_banco_globalDatoGeneralEmpleado= cargarid_tipo_cuenta_banco_globalDatoGeneralEmpleado;
	}

	public Border setResaltarnumero_cuentaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarnumero_cuentaDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_cuentaDatoGeneralEmpleado() {
		return this.resaltarnumero_cuentaDatoGeneralEmpleado;
	}

	public void setResaltarnumero_cuentaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarnumero_cuentaDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarnumero_cuentaDatoGeneralEmpleado() {
		return this.mostrarnumero_cuentaDatoGeneralEmpleado;
	}

	public void setMostrarnumero_cuentaDatoGeneralEmpleado(Boolean mostrarnumero_cuentaDatoGeneralEmpleado) {
		this.mostrarnumero_cuentaDatoGeneralEmpleado= mostrarnumero_cuentaDatoGeneralEmpleado;
	}

	public Boolean getActivarnumero_cuentaDatoGeneralEmpleado() {
		return this.activarnumero_cuentaDatoGeneralEmpleado;
	}

	public void setActivarnumero_cuentaDatoGeneralEmpleado(Boolean activarnumero_cuentaDatoGeneralEmpleado) {
		this.activarnumero_cuentaDatoGeneralEmpleado= activarnumero_cuentaDatoGeneralEmpleado;
	}

	public Border setResaltarid_tipo_sangreDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//datogeneralempleadoBeanSwingJInternalFrame.jTtoolBarDatoGeneralEmpleado.setBorder(borderResaltar);
		
		this.resaltarid_tipo_sangreDatoGeneralEmpleado= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_sangreDatoGeneralEmpleado() {
		return this.resaltarid_tipo_sangreDatoGeneralEmpleado;
	}

	public void setResaltarid_tipo_sangreDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarid_tipo_sangreDatoGeneralEmpleado= borderResaltar;
	}

	public Boolean getMostrarid_tipo_sangreDatoGeneralEmpleado() {
		return this.mostrarid_tipo_sangreDatoGeneralEmpleado;
	}

	public void setMostrarid_tipo_sangreDatoGeneralEmpleado(Boolean mostrarid_tipo_sangreDatoGeneralEmpleado) {
		this.mostrarid_tipo_sangreDatoGeneralEmpleado= mostrarid_tipo_sangreDatoGeneralEmpleado;
	}

	public Boolean getActivarid_tipo_sangreDatoGeneralEmpleado() {
		return this.activarid_tipo_sangreDatoGeneralEmpleado;
	}

	public void setActivarid_tipo_sangreDatoGeneralEmpleado(Boolean activarid_tipo_sangreDatoGeneralEmpleado) {
		this.activarid_tipo_sangreDatoGeneralEmpleado= activarid_tipo_sangreDatoGeneralEmpleado;
	}

	public Boolean getCargarid_tipo_sangreDatoGeneralEmpleado() {
		return this.cargarid_tipo_sangreDatoGeneralEmpleado;
	}

	public void setCargarid_tipo_sangreDatoGeneralEmpleado(Boolean cargarid_tipo_sangreDatoGeneralEmpleado) {
		this.cargarid_tipo_sangreDatoGeneralEmpleado= cargarid_tipo_sangreDatoGeneralEmpleado;
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
		
		
		this.setMostrarid_empleadoDatoGeneralEmpleado(esInicial);
		this.setMostrarid_numero_patronalDatoGeneralEmpleado(esInicial);
		this.setMostrarid_tipo_afiliacionDatoGeneralEmpleado(esInicial);
		this.setMostrarcarnet_iessDatoGeneralEmpleado(esInicial);
		this.setMostrarsectorial_iessDatoGeneralEmpleado(esInicial);
		this.setMostrarid_paisDatoGeneralEmpleado(esInicial);
		this.setMostrarid_provinciaDatoGeneralEmpleado(esInicial);
		this.setMostrarid_cantonDatoGeneralEmpleado(esInicial);
		this.setMostrarid_parroquiaDatoGeneralEmpleado(esInicial);
		this.setMostrarfecha_nacimientoDatoGeneralEmpleado(esInicial);
		this.setMostrarfecha_falleceDatoGeneralEmpleado(esInicial);
		this.setMostrarvalor_evaluacionDatoGeneralEmpleado(esInicial);
		this.setMostrarnumero_horasDatoGeneralEmpleado(esInicial);
		this.setMostrarvalor_horaDatoGeneralEmpleado(esInicial);
		this.setMostrarsalarioDatoGeneralEmpleado(esInicial);
		this.setMostrarid_monedaDatoGeneralEmpleado(esInicial);
		this.setMostrarnumero_contratoDatoGeneralEmpleado(esInicial);
		this.setMostrarid_tipo_contratoDatoGeneralEmpleado(esInicial);
		this.setMostrarvalor1DatoGeneralEmpleado(esInicial);
		this.setMostrarvalor2DatoGeneralEmpleado(esInicial);
		this.setMostrarvalor3DatoGeneralEmpleado(esInicial);
		this.setMostrarvalor4DatoGeneralEmpleado(esInicial);
		this.setMostrarvalor5DatoGeneralEmpleado(esInicial);
		this.setMostrarvalor6DatoGeneralEmpleado(esInicial);
		this.setMostrarcon_aporta_seguro_socialDatoGeneralEmpleado(esInicial);
		this.setMostrarcon_recibe_horas_extrasDatoGeneralEmpleado(esInicial);
		this.setMostrarcon_descuento_impuestosDatoGeneralEmpleado(esInicial);
		this.setMostrarpension_alimenticiaDatoGeneralEmpleado(esInicial);
		this.setMostrarcon_pago_por_horasDatoGeneralEmpleado(esInicial);
		this.setMostrarcon_anticipoDatoGeneralEmpleado(esInicial);
		this.setMostrarid_tipo_libreta_miliDatoGeneralEmpleado(esInicial);
		this.setMostrarlibreta_militarDatoGeneralEmpleado(esInicial);
		this.setMostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(esInicial);
		this.setMostrarid_bancoDatoGeneralEmpleado(esInicial);
		this.setMostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(esInicial);
		this.setMostrarnumero_cuentaDatoGeneralEmpleado(esInicial);
		this.setMostrarid_tipo_sangreDatoGeneralEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.ID)) {
				this.setMostrarid_empleadoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setMostrarid_numero_patronalDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION)) {
				this.setMostrarid_tipo_afiliacionDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CARNETIESS)) {
				this.setMostrarcarnet_iessDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS)) {
				this.setMostrarsectorial_iessDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDCANTON)) {
				this.setMostrarid_cantonDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA)) {
				this.setMostrarid_parroquiaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO)) {
				this.setMostrarfecha_nacimientoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE)) {
				this.setMostrarfecha_falleceDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION)) {
				this.setMostrarvalor_evaluacionDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS)) {
				this.setMostrarnumero_horasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALORHORA)) {
				this.setMostrarvalor_horaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.SALARIO)) {
				this.setMostrarsalarioDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO)) {
				this.setMostrarnumero_contratoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO)) {
				this.setMostrarid_tipo_contratoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR1)) {
				this.setMostrarvalor1DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR2)) {
				this.setMostrarvalor2DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR3)) {
				this.setMostrarvalor3DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR4)) {
				this.setMostrarvalor4DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR5)) {
				this.setMostrarvalor5DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR6)) {
				this.setMostrarvalor6DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL)) {
				this.setMostrarcon_aporta_seguro_socialDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS)) {
				this.setMostrarcon_recibe_horas_extrasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS)) {
				this.setMostrarcon_descuento_impuestosDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA)) {
				this.setMostrarpension_alimenticiaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS)) {
				this.setMostrarcon_pago_por_horasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO)) {
				this.setMostrarcon_anticipoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI)) {
				this.setMostrarid_tipo_libreta_miliDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR)) {
				this.setMostrarlibreta_militarDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setMostrarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDBANCO)) {
				this.setMostrarid_bancoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setMostrarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA)) {
				this.setMostrarnumero_cuentaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE)) {
				this.setMostrarid_tipo_sangreDatoGeneralEmpleado(esAsigna);
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
		
		
		this.setActivarid_empleadoDatoGeneralEmpleado(esInicial);
		this.setActivarid_numero_patronalDatoGeneralEmpleado(esInicial);
		this.setActivarid_tipo_afiliacionDatoGeneralEmpleado(esInicial);
		this.setActivarcarnet_iessDatoGeneralEmpleado(esInicial);
		this.setActivarsectorial_iessDatoGeneralEmpleado(esInicial);
		this.setActivarid_paisDatoGeneralEmpleado(esInicial);
		this.setActivarid_provinciaDatoGeneralEmpleado(esInicial);
		this.setActivarid_cantonDatoGeneralEmpleado(esInicial);
		this.setActivarid_parroquiaDatoGeneralEmpleado(esInicial);
		this.setActivarfecha_nacimientoDatoGeneralEmpleado(esInicial);
		this.setActivarfecha_falleceDatoGeneralEmpleado(esInicial);
		this.setActivarvalor_evaluacionDatoGeneralEmpleado(esInicial);
		this.setActivarnumero_horasDatoGeneralEmpleado(esInicial);
		this.setActivarvalor_horaDatoGeneralEmpleado(esInicial);
		this.setActivarsalarioDatoGeneralEmpleado(esInicial);
		this.setActivarid_monedaDatoGeneralEmpleado(esInicial);
		this.setActivarnumero_contratoDatoGeneralEmpleado(esInicial);
		this.setActivarid_tipo_contratoDatoGeneralEmpleado(esInicial);
		this.setActivarvalor1DatoGeneralEmpleado(esInicial);
		this.setActivarvalor2DatoGeneralEmpleado(esInicial);
		this.setActivarvalor3DatoGeneralEmpleado(esInicial);
		this.setActivarvalor4DatoGeneralEmpleado(esInicial);
		this.setActivarvalor5DatoGeneralEmpleado(esInicial);
		this.setActivarvalor6DatoGeneralEmpleado(esInicial);
		this.setActivarcon_aporta_seguro_socialDatoGeneralEmpleado(esInicial);
		this.setActivarcon_recibe_horas_extrasDatoGeneralEmpleado(esInicial);
		this.setActivarcon_descuento_impuestosDatoGeneralEmpleado(esInicial);
		this.setActivarpension_alimenticiaDatoGeneralEmpleado(esInicial);
		this.setActivarcon_pago_por_horasDatoGeneralEmpleado(esInicial);
		this.setActivarcon_anticipoDatoGeneralEmpleado(esInicial);
		this.setActivarid_tipo_libreta_miliDatoGeneralEmpleado(esInicial);
		this.setActivarlibreta_militarDatoGeneralEmpleado(esInicial);
		this.setActivarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(esInicial);
		this.setActivarid_bancoDatoGeneralEmpleado(esInicial);
		this.setActivarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(esInicial);
		this.setActivarnumero_cuentaDatoGeneralEmpleado(esInicial);
		this.setActivarid_tipo_sangreDatoGeneralEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.ID)) {
				this.setActivarid_empleadoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setActivarid_numero_patronalDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION)) {
				this.setActivarid_tipo_afiliacionDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CARNETIESS)) {
				this.setActivarcarnet_iessDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS)) {
				this.setActivarsectorial_iessDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDCANTON)) {
				this.setActivarid_cantonDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA)) {
				this.setActivarid_parroquiaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO)) {
				this.setActivarfecha_nacimientoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE)) {
				this.setActivarfecha_falleceDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION)) {
				this.setActivarvalor_evaluacionDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS)) {
				this.setActivarnumero_horasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALORHORA)) {
				this.setActivarvalor_horaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.SALARIO)) {
				this.setActivarsalarioDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO)) {
				this.setActivarnumero_contratoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO)) {
				this.setActivarid_tipo_contratoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR1)) {
				this.setActivarvalor1DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR2)) {
				this.setActivarvalor2DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR3)) {
				this.setActivarvalor3DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR4)) {
				this.setActivarvalor4DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR5)) {
				this.setActivarvalor5DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR6)) {
				this.setActivarvalor6DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL)) {
				this.setActivarcon_aporta_seguro_socialDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS)) {
				this.setActivarcon_recibe_horas_extrasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS)) {
				this.setActivarcon_descuento_impuestosDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA)) {
				this.setActivarpension_alimenticiaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS)) {
				this.setActivarcon_pago_por_horasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO)) {
				this.setActivarcon_anticipoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI)) {
				this.setActivarid_tipo_libreta_miliDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR)) {
				this.setActivarlibreta_militarDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setActivarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDBANCO)) {
				this.setActivarid_bancoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setActivarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA)) {
				this.setActivarnumero_cuentaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE)) {
				this.setActivarid_tipo_sangreDatoGeneralEmpleado(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltarid_empleadoDatoGeneralEmpleado(esInicial);
		this.setResaltarid_numero_patronalDatoGeneralEmpleado(esInicial);
		this.setResaltarid_tipo_afiliacionDatoGeneralEmpleado(esInicial);
		this.setResaltarcarnet_iessDatoGeneralEmpleado(esInicial);
		this.setResaltarsectorial_iessDatoGeneralEmpleado(esInicial);
		this.setResaltarid_paisDatoGeneralEmpleado(esInicial);
		this.setResaltarid_provinciaDatoGeneralEmpleado(esInicial);
		this.setResaltarid_cantonDatoGeneralEmpleado(esInicial);
		this.setResaltarid_parroquiaDatoGeneralEmpleado(esInicial);
		this.setResaltarfecha_nacimientoDatoGeneralEmpleado(esInicial);
		this.setResaltarfecha_falleceDatoGeneralEmpleado(esInicial);
		this.setResaltarvalor_evaluacionDatoGeneralEmpleado(esInicial);
		this.setResaltarnumero_horasDatoGeneralEmpleado(esInicial);
		this.setResaltarvalor_horaDatoGeneralEmpleado(esInicial);
		this.setResaltarsalarioDatoGeneralEmpleado(esInicial);
		this.setResaltarid_monedaDatoGeneralEmpleado(esInicial);
		this.setResaltarnumero_contratoDatoGeneralEmpleado(esInicial);
		this.setResaltarid_tipo_contratoDatoGeneralEmpleado(esInicial);
		this.setResaltarvalor1DatoGeneralEmpleado(esInicial);
		this.setResaltarvalor2DatoGeneralEmpleado(esInicial);
		this.setResaltarvalor3DatoGeneralEmpleado(esInicial);
		this.setResaltarvalor4DatoGeneralEmpleado(esInicial);
		this.setResaltarvalor5DatoGeneralEmpleado(esInicial);
		this.setResaltarvalor6DatoGeneralEmpleado(esInicial);
		this.setResaltarcon_aporta_seguro_socialDatoGeneralEmpleado(esInicial);
		this.setResaltarcon_recibe_horas_extrasDatoGeneralEmpleado(esInicial);
		this.setResaltarcon_descuento_impuestosDatoGeneralEmpleado(esInicial);
		this.setResaltarpension_alimenticiaDatoGeneralEmpleado(esInicial);
		this.setResaltarcon_pago_por_horasDatoGeneralEmpleado(esInicial);
		this.setResaltarcon_anticipoDatoGeneralEmpleado(esInicial);
		this.setResaltarid_tipo_libreta_miliDatoGeneralEmpleado(esInicial);
		this.setResaltarlibreta_militarDatoGeneralEmpleado(esInicial);
		this.setResaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(esInicial);
		this.setResaltarid_bancoDatoGeneralEmpleado(esInicial);
		this.setResaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(esInicial);
		this.setResaltarnumero_cuentaDatoGeneralEmpleado(esInicial);
		this.setResaltarid_tipo_sangreDatoGeneralEmpleado(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.ID)) {
				this.setResaltarid_empleadoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDNUMEROPATRONAL)) {
				this.setResaltarid_numero_patronalDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOAFILIACION)) {
				this.setResaltarid_tipo_afiliacionDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CARNETIESS)) {
				this.setResaltarcarnet_iessDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.SECTORIALIESS)) {
				this.setResaltarsectorial_iessDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDCANTON)) {
				this.setResaltarid_cantonDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDPARROQUIA)) {
				this.setResaltarid_parroquiaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.FECHANACIMIENTO)) {
				this.setResaltarfecha_nacimientoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.FECHAFALLECE)) {
				this.setResaltarfecha_falleceDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOREVALUACION)) {
				this.setResaltarvalor_evaluacionDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROHORAS)) {
				this.setResaltarnumero_horasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALORHORA)) {
				this.setResaltarvalor_horaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.SALARIO)) {
				this.setResaltarsalarioDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROCONTRATO)) {
				this.setResaltarnumero_contratoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOCONTRATO)) {
				this.setResaltarid_tipo_contratoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR1)) {
				this.setResaltarvalor1DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR2)) {
				this.setResaltarvalor2DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR3)) {
				this.setResaltarvalor3DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR4)) {
				this.setResaltarvalor4DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR5)) {
				this.setResaltarvalor5DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.VALOR6)) {
				this.setResaltarvalor6DatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONAPORTASEGUROSOCIAL)) {
				this.setResaltarcon_aporta_seguro_socialDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONRECIBEHORASEXTRAS)) {
				this.setResaltarcon_recibe_horas_extrasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONDESCUENTOIMPUESTOS)) {
				this.setResaltarcon_descuento_impuestosDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.PENSIONALIMENTICIA)) {
				this.setResaltarpension_alimenticiaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONPAGOPORHORAS)) {
				this.setResaltarcon_pago_por_horasDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.CONANTICIPO)) {
				this.setResaltarcon_anticipoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOLIBRETAMILI)) {
				this.setResaltarid_tipo_libreta_miliDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.LIBRETAMILITAR)) {
				this.setResaltarlibreta_militarDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setResaltarid_tipo_grupo_forma_pagoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDBANCO)) {
				this.setResaltarid_bancoDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setResaltarid_tipo_cuenta_banco_globalDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.NUMEROCUENTA)) {
				this.setResaltarnumero_cuentaDatoGeneralEmpleado(esAsigna);
				continue;
			}

			if(campo.clase.equals(DatoGeneralEmpleadoConstantesFunciones.IDTIPOSANGRE)) {
				this.setResaltarid_tipo_sangreDatoGeneralEmpleado(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdBancoDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdBancoDatoGeneralEmpleado() {
		return this.mostrarFK_IdBancoDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdBancoDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBancoDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCantonDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdCantonDatoGeneralEmpleado() {
		return this.mostrarFK_IdCantonDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdCantonDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCantonDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdEmpleadoDatoGeneralEmpleado() {
		return this.mostrarFK_IdEmpleadoDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdEmpleadoDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdMonedaDatoGeneralEmpleado() {
		return this.mostrarFK_IdMonedaDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdMonedaDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdNumeroPatronalDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdNumeroPatronalDatoGeneralEmpleado() {
		return this.mostrarFK_IdNumeroPatronalDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdNumeroPatronalDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdNumeroPatronalDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdPaisDatoGeneralEmpleado() {
		return this.mostrarFK_IdPaisDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdPaisDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdParroquiaDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdParroquiaDatoGeneralEmpleado() {
		return this.mostrarFK_IdParroquiaDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdParroquiaDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdParroquiaDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProvinciaDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdProvinciaDatoGeneralEmpleado() {
		return this.mostrarFK_IdProvinciaDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdProvinciaDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProvinciaDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoAfiliacionDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdTipoAfiliacionDatoGeneralEmpleado() {
		return this.mostrarFK_IdTipoAfiliacionDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdTipoAfiliacionDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoAfiliacionDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoContratoDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdTipoContratoDatoGeneralEmpleado() {
		return this.mostrarFK_IdTipoContratoDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdTipoContratoDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoContratoDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado() {
		return this.mostrarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado() {
		return this.mostrarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoLibretaMiliDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdTipoLibretaMiliDatoGeneralEmpleado() {
		return this.mostrarFK_IdTipoLibretaMiliDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdTipoLibretaMiliDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoLibretaMiliDatoGeneralEmpleado= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoSangreDatoGeneralEmpleado=true;

	public Boolean getMostrarFK_IdTipoSangreDatoGeneralEmpleado() {
		return this.mostrarFK_IdTipoSangreDatoGeneralEmpleado;
	}

	public void setMostrarFK_IdTipoSangreDatoGeneralEmpleado(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoSangreDatoGeneralEmpleado= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdBancoDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdBancoDatoGeneralEmpleado() {
		return this.activarFK_IdBancoDatoGeneralEmpleado;
	}

	public void setActivarFK_IdBancoDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdBancoDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdCantonDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdCantonDatoGeneralEmpleado() {
		return this.activarFK_IdCantonDatoGeneralEmpleado;
	}

	public void setActivarFK_IdCantonDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdCantonDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdEmpleadoDatoGeneralEmpleado() {
		return this.activarFK_IdEmpleadoDatoGeneralEmpleado;
	}

	public void setActivarFK_IdEmpleadoDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdMonedaDatoGeneralEmpleado() {
		return this.activarFK_IdMonedaDatoGeneralEmpleado;
	}

	public void setActivarFK_IdMonedaDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdNumeroPatronalDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdNumeroPatronalDatoGeneralEmpleado() {
		return this.activarFK_IdNumeroPatronalDatoGeneralEmpleado;
	}

	public void setActivarFK_IdNumeroPatronalDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdNumeroPatronalDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdPaisDatoGeneralEmpleado() {
		return this.activarFK_IdPaisDatoGeneralEmpleado;
	}

	public void setActivarFK_IdPaisDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdPaisDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdParroquiaDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdParroquiaDatoGeneralEmpleado() {
		return this.activarFK_IdParroquiaDatoGeneralEmpleado;
	}

	public void setActivarFK_IdParroquiaDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdParroquiaDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdProvinciaDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdProvinciaDatoGeneralEmpleado() {
		return this.activarFK_IdProvinciaDatoGeneralEmpleado;
	}

	public void setActivarFK_IdProvinciaDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdProvinciaDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoAfiliacionDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdTipoAfiliacionDatoGeneralEmpleado() {
		return this.activarFK_IdTipoAfiliacionDatoGeneralEmpleado;
	}

	public void setActivarFK_IdTipoAfiliacionDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoAfiliacionDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoContratoDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdTipoContratoDatoGeneralEmpleado() {
		return this.activarFK_IdTipoContratoDatoGeneralEmpleado;
	}

	public void setActivarFK_IdTipoContratoDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoContratoDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado() {
		return this.activarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado;
	}

	public void setActivarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado() {
		return this.activarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado;
	}

	public void setActivarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoLibretaMiliDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdTipoLibretaMiliDatoGeneralEmpleado() {
		return this.activarFK_IdTipoLibretaMiliDatoGeneralEmpleado;
	}

	public void setActivarFK_IdTipoLibretaMiliDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoLibretaMiliDatoGeneralEmpleado= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoSangreDatoGeneralEmpleado=true;

	public Boolean getActivarFK_IdTipoSangreDatoGeneralEmpleado() {
		return this.activarFK_IdTipoSangreDatoGeneralEmpleado;
	}

	public void setActivarFK_IdTipoSangreDatoGeneralEmpleado(Boolean habilitarResaltar) {
		this.activarFK_IdTipoSangreDatoGeneralEmpleado= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdBancoDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdBancoDatoGeneralEmpleado() {
		return this.resaltarFK_IdBancoDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdBancoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdBancoDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdBancoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBancoDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdCantonDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdCantonDatoGeneralEmpleado() {
		return this.resaltarFK_IdCantonDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdCantonDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdCantonDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdCantonDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCantonDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdEmpleadoDatoGeneralEmpleado() {
		return this.resaltarFK_IdEmpleadoDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdEmpleadoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdMonedaDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdMonedaDatoGeneralEmpleado() {
		return this.resaltarFK_IdMonedaDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdMonedaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdMonedaDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdMonedaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdNumeroPatronalDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdNumeroPatronalDatoGeneralEmpleado() {
		return this.resaltarFK_IdNumeroPatronalDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdNumeroPatronalDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdNumeroPatronalDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdNumeroPatronalDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdNumeroPatronalDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdPaisDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdPaisDatoGeneralEmpleado() {
		return this.resaltarFK_IdPaisDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdPaisDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdPaisDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdPaisDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdParroquiaDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdParroquiaDatoGeneralEmpleado() {
		return this.resaltarFK_IdParroquiaDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdParroquiaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdParroquiaDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdParroquiaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdParroquiaDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdProvinciaDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdProvinciaDatoGeneralEmpleado() {
		return this.resaltarFK_IdProvinciaDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdProvinciaDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdProvinciaDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdProvinciaDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProvinciaDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoAfiliacionDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdTipoAfiliacionDatoGeneralEmpleado() {
		return this.resaltarFK_IdTipoAfiliacionDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdTipoAfiliacionDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoAfiliacionDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoAfiliacionDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoAfiliacionDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoContratoDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdTipoContratoDatoGeneralEmpleado() {
		return this.resaltarFK_IdTipoContratoDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdTipoContratoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoContratoDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoContratoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoContratoDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado() {
		return this.resaltarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaBancoGlobalDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado() {
		return this.resaltarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGrupoFormaPagoDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoLibretaMiliDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdTipoLibretaMiliDatoGeneralEmpleado() {
		return this.resaltarFK_IdTipoLibretaMiliDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdTipoLibretaMiliDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoLibretaMiliDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoLibretaMiliDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoLibretaMiliDatoGeneralEmpleado= borderResaltar;
	}

	public Border resaltarFK_IdTipoSangreDatoGeneralEmpleado=null;

	public Border getResaltarFK_IdTipoSangreDatoGeneralEmpleado() {
		return this.resaltarFK_IdTipoSangreDatoGeneralEmpleado;
	}

	public void setResaltarFK_IdTipoSangreDatoGeneralEmpleado(Border borderResaltar) {
		this.resaltarFK_IdTipoSangreDatoGeneralEmpleado= borderResaltar;
	}

	public void setResaltarFK_IdTipoSangreDatoGeneralEmpleado(ParametroGeneralUsuario parametroGeneralUsuario/*DatoGeneralEmpleadoBeanSwingJInternalFrame datogeneralempleadoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoSangreDatoGeneralEmpleado= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}