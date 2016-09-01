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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.AnticipoClienteConstantesFunciones;
import com.bydan.erp.facturacion.util.AnticipoClienteParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.AnticipoClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AnticipoClienteConstantesFunciones extends AnticipoClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AnticipoCliente";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AnticipoCliente"+AnticipoClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AnticipoClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AnticipoClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AnticipoClienteConstantesFunciones.SCHEMA+"_"+AnticipoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AnticipoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AnticipoClienteConstantesFunciones.SCHEMA+"_"+AnticipoClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AnticipoClienteConstantesFunciones.SCHEMA+"_"+AnticipoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AnticipoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AnticipoClienteConstantesFunciones.SCHEMA+"_"+AnticipoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnticipoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AnticipoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnticipoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnticipoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AnticipoClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnticipoClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AnticipoClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AnticipoClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AnticipoClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AnticipoClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Anticipo Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Anticipo Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Anticipo Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AnticipoCliente";
	public static final String OBJECTNAME="anticipocliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="anticipo_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select anticipocliente from "+AnticipoClienteConstantesFunciones.SPERSISTENCENAME+" anticipocliente";
	public static String QUERYSELECTNATIVE="select "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".version_row,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id_empresa,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id_empleado,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id_estado_anti_cliente,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".id_tipo_grupo_forma_pago,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".fecha,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".valor,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descripcion,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".valor_adicional,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".valor_prestamo,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso1,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso2,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso3,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso4,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".ingreso5,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento1,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento2,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento3,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento4,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".descuento5,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".tipo_ingreso,"+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME+".tipo_descuento from "+AnticipoClienteConstantesFunciones.SCHEMA+"."+AnticipoClienteConstantesFunciones.TABLENAME;//+" as "+AnticipoClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AnticipoClienteConstantesFuncionesAdditional anticipoclienteConstantesFuncionesAdditional=null;
	
	public AnticipoClienteConstantesFuncionesAdditional getAnticipoClienteConstantesFuncionesAdditional() {
		return this.anticipoclienteConstantesFuncionesAdditional;
	}
	
	public void setAnticipoClienteConstantesFuncionesAdditional(AnticipoClienteConstantesFuncionesAdditional anticipoclienteConstantesFuncionesAdditional) {
		try {
			this.anticipoclienteConstantesFuncionesAdditional=anticipoclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDESTADOANTICLIENTE= "id_estado_anti_cliente";
    public static final String IDTIPOGRUPOFORMAPAGO= "id_tipo_grupo_forma_pago";
    public static final String FECHA= "fecha";
    public static final String VALOR= "valor";
    public static final String DESCRIPCION= "descripcion";
    public static final String VALORADICIONAL= "valor_adicional";
    public static final String VALORPRESTAMO= "valor_prestamo";
    public static final String INGRESO1= "ingreso1";
    public static final String INGRESO2= "ingreso2";
    public static final String INGRESO3= "ingreso3";
    public static final String INGRESO4= "ingreso4";
    public static final String INGRESO5= "ingreso5";
    public static final String DESCUENTO1= "descuento1";
    public static final String DESCUENTO2= "descuento2";
    public static final String DESCUENTO3= "descuento3";
    public static final String DESCUENTO4= "descuento4";
    public static final String DESCUENTO5= "descuento5";
    public static final String TIPOINGRESO= "tipo_ingreso";
    public static final String TIPODESCUENTO= "tipo_descuento";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDESTADOANTICLIENTE= "Estado Anti Cliente";
		public static final String LABEL_IDESTADOANTICLIENTE_LOWER= "Estado Anti Cliente";
    	public static final String LABEL_IDTIPOGRUPOFORMAPAGO= "Tipo Grupo Forma Pago";
		public static final String LABEL_IDTIPOGRUPOFORMAPAGO_LOWER= "Tipo Grupo Forma Pago";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_VALORADICIONAL= "Valor Adicional";
		public static final String LABEL_VALORADICIONAL_LOWER= "Valor Adicional";
    	public static final String LABEL_VALORPRESTAMO= "Valor Prestamo";
		public static final String LABEL_VALORPRESTAMO_LOWER= "Valor Prestamo";
    	public static final String LABEL_INGRESO1= "Ingreso1";
		public static final String LABEL_INGRESO1_LOWER= "Ingreso1";
    	public static final String LABEL_INGRESO2= "Ingreso2";
		public static final String LABEL_INGRESO2_LOWER= "Ingreso2";
    	public static final String LABEL_INGRESO3= "Ingreso3";
		public static final String LABEL_INGRESO3_LOWER= "Ingreso3";
    	public static final String LABEL_INGRESO4= "Ingreso4";
		public static final String LABEL_INGRESO4_LOWER= "Ingreso4";
    	public static final String LABEL_INGRESO5= "Ingreso5";
		public static final String LABEL_INGRESO5_LOWER= "Ingreso5";
    	public static final String LABEL_DESCUENTO1= "Descuento1";
		public static final String LABEL_DESCUENTO1_LOWER= "Descuento1";
    	public static final String LABEL_DESCUENTO2= "Descuento2";
		public static final String LABEL_DESCUENTO2_LOWER= "Descuento2";
    	public static final String LABEL_DESCUENTO3= "Descuento3";
		public static final String LABEL_DESCUENTO3_LOWER= "Descuento3";
    	public static final String LABEL_DESCUENTO4= "Descuento4";
		public static final String LABEL_DESCUENTO4_LOWER= "Descuento4";
    	public static final String LABEL_DESCUENTO5= "Descuento5";
		public static final String LABEL_DESCUENTO5_LOWER= "Descuento5";
    	public static final String LABEL_TIPOINGRESO= "Tipo Ingreso";
		public static final String LABEL_TIPOINGRESO_LOWER= "Tipo Ingreso";
    	public static final String LABEL_TIPODESCUENTO= "Tipo Descuento";
		public static final String LABEL_TIPODESCUENTO_LOWER= "Tipo Descuento";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getAnticipoClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.IDEMPLEADO)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_IDESTADOANTICLIENTE;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.FECHA)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.VALOR)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.VALORADICIONAL)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_VALORADICIONAL;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.VALORPRESTAMO)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_VALORPRESTAMO;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.INGRESO1)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_INGRESO1;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.INGRESO2)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_INGRESO2;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.INGRESO3)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_INGRESO3;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.INGRESO4)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_INGRESO4;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.INGRESO5)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_INGRESO5;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.DESCUENTO1)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_DESCUENTO1;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.DESCUENTO2)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_DESCUENTO2;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.DESCUENTO3)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_DESCUENTO3;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.DESCUENTO4)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_DESCUENTO4;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.DESCUENTO5)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_DESCUENTO5;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.TIPOINGRESO)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_TIPOINGRESO;}
		if(sNombreColumna.equals(AnticipoClienteConstantesFunciones.TIPODESCUENTO)) {sLabelColumna=AnticipoClienteConstantesFunciones.LABEL_TIPODESCUENTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAnticipoClienteDescripcion(AnticipoCliente anticipocliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(anticipocliente !=null/* && anticipocliente.getId()!=0*/) {
			if(anticipocliente.getId()!=null) {
				sDescripcion=anticipocliente.getId().toString();
			}//anticipoclienteanticipocliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getAnticipoClienteDescripcionDetallado(AnticipoCliente anticipocliente) {
		String sDescripcion="";
			
		sDescripcion+=AnticipoClienteConstantesFunciones.ID+"=";
		sDescripcion+=anticipocliente.getId().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=anticipocliente.getVersionRow().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=anticipocliente.getid_empresa().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=anticipocliente.getid_empleado().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE+"=";
		sDescripcion+=anticipocliente.getid_estado_anti_cliente().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO+"=";
		sDescripcion+=anticipocliente.getid_tipo_grupo_forma_pago().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.FECHA+"=";
		sDescripcion+=anticipocliente.getfecha().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.VALOR+"=";
		sDescripcion+=anticipocliente.getvalor().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=anticipocliente.getdescripcion()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.VALORADICIONAL+"=";
		sDescripcion+=anticipocliente.getvalor_adicional().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.VALORPRESTAMO+"=";
		sDescripcion+=anticipocliente.getvalor_prestamo().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.INGRESO1+"=";
		sDescripcion+=anticipocliente.getingreso1().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.INGRESO2+"=";
		sDescripcion+=anticipocliente.getingreso2().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.INGRESO3+"=";
		sDescripcion+=anticipocliente.getingreso3().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.INGRESO4+"=";
		sDescripcion+=anticipocliente.getingreso4().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.INGRESO5+"=";
		sDescripcion+=anticipocliente.getingreso5().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.DESCUENTO1+"=";
		sDescripcion+=anticipocliente.getdescuento1().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.DESCUENTO2+"=";
		sDescripcion+=anticipocliente.getdescuento2().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.DESCUENTO3+"=";
		sDescripcion+=anticipocliente.getdescuento3().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.DESCUENTO4+"=";
		sDescripcion+=anticipocliente.getdescuento4().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.DESCUENTO5+"=";
		sDescripcion+=anticipocliente.getdescuento5().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.TIPOINGRESO+"=";
		sDescripcion+=anticipocliente.gettipo_ingreso().toString()+",";
		sDescripcion+=AnticipoClienteConstantesFunciones.TIPODESCUENTO+"=";
		sDescripcion+=anticipocliente.gettipo_descuento().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAnticipoClienteDescripcion(AnticipoCliente anticipocliente,String sValor) throws Exception {			
		if(anticipocliente !=null) {
			//anticipoclienteanticipocliente.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getEstadoAntiClienteDescripcion(EstadoAntiCliente estadoanticliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoanticliente!=null/*&&estadoanticliente.getId()>0*/) {
			sDescripcion=EstadoAntiClienteConstantesFunciones.getEstadoAntiClienteDescripcion(estadoanticliente);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoAntiCliente")) {
			sNombreIndice="Tipo=  Por Estado Anti Cliente";
		} else if(sNombreIndice.equals("FK_IdTipoGrupoFormaPago")) {
			sNombreIndice="Tipo=  Por Tipo Grupo Forma Pago";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
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

	public static String getDetalleIndiceFK_IdEstadoAntiCliente(Long id_estado_anti_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_anti_cliente!=null) {sDetalleIndice+=" Codigo Unico De Estado Anti Cliente="+id_estado_anti_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGrupoFormaPago(Long id_tipo_grupo_forma_pago) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_grupo_forma_pago!=null) {sDetalleIndice+=" Codigo Unico De Tipo Grupo Forma Pago="+id_tipo_grupo_forma_pago.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAnticipoCliente(AnticipoCliente anticipocliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		anticipocliente.setdescripcion(anticipocliente.getdescripcion().trim());
	}
	
	public static void quitarEspaciosAnticipoClientes(List<AnticipoCliente> anticipoclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AnticipoCliente anticipocliente: anticipoclientes) {
			anticipocliente.setdescripcion(anticipocliente.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAnticipoCliente(AnticipoCliente anticipocliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && anticipocliente.getConCambioAuxiliar()) {
			anticipocliente.setIsDeleted(anticipocliente.getIsDeletedAuxiliar());	
			anticipocliente.setIsNew(anticipocliente.getIsNewAuxiliar());	
			anticipocliente.setIsChanged(anticipocliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			anticipocliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			anticipocliente.setIsDeletedAuxiliar(false);	
			anticipocliente.setIsNewAuxiliar(false);	
			anticipocliente.setIsChangedAuxiliar(false);
			
			anticipocliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAnticipoClientes(List<AnticipoCliente> anticipoclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AnticipoCliente anticipocliente : anticipoclientes) {
			if(conAsignarBase && anticipocliente.getConCambioAuxiliar()) {
				anticipocliente.setIsDeleted(anticipocliente.getIsDeletedAuxiliar());	
				anticipocliente.setIsNew(anticipocliente.getIsNewAuxiliar());	
				anticipocliente.setIsChanged(anticipocliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				anticipocliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				anticipocliente.setIsDeletedAuxiliar(false);	
				anticipocliente.setIsNewAuxiliar(false);	
				anticipocliente.setIsChangedAuxiliar(false);
				
				anticipocliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAnticipoCliente(AnticipoCliente anticipocliente,Boolean conEnteros) throws Exception  {
		anticipocliente.setvalor(0.0);
		anticipocliente.setvalor_adicional(0.0);
		anticipocliente.setvalor_prestamo(0.0);
		anticipocliente.setingreso1(0.0);
		anticipocliente.setingreso2(0.0);
		anticipocliente.setingreso3(0.0);
		anticipocliente.setingreso4(0.0);
		anticipocliente.setingreso5(0.0);
		anticipocliente.setdescuento1(0.0);
		anticipocliente.setdescuento2(0.0);
		anticipocliente.setdescuento3(0.0);
		anticipocliente.setdescuento4(0.0);
		anticipocliente.setdescuento5(0.0);
		anticipocliente.settipo_ingreso(0.0);
		anticipocliente.settipo_descuento(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAnticipoClientes(List<AnticipoCliente> anticipoclientes,Boolean conEnteros) throws Exception  {
		
		for(AnticipoCliente anticipocliente: anticipoclientes) {
			anticipocliente.setvalor(0.0);
			anticipocliente.setvalor_adicional(0.0);
			anticipocliente.setvalor_prestamo(0.0);
			anticipocliente.setingreso1(0.0);
			anticipocliente.setingreso2(0.0);
			anticipocliente.setingreso3(0.0);
			anticipocliente.setingreso4(0.0);
			anticipocliente.setingreso5(0.0);
			anticipocliente.setdescuento1(0.0);
			anticipocliente.setdescuento2(0.0);
			anticipocliente.setdescuento3(0.0);
			anticipocliente.setdescuento4(0.0);
			anticipocliente.setdescuento5(0.0);
			anticipocliente.settipo_ingreso(0.0);
			anticipocliente.settipo_descuento(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAnticipoCliente(List<AnticipoCliente> anticipoclientes,AnticipoCliente anticipoclienteAux) throws Exception  {
		AnticipoClienteConstantesFunciones.InicializarValoresAnticipoCliente(anticipoclienteAux,true);
		
		for(AnticipoCliente anticipocliente: anticipoclientes) {
			if(anticipocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			anticipoclienteAux.setvalor(anticipoclienteAux.getvalor()+anticipocliente.getvalor());			
			anticipoclienteAux.setvalor_adicional(anticipoclienteAux.getvalor_adicional()+anticipocliente.getvalor_adicional());			
			anticipoclienteAux.setvalor_prestamo(anticipoclienteAux.getvalor_prestamo()+anticipocliente.getvalor_prestamo());			
			anticipoclienteAux.setingreso1(anticipoclienteAux.getingreso1()+anticipocliente.getingreso1());			
			anticipoclienteAux.setingreso2(anticipoclienteAux.getingreso2()+anticipocliente.getingreso2());			
			anticipoclienteAux.setingreso3(anticipoclienteAux.getingreso3()+anticipocliente.getingreso3());			
			anticipoclienteAux.setingreso4(anticipoclienteAux.getingreso4()+anticipocliente.getingreso4());			
			anticipoclienteAux.setingreso5(anticipoclienteAux.getingreso5()+anticipocliente.getingreso5());			
			anticipoclienteAux.setdescuento1(anticipoclienteAux.getdescuento1()+anticipocliente.getdescuento1());			
			anticipoclienteAux.setdescuento2(anticipoclienteAux.getdescuento2()+anticipocliente.getdescuento2());			
			anticipoclienteAux.setdescuento3(anticipoclienteAux.getdescuento3()+anticipocliente.getdescuento3());			
			anticipoclienteAux.setdescuento4(anticipoclienteAux.getdescuento4()+anticipocliente.getdescuento4());			
			anticipoclienteAux.setdescuento5(anticipoclienteAux.getdescuento5()+anticipocliente.getdescuento5());			
			anticipoclienteAux.settipo_ingreso(anticipoclienteAux.gettipo_ingreso()+anticipocliente.gettipo_ingreso());			
			anticipoclienteAux.settipo_descuento(anticipoclienteAux.gettipo_descuento()+anticipocliente.gettipo_descuento());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAnticipoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AnticipoClienteConstantesFunciones.getArrayColumnasGlobalesAnticipoCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAnticipoCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AnticipoClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AnticipoClienteConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAnticipoCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AnticipoCliente> anticipoclientes,AnticipoCliente anticipocliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AnticipoCliente anticipoclienteAux: anticipoclientes) {
			if(anticipoclienteAux!=null && anticipocliente!=null) {
				if((anticipoclienteAux.getId()==null && anticipocliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(anticipoclienteAux.getId()!=null && anticipocliente.getId()!=null){
					if(anticipoclienteAux.getId().equals(anticipocliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAnticipoCliente(List<AnticipoCliente> anticipoclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
		Double valor_adicionalTotal=0.0;
		Double valor_prestamoTotal=0.0;
		Double ingreso1Total=0.0;
		Double ingreso2Total=0.0;
		Double ingreso3Total=0.0;
		Double ingreso4Total=0.0;
		Double ingreso5Total=0.0;
		Double descuento1Total=0.0;
		Double descuento2Total=0.0;
		Double descuento3Total=0.0;
		Double descuento4Total=0.0;
		Double descuento5Total=0.0;
		Double tipo_ingresoTotal=0.0;
		Double tipo_descuentoTotal=0.0;
	
		for(AnticipoCliente anticipocliente: anticipoclientes) {			
			if(anticipocliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=anticipocliente.getvalor();
			valor_adicionalTotal+=anticipocliente.getvalor_adicional();
			valor_prestamoTotal+=anticipocliente.getvalor_prestamo();
			ingreso1Total+=anticipocliente.getingreso1();
			ingreso2Total+=anticipocliente.getingreso2();
			ingreso3Total+=anticipocliente.getingreso3();
			ingreso4Total+=anticipocliente.getingreso4();
			ingreso5Total+=anticipocliente.getingreso5();
			descuento1Total+=anticipocliente.getdescuento1();
			descuento2Total+=anticipocliente.getdescuento2();
			descuento3Total+=anticipocliente.getdescuento3();
			descuento4Total+=anticipocliente.getdescuento4();
			descuento5Total+=anticipocliente.getdescuento5();
			tipo_ingresoTotal+=anticipocliente.gettipo_ingreso();
			tipo_descuentoTotal+=anticipocliente.gettipo_descuento();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.VALORADICIONAL);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_VALORADICIONAL);
		datoGeneral.setdValorDouble(valor_adicionalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.VALORPRESTAMO);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_VALORPRESTAMO);
		datoGeneral.setdValorDouble(valor_prestamoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.INGRESO1);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO1);
		datoGeneral.setdValorDouble(ingreso1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.INGRESO2);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO2);
		datoGeneral.setdValorDouble(ingreso2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.INGRESO3);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO3);
		datoGeneral.setdValorDouble(ingreso3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.INGRESO4);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO4);
		datoGeneral.setdValorDouble(ingreso4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.INGRESO5);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO5);
		datoGeneral.setdValorDouble(ingreso5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.DESCUENTO1);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO1);
		datoGeneral.setdValorDouble(descuento1Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.DESCUENTO2);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO2);
		datoGeneral.setdValorDouble(descuento2Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.DESCUENTO3);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO3);
		datoGeneral.setdValorDouble(descuento3Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.DESCUENTO4);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO4);
		datoGeneral.setdValorDouble(descuento4Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.DESCUENTO5);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO5);
		datoGeneral.setdValorDouble(descuento5Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.TIPOINGRESO);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_TIPOINGRESO);
		datoGeneral.setdValorDouble(tipo_ingresoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(AnticipoClienteConstantesFunciones.TIPODESCUENTO);
		datoGeneral.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_TIPODESCUENTO);
		datoGeneral.setdValorDouble(tipo_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAnticipoCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_ID, AnticipoClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_VERSIONROW, AnticipoClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_IDEMPRESA, AnticipoClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_IDEMPLEADO, AnticipoClienteConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_IDESTADOANTICLIENTE, AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO, AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_FECHA, AnticipoClienteConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_VALOR, AnticipoClienteConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_DESCRIPCION, AnticipoClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_VALORADICIONAL, AnticipoClienteConstantesFunciones.VALORADICIONAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_VALORPRESTAMO, AnticipoClienteConstantesFunciones.VALORPRESTAMO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_INGRESO1, AnticipoClienteConstantesFunciones.INGRESO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_INGRESO2, AnticipoClienteConstantesFunciones.INGRESO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_INGRESO3, AnticipoClienteConstantesFunciones.INGRESO3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_INGRESO4, AnticipoClienteConstantesFunciones.INGRESO4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_INGRESO5, AnticipoClienteConstantesFunciones.INGRESO5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_DESCUENTO1, AnticipoClienteConstantesFunciones.DESCUENTO1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_DESCUENTO2, AnticipoClienteConstantesFunciones.DESCUENTO2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_DESCUENTO3, AnticipoClienteConstantesFunciones.DESCUENTO3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_DESCUENTO4, AnticipoClienteConstantesFunciones.DESCUENTO4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_DESCUENTO5, AnticipoClienteConstantesFunciones.DESCUENTO5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_TIPOINGRESO, AnticipoClienteConstantesFunciones.TIPOINGRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnticipoClienteConstantesFunciones.LABEL_TIPODESCUENTO, AnticipoClienteConstantesFunciones.TIPODESCUENTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAnticipoCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.VALORADICIONAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.VALORPRESTAMO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.INGRESO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.INGRESO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.INGRESO3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.INGRESO4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.INGRESO5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.DESCUENTO1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.DESCUENTO2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.DESCUENTO3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.DESCUENTO4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.DESCUENTO5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.TIPOINGRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnticipoClienteConstantesFunciones.TIPODESCUENTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnticipoCliente() throws Exception  {
		return AnticipoClienteConstantesFunciones.getTiposSeleccionarAnticipoCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnticipoCliente(Boolean conFk) throws Exception  {
		return AnticipoClienteConstantesFunciones.getTiposSeleccionarAnticipoCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnticipoCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_IDESTADOANTICLIENTE);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_IDESTADOANTICLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_VALORADICIONAL);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_VALORADICIONAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_VALORPRESTAMO);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_VALORPRESTAMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_INGRESO1);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_INGRESO2);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_INGRESO3);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_INGRESO4);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_INGRESO5);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_INGRESO5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO1);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO2);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO3);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO4);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO5);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_TIPOINGRESO);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_TIPOINGRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnticipoClienteConstantesFunciones.LABEL_TIPODESCUENTO);
			reporte.setsDescripcion(AnticipoClienteConstantesFunciones.LABEL_TIPODESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAnticipoCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAnticipoCliente(AnticipoCliente anticipoclienteAux) throws Exception {
		
			anticipoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(anticipoclienteAux.getEmpresa()));
			anticipoclienteAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(anticipoclienteAux.getEmpleado()));
			anticipoclienteAux.setestadoanticliente_descripcion(EstadoAntiClienteConstantesFunciones.getEstadoAntiClienteDescripcion(anticipoclienteAux.getEstadoAntiCliente()));
			anticipoclienteAux.settipogrupoformapago_descripcion(TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(anticipoclienteAux.getTipoGrupoFormaPago()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAnticipoCliente(List<AnticipoCliente> anticipoclientesTemp) throws Exception {
		for(AnticipoCliente anticipoclienteAux:anticipoclientesTemp) {
			
			anticipoclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(anticipoclienteAux.getEmpresa()));
			anticipoclienteAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(anticipoclienteAux.getEmpleado()));
			anticipoclienteAux.setestadoanticliente_descripcion(EstadoAntiClienteConstantesFunciones.getEstadoAntiClienteDescripcion(anticipoclienteAux.getEstadoAntiCliente()));
			anticipoclienteAux.settipogrupoformapago_descripcion(TipoGrupoFormaPagoConstantesFunciones.getTipoGrupoFormaPagoDescripcion(anticipoclienteAux.getTipoGrupoFormaPago()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAnticipoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(EstadoAntiCliente.class));
				classes.add(new Classe(TipoGrupoFormaPago.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoAntiCliente.class)) {
						classes.add(new Classe(EstadoAntiCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGrupoFormaPago.class)) {
						classes.add(new Classe(TipoGrupoFormaPago.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAnticipoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EstadoAntiCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoAntiCliente.class)); continue;
					}

					if(TipoGrupoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFormaPago.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(EstadoAntiCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoAntiCliente.class)); continue;
					}

					if(TipoGrupoFormaPago.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFormaPago.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnticipoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AnticipoClienteConstantesFunciones.getClassesRelationshipsOfAnticipoCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnticipoCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAnticipoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AnticipoClienteConstantesFunciones.getClassesRelationshipsFromStringsOfAnticipoCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAnticipoCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AnticipoCliente anticipocliente,List<AnticipoCliente> anticipoclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AnticipoCliente anticipoclienteEncontrado=null;
			
			for(AnticipoCliente anticipoclienteLocal:anticipoclientes) {
				if(anticipoclienteLocal.getId().equals(anticipocliente.getId())) {
					anticipoclienteEncontrado=anticipoclienteLocal;
					
					anticipoclienteLocal.setIsChanged(anticipocliente.getIsChanged());
					anticipoclienteLocal.setIsNew(anticipocliente.getIsNew());
					anticipoclienteLocal.setIsDeleted(anticipocliente.getIsDeleted());
					
					anticipoclienteLocal.setGeneralEntityOriginal(anticipocliente.getGeneralEntityOriginal());
					
					anticipoclienteLocal.setId(anticipocliente.getId());	
					anticipoclienteLocal.setVersionRow(anticipocliente.getVersionRow());	
					anticipoclienteLocal.setid_empresa(anticipocliente.getid_empresa());	
					anticipoclienteLocal.setid_empleado(anticipocliente.getid_empleado());	
					anticipoclienteLocal.setid_estado_anti_cliente(anticipocliente.getid_estado_anti_cliente());	
					anticipoclienteLocal.setid_tipo_grupo_forma_pago(anticipocliente.getid_tipo_grupo_forma_pago());	
					anticipoclienteLocal.setfecha(anticipocliente.getfecha());	
					anticipoclienteLocal.setvalor(anticipocliente.getvalor());	
					anticipoclienteLocal.setdescripcion(anticipocliente.getdescripcion());	
					anticipoclienteLocal.setvalor_adicional(anticipocliente.getvalor_adicional());	
					anticipoclienteLocal.setvalor_prestamo(anticipocliente.getvalor_prestamo());	
					anticipoclienteLocal.setingreso1(anticipocliente.getingreso1());	
					anticipoclienteLocal.setingreso2(anticipocliente.getingreso2());	
					anticipoclienteLocal.setingreso3(anticipocliente.getingreso3());	
					anticipoclienteLocal.setingreso4(anticipocliente.getingreso4());	
					anticipoclienteLocal.setingreso5(anticipocliente.getingreso5());	
					anticipoclienteLocal.setdescuento1(anticipocliente.getdescuento1());	
					anticipoclienteLocal.setdescuento2(anticipocliente.getdescuento2());	
					anticipoclienteLocal.setdescuento3(anticipocliente.getdescuento3());	
					anticipoclienteLocal.setdescuento4(anticipocliente.getdescuento4());	
					anticipoclienteLocal.setdescuento5(anticipocliente.getdescuento5());	
					anticipoclienteLocal.settipo_ingreso(anticipocliente.gettipo_ingreso());	
					anticipoclienteLocal.settipo_descuento(anticipocliente.gettipo_descuento());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!anticipocliente.getIsDeleted()) {
				if(!existe) {
					anticipoclientes.add(anticipocliente);
				}
			} else {
				if(anticipoclienteEncontrado!=null && permiteQuitar)  {
					anticipoclientes.remove(anticipoclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AnticipoCliente anticipocliente,List<AnticipoCliente> anticipoclientes) throws Exception {
		try	{			
			for(AnticipoCliente anticipoclienteLocal:anticipoclientes) {
				if(anticipoclienteLocal.getId().equals(anticipocliente.getId())) {
					anticipoclienteLocal.setIsSelected(anticipocliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAnticipoCliente(List<AnticipoCliente> anticipoclientesAux) throws Exception {
		//this.anticipoclientesAux=anticipoclientesAux;
		
		for(AnticipoCliente anticipoclienteAux:anticipoclientesAux) {
			if(anticipoclienteAux.getIsChanged()) {
				anticipoclienteAux.setIsChanged(false);
			}		
			
			if(anticipoclienteAux.getIsNew()) {
				anticipoclienteAux.setIsNew(false);
			}	
			
			if(anticipoclienteAux.getIsDeleted()) {
				anticipoclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAnticipoCliente(AnticipoCliente anticipoclienteAux) throws Exception {
		//this.anticipoclienteAux=anticipoclienteAux;
		
			if(anticipoclienteAux.getIsChanged()) {
				anticipoclienteAux.setIsChanged(false);
			}		
			
			if(anticipoclienteAux.getIsNew()) {
				anticipoclienteAux.setIsNew(false);
			}	
			
			if(anticipoclienteAux.getIsDeleted()) {
				anticipoclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AnticipoCliente anticipoclienteAsignar,AnticipoCliente anticipocliente) throws Exception {
		anticipoclienteAsignar.setId(anticipocliente.getId());	
		anticipoclienteAsignar.setVersionRow(anticipocliente.getVersionRow());	
		anticipoclienteAsignar.setid_empresa(anticipocliente.getid_empresa());
		anticipoclienteAsignar.setempresa_descripcion(anticipocliente.getempresa_descripcion());	
		anticipoclienteAsignar.setid_empleado(anticipocliente.getid_empleado());
		anticipoclienteAsignar.setempleado_descripcion(anticipocliente.getempleado_descripcion());	
		anticipoclienteAsignar.setid_estado_anti_cliente(anticipocliente.getid_estado_anti_cliente());
		anticipoclienteAsignar.setestadoanticliente_descripcion(anticipocliente.getestadoanticliente_descripcion());	
		anticipoclienteAsignar.setid_tipo_grupo_forma_pago(anticipocliente.getid_tipo_grupo_forma_pago());
		anticipoclienteAsignar.settipogrupoformapago_descripcion(anticipocliente.gettipogrupoformapago_descripcion());	
		anticipoclienteAsignar.setfecha(anticipocliente.getfecha());	
		anticipoclienteAsignar.setvalor(anticipocliente.getvalor());	
		anticipoclienteAsignar.setdescripcion(anticipocliente.getdescripcion());	
		anticipoclienteAsignar.setvalor_adicional(anticipocliente.getvalor_adicional());	
		anticipoclienteAsignar.setvalor_prestamo(anticipocliente.getvalor_prestamo());	
		anticipoclienteAsignar.setingreso1(anticipocliente.getingreso1());	
		anticipoclienteAsignar.setingreso2(anticipocliente.getingreso2());	
		anticipoclienteAsignar.setingreso3(anticipocliente.getingreso3());	
		anticipoclienteAsignar.setingreso4(anticipocliente.getingreso4());	
		anticipoclienteAsignar.setingreso5(anticipocliente.getingreso5());	
		anticipoclienteAsignar.setdescuento1(anticipocliente.getdescuento1());	
		anticipoclienteAsignar.setdescuento2(anticipocliente.getdescuento2());	
		anticipoclienteAsignar.setdescuento3(anticipocliente.getdescuento3());	
		anticipoclienteAsignar.setdescuento4(anticipocliente.getdescuento4());	
		anticipoclienteAsignar.setdescuento5(anticipocliente.getdescuento5());	
		anticipoclienteAsignar.settipo_ingreso(anticipocliente.gettipo_ingreso());	
		anticipoclienteAsignar.settipo_descuento(anticipocliente.gettipo_descuento());	
	}
	
	public static void inicializarAnticipoCliente(AnticipoCliente anticipocliente) throws Exception {
		try {
				anticipocliente.setId(0L);	
					
				anticipocliente.setid_empresa(-1L);	
				anticipocliente.setid_empleado(-1L);	
				anticipocliente.setid_estado_anti_cliente(-1L);	
				anticipocliente.setid_tipo_grupo_forma_pago(-1L);	
				anticipocliente.setfecha(new Date());	
				anticipocliente.setvalor(0.0);	
				anticipocliente.setdescripcion("");	
				anticipocliente.setvalor_adicional(0.0);	
				anticipocliente.setvalor_prestamo(0.0);	
				anticipocliente.setingreso1(0.0);	
				anticipocliente.setingreso2(0.0);	
				anticipocliente.setingreso3(0.0);	
				anticipocliente.setingreso4(0.0);	
				anticipocliente.setingreso5(0.0);	
				anticipocliente.setdescuento1(0.0);	
				anticipocliente.setdescuento2(0.0);	
				anticipocliente.setdescuento3(0.0);	
				anticipocliente.setdescuento4(0.0);	
				anticipocliente.setdescuento5(0.0);	
				anticipocliente.settipo_ingreso(0.0);	
				anticipocliente.settipo_descuento(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAnticipoCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_IDESTADOANTICLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_IDTIPOGRUPOFORMAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_VALORADICIONAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_VALORPRESTAMO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_INGRESO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_INGRESO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_INGRESO3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_INGRESO4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_INGRESO5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_DESCUENTO5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_TIPOINGRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnticipoClienteConstantesFunciones.LABEL_TIPODESCUENTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAnticipoCliente(String sTipo,Row row,Workbook workbook,AnticipoCliente anticipocliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getestadoanticliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.gettipogrupoformapago_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getvalor_adicional());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getvalor_prestamo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getingreso1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getingreso2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getingreso3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getingreso4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getingreso5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getdescuento1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getdescuento2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getdescuento3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getdescuento4());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.getdescuento5());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.gettipo_ingreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(anticipocliente.gettipo_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAnticipoCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAnticipoCliente() {
		return this.sFinalQueryAnticipoCliente;
	}
	
	public void setsFinalQueryAnticipoCliente(String sFinalQueryAnticipoCliente) {
		this.sFinalQueryAnticipoCliente= sFinalQueryAnticipoCliente;
	}
	
	public Border resaltarSeleccionarAnticipoCliente=null;
	
	public Border setResaltarSeleccionarAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAnticipoCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAnticipoCliente() {
		return this.resaltarSeleccionarAnticipoCliente;
	}
	
	public void setResaltarSeleccionarAnticipoCliente(Border borderResaltarSeleccionarAnticipoCliente) {
		this.resaltarSeleccionarAnticipoCliente= borderResaltarSeleccionarAnticipoCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAnticipoCliente=null;
	public Boolean mostraridAnticipoCliente=true;
	public Boolean activaridAnticipoCliente=true;

	public Border resaltarid_empresaAnticipoCliente=null;
	public Boolean mostrarid_empresaAnticipoCliente=true;
	public Boolean activarid_empresaAnticipoCliente=true;
	public Boolean cargarid_empresaAnticipoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAnticipoCliente=false;//ConEventDepend=true

	public Border resaltarid_empleadoAnticipoCliente=null;
	public Boolean mostrarid_empleadoAnticipoCliente=true;
	public Boolean activarid_empleadoAnticipoCliente=true;
	public Boolean cargarid_empleadoAnticipoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoAnticipoCliente=false;//ConEventDepend=true

	public Border resaltarid_estado_anti_clienteAnticipoCliente=null;
	public Boolean mostrarid_estado_anti_clienteAnticipoCliente=true;
	public Boolean activarid_estado_anti_clienteAnticipoCliente=true;
	public Boolean cargarid_estado_anti_clienteAnticipoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_anti_clienteAnticipoCliente=false;//ConEventDepend=true

	public Border resaltarid_tipo_grupo_forma_pagoAnticipoCliente=null;
	public Boolean mostrarid_tipo_grupo_forma_pagoAnticipoCliente=true;
	public Boolean activarid_tipo_grupo_forma_pagoAnticipoCliente=true;
	public Boolean cargarid_tipo_grupo_forma_pagoAnticipoCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_grupo_forma_pagoAnticipoCliente=false;//ConEventDepend=true

	public Border resaltarfechaAnticipoCliente=null;
	public Boolean mostrarfechaAnticipoCliente=true;
	public Boolean activarfechaAnticipoCliente=false;

	public Border resaltarvalorAnticipoCliente=null;
	public Boolean mostrarvalorAnticipoCliente=true;
	public Boolean activarvalorAnticipoCliente=true;

	public Border resaltardescripcionAnticipoCliente=null;
	public Boolean mostrardescripcionAnticipoCliente=true;
	public Boolean activardescripcionAnticipoCliente=true;

	public Border resaltarvalor_adicionalAnticipoCliente=null;
	public Boolean mostrarvalor_adicionalAnticipoCliente=true;
	public Boolean activarvalor_adicionalAnticipoCliente=true;

	public Border resaltarvalor_prestamoAnticipoCliente=null;
	public Boolean mostrarvalor_prestamoAnticipoCliente=true;
	public Boolean activarvalor_prestamoAnticipoCliente=true;

	public Border resaltaringreso1AnticipoCliente=null;
	public Boolean mostraringreso1AnticipoCliente=true;
	public Boolean activaringreso1AnticipoCliente=true;

	public Border resaltaringreso2AnticipoCliente=null;
	public Boolean mostraringreso2AnticipoCliente=true;
	public Boolean activaringreso2AnticipoCliente=true;

	public Border resaltaringreso3AnticipoCliente=null;
	public Boolean mostraringreso3AnticipoCliente=true;
	public Boolean activaringreso3AnticipoCliente=true;

	public Border resaltaringreso4AnticipoCliente=null;
	public Boolean mostraringreso4AnticipoCliente=true;
	public Boolean activaringreso4AnticipoCliente=true;

	public Border resaltaringreso5AnticipoCliente=null;
	public Boolean mostraringreso5AnticipoCliente=true;
	public Boolean activaringreso5AnticipoCliente=true;

	public Border resaltardescuento1AnticipoCliente=null;
	public Boolean mostrardescuento1AnticipoCliente=true;
	public Boolean activardescuento1AnticipoCliente=true;

	public Border resaltardescuento2AnticipoCliente=null;
	public Boolean mostrardescuento2AnticipoCliente=true;
	public Boolean activardescuento2AnticipoCliente=true;

	public Border resaltardescuento3AnticipoCliente=null;
	public Boolean mostrardescuento3AnticipoCliente=true;
	public Boolean activardescuento3AnticipoCliente=true;

	public Border resaltardescuento4AnticipoCliente=null;
	public Boolean mostrardescuento4AnticipoCliente=true;
	public Boolean activardescuento4AnticipoCliente=true;

	public Border resaltardescuento5AnticipoCliente=null;
	public Boolean mostrardescuento5AnticipoCliente=true;
	public Boolean activardescuento5AnticipoCliente=true;

	public Border resaltartipo_ingresoAnticipoCliente=null;
	public Boolean mostrartipo_ingresoAnticipoCliente=true;
	public Boolean activartipo_ingresoAnticipoCliente=true;

	public Border resaltartipo_descuentoAnticipoCliente=null;
	public Boolean mostrartipo_descuentoAnticipoCliente=true;
	public Boolean activartipo_descuentoAnticipoCliente=true;

	
	

	public Border setResaltaridAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltaridAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAnticipoCliente() {
		return this.resaltaridAnticipoCliente;
	}

	public void setResaltaridAnticipoCliente(Border borderResaltar) {
		this.resaltaridAnticipoCliente= borderResaltar;
	}

	public Boolean getMostraridAnticipoCliente() {
		return this.mostraridAnticipoCliente;
	}

	public void setMostraridAnticipoCliente(Boolean mostraridAnticipoCliente) {
		this.mostraridAnticipoCliente= mostraridAnticipoCliente;
	}

	public Boolean getActivaridAnticipoCliente() {
		return this.activaridAnticipoCliente;
	}

	public void setActivaridAnticipoCliente(Boolean activaridAnticipoCliente) {
		this.activaridAnticipoCliente= activaridAnticipoCliente;
	}

	public Border setResaltarid_empresaAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAnticipoCliente() {
		return this.resaltarid_empresaAnticipoCliente;
	}

	public void setResaltarid_empresaAnticipoCliente(Border borderResaltar) {
		this.resaltarid_empresaAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaAnticipoCliente() {
		return this.mostrarid_empresaAnticipoCliente;
	}

	public void setMostrarid_empresaAnticipoCliente(Boolean mostrarid_empresaAnticipoCliente) {
		this.mostrarid_empresaAnticipoCliente= mostrarid_empresaAnticipoCliente;
	}

	public Boolean getActivarid_empresaAnticipoCliente() {
		return this.activarid_empresaAnticipoCliente;
	}

	public void setActivarid_empresaAnticipoCliente(Boolean activarid_empresaAnticipoCliente) {
		this.activarid_empresaAnticipoCliente= activarid_empresaAnticipoCliente;
	}

	public Boolean getCargarid_empresaAnticipoCliente() {
		return this.cargarid_empresaAnticipoCliente;
	}

	public void setCargarid_empresaAnticipoCliente(Boolean cargarid_empresaAnticipoCliente) {
		this.cargarid_empresaAnticipoCliente= cargarid_empresaAnticipoCliente;
	}

	public Border setResaltarid_empleadoAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarid_empleadoAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoAnticipoCliente() {
		return this.resaltarid_empleadoAnticipoCliente;
	}

	public void setResaltarid_empleadoAnticipoCliente(Border borderResaltar) {
		this.resaltarid_empleadoAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrarid_empleadoAnticipoCliente() {
		return this.mostrarid_empleadoAnticipoCliente;
	}

	public void setMostrarid_empleadoAnticipoCliente(Boolean mostrarid_empleadoAnticipoCliente) {
		this.mostrarid_empleadoAnticipoCliente= mostrarid_empleadoAnticipoCliente;
	}

	public Boolean getActivarid_empleadoAnticipoCliente() {
		return this.activarid_empleadoAnticipoCliente;
	}

	public void setActivarid_empleadoAnticipoCliente(Boolean activarid_empleadoAnticipoCliente) {
		this.activarid_empleadoAnticipoCliente= activarid_empleadoAnticipoCliente;
	}

	public Boolean getCargarid_empleadoAnticipoCliente() {
		return this.cargarid_empleadoAnticipoCliente;
	}

	public void setCargarid_empleadoAnticipoCliente(Boolean cargarid_empleadoAnticipoCliente) {
		this.cargarid_empleadoAnticipoCliente= cargarid_empleadoAnticipoCliente;
	}

	public Border setResaltarid_estado_anti_clienteAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarid_estado_anti_clienteAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_anti_clienteAnticipoCliente() {
		return this.resaltarid_estado_anti_clienteAnticipoCliente;
	}

	public void setResaltarid_estado_anti_clienteAnticipoCliente(Border borderResaltar) {
		this.resaltarid_estado_anti_clienteAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrarid_estado_anti_clienteAnticipoCliente() {
		return this.mostrarid_estado_anti_clienteAnticipoCliente;
	}

	public void setMostrarid_estado_anti_clienteAnticipoCliente(Boolean mostrarid_estado_anti_clienteAnticipoCliente) {
		this.mostrarid_estado_anti_clienteAnticipoCliente= mostrarid_estado_anti_clienteAnticipoCliente;
	}

	public Boolean getActivarid_estado_anti_clienteAnticipoCliente() {
		return this.activarid_estado_anti_clienteAnticipoCliente;
	}

	public void setActivarid_estado_anti_clienteAnticipoCliente(Boolean activarid_estado_anti_clienteAnticipoCliente) {
		this.activarid_estado_anti_clienteAnticipoCliente= activarid_estado_anti_clienteAnticipoCliente;
	}

	public Boolean getCargarid_estado_anti_clienteAnticipoCliente() {
		return this.cargarid_estado_anti_clienteAnticipoCliente;
	}

	public void setCargarid_estado_anti_clienteAnticipoCliente(Boolean cargarid_estado_anti_clienteAnticipoCliente) {
		this.cargarid_estado_anti_clienteAnticipoCliente= cargarid_estado_anti_clienteAnticipoCliente;
	}

	public Border setResaltarid_tipo_grupo_forma_pagoAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarid_tipo_grupo_forma_pagoAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_grupo_forma_pagoAnticipoCliente() {
		return this.resaltarid_tipo_grupo_forma_pagoAnticipoCliente;
	}

	public void setResaltarid_tipo_grupo_forma_pagoAnticipoCliente(Border borderResaltar) {
		this.resaltarid_tipo_grupo_forma_pagoAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrarid_tipo_grupo_forma_pagoAnticipoCliente() {
		return this.mostrarid_tipo_grupo_forma_pagoAnticipoCliente;
	}

	public void setMostrarid_tipo_grupo_forma_pagoAnticipoCliente(Boolean mostrarid_tipo_grupo_forma_pagoAnticipoCliente) {
		this.mostrarid_tipo_grupo_forma_pagoAnticipoCliente= mostrarid_tipo_grupo_forma_pagoAnticipoCliente;
	}

	public Boolean getActivarid_tipo_grupo_forma_pagoAnticipoCliente() {
		return this.activarid_tipo_grupo_forma_pagoAnticipoCliente;
	}

	public void setActivarid_tipo_grupo_forma_pagoAnticipoCliente(Boolean activarid_tipo_grupo_forma_pagoAnticipoCliente) {
		this.activarid_tipo_grupo_forma_pagoAnticipoCliente= activarid_tipo_grupo_forma_pagoAnticipoCliente;
	}

	public Boolean getCargarid_tipo_grupo_forma_pagoAnticipoCliente() {
		return this.cargarid_tipo_grupo_forma_pagoAnticipoCliente;
	}

	public void setCargarid_tipo_grupo_forma_pagoAnticipoCliente(Boolean cargarid_tipo_grupo_forma_pagoAnticipoCliente) {
		this.cargarid_tipo_grupo_forma_pagoAnticipoCliente= cargarid_tipo_grupo_forma_pagoAnticipoCliente;
	}

	public Border setResaltarfechaAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarfechaAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaAnticipoCliente() {
		return this.resaltarfechaAnticipoCliente;
	}

	public void setResaltarfechaAnticipoCliente(Border borderResaltar) {
		this.resaltarfechaAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrarfechaAnticipoCliente() {
		return this.mostrarfechaAnticipoCliente;
	}

	public void setMostrarfechaAnticipoCliente(Boolean mostrarfechaAnticipoCliente) {
		this.mostrarfechaAnticipoCliente= mostrarfechaAnticipoCliente;
	}

	public Boolean getActivarfechaAnticipoCliente() {
		return this.activarfechaAnticipoCliente;
	}

	public void setActivarfechaAnticipoCliente(Boolean activarfechaAnticipoCliente) {
		this.activarfechaAnticipoCliente= activarfechaAnticipoCliente;
	}

	public Border setResaltarvalorAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarvalorAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorAnticipoCliente() {
		return this.resaltarvalorAnticipoCliente;
	}

	public void setResaltarvalorAnticipoCliente(Border borderResaltar) {
		this.resaltarvalorAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrarvalorAnticipoCliente() {
		return this.mostrarvalorAnticipoCliente;
	}

	public void setMostrarvalorAnticipoCliente(Boolean mostrarvalorAnticipoCliente) {
		this.mostrarvalorAnticipoCliente= mostrarvalorAnticipoCliente;
	}

	public Boolean getActivarvalorAnticipoCliente() {
		return this.activarvalorAnticipoCliente;
	}

	public void setActivarvalorAnticipoCliente(Boolean activarvalorAnticipoCliente) {
		this.activarvalorAnticipoCliente= activarvalorAnticipoCliente;
	}

	public Border setResaltardescripcionAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionAnticipoCliente() {
		return this.resaltardescripcionAnticipoCliente;
	}

	public void setResaltardescripcionAnticipoCliente(Border borderResaltar) {
		this.resaltardescripcionAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionAnticipoCliente() {
		return this.mostrardescripcionAnticipoCliente;
	}

	public void setMostrardescripcionAnticipoCliente(Boolean mostrardescripcionAnticipoCliente) {
		this.mostrardescripcionAnticipoCliente= mostrardescripcionAnticipoCliente;
	}

	public Boolean getActivardescripcionAnticipoCliente() {
		return this.activardescripcionAnticipoCliente;
	}

	public void setActivardescripcionAnticipoCliente(Boolean activardescripcionAnticipoCliente) {
		this.activardescripcionAnticipoCliente= activardescripcionAnticipoCliente;
	}

	public Border setResaltarvalor_adicionalAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarvalor_adicionalAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_adicionalAnticipoCliente() {
		return this.resaltarvalor_adicionalAnticipoCliente;
	}

	public void setResaltarvalor_adicionalAnticipoCliente(Border borderResaltar) {
		this.resaltarvalor_adicionalAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrarvalor_adicionalAnticipoCliente() {
		return this.mostrarvalor_adicionalAnticipoCliente;
	}

	public void setMostrarvalor_adicionalAnticipoCliente(Boolean mostrarvalor_adicionalAnticipoCliente) {
		this.mostrarvalor_adicionalAnticipoCliente= mostrarvalor_adicionalAnticipoCliente;
	}

	public Boolean getActivarvalor_adicionalAnticipoCliente() {
		return this.activarvalor_adicionalAnticipoCliente;
	}

	public void setActivarvalor_adicionalAnticipoCliente(Boolean activarvalor_adicionalAnticipoCliente) {
		this.activarvalor_adicionalAnticipoCliente= activarvalor_adicionalAnticipoCliente;
	}

	public Border setResaltarvalor_prestamoAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltarvalor_prestamoAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_prestamoAnticipoCliente() {
		return this.resaltarvalor_prestamoAnticipoCliente;
	}

	public void setResaltarvalor_prestamoAnticipoCliente(Border borderResaltar) {
		this.resaltarvalor_prestamoAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrarvalor_prestamoAnticipoCliente() {
		return this.mostrarvalor_prestamoAnticipoCliente;
	}

	public void setMostrarvalor_prestamoAnticipoCliente(Boolean mostrarvalor_prestamoAnticipoCliente) {
		this.mostrarvalor_prestamoAnticipoCliente= mostrarvalor_prestamoAnticipoCliente;
	}

	public Boolean getActivarvalor_prestamoAnticipoCliente() {
		return this.activarvalor_prestamoAnticipoCliente;
	}

	public void setActivarvalor_prestamoAnticipoCliente(Boolean activarvalor_prestamoAnticipoCliente) {
		this.activarvalor_prestamoAnticipoCliente= activarvalor_prestamoAnticipoCliente;
	}

	public Border setResaltaringreso1AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltaringreso1AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso1AnticipoCliente() {
		return this.resaltaringreso1AnticipoCliente;
	}

	public void setResaltaringreso1AnticipoCliente(Border borderResaltar) {
		this.resaltaringreso1AnticipoCliente= borderResaltar;
	}

	public Boolean getMostraringreso1AnticipoCliente() {
		return this.mostraringreso1AnticipoCliente;
	}

	public void setMostraringreso1AnticipoCliente(Boolean mostraringreso1AnticipoCliente) {
		this.mostraringreso1AnticipoCliente= mostraringreso1AnticipoCliente;
	}

	public Boolean getActivaringreso1AnticipoCliente() {
		return this.activaringreso1AnticipoCliente;
	}

	public void setActivaringreso1AnticipoCliente(Boolean activaringreso1AnticipoCliente) {
		this.activaringreso1AnticipoCliente= activaringreso1AnticipoCliente;
	}

	public Border setResaltaringreso2AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltaringreso2AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso2AnticipoCliente() {
		return this.resaltaringreso2AnticipoCliente;
	}

	public void setResaltaringreso2AnticipoCliente(Border borderResaltar) {
		this.resaltaringreso2AnticipoCliente= borderResaltar;
	}

	public Boolean getMostraringreso2AnticipoCliente() {
		return this.mostraringreso2AnticipoCliente;
	}

	public void setMostraringreso2AnticipoCliente(Boolean mostraringreso2AnticipoCliente) {
		this.mostraringreso2AnticipoCliente= mostraringreso2AnticipoCliente;
	}

	public Boolean getActivaringreso2AnticipoCliente() {
		return this.activaringreso2AnticipoCliente;
	}

	public void setActivaringreso2AnticipoCliente(Boolean activaringreso2AnticipoCliente) {
		this.activaringreso2AnticipoCliente= activaringreso2AnticipoCliente;
	}

	public Border setResaltaringreso3AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltaringreso3AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso3AnticipoCliente() {
		return this.resaltaringreso3AnticipoCliente;
	}

	public void setResaltaringreso3AnticipoCliente(Border borderResaltar) {
		this.resaltaringreso3AnticipoCliente= borderResaltar;
	}

	public Boolean getMostraringreso3AnticipoCliente() {
		return this.mostraringreso3AnticipoCliente;
	}

	public void setMostraringreso3AnticipoCliente(Boolean mostraringreso3AnticipoCliente) {
		this.mostraringreso3AnticipoCliente= mostraringreso3AnticipoCliente;
	}

	public Boolean getActivaringreso3AnticipoCliente() {
		return this.activaringreso3AnticipoCliente;
	}

	public void setActivaringreso3AnticipoCliente(Boolean activaringreso3AnticipoCliente) {
		this.activaringreso3AnticipoCliente= activaringreso3AnticipoCliente;
	}

	public Border setResaltaringreso4AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltaringreso4AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso4AnticipoCliente() {
		return this.resaltaringreso4AnticipoCliente;
	}

	public void setResaltaringreso4AnticipoCliente(Border borderResaltar) {
		this.resaltaringreso4AnticipoCliente= borderResaltar;
	}

	public Boolean getMostraringreso4AnticipoCliente() {
		return this.mostraringreso4AnticipoCliente;
	}

	public void setMostraringreso4AnticipoCliente(Boolean mostraringreso4AnticipoCliente) {
		this.mostraringreso4AnticipoCliente= mostraringreso4AnticipoCliente;
	}

	public Boolean getActivaringreso4AnticipoCliente() {
		return this.activaringreso4AnticipoCliente;
	}

	public void setActivaringreso4AnticipoCliente(Boolean activaringreso4AnticipoCliente) {
		this.activaringreso4AnticipoCliente= activaringreso4AnticipoCliente;
	}

	public Border setResaltaringreso5AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltaringreso5AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaringreso5AnticipoCliente() {
		return this.resaltaringreso5AnticipoCliente;
	}

	public void setResaltaringreso5AnticipoCliente(Border borderResaltar) {
		this.resaltaringreso5AnticipoCliente= borderResaltar;
	}

	public Boolean getMostraringreso5AnticipoCliente() {
		return this.mostraringreso5AnticipoCliente;
	}

	public void setMostraringreso5AnticipoCliente(Boolean mostraringreso5AnticipoCliente) {
		this.mostraringreso5AnticipoCliente= mostraringreso5AnticipoCliente;
	}

	public Boolean getActivaringreso5AnticipoCliente() {
		return this.activaringreso5AnticipoCliente;
	}

	public void setActivaringreso5AnticipoCliente(Boolean activaringreso5AnticipoCliente) {
		this.activaringreso5AnticipoCliente= activaringreso5AnticipoCliente;
	}

	public Border setResaltardescuento1AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltardescuento1AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento1AnticipoCliente() {
		return this.resaltardescuento1AnticipoCliente;
	}

	public void setResaltardescuento1AnticipoCliente(Border borderResaltar) {
		this.resaltardescuento1AnticipoCliente= borderResaltar;
	}

	public Boolean getMostrardescuento1AnticipoCliente() {
		return this.mostrardescuento1AnticipoCliente;
	}

	public void setMostrardescuento1AnticipoCliente(Boolean mostrardescuento1AnticipoCliente) {
		this.mostrardescuento1AnticipoCliente= mostrardescuento1AnticipoCliente;
	}

	public Boolean getActivardescuento1AnticipoCliente() {
		return this.activardescuento1AnticipoCliente;
	}

	public void setActivardescuento1AnticipoCliente(Boolean activardescuento1AnticipoCliente) {
		this.activardescuento1AnticipoCliente= activardescuento1AnticipoCliente;
	}

	public Border setResaltardescuento2AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltardescuento2AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento2AnticipoCliente() {
		return this.resaltardescuento2AnticipoCliente;
	}

	public void setResaltardescuento2AnticipoCliente(Border borderResaltar) {
		this.resaltardescuento2AnticipoCliente= borderResaltar;
	}

	public Boolean getMostrardescuento2AnticipoCliente() {
		return this.mostrardescuento2AnticipoCliente;
	}

	public void setMostrardescuento2AnticipoCliente(Boolean mostrardescuento2AnticipoCliente) {
		this.mostrardescuento2AnticipoCliente= mostrardescuento2AnticipoCliente;
	}

	public Boolean getActivardescuento2AnticipoCliente() {
		return this.activardescuento2AnticipoCliente;
	}

	public void setActivardescuento2AnticipoCliente(Boolean activardescuento2AnticipoCliente) {
		this.activardescuento2AnticipoCliente= activardescuento2AnticipoCliente;
	}

	public Border setResaltardescuento3AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltardescuento3AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento3AnticipoCliente() {
		return this.resaltardescuento3AnticipoCliente;
	}

	public void setResaltardescuento3AnticipoCliente(Border borderResaltar) {
		this.resaltardescuento3AnticipoCliente= borderResaltar;
	}

	public Boolean getMostrardescuento3AnticipoCliente() {
		return this.mostrardescuento3AnticipoCliente;
	}

	public void setMostrardescuento3AnticipoCliente(Boolean mostrardescuento3AnticipoCliente) {
		this.mostrardescuento3AnticipoCliente= mostrardescuento3AnticipoCliente;
	}

	public Boolean getActivardescuento3AnticipoCliente() {
		return this.activardescuento3AnticipoCliente;
	}

	public void setActivardescuento3AnticipoCliente(Boolean activardescuento3AnticipoCliente) {
		this.activardescuento3AnticipoCliente= activardescuento3AnticipoCliente;
	}

	public Border setResaltardescuento4AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltardescuento4AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento4AnticipoCliente() {
		return this.resaltardescuento4AnticipoCliente;
	}

	public void setResaltardescuento4AnticipoCliente(Border borderResaltar) {
		this.resaltardescuento4AnticipoCliente= borderResaltar;
	}

	public Boolean getMostrardescuento4AnticipoCliente() {
		return this.mostrardescuento4AnticipoCliente;
	}

	public void setMostrardescuento4AnticipoCliente(Boolean mostrardescuento4AnticipoCliente) {
		this.mostrardescuento4AnticipoCliente= mostrardescuento4AnticipoCliente;
	}

	public Boolean getActivardescuento4AnticipoCliente() {
		return this.activardescuento4AnticipoCliente;
	}

	public void setActivardescuento4AnticipoCliente(Boolean activardescuento4AnticipoCliente) {
		this.activardescuento4AnticipoCliente= activardescuento4AnticipoCliente;
	}

	public Border setResaltardescuento5AnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltardescuento5AnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento5AnticipoCliente() {
		return this.resaltardescuento5AnticipoCliente;
	}

	public void setResaltardescuento5AnticipoCliente(Border borderResaltar) {
		this.resaltardescuento5AnticipoCliente= borderResaltar;
	}

	public Boolean getMostrardescuento5AnticipoCliente() {
		return this.mostrardescuento5AnticipoCliente;
	}

	public void setMostrardescuento5AnticipoCliente(Boolean mostrardescuento5AnticipoCliente) {
		this.mostrardescuento5AnticipoCliente= mostrardescuento5AnticipoCliente;
	}

	public Boolean getActivardescuento5AnticipoCliente() {
		return this.activardescuento5AnticipoCliente;
	}

	public void setActivardescuento5AnticipoCliente(Boolean activardescuento5AnticipoCliente) {
		this.activardescuento5AnticipoCliente= activardescuento5AnticipoCliente;
	}

	public Border setResaltartipo_ingresoAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltartipo_ingresoAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_ingresoAnticipoCliente() {
		return this.resaltartipo_ingresoAnticipoCliente;
	}

	public void setResaltartipo_ingresoAnticipoCliente(Border borderResaltar) {
		this.resaltartipo_ingresoAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrartipo_ingresoAnticipoCliente() {
		return this.mostrartipo_ingresoAnticipoCliente;
	}

	public void setMostrartipo_ingresoAnticipoCliente(Boolean mostrartipo_ingresoAnticipoCliente) {
		this.mostrartipo_ingresoAnticipoCliente= mostrartipo_ingresoAnticipoCliente;
	}

	public Boolean getActivartipo_ingresoAnticipoCliente() {
		return this.activartipo_ingresoAnticipoCliente;
	}

	public void setActivartipo_ingresoAnticipoCliente(Boolean activartipo_ingresoAnticipoCliente) {
		this.activartipo_ingresoAnticipoCliente= activartipo_ingresoAnticipoCliente;
	}

	public Border setResaltartipo_descuentoAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//anticipoclienteBeanSwingJInternalFrame.jTtoolBarAnticipoCliente.setBorder(borderResaltar);
		
		this.resaltartipo_descuentoAnticipoCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartipo_descuentoAnticipoCliente() {
		return this.resaltartipo_descuentoAnticipoCliente;
	}

	public void setResaltartipo_descuentoAnticipoCliente(Border borderResaltar) {
		this.resaltartipo_descuentoAnticipoCliente= borderResaltar;
	}

	public Boolean getMostrartipo_descuentoAnticipoCliente() {
		return this.mostrartipo_descuentoAnticipoCliente;
	}

	public void setMostrartipo_descuentoAnticipoCliente(Boolean mostrartipo_descuentoAnticipoCliente) {
		this.mostrartipo_descuentoAnticipoCliente= mostrartipo_descuentoAnticipoCliente;
	}

	public Boolean getActivartipo_descuentoAnticipoCliente() {
		return this.activartipo_descuentoAnticipoCliente;
	}

	public void setActivartipo_descuentoAnticipoCliente(Boolean activartipo_descuentoAnticipoCliente) {
		this.activartipo_descuentoAnticipoCliente= activartipo_descuentoAnticipoCliente;
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
		
		
		this.setMostraridAnticipoCliente(esInicial);
		this.setMostrarid_empresaAnticipoCliente(esInicial);
		this.setMostrarid_empleadoAnticipoCliente(esInicial);
		this.setMostrarid_estado_anti_clienteAnticipoCliente(esInicial);
		this.setMostrarid_tipo_grupo_forma_pagoAnticipoCliente(esInicial);
		this.setMostrarfechaAnticipoCliente(esInicial);
		this.setMostrarvalorAnticipoCliente(esInicial);
		this.setMostrardescripcionAnticipoCliente(esInicial);
		this.setMostrarvalor_adicionalAnticipoCliente(esInicial);
		this.setMostrarvalor_prestamoAnticipoCliente(esInicial);
		this.setMostraringreso1AnticipoCliente(esInicial);
		this.setMostraringreso2AnticipoCliente(esInicial);
		this.setMostraringreso3AnticipoCliente(esInicial);
		this.setMostraringreso4AnticipoCliente(esInicial);
		this.setMostraringreso5AnticipoCliente(esInicial);
		this.setMostrardescuento1AnticipoCliente(esInicial);
		this.setMostrardescuento2AnticipoCliente(esInicial);
		this.setMostrardescuento3AnticipoCliente(esInicial);
		this.setMostrardescuento4AnticipoCliente(esInicial);
		this.setMostrardescuento5AnticipoCliente(esInicial);
		this.setMostrartipo_ingresoAnticipoCliente(esInicial);
		this.setMostrartipo_descuentoAnticipoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.ID)) {
				this.setMostraridAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE)) {
				this.setMostrarid_estado_anti_clienteAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setMostrarid_tipo_grupo_forma_pagoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.FECHA)) {
				this.setMostrarfechaAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALOR)) {
				this.setMostrarvalorAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALORADICIONAL)) {
				this.setMostrarvalor_adicionalAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALORPRESTAMO)) {
				this.setMostrarvalor_prestamoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO1)) {
				this.setMostraringreso1AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO2)) {
				this.setMostraringreso2AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO3)) {
				this.setMostraringreso3AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO4)) {
				this.setMostraringreso4AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO5)) {
				this.setMostraringreso5AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO1)) {
				this.setMostrardescuento1AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO2)) {
				this.setMostrardescuento2AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO3)) {
				this.setMostrardescuento3AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO4)) {
				this.setMostrardescuento4AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO5)) {
				this.setMostrardescuento5AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.TIPOINGRESO)) {
				this.setMostrartipo_ingresoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.TIPODESCUENTO)) {
				this.setMostrartipo_descuentoAnticipoCliente(esAsigna);
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
		
		
		this.setActivaridAnticipoCliente(esInicial);
		this.setActivarid_empresaAnticipoCliente(esInicial);
		this.setActivarid_empleadoAnticipoCliente(esInicial);
		this.setActivarid_estado_anti_clienteAnticipoCliente(esInicial);
		this.setActivarid_tipo_grupo_forma_pagoAnticipoCliente(esInicial);
		this.setActivarfechaAnticipoCliente(esInicial);
		this.setActivarvalorAnticipoCliente(esInicial);
		this.setActivardescripcionAnticipoCliente(esInicial);
		this.setActivarvalor_adicionalAnticipoCliente(esInicial);
		this.setActivarvalor_prestamoAnticipoCliente(esInicial);
		this.setActivaringreso1AnticipoCliente(esInicial);
		this.setActivaringreso2AnticipoCliente(esInicial);
		this.setActivaringreso3AnticipoCliente(esInicial);
		this.setActivaringreso4AnticipoCliente(esInicial);
		this.setActivaringreso5AnticipoCliente(esInicial);
		this.setActivardescuento1AnticipoCliente(esInicial);
		this.setActivardescuento2AnticipoCliente(esInicial);
		this.setActivardescuento3AnticipoCliente(esInicial);
		this.setActivardescuento4AnticipoCliente(esInicial);
		this.setActivardescuento5AnticipoCliente(esInicial);
		this.setActivartipo_ingresoAnticipoCliente(esInicial);
		this.setActivartipo_descuentoAnticipoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.ID)) {
				this.setActivaridAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE)) {
				this.setActivarid_estado_anti_clienteAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setActivarid_tipo_grupo_forma_pagoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.FECHA)) {
				this.setActivarfechaAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALOR)) {
				this.setActivarvalorAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALORADICIONAL)) {
				this.setActivarvalor_adicionalAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALORPRESTAMO)) {
				this.setActivarvalor_prestamoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO1)) {
				this.setActivaringreso1AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO2)) {
				this.setActivaringreso2AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO3)) {
				this.setActivaringreso3AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO4)) {
				this.setActivaringreso4AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO5)) {
				this.setActivaringreso5AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO1)) {
				this.setActivardescuento1AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO2)) {
				this.setActivardescuento2AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO3)) {
				this.setActivardescuento3AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO4)) {
				this.setActivardescuento4AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO5)) {
				this.setActivardescuento5AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.TIPOINGRESO)) {
				this.setActivartipo_ingresoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.TIPODESCUENTO)) {
				this.setActivartipo_descuentoAnticipoCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAnticipoCliente(esInicial);
		this.setResaltarid_empresaAnticipoCliente(esInicial);
		this.setResaltarid_empleadoAnticipoCliente(esInicial);
		this.setResaltarid_estado_anti_clienteAnticipoCliente(esInicial);
		this.setResaltarid_tipo_grupo_forma_pagoAnticipoCliente(esInicial);
		this.setResaltarfechaAnticipoCliente(esInicial);
		this.setResaltarvalorAnticipoCliente(esInicial);
		this.setResaltardescripcionAnticipoCliente(esInicial);
		this.setResaltarvalor_adicionalAnticipoCliente(esInicial);
		this.setResaltarvalor_prestamoAnticipoCliente(esInicial);
		this.setResaltaringreso1AnticipoCliente(esInicial);
		this.setResaltaringreso2AnticipoCliente(esInicial);
		this.setResaltaringreso3AnticipoCliente(esInicial);
		this.setResaltaringreso4AnticipoCliente(esInicial);
		this.setResaltaringreso5AnticipoCliente(esInicial);
		this.setResaltardescuento1AnticipoCliente(esInicial);
		this.setResaltardescuento2AnticipoCliente(esInicial);
		this.setResaltardescuento3AnticipoCliente(esInicial);
		this.setResaltardescuento4AnticipoCliente(esInicial);
		this.setResaltardescuento5AnticipoCliente(esInicial);
		this.setResaltartipo_ingresoAnticipoCliente(esInicial);
		this.setResaltartipo_descuentoAnticipoCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.ID)) {
				this.setResaltaridAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDESTADOANTICLIENTE)) {
				this.setResaltarid_estado_anti_clienteAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.IDTIPOGRUPOFORMAPAGO)) {
				this.setResaltarid_tipo_grupo_forma_pagoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.FECHA)) {
				this.setResaltarfechaAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALOR)) {
				this.setResaltarvalorAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALORADICIONAL)) {
				this.setResaltarvalor_adicionalAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.VALORPRESTAMO)) {
				this.setResaltarvalor_prestamoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO1)) {
				this.setResaltaringreso1AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO2)) {
				this.setResaltaringreso2AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO3)) {
				this.setResaltaringreso3AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO4)) {
				this.setResaltaringreso4AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.INGRESO5)) {
				this.setResaltaringreso5AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO1)) {
				this.setResaltardescuento1AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO2)) {
				this.setResaltardescuento2AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO3)) {
				this.setResaltardescuento3AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO4)) {
				this.setResaltardescuento4AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.DESCUENTO5)) {
				this.setResaltardescuento5AnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.TIPOINGRESO)) {
				this.setResaltartipo_ingresoAnticipoCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnticipoClienteConstantesFunciones.TIPODESCUENTO)) {
				this.setResaltartipo_descuentoAnticipoCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpleadoAnticipoCliente=true;

	public Boolean getMostrarFK_IdEmpleadoAnticipoCliente() {
		return this.mostrarFK_IdEmpleadoAnticipoCliente;
	}

	public void setMostrarFK_IdEmpleadoAnticipoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoAnticipoCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaAnticipoCliente=true;

	public Boolean getMostrarFK_IdEmpresaAnticipoCliente() {
		return this.mostrarFK_IdEmpresaAnticipoCliente;
	}

	public void setMostrarFK_IdEmpresaAnticipoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaAnticipoCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoAntiClienteAnticipoCliente=true;

	public Boolean getMostrarFK_IdEstadoAntiClienteAnticipoCliente() {
		return this.mostrarFK_IdEstadoAntiClienteAnticipoCliente;
	}

	public void setMostrarFK_IdEstadoAntiClienteAnticipoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoAntiClienteAnticipoCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGrupoFormaPagoAnticipoCliente=true;

	public Boolean getMostrarFK_IdTipoGrupoFormaPagoAnticipoCliente() {
		return this.mostrarFK_IdTipoGrupoFormaPagoAnticipoCliente;
	}

	public void setMostrarFK_IdTipoGrupoFormaPagoAnticipoCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGrupoFormaPagoAnticipoCliente= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpleadoAnticipoCliente=true;

	public Boolean getActivarFK_IdEmpleadoAnticipoCliente() {
		return this.activarFK_IdEmpleadoAnticipoCliente;
	}

	public void setActivarFK_IdEmpleadoAnticipoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoAnticipoCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaAnticipoCliente=true;

	public Boolean getActivarFK_IdEmpresaAnticipoCliente() {
		return this.activarFK_IdEmpresaAnticipoCliente;
	}

	public void setActivarFK_IdEmpresaAnticipoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaAnticipoCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoAntiClienteAnticipoCliente=true;

	public Boolean getActivarFK_IdEstadoAntiClienteAnticipoCliente() {
		return this.activarFK_IdEstadoAntiClienteAnticipoCliente;
	}

	public void setActivarFK_IdEstadoAntiClienteAnticipoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoAntiClienteAnticipoCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGrupoFormaPagoAnticipoCliente=true;

	public Boolean getActivarFK_IdTipoGrupoFormaPagoAnticipoCliente() {
		return this.activarFK_IdTipoGrupoFormaPagoAnticipoCliente;
	}

	public void setActivarFK_IdTipoGrupoFormaPagoAnticipoCliente(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGrupoFormaPagoAnticipoCliente= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpleadoAnticipoCliente=null;

	public Border getResaltarFK_IdEmpleadoAnticipoCliente() {
		return this.resaltarFK_IdEmpleadoAnticipoCliente;
	}

	public void setResaltarFK_IdEmpleadoAnticipoCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoAnticipoCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoAnticipoCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaAnticipoCliente=null;

	public Border getResaltarFK_IdEmpresaAnticipoCliente() {
		return this.resaltarFK_IdEmpresaAnticipoCliente;
	}

	public void setResaltarFK_IdEmpresaAnticipoCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaAnticipoCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaAnticipoCliente= borderResaltar;
	}

	public Border resaltarFK_IdEstadoAntiClienteAnticipoCliente=null;

	public Border getResaltarFK_IdEstadoAntiClienteAnticipoCliente() {
		return this.resaltarFK_IdEstadoAntiClienteAnticipoCliente;
	}

	public void setResaltarFK_IdEstadoAntiClienteAnticipoCliente(Border borderResaltar) {
		this.resaltarFK_IdEstadoAntiClienteAnticipoCliente= borderResaltar;
	}

	public void setResaltarFK_IdEstadoAntiClienteAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoAntiClienteAnticipoCliente= borderResaltar;
	}

	public Border resaltarFK_IdTipoGrupoFormaPagoAnticipoCliente=null;

	public Border getResaltarFK_IdTipoGrupoFormaPagoAnticipoCliente() {
		return this.resaltarFK_IdTipoGrupoFormaPagoAnticipoCliente;
	}

	public void setResaltarFK_IdTipoGrupoFormaPagoAnticipoCliente(Border borderResaltar) {
		this.resaltarFK_IdTipoGrupoFormaPagoAnticipoCliente= borderResaltar;
	}

	public void setResaltarFK_IdTipoGrupoFormaPagoAnticipoCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnticipoClienteBeanSwingJInternalFrame anticipoclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGrupoFormaPagoAnticipoCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}