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


import com.bydan.erp.cartera.util.TransaccionClienteConstantesFunciones;
import com.bydan.erp.cartera.util.TransaccionClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TransaccionClienteParameterGeneral;

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
final public class TransaccionClienteConstantesFunciones extends TransaccionClienteConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TransaccionCliente";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TransaccionCliente"+TransaccionClienteConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransaccionClienteHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransaccionClienteHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransaccionClienteConstantesFunciones.SCHEMA+"_"+TransaccionClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransaccionClienteConstantesFunciones.SCHEMA+"_"+TransaccionClienteConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransaccionClienteConstantesFunciones.SCHEMA+"_"+TransaccionClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransaccionClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransaccionClienteConstantesFunciones.SCHEMA+"_"+TransaccionClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionClienteHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionClienteConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransaccionClienteHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransaccionClienteConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransaccionClienteConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransaccionClienteConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransaccionClienteConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransaccionClienteConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Analisis Transaccion Clientes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Analisis Transaccion Cliente";
	public static final String SCLASSWEBTITULO_LOWER="Transaccion Cliente";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TransaccionCliente";
	public static final String OBJECTNAME="transaccioncliente";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="transaccion_cliente";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transaccioncliente from "+TransaccionClienteConstantesFunciones.SPERSISTENCENAME+" transaccioncliente";
	public static String QUERYSELECTNATIVE="select "+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".id,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".version_row,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".id_empresa,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".id_modulo,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".nombre,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".id_transaccion1,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".id_transaccion2,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".id_transaccion3,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".id_transaccion4,"+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME+".id_transaccion5 from "+TransaccionClienteConstantesFunciones.SCHEMA+"."+TransaccionClienteConstantesFunciones.TABLENAME;//+" as "+TransaccionClienteConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TransaccionClienteConstantesFuncionesAdditional transaccionclienteConstantesFuncionesAdditional=null;
	
	public TransaccionClienteConstantesFuncionesAdditional getTransaccionClienteConstantesFuncionesAdditional() {
		return this.transaccionclienteConstantesFuncionesAdditional;
	}
	
	public void setTransaccionClienteConstantesFuncionesAdditional(TransaccionClienteConstantesFuncionesAdditional transaccionclienteConstantesFuncionesAdditional) {
		try {
			this.transaccionclienteConstantesFuncionesAdditional=transaccionclienteConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String NOMBRE= "nombre";
    public static final String IDTRANSACCION1= "id_transaccion1";
    public static final String IDTRANSACCION2= "id_transaccion2";
    public static final String IDTRANSACCION3= "id_transaccion3";
    public static final String IDTRANSACCION4= "id_transaccion4";
    public static final String IDTRANSACCION5= "id_transaccion5";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDTRANSACCION1= "Transaccion1";
		public static final String LABEL_IDTRANSACCION1_LOWER= "Transaccion1";
    	public static final String LABEL_IDTRANSACCION2= "Transaccion2";
		public static final String LABEL_IDTRANSACCION2_LOWER= "Transaccion2";
    	public static final String LABEL_IDTRANSACCION3= "Transaccion3";
		public static final String LABEL_IDTRANSACCION3_LOWER= "Transaccion3";
    	public static final String LABEL_IDTRANSACCION4= "Transaccion4";
		public static final String LABEL_IDTRANSACCION4_LOWER= "Transaccion4";
    	public static final String LABEL_IDTRANSACCION5= "Transaccion5";
		public static final String LABEL_IDTRANSACCION5_LOWER= "Transaccion5";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getTransaccionClienteLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransaccionClienteConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransaccionClienteConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransaccionClienteConstantesFunciones.IDMODULO)) {sLabelColumna=TransaccionClienteConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TransaccionClienteConstantesFunciones.NOMBRE)) {sLabelColumna=TransaccionClienteConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION1)) {sLabelColumna=TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION1;}
		if(sNombreColumna.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION2)) {sLabelColumna=TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION2;}
		if(sNombreColumna.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION3)) {sLabelColumna=TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION3;}
		if(sNombreColumna.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION4)) {sLabelColumna=TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION4;}
		if(sNombreColumna.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION5)) {sLabelColumna=TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION5;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getTransaccionClienteDescripcion(TransaccionCliente transaccioncliente) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transaccioncliente !=null/* && transaccioncliente.getId()!=0*/) {
			sDescripcion=transaccioncliente.getnombre();//transaccionclientetransaccioncliente.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransaccionClienteDescripcionDetallado(TransaccionCliente transaccioncliente) {
		String sDescripcion="";
			
		sDescripcion+=TransaccionClienteConstantesFunciones.ID+"=";
		sDescripcion+=transaccioncliente.getId().toString()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transaccioncliente.getVersionRow().toString()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transaccioncliente.getid_empresa().toString()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.IDMODULO+"=";
		sDescripcion+=transaccioncliente.getid_modulo().toString()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.NOMBRE+"=";
		sDescripcion+=transaccioncliente.getnombre()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.IDTRANSACCION1+"=";
		sDescripcion+=transaccioncliente.getid_transaccion1().toString()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.IDTRANSACCION2+"=";
		sDescripcion+=transaccioncliente.getid_transaccion2().toString()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.IDTRANSACCION3+"=";
		sDescripcion+=transaccioncliente.getid_transaccion3().toString()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.IDTRANSACCION4+"=";
		sDescripcion+=transaccioncliente.getid_transaccion4().toString()+",";
		sDescripcion+=TransaccionClienteConstantesFunciones.IDTRANSACCION5+"=";
		sDescripcion+=transaccioncliente.getid_transaccion5().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTransaccionClienteDescripcion(TransaccionCliente transaccioncliente,String sValor) throws Exception {			
		if(transaccioncliente !=null) {
			transaccioncliente.setnombre(sValor);//transaccionclientetransaccioncliente.getId().toString();
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
		} else if(sNombreIndice.equals("FK_IdTransaccion1")) {
			sNombreIndice="Tipo=  Por Transaccion1";
		} else if(sNombreIndice.equals("FK_IdTransaccion2")) {
			sNombreIndice="Tipo=  Por Transaccion2";
		} else if(sNombreIndice.equals("FK_IdTransaccion3")) {
			sNombreIndice="Tipo=  Por Transaccion3";
		} else if(sNombreIndice.equals("FK_IdTransaccion4")) {
			sNombreIndice="Tipo=  Por Transaccion4";
		} else if(sNombreIndice.equals("FK_IdTransaccion5")) {
			sNombreIndice="Tipo=  Por Transaccion5";
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

	public static String getDetalleIndiceFK_IdTransaccion1(Long id_transaccion1) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion1!=null) {sDetalleIndice+=" Codigo Unico De Transaccion1="+id_transaccion1.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion2(Long id_transaccion2) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion2!=null) {sDetalleIndice+=" Codigo Unico De Transaccion2="+id_transaccion2.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion3(Long id_transaccion3) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion3!=null) {sDetalleIndice+=" Codigo Unico De Transaccion3="+id_transaccion3.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion4(Long id_transaccion4) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion4!=null) {sDetalleIndice+=" Codigo Unico De Transaccion4="+id_transaccion4.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion5(Long id_transaccion5) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion5!=null) {sDetalleIndice+=" Codigo Unico De Transaccion5="+id_transaccion5.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTransaccionCliente(TransaccionCliente transaccioncliente,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transaccioncliente.setnombre(transaccioncliente.getnombre().trim());
	}
	
	public static void quitarEspaciosTransaccionClientes(List<TransaccionCliente> transaccionclientes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TransaccionCliente transaccioncliente: transaccionclientes) {
			transaccioncliente.setnombre(transaccioncliente.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionCliente(TransaccionCliente transaccioncliente,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transaccioncliente.getConCambioAuxiliar()) {
			transaccioncliente.setIsDeleted(transaccioncliente.getIsDeletedAuxiliar());	
			transaccioncliente.setIsNew(transaccioncliente.getIsNewAuxiliar());	
			transaccioncliente.setIsChanged(transaccioncliente.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transaccioncliente.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transaccioncliente.setIsDeletedAuxiliar(false);	
			transaccioncliente.setIsNewAuxiliar(false);	
			transaccioncliente.setIsChangedAuxiliar(false);
			
			transaccioncliente.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransaccionClientes(List<TransaccionCliente> transaccionclientes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TransaccionCliente transaccioncliente : transaccionclientes) {
			if(conAsignarBase && transaccioncliente.getConCambioAuxiliar()) {
				transaccioncliente.setIsDeleted(transaccioncliente.getIsDeletedAuxiliar());	
				transaccioncliente.setIsNew(transaccioncliente.getIsNewAuxiliar());	
				transaccioncliente.setIsChanged(transaccioncliente.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transaccioncliente.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transaccioncliente.setIsDeletedAuxiliar(false);	
				transaccioncliente.setIsNewAuxiliar(false);	
				transaccioncliente.setIsChangedAuxiliar(false);
				
				transaccioncliente.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransaccionCliente(TransaccionCliente transaccioncliente,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransaccionClientes(List<TransaccionCliente> transaccionclientes,Boolean conEnteros) throws Exception  {
		
		for(TransaccionCliente transaccioncliente: transaccionclientes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransaccionCliente(List<TransaccionCliente> transaccionclientes,TransaccionCliente transaccionclienteAux) throws Exception  {
		TransaccionClienteConstantesFunciones.InicializarValoresTransaccionCliente(transaccionclienteAux,true);
		
		for(TransaccionCliente transaccioncliente: transaccionclientes) {
			if(transaccioncliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransaccionClienteConstantesFunciones.getArrayColumnasGlobalesTransaccionCliente(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransaccionCliente(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionClienteConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionClienteConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransaccionClienteConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransaccionClienteConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransaccionCliente(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TransaccionCliente> transaccionclientes,TransaccionCliente transaccioncliente,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TransaccionCliente transaccionclienteAux: transaccionclientes) {
			if(transaccionclienteAux!=null && transaccioncliente!=null) {
				if((transaccionclienteAux.getId()==null && transaccioncliente.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transaccionclienteAux.getId()!=null && transaccioncliente.getId()!=null){
					if(transaccionclienteAux.getId().equals(transaccioncliente.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransaccionCliente(List<TransaccionCliente> transaccionclientes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TransaccionCliente transaccioncliente: transaccionclientes) {			
			if(transaccioncliente.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransaccionCliente() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_ID, TransaccionClienteConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_VERSIONROW, TransaccionClienteConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_IDEMPRESA, TransaccionClienteConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_IDMODULO, TransaccionClienteConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_NOMBRE, TransaccionClienteConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION1, TransaccionClienteConstantesFunciones.IDTRANSACCION1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION2, TransaccionClienteConstantesFunciones.IDTRANSACCION2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION3, TransaccionClienteConstantesFunciones.IDTRANSACCION3,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION4, TransaccionClienteConstantesFunciones.IDTRANSACCION4,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION5, TransaccionClienteConstantesFunciones.IDTRANSACCION5,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransaccionCliente() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.IDTRANSACCION1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.IDTRANSACCION2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.IDTRANSACCION3;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.IDTRANSACCION4;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransaccionClienteConstantesFunciones.IDTRANSACCION5;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionCliente() throws Exception  {
		return TransaccionClienteConstantesFunciones.getTiposSeleccionarTransaccionCliente(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionCliente(Boolean conFk) throws Exception  {
		return TransaccionClienteConstantesFunciones.getTiposSeleccionarTransaccionCliente(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransaccionCliente(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionClienteConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransaccionClienteConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionClienteConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TransaccionClienteConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionClienteConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TransaccionClienteConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION1);
			reporte.setsDescripcion(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION2);
			reporte.setsDescripcion(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION3);
			reporte.setsDescripcion(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION4);
			reporte.setsDescripcion(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION4);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION5);
			reporte.setsDescripcion(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION5);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransaccionCliente(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionCliente(TransaccionCliente transaccionclienteAux) throws Exception {
		
			transaccionclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccionclienteAux.getEmpresa()));
			transaccionclienteAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(transaccionclienteAux.getModulo()));
			transaccionclienteAux.settransaccion1_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion1()));
			transaccionclienteAux.settransaccion2_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion2()));
			transaccionclienteAux.settransaccion3_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion3()));
			transaccionclienteAux.settransaccion4_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion4()));
			transaccionclienteAux.settransaccion5_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion5()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransaccionCliente(List<TransaccionCliente> transaccionclientesTemp) throws Exception {
		for(TransaccionCliente transaccionclienteAux:transaccionclientesTemp) {
			
			transaccionclienteAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transaccionclienteAux.getEmpresa()));
			transaccionclienteAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(transaccionclienteAux.getModulo()));
			transaccionclienteAux.settransaccion1_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion1()));
			transaccionclienteAux.settransaccion2_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion2()));
			transaccionclienteAux.settransaccion3_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion3()));
			transaccionclienteAux.settransaccion4_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion4()));
			transaccionclienteAux.settransaccion5_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(transaccionclienteAux.getTransaccion5()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransaccionCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionClienteConstantesFunciones.getClassesRelationshipsOfTransaccionCliente(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransaccionClienteConstantesFunciones.getClassesRelationshipsFromStringsOfTransaccionCliente(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransaccionCliente(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TransaccionCliente transaccioncliente,List<TransaccionCliente> transaccionclientes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TransaccionCliente transaccionclienteEncontrado=null;
			
			for(TransaccionCliente transaccionclienteLocal:transaccionclientes) {
				if(transaccionclienteLocal.getId().equals(transaccioncliente.getId())) {
					transaccionclienteEncontrado=transaccionclienteLocal;
					
					transaccionclienteLocal.setIsChanged(transaccioncliente.getIsChanged());
					transaccionclienteLocal.setIsNew(transaccioncliente.getIsNew());
					transaccionclienteLocal.setIsDeleted(transaccioncliente.getIsDeleted());
					
					transaccionclienteLocal.setGeneralEntityOriginal(transaccioncliente.getGeneralEntityOriginal());
					
					transaccionclienteLocal.setId(transaccioncliente.getId());	
					transaccionclienteLocal.setVersionRow(transaccioncliente.getVersionRow());	
					transaccionclienteLocal.setid_empresa(transaccioncliente.getid_empresa());	
					transaccionclienteLocal.setid_modulo(transaccioncliente.getid_modulo());	
					transaccionclienteLocal.setnombre(transaccioncliente.getnombre());	
					transaccionclienteLocal.setid_transaccion1(transaccioncliente.getid_transaccion1());	
					transaccionclienteLocal.setid_transaccion2(transaccioncliente.getid_transaccion2());	
					transaccionclienteLocal.setid_transaccion3(transaccioncliente.getid_transaccion3());	
					transaccionclienteLocal.setid_transaccion4(transaccioncliente.getid_transaccion4());	
					transaccionclienteLocal.setid_transaccion5(transaccioncliente.getid_transaccion5());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!transaccioncliente.getIsDeleted()) {
				if(!existe) {
					transaccionclientes.add(transaccioncliente);
				}
			} else {
				if(transaccionclienteEncontrado!=null && permiteQuitar)  {
					transaccionclientes.remove(transaccionclienteEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TransaccionCliente transaccioncliente,List<TransaccionCliente> transaccionclientes) throws Exception {
		try	{			
			for(TransaccionCliente transaccionclienteLocal:transaccionclientes) {
				if(transaccionclienteLocal.getId().equals(transaccioncliente.getId())) {
					transaccionclienteLocal.setIsSelected(transaccioncliente.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransaccionCliente(List<TransaccionCliente> transaccionclientesAux) throws Exception {
		//this.transaccionclientesAux=transaccionclientesAux;
		
		for(TransaccionCliente transaccionclienteAux:transaccionclientesAux) {
			if(transaccionclienteAux.getIsChanged()) {
				transaccionclienteAux.setIsChanged(false);
			}		
			
			if(transaccionclienteAux.getIsNew()) {
				transaccionclienteAux.setIsNew(false);
			}	
			
			if(transaccionclienteAux.getIsDeleted()) {
				transaccionclienteAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransaccionCliente(TransaccionCliente transaccionclienteAux) throws Exception {
		//this.transaccionclienteAux=transaccionclienteAux;
		
			if(transaccionclienteAux.getIsChanged()) {
				transaccionclienteAux.setIsChanged(false);
			}		
			
			if(transaccionclienteAux.getIsNew()) {
				transaccionclienteAux.setIsNew(false);
			}	
			
			if(transaccionclienteAux.getIsDeleted()) {
				transaccionclienteAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TransaccionCliente transaccionclienteAsignar,TransaccionCliente transaccioncliente) throws Exception {
		transaccionclienteAsignar.setId(transaccioncliente.getId());	
		transaccionclienteAsignar.setVersionRow(transaccioncliente.getVersionRow());	
		transaccionclienteAsignar.setid_empresa(transaccioncliente.getid_empresa());
		transaccionclienteAsignar.setempresa_descripcion(transaccioncliente.getempresa_descripcion());	
		transaccionclienteAsignar.setid_modulo(transaccioncliente.getid_modulo());
		transaccionclienteAsignar.setmodulo_descripcion(transaccioncliente.getmodulo_descripcion());	
		transaccionclienteAsignar.setnombre(transaccioncliente.getnombre());	
		transaccionclienteAsignar.setid_transaccion1(transaccioncliente.getid_transaccion1());
		transaccionclienteAsignar.settransaccion1_descripcion(transaccioncliente.gettransaccion1_descripcion());	
		transaccionclienteAsignar.setid_transaccion2(transaccioncliente.getid_transaccion2());
		transaccionclienteAsignar.settransaccion2_descripcion(transaccioncliente.gettransaccion2_descripcion());	
		transaccionclienteAsignar.setid_transaccion3(transaccioncliente.getid_transaccion3());
		transaccionclienteAsignar.settransaccion3_descripcion(transaccioncliente.gettransaccion3_descripcion());	
		transaccionclienteAsignar.setid_transaccion4(transaccioncliente.getid_transaccion4());
		transaccionclienteAsignar.settransaccion4_descripcion(transaccioncliente.gettransaccion4_descripcion());	
		transaccionclienteAsignar.setid_transaccion5(transaccioncliente.getid_transaccion5());
		transaccionclienteAsignar.settransaccion5_descripcion(transaccioncliente.gettransaccion5_descripcion());	
	}
	
	public static void inicializarTransaccionCliente(TransaccionCliente transaccioncliente) throws Exception {
		try {
				transaccioncliente.setId(0L);	
					
				transaccioncliente.setid_empresa(-1L);	
				transaccioncliente.setid_modulo(-1L);	
				transaccioncliente.setnombre("");	
				transaccioncliente.setid_transaccion1(-1L);	
				transaccioncliente.setid_transaccion2(null);	
				transaccioncliente.setid_transaccion3(null);	
				transaccioncliente.setid_transaccion4(null);	
				transaccioncliente.setid_transaccion5(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransaccionCliente(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionClienteConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionClienteConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionClienteConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION3);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION4);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransaccionClienteConstantesFunciones.LABEL_IDTRANSACCION5);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransaccionCliente(String sTipo,Row row,Workbook workbook,TransaccionCliente transaccioncliente,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioncliente.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioncliente.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioncliente.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioncliente.gettransaccion1_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioncliente.gettransaccion2_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioncliente.gettransaccion3_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioncliente.gettransaccion4_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transaccioncliente.gettransaccion5_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransaccionCliente=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTransaccionCliente() {
		return this.sFinalQueryTransaccionCliente;
	}
	
	public void setsFinalQueryTransaccionCliente(String sFinalQueryTransaccionCliente) {
		this.sFinalQueryTransaccionCliente= sFinalQueryTransaccionCliente;
	}
	
	public Border resaltarSeleccionarTransaccionCliente=null;
	
	public Border setResaltarSeleccionarTransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransaccionCliente= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransaccionCliente() {
		return this.resaltarSeleccionarTransaccionCliente;
	}
	
	public void setResaltarSeleccionarTransaccionCliente(Border borderResaltarSeleccionarTransaccionCliente) {
		this.resaltarSeleccionarTransaccionCliente= borderResaltarSeleccionarTransaccionCliente;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransaccionCliente=null;
	public Boolean mostraridTransaccionCliente=true;
	public Boolean activaridTransaccionCliente=true;

	public Border resaltarid_empresaTransaccionCliente=null;
	public Boolean mostrarid_empresaTransaccionCliente=true;
	public Boolean activarid_empresaTransaccionCliente=true;
	public Boolean cargarid_empresaTransaccionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransaccionCliente=false;//ConEventDepend=true

	public Border resaltarid_moduloTransaccionCliente=null;
	public Boolean mostrarid_moduloTransaccionCliente=true;
	public Boolean activarid_moduloTransaccionCliente=true;
	public Boolean cargarid_moduloTransaccionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTransaccionCliente=false;//ConEventDepend=true

	public Border resaltarnombreTransaccionCliente=null;
	public Boolean mostrarnombreTransaccionCliente=true;
	public Boolean activarnombreTransaccionCliente=true;

	public Border resaltarid_transaccion1TransaccionCliente=null;
	public Boolean mostrarid_transaccion1TransaccionCliente=true;
	public Boolean activarid_transaccion1TransaccionCliente=true;
	public Boolean cargarid_transaccion1TransaccionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion1TransaccionCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion2TransaccionCliente=null;
	public Boolean mostrarid_transaccion2TransaccionCliente=true;
	public Boolean activarid_transaccion2TransaccionCliente=true;
	public Boolean cargarid_transaccion2TransaccionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion2TransaccionCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion3TransaccionCliente=null;
	public Boolean mostrarid_transaccion3TransaccionCliente=true;
	public Boolean activarid_transaccion3TransaccionCliente=true;
	public Boolean cargarid_transaccion3TransaccionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion3TransaccionCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion4TransaccionCliente=null;
	public Boolean mostrarid_transaccion4TransaccionCliente=true;
	public Boolean activarid_transaccion4TransaccionCliente=true;
	public Boolean cargarid_transaccion4TransaccionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion4TransaccionCliente=false;//ConEventDepend=true

	public Border resaltarid_transaccion5TransaccionCliente=null;
	public Boolean mostrarid_transaccion5TransaccionCliente=true;
	public Boolean activarid_transaccion5TransaccionCliente=true;
	public Boolean cargarid_transaccion5TransaccionCliente=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccion5TransaccionCliente=false;//ConEventDepend=true

	
	

	public Border setResaltaridTransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltaridTransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransaccionCliente() {
		return this.resaltaridTransaccionCliente;
	}

	public void setResaltaridTransaccionCliente(Border borderResaltar) {
		this.resaltaridTransaccionCliente= borderResaltar;
	}

	public Boolean getMostraridTransaccionCliente() {
		return this.mostraridTransaccionCliente;
	}

	public void setMostraridTransaccionCliente(Boolean mostraridTransaccionCliente) {
		this.mostraridTransaccionCliente= mostraridTransaccionCliente;
	}

	public Boolean getActivaridTransaccionCliente() {
		return this.activaridTransaccionCliente;
	}

	public void setActivaridTransaccionCliente(Boolean activaridTransaccionCliente) {
		this.activaridTransaccionCliente= activaridTransaccionCliente;
	}

	public Border setResaltarid_empresaTransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransaccionCliente() {
		return this.resaltarid_empresaTransaccionCliente;
	}

	public void setResaltarid_empresaTransaccionCliente(Border borderResaltar) {
		this.resaltarid_empresaTransaccionCliente= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransaccionCliente() {
		return this.mostrarid_empresaTransaccionCliente;
	}

	public void setMostrarid_empresaTransaccionCliente(Boolean mostrarid_empresaTransaccionCliente) {
		this.mostrarid_empresaTransaccionCliente= mostrarid_empresaTransaccionCliente;
	}

	public Boolean getActivarid_empresaTransaccionCliente() {
		return this.activarid_empresaTransaccionCliente;
	}

	public void setActivarid_empresaTransaccionCliente(Boolean activarid_empresaTransaccionCliente) {
		this.activarid_empresaTransaccionCliente= activarid_empresaTransaccionCliente;
	}

	public Boolean getCargarid_empresaTransaccionCliente() {
		return this.cargarid_empresaTransaccionCliente;
	}

	public void setCargarid_empresaTransaccionCliente(Boolean cargarid_empresaTransaccionCliente) {
		this.cargarid_empresaTransaccionCliente= cargarid_empresaTransaccionCliente;
	}

	public Border setResaltarid_moduloTransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarid_moduloTransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTransaccionCliente() {
		return this.resaltarid_moduloTransaccionCliente;
	}

	public void setResaltarid_moduloTransaccionCliente(Border borderResaltar) {
		this.resaltarid_moduloTransaccionCliente= borderResaltar;
	}

	public Boolean getMostrarid_moduloTransaccionCliente() {
		return this.mostrarid_moduloTransaccionCliente;
	}

	public void setMostrarid_moduloTransaccionCliente(Boolean mostrarid_moduloTransaccionCliente) {
		this.mostrarid_moduloTransaccionCliente= mostrarid_moduloTransaccionCliente;
	}

	public Boolean getActivarid_moduloTransaccionCliente() {
		return this.activarid_moduloTransaccionCliente;
	}

	public void setActivarid_moduloTransaccionCliente(Boolean activarid_moduloTransaccionCliente) {
		this.activarid_moduloTransaccionCliente= activarid_moduloTransaccionCliente;
	}

	public Boolean getCargarid_moduloTransaccionCliente() {
		return this.cargarid_moduloTransaccionCliente;
	}

	public void setCargarid_moduloTransaccionCliente(Boolean cargarid_moduloTransaccionCliente) {
		this.cargarid_moduloTransaccionCliente= cargarid_moduloTransaccionCliente;
	}

	public Border setResaltarnombreTransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarnombreTransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTransaccionCliente() {
		return this.resaltarnombreTransaccionCliente;
	}

	public void setResaltarnombreTransaccionCliente(Border borderResaltar) {
		this.resaltarnombreTransaccionCliente= borderResaltar;
	}

	public Boolean getMostrarnombreTransaccionCliente() {
		return this.mostrarnombreTransaccionCliente;
	}

	public void setMostrarnombreTransaccionCliente(Boolean mostrarnombreTransaccionCliente) {
		this.mostrarnombreTransaccionCliente= mostrarnombreTransaccionCliente;
	}

	public Boolean getActivarnombreTransaccionCliente() {
		return this.activarnombreTransaccionCliente;
	}

	public void setActivarnombreTransaccionCliente(Boolean activarnombreTransaccionCliente) {
		this.activarnombreTransaccionCliente= activarnombreTransaccionCliente;
	}

	public Border setResaltarid_transaccion1TransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion1TransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion1TransaccionCliente() {
		return this.resaltarid_transaccion1TransaccionCliente;
	}

	public void setResaltarid_transaccion1TransaccionCliente(Border borderResaltar) {
		this.resaltarid_transaccion1TransaccionCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion1TransaccionCliente() {
		return this.mostrarid_transaccion1TransaccionCliente;
	}

	public void setMostrarid_transaccion1TransaccionCliente(Boolean mostrarid_transaccion1TransaccionCliente) {
		this.mostrarid_transaccion1TransaccionCliente= mostrarid_transaccion1TransaccionCliente;
	}

	public Boolean getActivarid_transaccion1TransaccionCliente() {
		return this.activarid_transaccion1TransaccionCliente;
	}

	public void setActivarid_transaccion1TransaccionCliente(Boolean activarid_transaccion1TransaccionCliente) {
		this.activarid_transaccion1TransaccionCliente= activarid_transaccion1TransaccionCliente;
	}

	public Boolean getCargarid_transaccion1TransaccionCliente() {
		return this.cargarid_transaccion1TransaccionCliente;
	}

	public void setCargarid_transaccion1TransaccionCliente(Boolean cargarid_transaccion1TransaccionCliente) {
		this.cargarid_transaccion1TransaccionCliente= cargarid_transaccion1TransaccionCliente;
	}

	public Border setResaltarid_transaccion2TransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion2TransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion2TransaccionCliente() {
		return this.resaltarid_transaccion2TransaccionCliente;
	}

	public void setResaltarid_transaccion2TransaccionCliente(Border borderResaltar) {
		this.resaltarid_transaccion2TransaccionCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion2TransaccionCliente() {
		return this.mostrarid_transaccion2TransaccionCliente;
	}

	public void setMostrarid_transaccion2TransaccionCliente(Boolean mostrarid_transaccion2TransaccionCliente) {
		this.mostrarid_transaccion2TransaccionCliente= mostrarid_transaccion2TransaccionCliente;
	}

	public Boolean getActivarid_transaccion2TransaccionCliente() {
		return this.activarid_transaccion2TransaccionCliente;
	}

	public void setActivarid_transaccion2TransaccionCliente(Boolean activarid_transaccion2TransaccionCliente) {
		this.activarid_transaccion2TransaccionCliente= activarid_transaccion2TransaccionCliente;
	}

	public Boolean getCargarid_transaccion2TransaccionCliente() {
		return this.cargarid_transaccion2TransaccionCliente;
	}

	public void setCargarid_transaccion2TransaccionCliente(Boolean cargarid_transaccion2TransaccionCliente) {
		this.cargarid_transaccion2TransaccionCliente= cargarid_transaccion2TransaccionCliente;
	}

	public Border setResaltarid_transaccion3TransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion3TransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion3TransaccionCliente() {
		return this.resaltarid_transaccion3TransaccionCliente;
	}

	public void setResaltarid_transaccion3TransaccionCliente(Border borderResaltar) {
		this.resaltarid_transaccion3TransaccionCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion3TransaccionCliente() {
		return this.mostrarid_transaccion3TransaccionCliente;
	}

	public void setMostrarid_transaccion3TransaccionCliente(Boolean mostrarid_transaccion3TransaccionCliente) {
		this.mostrarid_transaccion3TransaccionCliente= mostrarid_transaccion3TransaccionCliente;
	}

	public Boolean getActivarid_transaccion3TransaccionCliente() {
		return this.activarid_transaccion3TransaccionCliente;
	}

	public void setActivarid_transaccion3TransaccionCliente(Boolean activarid_transaccion3TransaccionCliente) {
		this.activarid_transaccion3TransaccionCliente= activarid_transaccion3TransaccionCliente;
	}

	public Boolean getCargarid_transaccion3TransaccionCliente() {
		return this.cargarid_transaccion3TransaccionCliente;
	}

	public void setCargarid_transaccion3TransaccionCliente(Boolean cargarid_transaccion3TransaccionCliente) {
		this.cargarid_transaccion3TransaccionCliente= cargarid_transaccion3TransaccionCliente;
	}

	public Border setResaltarid_transaccion4TransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion4TransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion4TransaccionCliente() {
		return this.resaltarid_transaccion4TransaccionCliente;
	}

	public void setResaltarid_transaccion4TransaccionCliente(Border borderResaltar) {
		this.resaltarid_transaccion4TransaccionCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion4TransaccionCliente() {
		return this.mostrarid_transaccion4TransaccionCliente;
	}

	public void setMostrarid_transaccion4TransaccionCliente(Boolean mostrarid_transaccion4TransaccionCliente) {
		this.mostrarid_transaccion4TransaccionCliente= mostrarid_transaccion4TransaccionCliente;
	}

	public Boolean getActivarid_transaccion4TransaccionCliente() {
		return this.activarid_transaccion4TransaccionCliente;
	}

	public void setActivarid_transaccion4TransaccionCliente(Boolean activarid_transaccion4TransaccionCliente) {
		this.activarid_transaccion4TransaccionCliente= activarid_transaccion4TransaccionCliente;
	}

	public Boolean getCargarid_transaccion4TransaccionCliente() {
		return this.cargarid_transaccion4TransaccionCliente;
	}

	public void setCargarid_transaccion4TransaccionCliente(Boolean cargarid_transaccion4TransaccionCliente) {
		this.cargarid_transaccion4TransaccionCliente= cargarid_transaccion4TransaccionCliente;
	}

	public Border setResaltarid_transaccion5TransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transaccionclienteBeanSwingJInternalFrame.jTtoolBarTransaccionCliente.setBorder(borderResaltar);
		
		this.resaltarid_transaccion5TransaccionCliente= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccion5TransaccionCliente() {
		return this.resaltarid_transaccion5TransaccionCliente;
	}

	public void setResaltarid_transaccion5TransaccionCliente(Border borderResaltar) {
		this.resaltarid_transaccion5TransaccionCliente= borderResaltar;
	}

	public Boolean getMostrarid_transaccion5TransaccionCliente() {
		return this.mostrarid_transaccion5TransaccionCliente;
	}

	public void setMostrarid_transaccion5TransaccionCliente(Boolean mostrarid_transaccion5TransaccionCliente) {
		this.mostrarid_transaccion5TransaccionCliente= mostrarid_transaccion5TransaccionCliente;
	}

	public Boolean getActivarid_transaccion5TransaccionCliente() {
		return this.activarid_transaccion5TransaccionCliente;
	}

	public void setActivarid_transaccion5TransaccionCliente(Boolean activarid_transaccion5TransaccionCliente) {
		this.activarid_transaccion5TransaccionCliente= activarid_transaccion5TransaccionCliente;
	}

	public Boolean getCargarid_transaccion5TransaccionCliente() {
		return this.cargarid_transaccion5TransaccionCliente;
	}

	public void setCargarid_transaccion5TransaccionCliente(Boolean cargarid_transaccion5TransaccionCliente) {
		this.cargarid_transaccion5TransaccionCliente= cargarid_transaccion5TransaccionCliente;
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
		
		
		this.setMostraridTransaccionCliente(esInicial);
		this.setMostrarid_empresaTransaccionCliente(esInicial);
		this.setMostrarid_moduloTransaccionCliente(esInicial);
		this.setMostrarnombreTransaccionCliente(esInicial);
		this.setMostrarid_transaccion1TransaccionCliente(esInicial);
		this.setMostrarid_transaccion2TransaccionCliente(esInicial);
		this.setMostrarid_transaccion3TransaccionCliente(esInicial);
		this.setMostrarid_transaccion4TransaccionCliente(esInicial);
		this.setMostrarid_transaccion5TransaccionCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.ID)) {
				this.setMostraridTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION1)) {
				this.setMostrarid_transaccion1TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION2)) {
				this.setMostrarid_transaccion2TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION3)) {
				this.setMostrarid_transaccion3TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION4)) {
				this.setMostrarid_transaccion4TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION5)) {
				this.setMostrarid_transaccion5TransaccionCliente(esAsigna);
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
		
		
		this.setActivaridTransaccionCliente(esInicial);
		this.setActivarid_empresaTransaccionCliente(esInicial);
		this.setActivarid_moduloTransaccionCliente(esInicial);
		this.setActivarnombreTransaccionCliente(esInicial);
		this.setActivarid_transaccion1TransaccionCliente(esInicial);
		this.setActivarid_transaccion2TransaccionCliente(esInicial);
		this.setActivarid_transaccion3TransaccionCliente(esInicial);
		this.setActivarid_transaccion4TransaccionCliente(esInicial);
		this.setActivarid_transaccion5TransaccionCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.ID)) {
				this.setActivaridTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION1)) {
				this.setActivarid_transaccion1TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION2)) {
				this.setActivarid_transaccion2TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION3)) {
				this.setActivarid_transaccion3TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION4)) {
				this.setActivarid_transaccion4TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION5)) {
				this.setActivarid_transaccion5TransaccionCliente(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransaccionCliente(esInicial);
		this.setResaltarid_empresaTransaccionCliente(esInicial);
		this.setResaltarid_moduloTransaccionCliente(esInicial);
		this.setResaltarnombreTransaccionCliente(esInicial);
		this.setResaltarid_transaccion1TransaccionCliente(esInicial);
		this.setResaltarid_transaccion2TransaccionCliente(esInicial);
		this.setResaltarid_transaccion3TransaccionCliente(esInicial);
		this.setResaltarid_transaccion4TransaccionCliente(esInicial);
		this.setResaltarid_transaccion5TransaccionCliente(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.ID)) {
				this.setResaltaridTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION1)) {
				this.setResaltarid_transaccion1TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION2)) {
				this.setResaltarid_transaccion2TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION3)) {
				this.setResaltarid_transaccion3TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION4)) {
				this.setResaltarid_transaccion4TransaccionCliente(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransaccionClienteConstantesFunciones.IDTRANSACCION5)) {
				this.setResaltarid_transaccion5TransaccionCliente(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorNombreTransaccionCliente=true;

	public Boolean getMostrarBusquedaPorNombreTransaccionCliente() {
		return this.mostrarBusquedaPorNombreTransaccionCliente;
	}

	public void setMostrarBusquedaPorNombreTransaccionCliente(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreTransaccionCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTransaccionCliente=true;

	public Boolean getMostrarFK_IdEmpresaTransaccionCliente() {
		return this.mostrarFK_IdEmpresaTransaccionCliente;
	}

	public void setMostrarFK_IdEmpresaTransaccionCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTransaccionCliente= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTransaccionCliente=true;

	public Boolean getMostrarFK_IdModuloTransaccionCliente() {
		return this.mostrarFK_IdModuloTransaccionCliente;
	}

	public void setMostrarFK_IdModuloTransaccionCliente(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTransaccionCliente= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorNombreTransaccionCliente=true;

	public Boolean getActivarBusquedaPorNombreTransaccionCliente() {
		return this.activarBusquedaPorNombreTransaccionCliente;
	}

	public void setActivarBusquedaPorNombreTransaccionCliente(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreTransaccionCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTransaccionCliente=true;

	public Boolean getActivarFK_IdEmpresaTransaccionCliente() {
		return this.activarFK_IdEmpresaTransaccionCliente;
	}

	public void setActivarFK_IdEmpresaTransaccionCliente(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTransaccionCliente= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTransaccionCliente=true;

	public Boolean getActivarFK_IdModuloTransaccionCliente() {
		return this.activarFK_IdModuloTransaccionCliente;
	}

	public void setActivarFK_IdModuloTransaccionCliente(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTransaccionCliente= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorNombreTransaccionCliente=null;

	public Border getResaltarBusquedaPorNombreTransaccionCliente() {
		return this.resaltarBusquedaPorNombreTransaccionCliente;
	}

	public void setResaltarBusquedaPorNombreTransaccionCliente(Border borderResaltar) {
		this.resaltarBusquedaPorNombreTransaccionCliente= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreTransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreTransaccionCliente= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTransaccionCliente=null;

	public Border getResaltarFK_IdEmpresaTransaccionCliente() {
		return this.resaltarFK_IdEmpresaTransaccionCliente;
	}

	public void setResaltarFK_IdEmpresaTransaccionCliente(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTransaccionCliente= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTransaccionCliente= borderResaltar;
	}

	public Border resaltarFK_IdModuloTransaccionCliente=null;

	public Border getResaltarFK_IdModuloTransaccionCliente() {
		return this.resaltarFK_IdModuloTransaccionCliente;
	}

	public void setResaltarFK_IdModuloTransaccionCliente(Border borderResaltar) {
		this.resaltarFK_IdModuloTransaccionCliente= borderResaltar;
	}

	public void setResaltarFK_IdModuloTransaccionCliente(ParametroGeneralUsuario parametroGeneralUsuario/*TransaccionClienteBeanSwingJInternalFrame transaccionclienteBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTransaccionCliente= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}