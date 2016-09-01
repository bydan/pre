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
package com.bydan.erp.seguridad.util;

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


import com.bydan.erp.seguridad.util.SucursalConstantesFunciones;
import com.bydan.erp.seguridad.util.SucursalParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SucursalParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.seguridad.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.seguridad.business.dataaccess.*;
//import com.bydan.erp.seguridad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class SucursalConstantesFunciones extends SucursalConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Sucursal";
	public static final String SPATHOPCION="Seguridad";	
	public static final String SPATHMODULO="seguridad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Sucursal"+SucursalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SucursalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SucursalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SucursalConstantesFunciones.SCHEMA+"_"+SucursalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SucursalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SucursalConstantesFunciones.SCHEMA+"_"+SucursalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SucursalConstantesFunciones.SCHEMA+"_"+SucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SucursalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SucursalConstantesFunciones.SCHEMA+"_"+SucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SucursalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SucursalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SucursalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SucursalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SucursalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SucursalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SucursalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SucursalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SucursalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sucursales";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Sucursal";
	public static final String SCLASSWEBTITULO_LOWER="Sucursal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Sucursal";
	public static final String OBJECTNAME="sucursal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_SEGURIDAD;	
	public static final String TABLENAME="sucursal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select sucursal from "+SucursalConstantesFunciones.SPERSISTENCENAME+" sucursal";
	public static String QUERYSELECTNATIVE="select "+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".id,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".version_row,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".id_empresa,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".id_pais,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".id_ciudad,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".codigo,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".numero,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".nombre,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".direccion,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".ruc,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".telefono,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".fax,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".mail,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".responsable,"+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME+".descripcion from "+SucursalConstantesFunciones.SCHEMA+"."+SucursalConstantesFunciones.TABLENAME;//+" as "+SucursalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected SucursalConstantesFuncionesAdditional sucursalConstantesFuncionesAdditional=null;
	
	public SucursalConstantesFuncionesAdditional getSucursalConstantesFuncionesAdditional() {
		return this.sucursalConstantesFuncionesAdditional;
	}
	
	public void setSucursalConstantesFuncionesAdditional(SucursalConstantesFuncionesAdditional sucursalConstantesFuncionesAdditional) {
		try {
			this.sucursalConstantesFuncionesAdditional=sucursalConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDPAIS= "id_pais";
    public static final String IDCIUDAD= "id_ciudad";
    public static final String CODIGO= "codigo";
    public static final String NUMERO= "numero";
    public static final String NOMBRE= "nombre";
    public static final String DIRECCION= "direccion";
    public static final String RUC= "ruc";
    public static final String TELEFONO= "telefono";
    public static final String FAX= "fax";
    public static final String MAIL= "mail";
    public static final String RESPONSABLE= "responsable";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_IDCIUDAD= "Ciudad";
		public static final String LABEL_IDCIUDAD_LOWER= "Ciudad";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_DIRECCION= "Direccion";
		public static final String LABEL_DIRECCION_LOWER= "Direccion";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
    	public static final String LABEL_FAX= "Fax";
		public static final String LABEL_FAX_LOWER= "Fax";
    	public static final String LABEL_MAIL= "Mail";
		public static final String LABEL_MAIL_LOWER= "Mail";
    	public static final String LABEL_RESPONSABLE= "Responsable";
		public static final String LABEL_RESPONSABLE_LOWER= "Responsable";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA_TELEFONO;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA_TELEFONO;	
	public static final String SREGEXFAX=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXFAX=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXMAIL=ConstantesValidacion.SREGEXCADENA_MAIL;
	public static final String SMENSAJEREGEXMAIL=ConstantesValidacion.SVALIDACIONCADENA_MAIL;	
	public static final String SREGEXRESPONSABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRESPONSABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getSucursalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SucursalConstantesFunciones.IDEMPRESA)) {sLabelColumna=SucursalConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.IDPAIS)) {sLabelColumna=SucursalConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.IDCIUDAD)) {sLabelColumna=SucursalConstantesFunciones.LABEL_IDCIUDAD;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.CODIGO)) {sLabelColumna=SucursalConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.NUMERO)) {sLabelColumna=SucursalConstantesFunciones.LABEL_NUMERO;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.NOMBRE)) {sLabelColumna=SucursalConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.DIRECCION)) {sLabelColumna=SucursalConstantesFunciones.LABEL_DIRECCION;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.RUC)) {sLabelColumna=SucursalConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.TELEFONO)) {sLabelColumna=SucursalConstantesFunciones.LABEL_TELEFONO;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.FAX)) {sLabelColumna=SucursalConstantesFunciones.LABEL_FAX;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.MAIL)) {sLabelColumna=SucursalConstantesFunciones.LABEL_MAIL;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.RESPONSABLE)) {sLabelColumna=SucursalConstantesFunciones.LABEL_RESPONSABLE;}
		if(sNombreColumna.equals(SucursalConstantesFunciones.DESCRIPCION)) {sLabelColumna=SucursalConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(sucursal !=null/* && sucursal.getId()!=0*/) {
			sDescripcion=sucursal.getnombre();//sucursalsucursal.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSucursalDescripcionDetallado(Sucursal sucursal) {
		String sDescripcion="";
			
		sDescripcion+=SucursalConstantesFunciones.ID+"=";
		sDescripcion+=sucursal.getId().toString()+",";
		sDescripcion+=SucursalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=sucursal.getVersionRow().toString()+",";
		sDescripcion+=SucursalConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=sucursal.getid_empresa().toString()+",";
		sDescripcion+=SucursalConstantesFunciones.IDPAIS+"=";
		sDescripcion+=sucursal.getid_pais().toString()+",";
		sDescripcion+=SucursalConstantesFunciones.IDCIUDAD+"=";
		sDescripcion+=sucursal.getid_ciudad().toString()+",";
		sDescripcion+=SucursalConstantesFunciones.CODIGO+"=";
		sDescripcion+=sucursal.getcodigo()+",";
		sDescripcion+=SucursalConstantesFunciones.NUMERO+"=";
		sDescripcion+=sucursal.getnumero()+",";
		sDescripcion+=SucursalConstantesFunciones.NOMBRE+"=";
		sDescripcion+=sucursal.getnombre()+",";
		sDescripcion+=SucursalConstantesFunciones.DIRECCION+"=";
		sDescripcion+=sucursal.getdireccion()+",";
		sDescripcion+=SucursalConstantesFunciones.RUC+"=";
		sDescripcion+=sucursal.getruc()+",";
		sDescripcion+=SucursalConstantesFunciones.TELEFONO+"=";
		sDescripcion+=sucursal.gettelefono()+",";
		sDescripcion+=SucursalConstantesFunciones.FAX+"=";
		sDescripcion+=sucursal.getfax()+",";
		sDescripcion+=SucursalConstantesFunciones.MAIL+"=";
		sDescripcion+=sucursal.getmail()+",";
		sDescripcion+=SucursalConstantesFunciones.RESPONSABLE+"=";
		sDescripcion+=sucursal.getresponsable()+",";
		sDescripcion+=SucursalConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=sucursal.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setSucursalDescripcion(Sucursal sucursal,String sValor) throws Exception {			
		if(sucursal !=null) {
			sucursal.setnombre(sValor);;//sucursalsucursal.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCiudadDescripcion(Ciudad ciudad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ciudad!=null/*&&ciudad.getId()>0*/) {
			sDescripcion=CiudadConstantesFunciones.getCiudadDescripcion(ciudad);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCiudad")) {
			sNombreIndice="Tipo=  Por Ciudad";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		} else if(sNombreIndice.equals("PorIdPorIdEmpresa")) {
			sNombreIndice="Tipo=  Por Id Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCiudad(Long id_ciudad) {
		String sDetalleIndice=" Parametros->";
		if(id_ciudad!=null) {sDetalleIndice+=" Codigo Unico De Ciudad="+id_ciudad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorIdPorIdEmpresa(Long id,Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();}
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosSucursal(Sucursal sucursal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		sucursal.setcodigo(sucursal.getcodigo().trim());
		sucursal.setnumero(sucursal.getnumero().trim());
		sucursal.setnombre(sucursal.getnombre().trim());
		sucursal.setdireccion(sucursal.getdireccion().trim());
		sucursal.setruc(sucursal.getruc().trim());
		sucursal.settelefono(sucursal.gettelefono().trim());
		sucursal.setfax(sucursal.getfax().trim());
		sucursal.setmail(sucursal.getmail().trim());
		sucursal.setresponsable(sucursal.getresponsable().trim());
		sucursal.setdescripcion(sucursal.getdescripcion().trim());
	}
	
	public static void quitarEspaciosSucursals(List<Sucursal> sucursals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Sucursal sucursal: sucursals) {
			sucursal.setcodigo(sucursal.getcodigo().trim());
			sucursal.setnumero(sucursal.getnumero().trim());
			sucursal.setnombre(sucursal.getnombre().trim());
			sucursal.setdireccion(sucursal.getdireccion().trim());
			sucursal.setruc(sucursal.getruc().trim());
			sucursal.settelefono(sucursal.gettelefono().trim());
			sucursal.setfax(sucursal.getfax().trim());
			sucursal.setmail(sucursal.getmail().trim());
			sucursal.setresponsable(sucursal.getresponsable().trim());
			sucursal.setdescripcion(sucursal.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSucursal(Sucursal sucursal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && sucursal.getConCambioAuxiliar()) {
			sucursal.setIsDeleted(sucursal.getIsDeletedAuxiliar());	
			sucursal.setIsNew(sucursal.getIsNewAuxiliar());	
			sucursal.setIsChanged(sucursal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			sucursal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			sucursal.setIsDeletedAuxiliar(false);	
			sucursal.setIsNewAuxiliar(false);	
			sucursal.setIsChangedAuxiliar(false);
			
			sucursal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSucursals(List<Sucursal> sucursals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Sucursal sucursal : sucursals) {
			if(conAsignarBase && sucursal.getConCambioAuxiliar()) {
				sucursal.setIsDeleted(sucursal.getIsDeletedAuxiliar());	
				sucursal.setIsNew(sucursal.getIsNewAuxiliar());	
				sucursal.setIsChanged(sucursal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				sucursal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				sucursal.setIsDeletedAuxiliar(false);	
				sucursal.setIsNewAuxiliar(false);	
				sucursal.setIsChangedAuxiliar(false);
				
				sucursal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSucursal(Sucursal sucursal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSucursals(List<Sucursal> sucursals,Boolean conEnteros) throws Exception  {
		
		for(Sucursal sucursal: sucursals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSucursal(List<Sucursal> sucursals,Sucursal sucursalAux) throws Exception  {
		SucursalConstantesFunciones.InicializarValoresSucursal(sucursalAux,true);
		
		for(Sucursal sucursal: sucursals) {
			if(sucursal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSucursal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SucursalConstantesFunciones.getArrayColumnasGlobalesSucursal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSucursal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSucursal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Sucursal> sucursals,Sucursal sucursal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Sucursal sucursalAux: sucursals) {
			if(sucursalAux!=null && sucursal!=null) {
				if((sucursalAux.getId()==null && sucursal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(sucursalAux.getId()!=null && sucursal.getId()!=null){
					if(sucursalAux.getId().equals(sucursal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSucursal(List<Sucursal> sucursals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Sucursal sucursal: sucursals) {			
			if(sucursal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSucursal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_ID, SucursalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_VERSIONROW, SucursalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_IDEMPRESA, SucursalConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_IDPAIS, SucursalConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_IDCIUDAD, SucursalConstantesFunciones.IDCIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_CODIGO, SucursalConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_NUMERO, SucursalConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_NOMBRE, SucursalConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_DIRECCION, SucursalConstantesFunciones.DIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_RUC, SucursalConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_TELEFONO, SucursalConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_FAX, SucursalConstantesFunciones.FAX,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_MAIL, SucursalConstantesFunciones.MAIL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_RESPONSABLE, SucursalConstantesFunciones.RESPONSABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SucursalConstantesFunciones.LABEL_DESCRIPCION, SucursalConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSucursal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.IDCIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.DIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.FAX;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.MAIL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.RESPONSABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SucursalConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSucursal() throws Exception  {
		return SucursalConstantesFunciones.getTiposSeleccionarSucursal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSucursal(Boolean conFk) throws Exception  {
		return SucursalConstantesFunciones.getTiposSeleccionarSucursal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSucursal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_IDCIUDAD);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_IDCIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_DIRECCION);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_DIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_FAX);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_FAX);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_MAIL);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_MAIL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_RESPONSABLE);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_RESPONSABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SucursalConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(SucursalConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSucursal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSucursal(Sucursal sucursalAux) throws Exception {
		
			sucursalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(sucursalAux.getEmpresa()));
			sucursalAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(sucursalAux.getPais()));
			sucursalAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(sucursalAux.getCiudad()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSucursal(List<Sucursal> sucursalsTemp) throws Exception {
		for(Sucursal sucursalAux:sucursalsTemp) {
			
			sucursalAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(sucursalAux.getEmpresa()));
			sucursalAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(sucursalAux.getPais()));
			sucursalAux.setciudad_descripcion(CiudadConstantesFunciones.getCiudadDescripcion(sucursalAux.getCiudad()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Pais.class));
				classes.add(new Classe(Ciudad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ciudad.class)) {
						classes.add(new Classe(Ciudad.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}

					if(Ciudad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ciudad.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SucursalConstantesFunciones.getClassesRelationshipsOfSucursal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSucursal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SucursalConstantesFunciones.getClassesRelationshipsFromStringsOfSucursal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSucursal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(Sucursal sucursal,List<Sucursal> sucursals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Sucursal sucursalEncontrado=null;
			
			for(Sucursal sucursalLocal:sucursals) {
				if(sucursalLocal.getId().equals(sucursal.getId())) {
					sucursalEncontrado=sucursalLocal;
					
					sucursalLocal.setIsChanged(sucursal.getIsChanged());
					sucursalLocal.setIsNew(sucursal.getIsNew());
					sucursalLocal.setIsDeleted(sucursal.getIsDeleted());
					
					sucursalLocal.setGeneralEntityOriginal(sucursal.getGeneralEntityOriginal());
					
					sucursalLocal.setId(sucursal.getId());	
					sucursalLocal.setVersionRow(sucursal.getVersionRow());	
					sucursalLocal.setid_empresa(sucursal.getid_empresa());	
					sucursalLocal.setid_pais(sucursal.getid_pais());	
					sucursalLocal.setid_ciudad(sucursal.getid_ciudad());	
					sucursalLocal.setcodigo(sucursal.getcodigo());	
					sucursalLocal.setnumero(sucursal.getnumero());	
					sucursalLocal.setnombre(sucursal.getnombre());	
					sucursalLocal.setdireccion(sucursal.getdireccion());	
					sucursalLocal.setruc(sucursal.getruc());	
					sucursalLocal.settelefono(sucursal.gettelefono());	
					sucursalLocal.setfax(sucursal.getfax());	
					sucursalLocal.setmail(sucursal.getmail());	
					sucursalLocal.setresponsable(sucursal.getresponsable());	
					sucursalLocal.setdescripcion(sucursal.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!sucursal.getIsDeleted()) {
				if(!existe) {
					sucursals.add(sucursal);
				}
			} else {
				if(sucursalEncontrado!=null && permiteQuitar)  {
					sucursals.remove(sucursalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Sucursal sucursal,List<Sucursal> sucursals) throws Exception {
		try	{			
			for(Sucursal sucursalLocal:sucursals) {
				if(sucursalLocal.getId().equals(sucursal.getId())) {
					sucursalLocal.setIsSelected(sucursal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSucursal(List<Sucursal> sucursalsAux) throws Exception {
		//this.sucursalsAux=sucursalsAux;
		
		for(Sucursal sucursalAux:sucursalsAux) {
			if(sucursalAux.getIsChanged()) {
				sucursalAux.setIsChanged(false);
			}		
			
			if(sucursalAux.getIsNew()) {
				sucursalAux.setIsNew(false);
			}	
			
			if(sucursalAux.getIsDeleted()) {
				sucursalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSucursal(Sucursal sucursalAux) throws Exception {
		//this.sucursalAux=sucursalAux;
		
			if(sucursalAux.getIsChanged()) {
				sucursalAux.setIsChanged(false);
			}		
			
			if(sucursalAux.getIsNew()) {
				sucursalAux.setIsNew(false);
			}	
			
			if(sucursalAux.getIsDeleted()) {
				sucursalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Sucursal sucursalAsignar,Sucursal sucursal) throws Exception {
		sucursalAsignar.setId(sucursal.getId());	
		sucursalAsignar.setVersionRow(sucursal.getVersionRow());	
		sucursalAsignar.setid_empresa(sucursal.getid_empresa());
		sucursalAsignar.setempresa_descripcion(sucursal.getempresa_descripcion());	
		sucursalAsignar.setid_pais(sucursal.getid_pais());
		sucursalAsignar.setpais_descripcion(sucursal.getpais_descripcion());	
		sucursalAsignar.setid_ciudad(sucursal.getid_ciudad());
		sucursalAsignar.setciudad_descripcion(sucursal.getciudad_descripcion());	
		sucursalAsignar.setcodigo(sucursal.getcodigo());	
		sucursalAsignar.setnumero(sucursal.getnumero());	
		sucursalAsignar.setnombre(sucursal.getnombre());	
		sucursalAsignar.setdireccion(sucursal.getdireccion());	
		sucursalAsignar.setruc(sucursal.getruc());	
		sucursalAsignar.settelefono(sucursal.gettelefono());	
		sucursalAsignar.setfax(sucursal.getfax());	
		sucursalAsignar.setmail(sucursal.getmail());	
		sucursalAsignar.setresponsable(sucursal.getresponsable());	
		sucursalAsignar.setdescripcion(sucursal.getdescripcion());	
	}
	
	public static void inicializarSucursal(Sucursal sucursal) throws Exception {
		try {
				sucursal.setId(0L);	
					
				sucursal.setid_empresa(-1L);	
				sucursal.setid_pais(-1L);	
				sucursal.setid_ciudad(-1L);	
				sucursal.setcodigo("");	
				sucursal.setnumero("");	
				sucursal.setnombre("");	
				sucursal.setdireccion("");	
				sucursal.setruc("");	
				sucursal.settelefono("");	
				sucursal.setfax("");	
				sucursal.setmail("");	
				sucursal.setresponsable("");	
				sucursal.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSucursal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_IDCIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_DIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_FAX);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_MAIL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_RESPONSABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SucursalConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSucursal(String sTipo,Row row,Workbook workbook,Sucursal sucursal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getciudad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getdireccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getfax());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getmail());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getresponsable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(sucursal.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySucursal=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySucursal() {
		return this.sFinalQuerySucursal;
	}
	
	public void setsFinalQuerySucursal(String sFinalQuerySucursal) {
		this.sFinalQuerySucursal= sFinalQuerySucursal;
	}
	
	public Border resaltarSeleccionarSucursal=null;
	
	public Border setResaltarSeleccionarSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSucursal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSucursal() {
		return this.resaltarSeleccionarSucursal;
	}
	
	public void setResaltarSeleccionarSucursal(Border borderResaltarSeleccionarSucursal) {
		this.resaltarSeleccionarSucursal= borderResaltarSeleccionarSucursal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSucursal=null;
	public Boolean mostraridSucursal=true;
	public Boolean activaridSucursal=true;

	public Border resaltarid_empresaSucursal=null;
	public Boolean mostrarid_empresaSucursal=true;
	public Boolean activarid_empresaSucursal=true;
	public Boolean cargarid_empresaSucursal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSucursal=false;//ConEventDepend=true

	public Border resaltarid_paisSucursal=null;
	public Boolean mostrarid_paisSucursal=true;
	public Boolean activarid_paisSucursal=true;
	public Boolean cargarid_paisSucursal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisSucursal=false;//ConEventDepend=true

	public Border resaltarid_ciudadSucursal=null;
	public Boolean mostrarid_ciudadSucursal=true;
	public Boolean activarid_ciudadSucursal=true;
	public Boolean cargarid_ciudadSucursal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ciudadSucursal=true;//ConEventDepend=true

	public Border resaltarcodigoSucursal=null;
	public Boolean mostrarcodigoSucursal=true;
	public Boolean activarcodigoSucursal=true;

	public Border resaltarnumeroSucursal=null;
	public Boolean mostrarnumeroSucursal=true;
	public Boolean activarnumeroSucursal=true;

	public Border resaltarnombreSucursal=null;
	public Boolean mostrarnombreSucursal=true;
	public Boolean activarnombreSucursal=true;

	public Border resaltardireccionSucursal=null;
	public Boolean mostrardireccionSucursal=true;
	public Boolean activardireccionSucursal=true;

	public Border resaltarrucSucursal=null;
	public Boolean mostrarrucSucursal=true;
	public Boolean activarrucSucursal=true;

	public Border resaltartelefonoSucursal=null;
	public Boolean mostrartelefonoSucursal=true;
	public Boolean activartelefonoSucursal=true;

	public Border resaltarfaxSucursal=null;
	public Boolean mostrarfaxSucursal=true;
	public Boolean activarfaxSucursal=true;

	public Border resaltarmailSucursal=null;
	public Boolean mostrarmailSucursal=true;
	public Boolean activarmailSucursal=true;

	public Border resaltarresponsableSucursal=null;
	public Boolean mostrarresponsableSucursal=true;
	public Boolean activarresponsableSucursal=true;

	public Border resaltardescripcionSucursal=null;
	public Boolean mostrardescripcionSucursal=true;
	public Boolean activardescripcionSucursal=true;

	
	

	public Border setResaltaridSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltaridSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSucursal() {
		return this.resaltaridSucursal;
	}

	public void setResaltaridSucursal(Border borderResaltar) {
		this.resaltaridSucursal= borderResaltar;
	}

	public Boolean getMostraridSucursal() {
		return this.mostraridSucursal;
	}

	public void setMostraridSucursal(Boolean mostraridSucursal) {
		this.mostraridSucursal= mostraridSucursal;
	}

	public Boolean getActivaridSucursal() {
		return this.activaridSucursal;
	}

	public void setActivaridSucursal(Boolean activaridSucursal) {
		this.activaridSucursal= activaridSucursal;
	}

	public Border setResaltarid_empresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarid_empresaSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSucursal() {
		return this.resaltarid_empresaSucursal;
	}

	public void setResaltarid_empresaSucursal(Border borderResaltar) {
		this.resaltarid_empresaSucursal= borderResaltar;
	}

	public Boolean getMostrarid_empresaSucursal() {
		return this.mostrarid_empresaSucursal;
	}

	public void setMostrarid_empresaSucursal(Boolean mostrarid_empresaSucursal) {
		this.mostrarid_empresaSucursal= mostrarid_empresaSucursal;
	}

	public Boolean getActivarid_empresaSucursal() {
		return this.activarid_empresaSucursal;
	}

	public void setActivarid_empresaSucursal(Boolean activarid_empresaSucursal) {
		this.activarid_empresaSucursal= activarid_empresaSucursal;
	}

	public Boolean getCargarid_empresaSucursal() {
		return this.cargarid_empresaSucursal;
	}

	public void setCargarid_empresaSucursal(Boolean cargarid_empresaSucursal) {
		this.cargarid_empresaSucursal= cargarid_empresaSucursal;
	}

	public Border setResaltarid_paisSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarid_paisSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisSucursal() {
		return this.resaltarid_paisSucursal;
	}

	public void setResaltarid_paisSucursal(Border borderResaltar) {
		this.resaltarid_paisSucursal= borderResaltar;
	}

	public Boolean getMostrarid_paisSucursal() {
		return this.mostrarid_paisSucursal;
	}

	public void setMostrarid_paisSucursal(Boolean mostrarid_paisSucursal) {
		this.mostrarid_paisSucursal= mostrarid_paisSucursal;
	}

	public Boolean getActivarid_paisSucursal() {
		return this.activarid_paisSucursal;
	}

	public void setActivarid_paisSucursal(Boolean activarid_paisSucursal) {
		this.activarid_paisSucursal= activarid_paisSucursal;
	}

	public Boolean getCargarid_paisSucursal() {
		return this.cargarid_paisSucursal;
	}

	public void setCargarid_paisSucursal(Boolean cargarid_paisSucursal) {
		this.cargarid_paisSucursal= cargarid_paisSucursal;
	}

	public Border setResaltarid_ciudadSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarid_ciudadSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ciudadSucursal() {
		return this.resaltarid_ciudadSucursal;
	}

	public void setResaltarid_ciudadSucursal(Border borderResaltar) {
		this.resaltarid_ciudadSucursal= borderResaltar;
	}

	public Boolean getMostrarid_ciudadSucursal() {
		return this.mostrarid_ciudadSucursal;
	}

	public void setMostrarid_ciudadSucursal(Boolean mostrarid_ciudadSucursal) {
		this.mostrarid_ciudadSucursal= mostrarid_ciudadSucursal;
	}

	public Boolean getActivarid_ciudadSucursal() {
		return this.activarid_ciudadSucursal;
	}

	public void setActivarid_ciudadSucursal(Boolean activarid_ciudadSucursal) {
		this.activarid_ciudadSucursal= activarid_ciudadSucursal;
	}

	public Boolean getCargarid_ciudadSucursal() {
		return this.cargarid_ciudadSucursal;
	}

	public void setCargarid_ciudadSucursal(Boolean cargarid_ciudadSucursal) {
		this.cargarid_ciudadSucursal= cargarid_ciudadSucursal;
	}

	public Border setResaltarcodigoSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarcodigoSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoSucursal() {
		return this.resaltarcodigoSucursal;
	}

	public void setResaltarcodigoSucursal(Border borderResaltar) {
		this.resaltarcodigoSucursal= borderResaltar;
	}

	public Boolean getMostrarcodigoSucursal() {
		return this.mostrarcodigoSucursal;
	}

	public void setMostrarcodigoSucursal(Boolean mostrarcodigoSucursal) {
		this.mostrarcodigoSucursal= mostrarcodigoSucursal;
	}

	public Boolean getActivarcodigoSucursal() {
		return this.activarcodigoSucursal;
	}

	public void setActivarcodigoSucursal(Boolean activarcodigoSucursal) {
		this.activarcodigoSucursal= activarcodigoSucursal;
	}

	public Border setResaltarnumeroSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarnumeroSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroSucursal() {
		return this.resaltarnumeroSucursal;
	}

	public void setResaltarnumeroSucursal(Border borderResaltar) {
		this.resaltarnumeroSucursal= borderResaltar;
	}

	public Boolean getMostrarnumeroSucursal() {
		return this.mostrarnumeroSucursal;
	}

	public void setMostrarnumeroSucursal(Boolean mostrarnumeroSucursal) {
		this.mostrarnumeroSucursal= mostrarnumeroSucursal;
	}

	public Boolean getActivarnumeroSucursal() {
		return this.activarnumeroSucursal;
	}

	public void setActivarnumeroSucursal(Boolean activarnumeroSucursal) {
		this.activarnumeroSucursal= activarnumeroSucursal;
	}

	public Border setResaltarnombreSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarnombreSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSucursal() {
		return this.resaltarnombreSucursal;
	}

	public void setResaltarnombreSucursal(Border borderResaltar) {
		this.resaltarnombreSucursal= borderResaltar;
	}

	public Boolean getMostrarnombreSucursal() {
		return this.mostrarnombreSucursal;
	}

	public void setMostrarnombreSucursal(Boolean mostrarnombreSucursal) {
		this.mostrarnombreSucursal= mostrarnombreSucursal;
	}

	public Boolean getActivarnombreSucursal() {
		return this.activarnombreSucursal;
	}

	public void setActivarnombreSucursal(Boolean activarnombreSucursal) {
		this.activarnombreSucursal= activarnombreSucursal;
	}

	public Border setResaltardireccionSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltardireccionSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccionSucursal() {
		return this.resaltardireccionSucursal;
	}

	public void setResaltardireccionSucursal(Border borderResaltar) {
		this.resaltardireccionSucursal= borderResaltar;
	}

	public Boolean getMostrardireccionSucursal() {
		return this.mostrardireccionSucursal;
	}

	public void setMostrardireccionSucursal(Boolean mostrardireccionSucursal) {
		this.mostrardireccionSucursal= mostrardireccionSucursal;
	}

	public Boolean getActivardireccionSucursal() {
		return this.activardireccionSucursal;
	}

	public void setActivardireccionSucursal(Boolean activardireccionSucursal) {
		this.activardireccionSucursal= activardireccionSucursal;
	}

	public Border setResaltarrucSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarrucSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucSucursal() {
		return this.resaltarrucSucursal;
	}

	public void setResaltarrucSucursal(Border borderResaltar) {
		this.resaltarrucSucursal= borderResaltar;
	}

	public Boolean getMostrarrucSucursal() {
		return this.mostrarrucSucursal;
	}

	public void setMostrarrucSucursal(Boolean mostrarrucSucursal) {
		this.mostrarrucSucursal= mostrarrucSucursal;
	}

	public Boolean getActivarrucSucursal() {
		return this.activarrucSucursal;
	}

	public void setActivarrucSucursal(Boolean activarrucSucursal) {
		this.activarrucSucursal= activarrucSucursal;
	}

	public Border setResaltartelefonoSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltartelefonoSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoSucursal() {
		return this.resaltartelefonoSucursal;
	}

	public void setResaltartelefonoSucursal(Border borderResaltar) {
		this.resaltartelefonoSucursal= borderResaltar;
	}

	public Boolean getMostrartelefonoSucursal() {
		return this.mostrartelefonoSucursal;
	}

	public void setMostrartelefonoSucursal(Boolean mostrartelefonoSucursal) {
		this.mostrartelefonoSucursal= mostrartelefonoSucursal;
	}

	public Boolean getActivartelefonoSucursal() {
		return this.activartelefonoSucursal;
	}

	public void setActivartelefonoSucursal(Boolean activartelefonoSucursal) {
		this.activartelefonoSucursal= activartelefonoSucursal;
	}

	public Border setResaltarfaxSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarfaxSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfaxSucursal() {
		return this.resaltarfaxSucursal;
	}

	public void setResaltarfaxSucursal(Border borderResaltar) {
		this.resaltarfaxSucursal= borderResaltar;
	}

	public Boolean getMostrarfaxSucursal() {
		return this.mostrarfaxSucursal;
	}

	public void setMostrarfaxSucursal(Boolean mostrarfaxSucursal) {
		this.mostrarfaxSucursal= mostrarfaxSucursal;
	}

	public Boolean getActivarfaxSucursal() {
		return this.activarfaxSucursal;
	}

	public void setActivarfaxSucursal(Boolean activarfaxSucursal) {
		this.activarfaxSucursal= activarfaxSucursal;
	}

	public Border setResaltarmailSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarmailSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmailSucursal() {
		return this.resaltarmailSucursal;
	}

	public void setResaltarmailSucursal(Border borderResaltar) {
		this.resaltarmailSucursal= borderResaltar;
	}

	public Boolean getMostrarmailSucursal() {
		return this.mostrarmailSucursal;
	}

	public void setMostrarmailSucursal(Boolean mostrarmailSucursal) {
		this.mostrarmailSucursal= mostrarmailSucursal;
	}

	public Boolean getActivarmailSucursal() {
		return this.activarmailSucursal;
	}

	public void setActivarmailSucursal(Boolean activarmailSucursal) {
		this.activarmailSucursal= activarmailSucursal;
	}

	public Border setResaltarresponsableSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltarresponsableSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarresponsableSucursal() {
		return this.resaltarresponsableSucursal;
	}

	public void setResaltarresponsableSucursal(Border borderResaltar) {
		this.resaltarresponsableSucursal= borderResaltar;
	}

	public Boolean getMostrarresponsableSucursal() {
		return this.mostrarresponsableSucursal;
	}

	public void setMostrarresponsableSucursal(Boolean mostrarresponsableSucursal) {
		this.mostrarresponsableSucursal= mostrarresponsableSucursal;
	}

	public Boolean getActivarresponsableSucursal() {
		return this.activarresponsableSucursal;
	}

	public void setActivarresponsableSucursal(Boolean activarresponsableSucursal) {
		this.activarresponsableSucursal= activarresponsableSucursal;
	}

	public Border setResaltardescripcionSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//sucursalBeanSwingJInternalFrame.jTtoolBarSucursal.setBorder(borderResaltar);
		
		this.resaltardescripcionSucursal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionSucursal() {
		return this.resaltardescripcionSucursal;
	}

	public void setResaltardescripcionSucursal(Border borderResaltar) {
		this.resaltardescripcionSucursal= borderResaltar;
	}

	public Boolean getMostrardescripcionSucursal() {
		return this.mostrardescripcionSucursal;
	}

	public void setMostrardescripcionSucursal(Boolean mostrardescripcionSucursal) {
		this.mostrardescripcionSucursal= mostrardescripcionSucursal;
	}

	public Boolean getActivardescripcionSucursal() {
		return this.activardescripcionSucursal;
	}

	public void setActivardescripcionSucursal(Boolean activardescripcionSucursal) {
		this.activardescripcionSucursal= activardescripcionSucursal;
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
		
		
		this.setMostraridSucursal(esInicial);
		this.setMostrarid_empresaSucursal(esInicial);
		this.setMostrarid_paisSucursal(esInicial);
		this.setMostrarid_ciudadSucursal(esInicial);
		this.setMostrarcodigoSucursal(esInicial);
		this.setMostrarnumeroSucursal(esInicial);
		this.setMostrarnombreSucursal(esInicial);
		this.setMostrardireccionSucursal(esInicial);
		this.setMostrarrucSucursal(esInicial);
		this.setMostrartelefonoSucursal(esInicial);
		this.setMostrarfaxSucursal(esInicial);
		this.setMostrarmailSucursal(esInicial);
		this.setMostrarresponsableSucursal(esInicial);
		this.setMostrardescripcionSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SucursalConstantesFunciones.ID)) {
				this.setMostraridSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDCIUDAD)) {
				this.setMostrarid_ciudadSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.DIRECCION)) {
				this.setMostrardireccionSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.RUC)) {
				this.setMostrarrucSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.FAX)) {
				this.setMostrarfaxSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.MAIL)) {
				this.setMostrarmailSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.RESPONSABLE)) {
				this.setMostrarresponsableSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionSucursal(esAsigna);
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
		
		
		this.setActivaridSucursal(esInicial);
		this.setActivarid_empresaSucursal(esInicial);
		this.setActivarid_paisSucursal(esInicial);
		this.setActivarid_ciudadSucursal(esInicial);
		this.setActivarcodigoSucursal(esInicial);
		this.setActivarnumeroSucursal(esInicial);
		this.setActivarnombreSucursal(esInicial);
		this.setActivardireccionSucursal(esInicial);
		this.setActivarrucSucursal(esInicial);
		this.setActivartelefonoSucursal(esInicial);
		this.setActivarfaxSucursal(esInicial);
		this.setActivarmailSucursal(esInicial);
		this.setActivarresponsableSucursal(esInicial);
		this.setActivardescripcionSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SucursalConstantesFunciones.ID)) {
				this.setActivaridSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDCIUDAD)) {
				this.setActivarid_ciudadSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.CODIGO)) {
				this.setActivarcodigoSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.NUMERO)) {
				this.setActivarnumeroSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.DIRECCION)) {
				this.setActivardireccionSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.RUC)) {
				this.setActivarrucSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.FAX)) {
				this.setActivarfaxSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.MAIL)) {
				this.setActivarmailSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.RESPONSABLE)) {
				this.setActivarresponsableSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionSucursal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSucursal(esInicial);
		this.setResaltarid_empresaSucursal(esInicial);
		this.setResaltarid_paisSucursal(esInicial);
		this.setResaltarid_ciudadSucursal(esInicial);
		this.setResaltarcodigoSucursal(esInicial);
		this.setResaltarnumeroSucursal(esInicial);
		this.setResaltarnombreSucursal(esInicial);
		this.setResaltardireccionSucursal(esInicial);
		this.setResaltarrucSucursal(esInicial);
		this.setResaltartelefonoSucursal(esInicial);
		this.setResaltarfaxSucursal(esInicial);
		this.setResaltarmailSucursal(esInicial);
		this.setResaltarresponsableSucursal(esInicial);
		this.setResaltardescripcionSucursal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SucursalConstantesFunciones.ID)) {
				this.setResaltaridSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.IDCIUDAD)) {
				this.setResaltarid_ciudadSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.DIRECCION)) {
				this.setResaltardireccionSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.RUC)) {
				this.setResaltarrucSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.FAX)) {
				this.setResaltarfaxSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.MAIL)) {
				this.setResaltarmailSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.RESPONSABLE)) {
				this.setResaltarresponsableSucursal(esAsigna);
				continue;
			}

			if(campo.clase.equals(SucursalConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionSucursal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaSucursal=true;

	public Boolean getMostrarFK_IdEmpresaSucursal() {
		return this.mostrarFK_IdEmpresaSucursal;
	}

	public void setMostrarFK_IdEmpresaSucursal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSucursal= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPaisSucursal=true;

	public Boolean getMostrarFK_IdPaisSucursal() {
		return this.mostrarFK_IdPaisSucursal;
	}

	public void setMostrarFK_IdPaisSucursal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisSucursal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaSucursal=true;

	public Boolean getActivarFK_IdEmpresaSucursal() {
		return this.activarFK_IdEmpresaSucursal;
	}

	public void setActivarFK_IdEmpresaSucursal(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSucursal= habilitarResaltar;
	}

	public Boolean activarFK_IdPaisSucursal=true;

	public Boolean getActivarFK_IdPaisSucursal() {
		return this.activarFK_IdPaisSucursal;
	}

	public void setActivarFK_IdPaisSucursal(Boolean habilitarResaltar) {
		this.activarFK_IdPaisSucursal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaSucursal=null;

	public Border getResaltarFK_IdEmpresaSucursal() {
		return this.resaltarFK_IdEmpresaSucursal;
	}

	public void setResaltarFK_IdEmpresaSucursal(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSucursal= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSucursal= borderResaltar;
	}

	public Border resaltarFK_IdPaisSucursal=null;

	public Border getResaltarFK_IdPaisSucursal() {
		return this.resaltarFK_IdPaisSucursal;
	}

	public void setResaltarFK_IdPaisSucursal(Border borderResaltar) {
		this.resaltarFK_IdPaisSucursal= borderResaltar;
	}

	public void setResaltarFK_IdPaisSucursal(ParametroGeneralUsuario parametroGeneralUsuario/*SucursalBeanSwingJInternalFrame sucursalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisSucursal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}