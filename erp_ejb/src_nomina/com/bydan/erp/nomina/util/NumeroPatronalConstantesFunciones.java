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


import com.bydan.erp.nomina.util.NumeroPatronalConstantesFunciones;
import com.bydan.erp.nomina.util.NumeroPatronalParameterReturnGeneral;
//import com.bydan.erp.nomina.util.NumeroPatronalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class NumeroPatronalConstantesFunciones extends NumeroPatronalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="NumeroPatronal";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="NumeroPatronal"+NumeroPatronalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="NumeroPatronalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="NumeroPatronalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=NumeroPatronalConstantesFunciones.SCHEMA+"_"+NumeroPatronalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/NumeroPatronalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=NumeroPatronalConstantesFunciones.SCHEMA+"_"+NumeroPatronalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=NumeroPatronalConstantesFunciones.SCHEMA+"_"+NumeroPatronalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/NumeroPatronalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=NumeroPatronalConstantesFunciones.SCHEMA+"_"+NumeroPatronalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NumeroPatronalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NumeroPatronalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NumeroPatronalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NumeroPatronalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/NumeroPatronalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+NumeroPatronalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=NumeroPatronalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+NumeroPatronalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=NumeroPatronalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+NumeroPatronalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Numero Patronales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Numero Patronal";
	public static final String SCLASSWEBTITULO_LOWER="Numero Patronal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="NumeroPatronal";
	public static final String OBJECTNAME="numeropatronal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="numero_patronal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select numeropatronal from "+NumeroPatronalConstantesFunciones.SPERSISTENCENAME+" numeropatronal";
	public static String QUERYSELECTNATIVE="select "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".version_row,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id_empresa,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id_provincia,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id_canton,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".id_parroquia,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".numero,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".codigo_actividad,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".apellido,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".nombre,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".cedula,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".telefono,"+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME+".descripcion from "+NumeroPatronalConstantesFunciones.SCHEMA+"."+NumeroPatronalConstantesFunciones.TABLENAME;//+" as "+NumeroPatronalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected NumeroPatronalConstantesFuncionesAdditional numeropatronalConstantesFuncionesAdditional=null;
	
	public NumeroPatronalConstantesFuncionesAdditional getNumeroPatronalConstantesFuncionesAdditional() {
		return this.numeropatronalConstantesFuncionesAdditional;
	}
	
	public void setNumeroPatronalConstantesFuncionesAdditional(NumeroPatronalConstantesFuncionesAdditional numeropatronalConstantesFuncionesAdditional) {
		try {
			this.numeropatronalConstantesFuncionesAdditional=numeropatronalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPROVINCIA= "id_provincia";
    public static final String IDCANTON= "id_canton";
    public static final String IDPARROQUIA= "id_parroquia";
    public static final String NUMERO= "numero";
    public static final String CODIGOACTIVIDAD= "codigo_actividad";
    public static final String APELLIDO= "apellido";
    public static final String NOMBRE= "nombre";
    public static final String CEDULA= "cedula";
    public static final String TELEFONO= "telefono";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPROVINCIA= "Provincia";
		public static final String LABEL_IDPROVINCIA_LOWER= "Provincia";
    	public static final String LABEL_IDCANTON= "Canton";
		public static final String LABEL_IDCANTON_LOWER= "Canton";
    	public static final String LABEL_IDPARROQUIA= "Parroquia";
		public static final String LABEL_IDPARROQUIA_LOWER= "Parroquia";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_CODIGOACTIVIDAD= "Codigo Actividad Economica";
		public static final String LABEL_CODIGOACTIVIDAD_LOWER= "Codigo Actividad";
    	public static final String LABEL_APELLIDO= "Apellido";
		public static final String LABEL_APELLIDO_LOWER= "Apellido";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CEDULA= "Cedula";
		public static final String LABEL_CEDULA_LOWER= "Cedula";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_ACTIVIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_ACTIVIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXAPELLIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXAPELLIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCEDULA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCEDULA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getNumeroPatronalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.IDEMPRESA)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.IDPROVINCIA)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_IDPROVINCIA;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.IDCANTON)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_IDCANTON;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.IDPARROQUIA)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_IDPARROQUIA;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.NUMERO)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_CODIGOACTIVIDAD;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.APELLIDO)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_APELLIDO;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.NOMBRE)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.CEDULA)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_CEDULA;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.TELEFONO)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(NumeroPatronalConstantesFunciones.DESCRIPCION)) {sLabelColumna=NumeroPatronalConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getNumeroPatronalDescripcion(NumeroPatronal numeropatronal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(numeropatronal !=null/* && numeropatronal.getId()!=0*/) {
			sDescripcion=numeropatronal.getnombre();//numeropatronalnumeropatronal.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getNumeroPatronalDescripcionDetallado(NumeroPatronal numeropatronal) {
		String sDescripcion="";
			
		sDescripcion+=NumeroPatronalConstantesFunciones.ID+"=";
		sDescripcion+=numeropatronal.getId().toString()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=numeropatronal.getVersionRow().toString()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=numeropatronal.getid_empresa().toString()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.IDPROVINCIA+"=";
		sDescripcion+=numeropatronal.getid_provincia().toString()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.IDCANTON+"=";
		sDescripcion+=numeropatronal.getid_canton().toString()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.IDPARROQUIA+"=";
		sDescripcion+=numeropatronal.getid_parroquia().toString()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.NUMERO+"=";
		sDescripcion+=numeropatronal.getnumero()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD+"=";
		sDescripcion+=numeropatronal.getcodigo_actividad()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.APELLIDO+"=";
		sDescripcion+=numeropatronal.getapellido()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.NOMBRE+"=";
		sDescripcion+=numeropatronal.getnombre()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.CEDULA+"=";
		sDescripcion+=numeropatronal.getcedula()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.TELEFONO+"=";
		sDescripcion+=numeropatronal.gettelefono()+",";
		sDescripcion+=NumeroPatronalConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=numeropatronal.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setNumeroPatronalDescripcion(NumeroPatronal numeropatronal,String sValor) throws Exception {			
		if(numeropatronal !=null) {
			numeropatronal.setnombre(sValor);;//numeropatronalnumeropatronal.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCanton")) {
			sNombreIndice="Tipo=  Por Canton";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdParroquia")) {
			sNombreIndice="Tipo=  Por Parroquia";
		} else if(sNombreIndice.equals("FK_IdProvincia")) {
			sNombreIndice="Tipo=  Por Provincia";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCanton(Long id_canton) {
		String sDetalleIndice=" Parametros->";
		if(id_canton!=null) {sDetalleIndice+=" Codigo Unico De Canton="+id_canton.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosNumeroPatronal(NumeroPatronal numeropatronal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		numeropatronal.setnumero(numeropatronal.getnumero().trim());
		numeropatronal.setcodigo_actividad(numeropatronal.getcodigo_actividad().trim());
		numeropatronal.setapellido(numeropatronal.getapellido().trim());
		numeropatronal.setnombre(numeropatronal.getnombre().trim());
		numeropatronal.setcedula(numeropatronal.getcedula().trim());
		numeropatronal.settelefono(numeropatronal.gettelefono().trim());
		numeropatronal.setdescripcion(numeropatronal.getdescripcion().trim());
	}
	
	public static void quitarEspaciosNumeroPatronals(List<NumeroPatronal> numeropatronals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(NumeroPatronal numeropatronal: numeropatronals) {
			numeropatronal.setnumero(numeropatronal.getnumero().trim());
			numeropatronal.setcodigo_actividad(numeropatronal.getcodigo_actividad().trim());
			numeropatronal.setapellido(numeropatronal.getapellido().trim());
			numeropatronal.setnombre(numeropatronal.getnombre().trim());
			numeropatronal.setcedula(numeropatronal.getcedula().trim());
			numeropatronal.settelefono(numeropatronal.gettelefono().trim());
			numeropatronal.setdescripcion(numeropatronal.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNumeroPatronal(NumeroPatronal numeropatronal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && numeropatronal.getConCambioAuxiliar()) {
			numeropatronal.setIsDeleted(numeropatronal.getIsDeletedAuxiliar());	
			numeropatronal.setIsNew(numeropatronal.getIsNewAuxiliar());	
			numeropatronal.setIsChanged(numeropatronal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			numeropatronal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			numeropatronal.setIsDeletedAuxiliar(false);	
			numeropatronal.setIsNewAuxiliar(false);	
			numeropatronal.setIsChangedAuxiliar(false);
			
			numeropatronal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresNumeroPatronals(List<NumeroPatronal> numeropatronals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(NumeroPatronal numeropatronal : numeropatronals) {
			if(conAsignarBase && numeropatronal.getConCambioAuxiliar()) {
				numeropatronal.setIsDeleted(numeropatronal.getIsDeletedAuxiliar());	
				numeropatronal.setIsNew(numeropatronal.getIsNewAuxiliar());	
				numeropatronal.setIsChanged(numeropatronal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				numeropatronal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				numeropatronal.setIsDeletedAuxiliar(false);	
				numeropatronal.setIsNewAuxiliar(false);	
				numeropatronal.setIsChangedAuxiliar(false);
				
				numeropatronal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresNumeroPatronal(NumeroPatronal numeropatronal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresNumeroPatronals(List<NumeroPatronal> numeropatronals,Boolean conEnteros) throws Exception  {
		
		for(NumeroPatronal numeropatronal: numeropatronals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaNumeroPatronal(List<NumeroPatronal> numeropatronals,NumeroPatronal numeropatronalAux) throws Exception  {
		NumeroPatronalConstantesFunciones.InicializarValoresNumeroPatronal(numeropatronalAux,true);
		
		for(NumeroPatronal numeropatronal: numeropatronals) {
			if(numeropatronal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNumeroPatronal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=NumeroPatronalConstantesFunciones.getArrayColumnasGlobalesNumeroPatronal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesNumeroPatronal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(NumeroPatronalConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(NumeroPatronalConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoNumeroPatronal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<NumeroPatronal> numeropatronals,NumeroPatronal numeropatronal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(NumeroPatronal numeropatronalAux: numeropatronals) {
			if(numeropatronalAux!=null && numeropatronal!=null) {
				if((numeropatronalAux.getId()==null && numeropatronal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(numeropatronalAux.getId()!=null && numeropatronal.getId()!=null){
					if(numeropatronalAux.getId().equals(numeropatronal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaNumeroPatronal(List<NumeroPatronal> numeropatronals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(NumeroPatronal numeropatronal: numeropatronals) {			
			if(numeropatronal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaNumeroPatronal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_ID, NumeroPatronalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_VERSIONROW, NumeroPatronalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_IDEMPRESA, NumeroPatronalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_IDPROVINCIA, NumeroPatronalConstantesFunciones.IDPROVINCIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_IDCANTON, NumeroPatronalConstantesFunciones.IDCANTON,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_IDPARROQUIA, NumeroPatronalConstantesFunciones.IDPARROQUIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_NUMERO, NumeroPatronalConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_CODIGOACTIVIDAD, NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_APELLIDO, NumeroPatronalConstantesFunciones.APELLIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_NOMBRE, NumeroPatronalConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_CEDULA, NumeroPatronalConstantesFunciones.CEDULA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_TELEFONO, NumeroPatronalConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,NumeroPatronalConstantesFunciones.LABEL_DESCRIPCION, NumeroPatronalConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasNumeroPatronal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.IDPROVINCIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.IDCANTON;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.IDPARROQUIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.APELLIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.CEDULA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=NumeroPatronalConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNumeroPatronal() throws Exception  {
		return NumeroPatronalConstantesFunciones.getTiposSeleccionarNumeroPatronal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNumeroPatronal(Boolean conFk) throws Exception  {
		return NumeroPatronalConstantesFunciones.getTiposSeleccionarNumeroPatronal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarNumeroPatronal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_IDPROVINCIA);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_IDPROVINCIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_IDCANTON);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_IDCANTON);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_IDPARROQUIA);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_IDPARROQUIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_CODIGOACTIVIDAD);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_CODIGOACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_APELLIDO);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_APELLIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_CEDULA);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_CEDULA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(NumeroPatronalConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(NumeroPatronalConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesNumeroPatronal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesNumeroPatronal(NumeroPatronal numeropatronalAux) throws Exception {
		
			numeropatronalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(numeropatronalAux.getEmpresa()));
			numeropatronalAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(numeropatronalAux.getProvincia()));
			numeropatronalAux.setcanton_descripcion(CantonConstantesFunciones.getCantonDescripcion(numeropatronalAux.getCanton()));
			numeropatronalAux.setparroquia_descripcion(ParroquiaConstantesFunciones.getParroquiaDescripcion(numeropatronalAux.getParroquia()));		
	}
	
	public static void refrescarForeignKeysDescripcionesNumeroPatronal(List<NumeroPatronal> numeropatronalsTemp) throws Exception {
		for(NumeroPatronal numeropatronalAux:numeropatronalsTemp) {
			
			numeropatronalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(numeropatronalAux.getEmpresa()));
			numeropatronalAux.setprovincia_descripcion(ProvinciaConstantesFunciones.getProvinciaDescripcion(numeropatronalAux.getProvincia()));
			numeropatronalAux.setcanton_descripcion(CantonConstantesFunciones.getCantonDescripcion(numeropatronalAux.getCanton()));
			numeropatronalAux.setparroquia_descripcion(ParroquiaConstantesFunciones.getParroquiaDescripcion(numeropatronalAux.getParroquia()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfNumeroPatronal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Provincia.class));
				classes.add(new Classe(Canton.class));
				classes.add(new Classe(Parroquia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfNumeroPatronal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNumeroPatronal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return NumeroPatronalConstantesFunciones.getClassesRelationshipsOfNumeroPatronal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNumeroPatronal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DatoGeneralEmpleado.class));
				classes.add(new Classe(Estructura.class));
				classes.add(new Classe(Cargo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Estructura.class)) {
						classes.add(new Classe(Estructura.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cargo.class)) {
						classes.add(new Classe(Cargo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNumeroPatronal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return NumeroPatronalConstantesFunciones.getClassesRelationshipsFromStringsOfNumeroPatronal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfNumeroPatronal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}

					if(Estructura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Estructura.class)); continue;
					}

					if(Cargo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cargo.class)); continue;
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
	public static void actualizarLista(NumeroPatronal numeropatronal,List<NumeroPatronal> numeropatronals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			NumeroPatronal numeropatronalEncontrado=null;
			
			for(NumeroPatronal numeropatronalLocal:numeropatronals) {
				if(numeropatronalLocal.getId().equals(numeropatronal.getId())) {
					numeropatronalEncontrado=numeropatronalLocal;
					
					numeropatronalLocal.setIsChanged(numeropatronal.getIsChanged());
					numeropatronalLocal.setIsNew(numeropatronal.getIsNew());
					numeropatronalLocal.setIsDeleted(numeropatronal.getIsDeleted());
					
					numeropatronalLocal.setGeneralEntityOriginal(numeropatronal.getGeneralEntityOriginal());
					
					numeropatronalLocal.setId(numeropatronal.getId());	
					numeropatronalLocal.setVersionRow(numeropatronal.getVersionRow());	
					numeropatronalLocal.setid_empresa(numeropatronal.getid_empresa());	
					numeropatronalLocal.setid_provincia(numeropatronal.getid_provincia());	
					numeropatronalLocal.setid_canton(numeropatronal.getid_canton());	
					numeropatronalLocal.setid_parroquia(numeropatronal.getid_parroquia());	
					numeropatronalLocal.setnumero(numeropatronal.getnumero());	
					numeropatronalLocal.setcodigo_actividad(numeropatronal.getcodigo_actividad());	
					numeropatronalLocal.setapellido(numeropatronal.getapellido());	
					numeropatronalLocal.setnombre(numeropatronal.getnombre());	
					numeropatronalLocal.setcedula(numeropatronal.getcedula());	
					numeropatronalLocal.settelefono(numeropatronal.gettelefono());	
					numeropatronalLocal.setdescripcion(numeropatronal.getdescripcion());	
					
					
					numeropatronalLocal.setDatoGeneralEmpleados(numeropatronal.getDatoGeneralEmpleados());
					numeropatronalLocal.setEstructuras(numeropatronal.getEstructuras());
					numeropatronalLocal.setCargos(numeropatronal.getCargos());
					
					existe=true;
					break;
				}
			}
			
			if(!numeropatronal.getIsDeleted()) {
				if(!existe) {
					numeropatronals.add(numeropatronal);
				}
			} else {
				if(numeropatronalEncontrado!=null && permiteQuitar)  {
					numeropatronals.remove(numeropatronalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(NumeroPatronal numeropatronal,List<NumeroPatronal> numeropatronals) throws Exception {
		try	{			
			for(NumeroPatronal numeropatronalLocal:numeropatronals) {
				if(numeropatronalLocal.getId().equals(numeropatronal.getId())) {
					numeropatronalLocal.setIsSelected(numeropatronal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesNumeroPatronal(List<NumeroPatronal> numeropatronalsAux) throws Exception {
		//this.numeropatronalsAux=numeropatronalsAux;
		
		for(NumeroPatronal numeropatronalAux:numeropatronalsAux) {
			if(numeropatronalAux.getIsChanged()) {
				numeropatronalAux.setIsChanged(false);
			}		
			
			if(numeropatronalAux.getIsNew()) {
				numeropatronalAux.setIsNew(false);
			}	
			
			if(numeropatronalAux.getIsDeleted()) {
				numeropatronalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesNumeroPatronal(NumeroPatronal numeropatronalAux) throws Exception {
		//this.numeropatronalAux=numeropatronalAux;
		
			if(numeropatronalAux.getIsChanged()) {
				numeropatronalAux.setIsChanged(false);
			}		
			
			if(numeropatronalAux.getIsNew()) {
				numeropatronalAux.setIsNew(false);
			}	
			
			if(numeropatronalAux.getIsDeleted()) {
				numeropatronalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(NumeroPatronal numeropatronalAsignar,NumeroPatronal numeropatronal) throws Exception {
		numeropatronalAsignar.setId(numeropatronal.getId());	
		numeropatronalAsignar.setVersionRow(numeropatronal.getVersionRow());	
		numeropatronalAsignar.setid_empresa(numeropatronal.getid_empresa());
		numeropatronalAsignar.setempresa_descripcion(numeropatronal.getempresa_descripcion());	
		numeropatronalAsignar.setid_provincia(numeropatronal.getid_provincia());
		numeropatronalAsignar.setprovincia_descripcion(numeropatronal.getprovincia_descripcion());	
		numeropatronalAsignar.setid_canton(numeropatronal.getid_canton());
		numeropatronalAsignar.setcanton_descripcion(numeropatronal.getcanton_descripcion());	
		numeropatronalAsignar.setid_parroquia(numeropatronal.getid_parroquia());
		numeropatronalAsignar.setparroquia_descripcion(numeropatronal.getparroquia_descripcion());	
		numeropatronalAsignar.setnumero(numeropatronal.getnumero());	
		numeropatronalAsignar.setcodigo_actividad(numeropatronal.getcodigo_actividad());	
		numeropatronalAsignar.setapellido(numeropatronal.getapellido());	
		numeropatronalAsignar.setnombre(numeropatronal.getnombre());	
		numeropatronalAsignar.setcedula(numeropatronal.getcedula());	
		numeropatronalAsignar.settelefono(numeropatronal.gettelefono());	
		numeropatronalAsignar.setdescripcion(numeropatronal.getdescripcion());	
	}
	
	public static void inicializarNumeroPatronal(NumeroPatronal numeropatronal) throws Exception {
		try {
				numeropatronal.setId(0L);	
					
				numeropatronal.setid_empresa(-1L);	
				numeropatronal.setid_provincia(-1L);	
				numeropatronal.setid_canton(-1L);	
				numeropatronal.setid_parroquia(-1L);	
				numeropatronal.setnumero("");	
				numeropatronal.setcodigo_actividad("");	
				numeropatronal.setapellido("");	
				numeropatronal.setnombre("");	
				numeropatronal.setcedula("");	
				numeropatronal.settelefono("");	
				numeropatronal.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderNumeroPatronal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_IDPROVINCIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_IDCANTON);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_IDPARROQUIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_CODIGOACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_APELLIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_CEDULA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(NumeroPatronalConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataNumeroPatronal(String sTipo,Row row,Workbook workbook,NumeroPatronal numeropatronal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getprovincia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getcanton_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getparroquia_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getcodigo_actividad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getapellido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getcedula());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(numeropatronal.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryNumeroPatronal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryNumeroPatronal() {
		return this.sFinalQueryNumeroPatronal;
	}
	
	public void setsFinalQueryNumeroPatronal(String sFinalQueryNumeroPatronal) {
		this.sFinalQueryNumeroPatronal= sFinalQueryNumeroPatronal;
	}
	
	public Border resaltarSeleccionarNumeroPatronal=null;
	
	public Border setResaltarSeleccionarNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarNumeroPatronal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarNumeroPatronal() {
		return this.resaltarSeleccionarNumeroPatronal;
	}
	
	public void setResaltarSeleccionarNumeroPatronal(Border borderResaltarSeleccionarNumeroPatronal) {
		this.resaltarSeleccionarNumeroPatronal= borderResaltarSeleccionarNumeroPatronal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridNumeroPatronal=null;
	public Boolean mostraridNumeroPatronal=true;
	public Boolean activaridNumeroPatronal=true;

	public Border resaltarid_empresaNumeroPatronal=null;
	public Boolean mostrarid_empresaNumeroPatronal=true;
	public Boolean activarid_empresaNumeroPatronal=true;
	public Boolean cargarid_empresaNumeroPatronal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaNumeroPatronal=false;//ConEventDepend=true

	public Border resaltarid_provinciaNumeroPatronal=null;
	public Boolean mostrarid_provinciaNumeroPatronal=true;
	public Boolean activarid_provinciaNumeroPatronal=true;
	public Boolean cargarid_provinciaNumeroPatronal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_provinciaNumeroPatronal=false;//ConEventDepend=true

	public Border resaltarid_cantonNumeroPatronal=null;
	public Boolean mostrarid_cantonNumeroPatronal=true;
	public Boolean activarid_cantonNumeroPatronal=true;
	public Boolean cargarid_cantonNumeroPatronal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cantonNumeroPatronal=false;//ConEventDepend=true

	public Border resaltarid_parroquiaNumeroPatronal=null;
	public Boolean mostrarid_parroquiaNumeroPatronal=true;
	public Boolean activarid_parroquiaNumeroPatronal=true;
	public Boolean cargarid_parroquiaNumeroPatronal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_parroquiaNumeroPatronal=false;//ConEventDepend=true

	public Border resaltarnumeroNumeroPatronal=null;
	public Boolean mostrarnumeroNumeroPatronal=true;
	public Boolean activarnumeroNumeroPatronal=true;

	public Border resaltarcodigo_actividadNumeroPatronal=null;
	public Boolean mostrarcodigo_actividadNumeroPatronal=true;
	public Boolean activarcodigo_actividadNumeroPatronal=true;

	public Border resaltarapellidoNumeroPatronal=null;
	public Boolean mostrarapellidoNumeroPatronal=true;
	public Boolean activarapellidoNumeroPatronal=true;

	public Border resaltarnombreNumeroPatronal=null;
	public Boolean mostrarnombreNumeroPatronal=true;
	public Boolean activarnombreNumeroPatronal=true;

	public Border resaltarcedulaNumeroPatronal=null;
	public Boolean mostrarcedulaNumeroPatronal=true;
	public Boolean activarcedulaNumeroPatronal=true;

	public Border resaltartelefonoNumeroPatronal=null;
	public Boolean mostrartelefonoNumeroPatronal=true;
	public Boolean activartelefonoNumeroPatronal=true;

	public Border resaltardescripcionNumeroPatronal=null;
	public Boolean mostrardescripcionNumeroPatronal=true;
	public Boolean activardescripcionNumeroPatronal=true;

	
	

	public Border setResaltaridNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltaridNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridNumeroPatronal() {
		return this.resaltaridNumeroPatronal;
	}

	public void setResaltaridNumeroPatronal(Border borderResaltar) {
		this.resaltaridNumeroPatronal= borderResaltar;
	}

	public Boolean getMostraridNumeroPatronal() {
		return this.mostraridNumeroPatronal;
	}

	public void setMostraridNumeroPatronal(Boolean mostraridNumeroPatronal) {
		this.mostraridNumeroPatronal= mostraridNumeroPatronal;
	}

	public Boolean getActivaridNumeroPatronal() {
		return this.activaridNumeroPatronal;
	}

	public void setActivaridNumeroPatronal(Boolean activaridNumeroPatronal) {
		this.activaridNumeroPatronal= activaridNumeroPatronal;
	}

	public Border setResaltarid_empresaNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarid_empresaNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaNumeroPatronal() {
		return this.resaltarid_empresaNumeroPatronal;
	}

	public void setResaltarid_empresaNumeroPatronal(Border borderResaltar) {
		this.resaltarid_empresaNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarid_empresaNumeroPatronal() {
		return this.mostrarid_empresaNumeroPatronal;
	}

	public void setMostrarid_empresaNumeroPatronal(Boolean mostrarid_empresaNumeroPatronal) {
		this.mostrarid_empresaNumeroPatronal= mostrarid_empresaNumeroPatronal;
	}

	public Boolean getActivarid_empresaNumeroPatronal() {
		return this.activarid_empresaNumeroPatronal;
	}

	public void setActivarid_empresaNumeroPatronal(Boolean activarid_empresaNumeroPatronal) {
		this.activarid_empresaNumeroPatronal= activarid_empresaNumeroPatronal;
	}

	public Boolean getCargarid_empresaNumeroPatronal() {
		return this.cargarid_empresaNumeroPatronal;
	}

	public void setCargarid_empresaNumeroPatronal(Boolean cargarid_empresaNumeroPatronal) {
		this.cargarid_empresaNumeroPatronal= cargarid_empresaNumeroPatronal;
	}

	public Border setResaltarid_provinciaNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarid_provinciaNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_provinciaNumeroPatronal() {
		return this.resaltarid_provinciaNumeroPatronal;
	}

	public void setResaltarid_provinciaNumeroPatronal(Border borderResaltar) {
		this.resaltarid_provinciaNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarid_provinciaNumeroPatronal() {
		return this.mostrarid_provinciaNumeroPatronal;
	}

	public void setMostrarid_provinciaNumeroPatronal(Boolean mostrarid_provinciaNumeroPatronal) {
		this.mostrarid_provinciaNumeroPatronal= mostrarid_provinciaNumeroPatronal;
	}

	public Boolean getActivarid_provinciaNumeroPatronal() {
		return this.activarid_provinciaNumeroPatronal;
	}

	public void setActivarid_provinciaNumeroPatronal(Boolean activarid_provinciaNumeroPatronal) {
		this.activarid_provinciaNumeroPatronal= activarid_provinciaNumeroPatronal;
	}

	public Boolean getCargarid_provinciaNumeroPatronal() {
		return this.cargarid_provinciaNumeroPatronal;
	}

	public void setCargarid_provinciaNumeroPatronal(Boolean cargarid_provinciaNumeroPatronal) {
		this.cargarid_provinciaNumeroPatronal= cargarid_provinciaNumeroPatronal;
	}

	public Border setResaltarid_cantonNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarid_cantonNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cantonNumeroPatronal() {
		return this.resaltarid_cantonNumeroPatronal;
	}

	public void setResaltarid_cantonNumeroPatronal(Border borderResaltar) {
		this.resaltarid_cantonNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarid_cantonNumeroPatronal() {
		return this.mostrarid_cantonNumeroPatronal;
	}

	public void setMostrarid_cantonNumeroPatronal(Boolean mostrarid_cantonNumeroPatronal) {
		this.mostrarid_cantonNumeroPatronal= mostrarid_cantonNumeroPatronal;
	}

	public Boolean getActivarid_cantonNumeroPatronal() {
		return this.activarid_cantonNumeroPatronal;
	}

	public void setActivarid_cantonNumeroPatronal(Boolean activarid_cantonNumeroPatronal) {
		this.activarid_cantonNumeroPatronal= activarid_cantonNumeroPatronal;
	}

	public Boolean getCargarid_cantonNumeroPatronal() {
		return this.cargarid_cantonNumeroPatronal;
	}

	public void setCargarid_cantonNumeroPatronal(Boolean cargarid_cantonNumeroPatronal) {
		this.cargarid_cantonNumeroPatronal= cargarid_cantonNumeroPatronal;
	}

	public Border setResaltarid_parroquiaNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarid_parroquiaNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_parroquiaNumeroPatronal() {
		return this.resaltarid_parroquiaNumeroPatronal;
	}

	public void setResaltarid_parroquiaNumeroPatronal(Border borderResaltar) {
		this.resaltarid_parroquiaNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarid_parroquiaNumeroPatronal() {
		return this.mostrarid_parroquiaNumeroPatronal;
	}

	public void setMostrarid_parroquiaNumeroPatronal(Boolean mostrarid_parroquiaNumeroPatronal) {
		this.mostrarid_parroquiaNumeroPatronal= mostrarid_parroquiaNumeroPatronal;
	}

	public Boolean getActivarid_parroquiaNumeroPatronal() {
		return this.activarid_parroquiaNumeroPatronal;
	}

	public void setActivarid_parroquiaNumeroPatronal(Boolean activarid_parroquiaNumeroPatronal) {
		this.activarid_parroquiaNumeroPatronal= activarid_parroquiaNumeroPatronal;
	}

	public Boolean getCargarid_parroquiaNumeroPatronal() {
		return this.cargarid_parroquiaNumeroPatronal;
	}

	public void setCargarid_parroquiaNumeroPatronal(Boolean cargarid_parroquiaNumeroPatronal) {
		this.cargarid_parroquiaNumeroPatronal= cargarid_parroquiaNumeroPatronal;
	}

	public Border setResaltarnumeroNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarnumeroNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroNumeroPatronal() {
		return this.resaltarnumeroNumeroPatronal;
	}

	public void setResaltarnumeroNumeroPatronal(Border borderResaltar) {
		this.resaltarnumeroNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarnumeroNumeroPatronal() {
		return this.mostrarnumeroNumeroPatronal;
	}

	public void setMostrarnumeroNumeroPatronal(Boolean mostrarnumeroNumeroPatronal) {
		this.mostrarnumeroNumeroPatronal= mostrarnumeroNumeroPatronal;
	}

	public Boolean getActivarnumeroNumeroPatronal() {
		return this.activarnumeroNumeroPatronal;
	}

	public void setActivarnumeroNumeroPatronal(Boolean activarnumeroNumeroPatronal) {
		this.activarnumeroNumeroPatronal= activarnumeroNumeroPatronal;
	}

	public Border setResaltarcodigo_actividadNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarcodigo_actividadNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_actividadNumeroPatronal() {
		return this.resaltarcodigo_actividadNumeroPatronal;
	}

	public void setResaltarcodigo_actividadNumeroPatronal(Border borderResaltar) {
		this.resaltarcodigo_actividadNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarcodigo_actividadNumeroPatronal() {
		return this.mostrarcodigo_actividadNumeroPatronal;
	}

	public void setMostrarcodigo_actividadNumeroPatronal(Boolean mostrarcodigo_actividadNumeroPatronal) {
		this.mostrarcodigo_actividadNumeroPatronal= mostrarcodigo_actividadNumeroPatronal;
	}

	public Boolean getActivarcodigo_actividadNumeroPatronal() {
		return this.activarcodigo_actividadNumeroPatronal;
	}

	public void setActivarcodigo_actividadNumeroPatronal(Boolean activarcodigo_actividadNumeroPatronal) {
		this.activarcodigo_actividadNumeroPatronal= activarcodigo_actividadNumeroPatronal;
	}

	public Border setResaltarapellidoNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarapellidoNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarapellidoNumeroPatronal() {
		return this.resaltarapellidoNumeroPatronal;
	}

	public void setResaltarapellidoNumeroPatronal(Border borderResaltar) {
		this.resaltarapellidoNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarapellidoNumeroPatronal() {
		return this.mostrarapellidoNumeroPatronal;
	}

	public void setMostrarapellidoNumeroPatronal(Boolean mostrarapellidoNumeroPatronal) {
		this.mostrarapellidoNumeroPatronal= mostrarapellidoNumeroPatronal;
	}

	public Boolean getActivarapellidoNumeroPatronal() {
		return this.activarapellidoNumeroPatronal;
	}

	public void setActivarapellidoNumeroPatronal(Boolean activarapellidoNumeroPatronal) {
		this.activarapellidoNumeroPatronal= activarapellidoNumeroPatronal;
	}

	public Border setResaltarnombreNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarnombreNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreNumeroPatronal() {
		return this.resaltarnombreNumeroPatronal;
	}

	public void setResaltarnombreNumeroPatronal(Border borderResaltar) {
		this.resaltarnombreNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarnombreNumeroPatronal() {
		return this.mostrarnombreNumeroPatronal;
	}

	public void setMostrarnombreNumeroPatronal(Boolean mostrarnombreNumeroPatronal) {
		this.mostrarnombreNumeroPatronal= mostrarnombreNumeroPatronal;
	}

	public Boolean getActivarnombreNumeroPatronal() {
		return this.activarnombreNumeroPatronal;
	}

	public void setActivarnombreNumeroPatronal(Boolean activarnombreNumeroPatronal) {
		this.activarnombreNumeroPatronal= activarnombreNumeroPatronal;
	}

	public Border setResaltarcedulaNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltarcedulaNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcedulaNumeroPatronal() {
		return this.resaltarcedulaNumeroPatronal;
	}

	public void setResaltarcedulaNumeroPatronal(Border borderResaltar) {
		this.resaltarcedulaNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrarcedulaNumeroPatronal() {
		return this.mostrarcedulaNumeroPatronal;
	}

	public void setMostrarcedulaNumeroPatronal(Boolean mostrarcedulaNumeroPatronal) {
		this.mostrarcedulaNumeroPatronal= mostrarcedulaNumeroPatronal;
	}

	public Boolean getActivarcedulaNumeroPatronal() {
		return this.activarcedulaNumeroPatronal;
	}

	public void setActivarcedulaNumeroPatronal(Boolean activarcedulaNumeroPatronal) {
		this.activarcedulaNumeroPatronal= activarcedulaNumeroPatronal;
	}

	public Border setResaltartelefonoNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltartelefonoNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoNumeroPatronal() {
		return this.resaltartelefonoNumeroPatronal;
	}

	public void setResaltartelefonoNumeroPatronal(Border borderResaltar) {
		this.resaltartelefonoNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrartelefonoNumeroPatronal() {
		return this.mostrartelefonoNumeroPatronal;
	}

	public void setMostrartelefonoNumeroPatronal(Boolean mostrartelefonoNumeroPatronal) {
		this.mostrartelefonoNumeroPatronal= mostrartelefonoNumeroPatronal;
	}

	public Boolean getActivartelefonoNumeroPatronal() {
		return this.activartelefonoNumeroPatronal;
	}

	public void setActivartelefonoNumeroPatronal(Boolean activartelefonoNumeroPatronal) {
		this.activartelefonoNumeroPatronal= activartelefonoNumeroPatronal;
	}

	public Border setResaltardescripcionNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltar);
		
		this.resaltardescripcionNumeroPatronal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionNumeroPatronal() {
		return this.resaltardescripcionNumeroPatronal;
	}

	public void setResaltardescripcionNumeroPatronal(Border borderResaltar) {
		this.resaltardescripcionNumeroPatronal= borderResaltar;
	}

	public Boolean getMostrardescripcionNumeroPatronal() {
		return this.mostrardescripcionNumeroPatronal;
	}

	public void setMostrardescripcionNumeroPatronal(Boolean mostrardescripcionNumeroPatronal) {
		this.mostrardescripcionNumeroPatronal= mostrardescripcionNumeroPatronal;
	}

	public Boolean getActivardescripcionNumeroPatronal() {
		return this.activardescripcionNumeroPatronal;
	}

	public void setActivardescripcionNumeroPatronal(Boolean activardescripcionNumeroPatronal) {
		this.activardescripcionNumeroPatronal= activardescripcionNumeroPatronal;
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
		
		
		this.setMostraridNumeroPatronal(esInicial);
		this.setMostrarid_empresaNumeroPatronal(esInicial);
		this.setMostrarid_provinciaNumeroPatronal(esInicial);
		this.setMostrarid_cantonNumeroPatronal(esInicial);
		this.setMostrarid_parroquiaNumeroPatronal(esInicial);
		this.setMostrarnumeroNumeroPatronal(esInicial);
		this.setMostrarcodigo_actividadNumeroPatronal(esInicial);
		this.setMostrarapellidoNumeroPatronal(esInicial);
		this.setMostrarnombreNumeroPatronal(esInicial);
		this.setMostrarcedulaNumeroPatronal(esInicial);
		this.setMostrartelefonoNumeroPatronal(esInicial);
		this.setMostrardescripcionNumeroPatronal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.ID)) {
				this.setMostraridNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDPROVINCIA)) {
				this.setMostrarid_provinciaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDCANTON)) {
				this.setMostrarid_cantonNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDPARROQUIA)) {
				this.setMostrarid_parroquiaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD)) {
				this.setMostrarcodigo_actividadNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.APELLIDO)) {
				this.setMostrarapellidoNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.CEDULA)) {
				this.setMostrarcedulaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionNumeroPatronal(esAsigna);
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
		
		
		this.setActivaridNumeroPatronal(esInicial);
		this.setActivarid_empresaNumeroPatronal(esInicial);
		this.setActivarid_provinciaNumeroPatronal(esInicial);
		this.setActivarid_cantonNumeroPatronal(esInicial);
		this.setActivarid_parroquiaNumeroPatronal(esInicial);
		this.setActivarnumeroNumeroPatronal(esInicial);
		this.setActivarcodigo_actividadNumeroPatronal(esInicial);
		this.setActivarapellidoNumeroPatronal(esInicial);
		this.setActivarnombreNumeroPatronal(esInicial);
		this.setActivarcedulaNumeroPatronal(esInicial);
		this.setActivartelefonoNumeroPatronal(esInicial);
		this.setActivardescripcionNumeroPatronal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.ID)) {
				this.setActivaridNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDPROVINCIA)) {
				this.setActivarid_provinciaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDCANTON)) {
				this.setActivarid_cantonNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDPARROQUIA)) {
				this.setActivarid_parroquiaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.NUMERO)) {
				this.setActivarnumeroNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD)) {
				this.setActivarcodigo_actividadNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.APELLIDO)) {
				this.setActivarapellidoNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.NOMBRE)) {
				this.setActivarnombreNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.CEDULA)) {
				this.setActivarcedulaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionNumeroPatronal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridNumeroPatronal(esInicial);
		this.setResaltarid_empresaNumeroPatronal(esInicial);
		this.setResaltarid_provinciaNumeroPatronal(esInicial);
		this.setResaltarid_cantonNumeroPatronal(esInicial);
		this.setResaltarid_parroquiaNumeroPatronal(esInicial);
		this.setResaltarnumeroNumeroPatronal(esInicial);
		this.setResaltarcodigo_actividadNumeroPatronal(esInicial);
		this.setResaltarapellidoNumeroPatronal(esInicial);
		this.setResaltarnombreNumeroPatronal(esInicial);
		this.setResaltarcedulaNumeroPatronal(esInicial);
		this.setResaltartelefonoNumeroPatronal(esInicial);
		this.setResaltardescripcionNumeroPatronal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.ID)) {
				this.setResaltaridNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDPROVINCIA)) {
				this.setResaltarid_provinciaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDCANTON)) {
				this.setResaltarid_cantonNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.IDPARROQUIA)) {
				this.setResaltarid_parroquiaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.CODIGOACTIVIDAD)) {
				this.setResaltarcodigo_actividadNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.APELLIDO)) {
				this.setResaltarapellidoNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.CEDULA)) {
				this.setResaltarcedulaNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoNumeroPatronal(esAsigna);
				continue;
			}

			if(campo.clase.equals(NumeroPatronalConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionNumeroPatronal(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDatoGeneralEmpleadoNumeroPatronal=null;

	public Border getResaltarDatoGeneralEmpleadoNumeroPatronal() {
		return this.resaltarDatoGeneralEmpleadoNumeroPatronal;
	}

	public void setResaltarDatoGeneralEmpleadoNumeroPatronal(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoNumeroPatronal= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoNumeroPatronal= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoNumeroPatronal=true;

	public Boolean getMostrarDatoGeneralEmpleadoNumeroPatronal() {
		return this.mostrarDatoGeneralEmpleadoNumeroPatronal;
	}

	public void setMostrarDatoGeneralEmpleadoNumeroPatronal(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoNumeroPatronal= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoNumeroPatronal=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoNumeroPatronal() {
		return this.activarDatoGeneralEmpleadoNumeroPatronal;
	}

	public void setActivarDatoGeneralEmpleadoNumeroPatronal(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoNumeroPatronal= habilitarResaltarDatoGeneralEmpleado;
	}


	public Border resaltarEstructuraNumeroPatronal=null;

	public Border getResaltarEstructuraNumeroPatronal() {
		return this.resaltarEstructuraNumeroPatronal;
	}

	public void setResaltarEstructuraNumeroPatronal(Border borderResaltarEstructura) {
		if(borderResaltarEstructura!=null) {
			this.resaltarEstructuraNumeroPatronal= borderResaltarEstructura;
		}
	}

	public Border setResaltarEstructuraNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltarEstructura=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltarEstructura);
			
		this.resaltarEstructuraNumeroPatronal= borderResaltarEstructura;

		 return borderResaltarEstructura;
	}



	public Boolean mostrarEstructuraNumeroPatronal=true;

	public Boolean getMostrarEstructuraNumeroPatronal() {
		return this.mostrarEstructuraNumeroPatronal;
	}

	public void setMostrarEstructuraNumeroPatronal(Boolean visibilidadResaltarEstructura) {
		this.mostrarEstructuraNumeroPatronal= visibilidadResaltarEstructura;
	}



	public Boolean activarEstructuraNumeroPatronal=true;

	public Boolean gethabilitarResaltarEstructuraNumeroPatronal() {
		return this.activarEstructuraNumeroPatronal;
	}

	public void setActivarEstructuraNumeroPatronal(Boolean habilitarResaltarEstructura) {
		this.activarEstructuraNumeroPatronal= habilitarResaltarEstructura;
	}


	public Border resaltarCargoNumeroPatronal=null;

	public Border getResaltarCargoNumeroPatronal() {
		return this.resaltarCargoNumeroPatronal;
	}

	public void setResaltarCargoNumeroPatronal(Border borderResaltarCargo) {
		if(borderResaltarCargo!=null) {
			this.resaltarCargoNumeroPatronal= borderResaltarCargo;
		}
	}

	public Border setResaltarCargoNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltarCargo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//numeropatronalBeanSwingJInternalFrame.jTtoolBarNumeroPatronal.setBorder(borderResaltarCargo);
			
		this.resaltarCargoNumeroPatronal= borderResaltarCargo;

		 return borderResaltarCargo;
	}



	public Boolean mostrarCargoNumeroPatronal=true;

	public Boolean getMostrarCargoNumeroPatronal() {
		return this.mostrarCargoNumeroPatronal;
	}

	public void setMostrarCargoNumeroPatronal(Boolean visibilidadResaltarCargo) {
		this.mostrarCargoNumeroPatronal= visibilidadResaltarCargo;
	}



	public Boolean activarCargoNumeroPatronal=true;

	public Boolean gethabilitarResaltarCargoNumeroPatronal() {
		return this.activarCargoNumeroPatronal;
	}

	public void setActivarCargoNumeroPatronal(Boolean habilitarResaltarCargo) {
		this.activarCargoNumeroPatronal= habilitarResaltarCargo;
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

		this.setMostrarDatoGeneralEmpleadoNumeroPatronal(esInicial);
		this.setMostrarEstructuraNumeroPatronal(esInicial);
		this.setMostrarCargoNumeroPatronal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoNumeroPatronal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Estructura.class)) {
				this.setMostrarEstructuraNumeroPatronal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setMostrarCargoNumeroPatronal(esAsigna);
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

		this.setActivarDatoGeneralEmpleadoNumeroPatronal(esInicial);
		this.setActivarEstructuraNumeroPatronal(esInicial);
		this.setActivarCargoNumeroPatronal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoNumeroPatronal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Estructura.class)) {
				this.setActivarEstructuraNumeroPatronal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setActivarCargoNumeroPatronal(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDatoGeneralEmpleadoNumeroPatronal(esInicial);
		this.setResaltarEstructuraNumeroPatronal(esInicial);
		this.setResaltarCargoNumeroPatronal(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoNumeroPatronal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Estructura.class)) {
				this.setResaltarEstructuraNumeroPatronal(esAsigna);
				continue;
			}

			if(clase.clas.equals(Cargo.class)) {
				this.setResaltarCargoNumeroPatronal(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCantonNumeroPatronal=true;

	public Boolean getMostrarFK_IdCantonNumeroPatronal() {
		return this.mostrarFK_IdCantonNumeroPatronal;
	}

	public void setMostrarFK_IdCantonNumeroPatronal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCantonNumeroPatronal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaNumeroPatronal=true;

	public Boolean getMostrarFK_IdEmpresaNumeroPatronal() {
		return this.mostrarFK_IdEmpresaNumeroPatronal;
	}

	public void setMostrarFK_IdEmpresaNumeroPatronal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaNumeroPatronal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdParroquiaNumeroPatronal=true;

	public Boolean getMostrarFK_IdParroquiaNumeroPatronal() {
		return this.mostrarFK_IdParroquiaNumeroPatronal;
	}

	public void setMostrarFK_IdParroquiaNumeroPatronal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdParroquiaNumeroPatronal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProvinciaNumeroPatronal=true;

	public Boolean getMostrarFK_IdProvinciaNumeroPatronal() {
		return this.mostrarFK_IdProvinciaNumeroPatronal;
	}

	public void setMostrarFK_IdProvinciaNumeroPatronal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProvinciaNumeroPatronal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCantonNumeroPatronal=true;

	public Boolean getActivarFK_IdCantonNumeroPatronal() {
		return this.activarFK_IdCantonNumeroPatronal;
	}

	public void setActivarFK_IdCantonNumeroPatronal(Boolean habilitarResaltar) {
		this.activarFK_IdCantonNumeroPatronal= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaNumeroPatronal=true;

	public Boolean getActivarFK_IdEmpresaNumeroPatronal() {
		return this.activarFK_IdEmpresaNumeroPatronal;
	}

	public void setActivarFK_IdEmpresaNumeroPatronal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaNumeroPatronal= habilitarResaltar;
	}

	public Boolean activarFK_IdParroquiaNumeroPatronal=true;

	public Boolean getActivarFK_IdParroquiaNumeroPatronal() {
		return this.activarFK_IdParroquiaNumeroPatronal;
	}

	public void setActivarFK_IdParroquiaNumeroPatronal(Boolean habilitarResaltar) {
		this.activarFK_IdParroquiaNumeroPatronal= habilitarResaltar;
	}

	public Boolean activarFK_IdProvinciaNumeroPatronal=true;

	public Boolean getActivarFK_IdProvinciaNumeroPatronal() {
		return this.activarFK_IdProvinciaNumeroPatronal;
	}

	public void setActivarFK_IdProvinciaNumeroPatronal(Boolean habilitarResaltar) {
		this.activarFK_IdProvinciaNumeroPatronal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCantonNumeroPatronal=null;

	public Border getResaltarFK_IdCantonNumeroPatronal() {
		return this.resaltarFK_IdCantonNumeroPatronal;
	}

	public void setResaltarFK_IdCantonNumeroPatronal(Border borderResaltar) {
		this.resaltarFK_IdCantonNumeroPatronal= borderResaltar;
	}

	public void setResaltarFK_IdCantonNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCantonNumeroPatronal= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaNumeroPatronal=null;

	public Border getResaltarFK_IdEmpresaNumeroPatronal() {
		return this.resaltarFK_IdEmpresaNumeroPatronal;
	}

	public void setResaltarFK_IdEmpresaNumeroPatronal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaNumeroPatronal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaNumeroPatronal= borderResaltar;
	}

	public Border resaltarFK_IdParroquiaNumeroPatronal=null;

	public Border getResaltarFK_IdParroquiaNumeroPatronal() {
		return this.resaltarFK_IdParroquiaNumeroPatronal;
	}

	public void setResaltarFK_IdParroquiaNumeroPatronal(Border borderResaltar) {
		this.resaltarFK_IdParroquiaNumeroPatronal= borderResaltar;
	}

	public void setResaltarFK_IdParroquiaNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdParroquiaNumeroPatronal= borderResaltar;
	}

	public Border resaltarFK_IdProvinciaNumeroPatronal=null;

	public Border getResaltarFK_IdProvinciaNumeroPatronal() {
		return this.resaltarFK_IdProvinciaNumeroPatronal;
	}

	public void setResaltarFK_IdProvinciaNumeroPatronal(Border borderResaltar) {
		this.resaltarFK_IdProvinciaNumeroPatronal= borderResaltar;
	}

	public void setResaltarFK_IdProvinciaNumeroPatronal(ParametroGeneralUsuario parametroGeneralUsuario/*NumeroPatronalBeanSwingJInternalFrame numeropatronalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProvinciaNumeroPatronal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}