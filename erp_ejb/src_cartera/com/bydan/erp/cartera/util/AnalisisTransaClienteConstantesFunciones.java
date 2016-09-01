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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.AnalisisTransaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.AnalisisTransaClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.AnalisisTransaClienteParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AnalisisTransaClienteConstantesFunciones extends AnalisisTransaClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="AnalisisTransaCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AnalisisTransaCliente"+AnalisisTransaClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AnalisisTransaClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AnalisisTransaClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AnalisisTransaClienteConstantesFunciones.SCHEMA+"_"+AnalisisTransaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AnalisisTransaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AnalisisTransaClienteConstantesFunciones.SCHEMA+"_"+AnalisisTransaClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AnalisisTransaClienteConstantesFunciones.SCHEMA+"_"+AnalisisTransaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AnalisisTransaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AnalisisTransaClienteConstantesFunciones.SCHEMA+"_"+AnalisisTransaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnalisisTransaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AnalisisTransaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnalisisTransaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnalisisTransaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AnalisisTransaClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AnalisisTransaClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AnalisisTransaClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AnalisisTransaClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AnalisisTransaClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AnalisisTransaClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Analisis Transaccion Clientees";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Analisis Transaccion Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Analisis Transa Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AnalisisTransaCliente";
	public static final String OBJECTNAME="analisistransacliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="analisis_transa_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select analisistransacliente from "+AnalisisTransaClienteConstantesFunciones.SPERSISTENCENAME+" analisistransacliente";
	public static String QUERYSELECTNATIVE="select "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".version_row,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_empresa,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_modulo,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".nombre,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".descripcion,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion1,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion2,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion3,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion4,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion5,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion6,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion7,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion8,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion9,"+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME+".id_transaccion10 from "+AnalisisTransaClienteConstantesFunciones.SCHEMA+"."+AnalisisTransaClienteConstantesFunciones.TABLENAME;//+" as "+AnalisisTransaClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected AnalisisTransaClienteConstantesFuncionesAdditional analisistransaclienteConstantesFuncionesAdditional=null;
	
	public AnalisisTransaClienteConstantesFuncionesAdditional getAnalisisTransaClienteConstantesFuncionesAdditional() {
		return this.analisistransaclienteConstantesFuncionesAdditional;
	}
	
	public void setAnalisisTransaClienteConstantesFuncionesAdditional(AnalisisTransaClienteConstantesFuncionesAdditional analisistransaclienteConstantesFuncionesAdditional) {
		try {
			this.analisistransaclienteConstantesFuncionesAdditional=analisistransaclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String NOMBRE= "nombre";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDTRANSACCION1= "id_transaccion1";
    public static final String IDTRANSACCION2= "id_transaccion2";
    public static final String IDTRANSACCION3= "id_transaccion3";
    public static final String IDTRANSACCION4= "id_transaccion4";
    public static final String IDTRANSACCION5= "id_transaccion5";
    public static final String IDTRANSACCION6= "id_transaccion6";
    public static final String IDTRANSACCION7= "id_transaccion7";
    public static final String IDTRANSACCION8= "id_transaccion8";
    public static final String IDTRANSACCION9= "id_transaccion9";
    public static final String IDTRANSACCION10= "id_transaccion10";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDTRANSACCION1= "Transaccion 1";
		public static final String LABEL_IDTRANSACCION1_LOWER= "Transaccion1";
    	public static final String LABEL_IDTRANSACCION2= "Transaccion 2";
		public static final String LABEL_IDTRANSACCION2_LOWER= "Transaccion2";
    	public static final String LABEL_IDTRANSACCION3= "Transaccion 3";
		public static final String LABEL_IDTRANSACCION3_LOWER= "Transaccion3";
    	public static final String LABEL_IDTRANSACCION4= "Transaccion 4";
		public static final String LABEL_IDTRANSACCION4_LOWER= "Transaccion4";
    	public static final String LABEL_IDTRANSACCION5= "Transaccion 5";
		public static final String LABEL_IDTRANSACCION5_LOWER= "Transaccion5";
    	public static final String LABEL_IDTRANSACCION6= "Transaccion 6";
		public static final String LABEL_IDTRANSACCION6_LOWER= "Transaccion6";
    	public static final String LABEL_IDTRANSACCION7= "Transaccion 7";
		public static final String LABEL_IDTRANSACCION7_LOWER= "Transaccion7";
    	public static final String LABEL_IDTRANSACCION8= "Transaccion 8";
		public static final String LABEL_IDTRANSACCION8_LOWER= "Transaccion8";
    	public static final String LABEL_IDTRANSACCION9= "Transaccion 9";
		public static final String LABEL_IDTRANSACCION9_LOWER= "Transaccion9";
    	public static final String LABEL_IDTRANSACCION10= "Transaccion 10";
		public static final String LABEL_IDTRANSACCION10_LOWER= "Transaccion10";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getAnalisisTransaClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDMODULO)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.NOMBRE)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.DESCRIPCION)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION1;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION2;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION3;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION4;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION5;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION6;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION7;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION8;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION9;}
		if(sNombreColumna.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10)) {sLabelColumna=AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION10;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAnalisisTransaClienteDescripcion(AnalisisTransaCliente analisistransacliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(analisistransacliente !=null/* && analisistransacliente.getId()!=0*/) {
			sDescripcion=analisistransacliente.getnombre();//analisistransaclienteanalisistransacliente.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAnalisisTransaClienteDescripcionDetallado(AnalisisTransaCliente analisistransacliente) {
		String sDescripcion="";
			
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.ID+"=";
		sDescripcion+=analisistransacliente.getId().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=analisistransacliente.getVersionRow().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=analisistransacliente.getid_empresa().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDMODULO+"=";
		sDescripcion+=analisistransacliente.getid_modulo().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=analisistransacliente.getnombre()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=analisistransacliente.getdescripcion()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=analisistransacliente.getid_transaccion().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1+"=";
		sDescripcion+=analisistransacliente.getid_transaccion1().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2+"=";
		sDescripcion+=analisistransacliente.getid_transaccion2().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3+"=";
		sDescripcion+=analisistransacliente.getid_transaccion3().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4+"=";
		sDescripcion+=analisistransacliente.getid_transaccion4().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5+"=";
		sDescripcion+=analisistransacliente.getid_transaccion5().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6+"=";
		sDescripcion+=analisistransacliente.getid_transaccion6().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7+"=";
		sDescripcion+=analisistransacliente.getid_transaccion7().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8+"=";
		sDescripcion+=analisistransacliente.getid_transaccion8().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9+"=";
		sDescripcion+=analisistransacliente.getid_transaccion9().toString()+",";
		sDescripcion+=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10+"=";
		sDescripcion+=analisistransacliente.getid_transaccion10().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAnalisisTransaClienteDescripcion(AnalisisTransaCliente analisistransacliente,String sValor) throws Exception {			
		if(analisistransacliente !=null) {
			analisistransacliente.setnombre(sValor);;//analisistransaclienteanalisistransacliente.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion1Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion2Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion3Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion4Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion5Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion6Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion7Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion8Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion9Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getTransaccion10Descripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		} else if(sNombreIndice.equals("FK_IdTransaccion1")) {
			sNombreIndice="Tipo=  Por Transaccion 1";
		} else if(sNombreIndice.equals("FK_IdTransaccion10")) {
			sNombreIndice="Tipo=  Por Transaccion 10";
		} else if(sNombreIndice.equals("FK_IdTransaccion2")) {
			sNombreIndice="Tipo=  Por Transaccion 2";
		} else if(sNombreIndice.equals("FK_IdTransaccion4")) {
			sNombreIndice="Tipo=  Por Transaccion 4";
		} else if(sNombreIndice.equals("FK_IdTransaccion5")) {
			sNombreIndice="Tipo=  Por Transaccion 5";
		} else if(sNombreIndice.equals("FK_IdTransaccion6")) {
			sNombreIndice="Tipo=  Por Transaccion 6";
		} else if(sNombreIndice.equals("FK_IdTransaccion7")) {
			sNombreIndice="Tipo=  Por Transaccion 7";
		} else if(sNombreIndice.equals("FK_IdTransaccion8")) {
			sNombreIndice="Tipo=  Por Transaccion 8";
		} else if(sNombreIndice.equals("FK_IdTransaccion9")) {
			sNombreIndice="Tipo=  Por Transaccion 9";
		} else if(sNombreIndice.equals("FK_IdTransaccionTransaccio3")) {
			sNombreIndice="Tipo=  Por Transaccion 3";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion1(Long id_transaccion1) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion1!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 1="+id_transaccion1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion10(Long id_transaccion10) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion10!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 10="+id_transaccion10.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion2(Long id_transaccion2) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion2!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 2="+id_transaccion2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion4(Long id_transaccion4) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion4!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 4="+id_transaccion4.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion5(Long id_transaccion5) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion5!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 5="+id_transaccion5.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion6(Long id_transaccion6) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion6!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 6="+id_transaccion6.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion7(Long id_transaccion7) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion7!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 7="+id_transaccion7.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion8(Long id_transaccion8) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion8!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 8="+id_transaccion8.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion9(Long id_transaccion9) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion9!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 9="+id_transaccion9.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccionTransaccio3(Long id_transaccion3) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion3!=null) {sDetalleIndice+=" Codigo Unico De Transaccion 3="+id_transaccion3.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAnalisisTransaCliente(AnalisisTransaCliente analisistransacliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		analisistransacliente.setnombre(analisistransacliente.getnombre().trim());
		analisistransacliente.setdescripcion(analisistransacliente.getdescripcion().trim());
	}
	
	public static void quitarEspaciosAnalisisTransaClientes(List<AnalisisTransaCliente> analisistransaclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AnalisisTransaCliente analisistransacliente: analisistransaclientes) {
			analisistransacliente.setnombre(analisistransacliente.getnombre().trim());
			analisistransacliente.setdescripcion(analisistransacliente.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAnalisisTransaCliente(AnalisisTransaCliente analisistransacliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && analisistransacliente.getConCambioAuxiliar()) {
			analisistransacliente.setIsDeleted(analisistransacliente.getIsDeletedAuxiliar());	
			analisistransacliente.setIsNew(analisistransacliente.getIsNewAuxiliar());	
			analisistransacliente.setIsChanged(analisistransacliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			analisistransacliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			analisistransacliente.setIsDeletedAuxiliar(false);	
			analisistransacliente.setIsNewAuxiliar(false);	
			analisistransacliente.setIsChangedAuxiliar(false);
			
			analisistransacliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAnalisisTransaClientes(List<AnalisisTransaCliente> analisistransaclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AnalisisTransaCliente analisistransacliente : analisistransaclientes) {
			if(conAsignarBase && analisistransacliente.getConCambioAuxiliar()) {
				analisistransacliente.setIsDeleted(analisistransacliente.getIsDeletedAuxiliar());	
				analisistransacliente.setIsNew(analisistransacliente.getIsNewAuxiliar());	
				analisistransacliente.setIsChanged(analisistransacliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				analisistransacliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				analisistransacliente.setIsDeletedAuxiliar(false);	
				analisistransacliente.setIsNewAuxiliar(false);	
				analisistransacliente.setIsChangedAuxiliar(false);
				
				analisistransacliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAnalisisTransaCliente(AnalisisTransaCliente analisistransacliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresAnalisisTransaClientes(List<AnalisisTransaCliente> analisistransaclientes,Boolean conEnteros) throws Exception  {
		
		for(AnalisisTransaCliente analisistransacliente: analisistransaclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaAnalisisTransaCliente(List<AnalisisTransaCliente> analisistransaclientes,AnalisisTransaCliente analisistransaclienteAux) throws Exception  {
		AnalisisTransaClienteConstantesFunciones.InicializarValoresAnalisisTransaCliente(analisistransaclienteAux,true);
		
		for(AnalisisTransaCliente analisistransacliente: analisistransaclientes) {
			if(analisistransacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAnalisisTransaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AnalisisTransaClienteConstantesFunciones.getArrayColumnasGlobalesAnalisisTransaCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAnalisisTransaCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AnalisisTransaClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AnalisisTransaClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AnalisisTransaClienteConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AnalisisTransaClienteConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAnalisisTransaCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AnalisisTransaCliente> analisistransaclientes,AnalisisTransaCliente analisistransacliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AnalisisTransaCliente analisistransaclienteAux: analisistransaclientes) {
			if(analisistransaclienteAux!=null && analisistransacliente!=null) {
				if((analisistransaclienteAux.getId()==null && analisistransacliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(analisistransaclienteAux.getId()!=null && analisistransacliente.getId()!=null){
					if(analisistransaclienteAux.getId().equals(analisistransacliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAnalisisTransaCliente(List<AnalisisTransaCliente> analisistransaclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AnalisisTransaCliente analisistransacliente: analisistransaclientes) {			
			if(analisistransacliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAnalisisTransaCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_ID, AnalisisTransaClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_VERSIONROW, AnalisisTransaClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDEMPRESA, AnalisisTransaClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDMODULO, AnalisisTransaClienteConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_NOMBRE, AnalisisTransaClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_DESCRIPCION, AnalisisTransaClienteConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION1, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION2, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION3, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION4, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION5, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION6, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION7, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION8, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION9, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION10, AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAnalisisTransaCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnalisisTransaCliente() throws Exception  {
		return AnalisisTransaClienteConstantesFunciones.getTiposSeleccionarAnalisisTransaCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnalisisTransaCliente(Boolean conFk) throws Exception  {
		return AnalisisTransaClienteConstantesFunciones.getTiposSeleccionarAnalisisTransaCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAnalisisTransaCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION1);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION2);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION3);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION4);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION5);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION6);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION6);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION7);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION7);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION8);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION8);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION9);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION9);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION10);
			reporte.setsDescripcion(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION10);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAnalisisTransaCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAnalisisTransaCliente(AnalisisTransaCliente analisistransaclienteAux) throws Exception {
		
			analisistransaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(analisistransaclienteAux.getEmpresa()));
			analisistransaclienteAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(analisistransaclienteAux.getModulo()));
			analisistransaclienteAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion()));
			analisistransaclienteAux.settransaccion1_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion1()));
			analisistransaclienteAux.settransaccion2_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion2()));
			analisistransaclienteAux.settransaccion3_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion3()));
			analisistransaclienteAux.settransaccion4_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion4()));
			analisistransaclienteAux.settransaccion5_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion5()));
			analisistransaclienteAux.settransaccion6_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion6()));
			analisistransaclienteAux.settransaccion7_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion7()));
			analisistransaclienteAux.settransaccion8_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion8()));
			analisistransaclienteAux.settransaccion9_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion9()));
			analisistransaclienteAux.settransaccion10_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion10()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAnalisisTransaCliente(List<AnalisisTransaCliente> analisistransaclientesTemp) throws Exception {
		for(AnalisisTransaCliente analisistransaclienteAux:analisistransaclientesTemp) {
			
			analisistransaclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(analisistransaclienteAux.getEmpresa()));
			analisistransaclienteAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(analisistransaclienteAux.getModulo()));
			analisistransaclienteAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion()));
			analisistransaclienteAux.settransaccion1_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion1()));
			analisistransaclienteAux.settransaccion2_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion2()));
			analisistransaclienteAux.settransaccion3_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion3()));
			analisistransaclienteAux.settransaccion4_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion4()));
			analisistransaclienteAux.settransaccion5_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion5()));
			analisistransaclienteAux.settransaccion6_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion6()));
			analisistransaclienteAux.settransaccion7_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion7()));
			analisistransaclienteAux.settransaccion8_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion8()));
			analisistransaclienteAux.settransaccion9_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion9()));
			analisistransaclienteAux.settransaccion10_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(analisistransaclienteAux.getTransaccion10()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAnalisisTransaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Transaccion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAnalisisTransaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnalisisTransaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AnalisisTransaClienteConstantesFunciones.getClassesRelationshipsOfAnalisisTransaCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnalisisTransaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAnalisisTransaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AnalisisTransaClienteConstantesFunciones.getClassesRelationshipsFromStringsOfAnalisisTransaCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAnalisisTransaCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AnalisisTransaCliente analisistransacliente,List<AnalisisTransaCliente> analisistransaclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			AnalisisTransaCliente analisistransaclienteEncontrado=null;
			
			for(AnalisisTransaCliente analisistransaclienteLocal:analisistransaclientes) {
				if(analisistransaclienteLocal.getId().equals(analisistransacliente.getId())) {
					analisistransaclienteEncontrado=analisistransaclienteLocal;
					
					analisistransaclienteLocal.setIsChanged(analisistransacliente.getIsChanged());
					analisistransaclienteLocal.setIsNew(analisistransacliente.getIsNew());
					analisistransaclienteLocal.setIsDeleted(analisistransacliente.getIsDeleted());
					
					analisistransaclienteLocal.setGeneralEntityOriginal(analisistransacliente.getGeneralEntityOriginal());
					
					analisistransaclienteLocal.setId(analisistransacliente.getId());	
					analisistransaclienteLocal.setVersionRow(analisistransacliente.getVersionRow());	
					analisistransaclienteLocal.setid_empresa(analisistransacliente.getid_empresa());	
					analisistransaclienteLocal.setid_modulo(analisistransacliente.getid_modulo());	
					analisistransaclienteLocal.setnombre(analisistransacliente.getnombre());	
					analisistransaclienteLocal.setdescripcion(analisistransacliente.getdescripcion());	
					analisistransaclienteLocal.setid_transaccion(analisistransacliente.getid_transaccion());	
					analisistransaclienteLocal.setid_transaccion1(analisistransacliente.getid_transaccion1());	
					analisistransaclienteLocal.setid_transaccion2(analisistransacliente.getid_transaccion2());	
					analisistransaclienteLocal.setid_transaccion3(analisistransacliente.getid_transaccion3());	
					analisistransaclienteLocal.setid_transaccion4(analisistransacliente.getid_transaccion4());	
					analisistransaclienteLocal.setid_transaccion5(analisistransacliente.getid_transaccion5());	
					analisistransaclienteLocal.setid_transaccion6(analisistransacliente.getid_transaccion6());	
					analisistransaclienteLocal.setid_transaccion7(analisistransacliente.getid_transaccion7());	
					analisistransaclienteLocal.setid_transaccion8(analisistransacliente.getid_transaccion8());	
					analisistransaclienteLocal.setid_transaccion9(analisistransacliente.getid_transaccion9());	
					analisistransaclienteLocal.setid_transaccion10(analisistransacliente.getid_transaccion10());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!analisistransacliente.getIsDeleted()) {
				if(!existe) {
					analisistransaclientes.add(analisistransacliente);
				}
			} else {
				if(analisistransaclienteEncontrado!=null && permiteQuitar)  {
					analisistransaclientes.remove(analisistransaclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(AnalisisTransaCliente analisistransacliente,List<AnalisisTransaCliente> analisistransaclientes) throws Exception {
		try	{			
			for(AnalisisTransaCliente analisistransaclienteLocal:analisistransaclientes) {
				if(analisistransaclienteLocal.getId().equals(analisistransacliente.getId())) {
					analisistransaclienteLocal.setIsSelected(analisistransacliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAnalisisTransaCliente(List<AnalisisTransaCliente> analisistransaclientesAux) throws Exception {
		//this.analisistransaclientesAux=analisistransaclientesAux;
		
		for(AnalisisTransaCliente analisistransaclienteAux:analisistransaclientesAux) {
			if(analisistransaclienteAux.getIsChanged()) {
				analisistransaclienteAux.setIsChanged(false);
			}		
			
			if(analisistransaclienteAux.getIsNew()) {
				analisistransaclienteAux.setIsNew(false);
			}	
			
			if(analisistransaclienteAux.getIsDeleted()) {
				analisistransaclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAnalisisTransaCliente(AnalisisTransaCliente analisistransaclienteAux) throws Exception {
		//this.analisistransaclienteAux=analisistransaclienteAux;
		
			if(analisistransaclienteAux.getIsChanged()) {
				analisistransaclienteAux.setIsChanged(false);
			}		
			
			if(analisistransaclienteAux.getIsNew()) {
				analisistransaclienteAux.setIsNew(false);
			}	
			
			if(analisistransaclienteAux.getIsDeleted()) {
				analisistransaclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AnalisisTransaCliente analisistransaclienteAsignar,AnalisisTransaCliente analisistransacliente) throws Exception {
		analisistransaclienteAsignar.setId(analisistransacliente.getId());	
		analisistransaclienteAsignar.setVersionRow(analisistransacliente.getVersionRow());	
		analisistransaclienteAsignar.setid_empresa(analisistransacliente.getid_empresa());
		analisistransaclienteAsignar.setempresa_descripcion(analisistransacliente.getempresa_descripcion());	
		analisistransaclienteAsignar.setid_modulo(analisistransacliente.getid_modulo());
		analisistransaclienteAsignar.setmodulo_descripcion(analisistransacliente.getmodulo_descripcion());	
		analisistransaclienteAsignar.setnombre(analisistransacliente.getnombre());	
		analisistransaclienteAsignar.setdescripcion(analisistransacliente.getdescripcion());	
		analisistransaclienteAsignar.setid_transaccion(analisistransacliente.getid_transaccion());
		analisistransaclienteAsignar.settransaccion_descripcion(analisistransacliente.gettransaccion_descripcion());	
		analisistransaclienteAsignar.setid_transaccion1(analisistransacliente.getid_transaccion1());
		analisistransaclienteAsignar.settransaccion1_descripcion(analisistransacliente.gettransaccion1_descripcion());	
		analisistransaclienteAsignar.setid_transaccion2(analisistransacliente.getid_transaccion2());
		analisistransaclienteAsignar.settransaccion2_descripcion(analisistransacliente.gettransaccion2_descripcion());	
		analisistransaclienteAsignar.setid_transaccion3(analisistransacliente.getid_transaccion3());
		analisistransaclienteAsignar.settransaccion3_descripcion(analisistransacliente.gettransaccion3_descripcion());	
		analisistransaclienteAsignar.setid_transaccion4(analisistransacliente.getid_transaccion4());
		analisistransaclienteAsignar.settransaccion4_descripcion(analisistransacliente.gettransaccion4_descripcion());	
		analisistransaclienteAsignar.setid_transaccion5(analisistransacliente.getid_transaccion5());
		analisistransaclienteAsignar.settransaccion5_descripcion(analisistransacliente.gettransaccion5_descripcion());	
		analisistransaclienteAsignar.setid_transaccion6(analisistransacliente.getid_transaccion6());
		analisistransaclienteAsignar.settransaccion6_descripcion(analisistransacliente.gettransaccion6_descripcion());	
		analisistransaclienteAsignar.setid_transaccion7(analisistransacliente.getid_transaccion7());
		analisistransaclienteAsignar.settransaccion7_descripcion(analisistransacliente.gettransaccion7_descripcion());	
		analisistransaclienteAsignar.setid_transaccion8(analisistransacliente.getid_transaccion8());
		analisistransaclienteAsignar.settransaccion8_descripcion(analisistransacliente.gettransaccion8_descripcion());	
		analisistransaclienteAsignar.setid_transaccion9(analisistransacliente.getid_transaccion9());
		analisistransaclienteAsignar.settransaccion9_descripcion(analisistransacliente.gettransaccion9_descripcion());	
		analisistransaclienteAsignar.setid_transaccion10(analisistransacliente.getid_transaccion10());
		analisistransaclienteAsignar.settransaccion10_descripcion(analisistransacliente.gettransaccion10_descripcion());	
	}
	
	public static void inicializarAnalisisTransaCliente(AnalisisTransaCliente analisistransacliente) throws Exception {
		try {
				analisistransacliente.setId(0L);	
					
				analisistransacliente.setid_empresa(-1L);	
				analisistransacliente.setid_modulo(-1L);	
				analisistransacliente.setnombre("");	
				analisistransacliente.setdescripcion("");	
				analisistransacliente.setid_transaccion(-1L);	
				analisistransacliente.setid_transaccion1(null);	
				analisistransacliente.setid_transaccion2(null);	
				analisistransacliente.setid_transaccion3(null);	
				analisistransacliente.setid_transaccion4(null);	
				analisistransacliente.setid_transaccion5(null);	
				analisistransacliente.setid_transaccion6(null);	
				analisistransacliente.setid_transaccion7(null);	
				analisistransacliente.setid_transaccion8(null);	
				analisistransacliente.setid_transaccion9(null);	
				analisistransacliente.setid_transaccion10(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAnalisisTransaCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION5);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION6);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION7);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION8);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION9);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AnalisisTransaClienteConstantesFunciones.LABEL_IDTRANSACCION10);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAnalisisTransaCliente(String sTipo,Row row,Workbook workbook,AnalisisTransaCliente analisistransacliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion3_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion4_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion5_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion6_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion7_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion8_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion9_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(analisistransacliente.gettransaccion10_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAnalisisTransaCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryAnalisisTransaCliente() {
		return this.sFinalQueryAnalisisTransaCliente;
	}
	
	public void setsFinalQueryAnalisisTransaCliente(String sFinalQueryAnalisisTransaCliente) {
		this.sFinalQueryAnalisisTransaCliente= sFinalQueryAnalisisTransaCliente;
	}
	
	public Border resaltarSeleccionarAnalisisTransaCliente=null;
	
	public Border setResaltarSeleccionarAnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAnalisisTransaCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAnalisisTransaCliente() {
		return this.resaltarSeleccionarAnalisisTransaCliente;
	}
	
	public void setResaltarSeleccionarAnalisisTransaCliente(Border borderResaltarSeleccionarAnalisisTransaCliente) {
		this.resaltarSeleccionarAnalisisTransaCliente= borderResaltarSeleccionarAnalisisTransaCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAnalisisTransaCliente=null;
	public Boolean mostraridAnalisisTransaCliente=true;
	public Boolean activaridAnalisisTransaCliente=true;

	public Border resaltarid_empresaAnalisisTransaCliente=null;
	public Boolean mostrarid_empresaAnalisisTransaCliente=true;
	public Boolean activarid_empresaAnalisisTransaCliente=true;
	public Boolean cargarid_empresaAnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_moduloAnalisisTransaCliente=null;
	public Boolean mostrarid_moduloAnalisisTransaCliente=true;
	public Boolean activarid_moduloAnalisisTransaCliente=true;
	public Boolean cargarid_moduloAnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloAnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarnombreAnalisisTransaCliente=null;
	public Boolean mostrarnombreAnalisisTransaCliente=true;
	public Boolean activarnombreAnalisisTransaCliente=true;

	public Border resaltardescripcionAnalisisTransaCliente=null;
	public Boolean mostrardescripcionAnalisisTransaCliente=true;
	public Boolean activardescripcionAnalisisTransaCliente=true;

	public Border resaltarid_transaccionAnalisisTransaCliente=null;
	public Boolean mostrarid_transaccionAnalisisTransaCliente=true;
	public Boolean activarid_transaccionAnalisisTransaCliente=true;
	public Boolean cargarid_transaccionAnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionAnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion1AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion1AnalisisTransaCliente=true;
	public Boolean activarid_transaccion1AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion1AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion1AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion2AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion2AnalisisTransaCliente=true;
	public Boolean activarid_transaccion2AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion2AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion2AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion3AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion3AnalisisTransaCliente=true;
	public Boolean activarid_transaccion3AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion3AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion3AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion4AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion4AnalisisTransaCliente=true;
	public Boolean activarid_transaccion4AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion4AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion4AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion5AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion5AnalisisTransaCliente=true;
	public Boolean activarid_transaccion5AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion5AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion5AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion6AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion6AnalisisTransaCliente=true;
	public Boolean activarid_transaccion6AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion6AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion6AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion7AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion7AnalisisTransaCliente=true;
	public Boolean activarid_transaccion7AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion7AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion7AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion8AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion8AnalisisTransaCliente=true;
	public Boolean activarid_transaccion8AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion8AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion8AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion9AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion9AnalisisTransaCliente=true;
	public Boolean activarid_transaccion9AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion9AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion9AnalisisTransaCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion10AnalisisTransaCliente=null;
	public Boolean mostrarid_transaccion10AnalisisTransaCliente=true;
	public Boolean activarid_transaccion10AnalisisTransaCliente=true;
	public Boolean cargarid_transaccion10AnalisisTransaCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion10AnalisisTransaCliente=false;//ConEventDepend=true

	
	

	public Border setResaltaridAnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltaridAnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAnalisisTransaCliente() {
		return this.resaltaridAnalisisTransaCliente;
	}

	public void setResaltaridAnalisisTransaCliente(Border borderResaltar) {
		this.resaltaridAnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostraridAnalisisTransaCliente() {
		return this.mostraridAnalisisTransaCliente;
	}

	public void setMostraridAnalisisTransaCliente(Boolean mostraridAnalisisTransaCliente) {
		this.mostraridAnalisisTransaCliente= mostraridAnalisisTransaCliente;
	}

	public Boolean getActivaridAnalisisTransaCliente() {
		return this.activaridAnalisisTransaCliente;
	}

	public void setActivaridAnalisisTransaCliente(Boolean activaridAnalisisTransaCliente) {
		this.activaridAnalisisTransaCliente= activaridAnalisisTransaCliente;
	}

	public Border setResaltarid_empresaAnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaAnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAnalisisTransaCliente() {
		return this.resaltarid_empresaAnalisisTransaCliente;
	}

	public void setResaltarid_empresaAnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_empresaAnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaAnalisisTransaCliente() {
		return this.mostrarid_empresaAnalisisTransaCliente;
	}

	public void setMostrarid_empresaAnalisisTransaCliente(Boolean mostrarid_empresaAnalisisTransaCliente) {
		this.mostrarid_empresaAnalisisTransaCliente= mostrarid_empresaAnalisisTransaCliente;
	}

	public Boolean getActivarid_empresaAnalisisTransaCliente() {
		return this.activarid_empresaAnalisisTransaCliente;
	}

	public void setActivarid_empresaAnalisisTransaCliente(Boolean activarid_empresaAnalisisTransaCliente) {
		this.activarid_empresaAnalisisTransaCliente= activarid_empresaAnalisisTransaCliente;
	}

	public Boolean getCargarid_empresaAnalisisTransaCliente() {
		return this.cargarid_empresaAnalisisTransaCliente;
	}

	public void setCargarid_empresaAnalisisTransaCliente(Boolean cargarid_empresaAnalisisTransaCliente) {
		this.cargarid_empresaAnalisisTransaCliente= cargarid_empresaAnalisisTransaCliente;
	}

	public Border setResaltarid_moduloAnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_moduloAnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloAnalisisTransaCliente() {
		return this.resaltarid_moduloAnalisisTransaCliente;
	}

	public void setResaltarid_moduloAnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_moduloAnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_moduloAnalisisTransaCliente() {
		return this.mostrarid_moduloAnalisisTransaCliente;
	}

	public void setMostrarid_moduloAnalisisTransaCliente(Boolean mostrarid_moduloAnalisisTransaCliente) {
		this.mostrarid_moduloAnalisisTransaCliente= mostrarid_moduloAnalisisTransaCliente;
	}

	public Boolean getActivarid_moduloAnalisisTransaCliente() {
		return this.activarid_moduloAnalisisTransaCliente;
	}

	public void setActivarid_moduloAnalisisTransaCliente(Boolean activarid_moduloAnalisisTransaCliente) {
		this.activarid_moduloAnalisisTransaCliente= activarid_moduloAnalisisTransaCliente;
	}

	public Boolean getCargarid_moduloAnalisisTransaCliente() {
		return this.cargarid_moduloAnalisisTransaCliente;
	}

	public void setCargarid_moduloAnalisisTransaCliente(Boolean cargarid_moduloAnalisisTransaCliente) {
		this.cargarid_moduloAnalisisTransaCliente= cargarid_moduloAnalisisTransaCliente;
	}

	public Border setResaltarnombreAnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarnombreAnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreAnalisisTransaCliente() {
		return this.resaltarnombreAnalisisTransaCliente;
	}

	public void setResaltarnombreAnalisisTransaCliente(Border borderResaltar) {
		this.resaltarnombreAnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarnombreAnalisisTransaCliente() {
		return this.mostrarnombreAnalisisTransaCliente;
	}

	public void setMostrarnombreAnalisisTransaCliente(Boolean mostrarnombreAnalisisTransaCliente) {
		this.mostrarnombreAnalisisTransaCliente= mostrarnombreAnalisisTransaCliente;
	}

	public Boolean getActivarnombreAnalisisTransaCliente() {
		return this.activarnombreAnalisisTransaCliente;
	}

	public void setActivarnombreAnalisisTransaCliente(Boolean activarnombreAnalisisTransaCliente) {
		this.activarnombreAnalisisTransaCliente= activarnombreAnalisisTransaCliente;
	}

	public Border setResaltardescripcionAnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltardescripcionAnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionAnalisisTransaCliente() {
		return this.resaltardescripcionAnalisisTransaCliente;
	}

	public void setResaltardescripcionAnalisisTransaCliente(Border borderResaltar) {
		this.resaltardescripcionAnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrardescripcionAnalisisTransaCliente() {
		return this.mostrardescripcionAnalisisTransaCliente;
	}

	public void setMostrardescripcionAnalisisTransaCliente(Boolean mostrardescripcionAnalisisTransaCliente) {
		this.mostrardescripcionAnalisisTransaCliente= mostrardescripcionAnalisisTransaCliente;
	}

	public Boolean getActivardescripcionAnalisisTransaCliente() {
		return this.activardescripcionAnalisisTransaCliente;
	}

	public void setActivardescripcionAnalisisTransaCliente(Boolean activardescripcionAnalisisTransaCliente) {
		this.activardescripcionAnalisisTransaCliente= activardescripcionAnalisisTransaCliente;
	}

	public Border setResaltarid_transaccionAnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccionAnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionAnalisisTransaCliente() {
		return this.resaltarid_transaccionAnalisisTransaCliente;
	}

	public void setResaltarid_transaccionAnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccionAnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccionAnalisisTransaCliente() {
		return this.mostrarid_transaccionAnalisisTransaCliente;
	}

	public void setMostrarid_transaccionAnalisisTransaCliente(Boolean mostrarid_transaccionAnalisisTransaCliente) {
		this.mostrarid_transaccionAnalisisTransaCliente= mostrarid_transaccionAnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccionAnalisisTransaCliente() {
		return this.activarid_transaccionAnalisisTransaCliente;
	}

	public void setActivarid_transaccionAnalisisTransaCliente(Boolean activarid_transaccionAnalisisTransaCliente) {
		this.activarid_transaccionAnalisisTransaCliente= activarid_transaccionAnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccionAnalisisTransaCliente() {
		return this.cargarid_transaccionAnalisisTransaCliente;
	}

	public void setCargarid_transaccionAnalisisTransaCliente(Boolean cargarid_transaccionAnalisisTransaCliente) {
		this.cargarid_transaccionAnalisisTransaCliente= cargarid_transaccionAnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion1AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion1AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion1AnalisisTransaCliente() {
		return this.resaltarid_transaccion1AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion1AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion1AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion1AnalisisTransaCliente() {
		return this.mostrarid_transaccion1AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion1AnalisisTransaCliente(Boolean mostrarid_transaccion1AnalisisTransaCliente) {
		this.mostrarid_transaccion1AnalisisTransaCliente= mostrarid_transaccion1AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion1AnalisisTransaCliente() {
		return this.activarid_transaccion1AnalisisTransaCliente;
	}

	public void setActivarid_transaccion1AnalisisTransaCliente(Boolean activarid_transaccion1AnalisisTransaCliente) {
		this.activarid_transaccion1AnalisisTransaCliente= activarid_transaccion1AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion1AnalisisTransaCliente() {
		return this.cargarid_transaccion1AnalisisTransaCliente;
	}

	public void setCargarid_transaccion1AnalisisTransaCliente(Boolean cargarid_transaccion1AnalisisTransaCliente) {
		this.cargarid_transaccion1AnalisisTransaCliente= cargarid_transaccion1AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion2AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion2AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion2AnalisisTransaCliente() {
		return this.resaltarid_transaccion2AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion2AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion2AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion2AnalisisTransaCliente() {
		return this.mostrarid_transaccion2AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion2AnalisisTransaCliente(Boolean mostrarid_transaccion2AnalisisTransaCliente) {
		this.mostrarid_transaccion2AnalisisTransaCliente= mostrarid_transaccion2AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion2AnalisisTransaCliente() {
		return this.activarid_transaccion2AnalisisTransaCliente;
	}

	public void setActivarid_transaccion2AnalisisTransaCliente(Boolean activarid_transaccion2AnalisisTransaCliente) {
		this.activarid_transaccion2AnalisisTransaCliente= activarid_transaccion2AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion2AnalisisTransaCliente() {
		return this.cargarid_transaccion2AnalisisTransaCliente;
	}

	public void setCargarid_transaccion2AnalisisTransaCliente(Boolean cargarid_transaccion2AnalisisTransaCliente) {
		this.cargarid_transaccion2AnalisisTransaCliente= cargarid_transaccion2AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion3AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion3AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion3AnalisisTransaCliente() {
		return this.resaltarid_transaccion3AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion3AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion3AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion3AnalisisTransaCliente() {
		return this.mostrarid_transaccion3AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion3AnalisisTransaCliente(Boolean mostrarid_transaccion3AnalisisTransaCliente) {
		this.mostrarid_transaccion3AnalisisTransaCliente= mostrarid_transaccion3AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion3AnalisisTransaCliente() {
		return this.activarid_transaccion3AnalisisTransaCliente;
	}

	public void setActivarid_transaccion3AnalisisTransaCliente(Boolean activarid_transaccion3AnalisisTransaCliente) {
		this.activarid_transaccion3AnalisisTransaCliente= activarid_transaccion3AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion3AnalisisTransaCliente() {
		return this.cargarid_transaccion3AnalisisTransaCliente;
	}

	public void setCargarid_transaccion3AnalisisTransaCliente(Boolean cargarid_transaccion3AnalisisTransaCliente) {
		this.cargarid_transaccion3AnalisisTransaCliente= cargarid_transaccion3AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion4AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion4AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion4AnalisisTransaCliente() {
		return this.resaltarid_transaccion4AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion4AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion4AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion4AnalisisTransaCliente() {
		return this.mostrarid_transaccion4AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion4AnalisisTransaCliente(Boolean mostrarid_transaccion4AnalisisTransaCliente) {
		this.mostrarid_transaccion4AnalisisTransaCliente= mostrarid_transaccion4AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion4AnalisisTransaCliente() {
		return this.activarid_transaccion4AnalisisTransaCliente;
	}

	public void setActivarid_transaccion4AnalisisTransaCliente(Boolean activarid_transaccion4AnalisisTransaCliente) {
		this.activarid_transaccion4AnalisisTransaCliente= activarid_transaccion4AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion4AnalisisTransaCliente() {
		return this.cargarid_transaccion4AnalisisTransaCliente;
	}

	public void setCargarid_transaccion4AnalisisTransaCliente(Boolean cargarid_transaccion4AnalisisTransaCliente) {
		this.cargarid_transaccion4AnalisisTransaCliente= cargarid_transaccion4AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion5AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion5AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion5AnalisisTransaCliente() {
		return this.resaltarid_transaccion5AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion5AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion5AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion5AnalisisTransaCliente() {
		return this.mostrarid_transaccion5AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion5AnalisisTransaCliente(Boolean mostrarid_transaccion5AnalisisTransaCliente) {
		this.mostrarid_transaccion5AnalisisTransaCliente= mostrarid_transaccion5AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion5AnalisisTransaCliente() {
		return this.activarid_transaccion5AnalisisTransaCliente;
	}

	public void setActivarid_transaccion5AnalisisTransaCliente(Boolean activarid_transaccion5AnalisisTransaCliente) {
		this.activarid_transaccion5AnalisisTransaCliente= activarid_transaccion5AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion5AnalisisTransaCliente() {
		return this.cargarid_transaccion5AnalisisTransaCliente;
	}

	public void setCargarid_transaccion5AnalisisTransaCliente(Boolean cargarid_transaccion5AnalisisTransaCliente) {
		this.cargarid_transaccion5AnalisisTransaCliente= cargarid_transaccion5AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion6AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion6AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion6AnalisisTransaCliente() {
		return this.resaltarid_transaccion6AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion6AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion6AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion6AnalisisTransaCliente() {
		return this.mostrarid_transaccion6AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion6AnalisisTransaCliente(Boolean mostrarid_transaccion6AnalisisTransaCliente) {
		this.mostrarid_transaccion6AnalisisTransaCliente= mostrarid_transaccion6AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion6AnalisisTransaCliente() {
		return this.activarid_transaccion6AnalisisTransaCliente;
	}

	public void setActivarid_transaccion6AnalisisTransaCliente(Boolean activarid_transaccion6AnalisisTransaCliente) {
		this.activarid_transaccion6AnalisisTransaCliente= activarid_transaccion6AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion6AnalisisTransaCliente() {
		return this.cargarid_transaccion6AnalisisTransaCliente;
	}

	public void setCargarid_transaccion6AnalisisTransaCliente(Boolean cargarid_transaccion6AnalisisTransaCliente) {
		this.cargarid_transaccion6AnalisisTransaCliente= cargarid_transaccion6AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion7AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion7AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion7AnalisisTransaCliente() {
		return this.resaltarid_transaccion7AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion7AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion7AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion7AnalisisTransaCliente() {
		return this.mostrarid_transaccion7AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion7AnalisisTransaCliente(Boolean mostrarid_transaccion7AnalisisTransaCliente) {
		this.mostrarid_transaccion7AnalisisTransaCliente= mostrarid_transaccion7AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion7AnalisisTransaCliente() {
		return this.activarid_transaccion7AnalisisTransaCliente;
	}

	public void setActivarid_transaccion7AnalisisTransaCliente(Boolean activarid_transaccion7AnalisisTransaCliente) {
		this.activarid_transaccion7AnalisisTransaCliente= activarid_transaccion7AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion7AnalisisTransaCliente() {
		return this.cargarid_transaccion7AnalisisTransaCliente;
	}

	public void setCargarid_transaccion7AnalisisTransaCliente(Boolean cargarid_transaccion7AnalisisTransaCliente) {
		this.cargarid_transaccion7AnalisisTransaCliente= cargarid_transaccion7AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion8AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion8AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion8AnalisisTransaCliente() {
		return this.resaltarid_transaccion8AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion8AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion8AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion8AnalisisTransaCliente() {
		return this.mostrarid_transaccion8AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion8AnalisisTransaCliente(Boolean mostrarid_transaccion8AnalisisTransaCliente) {
		this.mostrarid_transaccion8AnalisisTransaCliente= mostrarid_transaccion8AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion8AnalisisTransaCliente() {
		return this.activarid_transaccion8AnalisisTransaCliente;
	}

	public void setActivarid_transaccion8AnalisisTransaCliente(Boolean activarid_transaccion8AnalisisTransaCliente) {
		this.activarid_transaccion8AnalisisTransaCliente= activarid_transaccion8AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion8AnalisisTransaCliente() {
		return this.cargarid_transaccion8AnalisisTransaCliente;
	}

	public void setCargarid_transaccion8AnalisisTransaCliente(Boolean cargarid_transaccion8AnalisisTransaCliente) {
		this.cargarid_transaccion8AnalisisTransaCliente= cargarid_transaccion8AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion9AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion9AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion9AnalisisTransaCliente() {
		return this.resaltarid_transaccion9AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion9AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion9AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion9AnalisisTransaCliente() {
		return this.mostrarid_transaccion9AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion9AnalisisTransaCliente(Boolean mostrarid_transaccion9AnalisisTransaCliente) {
		this.mostrarid_transaccion9AnalisisTransaCliente= mostrarid_transaccion9AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion9AnalisisTransaCliente() {
		return this.activarid_transaccion9AnalisisTransaCliente;
	}

	public void setActivarid_transaccion9AnalisisTransaCliente(Boolean activarid_transaccion9AnalisisTransaCliente) {
		this.activarid_transaccion9AnalisisTransaCliente= activarid_transaccion9AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion9AnalisisTransaCliente() {
		return this.cargarid_transaccion9AnalisisTransaCliente;
	}

	public void setCargarid_transaccion9AnalisisTransaCliente(Boolean cargarid_transaccion9AnalisisTransaCliente) {
		this.cargarid_transaccion9AnalisisTransaCliente= cargarid_transaccion9AnalisisTransaCliente;
	}

	public Border setResaltarid_transaccion10AnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//analisistransaclienteBeanSwingJInternalFrame.jTtoolBarAnalisisTransaCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion10AnalisisTransaCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion10AnalisisTransaCliente() {
		return this.resaltarid_transaccion10AnalisisTransaCliente;
	}

	public void setResaltarid_transaccion10AnalisisTransaCliente(Border borderResaltar) {
		this.resaltarid_transaccion10AnalisisTransaCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion10AnalisisTransaCliente() {
		return this.mostrarid_transaccion10AnalisisTransaCliente;
	}

	public void setMostrarid_transaccion10AnalisisTransaCliente(Boolean mostrarid_transaccion10AnalisisTransaCliente) {
		this.mostrarid_transaccion10AnalisisTransaCliente= mostrarid_transaccion10AnalisisTransaCliente;
	}

	public Boolean getActivarid_transaccion10AnalisisTransaCliente() {
		return this.activarid_transaccion10AnalisisTransaCliente;
	}

	public void setActivarid_transaccion10AnalisisTransaCliente(Boolean activarid_transaccion10AnalisisTransaCliente) {
		this.activarid_transaccion10AnalisisTransaCliente= activarid_transaccion10AnalisisTransaCliente;
	}

	public Boolean getCargarid_transaccion10AnalisisTransaCliente() {
		return this.cargarid_transaccion10AnalisisTransaCliente;
	}

	public void setCargarid_transaccion10AnalisisTransaCliente(Boolean cargarid_transaccion10AnalisisTransaCliente) {
		this.cargarid_transaccion10AnalisisTransaCliente= cargarid_transaccion10AnalisisTransaCliente;
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
		
		
		this.setMostraridAnalisisTransaCliente(esInicial);
		this.setMostrarid_empresaAnalisisTransaCliente(esInicial);
		this.setMostrarid_moduloAnalisisTransaCliente(esInicial);
		this.setMostrarnombreAnalisisTransaCliente(esInicial);
		this.setMostrardescripcionAnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccionAnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion1AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion2AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion3AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion4AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion5AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion6AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion7AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion8AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion9AnalisisTransaCliente(esInicial);
		this.setMostrarid_transaccion10AnalisisTransaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.ID)) {
				this.setMostraridAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1)) {
				this.setMostrarid_transaccion1AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2)) {
				this.setMostrarid_transaccion2AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3)) {
				this.setMostrarid_transaccion3AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4)) {
				this.setMostrarid_transaccion4AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5)) {
				this.setMostrarid_transaccion5AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6)) {
				this.setMostrarid_transaccion6AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7)) {
				this.setMostrarid_transaccion7AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8)) {
				this.setMostrarid_transaccion8AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9)) {
				this.setMostrarid_transaccion9AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10)) {
				this.setMostrarid_transaccion10AnalisisTransaCliente(esAsigna);
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
		
		
		this.setActivaridAnalisisTransaCliente(esInicial);
		this.setActivarid_empresaAnalisisTransaCliente(esInicial);
		this.setActivarid_moduloAnalisisTransaCliente(esInicial);
		this.setActivarnombreAnalisisTransaCliente(esInicial);
		this.setActivardescripcionAnalisisTransaCliente(esInicial);
		this.setActivarid_transaccionAnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion1AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion2AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion3AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion4AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion5AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion6AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion7AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion8AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion9AnalisisTransaCliente(esInicial);
		this.setActivarid_transaccion10AnalisisTransaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.ID)) {
				this.setActivaridAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1)) {
				this.setActivarid_transaccion1AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2)) {
				this.setActivarid_transaccion2AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3)) {
				this.setActivarid_transaccion3AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4)) {
				this.setActivarid_transaccion4AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5)) {
				this.setActivarid_transaccion5AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6)) {
				this.setActivarid_transaccion6AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7)) {
				this.setActivarid_transaccion7AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8)) {
				this.setActivarid_transaccion8AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9)) {
				this.setActivarid_transaccion9AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10)) {
				this.setActivarid_transaccion10AnalisisTransaCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAnalisisTransaCliente(esInicial);
		this.setResaltarid_empresaAnalisisTransaCliente(esInicial);
		this.setResaltarid_moduloAnalisisTransaCliente(esInicial);
		this.setResaltarnombreAnalisisTransaCliente(esInicial);
		this.setResaltardescripcionAnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccionAnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion1AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion2AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion3AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion4AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion5AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion6AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion7AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion8AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion9AnalisisTransaCliente(esInicial);
		this.setResaltarid_transaccion10AnalisisTransaCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.ID)) {
				this.setResaltaridAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionAnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1)) {
				this.setResaltarid_transaccion1AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2)) {
				this.setResaltarid_transaccion2AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3)) {
				this.setResaltarid_transaccion3AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4)) {
				this.setResaltarid_transaccion4AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5)) {
				this.setResaltarid_transaccion5AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6)) {
				this.setResaltarid_transaccion6AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7)) {
				this.setResaltarid_transaccion7AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8)) {
				this.setResaltarid_transaccion8AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9)) {
				this.setResaltarid_transaccion9AnalisisTransaCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10)) {
				this.setResaltarid_transaccion10AnalisisTransaCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreAnalisisTransaCliente=true;

	public Boolean getMostrarBusquedaPorNombreAnalisisTransaCliente() {
		return this.mostrarBusquedaPorNombreAnalisisTransaCliente;
	}

	public void setMostrarBusquedaPorNombreAnalisisTransaCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreAnalisisTransaCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreAnalisisTransaCliente=true;

	public Boolean getActivarBusquedaPorNombreAnalisisTransaCliente() {
		return this.activarBusquedaPorNombreAnalisisTransaCliente;
	}

	public void setActivarBusquedaPorNombreAnalisisTransaCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreAnalisisTransaCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreAnalisisTransaCliente=null;

	public Border getResaltarBusquedaPorNombreAnalisisTransaCliente() {
		return this.resaltarBusquedaPorNombreAnalisisTransaCliente;
	}

	public void setResaltarBusquedaPorNombreAnalisisTransaCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreAnalisisTransaCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreAnalisisTransaCliente(ParametroGeneralUsuario parametroGeneralUsuario/*AnalisisTransaClienteBeanSwingJInternalFrame analisistransaclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreAnalisisTransaCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}